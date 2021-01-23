package P_Method;

import static javax.swing.JFileChooser.APPROVE_OPTION;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

/*****
 * 本类为调用JChooser功能完成选中歌曲信息的添加。
 * @author others
 *
 */
public class FileInput {
	private JFileChooser FD = null;
	private File f[];
	private String name[];
	private JFrame JF;
	public FileInput(JFrame JF) {
		this.JF = JF;
		FD = new JFileChooser("E:\\MUSIC");
		FD.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return ".mp3";
			}
			
			@Override
			public boolean accept(File f) {
				if(f.isDirectory()) return true;
				return f.getName().endsWith(".mp3");
			}
		});
		FD.setAcceptAllFileFilterUsed(false);
		FD.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FD.setMultiSelectionEnabled(true);
	}
	public void open() {
		f=null;
		int result = FD.showOpenDialog(JF);
		if (result == APPROVE_OPTION) {
			f = FD.getSelectedFiles();
		}
	}
	public String[] getFileNames() {
		name = null;
		if(f!=null) {
			name = new String[f.length];
			for(int i=0;i<f.length;i++) {
				name[i] = f[i].getPath();
			}
		}
		return name;
	}
	public File[] getFiles() {
		return f;
	}
}
