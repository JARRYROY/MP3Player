package P_List;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import P_Music.MusicInf;

/************
 * ʵ�ּ����б�Ŀ��ƹ���
 * @author JERRY
 *
 */
public class ListController {
	List_IO I_O = new List_IO();						//����IOʵ����Text�ļ��Խӡ�
	ArrayList<MusicInf>arrayList = new ArrayList<>();	//������������顣
	JList<String>jList = new JList<>();					//�󶨽����б�
	
	/**********
	 * ��ʼ����ȡ�б�
	 */
	public ListController() {
		arrayList = I_O.getList();
	}
	
	/**********
	 * ��������ӹ���
	 * @param musicInf
	 */
	public void ArrayAdd(MusicInf musicInf) {
		arrayList.add(musicInf);
		I_O.setList(arrayList);
		ListShow();
	}
	
	/**********
	 * ������ɾ������
	 * @param index
	 */
	public void ArrayDel(int index) {
		arrayList = I_O.getList();
		arrayList.remove(index);
		I_O.setList(arrayList);
		ListShow();
	}
	
	/********
	 * �б���ʾ����
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
	 * �б�������󶨽����б�
	 * @param allList
	 */
	public void setJlist(JList<String> allList) {
		jList = allList;
	}
}
