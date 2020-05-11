package Test;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Hostpital_System_Model.InfoVO;

import javax.swing.JButton;
import java.awt.BorderLayout;

public class Check {

	private JFrame frame;


	/**
	 * Create the application.
	 */
	public Check() {
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
		
		JButton btnNewButton = new JButton("\uC131\uACF5");
		btnNewButton.setText(InfoVO.getId()+" "+InfoVO.getHosname()+" "+InfoVO.getDeptname()+" "+InfoVO.getDocname()+" "+InfoVO.getDate()+" "+InfoVO.getTime());
		frame.getContentPane().add(btnNewButton, BorderLayout.NORTH);
	}

}
