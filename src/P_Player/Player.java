package P_Player;

import java.io.File;
import java.util.Map;

import P_Lrc.LrcArea;
import P_Method.BindMethod;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

/*****
 * 主播放器对象，实现参数传递和状态更新
 * @author JERRY
 *
 */
public class Player implements BasicPlayerListener{
	
    //建立各种播放器组件
	BasicPlayer player;				//调用库建立播放器线程
	BasicController controller;		//调用库建立控制器
	String path;					//歌曲路径
	int state;						//歌曲状态
	LrcArea lrcArea;				//歌词域
	
	/*****
	 * 状态常量
	 */
	public static final int UNKNOWN = -1;
    public static final int PLAYING = 0;
    public static final int PAUSED = 1;
    public static final int STOPPED = 2;
    public static final int OPENED = 3;
    public static final int SEEKING = 4;
	
    /***
     * 初始化播放器
     * @param path
     */
	public Player(String path) {
		this.path = path;
		player = new BasicPlayer();
		controller = (BasicController)player;
		player.addBasicPlayerListener(this);
		lrcArea = new LrcArea(path);
		BindMethod.initLRC(lrcArea);
		
	}
	
	/***
	 * 播放开始
	 * @return 播放成功=true
	 */
	public boolean Play() {
		try {
			controller.open(new File(path));
			controller.play();
			state = PLAYING;
			controller.setGain(0.85);
			controller.setPan(0.0);
			return true;
		} catch (BasicPlayerException e) {
			System.out.println("歌曲读入播放失败\nPlayer 1");
			return false;
		}
	}
	
	/***
	 * 播放停止
	 * @return 停止成功=true
	 */
	public boolean stop() {
		if(state == STOPPED) {
			return true;
		}
		try {
			player.stop();
			state = STOPPED;
			return true;
		} catch (Exception e) {
			System.out.println("歌曲停止失败\nPlayer 2");
			return false;
		}
	}
	
	/***
	 * 播放暂停
	 * @return 暂停成功=true
	 */
	public boolean pause() {
		if(state == PLAYING) {
			try {
				player.pause();
				state = PAUSED;
				return true;
			} catch (BasicPlayerException e) {
				System.out.println("歌曲暂停失败\nPlayer 3");
				return false;
			}
		}
		return false;
	}
	
	/***
	 * 播放继续
	 * @return 继续成功=true
	 */
	public boolean resume() {
		if(state == PAUSED) {
			try {
				player.resume();
				state = PLAYING;
				return true;
			} catch (Exception e) {
				System.out.println("歌曲恢复失败\nPlayer 4");
				return false;
			}
		}
		return false;
	}
	
	/***
	 * 播放跳转至输出比特
	 * @param bytes
	 * @return 跳转成功=true
	 */
	public boolean seek(long bytes) {
		try {
			player.seek(bytes);
			return true;
		} catch (BasicPlayerException e) {
			System.out.println("歌曲拖拽失败\nPlayer 6");
			return false;
		}
	}
	
	/***
	 * 获取播放状态
	 * @return int 状态
	 */
	public int getStatus() {
		return player.getStatus();
	}
	@Override
	public void opened(Object stream, Map properties) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/***
	 * 线程接口函数。
	 * 完成实时歌曲信息返回操作。
	 * 返回频率100ms。
	 */
	public void progress(int bytesread, long microseconds, byte[] pcmdata, Map properties) {
		String[] string = properties.toString().split(",");
    	String[] string1 = string[3].split("=");
    	String[] string2 = string[2].split("=");
    	long CurrentByte = Long.parseLong(string1[1]);
    	long CurrentTime = Long.parseLong(string2[1]);
    	BindMethod.BindJBar(CurrentByte);
    	BindMethod.BindLRC(CurrentTime);    	
    	BindMethod.BindTime(CurrentTime);
	}

	@Override
	public void stateUpdated(BasicPlayerEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setController(BasicController controller) {
		// TODO Auto-generated method stub
		
	}
}
