package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import delegate.UserDelegate;
import egov.entities.User;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ListUser extends JFrame {

	private JPanel contentPane;
	private JTextField job;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField gender;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblJob;
	private JLabel lblGender;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnActualiser;
	private JTable table;
	private String[][] donnes;
	private JButton btnActiver;
	private JTextField birthPlace;
	JDateChooser dato = new JDateChooser();
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListUser frame = new ListUser();
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
	public ListUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(230, 56, 534, 160);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		table_2 = new JTable();
		scrollPane.setColumnHeaderView(table_2);

		job = new JTextField();
		job.setColumns(10);
		job.setBounds(101, 242, 86, 20);
		contentPane.add(job);

		firstName = new JTextField();
		firstName.setColumns(10);
		firstName.setBounds(101, 158, 86, 20);
		contentPane.add(firstName);

		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(101, 200, 86, 20);
		contentPane.add(lastName);

		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(101, 273, 86, 20);
		contentPane.add(gender);

		lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 160, 78, 17);
		contentPane.add(lblFirstName);

		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 199, 78, 21);
		contentPane.add(lblLastName);

		lblJob = new JLabel("Job");
		lblJob.setBounds(34, 245, 26, 14);
		contentPane.add(lblJob);

		lblGender = new JLabel("Gender");
		lblGender.setBounds(10, 276, 46, 14);
		contentPane.add(lblGender);
		

		btnUpdate = new JButton("update");
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = table.getSelectedRow();

				int x = Integer.parseInt(donnes[a][0]);

				User user = UserDelegate.doFindUserById(x);
				String n = lastName.getText();
				String f = firstName.getText();
				String j = job.getText();
				String p = birthPlace.getText();
				String g = gender.getText();
				Date d = dato.getDate();

				user.setFirstName(f);
				user.setLastName(n);
				user.setJob(j);
				

				user.setBirthPlace(p);
				user.setGender(g);

				if (UserDelegate.doUpdateUser(user))
					JOptionPane.showMessageDialog(null, "updated");
				else
					JOptionPane.showMessageDialog(null, "erreur");
			}
		});
		btnUpdate.setBounds(516, 288, 89, 23);
		contentPane.add(btnUpdate);

		btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				User us = new User();
				int a = table.getSelectedRow();

				int x = Integer.parseInt(donnes[a][0]);
				;
				if (UserDelegate.doDeleteUser(UserDelegate.doFindUserById(x)))
					JOptionPane.showMessageDialog(null, "Deleted");
				else
					JOptionPane.showMessageDialog(null, "Delete Error");
				;

			}
		});
		btnDelete.setBounds(125, 92, 89, 23);
		contentPane.add(btnDelete);

		btnActualiser = new JButton("actualiser");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					List<User> users = new ArrayList<User>();

					users = UserDelegate.doFindAllUsers();
					System.out.println("done");
					String[][] donnes = new String[users.size()][8];
					for (int i = 0; i < users.size(); i++) {

						donnes[i][0] = String.valueOf(users.get(i).getIdUser());
						donnes[i][1] = users.get(i).getFirstName();
						donnes[i][2] = users.get(i).getLastName();
						donnes[i][3] = String.valueOf(users.get(i).getBirthDate());
						donnes[i][4] = users.get(i).getBirthPlace();
						donnes[i][5] = users.get(i).getJob();
						donnes[i][6] = users.get(i).getGender();
						donnes[i][7] = users.get(i).getEmail();

					}

					table.setModel(new javax.swing.table.DefaultTableModel(donnes, new String[] { "id", "First name",
							"last name", "birth date", "birth place", "job", "Gender", "E-mail" }));

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnActualiser.setBounds(332, 288, 89, 23);
		contentPane.add(btnActualiser);

		btnActiver = new JButton("Activer");
		btnActiver.setBounds(10, 92, 89, 23);
		contentPane.add(btnActiver);

		birthPlace = new JTextField();
		birthPlace.setColumns(10);
		birthPlace.setBounds(101, 333, 86, 20);
		contentPane.add(birthPlace);

		JLabel lblBirthDate = new JLabel("Birth Date");
		lblBirthDate.setBounds(10, 302, 57, 20);
		contentPane.add(lblBirthDate);

		JLabel lblBirthPlace = new JLabel("Birth Place");
		lblBirthPlace.setBounds(10, 336, 78, 14);
		contentPane.add(lblBirthPlace);

		JDateChooser dato = new JDateChooser();
		dato.setBounds(100, 304, 87, 20);
		contentPane.add(dato);
	}
}
