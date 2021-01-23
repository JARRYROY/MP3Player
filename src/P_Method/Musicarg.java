package P_Method;

import java.io.File;
import java.io.FileInputStream;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

/****
 * ��ɶ�������Ϣ�ļ���Ͳ�ȫ��
 * @author JERRY
 *
 */
public class Musicarg {
	String path;
	
	/***
	 * ��ȡ�����ļ�
	 * @param path
	 */
	public Musicarg(String path) {
		this.path = path;
	}
	
	/***
	 * ��ȡ������ʱ��
	 * @return ��ʱ��
	 */
	public int GetDuration() {
		int total = 0;
		try {
			MP3File mp3File = (MP3File)AudioFileIO.read(new File(path));
			MP3AudioHeader audioHeader = (MP3AudioHeader)mp3File.getAudioHeader();
			total = audioHeader.getTrackLength();   //����Ϊ��λ
		} catch (Exception e) {
			System.out.println("����ʱ����ȡʧ��\nMusicLength 1");
		}
		return total;
	}
	
	/***
	 * ��ȡ�����ļ��ܱ��ش�С
	 * @return long ������
	 */
	public int GetSize() {
		File file = new File(path);
		int MusicSize = 0;
		try {
			FileInputStream fin = new FileInputStream(file);
			MusicSize = fin.available();
			fin.close();
			
		} catch (Exception e1) {
			System.out.println("������С��ȡʧ��\nMusicLength 2");
		}
		return MusicSize;
	}
}
