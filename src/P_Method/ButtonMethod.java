package P_Method;

import java.io.File;

import javax.swing.JFrame;

import P_List.ListController;
import P_Music.MusicInf;

/*****
 * ������Ҫ��ɶ�����¼���̬�󶨡�
 * ��Ҫ����Ϊ������Ӹ����Լ�ɾ���������ܡ�
 * @author JERRY
 *
 */
public class ButtonMethod {
	
	/***
	 * ��̬��Ӹ���
	 */
	public static void ADD() {
		ListController controller = new ListController();
		FileInput fileInput = new FileInput(new JFrame());
		fileInput.open();
		try {
			File[] files = fileInput.getFiles();
		if(files!=null) {
			for(int i=0;i<files.length;i++) {
				MusicInf musicInf = new MusicInf();
				musicInf.setName(files[i].getName());
				musicInf.setPath(files[i].getPath());
				Musicarg arg = new Musicarg(files[i].getPath());
				musicInf.setLength(arg.GetDuration());
				musicInf.setSize(arg.GetSize());
				controller.ArrayAdd(musicInf);
			}
		}
		} catch (Exception e) {
			System.out.println("��Դ��������ȡʧ��\nButtonMethod 1");
		}
	}
	
	/***
	 * ��̬ɾ������
	 * @param index
	 */
	public static void DEL(int index) {
		ListController listArray = new ListController();
		try {
			listArray.ArrayDel(index);
		} catch (Exception e) {
			System.out.println("�ļ�ɾ��ʧ��\nButtonMethod 2");
		}
	}
}
