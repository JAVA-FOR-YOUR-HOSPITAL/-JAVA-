package Hostpital_System_View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Hostpital_System_Model.Book_markDAO;
import Hostpital_System_Model.InfoVO;

public class GUIMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain window = new GUIMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIMain() {
		initialize();
		Dimension frameSize = frame.getSize();
		// 모니터 크기
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// (모니터화면 가로 - 프레임화면 가로) / 2, (모니터화면 세로 - 프레임화면 세로) / 2
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 368, 565);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel mainMenu = new JLabel(new ImageIcon("img/MenuMain.png"));
		mainMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mainMenu.setBounds(0, 0, 352, 526);

		JButton home_bt = new JButton(new ImageIcon("img/home_bt.png"));
		home_bt.setBounds(150, 5, 60, 60);
		frame.getContentPane().add(home_bt);
		home_bt.setBorderPainted(false);
		home_bt.setFocusPainted(false);
		home_bt.setContentAreaFilled(false);

		JButton mine_bt = new JButton(new ImageIcon("img/mine_bt.png"));
		mine_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (InfoVO.getId().equals("")) {
					int result = JOptionPane.showConfirmDialog(null, "로그인하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						LoginMain login = new LoginMain();
						frame.dispose();
					}
				} else {
					MyPage mypage = new MyPage();
					frame.dispose();
				}
			}
		});
		mine_bt.setBounds(300, 10, 60, 60);
		frame.getContentPane().add(mine_bt);
		mine_bt.setBorderPainted(false);
		mine_bt.setFocusPainted(false);
		mine_bt.setContentAreaFilled(false);

		JButton search_bt = new JButton(new ImageIcon("img/search_bt.png"));
		search_bt.setBounds(235, 165, 60, 60);
		frame.getContentPane().add(search_bt);
		search_bt.setBorderPainted(false);
		search_bt.setFocusPainted(false);
		search_bt.setContentAreaFilled(false);
		search_bt.addActionListener(new ActionListener() { // 익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e) {
				SearchMain search = new SearchMain();
				frame.dispose();
			}
		});

		JButton reserve_bt = new JButton(new ImageIcon("img/reserve_bt.png"));
		reserve_bt.setBounds(150, 170, 60, 60);
		frame.getContentPane().add(reserve_bt);
		reserve_bt.setBorderPainted(false);
		reserve_bt.setFocusPainted(false);
		reserve_bt.setContentAreaFilled(false);
		reserve_bt.addActionListener(new ActionListener() { // 익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e) {
				if(InfoVO.getId().equals("")) {
					int result = JOptionPane.showConfirmDialog(null, "로그인이 필요합니다.", "확인", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						LoginMain login = new LoginMain();
						frame.dispose();
					}
				}else {
					ReserveProcess1 book = new ReserveProcess1();
					frame.dispose();
				}
			}
		});

		Random rd = new Random();
		int n = rd.nextInt(2);

		JButton bookMark_bt = new JButton(new ImageIcon("img/bookMark_bt.png"));
		bookMark_bt.setBounds(49, 165, 60, 60);
		frame.getContentPane().add(bookMark_bt);
		bookMark_bt.setBorderPainted(false);
		bookMark_bt.setFocusPainted(false);
		bookMark_bt.setContentAreaFilled(false);
		bookMark_bt.addActionListener(new ActionListener() { // 익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e) {
				if (InfoVO.getId().equals("")) {
					int result = JOptionPane.showConfirmDialog(null, "로그인이 필요합니다.", "확인", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						LoginMain login = new LoginMain();
						frame.dispose();
					}
				} else {
					Book_markDAO book = new Book_markDAO();
					ArrayList<ArrayList<String>> list = book.book_m_look(InfoVO.getId());
					if(list.size() == 2) {
						BookMarkMain2 book2 = new BookMarkMain2();
					}else if(list.size() < 2) {
						BookMarkMain book1 = new BookMarkMain();
					}else if(list == null){
						System.out.println("값이 없습니다.");
					}
					frame.dispose();
				}
			}
		});

		JButton view_bt = new JButton(new ImageIcon("img/view_bt.png"));
		view_bt.setBounds(49, 264, 60, 60);
		frame.getContentPane().add(view_bt);
		view_bt.setBorderPainted(false);
		view_bt.setFocusPainted(false);
		view_bt.setContentAreaFilled(false);
		view_bt.addActionListener(new ActionListener() { // 익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e) {
				if(InfoVO.getId().equals("")) {
					int result = JOptionPane.showConfirmDialog(null, "로그인이 필요합니다.", "로그인", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						LoginMain login = new LoginMain();
						frame.dispose();
					}
				}else {
					ViewMain view1 = new ViewMain();
					frame.dispose();					
				}
			}
		});

		JButton waiting_bt = new JButton(new ImageIcon("img/waiting_bt.png"));
		waiting_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		waiting_bt.setBounds(146, 264, 60, 60);
		frame.getContentPane().add(waiting_bt);
		waiting_bt.setBorderPainted(false);
		waiting_bt.setFocusPainted(false);
		waiting_bt.setContentAreaFilled(false);

		JButton guide_bt = new JButton(new ImageIcon("img/guide_bt.png"));
		guide_bt.setBounds(235, 264, 60, 60);
		frame.getContentPane().add(guide_bt);
		guide_bt.setBorderPainted(false);
		guide_bt.setFocusPainted(false);
		guide_bt.setContentAreaFilled(false);

		frame.getContentPane().add(mainMenu);

	}

}
