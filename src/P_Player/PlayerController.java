package P_Player;

import P_Method.PlayModel;

/******
 * 音乐播放控制器
 * @author Administrator
 *
 */
public class PlayerController {
	Player player;	//主播放器创建
	String path;	//音乐路径获取
	
	/***
	 * 控制器播放音乐，切换播放状态
	 * @param path
	 */
	public void PlayMusic(String path) {
		this.path = path;
		player = new Player(path);
		PlayModel.PlayingModel();
		player.Play();	
	}
	
	/***
	 * 控制器停止音乐播放，切换停止状态
	 */
	public void StopMusic() {
		try {
			PlayModel.PauseModel();
			player.stop();
		} catch (Exception e) {}
	}
	
	/***
	 * 控制器暂停音乐播放，切换停止状态
	 */
	public void Pause() {
		try {
			PlayModel.PauseModel();
			player.pause();
		} catch (Exception e) {}
	}
	
	/***
	 * 控制器恢复音乐播放，切换播放状态
	 */
	public void Resume() {
		try {
			PlayModel.PlayingModel();
			player.resume();
		} catch (Exception e) {}
	}
	
	/***
	 * 控制器完成点击自动切换 播放/暂停状态
	 */
	public void PS_RS() {
		if(player.pause()) {
			PlayModel.PauseModel();
		}else{
			PlayModel.PlayingModel();
			player.resume();
		}
	}
	
	/***
	 * 控制器完成音乐比特跳转
	 * @param bytes
	 */
	public void seek(long bytes) {
		try {
			player.seek(bytes);
		} catch (Exception e) {}
	}
}
