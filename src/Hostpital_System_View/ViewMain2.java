package Hostpital_System_View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import Hostpital_System_Model.Book_markDAO;
import Hostpital_System_Model.DeptDAO;
import Hostpital_System_Model.DoctorDAO;
import Hostpital_System_Model.HospitalDAO;
import Hostpital_System_Model.InfoVO;
import Hostpital_System_Model.ReservationDAO;

import java.awt.Font;

public class ViewMain2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMain2 window = new ViewMain2();
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
	public ViewMain2() {
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
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 368, 565);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel backgdMain = new JLabel(new ImageIcon("img/ViewMain2.png"));
		backgdMain.setBounds(0, 0, 352, 526);
		frame.getContentPane().setLayout(null);

		JButton home_bt = new JButton(new ImageIcon("img/home_bt.png"));
		home_bt.setBounds(150, 5, 60, 60);
		frame.getContentPane().add(home_bt);
		home_bt.setBorderPainted(false);
		home_bt.setFocusPainted(false);
		home_bt.setContentAreaFilled(false);
		
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

		
		JButton nowDay = new JButton();
		nowDay.setBounds(30, 110, 95, 23);
		frame.getContentPane().add(nowDay);
		nowDay.setBorderPainted(false);
		nowDay.setFocusPainted(false);
		nowDay.setContentAreaFilled(false);
		nowDay.addActionListener(new ActionListener() { // 익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e) {
				ViewMain vm = new ViewMain();
				frame.dispose();
			}
		});
		
		JLabel startDay = new JLabel("");
		startDay.setFont(new Font("12롯데마트드림Medium", Font.PLAIN, 13));
		startDay.setBounds(60, 160, 95, 15);
		frame.getContentPane().add(startDay);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date(System.currentTimeMillis()));
		String toDay = new java.text.SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		startDay.setText(toDay);
		
		JLabel finalDay = new JLabel("");
		finalDay.setFont(new Font("12롯데마트드림Medium", Font.PLAIN, 13));
		finalDay.setBounds(210, 160, 78, 15);
		frame.getContentPane().add(finalDay);
		cal.add(Calendar.DATE, 31);
		String day = new java.text.SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		finalDay.setText(day);

		JLabel reserveDay = new JLabel("");
		reserveDay.setFont(new Font("12롯데마트드림Medium", Font.PLAIN, 12));
		reserveDay.setBounds(90, 216, 120, 15);
		frame.getContentPane().add(reserveDay);
		
		JLabel hosN = new JLabel("");
		hosN.setFont(new Font("12롯데마트드림Medium", Font.PLAIN, 12));
		hosN.setBounds(90, 240, 120, 15);
		frame.getContentPane().add(hosN);
		
		JLabel depN = new JLabel("");
		depN.setFont(new Font("12롯데마트드림Medium", Font.PLAIN, 12));
		depN.setBounds(90, 264, 120, 15);
		frame.getContentPane().add(depN);
		
		JLabel docN = new JLabel("");
		docN.setFont(new Font("12롯데마트드림Medium", Font.PLAIN, 12));
		docN.setBounds(90, 288, 120, 15);
		frame.getContentPane().add(docN);
		
		
		
		JLabel reserveDay2 = new JLabel("");
		reserveDay2.setFont(new Font("12롯데마트드림Medium", Font.PLAIN, 12));
		reserveDay2.setBounds(90, 339, 120, 15);
		frame.getContentPane().add(reserveDay2);
		
		JLabel hosN2 = new JLabel("");
		hosN2.setFont(new Font("12롯데마트드림Medium", Font.PLAIN, 12));
		hosN2.setBounds(90, 363, 120, 15);
		frame.getContentPane().add(hosN2);
		
		JLabel depN2 = new JLabel("");
		depN2.setFont(new Font("12롯데마트드림Medium", Font.PLAIN, 12));
		depN2.setBounds(90, 386, 120, 15);
		frame.getContentPane().add(depN2);
		
		JLabel docN2 = new JLabel("");
		docN2.setFont(new Font("12롯데마트드림Medium", Font.PLAIN, 12));
		docN2.setBounds(90, 410, 120, 15);
		frame.getContentPane().add(docN2);
		ReservationDAO dao = new ReservationDAO();
		list = dao.showRes_mon(InfoVO.getId());
		
		if(list == null) {
			System.out.println("예약이 없습니다.");
		}else {
			for(int i = 0; i < list.size(); i++) {
				if(i == 0) {
					reserveDay.setText(list.get(i).get(3));
					hosN.setText(list.get(i).get(0));
					depN.setText(list.get(i).get(1));
					docN.setText(list.get(i).get(2));
				}else {
					reserveDay2.setText(list.get(i).get(3));
					hosN2.setText(list.get(i).get(0));
					depN2.setText(list.get(i).get(1));
					docN2.setText(list.get(i).get(2));
				}
			}
		}
		
		JRadioButton bookSelect_bt = new JRadioButton();
		
		bookSelect_bt.setOpaque(false);
		bookSelect_bt.setIcon(new ImageIcon("img/bookCheck_bt1.png"));
		bookSelect_bt.setBounds(290, 190, 37, 37);
		bookSelect_bt.setSelectedIcon(new ImageIcon("img/bookCheck_bt2.png"));
		frame.getContentPane().add(bookSelect_bt);
		
		JRadioButton bookSelect2_bt = new JRadioButton();
		bookSelect2_bt.setSelectedIcon(new ImageIcon("img/bookCheck_bt2.png"));
		bookSelect2_bt.setOpaque(false);
		bookSelect2_bt.setIcon(new ImageIcon("img/bookCheck_bt1.png"));
		bookSelect2_bt.setBounds(290, 317, 37, 37);
		frame.getContentPane().add(bookSelect2_bt);
		
		home_bt.addActionListener(new ActionListener() { // 익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e) {
				if(bookSelect_bt.isSelected() == true) {
					HospitalDAO hos = new HospitalDAO();
					int hos_num = hos.getHos_num(hosN.getText());
					DeptDAO dept = new DeptDAO();
					int dept_num = dept.getDept_num(hos_num, depN.getText());
					DoctorDAO doc = new DoctorDAO();
					String doc_id = doc.getDoc_id(hos_num, dept_num, docN.getText());
					Book_markDAO dao = new Book_markDAO();
					int result = dao.book_mark(InfoVO.getId(), hos_num, dept_num, doc_id);
					if(result == 1) {
						System.out.println("삽입 성공");
					}
				}
				if(bookSelect2_bt.isSelected() == true) {
					HospitalDAO hos = new HospitalDAO();
					int hos_num = hos.getHos_num(hosN2.getText());
					DeptDAO dept = new DeptDAO();
					int dept_num = dept.getDept_num(hos_num, depN2.getText());
					DoctorDAO doc = new DoctorDAO();
					String doc_id = doc.getDoc_id(hos_num, dept_num, docN2.getText());
					Book_markDAO dao = new Book_markDAO();
					int result = dao.book_mark(InfoVO.getId(), hos_num, dept_num, doc_id);
					if(result == 1) {
						System.out.println("삽입 성공");
					}
				}
				GUIMain.main(null);
				frame.dispose();
			}
		});
		JButton cancel = new JButton(new ImageIcon("img/cancel2.png"));
		cancel.setBounds(250, 280, 66, 23);
		frame.getContentPane().add(cancel);
		cancel.setBorderPainted(false);
		cancel.setFocusPainted(false);
		cancel.setContentAreaFilled(false);
		cancel.addActionListener(new ActionListener() { // 익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e) {
				ViewMain2 vm2 = new ViewMain2();
				frame.dispose();
			}
		});
		
		JButton cancel2 = new JButton(new ImageIcon("img/cancel2.png"));
		cancel2.setBounds(250, 404, 66, 23);
		frame.getContentPane().add(cancel2);
		cancel2.setBorderPainted(false);
		cancel2.setFocusPainted(false);
		cancel2.setContentAreaFilled(false);
		cancel2.addActionListener(new ActionListener() { // 익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e) {
				ViewMain2 vm3 = new ViewMain2();
				frame.dispose();
			}
		});

		
		frame.getContentPane().add(backgdMain);
		
		

	}
}
