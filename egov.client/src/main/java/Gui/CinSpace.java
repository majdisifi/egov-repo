package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Gui.user.UserSpace;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CinSpace extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CinSpace frame = new CinSpace();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CinSpace() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRequestToApply = new JButton("request to apply for a cin ");
		btnRequestToApply.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRequestToApply.setBounds(32, 119, 189, 42);
		contentPane.add(btnRequestToApply);
		
		JButton btnRenewACin = new JButton("Renew a cin");
		btnRenewACin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnRenewACin.setBounds(231, 119, 162, 42);
		contentPane.add(btnRenewACin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new UserSpace().setVisible(true);
				setVisible(false);
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCancel.setBounds(335, 228, 89, 23);
		contentPane.add(btnCancel);
	}
}
