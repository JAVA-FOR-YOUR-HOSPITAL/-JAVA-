package Hostpital_System_View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Hostpital_System_Model.InfoVO;

public class ReserveProcess1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public ReserveProcess1() {
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
		
		JLabel backgdMain = new JLabel(new ImageIcon("img/ReserveProcess1.png"));
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
		back_bt.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				GUIMain.main(null);
				frame.dispose();
			}
		});
		
		JButton jnu_bt = new JButton();
		jnu_bt.setBounds(17, 210, 103, 115);
		frame.getContentPane().add(jnu_bt);
		jnu_bt.setBorderPainted(false);
		jnu_bt.setFocusPainted(false);
		jnu_bt.setContentAreaFilled(false);
		jnu_bt.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				InfoVO.setHosname("전남대학교병원");
				ReserveProcess2 Rp2 = new ReserveProcess2();
				frame.dispose();
			}
		});
		
		JButton jnuH_bt = new JButton();
		jnuH_bt.setBounds(120, 210, 103, 115);
		frame.getContentPane().add(jnuH_bt);
		jnuH_bt.setBorderPainted(false);
		jnuH_bt.setFocusPainted(false);
		jnuH_bt.setContentAreaFilled(false);
		jnuH_bt.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				InfoVO.setHosname("화순전남대학교병원");
				ReserveProcess2 Rp2 = new ReserveProcess2();
				frame.dispose();
			}
		});
		
		JButton csu_bt = new JButton();
		csu_bt.setBounds(230, 210, 103, 115);
		frame.getContentPane().add(csu_bt);
		csu_bt.setBorderPainted(false);
		csu_bt.setFocusPainted(false);
		csu_bt.setContentAreaFilled(false);
		csu_bt.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				InfoVO.setHosname("조선대학교병원");
				ReserveProcess2 Rp2 = new ReserveProcess2();
				frame.dispose();
			}
		});
		
		
		frame.getContentPane().add(backgdMain);
	}
}
