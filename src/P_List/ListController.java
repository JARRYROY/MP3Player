package P_List;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import P_Music.MusicInf;

/************
 * 实现简易列表的控制功能
 * @author JERRY
 *
 */
public class ListController {
	List_IO I_O = new List_IO();						//创建IO实现于Text文件对接。
	ArrayList<MusicInf>arrayList = new ArrayList<>();	//音乐类操作数组。
	JList<String>jList = new JList<>();					//绑定界面列表。
	
	/**********
	 * 初始化获取列表。
	 */
	public ListController() {
		arrayList = I_O.getList();
	}
	
	/**********
	 * 音乐项添加功能
	 * @param musicInf
	 */
	public void ArrayAdd(MusicInf musicInf) {
		arrayList.add(musicInf);
		I_O.setList(arrayList);
		ListShow();
	}
	
	/**********
	 * 音乐项删除功能
	 * @param index
	 */
	public void ArrayDel(int index) {
		arrayList = I_O.getList();
		arrayList.remove(index);
		I_O.setList(arrayList);
		ListShow();
	}
	
	/********
	 * 列表显示函数
	 */
	public void ListShow() {
		arrayList = I_O.getList();
		DefaultListModel<String> LM = new DefaultListModel<>();
		
		for(int i=0;i<arrayList.size();i++) {
			LM.addElement((i+1) + " .  " + arrayList.get(i).getName().split(".mp3")[0]);
		}
		jList.setModel(LM);
	}
	
	/***
	 * 列表控制器绑定界面列表
	 * @param allList
	 */
	public void setJlist(JList<String> allList) {
		jList = allList;
	}
}
