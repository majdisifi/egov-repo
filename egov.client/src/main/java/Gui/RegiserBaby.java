package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import delegate.UserDelegate;
import egov.entities.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegiserBaby extends JFrame {

	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField job;
	private JTextField birthPlace;
	private JTextField gender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegiserBaby frame = new RegiserBaby();
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
	public RegiserBaby() {
		JDateChooser dato = new JDateChooser();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		firstName = new JTextField();
		firstName.setColumns(10);
		firstName.setBounds(262, 48, 86, 20);
		contentPane.add(firstName);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(262, 91, 86, 20);
		contentPane.add(lastName);
		
		job = new JTextField();
		job.setColumns(10);
		job.setBounds(262, 143, 86, 20);
		contentPane.add(job);
		
		
		dato.setBounds(262, 193, 87, 20);
		contentPane.add(dato);
		
		birthPlace = new JTextField();
		birthPlace.setColumns(10);
		birthPlace.setBounds(262, 267, 86, 20);
		contentPane.add(birthPlace);
		
		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(262, 311, 86, 20);
		contentPane.add(gender);
		
		JLabel label = new JLabel("First Name");
		label.setBounds(189, 52, 51, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Last Name");
		label_1.setBounds(190, 95, 50, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Job");
		label_2.setBounds(200, 147, 29, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Birth Date");
		label_3.setBounds(190, 194, 48, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Birth Place");
		label_4.setBounds(180, 270, 58, 17);
		contentPane.add(label_4);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDateChooser dato = new JDateChooser();
				
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String n = lastName.getText();
				String f = firstName.getText();
				String j = job.getText();
			
				String p=birthPlace.getText();
		
				String g=gender.getText();
				//String np=pere.getText();
				//String nm=mere.getText();
			
				
				
				Date d=dato.getDate();
				
				User user = new User();
				user.setFirstName(f);
				user.setLastName(n);
				user.setJob(j);
				user.setDeathDate(d);
				
				user.setBirthPlace(p);
				user.setGender(g);
				//user.setBirthPlace(np);
				//user.setBirthPlace(nm);

				UserDelegate.CreateUser(user);
				JOptionPane.showMessageDialog(null, "Added");
			}
		});
		btnNewButton.setBounds(212, 341, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblGender = new JLabel("gender");
		lblGender.setBounds(189, 314, 46, 14);
		contentPane.add(lblGender);
		
		JButton btnAnnuler = new JButton("annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ListUser frame = new ListUser();
			        frame.setVisible(true);
			        
			}
		});
		btnAnnuler.setBounds(363, 341, 89, 23);
		contentPane.add(btnAnnuler);
	}
}
