package Start;

import java.awt.EventQueue;

import P_View.Main_View;
/*****
 * Æô¶¯º¯Êý
 * @author JERRY
 *
 */
public class Start {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_View frame = new Main_View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
