package Test;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Hostpital_System_Model.InfoVO;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView {

	private JFrame frame;
	private String name;
	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn2 = new JButton("\uAE40\uC131\uC9C4");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(name);
			}
		});
		frame.getContentPane().add(btn2, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("\uC774\uB825");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.CENTER);
		
		JButton btnNewButton_1 = new JButton("\uC804\uBB38\uBD84\uC57C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton_1, BorderLayout.EAST);
		
		JButton btnNewButton_2 = new JButton("\uC608\uC57D\uD558\uAE30");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(InfoVO.getDocname());
				System.out.println(InfoVO.getDeptname());
				System.out.println(InfoVO.getHosname());
				Test test = new Test();
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton_2, BorderLayout.SOUTH);
	}

}
