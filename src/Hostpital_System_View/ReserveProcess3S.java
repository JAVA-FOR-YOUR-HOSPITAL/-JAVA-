package Hostpital_System_View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import Hostpital_System_Model.InfoVO;

public class ReserveProcess3S {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ReserveProcess3S window = new ReserveProcess3S();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ReserveProcess3S() {
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

		JLabel backgdMain = new JLabel(new ImageIcon("img/ReserveProcess3S.png"));
		backgdMain.setBounds(0, 0, 352, 526);
		frame.getContentPane().setLayout(null);

		JButton home_bt = new JButton(new ImageIcon("img/home_bt.png"));
		home_bt.setBounds(150, 5, 60, 60);
		frame.getContentPane().add(home_bt);
		home_bt.setBorderPainted(false);
		home_bt.setFocusPainted(false);
		home_bt.setContentAreaFilled(false);
		home_bt.addActionListener(new ActionListener() { // 익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e) {
				GUIMain.main(null);
				frame.dispose();
			}
		});
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("12롯데마트드림Light", Font.BOLD, 13));
		lblNewLabel.setBounds(108, 419, 141, 15);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setText(InfoVO.getDeptname());

		JButton mine_bt = new JButton(new ImageIcon("img/mine_bt.png"));
		mine_bt.setBounds(300, 10, 60, 60);
		frame.getContentPane().add(mine_bt);
		mine_bt.setBorderPainted(false);
		mine_bt.setFocusPainted(false);
		mine_bt.setContentAreaFilled(false);
		mine_bt.addActionListener(new ActionListener() { // 익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e) {
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
		back_bt.addActionListener(new ActionListener() { // 익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e) {
				ReserveProcess2 RP2 = new ReserveProcess2();
				frame.dispose();
			}
		});

		// 선택칸 마지막 금요일

		JRadioButton selectScadule_bt = new JRadioButton("");
		selectScadule_bt.setOpaque(false);
		selectScadule_bt.setHorizontalAlignment(SwingConstants.CENTER);
		selectScadule_bt.setIcon(new ImageIcon("img/check31_bt1.png"));
		selectScadule_bt.setSelectedIcon(new ImageIcon("img/check31_bt2.png"));
		selectScadule_bt.setBounds(221, 359, 30, 30);
		frame.getContentPane().add(selectScadule_bt);

		JButton next_bt = new JButton();
		next_bt.setBounds(130, 450, 80, 30);
		frame.getContentPane().add(next_bt);
		next_bt.setBorderPainted(false);
		next_bt.setFocusPainted(false);
		next_bt.setContentAreaFilled(false);
		next_bt.addActionListener(new ActionListener() { // 익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e) {
				ReserveProcess3sT RP3sT = new ReserveProcess3sT();

			}
		});

		JButton wantDoc_bt = new JButton();
		wantDoc_bt.setBounds(180, 120, 148, 30);
		frame.getContentPane().add(wantDoc_bt);
		wantDoc_bt.setBorderPainted(false);
		wantDoc_bt.setFocusPainted(false);
		wantDoc_bt.setContentAreaFilled(false);
		wantDoc_bt.addActionListener(new ActionListener() { // 익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e) {
				ReserveProcess3D wantD = new ReserveProcess3D();
				frame.dispose();
			}
		});

		frame.getContentPane().add(backgdMain);

	}

}
