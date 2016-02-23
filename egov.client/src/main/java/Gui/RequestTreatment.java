package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Gui.admin.AdminSpace;
import delegate.UserDelegate;
import egov.entities.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class RequestTreatment extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	String[][] donnes;
	List<User> us;
	private JTextField numCin;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequestTreatment frame = new RequestTreatment();
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
	public RequestTreatment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRequestTreatment = new JLabel("Request treatment ");
		lblRequestTreatment.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRequestTreatment.setBounds(223, 11, 208, 42);
		contentPane.add(lblRequestTreatment);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\HP\\git\\egov-repo\\egov.client\\target\\classes\\icons\\add.png"));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				
				int a = table.getSelectedRow();

				int x = Integer.parseInt(donnes[a][0]);

				User user = UserDelegate.doFindUserById(x);
				String n =  String.valueOf(numCin.getText());
						
			

					if (n.length()!=8)
						JOptionPane.showMessageDialog(null, "erreur");
					
						
					else
						
				user.setNumCin(Integer.parseInt(n));
					

				if (UserDelegate.doUpdateUser(user))
					JOptionPane.showMessageDialog(null, "Cin add");
				else
					JOptionPane.showMessageDialog(null, "erreur");
				
				/////////////
				
				try {

					List<User> users = new ArrayList<User>();

					users = UserDelegate.doFindAllUsers();
					System.out.println("done");
					donnes = new String[users.size()][10];
					for (int i = 0; i < users.size(); i++) {
						
						
						donnes[i][0] =String.valueOf(users.get(i).getIdUser());
						donnes[i][1] = users.get(i).getFirstName();
						donnes[i][2] = users.get(i).getLastName();
						donnes[i][3] = String.valueOf(users.get(i).getBirthDate());
						donnes[i][4] = users.get(i).getBirthPlace();
						donnes[i][5] = users.get(i).getJob();
						donnes[i][6] = users.get(i).getGender();
						donnes[i][7] = users.get(i).getEmail();
						donnes[i][8] = String.valueOf(users.get(i).getDeathDate());
						donnes[i][9] = String.valueOf(users.get(i).getNumCin());
						
						

					}

					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "Id","First name", "Last name", "Birth date", "Birth place", "Job", "Gender", "E-mail","Death Date","Cin" }));

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
				
			
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(606, 319, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 64, 690, 160);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table_1 = new JTable();
		scrollPane.setColumnHeaderView(table_1);
		
		
		try {

			List<User> users = new ArrayList<User>();

			users = UserDelegate.doFindAllUsers();
			System.out.println("done");
			donnes = new String[users.size()][10];
			for (int i = 0; i < users.size(); i++) {
				
				
				donnes[i][0] =String.valueOf(users.get(i).getIdUser());
				donnes[i][1] = users.get(i).getFirstName();
				donnes[i][2] = users.get(i).getLastName();
				donnes[i][3] = String.valueOf(users.get(i).getBirthDate());
				donnes[i][4] = users.get(i).getBirthPlace();
				donnes[i][5] = users.get(i).getJob();
				donnes[i][6] = users.get(i).getGender();
				donnes[i][7] = users.get(i).getEmail();
				donnes[i][8] = String.valueOf(users.get(i).getDeathDate());
				donnes[i][9] = String.valueOf(users.get(i).getNumCin());
				
				

			}

			table.setModel(new javax.swing.table.DefaultTableModel(donnes,
					new String[] { "Id","First name", "Last name", "Birth date", "Birth place", "Job", "Gender", "E-mail","Death Date","Cin" }));
			
			JLabel lblNumCin = new JLabel("Num Cin :");
			lblNumCin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNumCin.setBounds(70, 267, 83, 14);
			contentPane.add(lblNumCin);
			
			numCin = new JTextField();
			numCin.setBounds(146, 265, 96, 20);
			contentPane.add(numCin);
			numCin.setColumns(10);
			
			JButton btnCancel = new JButton("Cancel");
			btnCancel.setIcon(new ImageIcon("C:\\Users\\HP\\git\\egov-repo\\egov.client\\target\\classes\\icons\\arrow_left.png"));
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					new AdminSpace().setVisible(true);
					setVisible(false);
				}
			});
			btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
			btnCancel.setBounds(472, 320, 117, 23);
			contentPane.add(btnCancel);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
