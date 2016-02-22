package Gui.user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Gui.authetification.Authentification;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class UserSpace extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSpace frame = new UserSpace();
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
	public UserSpace() {
		setTitle("UserSpace");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGet = new JButton("Birth Certificate");
		btnGet.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGet.setBounds(21, 117, 131, 23);
		contentPane.add(btnGet);
		
		JButton btnDeathCertificate = new JButton("Death Certificate");
		btnDeathCertificate.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDeathCertificate.setBounds(178, 117, 123, 23);
		contentPane.add(btnDeathCertificate);
		
		JButton btnCinCard = new JButton("CIN Card");
		btnCinCard.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnCinCard.setBounds(480, 177, 89, 23);
		contentPane.add(btnCinCard);
		
		JButton btnJob = new JButton("Job");
		btnJob.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnJob.setBounds(480, 117, 89, 23);
		contentPane.add(btnJob);
		
		JButton btnRegestratinACar = new JButton("Registratin a car");
		btnRegestratinACar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnRegestratinACar.setBounds(21, 177, 131, 23);
		contentPane.add(btnRegestratinACar);
		
		JButton btnBilsAndFines = new JButton("Bils and fines");
		btnBilsAndFines.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnBilsAndFines.setBounds(336, 177, 111, 23);
		contentPane.add(btnBilsAndFines);
		
		JButton btnRegitratingForSchool = new JButton("Regitrating for school");
		btnRegitratingForSchool.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnRegitratingForSchool.setBounds(172, 177, 147, 23);
		contentPane.add(btnRegitratingForSchool);
		
		JButton btnReportingCrime = new JButton("Reporting crime");
		btnReportingCrime.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnReportingCrime.setBounds(336, 117, 123, 23);
		contentPane.add(btnReportingCrime);
		
		JButton btnNewButton = new JButton("Sign out");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Authentification().setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(480, 294, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblUserSpace = new JLabel("User Space");
		lblUserSpace.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUserSpace.setBounds(212, 11, 147, 39);
		contentPane.add(lblUserSpace);
	}
}
