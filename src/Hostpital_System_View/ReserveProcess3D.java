package Hostpital_System_View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ReserveProcess3D {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	
	public static void main(String[] args) {
		new ReserveProcess3D();
	}
	public ReserveProcess3D() {
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
		frame.setBounds(100, 100, 368, 568);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel backgdMain = new JLabel(new ImageIcon("img/ReserveProcess3D.png"));
		backgdMain.setBounds(0, 0, 352, 529);
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
		back_bt.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				ReserveProcess2 RP2 = new ReserveProcess2();
				frame.dispose();
			}
		});
		
		
		JButton wantScadule_bt = new JButton();
		wantScadule_bt.setBounds(20, 123, 148, 30);
		frame.getContentPane().add(wantScadule_bt);
		wantScadule_bt.setBorderPainted(false);
		wantScadule_bt.setFocusPainted(false);
		wantScadule_bt.setContentAreaFilled(false);
		wantScadule_bt.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				ReserveProcess3S wantS = new ReserveProcess3S();
				frame.dispose();
			}
		});
		
		ImageIcon list[] = new ImageIcon[3];
		for(int i= 0; i<list.length; i++) {
			list[i] = new ImageIcon("img/sdoc"+i+"_bt.png");
		}
		
		//이름이랑 그거를 개인적으로 못넣을듯 그림 다르게 넣기 똑같은 데이터 받아오는 식으로 하기
		JList imageList = new JList(list);
		imageList.setSize(312, 700);
		JScrollPane scrollPage = new JScrollPane(imageList);
		scrollPage.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPage.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPage.setBounds(18, 154, 330, 250);
		
		frame.getContentPane().add(scrollPage);
		scrollPage.setBorder(null); //스크롤 테두리 없애기
		scrollPage.setBackground(new Color(65, 140, 195));
		
		JButton next_bt = new JButton();
		next_bt.setBounds(130, 450, 80, 30);
		frame.getContentPane().add(next_bt);
		next_bt.setBorderPainted(false);
		next_bt.setFocusPainted(false);
		next_bt.setContentAreaFilled(false);
		next_bt.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				ReserveProcess3sT RP3dT = new ReserveProcess3sT();
				
			}
		});
		
		
		
		
		
		
		
		
		frame.getContentPane().add(backgdMain);
		
		
		
		
		
		
	}
}
