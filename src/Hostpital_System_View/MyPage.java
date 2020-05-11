package Hostpital_System_View;

import java.awt.Color;
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
import javax.swing.SwingConstants;

import Hostpital_System_Model.InfoVO;
import Hostpital_System_Model.MemberDAO;
import Hostpital_System_Model.MemberDTO;

public class MyPage {

	private JFrame frame;
	private MemberDTO member;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPage window = new MyPage();
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
	public MyPage() {
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
		
		JLabel myPage = new JLabel(new ImageIcon("img/MyPage.png"));
		myPage.setBounds(0, 0, 352, 526);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(64, 140, 195));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("12롯데마트드림Light", Font.BOLD, 15));
		lblNewLabel.setBounds(115, 167, 73, 24);
		frame.getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(64, 140, 195));
		lblNewLabel_1.setFont(new Font("12롯데마트드림Light", Font.BOLD, 15));
		lblNewLabel_1.setBounds(119, 224, 139, 17);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel label = new JLabel("");
		label.setForeground(new Color(64, 140, 195));
		label.setFont(new Font("12롯데마트드림Light", Font.BOLD, 15));
		label.setBounds(119, 262, 139, 17);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(new Color(64, 140, 195));
		label_1.setFont(new Font("12롯데마트드림Light", Font.BOLD, 15));
		label_1.setBounds(119, 299, 139, 17);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setForeground(new Color(64, 140, 195));
		label_2.setFont(new Font("12롯데마트드림Light", Font.BOLD, 15));
		label_2.setBounds(119, 337, 198, 17);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setForeground(new Color(64, 140, 195));
		label_3.setFont(new Font("12롯데마트드림Light", Font.BOLD, 15));
		label_3.setBounds(119, 376, 198, 17);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setForeground(new Color(64, 140, 195));
		label_4.setFont(new Font("12롯데마트드림Light", Font.BOLD, 15));
		label_4.setBounds(119, 414, 198, 17);
		frame.getContentPane().add(label_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("12롯데마트드림Light", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(210, 120, 130, 65);
		frame.getContentPane().add(lblNewLabel_2);
		
		MemberDAO dao = new MemberDAO();
		member = dao.showInfo(InfoVO.getId());
		if(member == null) {
			System.out.println("에러");
		}else {
			lblNewLabel.setText(member.getMember_name());
			lblNewLabel_1.setText(member.getMember_id());
			label.setText("********");
			label_1.setText(member.getMember_name());
			label_2.setText(member.getMember_ad());
			label_3.setText(member.getMember_ph());
			label_4.setText(member.getMember_birth());
			int grade = member.getMember_grade();
			String member_grade = "";
			switch(grade) {
			case 0:
				member_grade = "우수";
				lblNewLabel_2.setForeground(new Color(102, 204, 102));
				break;
			case 1:
				lblNewLabel_2.setForeground(new Color(255, 204, 51));
				member_grade = "주의";
				
				break;
			case 2:
				lblNewLabel_2.setForeground(new Color(255, 0, 0));
				member_grade = "경고";
				break;
			case 3:
				member_grade = "블랙리스트";
				lblNewLabel_2.setForeground(new Color(0, 0, 0));
				break;
			}
			lblNewLabel_2.setText(member_grade);
			
		}
		
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
		
		JButton yes_bt = new JButton();
		yes_bt.setBounds(185, 455, 110, 30);
		frame.getContentPane().add(yes_bt);
		yes_bt.setBorderPainted(false);
		yes_bt.setFocusPainted(false);
		yes_bt.setContentAreaFilled(false);
		yes_bt.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				GUIMain.main(null);
				frame.dispose();
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		frame.getContentPane().add(myPage);
		
	}
}
