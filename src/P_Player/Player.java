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
 * ������������ʵ�ֲ������ݺ�״̬����
 * @author JERRY
 *
 */
public class Player implements BasicPlayerListener{
	
    //�������ֲ��������
	BasicPlayer player;				//���ÿ⽨���������߳�
	BasicController controller;		//���ÿ⽨��������
	String path;					//����·��
	int state;						//����״̬
	LrcArea lrcArea;				//�����
	
	/*****
	 * ״̬����
	 */
	public static final int UNKNOWN = -1;
    public static final int PLAYING = 0;
    public static final int PAUSED = 1;
    public static final int STOPPED = 2;
    public static final int OPENED = 3;
    public static final int SEEKING = 4;
	
    /***
     * ��ʼ��������
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
	 * ���ſ�ʼ
	 * @return ���ųɹ�=true
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
			System.out.println("�������벥��ʧ��\nPlayer 1");
			return false;
		}
	}
	
	/***
	 * ����ֹͣ
	 * @return ֹͣ�ɹ�=true
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
			System.out.println("����ֹͣʧ��\nPlayer 2");
			return false;
		}
	}
	
	/***
	 * ������ͣ
	 * @return ��ͣ�ɹ�=true
	 */
	public boolean pause() {
		if(state == PLAYING) {
			try {
				player.pause();
				state = PAUSED;
				return true;
			} catch (BasicPlayerException e) {
				System.out.println("������ͣʧ��\nPlayer 3");
				return false;
			}
		}
		return false;
	}
	
	/***
	 * ���ż���
	 * @return �����ɹ�=true
	 */
	public boolean resume() {
		if(state == PAUSED) {
			try {
				player.resume();
				state = PLAYING;
				return true;
			} catch (Exception e) {
				System.out.println("�����ָ�ʧ��\nPlayer 4");
				return false;
			}
		}
		return false;
	}
	
	/***
	 * ������ת���������
	 * @param bytes
	 * @return ��ת�ɹ�=true
	 */
	public boolean seek(long bytes) {
		try {
			player.seek(bytes);
			return true;
		} catch (BasicPlayerException e) {
			System.out.println("������קʧ��\nPlayer 6");
			return false;
		}
	}
	
	/***
	 * ��ȡ����״̬
	 * @return int ״̬
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
	 * �߳̽ӿں�����
	 * ���ʵʱ������Ϣ���ز�����
	 * ����Ƶ��100ms��
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
