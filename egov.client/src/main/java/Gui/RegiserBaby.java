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
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegiserBaby extends JFrame {

	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField birthPlace;
	private JTextField nationality;
	private JTextField father;
	private JTextField mother;
	JComboBox comboBox = new JComboBox();

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
		setBounds(100, 100, 652, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		firstName = new JTextField();
		firstName.setColumns(10);
		firstName.setBounds(262, 50, 86, 20);
		contentPane.add(firstName);

		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(262, 103, 86, 20);
		contentPane.add(lastName);

		dato.setBounds(262, 164, 87, 20);
		contentPane.add(dato);

		birthPlace = new JTextField();
		birthPlace.setColumns(10);
		birthPlace.setBounds(262, 230, 86, 20);
		contentPane.add(birthPlace);

		JLabel label = new JLabel("First Name");
		label.setBounds(159, 53, 51, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Last Name");
		label_1.setBounds(160, 106, 50, 14);
		contentPane.add(label_1);

		JLabel label_3 = new JLabel("Birth Date");
		label_3.setBounds(162, 164, 48, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Birth Place");
		label_4.setBounds(159, 232, 58, 17);
		contentPane.add(label_4);

		JButton btnNewButton = new JButton("Submit\r\n");
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

				String p = birthPlace.getText();
				String t = nationality.getText();
				String m=mother.getText();
				String fa=father.getText();
				Date d = dato.getDate();

				User user = new User();
				int index = comboBox.getSelectedIndex();
				if (index == 0)
					JOptionPane.showMessageDialog(null, "You Should Select your gender");
				else {

					if (index == 1) {
						user.setGender("Male");
					}
					if (index == 2) {
						user.setGender("Female");
					}

					user.setFirstName(f);
					user.setLastName(n);

					user.setDeathDate(d);

					user.setBirthPlace(p);
					user.setFatherName(fa);
					user.setMotherName(m);

					UserDelegate.CreateUser(user);
					JOptionPane.showMessageDialog(null, "Added");
				}
			}
		});
		btnNewButton.setBounds(233, 506, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblGender = new JLabel("gender");
		lblGender.setBounds(162, 292, 46, 14);
		contentPane.add(lblGender);

		nationality = new JTextField();
		nationality.setBounds(262, 347, 86, 20);
		contentPane.add(nationality);
		nationality.setColumns(10);

		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setBounds(154, 349, 75, 17);
		contentPane.add(lblNationality);

		father = new JTextField();
		father.setBounds(262, 404, 86, 20);
		contentPane.add(father);
		father.setColumns(10);

		mother = new JTextField();
		mother.setBounds(262, 452, 86, 20);
		contentPane.add(mother);
		mother.setColumns(10);

		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setBounds(135, 406, 75, 17);
		contentPane.add(lblFathersName);

		JLabel lblMothersName = new JLabel("Mother's Name");
		lblMothersName.setBounds(135, 455, 75, 14);
		contentPane.add(lblMothersName);

		comboBox.setModel(new DefaultComboBoxModel(new String[] { "-----", "Male", "Female\t" }));
		comboBox.setBounds(262, 289, 70, 20);
		contentPane.add(comboBox);
	}
}
