package Hostpital_System_View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ReserveProcess4 {

	private JFrame frame;

	

	/**
	 * Create the application.
	 */
	public ReserveProcess4() {
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
		
		JLabel backgdMain = new JLabel(new ImageIcon("img/ReserveProcess4.png"));
		backgdMain.setBounds(0, 0, 352, 526);
		
		JButton home_bt = new JButton(new ImageIcon("img/home_bt.png"));
		home_bt.setBounds(150, 5, 60, 60);
		frame.getContentPane().add(home_bt);
		home_bt.setBorderPainted(false);
		home_bt.setFocusPainted(false);
		home_bt.setContentAreaFilled(false);
		home_bt.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				GUIMain.main(null);
				frame.dispose();
			}
		});
		
		JButton mine_bt = new JButton(new ImageIcon("img/mine_bt.png"));
		mine_bt.setBounds(300, 10, 60, 60);
		frame.getContentPane().add(mine_bt);
		mine_bt.setBorderPainted(false);
		mine_bt.setFocusPainted(false);
		mine_bt.setContentAreaFilled(false);
		mine_bt.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				MyPage mp = new MyPage();
				frame.dispose();
			}
		});
		
		JButton back_bt = new JButton(new ImageIcon("img/back_bt.png"));
		back_bt.setBounds(5, 10, 60, 60);
		frame.getContentPane().add(back_bt);
		back_bt.setBorderPainted(false);
		back_bt.setFocusPainted(false);
		back_bt.setContentAreaFilled(false);
		
		JButton viewCheck_bt = new JButton();
		viewCheck_bt.setBounds(45, 295, 130, 30);
		frame.getContentPane().add(viewCheck_bt);
		viewCheck_bt.setBorderPainted(false);
		viewCheck_bt.setFocusPainted(false);
		viewCheck_bt.setContentAreaFilled(false);
		viewCheck_bt.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				ViewMain vm = new ViewMain();
				frame.dispose();
			}
		});
		
		
		JButton mainMenu_bt = new JButton();
		mainMenu_bt.setBounds(180, 295, 130, 30);
		frame.getContentPane().add(mainMenu_bt);
		mainMenu_bt.setBorderPainted(false);
		mainMenu_bt.setFocusPainted(false);
		mainMenu_bt.setContentAreaFilled(false);
		mainMenu_bt.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				GUIMain.main(null);
				frame.dispose();
			}
		});
		
		
		
		frame.getContentPane().add(backgdMain);
		
		
	}

}
