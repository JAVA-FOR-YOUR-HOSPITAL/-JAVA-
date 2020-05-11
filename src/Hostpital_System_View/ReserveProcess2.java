package Hostpital_System_View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import Hostpital_System_Model.InfoVO;

public class ReserveProcess2 {

	private JFrame frame;
	private String dept_name = "";
	

	/**
	 * Create the application.
	 */
	public ReserveProcess2() {
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
		
		JLabel backgdMain = new JLabel(new ImageIcon("img/ReserveProcess2.png"));
		backgdMain.setBounds(0, 0, 352, 526);
		frame.getContentPane().setLayout(null);
		
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
				if(InfoVO.getId().equals("")){
					int result = JOptionPane.showConfirmDialog(null, "로그인하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.YES_OPTION) {
						LoginMain login = new LoginMain();
						frame.dispose();
					}
				}else {
					MyPage mypage = new MyPage();
					frame.dispose();
				}
			}
		});
		
		JButton back_bt = new JButton(new ImageIcon("img/back_bt.png"));
		back_bt.setBounds(5, 10, 60, 60);
		frame.getContentPane().add(back_bt);
		back_bt.setBorderPainted(false);
		back_bt.setFocusPainted(false);
		back_bt.setContentAreaFilled(false);
		back_bt.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				GUIMain.main(null);
				frame.dispose();
			}
		});
		
			
		JRadioButton r1c1 = new JRadioButton("");
		JRadioButton r2c1 = new JRadioButton("");
		JRadioButton r3c1 = new JRadioButton("");
		JRadioButton r4c1 = new JRadioButton("");
		JRadioButton r5c1 = new JRadioButton("");
		JRadioButton r6c1 = new JRadioButton("");
		JRadioButton r7c1 = new JRadioButton("");
		JRadioButton r8c1 = new JRadioButton("");
		JRadioButton r9c1 = new JRadioButton("");
		JRadioButton r10c1 = new JRadioButton("");
		JRadioButton r11c1 = new JRadioButton("");
		JRadioButton r1c2 = new JRadioButton("");
		JRadioButton r2c2 = new JRadioButton("");
		JRadioButton r3c2 = new JRadioButton("");
		JRadioButton r4c2 = new JRadioButton("");
		JRadioButton r5c2 = new JRadioButton("");
		JRadioButton r6c2 = new JRadioButton("");
		JRadioButton r7c2 = new JRadioButton("");
		JRadioButton r8c2 = new JRadioButton("");
		JRadioButton r9c2 = new JRadioButton("");
		JRadioButton r10c2 = new JRadioButton("");
		JRadioButton r11c2 = new JRadioButton("");
		JRadioButton r1c3 = new JRadioButton("");
		JRadioButton r2c3 = new JRadioButton("");
		JRadioButton r3c3 = new JRadioButton("");
		JRadioButton r4c3 = new JRadioButton("");
		JRadioButton r5c3 = new JRadioButton("");
		JRadioButton r6c3 = new JRadioButton("");
		JRadioButton r7c3 = new JRadioButton("");
		JRadioButton r8c3 = new JRadioButton("");
		JRadioButton r9c3 = new JRadioButton("");
		JRadioButton r10c3 = new JRadioButton("");
		
		ButtonGroup group = new ButtonGroup();
		group.add(r1c1);group.add(r2c1);group.add(r3c1);group.add(r4c1);group.add(r5c1);group.add(r6c1);group.add(r7c1);group.add(r8c1);group.add(r9c1);group.add(r10c1);group.add(r11c1);
		group.add(r1c2);group.add(r2c2);group.add(r3c2);group.add(r4c2);group.add(r5c2);group.add(r6c2);group.add(r7c2);group.add(r8c2);group.add(r9c2);group.add(r10c2);group.add(r11c2);
		group.add(r1c3);group.add(r2c3);group.add(r3c3);group.add(r4c3);group.add(r5c3);group.add(r6c3);group.add(r7c3);group.add(r8c3);group.add(r9c3);group.add(r10c3);
		r1c1.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r1c1.setOpaque(false);
		r1c1.setIcon(new ImageIcon("img/check_bt1.png"));
		r1c1.setBounds(35, 156, 20, 20);
		frame.getContentPane().add(r1c1);
		if(r1c1.isSelected() == true) {
			r2c1.setSelected(false);
		}
		r1c1.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r1c1.setOpaque(false);
		r1c1.setIcon(new ImageIcon("img/check_bt1.png"));
		r1c1.setBounds(35, 156, 20, 20);
		frame.getContentPane().add(r1c1);

		
		r2c1.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r2c1.setOpaque(false);
		r2c1.setIcon(new ImageIcon("img/check_bt1.png"));
		r2c1.setBounds(35, 181, 20, 20);
		frame.getContentPane().add(r2c1);
		r3c1.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r3c1.setOpaque(false);
		r3c1.setIcon(new ImageIcon("img/check_bt1.png"));
		r3c1.setBounds(35, 206, 20, 20);
		frame.getContentPane().add(r3c1);
		
		
		r4c1.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r4c1.setOpaque(false);
		r4c1.setIcon(new ImageIcon("img/check_bt1.png"));
		r4c1.setBounds(35, 230, 20, 20);
		frame.getContentPane().add(r4c1);

		
		r5c1.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r5c1.setOpaque(false);
		r5c1.setIcon(new ImageIcon("img/check_bt1.png"));
		r5c1.setBounds(35, 253, 20, 20);
		frame.getContentPane().add(r5c1);
		
		
		r6c1.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r6c1.setOpaque(false);
		r6c1.setIcon(new ImageIcon("img/check_bt1.png"));
		r6c1.setBounds(35, 278, 20, 20);
		frame.getContentPane().add(r6c1);

		
		r7c1.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r7c1.setOpaque(false);
		r7c1.setIcon(new ImageIcon("img/check_bt1.png"));
		r7c1.setBounds(35, 303, 20, 20);
		frame.getContentPane().add(r7c1);

		
		r8c1.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r8c1.setOpaque(false);
		r8c1.setIcon(new ImageIcon("img/check_bt1.png"));
		r8c1.setBounds(35, 326, 20, 20);
		frame.getContentPane().add(r8c1);

		
		r9c1.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r9c1.setOpaque(false);
		r9c1.setIcon(new ImageIcon("img/check_bt1.png"));
		r9c1.setBounds(35, 351, 20, 20);
		frame.getContentPane().add(r9c1);

		
		r10c1.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r10c1.setOpaque(false);
		r10c1.setIcon(new ImageIcon("img/check_bt1.png"));
		r10c1.setBounds(35, 376, 20, 20);
		frame.getContentPane().add(r10c1);
		
		r11c1.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r11c1.setOpaque(false);
		r11c1.setIcon(new ImageIcon("img/check_bt1.png"));
		r11c1.setBounds(35, 400, 20, 20);
		frame.getContentPane().add(r11c1);
		r1c2.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r1c2.setOpaque(false);
		r1c2.setIcon(new ImageIcon("img/check_bt1.png"));
		r1c2.setBounds(143, 156, 20, 20);
		frame.getContentPane().add(r1c2);

		r2c2.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r2c2.setOpaque(false);
		r2c2.setIcon(new ImageIcon("img/check_bt1.png"));
		r2c2.setBounds(143, 181, 20, 20);
		frame.getContentPane().add(r2c2);
		
		r3c2.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r3c2.setOpaque(false);
		r3c2.setIcon(new ImageIcon("img/check_bt1.png"));
		r3c2.setBounds(143, 206, 20, 20);
		frame.getContentPane().add(r3c2);
		
		r4c2.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r4c2.setOpaque(false);
		r4c2.setIcon(new ImageIcon("img/check_bt1.png"));
		r4c2.setBounds(143, 230, 20, 20);
		frame.getContentPane().add(r4c2);
		
		r5c2.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r5c2.setOpaque(false);
		r5c2.setIcon(new ImageIcon("img/check_bt1.png"));
		r5c2.setBounds(143, 253, 20, 20);
		frame.getContentPane().add(r5c2);

		
		r6c2.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r6c2.setOpaque(false);
		r6c2.setIcon(new ImageIcon("img/check_bt1.png"));
		r6c2.setBounds(143, 278, 20, 20);
		frame.getContentPane().add(r6c2);

		r7c2.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r7c2.setOpaque(false);
		r7c2.setIcon(new ImageIcon("img/check_bt1.png"));
		r7c2.setBounds(143, 303, 20, 20);
		frame.getContentPane().add(r7c2);

		r8c2.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r8c2.setOpaque(false);
		r8c2.setIcon(new ImageIcon("img/check_bt1.png"));
		r8c2.setBounds(143, 326, 20, 20);
		frame.getContentPane().add(r8c2);

		r9c2.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r9c2.setOpaque(false);
		r9c2.setIcon(new ImageIcon("img/check_bt1.png"));
		r9c2.setBounds(143, 351, 20, 20);
		frame.getContentPane().add(r9c2);

		r10c2.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r10c2.setOpaque(false);
		r10c2.setIcon(new ImageIcon("img/check_bt1.png"));
		r10c2.setBounds(143, 376, 20, 20);
		frame.getContentPane().add(r10c2);

		r11c2.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r11c2.setOpaque(false);
		r11c2.setIcon(new ImageIcon("img/check_bt1.png"));
		r11c2.setBounds(143, 400, 20, 20);
		frame.getContentPane().add(r11c2);
		
		r1c3.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r1c3.setOpaque(false);
		r1c3.setIcon(new ImageIcon("img/check_bt1.png"));
		r1c3.setBounds(235, 156, 20, 20);
		frame.getContentPane().add(r1c3);
		
		r2c3.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r2c3.setOpaque(false);
		r2c3.setIcon(new ImageIcon("img/check_bt1.png"));
		r2c3.setBounds(235, 181, 20, 20);
		frame.getContentPane().add(r2c3);
		r3c3.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r3c3.setOpaque(false);
		r3c3.setIcon(new ImageIcon("img/check_bt1.png"));
		r3c3.setBounds(235, 206, 20, 20);
		frame.getContentPane().add(r3c3);
		
		r4c3.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r4c3.setOpaque(false);
		r4c3.setIcon(new ImageIcon("img/check_bt1.png"));
		r4c3.setBounds(235, 230, 20, 20);
		frame.getContentPane().add(r4c3);
		
		r5c3.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r5c3.setOpaque(false);
		r5c3.setIcon(new ImageIcon("img/check_bt1.png"));
		r5c3.setBounds(235, 253, 20, 20);
		frame.getContentPane().add(r5c3);
		
		r6c3.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r6c3.setOpaque(false);
		r6c3.setIcon(new ImageIcon("img/check_bt1.png"));
		r6c3.setBounds(235, 278, 20, 20);
		frame.getContentPane().add(r6c3);
		
		r7c3.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r7c3.setOpaque(false);
		r7c3.setIcon(new ImageIcon("img/check_bt1.png"));
		r7c3.setBounds(235, 303, 20, 20);
		frame.getContentPane().add(r7c3);
		
		r8c3.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r8c3.setOpaque(false);
		r8c3.setIcon(new ImageIcon("img/check_bt1.png"));
		r8c3.setBounds(235, 326, 20, 20);
		frame.getContentPane().add(r8c3);
		
		r9c3.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r9c3.setOpaque(false);
		r9c3.setIcon(new ImageIcon("img/check_bt1.png"));
		r9c3.setBounds(235, 351, 20, 20);
		frame.getContentPane().add(r9c3);

		r10c3.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		r10c3.setOpaque(false);
		r10c3.setIcon(new ImageIcon("img/check_bt1.png"));
		r10c3.setBounds(235, 376, 20, 20);
		frame.getContentPane().add(r10c3);

		
		JButton select_bt2 = new JButton();
		select_bt2.setBounds(100, 440, 150, 30);
		frame.getContentPane().add(select_bt2);
		select_bt2.setBorderPainted(false);
		select_bt2.setFocusPainted(false);
		select_bt2.setContentAreaFilled(false);	
		select_bt2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(r1c1.isSelected() == true) {
				dept_name = "간담췌외과";
			}
			if(r2c1.isSelected() == true) {
				dept_name = "내분비대사내과";
			}
			if(r3c1.isSelected() == true) {
				dept_name = "류마티스내과";
			}
			if(r4c1.isSelected() == true) {
				dept_name = "산부인과";
			}
			if(r5c1.isSelected() == true) {
				dept_name = "소아청소년과";
			}
			if(r6c1.isSelected() == true) {
				dept_name = "신경과";
			}
			if(r7c1.isSelected() == true) {
				dept_name = "안과";
			}
			if(r8c1.isSelected() == true) {
				dept_name = "위장관외과";
			}
			if(r9c1.isSelected() == true) {
				dept_name = "재활의학과";
			}
			if(r10c1.isSelected() == true) {
				dept_name = "피부과";
			}
			if(r11c1.isSelected() == true) {
				dept_name = "호흡기내과";
			}
			if(r1c2.isSelected() == true) {
				dept_name = "감염내과";
			}
			if(r2c2.isSelected() == true) {
				dept_name = "내분비외과";
			}
			if(r3c2.isSelected() == true) {
				dept_name = "통증클리닉";
			}
			if(r4c2.isSelected() == true) {
				dept_name = "성형외과";
			}
			if(r5c2.isSelected() == true) {
				dept_name = "소화기내과";
			}
			if(r6c2.isSelected() == true) {
				dept_name = "신경외과";
			}
			if(r7c2.isSelected() == true) {
				dept_name = "알레르기외과";
			}
			if(r8c2.isSelected() == true) {
				dept_name = "이비인후과";
			}
			if(r9c2.isSelected() == true) {
				dept_name = "정형외과";
			}
			if(r10c2.isSelected() == true) {
				dept_name = "핵의학과";
			}
			if(r11c2.isSelected() == true) {
				dept_name = "흉부외과";
			}
			if(r1c3.isSelected() == true) {
				dept_name = "구강악안면외과";
			}
			if(r2c3.isSelected() == true) {
				dept_name = "대장항문외과";
			}
			if(r3c3.isSelected() == true) {
				dept_name = "비뇨의학과";
			}
			if(r4c3.isSelected() == true) {
				dept_name = "소아외과";
			}
			if(r5c3.isSelected() == true) {
				dept_name = "순환기내과";
			}
			if(r6c3.isSelected() == true) {
				dept_name = "신장내과";
			}
			if(r7c3.isSelected() == true) {
				dept_name = "외상외과";
			}
			if(r8c3.isSelected() == true) {
				dept_name = "이식혈관외과";
			}
			if(r9c3.isSelected() == true) {
				dept_name = "직업환경의학과";
			}
			if(r10c3.isSelected() == true) {
				dept_name = "혈액내과";
			}
			InfoVO.setDeptname(dept_name);
			ReserveProcess3S wantS = new ReserveProcess3S();
			frame.dispose();
		}
	});
		
		
		
		frame.getContentPane().add(backgdMain);
		
	}
}
