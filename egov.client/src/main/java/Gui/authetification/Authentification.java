package Gui.authetification;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;

import delegate.AuthentificationUserDelegate;
import egov.entities.User;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Authentification extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JTextField pwd;

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
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel.setBounds(104, 43, 185, 25);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(48, 81, 311, 135);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setBounds(10, 31, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblPwd = new JLabel("Pwd");
		lblPwd.setBounds(10, 66, 46, 14);
		panel.add(lblPwd);
		
		login = new JTextField();
		login.setBounds(107, 28, 86, 20);
		panel.add(login);
		login.setColumns(10);
		
		pwd = new JTextField();
		pwd.setBounds(107, 63, 86, 20);
		panel.add(pwd);
		pwd.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User user=AuthentificationUserDelegate.doAuthentificate(login.getText(), pwd.getText());
				if(user!=null){
					
					System.out.println("OK");
				}
			}
		});
		btnNewButton.setBounds(104, 101, 89, 23);
		panel.add(btnNewButton);
	}
}
