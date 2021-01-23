package P_Method;

import javax.swing.JLabel;
import javax.swing.JSlider;

import P_Lrc.LrcArea;

public class BindMethod {
	public static JSlider JBar;
	public static JLabel LRCArr[];
	public static LrcArea lrcArea;
	public static JLabel CurrentTime,DurationTime;
	
	/*****
	 * 
	 * 界面VIEW控件全绑定
	 */
	public static void BindProgress(JSlider JBar,JLabel []LRC,JLabel CurrentTime,JLabel DurationTime) {
		BindMethod.JBar = JBar;
		BindMethod.LRCArr = LRC;
		BindMethod.CurrentTime = CurrentTime;
		BindMethod.DurationTime = DurationTime;
	}
	
	/*****
	 * 静态控件初始化函数
	 * 
	 */
	
	/***
	 * 初始化进度条
	 * @param max
	 */
	public static void initJBar(int max) {
		BindMethod.JBar.setMaximum(max);
	}

	/***
	 * 初始化歌词域
	 * @param lrcArea
	 */
	public static void initLRC(LrcArea lrcArea) {
		ClearLRC();
		BindMethod.lrcArea = lrcArea;
		lrcArea.ConnectJText(LRCArr);
		lrcArea.getLrc();
	}

	/***
	 * 初始化歌曲时长
	 * @param Time
	 */
	public static void initDuration(int Time) {
		DurationTime.setText(TimeConvString(Time));
	}
	
	/****
	 * 静态控件动态绑定函数
	 * 
	 */

	/***
	 * 动态改变进度条
	 * @param Byte
	 */
	public static void BindJBar(long Byte) {
		JBar.setValue((int) Byte);
	}

	/***
	 * 动态改变歌词域
	 * @param time
	 */
	public static void BindLRC(long time) {
		lrcArea.fitLRC(time);
	}

	/***
	 * 动态改变当前播放时间
	 * @param Time
	 */
	public static void BindTime(long Time) {
		int time = (int) (Time/1000000);
		CurrentTime.setText(TimeConvString(time));
	}
	
	/***
	 * 音乐播放结束判断
	 * @return bool
	 */
	public static boolean JudgeFinish() {
		try {
			if(StringConvTime()>(Integer.parseInt(DurationTime.getText())-2)) return true;
		else return false;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
	
	/****
	 * 方法内部处理函数
	 */
	
	/***
	 * 歌词域清空
	 */
	private static void ClearLRC() {
		for(int i=0;i<7;i++) {
			LRCArr[i].setText("");
		}
	}

	/***
	 * 时间格式转化
	 * @param time
	 * @return 00:00
	 */
	private static String TimeConvString(int time) {
		int minute = time/60;
		int second = time%60;
		StringBuffer sBuffer = new StringBuffer();
		if(minute<10) {
			sBuffer.append("0"+minute+":");
		}else {
			sBuffer.append(minute + ":");
		}
		if(second<10) {
			sBuffer.append("0"+second);
		}else {
			sBuffer.append(second);
		}
		return sBuffer.toString();
	}
	
	/***
	 * 字符串转化时间
	 * @return
	 */
	private static int StringConvTime() {
		String string = CurrentTime.getText();
		try {
			String[] time = string.split(":");
			int min = Integer.parseInt(time[0]);
			int sec = Integer.parseInt(time[1]);
			return (min * 60 + sec);
		}catch (Exception e) {
			System.out.println("字符串转时间失败");
			return 0;
		}
	}
}
