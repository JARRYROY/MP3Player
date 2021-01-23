package P_Player;

import P_Method.PlayModel;

/******
 * ���ֲ��ſ�����
 * @author Administrator
 *
 */
public class PlayerController {
	Player player;	//������������
	String path;	//����·����ȡ
	
	/***
	 * �������������֣��л�����״̬
	 * @param path
	 */
	public void PlayMusic(String path) {
		this.path = path;
		player = new Player(path);
		PlayModel.PlayingModel();
		player.Play();	
	}
	
	/***
	 * ������ֹͣ���ֲ��ţ��л�ֹͣ״̬
	 */
	public void StopMusic() {
		try {
			PlayModel.PauseModel();
			player.stop();
		} catch (Exception e) {}
	}
	
	/***
	 * ��������ͣ���ֲ��ţ��л�ֹͣ״̬
	 */
	public void Pause() {
		try {
			PlayModel.PauseModel();
			player.pause();
		} catch (Exception e) {}
	}
	
	/***
	 * �������ָ����ֲ��ţ��л�����״̬
	 */
	public void Resume() {
		try {
			PlayModel.PlayingModel();
			player.resume();
		} catch (Exception e) {}
	}
	
	/***
	 * ��������ɵ���Զ��л� ����/��ͣ״̬
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
	 * ������������ֱ�����ת
	 * @param bytes
	 */
	public void seek(long bytes) {
		try {
			player.seek(bytes);
		} catch (Exception e) {}
	}
}
