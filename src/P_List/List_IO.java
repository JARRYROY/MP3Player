package P_List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

import P_Music.MusicInf;

/******************
 * ������Ҫʵ�ִ�text�ļ����б���뵽������ʱ�����С�
 * ͨ������Get,Set������ȡ����͸����б�
 * @author JERRY
 * 
 */
public class List_IO {
	
	
	ArrayList<MusicInf>arrayList = new ArrayList<>();	//��ʱ������
	File list = new File("list/list.txt");				//�б��ļ�
	private BufferedReader bin;							//������
	private BufferedWriter bout;						//�����
	
	/************
	 * ��ɶ����ļ����������������顣
	 * @return MusicInf[]
	 */
	public ArrayList<MusicInf> getList(){
		arrayList = new ArrayList<>();
		if(!list.exists()) {
			return arrayList;
		}
		try {
			Reader in = new FileReader(list);
			bin = new BufferedReader(in);
			while(true) {
				String st = bin.readLine();
				if(st == null) {
					break;
				}
				String string[] = st.split("@#@"); 
				MusicInf musicInf = new MusicInf(string[0],string[1],Integer.parseInt(string[2]),Integer.parseInt(string[3]));
				arrayList.add(musicInf);
			}
			bin.close();
		} catch (FileNotFoundException e) {
			System.out.println("list�ļ���ȡʧ��\nList_IO 1");
		} catch (IOException e) {
			System.out.println("����������ʧ��\nList_IO 2");
		}
		return arrayList;
	}
	
	/*********
	 * ��������������벢д��text�ļ��С�
	 * @param arrayList
	 */
	public void setList(ArrayList<MusicInf> arrayList) {
		if(list.exists()) {
			list.delete();
		}
		try {
			list.createNewFile();
		} catch (IOException e) {
			System.out.println("list����ʧ��\nList_IO 3");
		}
		try {
			Writer out = new FileWriter(list);
			bout = new BufferedWriter(out);
			for(int i=0;i<arrayList.size();i++) {
				bout.write(arrayList.get(i).toString());
				bout.newLine();
				bout.flush();
			}
			bout.close();
		} catch (IOException e) {
			System.out.println("����������ʧ��\nList_IO 4");
		}
	}

}
