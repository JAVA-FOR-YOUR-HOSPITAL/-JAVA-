package Test;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Hostpital_System_Model.InfoVO;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public Test() {
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
		
		JButton btnNewButton = new JButton("healthysoon");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoVO.setId(btnNewButton.getText());
				Date date = new Date();
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.CENTER);
	}

}
