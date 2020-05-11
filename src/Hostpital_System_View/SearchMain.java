package Hostpital_System_View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Hostpital_System_Model.DeptDAO;
import Hostpital_System_Model.DoctorDAO;
import Hostpital_System_Model.HospitalDAO;
import Hostpital_System_Model.HospitalDTO;
import Hostpital_System_Model.InfoVO;

import java.awt.Color;
import java.awt.Dimension;

public class SearchMain {

	private JFrame frame;
	private JTextField searchTextField;

	
	/**
	 * Create the application.
	 */
	public SearchMain() {
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
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("img/SearchMain.png"));
		lblNewLabel.setBounds(0, 0, 352, 526);
		
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
		
		searchTextField = new JTextField();
		searchTextField.setHorizontalAlignment(SwingConstants.CENTER);
		searchTextField.setFont(new Font("12롯데마트드림Medium", Font.PLAIN, 14));
		searchTextField.setBounds(92, 97, 188, 22);
		frame.getContentPane().add(searchTextField);
		searchTextField.setColumns(20);
		searchTextField.setOpaque(false);
		searchTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		//체크 넣기
		String name[] = {"병원", "진료과", "의료진"};
		
		JPanel searchCheck = new JPanel();
		searchCheck.setBounds(25, 93, 70, 30);
		frame.getContentPane().add(searchCheck);
		searchCheck.setLayout(null);
		
		JComboBox group = new JComboBox(name);
		group.setBounds(0, 0, 70, 30);
		group.setForeground(Color.WHITE);
		group.setBackground(new Color(65, 140, 195));
		group.setFont(new Font("12롯데마트드림Medium", Font.PLAIN, 13));
		searchCheck.add(group);
		
		JButton search_bt2 = new JButton();
		search_bt2.setBounds(290, 92, 35, 35);
		frame.getContentPane().add(search_bt2);
		search_bt2.setBorderPainted(false);
		search_bt2.setFocusPainted(false);
		search_bt2.setContentAreaFilled(false);
		search_bt2.addActionListener(new ActionListener(){ //익명클래스로 리스너 작성
			public void actionPerformed(ActionEvent e){
				String search = group.getSelectedItem().toString();
				String name = searchTextField.getText();
				if(search.equals("병원")) {
					InfoVO.setFindIndex(0);
					HospitalDAO hos = new HospitalDAO();
					ArrayList<HospitalDTO> hos_info = hos.partSearch(name);
					if(hos_info == null) {
						System.out.println("병원 이름에 해당하는 목록이 없습니다.");
					}else {
						for(HospitalDTO dto : hos_info) {
							System.out.println(dto.getHos_name());
						}
					}
				}else if(search.equals("진료과")) {
					InfoVO.setFindIndex(1);
					DeptDAO dept = new DeptDAO();
					ArrayList<ArrayList<String>> dept_info = dept.dept_Search(name);
					if(dept_info == null) {
						System.out.println("진료과 이름에 해당하는 목록이 없습니다.");
					}else {
						for(ArrayList<String> list : dept_info) {
							System.out.println(list.get(0)+"\t"+list.get(1));
//							System.out.println(list.get(1));
						}						
					}
				}else if(search.equals("의료진")) {
					InfoVO.setFindIndex(2);
					DoctorDAO doc = new DoctorDAO();
					ArrayList<ArrayList<String>> doc_info = doc.docSearch(name);
					InfoVO.setDocname(name);
					if(doc_info == null) {
						System.out.println("의료진 이름에 해당하는 목록이 없습니다.");
					}else {
						ReserveProcessDR mp = new ReserveProcessDR();
						frame.dispose();
						for(ArrayList<String> list : doc_info) {
							System.out.println(list.get(0)+"\t"+list.get(1)+"\t"+list.get(2));
//							System.out.println(list.get(1));
//							System.out.println(list.get(2));
						}						
					}
				}
			}
		});
	
		frame.getContentPane().add(lblNewLabel);

	}
}
