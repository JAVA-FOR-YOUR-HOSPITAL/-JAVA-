package Test;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Hostpital_System_Model.InfoVO;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Date {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public Date() {
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
		
		JButton btnNewButton = new JButton("2020-01-19");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.CENTER);
		
		JButton btnNewButton_1 = new JButton("18:00");
		frame.getContentPane().add(btnNewButton_1, BorderLayout.EAST);
		
		JButton btnNewButton_2 = new JButton("\uC608\uC57D\uD558\uAE30");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoVO.setDate(btnNewButton.getText());
				InfoVO.setTime(btnNewButton_1.getText());
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton_2, BorderLayout.SOUTH);
		
		JButton btnNewButton_3 = new JButton("\uC6D0\uD558\uB294 \uC758\uB8CC\uC9C4");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(InfoVO.getId());
				Time time = new Time();
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton_3, BorderLayout.WEST);
	}

}
