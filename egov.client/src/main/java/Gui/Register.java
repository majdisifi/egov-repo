package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import delegate.UserDelegate;
import egov.entities.User;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;

public class Register {

	private JFrame frame;
	private JTextField job;
	private JTextField lastname;
	private JTextField firstname;
	private JTextField birthPlace;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 774, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("Birth Date");
		label.setBounds(235, 213, 48, 14);
		frame.getContentPane().add(label);


		JDateChooser dato = new JDateChooser();
		job = new JTextField();
		job.setColumns(10);
		job.setBounds(338, 163, 86, 20);
		frame.getContentPane().add(job);

		JLabel label_1 = new JLabel("Job");
		label_1.setBounds(245, 166, 29, 14);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Last Name");
		label_2.setBounds(235, 114, 50, 14);
		frame.getContentPane().add(label_2);

		lastname = new JTextField();
		lastname.setColumns(10);
		lastname.setBounds(338, 111, 86, 20);
		frame.getContentPane().add(lastname);

		firstname = new JTextField();
		firstname.setColumns(10);
		firstname.setBounds(338, 68, 86, 20);
		frame.getContentPane().add(firstname);

		JLabel label_3 = new JLabel("First Name");
		label_3.setBounds(234, 71, 51, 14);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("Creating Account");
		label_4.setFont(new Font("Source Sans Pro ExtraLight", Font.BOLD, 14));
		label_4.setBounds(283, 11, 260, 23);
		frame.getContentPane().add(label_4);

		JButton button = new JButton("Submit");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String n = lastname.getText();
				String f = firstname.getText();
				String j = job.getText();
			
				String p=birthPlace.getText();
				String em=email.getText();
			
				
				
				Date d=dato.getDate();
				
				User user = new User();
				user.setFirstName(f);
				user.setLastName(n);
				user.setJob(j);
				user.setDeathDate(d);
				user.setEmail(em);
				user.setBirthPlace(p);

				UserDelegate.CreateUser(user);
				JOptionPane.showMessageDialog(null, "Added");
			      

			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		button.setBounds(283, 408, 65, 23);
		frame.getContentPane().add(button);

		dato.setBounds(338, 213, 87, 20);
		frame.getContentPane().add(dato);
		
		birthPlace = new JTextField();
		birthPlace.setColumns(10);
		birthPlace.setBounds(338, 287, 86, 20);
		frame.getContentPane().add(birthPlace);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(338, 331, 86, 20);
		frame.getContentPane().add(email);
		
		JLabel lblEmal = new JLabel("E-mal");
		lblEmal.setBounds(237, 334, 46, 14);
		frame.getContentPane().add(lblEmal);
		
		JLabel lblBirthPlace = new JLabel("Birth Place");
		lblBirthPlace.setBounds(225, 289, 58, 17);
		frame.getContentPane().add(lblBirthPlace);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hp dv6\\Desktop\\bureau\\Nouveau dossier (12)\\1.png"));
		lblNewLabel.setBounds(0, 0, 769, 477);
		frame.getContentPane().add(lblNewLabel);
	}
}
