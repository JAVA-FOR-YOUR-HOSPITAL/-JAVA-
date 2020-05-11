package Hostpital_System_View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;

public class LoginMain {

	private JFrame frame;
	BufferedImage img1 = null;//전역변수 깔아두기
	
	/**
	 * Create the application.
	 */
	public LoginMain() {
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
		
		ImageIcon image1 = new ImageIcon("img/LoginMain.png");
		JLabel backgdMain = new JLabel(image1);
		
		backgdMain.setBounds(0, 0, 352, 526);
		
		
		
		try {
			img1 = ImageIO.read(new File("img/LoginMain.png"));
		}catch(IOException e) {
			System.out.println("이미지 불러오기 실패");
			System.exit(0);
		}

		ImageIcon image2 = new ImageIcon("img/Login_bt.png");
		JButton loginBt = new JButton(image2);
		loginBt.setBounds(85, 312, 180, 40);
		frame.getContentPane().add(loginBt);
		
		loginBt.setBorderPainted(false);
		loginBt.setFocusPainted(false);
		loginBt.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				LoginIdAndPw LgPw = new LoginIdAndPw();
				frame.dispose();
			}
		});
		//loginBt.setContentAreaFilled(false);
		
		ImageIcon image3 = new ImageIcon("img/Join_bt.png");
		JButton joinBt = new JButton(image3);
		joinBt.setBounds(85, 362, 180, 40);
		frame.getContentPane().add(joinBt);
		joinBt.setBorderPainted(false);
		joinBt.setFocusPainted(false);
		
		
		frame.getContentPane().add(backgdMain);
		
	}
}
