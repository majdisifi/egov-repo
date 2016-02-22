package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import delegate.UserDelegate;
import egov.entities.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;

public class RegisterUser extends JFrame {

	private JPanel contentPane;
	private JTextField gender;
	private JTextField birthPlace;
	private JTextField job;
	private JTextField lastName;
	private JTextField firstName;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField email;
	private JLabel lblMail;
	JDateChooser dato = new JDateChooser();
	private JLabel lblCreatingAccount;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUser frame = new RegisterUser();
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
	public RegisterUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(330, 300, 86, 20);
		contentPane.add(gender);
		
		birthPlace = new JTextField();
		birthPlace.setColumns(10);
		birthPlace.setBounds(330, 231, 86, 20);
		contentPane.add(birthPlace);
		
		job = new JTextField();
		job.setColumns(10);
		job.setBounds(330, 144, 86, 20);
		contentPane.add(job);
		JDateChooser dato = new JDateChooser();	
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(330, 99, 86, 20);
		contentPane.add(lastName);
		
		firstName = new JTextField();
		firstName.setColumns(10);
		firstName.setBounds(330, 52, 86, 20);
		contentPane.add(firstName);
		
		JButton button = new JButton("Submit");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String n = lastName.getText();
				String f = firstName.getText();
				String j = job.getText();

				String p = birthPlace.getText();
				String em = email.getText();
				String g = gender.getText();
				// String np=pere.getText();
				// String nm=mere.getText();

				Date d = dato.getDate();

				User user = new User();
				user.setFirstName(f);
				user.setLastName(n);
				user.setJob(j);
				user.setBirthDate(d);
				user.setEmail(em);
				user.setBirthPlace(p);
				user.setGender(g);
				// user.setBirthPlace(np);
				// user.setBirthPlace(nm);

				
				UserDelegate.CreateUser(user);
				JOptionPane.showMessageDialog(null, "Thank you for your Registration , you should Wait verification of your account");
				ListUser frame = new ListUser();
		        frame.setVisible(true);
			
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
			}
		});
		button.setBounds(292, 331, 89, 23);
		contentPane.add(button);
		

		dato.setBounds(330, 189, 87, 20);
		contentPane.add(dato);
		
		label = new JLabel("First Name");
		label.setBounds(212, 55, 51, 14);
		contentPane.add(label);
		
		label_1 = new JLabel("Last Name");
		label_1.setBounds(213, 102, 50, 14);
		contentPane.add(label_1);
		
		label_2 = new JLabel("Job");
		label_2.setBounds(234, 147, 29, 14);
		contentPane.add(label_2);
		
		label_3 = new JLabel("Birth Date");
		label_3.setBounds(215, 195, 48, 14);
		contentPane.add(label_3);
		
		label_4 = new JLabel("Birth Place");
		label_4.setBounds(212, 233, 58, 17);
		contentPane.add(label_4);
		
		label_5 = new JLabel("gender");
		label_5.setBounds(217, 303, 46, 14);
		contentPane.add(label_5);
		
		email = new JTextField();
		email.setBounds(330, 269, 86, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		lblMail = new JLabel("Mail");
		lblMail.setBounds(227, 272, 46, 14);
		contentPane.add(lblMail);
		
		lblCreatingAccount = new JLabel("Creating Account");
		lblCreatingAccount.setBounds(275, 11, 126, 30);
		contentPane.add(lblCreatingAccount);
		
		comboBox = new JComboBox();
		comboBox.addItem("Male");
		comboBox.addItem("Female");

		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				
			}
		});
		comboBox.setBounds(57, 31, 70, 20);
		contentPane.add(comboBox);
	}
}
