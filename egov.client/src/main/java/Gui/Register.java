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

public class Register {

	private JFrame frame;
	private JTextField date;
	private JTextField job;
	private JTextField lastname;
	private JTextField firstname;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Birth Date");
		label.setBounds(89, 166, 48, 14);
		frame.getContentPane().add(label);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(175, 163, 86, 20);
		frame.getContentPane().add(date);
		
		job = new JTextField();
		job.setColumns(10);
		job.setBounds(175, 132, 86, 20);
		frame.getContentPane().add(job);
		
		JLabel label_1 = new JLabel("Job");
		label_1.setBounds(108, 135, 29, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Last Name");
		label_2.setBounds(87, 104, 50, 14);
		frame.getContentPane().add(label_2);
		
		lastname = new JTextField();
		lastname.setColumns(10);
		lastname.setBounds(175, 101, 86, 20);
		frame.getContentPane().add(lastname);
		
		firstname = new JTextField();
		firstname.setColumns(10);
		firstname.setBounds(175, 63, 86, 20);
		frame.getContentPane().add(firstname);
		
		JLabel label_3 = new JLabel("First Name");
		label_3.setBounds(86, 66, 51, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Creating Account");
		label_4.setFont(new Font("Source Sans Pro ExtraLight", Font.BOLD, 14));
		label_4.setBounds(138, 11, 260, 23);
		frame.getContentPane().add(label_4);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user=new User();
				user.setFirstName(user.getFirstName());
				user.setFirstName(user.getFirstName());
				user.setJob(user.getJob());
				//user.setDeathDate(new Date());
				if(UserDelegate.CreateUser(user))
						{
					JOptionPane.showMessageDialog(null," Ok Patron (y) ");
					user.setFirstName("");
					user.setLastName("");
					user.setJob("");
						}
				else{}
			
			}
		});
		button.setBounds(137, 227, 65, 23);
		frame.getContentPane().add(button);
	}
}
