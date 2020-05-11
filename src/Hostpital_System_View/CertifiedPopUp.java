package Hostpital_System_View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Hostpital_System_Model.DeptDAO;
import Hostpital_System_Model.DoctorDAO;
import Hostpital_System_Model.HospitalDAO;
import Hostpital_System_Model.InfoVO;
import Hostpital_System_Model.ReservationDAO;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JRadioButton;

public class CertifiedPopUp {

	private JFrame frame;
	private JTextField name;
	private JTextField checkList1;
	private JTextField checkList2;
	private JTextField handPhone1;
	private JTextField handPhone2;
	private JTextField handPhone3;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               CertifiedPopUp window = new CertifiedPopUp();
//               window.frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }

	/**
	 * Create the application.
	 */
	public CertifiedPopUp() {
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
		JLabel backgdMain = new JLabel(new ImageIcon("img/confirmMain.png"));
		backgdMain.setBounds(0, 0, 352, 526);
		frame.getContentPane().setLayout(null);

		JRadioButton yes_bt = new JRadioButton("동의합니다.");
		yes_bt.setHorizontalAlignment(SwingConstants.CENTER);
		yes_bt.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 15));
		yes_bt.setSelectedIcon(new ImageIcon("img/check_bt2.png"));
		yes_bt.setIcon(new ImageIcon("img/check_bt1.png"));
		yes_bt.setOpaque(false);
		yes_bt.setBounds(125, 211, 101, 23);
		frame.getContentPane().add(yes_bt);

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
		back_bt.addActionListener(new ActionListener() { // 익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e) {
				GUIMain.main(null);
				frame.dispose();
			}
		});

		name = new JTextField();
		name.setBounds(107, 255, 190, 21);
		name.setOpaque(false);
		name.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 16));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(name);
		name.setColumns(15);
		name.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		checkList1 = new JTextField();
		checkList1.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 16));
		checkList1.setBounds(129, 310, 64, 21);
		checkList1.setHorizontalAlignment(SwingConstants.CENTER);
		checkList1.setOpaque(false);
		frame.getContentPane().add(checkList1);
		checkList1.setColumns(6);
		checkList1.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		checkList2 = new JTextField();
		checkList2.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 16));
		checkList2.setBounds(214, 310, 70, 21);
		checkList2.setOpaque(false);
		checkList2.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(checkList2);
		checkList2.setColumns(7);
		checkList2.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		handPhone1 = new JTextField();
		handPhone1.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 16));
		handPhone1.setBounds(116, 362, 39, 21);
		handPhone1.setOpaque(false);
		handPhone1.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(handPhone1);
		handPhone1.setColumns(3);
		handPhone1.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		handPhone2 = new JTextField();
		handPhone2.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 16));
		handPhone2.setBounds(187, 362, 39, 21);
		handPhone2.setOpaque(false);
		handPhone2.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(handPhone2);
		handPhone2.setColumns(4);
		handPhone2.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		handPhone3 = new JTextField();
		handPhone3.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 16));
		handPhone3.setBounds(256, 362, 39, 21);
		handPhone3.setOpaque(false);
		handPhone3.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(handPhone3);
		handPhone3.setColumns(4);
		handPhone3.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 13));
		textArea.setBounds(46, 88, 4, 24);
		frame.getContentPane().add(textArea);

		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(30, 105, 300, 100);
		frame.getContentPane().add(scrollPane);

		textArea.setText("<< 개인정보 동의서 >> \r\n" + "전남대학교병원은 개인정보보호법에 의거하여 귀하\r\n" + "의 개인정보를 수집함에 있어 아래의 내용을 안내하고\r\n"
				+ "있습니다. \r\n" + "전남대학교병원은 수집한 개인정보를 다음의 목적을\r\n " + "위해 활용합니다. \r\n"
				+ "이용자가 제공한 모든 정보는 하기 목적에 필요한 \r\n" + "용도 이외로는 사용되지 않으며 이용 목적이 변경될 \r\n시에는 사전 동의를 구할 것입니다.\r\n"
				+ "< 개인정보의 수집 및 이용목적 >\r\n" + "‘비회원 인터넷 예약’을 진행하기 위한 용도\r\n" + "수집하는 개인정보의 항목 및 수집방법\r\n"
				+ "필수항목 : 환자성명, 휴대폰번호\r\n" + "개인정보의 보유 및 이용기간\r\n" + "입력하신 개인정보는 진료예약 후 삭제되며, \r\n"
				+ "예약 외 목적으로는 사용치 아니합니다.\r\n " + "(진료 후 의료법에 따른 기간동안 보유함)\r\n" + "동의를 거부할 권리 / 동의거부에 따른 안내\r\n"
				+ "고객께서는 본 안내에 따른 개인정보 수집에 대하여 \r\n 거부할 수 있는 권리가 있습니다.\r\n"
				+ "진료예약을 위한 개인정보 미제공시에는 비회원 \r\n 인터넷 예약 서비스를 받으실 수 없습니다.");

		JButton confirm_bt = new JButton("");
		confirm_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (yes_bt.isSelected() == true) {
					ReservationDAO dao = new ReservationDAO();
					String uname = name.getText();
					String hp = handPhone1.getText() + "-" + handPhone2.getText() + "-" + handPhone3.getText();
					String check_id_num = checkList1.getText() + "-" + checkList2.getText();
					
					if (uname.equals(InfoVO.getUsername())) {
						int result = dao.certification(uname, hp, check_id_num);
						if (result == 1) {
							String date = InfoVO.getDate() + " " + InfoVO.getTime() + ":00";
							HospitalDAO hos = new HospitalDAO();
							int hos_num = hos.getHos_num(InfoVO.getHosname());
							DeptDAO dept = new DeptDAO();
							int dept_num = dept.getDept_num(hos_num, InfoVO.getDeptname());
							DoctorDAO doc = new DoctorDAO();
							String doc_name = doc.getDoc_id(hos_num, dept_num, InfoVO.getDocname());
							int res = dao.reservation(InfoVO.getId(), dept_num, doc_name, date);
							if (res == 1) {
								InfoVO.setHosname("");
								InfoVO.setDeptname("");
								InfoVO.setDocname("");
								InfoVO.setDate("");
								InfoVO.setTime("");
								ReserveProcess4 rp = new ReserveProcess4();
								frame.dispose();
							} else {
								JOptionPane.showMessageDialog(null, "예약에 실패하셨습니다.");
							}
						} else {
							JOptionPane.showMessageDialog(null, "입력한 정보가 맞지 않습니다.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "로그인한 정보와 일치하지 않습니다.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "동의를 하셔야만 인증이 가능합니다.");
				}
			}
		});
		confirm_bt.setBounds(80, 448, 113, 28);
		frame.getContentPane().add(confirm_bt);
		confirm_bt.setBorderPainted(false);
		confirm_bt.setFocusPainted(false);
		confirm_bt.setContentAreaFilled(false);

		JButton cancel_bt = new JButton("");
		cancel_bt.setBounds(205, 448, 113, 28);
		frame.getContentPane().add(cancel_bt);
		cancel_bt.setBorderPainted(false);
		cancel_bt.setFocusPainted(false);
		cancel_bt.setContentAreaFilled(false);

		frame.getContentPane().add(backgdMain);

	}
}
