package Hostpital_System_View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Hostpital_System_Model.InfoVO;
import Hostpital_System_Model.MemberDAO;
import Hostpital_System_Model.MemberDTO;

public class LoginIdAndPw {

	private JFrame frame;
	private JTextField loginTextField;
	private JTextField passwordField;
	private JButton enterBt;
	private JButton cancelBt;

	
	public LoginIdAndPw() {
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
		
		ImageIcon image1 = new ImageIcon("img/LoginSmallMain.png");
		JLabel backgdMain = new JLabel(image1);
		backgdMain.setBounds(0, 0, 352, 526);
		
		loginTextField = new JTextField();
		loginTextField.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		loginTextField.setForeground(new Color(0, 0, 128));
		loginTextField.setHorizontalAlignment(SwingConstants.CENTER);
		loginTextField.setBounds(100, 290, 150, 20);
		loginTextField.setOpaque(false);
		loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		frame.getContentPane().add(loginTextField);
		loginTextField.setColumns(15);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(0, 0, 128));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(100, 320, 150, 20);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		frame.getContentPane().add(passwordField);
		passwordField.setColumns(15);
		
		enterBt = new JButton(new ImageIcon("img/Enter_bt.png"));
		enterBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO mem_dao = new MemberDAO();
				String id = loginTextField.getText();
				String pw = passwordField.getText();
				MemberDTO member = mem_dao.login(id, pw);
				if(member == null) {
					JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 틀립니다.");
				}else {
					InfoVO.setUsername(member.getMember_name());
					InfoVO.setId(id);
					GUIMain main = new GUIMain();
					frame.dispose();
				}
			}
		});
		enterBt.setBounds(75, 355, 100, 40);
		frame.getContentPane().add(enterBt);
		enterBt.setBorderPainted(false);
		enterBt.setFocusPainted(false);
		
		cancelBt = new JButton(new ImageIcon("img/cancel_bt.png"));
		cancelBt.setBounds(175, 355, 100, 40);
		frame.getContentPane().add(cancelBt);
		cancelBt.setBorderPainted(false);
		cancelBt.setFocusPainted(false);
		cancelBt.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				LoginMain LgPw = new LoginMain();
				frame.dispose();
			}
		});
		
		
		
		frame.getContentPane().add(backgdMain);
		
		
		
		
		
		
		
	
	}
}
