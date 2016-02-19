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
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class ListUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblJob;
	private JLabel lblGender;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnActualiser;
	private JTable table;
	private String[][] donnes;

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
		scrollPane.setBounds(242, 60, 534, 160);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(101, 248, 86, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 153, 86, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(101, 200, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(101, 302, 86, 20);
		contentPane.add(textField_3);
		
		lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 155, 78, 17);
		contentPane.add(lblFirstName);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 196, 78, 21);
		contentPane.add(lblLastName);
		
		lblJob = new JLabel("Job");
		lblJob.setBounds(21, 251, 26, 14);
		contentPane.add(lblJob);
		
		lblGender = new JLabel("Gender");
		lblGender.setBounds(10, 305, 46, 14);
		contentPane.add(lblGender);
		
		btnUpdate = new JButton("update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnUpdate.setBounds(414, 301, 89, 23);
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

				if (UserDelegate.removeUserById(x))
					JOptionPane.showMessageDialog(null, "Added");
				else
					JOptionPane.showMessageDialog(null, "erreur");
				;
			
			}
		});
		btnDelete.setBounds(578, 301, 89, 23);
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
						
						
						donnes[i][0] =String.valueOf(users.get(i).getIdUser());
						donnes[i][1] = users.get(i).getFirstName();
						donnes[i][2] = users.get(i).getLastName();
						donnes[i][3] = String.valueOf(users.get(i).getBirthDate());
						donnes[i][4] = users.get(i).getBirthPlace();
						donnes[i][5] = users.get(i).getJob();
						donnes[i][6] = users.get(i).getGender();
						donnes[i][7] = users.get(i).getEmail();

					}

					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "id","First name", "last name", "birth date", "birth place", "job", "Gender", "E-mail" }));

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnActualiser.setBounds(230, 301, 89, 23);
		contentPane.add(btnActualiser);
	}

}
