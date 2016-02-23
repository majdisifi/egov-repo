package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateCinSpace extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateCinSpace frame = new CreateCinSpace();
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
	public CreateCinSpace() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCinRequest = new JLabel("Cin Request");
		lblCinRequest.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCinRequest.setBounds(215, 36, 136, 46);
		contentPane.add(lblCinRequest);
		
		JLabel lblImportAPicture = new JLabel("Import a picture :");
		lblImportAPicture.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblImportAPicture.setBounds(165, 139, 114, 38);
		contentPane.add(lblImportAPicture);
		
		JLabel lblImportAcertificateOf = new JLabel("Import aCertificate of status of residence :");
		lblImportAcertificateOf.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblImportAcertificateOf.setBounds(40, 188, 254, 28);
		contentPane.add(lblImportAcertificateOf);
		
		JLabel lblImport = new JLabel(" Import bearth certificate :");
		lblImport.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblImport.setBounds(121, 236, 160, 38);
		contentPane.add(lblImport);
		
		textField = new JTextField();
		textField.setBounds(304, 149, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(304, 193, 130, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(304, 246, 130, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSend.setBounds(304, 309, 89, 23);
		contentPane.add(btnSend);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CinSpace().setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(190, 310, 89, 23);
		contentPane.add(btnNewButton);
	}

}
