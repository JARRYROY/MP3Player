package P_Lrc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;

/***********
 * 该类为对音乐歌词文件的处理。
 * 利用时间，歌词双数组完成歌词输出。
 * @author Administrator
 *
 */
public class LrcArea {
	Pattern pattern = Pattern.compile("\\[(\\d{1,2}):(\\d{1,2}).(\\d{1,2})\\]");	//解析歌词正则表达式
	long Time[];					//时间数组
	String Text[];					//歌词数组
	int index=0;					//标记
	JLabel Line[];					//歌词域
	boolean Loadready = true;		
	File file;
	
	/*******
	 * 初始化数组。
	 * @param path
	 */
	public LrcArea(String path) {
		Time = new long[100];
		Text = new String[100];
		file = new File(path.split(".mp3")[0]+".lrc");
	}
	
	/********
	 * 解析Lrc文件存入数组中。
	 */
	public void getLrc() {
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					fis));
			String lrcString = null;
			while ((lrcString = reader.readLine()) != null) {
				parseLine(lrcString);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Get NULL");
			Loadready = false;
			Line[2].setText("无~~歌~~词");
		}
	}
	
	/*********
	 * 对应时间单位微秒输出歌词。
	 * @param microseconds
	 */
	public void fitLRC(long microseconds) {
		if (Loadready) {
			long formats = microseconds / 1000;
			int local = 0;
			for (int i = 0; i < index - 1; i++) {
				if (formats > Time[i] && formats < Time[i + 1]) {
					local = i;
					break;
				}
			}
			if (local - 1 > 0) {
				Line[0].setText(Text[local - 2]);
			}
			if (local > 0) {
				Line[1].setText(Text[local - 1]);
			}

			Line[2].setText(Text[local]);
			for (int i = 2; i < 6; i++) {
				show(local, i);
			}
		}
	}
	
	/*******
	 * 歌词显示函数。
	 * @param l
	 * @param i
	 */
	public void show(int l,int i) {
		if(l<(index - i)) {
			Line[i+1].setText(Text[l+i-1]);
		}else {
			Line[i+1].setText("");
		}
	}
		
	/*********
	 * 正则表达式解析行歌词函数。
	 * @param lrcString
	 */
	public void parseLine(String lrcString) {
		Matcher matcher = pattern.matcher(lrcString);
		while (matcher.find()) {
			long x = strToLong(matcher.group(1),matcher.group(2),matcher.group(3));
			Time[index] = x;
			Text[index] = lrcString.substring(matcher.end());
			index++;
		}
	}
	
	/********
	 * 转化为分秒毫秒格式。
	 * @param m
	 * @param s
	 * @param ms
	 * @return
	 */
	public long strToLong(String m,String s,String ms) {
		int min = Integer.parseInt(m);
		int sec = Integer.parseInt(s);
		int mill = Integer.parseInt(ms);
		return min * 60 * 1000 + sec * 1000 + mill * 10;
	}
	
	public void ConnectJText(JLabel area[]) {
		Line = area;
	}

}
