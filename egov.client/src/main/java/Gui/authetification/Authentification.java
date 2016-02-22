package Gui.authetification;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;

import Gui.admin.AdminSpace;
import Gui.user.UserSpace;
import delegate.AuthentificationUserDelegate;
import egov.entities.Admin;
import egov.entities.User;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Authentification extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
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
	public Authentification() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Authentification");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(129, 22, 185, 25);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(48, 81, 355, 170);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Login :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(25, 27, 60, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblPwd = new JLabel("Pwd :");
		lblPwd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPwd.setBounds(25, 66, 60, 17);
		panel.add(lblPwd);
		
		login = new JTextField();
		login.setBounds(108, 31, 152, 20);
		panel.add(login);
		login.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User user=AuthentificationUserDelegate.doAuthentificate(login.getText(), new String(pwd.getPassword()));
				
				if(user!=null){
					
					if(user instanceof Admin)
					{
						new AdminSpace().setVisible(true);
					}
					else 
					{
						new UserSpace().setVisible(true);
					}
					
					setVisible(false);
					
					
				}
				else {
					
					JOptionPane.showMessageDialog(rootPane	, "enter your login and password please", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(108, 97, 89, 24);
		panel.add(btnNewButton);
		
		pwd = new JPasswordField();
		pwd.setBounds(108, 66, 152, 20);
		panel.add(pwd);
		
		JButton btnForgotPassword = new JButton("Forgot password");
		btnForgotPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ResetPwd().setVisible(true);
				setVisible(false);
			}
		});
		btnForgotPassword.setBounds(182, 136, 152, 23);
		panel.add(btnForgotPassword);
	}
}
