package Hostpital_System_View;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Hostpital_System_Model.DoctorDAO;
import Hostpital_System_Model.InfoVO;

public class ReserveProcessDR {

	private JFrame frame;
	private ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ReserveProcessDR window = new ReserveProcessDR();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ReserveProcessDR() {
		initialize();
		Dimension frameSize = frame.getSize();
	    // ����� ũ��
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    // (�����ȭ�� ���� - ������ȭ�� ����) / 2, (�����ȭ�� ���� - ������ȭ�� ����) / 2
	    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int find = InfoVO.getFindIndex();
		if(find == 0) {
			
		}else if(find == 1) {
			
		}else {
			DoctorDAO doc = new DoctorDAO();
			lists = doc.docSearch(InfoVO.getDocname());
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 368, 568);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel backgdMain = new JLabel(new ImageIcon("img/SearchResult.png"));
		backgdMain.setBounds(0, 0, 352, 529);
		frame.getContentPane().setLayout(null);
		
		JButton home_bt = new JButton(new ImageIcon("img/home_bt.png"));
		home_bt.setBounds(150, 5, 60, 60);
		frame.getContentPane().add(home_bt);
		home_bt.setBorderPainted(false);
		home_bt.setFocusPainted(false);
		home_bt.setContentAreaFilled(false);
		home_bt.addActionListener(new ActionListener(){ //�͸�Ŭ������ ������ �ۼ�
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
		mine_bt.addActionListener(new ActionListener(){ //�͸�Ŭ������ ������ �ۼ�
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
		back_bt.addActionListener(new ActionListener(){ //�͸�Ŭ������ ������ �ۼ�
			public void actionPerformed(ActionEvent e){
				ReserveProcess2 RP2 = new ReserveProcess2();
				frame.dispose();
			}
		});
		
		String name[] = {"����", "�����", "�Ƿ���"};
		
		JPanel searchCheck = new JPanel();
		searchCheck.setBounds(25, 93, 70, 30);
		frame.getContentPane().add(searchCheck);
		searchCheck.setLayout(null);
		
		JComboBox group = new JComboBox(name);
		group.setBounds(0, 0, 70, 30);
		group.setForeground(Color.WHITE);
		group.setBackground(new Color(65, 140, 195));
		group.setFont(new Font("���� ���", Font.PLAIN, 12));
		searchCheck.add(group);
		
		
		JButton wantScadule_bt = new JButton();
		wantScadule_bt.setBounds(20, 123, 148, 30);
		frame.getContentPane().add(wantScadule_bt);
		wantScadule_bt.setBorderPainted(false);
		wantScadule_bt.setFocusPainted(false);
		wantScadule_bt.setContentAreaFilled(false);
		wantScadule_bt.addActionListener(new ActionListener(){ //�͸�Ŭ������ ������ �ۼ�
			public void actionPerformed(ActionEvent e){
				ReserveProcess3S wantS = new ReserveProcess3S();
				frame.dispose();
			}
		});
		
		ImageIcon list[] = new ImageIcon[3];
		for(int i= 0; i<list.length; i++) {
			list[i] = new ImageIcon("img/doc"+i+"_bt.png");
		}
		
		//�̸��̶� �װŸ� ���������� �������� �׸� �ٸ��� �ֱ� �Ȱ��� ������ �޾ƿ��� ������ �ϱ�
		JList imageList = new JList(list);
		imageList.setSize(312, 700);
		JScrollPane scrollPage = new JScrollPane(imageList);
		scrollPage.setBounds(18, 154, 330, 250);
		
		frame.getContentPane().add(scrollPage);
		scrollPage.setBorder(null); //��ũ�� �׵θ� ���ֱ�
		scrollPage.setBackground(new Color(65, 140, 195));
		
		JButton next_bt = new JButton();
		next_bt.setBounds(130, 450, 80, 30);
		frame.getContentPane().add(next_bt);
		next_bt.setBorderPainted(false);
		next_bt.setFocusPainted(false);
		next_bt.setContentAreaFilled(false);
		next_bt.addActionListener(new ActionListener(){ //�͸�Ŭ������ ������ �ۼ�
			public void actionPerformed(ActionEvent e){
				int result = imageList.getSelectedIndex();
				switch(result) {
				case -1:
					JOptionPane.showMessageDialog(null, "������ �ȵǾ����ϴ�.");
					break;
				case 0:
					InfoVO.setHosname(lists.get(0).get(0));
					InfoVO.setDeptname(lists.get(0).get(1));
					InfoVO.setDocname(lists.get(0).get(2));
					ReserveProcess3sT RP1 = new ReserveProcess3sT();
					break;
				case 1:
					InfoVO.setHosname(lists.get(1).get(0));
					InfoVO.setDeptname(lists.get(1).get(1));
					InfoVO.setDocname(lists.get(1).get(2));
					ReserveProcess3sT RP2 = new ReserveProcess3sT();
					break;
				case 2:
					InfoVO.setHosname(lists.get(2).get(0));
					InfoVO.setDeptname(lists.get(2).get(1));
					InfoVO.setDocname(lists.get(2).get(2));
					ReserveProcess3sT RP3 = new ReserveProcess3sT();
					break;
				}
				
			}
		});
		
		frame.getContentPane().add(backgdMain);
		
		
	}

}
