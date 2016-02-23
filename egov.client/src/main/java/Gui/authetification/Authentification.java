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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

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
		setBounds(100, 100, 573, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Authentification");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(148, 23, 185, 25);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(59, 81, 395, 193);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Login :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(78, 27, 60, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblPwd = new JLabel("Pwd :");
		lblPwd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPwd.setBounds(78, 66, 60, 17);
		panel.add(lblPwd);
		
		login = new JTextField();
		login.setBounds(161, 31, 152, 20);
		panel.add(login);
		login.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\HP\\git\\egov-repo\\egov.client\\src\\main\\java\\images\\OK.gif"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User user=AuthentificationUserDelegate.doAuthentificate(login.getText(), new String(pwd.getPassword()));
				
				if(user!=null){
					
					if(user instanceof Admin)
					{
						JOptionPane.showMessageDialog(null, "Welcome Admin");
						new AdminSpace().setVisible(true);
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Welcome Sir/Mme "+user.getFirstName());
						new UserSpace().setVisible(true);
					}
					
					setVisible(false);
					
					
				}
				else {
					
					JOptionPane.showMessageDialog(rootPane	, "enter your login and password please", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(187, 138, 112, 34);
		panel.add(btnNewButton);
		
		pwd = new JPasswordField();
		pwd.setBounds(161, 66, 152, 20);
		panel.add(pwd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon("C:\\Users\\HP\\git\\egov-repo\\egov.client\\src\\main\\java\\images\\Close.gif"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCancel.setBounds(49, 139, 128, 33);
		panel.add(btnCancel);
		
		JLabel lblForgetPassword = new JLabel("Forget password ?");
		lblForgetPassword.setForeground(Color.BLUE);
		lblForgetPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				new ResetPwd().setVisible(true);
				setVisible(false);
			}
		});
		lblForgetPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblForgetPassword.setBounds(106, 94, 128, 31);
		panel.add(lblForgetPassword);
	}
}
