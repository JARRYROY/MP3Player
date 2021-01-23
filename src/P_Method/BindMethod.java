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
	 * ����VIEW�ؼ�ȫ��
	 */
	public static void BindProgress(JSlider JBar,JLabel []LRC,JLabel CurrentTime,JLabel DurationTime) {
		BindMethod.JBar = JBar;
		BindMethod.LRCArr = LRC;
		BindMethod.CurrentTime = CurrentTime;
		BindMethod.DurationTime = DurationTime;
	}
	
	/*****
	 * ��̬�ؼ���ʼ������
	 * 
	 */
	
	/***
	 * ��ʼ��������
	 * @param max
	 */
	public static void initJBar(int max) {
		BindMethod.JBar.setMaximum(max);
	}

	/***
	 * ��ʼ�������
	 * @param lrcArea
	 */
	public static void initLRC(LrcArea lrcArea) {
		ClearLRC();
		BindMethod.lrcArea = lrcArea;
		lrcArea.ConnectJText(LRCArr);
		lrcArea.getLrc();
	}

	/***
	 * ��ʼ������ʱ��
	 * @param Time
	 */
	public static void initDuration(int Time) {
		DurationTime.setText(TimeConvString(Time));
	}
	
	/****
	 * ��̬�ؼ���̬�󶨺���
	 * 
	 */

	/***
	 * ��̬�ı������
	 * @param Byte
	 */
	public static void BindJBar(long Byte) {
		JBar.setValue((int) Byte);
	}

	/***
	 * ��̬�ı�����
	 * @param time
	 */
	public static void BindLRC(long time) {
		lrcArea.fitLRC(time);
	}

	/***
	 * ��̬�ı䵱ǰ����ʱ��
	 * @param Time
	 */
	public static void BindTime(long Time) {
		int time = (int) (Time/1000000);
		CurrentTime.setText(TimeConvString(time));
	}
	
	/***
	 * ���ֲ��Ž����ж�
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
	 * �����ڲ�������
	 */
	
	/***
	 * ��������
	 */
	private static void ClearLRC() {
		for(int i=0;i<7;i++) {
			LRCArr[i].setText("");
		}
	}

	/***
	 * ʱ���ʽת��
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
	 * �ַ���ת��ʱ��
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
			System.out.println("�ַ���תʱ��ʧ��");
			return 0;
		}
	}
}
