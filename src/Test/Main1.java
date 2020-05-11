package Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Hostpital_System_Model.InfoVO;

public class Main1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main1 window = new Main1();
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
	public Main1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("\uAE40\uC131\uC9C4 \uD53C\uBD80\uACFC \uC804\uB0A8\uB300\uD559\uAD50\uBCD1\uC6D0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] str = btnNewButton.getText().split(" ");
				InfoVO.setDocname(str[0]);
				InfoVO.setDeptname(str[1]);
				InfoVO.setHosname(str[2]);
				MainView main = new MainView();
				frame.dispose();				
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.WEST);
		
		JButton btnNewButton_1 = new JButton("\uAE40\uC131\uC9C4 \uAC74\uAC15\uC758\uD559\uACFC \uC804\uB0A8\uB300\uD559\uAD50\uBCD1\uC6D0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().add(btnNewButton_1, BorderLayout.CENTER);
	}

}
