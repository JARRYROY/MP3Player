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
 * 该类主要实现从text文件将列表读入到类中临时数组中。
 * 通过调用Get,Set函数获取数组和更新列表。
 * @author JERRY
 * 
 */
public class List_IO {
	
	
	ArrayList<MusicInf>arrayList = new ArrayList<>();	//临时类数组
	File list = new File("list/list.txt");				//列表文件
	private BufferedReader bin;							//读入流
	private BufferedWriter bout;						//输出流
	
	/************
	 * 完成读入文件并返回音乐类数组。
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
			System.out.println("list文件读取失败\nList_IO 1");
		} catch (IOException e) {
			System.out.println("缓冲流操作失败\nList_IO 2");
		}
		return arrayList;
	}
	
	/*********
	 * 从音乐类数组读入并写回text文件中。
	 * @param arrayList
	 */
	public void setList(ArrayList<MusicInf> arrayList) {
		if(list.exists()) {
			list.delete();
		}
		try {
			list.createNewFile();
		} catch (IOException e) {
			System.out.println("list表创建失败\nList_IO 3");
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
			System.out.println("缓冲流操作失败\nList_IO 4");
		}
	}

}
