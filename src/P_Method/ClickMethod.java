package P_Method;

import P_List.List_IO;
import P_Music.MusicInf;
import P_Player.PlayerController;

/*****
 * ����¼�ͳһ����
 * @author JERRY
 *
 */
public class ClickMethod {
	
	/**
	 * �����¼�
	 * @param playerController
	 * @param index
	 */
	public static void Click(PlayerController playerController,int index) {
		MusicInf musicInf = (new List_IO()).getList().get(index);
		BindMethod.initJBar(musicInf.getSize());  
		BindMethod.initDuration(musicInf.getLength());
		playerController.StopMusic();
		playerController.PlayMusic(musicInf.getPath());
	}
}
