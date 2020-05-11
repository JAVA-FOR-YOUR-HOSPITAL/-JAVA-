package Hostpital_System_View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Hostpital_System_Model.DoctorDAO;
import Hostpital_System_Model.InfoVO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ReserveProcess3sT {

	private JFrame frame;
	private String date = "";
	private String time = "";
	
	/**
	 * Create the application.
	 */
	public ReserveProcess3sT() {
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
		
		JLabel backgdMain = new JLabel(new ImageIcon("img/PopUp.png"));
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
				InfoVO.setDocname("");
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
				ReserveProcess3S RP3S = new ReserveProcess3S();
				frame.dispose();
			}
		});
		
		
		JButton next_bt = new JButton();
		next_bt.setBounds(130, 450, 80, 30);
		frame.getContentPane().add(next_bt);
		next_bt.setBorderPainted(false);
		next_bt.setFocusPainted(false);
		next_bt.setContentAreaFilled(false);
		next_bt.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				if(date.equals("")&&time.equals("")) {
					JOptionPane.showMessageDialog(null, "시간을 선택해주세요.");
				}else {
					int result = JOptionPane.showConfirmDialog(null, "예약하시겠습니까?","확인",JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.YES_OPTION) {
						InfoVO.setDate(date);
						InfoVO.setTime(time);
						CertifiedPopUp ce = new CertifiedPopUp();
						frame.dispose();
					}
				}

			}
		});		
		JLabel dTime1 = new JLabel();
		dTime1.setHorizontalAlignment(SwingConstants.LEFT);
		dTime1.setFont(new Font("12롯데마트드림Light", Font.BOLD, 16));
		
		dTime1.setBounds(64, 196, 157, 43);
		frame.getContentPane().add(dTime1);
		
		JLabel dTime1_2 = new JLabel("");
		dTime1_2.setFont(new Font("12롯데마트드림Light", Font.BOLD, 16));
		dTime1_2.setBounds(226, 196, 95, 43);
		frame.getContentPane().add(dTime1_2);
		
		JLabel dTime2 = new JLabel("");
		dTime2.setHorizontalAlignment(SwingConstants.LEFT);
		dTime2.setFont(new Font("12롯데마트드림Light", Font.BOLD, 16));
		dTime2.setBounds(64, 249, 157, 43);
		frame.getContentPane().add(dTime2);
		
		JLabel dTime2_2 = new JLabel("");
		dTime2_2.setFont(new Font("12롯데마트드림Light", Font.BOLD, 16));
		dTime2_2.setBounds(226, 249, 95, 43);
		frame.getContentPane().add(dTime2_2);
		
		JLabel dTime3 = new JLabel("");
		dTime3.setHorizontalAlignment(SwingConstants.LEFT);
		dTime3.setFont(new Font("12롯데마트드림Light", Font.BOLD, 16));
		dTime3.setBounds(64, 299, 157, 43);
		frame.getContentPane().add(dTime3);
		
		
		JLabel dTime3_2 = new JLabel("");
		dTime3_2.setFont(new Font("12롯데마트드림Light", Font.BOLD, 16));
		dTime3_2.setBounds(226, 302, 95, 40);
		frame.getContentPane().add(dTime3_2);
		
		dTime1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dTime1.setForeground(new Color(64, 140, 195));
				dTime2.setForeground(new Color(0, 0, 0));
				dTime3.setForeground(new Color(0, 0, 0));
				InfoVO.setDocname(dTime1_2.getText());
				String[] str = dTime1.getText().split(" ");
				date = str[0];
				time = str[1];
			}
		});
		
		dTime2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dTime1.setForeground(new Color(0, 0, 0));
				dTime2.setForeground(new Color(64, 140, 195));
				dTime3.setForeground(new Color(0, 0, 0));
				InfoVO.setDocname(dTime2_2.getText());
				String[] str = dTime2.getText().split(" ");
				date = str[0];
				time = str[1];
			}
		});
		
		dTime3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dTime1.setForeground(new Color(0, 0, 0));
				dTime2.setForeground(new Color(0, 0, 0));
				dTime3.setForeground(new Color(64, 140, 195));
				String[] str = dTime3.getText().split(" ");
				InfoVO.setDocname(dTime3_2.getText());
				date = str[0];
				time = str[1];
			}
		});
		String[] time1 = {"2020-01-27 10:30","2020-01-28 11:00","2020-01-30 15:00"};
		String[] time2 = {"2020-01-31 14:30","2020-01-31 11:00","2020-01-31 15:30"};
		
		DoctorDAO doc = new DoctorDAO();
		if(InfoVO.getDocname().equals("")) {
			ArrayList<String> d_list = doc.docSearch(InfoVO.getHosname(), InfoVO.getDeptname());
			dTime1.setText(time2[0]);
			dTime1_2.setText(d_list.get(0));
			dTime2.setText(time2[1]);
			dTime2_2.setText(d_list.get(2));
			dTime3.setText(time2[2]);
			dTime3_2.setText(d_list.get(2));
		}else {
			dTime1.setText(time1[0]);
			dTime1_2.setText(InfoVO.getDocname());
			dTime2.setText(time1[1]);
			dTime2_2.setText(InfoVO.getDocname());
			dTime3.setText(time1[2]);
			dTime3_2.setText(InfoVO.getDocname());
		}

		frame.getContentPane().add(backgdMain);
		
		
	}

}
