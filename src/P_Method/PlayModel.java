package P_Method;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/******
 * ��ɲ�����ͣ����ͼ����л���
 * @author JERRY
 *
 */
public class PlayModel {
	public static JLabel L_play,L_control;
	public static ImageIcon play,playstop,btbar,btbarp;
	
	/***
	 * �󶨷�������ɽ��澲̬Ԫ�صİ�
	 * @param L_play
	 * @param L_control
	 * @param play
	 * @param playstop
	 * @param btbar
	 * @param btbarp
	 */
	public static void BindModel(JLabel L_play,JLabel L_control,ImageIcon play,ImageIcon playstop,ImageIcon btbar, ImageIcon btbarp) {
		PlayModel.L_play = L_play;
		PlayModel.L_control = L_control;
		PlayModel.play = play;
		PlayModel.playstop = playstop;
		PlayModel.btbar = btbar;
		PlayModel.btbarp = btbarp;
	}
	
	/***
	 * ����״̬�����л�
	 */
	public static void PlayingModel() {
		L_play.setIcon(play);
		L_control.setIcon(btbar);
	}
	
	/***
	 * ��ͣ״̬�����л�
	 */
	public static void PauseModel() {
		L_play.setIcon(playstop);
		L_control.setIcon(btbarp);
	}
}
