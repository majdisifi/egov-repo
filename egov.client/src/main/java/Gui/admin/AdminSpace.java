package Gui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Gui.authetification.Authentification;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class AdminSpace extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSpace frame = new AdminSpace();
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
	public AdminSpace() {
		setFont(new Font("Dialog", Font.ITALIC, 20));
		setTitle("Admin Space");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSignOut = new JButton("Sign out");
		btnSignOut.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Authentification().setVisible(true);
				setVisible(false);
			}
		});
		btnSignOut.setBounds(335, 228, 89, 23);
		contentPane.add(btnSignOut);
		
		JLabel lblAdminSpace = new JLabel("Admin Space");
		lblAdminSpace.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAdminSpace.setBounds(130, 21, 122, 23);
		contentPane.add(lblAdminSpace);
	}

}
