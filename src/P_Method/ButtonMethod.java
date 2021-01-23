package P_Method;

import java.io.File;

import javax.swing.JFrame;

import P_List.ListController;
import P_Music.MusicInf;

/*****
 * 该类主要完成对鼠标事件静态绑定。
 * 主要功能为今天添加歌曲以及删除歌曲功能。
 * @author JERRY
 *
 */
public class ButtonMethod {
	
	/***
	 * 静态添加歌曲
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
			System.out.println("资源管理器读取失败\nButtonMethod 1");
		}
	}
	
	/***
	 * 静态删除歌曲
	 * @param index
	 */
	public static void DEL(int index) {
		ListController listArray = new ListController();
		try {
			listArray.ArrayDel(index);
		} catch (Exception e) {
			System.out.println("文件删除失败\nButtonMethod 2");
		}
	}
}
