package P_View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import P_List.ListController;
import P_Method.BindMethod;
import P_Method.ButtonMethod;
import P_Method.ClickMethod;
import P_Method.PlayModel;
import P_Player.PlayerController;


public class Main_View extends JFrame {

	/**
	 * ȫ�����Ժ�ֵ�趨
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int selectindex=0;
	
	/**
	 * ���������庯��
	 */
	public Main_View() {
		
		/***
		 * �����������
		 */
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1010, 572);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/************************
		 * 
		 * 
		 * IMGͼƬ��ӱ���
		 * 
		 * 
		 *************************/

		ImageIcon logo = new ImageIcon("img/logo.jpg");
		ImageIcon bg = new ImageIcon("img/topbg.png");
		ImageIcon icon_add = new ImageIcon("img/add.png");
		ImageIcon icon_del = new ImageIcon("img/del.png");
		ImageIcon btbar = new ImageIcon("img/btbar.png");
		ImageIcon rightbg = new ImageIcon("img/rightbg.gif");
		ImageIcon play = new ImageIcon("img/play.gif");
		ImageIcon playstop = new ImageIcon("img/playstop.png");
		ImageIcon btbarp = new ImageIcon("img/btbarp.png");

		/*********************************
		 * 
		 * 
		 * ��������ͽ�������
		 * 
		 * 
		 *******************************/

		icon_del.setImage(icon_del.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		JButton bt_del = new JButton("ɾ ��", icon_del);
		bt_del.setBounds(548, 29, 111, 58);
		contentPane.add(bt_del);

		JLabel L_Text = new JLabel("MUSIC BOX");
		L_Text.setForeground(new Color(248, 248, 255));
		L_Text.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 22));
		L_Text.setBounds(191, 0, 168, 123);
		contentPane.add(L_Text);

		logo.setImage(logo.getImage().getScaledInstance(158, 123, Image.SCALE_DEFAULT));
		JLabel L_logo = new JLabel();
		L_logo.setIcon(logo);
		L_logo.setBounds(0, 0, 158, 123);
		getContentPane().add(L_logo);

		rightbg.setImage(rightbg.getImage().getScaledInstance(147, 123, Image.SCALE_DEFAULT));
		JLabel L_Right = new JLabel("");
		L_Right.setIcon(rightbg);
		L_Right.setBounds(855, 0, 147, 123);
		contentPane.add(L_Right);

		JPanel P_list = new JPanel();
		P_list.setBackground(Color.DARK_GRAY);
		P_list.setBounds(0, 126, 349, 416);
		contentPane.add(P_list);
		P_list.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		P_list.add(scrollPane);
		
		JList<String> allList = new JList<>();
		allList.setForeground(new Color(255, 255, 255));
		allList.setBackground(new Color(51, 51, 51));
		scrollPane.setViewportView(allList);

		JPanel P_body = new JPanel();
		P_body.setBackground(new Color(51, 51, 51));
		P_body.setBounds(359, 126, 643, 416);
		contentPane.add(P_body);
		P_body.setLayout(null);

		JPanel P_pic = new JPanel();
		P_pic.setBackground(Color.GRAY);
		
		P_pic.setBounds(10, 10, 342, 297);
		P_body.add(P_pic);
		P_pic.setLayout(null);
		
		play.setImage(play.getImage().getScaledInstance(322, 277, Image.SCALE_DEFAULT));
		playstop.setImage(playstop.getImage().getScaledInstance(322, 277, Image.SCALE_DEFAULT));
		JLabel L_play = new JLabel("");
		L_play.setIcon(playstop);
		L_play.setBounds(10, 10, 322, 277);
		P_pic.add(L_play);

		JPanel P_lrc = new JPanel();
		P_lrc.setBackground(new Color(102, 102, 102));
		P_lrc.setBounds(362, 10, 271, 297);
		P_body.add(P_lrc);
		P_lrc.setLayout(null);
		
		JLabel L_t0 = new JLabel("");
		L_t0.setHorizontalAlignment(SwingConstants.CENTER);
		L_t0.setForeground(SystemColor.scrollbar);
		L_t0.setFont(new Font("������κ", Font.BOLD, 14));
		L_t0.setBounds(10, 10, 251, 30);
		P_lrc.add(L_t0);
		
		JLabel L_t1 = new JLabel("");
		L_t1.setHorizontalAlignment(SwingConstants.CENTER);
		L_t1.setForeground(SystemColor.scrollbar);
		L_t1.setFont(new Font("������κ", Font.BOLD, 14));
		L_t1.setBounds(10, 50, 251, 30);
		P_lrc.add(L_t1);
		
		JLabel L_t2 = new JLabel("");
		L_t2.setHorizontalAlignment(SwingConstants.CENTER);
		L_t2.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		L_t2.setFont(new Font("������κ", Font.BOLD, 16));
		L_t2.setBounds(10, 90, 251, 30);
		P_lrc.add(L_t2);
		
		JLabel L_t3 = new JLabel("");
		L_t3.setHorizontalAlignment(SwingConstants.CENTER);
		L_t3.setForeground(SystemColor.scrollbar);
		L_t3.setFont(new Font("������κ", Font.BOLD, 14));
		L_t3.setBounds(10, 130, 251, 30);
		P_lrc.add(L_t3);
		
		JLabel L_t4 = new JLabel("");
		L_t4.setHorizontalAlignment(SwingConstants.CENTER);
		L_t4.setForeground(SystemColor.scrollbar);
		L_t4.setFont(new Font("������κ", Font.BOLD, 14));
		L_t4.setBounds(10, 170, 251, 30);
		P_lrc.add(L_t4);
		
		JLabel L_t5 = new JLabel("");
		L_t5.setHorizontalAlignment(SwingConstants.CENTER);
		L_t5.setForeground(SystemColor.scrollbar);
		L_t5.setFont(new Font("������κ", Font.BOLD, 14));
		L_t5.setBounds(10, 210, 251, 30);
		P_lrc.add(L_t5);
		
		JLabel L_t6 = new JLabel("");
		L_t6.setHorizontalAlignment(SwingConstants.CENTER);
		L_t6.setForeground(SystemColor.scrollbar);
		L_t6.setFont(new Font("������κ", Font.BOLD, 14));
		L_t6.setBounds(10, 250, 251, 30);
		P_lrc.add(L_t6);
		JLabel LrcArr[] = {L_t0,L_t1,L_t2,L_t3,L_t4,L_t5,L_t6};
		
		JPanel P_control = new JPanel();
		P_control.setBackground(new Color(51, 51, 51));
		P_control.setBounds(10, 317, 623, 89);
		P_body.add(P_control);
		P_control.setLayout(null);
		
		btbar.setImage(btbar.getImage().getScaledInstance(169, 69, Image.SCALE_DEFAULT));
		btbarp.setImage(btbarp.getImage().getScaledInstance(169, 69, Image.SCALE_DEFAULT));
		JLabel L_btControl = new JLabel("");
		L_btControl.setIcon(btbar);
		L_btControl.setBounds(0, 10, 169, 69);
		P_control.add(L_btControl);
		
		JButton bt_before = new JButton("");
		bt_before.setBounds(0, 17, 49, 55);
		bt_before.setContentAreaFilled(false);
		P_control.add(bt_before);
		
		JButton bt_pauseAndresume = new JButton("");
		bt_pauseAndresume.setBounds(59, 17, 49, 55);
		bt_pauseAndresume.setContentAreaFilled(false);
		P_control.add(bt_pauseAndresume);
		
		JButton bt_next = new JButton("");
		bt_next.setBounds(118, 17, 49, 55);
		bt_next.setContentAreaFilled(false);
		P_control.add(bt_next);
		
		JSlider PlayBar = new JSlider();
		PlayBar.setBackground(new Color(51, 51, 51));
		PlayBar.setForeground(UIManager.getColor("textInactiveText"));
		PlayBar.setBounds(211, 34, 365, 26);
		P_control.add(PlayBar);

		bg.setImage(bg.getImage().getScaledInstance(699, 123, Image.SCALE_DEFAULT));
		JLabel L_TBar = new JLabel();
		L_TBar.setBounds(158, 0, 699, 123);
		L_TBar.setIcon(bg);
		contentPane.add(L_TBar);

		icon_add.setImage(icon_add.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		JButton bt_add = new JButton("�� ��", icon_add);
		bt_add.setBounds(382, 29, 111, 58);
		contentPane.add(bt_add);
		
		JLabel L_currentTime = new JLabel("00:00");
		L_currentTime.setForeground(Color.WHITE);
		L_currentTime.setBounds(179, 34, 42, 26);
		P_control.add(L_currentTime);
		
		JLabel L_Duration = new JLabel("00:00");
		L_Duration.setForeground(Color.WHITE);
		L_Duration.setBounds(581, 34, 42, 26);
		P_control.add(L_Duration);
		
		/********************
		 * 
		 * ��̬�󶨷���
		 * 
		 ******************/
		PlayModel.BindModel(L_play, L_btControl, play, playstop, btbar, btbarp);
		BindMethod.BindProgress(PlayBar, LrcArr, L_currentTime, L_Duration);
		
		/****************************
		 * 
		 * �б���ذ�ť�Լ��¼�����
		 * 
		 ***************************/
		//�����б������
		//�������󶨽����б�
		//��ʼ���б�
		ListController listController = new ListController();
		listController.setJlist(allList);
		listController.ListShow();
		
		//��Ӱ�ťʵ��
		bt_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ButtonMethod.ADD();				//��̬�б����
				listController.ListShow();		
			}
		});

		//ɾ����ťʵ��
		bt_del.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = allList.getSelectedIndex();
				ButtonMethod.DEL(index);		//��̬�б�ɾ��
				listController.ListShow();
			}
		});
		
		//�������ֲ���������
		PlayerController playerController = new PlayerController();
		
		//�б����¼�
		allList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(allList.getSelectedIndex()!=-1) {
					if(e.getClickCount()==2) {
						selectindex = allList.getSelectedIndex();
						ClickMethod.Click(playerController,selectindex);	//��̬����¼�
					}
				}
			}
		});
		
		/*****************************
		 * 
		 * ���ֲ��ſ�������ذ�ť�Լ��¼�
		 * 
		 ****************************/
		
		//��һ�װ�ť
		bt_before.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					selectindex--;
					ClickMethod.Click(playerController,selectindex);
					allList.setSelectedIndex(selectindex);
				} catch (Exception e2) {
					selectindex++;
					System.out.println("���б�");
				}
			}
		});
		
		//��һ�װ�ť
		bt_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					selectindex++;
					ClickMethod.Click(playerController,selectindex);
					allList.setSelectedIndex(selectindex);
				} catch (Exception e2) {
					selectindex--;
					System.out.println("���б�");
				}
				
			}
		});
		
		
		
		//��ͣ��������ť
		bt_pauseAndresume.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				playerController.PS_RS();		// ��ͣ/�ָ�����
			}
		});
		
		//��������ק����
		PlayBar.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				playerController.seek(PlayBar.getValue());		// ������ת����
				playerController.PS_RS();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				playerController.PS_RS();
			}
			
			@Override public void mouseExited(MouseEvent e) {}
			@Override public void mouseEntered(MouseEvent e) {}
			@Override public void mouseClicked(MouseEvent e) {}
		});
		
		//�����и蹦��
		PlayBar.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if(BindMethod.JudgeFinish()) {
					bt_next.doClick();
				}
			}
		});
	}
}
