package P_Method;

import java.io.File;
import java.io.FileInputStream;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

/****
 * 完成对音乐信息的计算和补全。
 * @author JERRY
 *
 */
public class Musicarg {
	String path;
	
	/***
	 * 获取音乐文件
	 * @param path
	 */
	public Musicarg(String path) {
		this.path = path;
	}
	
	/***
	 * 获取音乐总时长
	 * @return 总时长
	 */
	public int GetDuration() {
		int total = 0;
		try {
			MP3File mp3File = (MP3File)AudioFileIO.read(new File(path));
			MP3AudioHeader audioHeader = (MP3AudioHeader)mp3File.getAudioHeader();
			total = audioHeader.getTrackLength();   //以秒为单位
		} catch (Exception e) {
			System.out.println("歌曲时长获取失败\nMusicLength 1");
		}
		return total;
	}
	
	/***
	 * 获取音乐文件总比特大小
	 * @return long 比特数
	 */
	public int GetSize() {
		File file = new File(path);
		int MusicSize = 0;
		try {
			FileInputStream fin = new FileInputStream(file);
			MusicSize = fin.available();
			fin.close();
			
		} catch (Exception e1) {
			System.out.println("歌曲大小获取失败\nMusicLength 2");
		}
		return MusicSize;
	}
}
