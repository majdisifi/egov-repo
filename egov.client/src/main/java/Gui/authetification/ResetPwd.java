package Gui.authetification;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SendMail.SendMail;
import delegate.UserDelegate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.mail.MessagingException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResetPwd extends JFrame {

	private JPanel contentPane;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResetPwd frame = new ResetPwd();
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
	public ResetPwd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResetYourPassword = new JLabel("Reset your password");
		lblResetYourPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblResetYourPassword.setBounds(106, 36, 248, 32);
		contentPane.add(lblResetYourPassword);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblEmail.setBounds(66, 110, 69, 14);
		contentPane.add(lblEmail);
		
		email = new JTextField();
		email.setBounds(152, 109, 174, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String email_user= email.getText();
				String password= UserDelegate.getProxy().findpwd(email_user);
				SendMail sm= new SendMail(email_user,password );
				try {
					sm.send();
					JOptionPane.showConfirmDialog(null, "Mail send ! consult your mail");
				
					
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSend.setBounds(155, 168, 89, 23);
		contentPane.add(btnSend);
		
		JButton btnRetour = new JButton("retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new Authentification().setVisible(true);
				setVisible(false);
			}
		});
		btnRetour.setBounds(66, 168, 89, 23);
		contentPane.add(btnRetour);
	}
}
