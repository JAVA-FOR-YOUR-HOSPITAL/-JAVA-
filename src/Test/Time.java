package Test;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Hostpital_System_Model.InfoVO;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Time {

	JFrame frame;

	/**
	 * Create the application.
	 */
	public Time() {
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
		
		JButton btnNewButton = new JButton("\uC6D0\uD558\uB294 \uB0A0\uC9DC");
		frame.getContentPane().add(btnNewButton, BorderLayout.NORTH);
		
		
		JButton btnNewButton_1 = new JButton("2020-01-20");
		frame.getContentPane().add(btnNewButton_1, BorderLayout.WEST);
		
		JButton btnNewButton_2 = new JButton("17:00");
		frame.getContentPane().add(btnNewButton_2, BorderLayout.CENTER);
		
		JButton btnNewButton_3 = new JButton("±è¼ºÁø");
		frame.getContentPane().add(btnNewButton_3, BorderLayout.EAST);
		
		JButton button = new JButton("\uC608\uC57D\uD558\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoVO.setDate(btnNewButton_1.getText());
				InfoVO.setTime(btnNewButton_2.getText());
				InfoVO.setDocname(btnNewButton_3.getText());
				Cert cert = new Cert();
				frame.dispose();
			}
		});
		frame.getContentPane().add(button, BorderLayout.SOUTH);
	}

}
