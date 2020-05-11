package Hostpital_System_View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Hostpital_System_Model.Book_markDAO;
import Hostpital_System_Model.DeptDAO;
import Hostpital_System_Model.DoctorDAO;
import Hostpital_System_Model.HospitalDAO;
import Hostpital_System_Model.InfoVO;

public class BookMarkMain {

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookMarkMain window = new BookMarkMain();
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
	public BookMarkMain() {
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
		ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
		Book_markDAO book = new Book_markDAO();
		lists = book.book_m_look(InfoVO.getId());
		
		frame = new JFrame();
		frame.setBounds(100, 100, 368, 565);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel backgdMain = new JLabel(new ImageIcon("img/BookMarkMain.png"));
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

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("12롯데마트드림Medium", Font.PLAIN, 13));
		lblNewLabel.setBounds(65, 217, 138, 28);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("12롯데마트드림Medium", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(155, 217, 60, 28);
		frame.getContentPane().add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("12롯데마트드림Medium", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(200, 217, 60, 28);
		frame.getContentPane().add(lblNewLabel_2);

		if (lists == null) {
			System.out.println("값이 없습니다.");
		} else {
			for (ArrayList<String> list : lists) {
				lblNewLabel.setText(list.get(0));
				lblNewLabel_1.setText(list.get(1));
				lblNewLabel_2.setText(list.get(2));
			}
		}

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

		JButton remove_bt = new JButton();
		remove_bt.setBounds(12, 217, 28, 28);
		frame.getContentPane().add(remove_bt);
		remove_bt.setBorderPainted(false);
		remove_bt.setFocusPainted(false);
		remove_bt.setContentAreaFilled(false);
		remove_bt.addActionListener(new ActionListener() { // 익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e) {
				HospitalDAO hos = new HospitalDAO();
				int hos_num = hos.getHos_num(lblNewLabel.getText());
				DeptDAO dept = new DeptDAO();
				int dept_num = dept.getDept_num(hos_num, lblNewLabel_1.getText());
				DoctorDAO doc = new DoctorDAO();
				String doc_id = doc.getDoc_id(hos_num, dept_num, lblNewLabel_2.getText());
				int book_num = book.getBook_num(InfoVO.getId(), hos_num, dept_num, doc_id);
				int result = book.delete_book_m(book_num, InfoVO.getId());
				if(result == 1) {
					System.out.println("삭제 성공");
					GUIMain.main(null);
					frame.dispose();
				}else {
					System.out.println("삭제 실패");
				}
			}
		});
		JButton reserve_bt = new JButton();
		reserve_bt.setBounds(285, 168, 36, 26);
		frame.getContentPane().add(reserve_bt);
		reserve_bt.setBorderPainted(false);
		reserve_bt.setFocusPainted(false);
		reserve_bt.setContentAreaFilled(false);
		remove_bt.addActionListener(new ActionListener() { // 익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e) {
				// 예약 창 이동
				frame.dispose();
			}
		});
		frame.getContentPane().add(backgdMain);

	}

}
