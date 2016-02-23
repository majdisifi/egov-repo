package Gui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Gui.ManageCar;
import Gui.ManageUser;
import Gui.RequestTreatment;
import Gui.authetification.Authentification;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

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
		setBounds(100, 100, 710, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSignOut = new JButton("Sign out");
		btnSignOut.setIcon(new ImageIcon("C:\\Users\\HP\\git\\egov-repo\\egov.client\\src\\main\\java\\images\\Previous.gif"));
		btnSignOut.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Authentification().setVisible(true);
				setVisible(false);
			}
		});
		btnSignOut.setBounds(571, 294, 113, 33);
		contentPane.add(btnSignOut);
		
		JLabel lblAdminSpace = new JLabel("Admin Space");
		lblAdminSpace.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAdminSpace.setBounds(261, 48, 122, 23);
		contentPane.add(lblAdminSpace);
		
		JButton btnManageCars = new JButton("Manage Cars");
		btnManageCars.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnManageCars.setIcon(null);
		btnManageCars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ManageCar().setVisible(true);
				setVisible(false);
				
			}
		});
		btnManageCars.setBounds(39, 157, 126, 23);
		contentPane.add(btnManageCars);
		
		JButton btnManageAccount = new JButton("Manage account");
		btnManageAccount.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnManageAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnManageAccount.setBounds(175, 157, 148, 23);
		contentPane.add(btnManageAccount);
		
		JButton btnManagerCin = new JButton("Manage Cin");
		btnManagerCin.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnManagerCin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new RequestTreatment().setVisible(true);
				setVisible(false);
			}
		});
		btnManagerCin.setBounds(333, 157, 124, 23);
		contentPane.add(btnManagerCin);
		
		JButton btnManager = new JButton("Manager ");
		btnManager.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnManager.setBounds(467, 157, 102, 23);
		contentPane.add(btnManager);
	}
}
