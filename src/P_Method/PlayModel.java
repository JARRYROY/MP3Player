package P_Method;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/******
 * 完成播放暂停界面图像的切换。
 * @author JERRY
 *
 */
public class PlayModel {
	public static JLabel L_play,L_control;
	public static ImageIcon play,playstop,btbar,btbarp;
	
	/***
	 * 绑定方法，完成界面静态元素的绑定
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
	 * 播放状态界面切换
	 */
	public static void PlayingModel() {
		L_play.setIcon(play);
		L_control.setIcon(btbar);
	}
	
	/***
	 * 暂停状态界面切换
	 */
	public static void PauseModel() {
		L_play.setIcon(playstop);
		L_control.setIcon(btbarp);
	}
}
