package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RepaintManager;

import delegate.UserDelegate;
import egov.entities.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.BirthdayEvaluator;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ManageUser {

	private JFrame frame;
	private JTextField job;
	private JTextField lastname;
	private JTextField firstname;
	private JTextField birthPlace;
	private JTextField email;
	JScrollPane scrollPane = new JScrollPane();
	private JTable table;
	String[][] donnes;
	List<User> us;
	private JTable table_1;
	private JTextField nationality;
	JComboBox comboBox = new JComboBox();
	private JTextField mother;
	private JTextField father;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageUser window = new ManageUser();
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
	public ManageUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 998, 591);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("Birth Date");
		label.setBounds(65, 174, 48, 14);
		frame.getContentPane().add(label);
		JDateChooser death = new JDateChooser();
		JDateChooser dato = new JDateChooser();
		job = new JTextField();
		job.setColumns(10);
		job.setBounds(168, 126, 86, 20);
		frame.getContentPane().add(job);

		JLabel label_1 = new JLabel("Job");
		label_1.setBounds(65, 129, 29, 14);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Last Name");
		label_2.setBounds(65, 84, 50, 14);
		frame.getContentPane().add(label_2);

		lastname = new JTextField();
		lastname.setColumns(10);
		lastname.setBounds(168, 81, 86, 20);
		frame.getContentPane().add(lastname);

		firstname = new JTextField();
		firstname.setColumns(10);
		firstname.setBounds(168, 40, 86, 20);
		frame.getContentPane().add(firstname);

		JLabel label_3 = new JLabel("First Name");
		label_3.setBounds(65, 43, 51, 14);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("Managing User Account");

		label_4.setBounds(408, 11, 260, 23);
		frame.getContentPane().add(label_4);

		JButton button = new JButton("Add");

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String n = lastname.getText();
				String f = firstname.getText();
				String j = job.getText();

				String p = birthPlace.getText();
				String em = email.getText();
				
				String t=nationality.getText();
				
				String fa=father.getText();
				String ma=mother.getText();
				// String np=pere.getText();
				// String nm=mere.getText();

				Date d = dato.getDate();
				User user = new User();
				
	int index=comboBox.getSelectedIndex();
				
	if (index==0) 
		JOptionPane.showMessageDialog(null, "You Should Select your gender");
	else {

				if (index==1) 
				{user.setGender("Male");}
				if (index==2){user.setGender("Female");}
				

				
				user.setFirstName(f);
				user.setLastName(n);
				user.setJob(j);
				user.setBirthDate(d);
				user.setEmail(em);
				user.setBirthPlace(p);
				user.setFatherName(fa);
				user.setMotherName(ma);
				
				// user.setBirthPlace(np);
				// user.setBirthPlace(nm);
				user.setNationality(t);

				UserDelegate.CreateUser(user);
				JOptionPane.showMessageDialog(null, "Added");

				////
				try {

					List<User> users = new ArrayList<User>();

					users = UserDelegate.doFindAllUsers();
					System.out.println("done");
					donnes = new String[users.size()][12];
					for (int i = 0; i < users.size(); i++) {

						donnes[i][0] = String.valueOf(users.get(i).getIdUser());
						donnes[i][1] = users.get(i).getFirstName();
						donnes[i][2] = users.get(i).getLastName();
						donnes[i][3] = String.valueOf(users.get(i).getBirthDate());
						donnes[i][4] = users.get(i).getBirthPlace();
						donnes[i][5] = users.get(i).getJob();
						donnes[i][6] = users.get(i).getGender();
						donnes[i][7] = users.get(i).getEmail();
						donnes[i][8] = String.valueOf(users.get(i).getDeathDate());
						donnes[i][9] = users.get(i).getNationality();
						donnes[i][10] = users.get(i).getMotherName();
						donnes[i][11] = users.get(i).getFatherName();

					}

					table.setModel(new javax.swing.table.DefaultTableModel(donnes, new String[] { "id", "First name",
							"last name", "birth date", "birth place", "job", "Gender", "E-mail", "Death Date","Nationality","Mother Name" ,"Father Name"}));

				} catch (Exception e1) {
					e1.printStackTrace();
				}
	}

			}
		});

		scrollPane.setViewportView(table);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		button.setBounds(478, 305, 65, 23);
		frame.getContentPane().add(button);

		dato.setBounds(168, 168, 87, 20);
		frame.getContentPane().add(dato);

		birthPlace = new JTextField();
		birthPlace.setColumns(10);
		birthPlace.setBounds(168, 262, 86, 20);
		frame.getContentPane().add(birthPlace);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(168, 306, 86, 20);
		frame.getContentPane().add(email);

		JLabel lblEmal = new JLabel("E-mal");
		lblEmal.setBounds(67, 309, 46, 14);
		frame.getContentPane().add(lblEmal);

		JLabel lblBirthPlace = new JLabel("Birth Place");
		lblBirthPlace.setBounds(65, 264, 58, 17);
		frame.getContentPane().add(lblBirthPlace);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
		

			}
		});
		scrollPane_1.setBounds(289, 77, 666, 177);
		frame.getContentPane().add(scrollPane_1);

		table = new JTable();
		scrollPane_1.setViewportView(table);

		table_1 = new JTable();
		scrollPane_1.setColumnHeaderView(table_1);

		JButton btnNewButton = new JButton("actualize");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton.setBounds(306, 359, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnSupprimer = new JButton("delete");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				User us = new User();
				int a = table.getSelectedRow();
				System.out.println(a);
				int x = Integer.parseInt(donnes[a][0]);
				System.out.println(x);

				if (UserDelegate.removeUserById(x))
					JOptionPane.showMessageDialog(null, "Deleted");

				else
					JOptionPane.showMessageDialog(null, "erreur");
				///////////
				try {

					List<User> users = new ArrayList<User>();

					users = UserDelegate.doFindAllUsers();
					System.out.println("done");
					donnes = new String[users.size()][12];
					for (int i = 0; i < users.size(); i++) {

						donnes[i][0] = String.valueOf(users.get(i).getIdUser());
						donnes[i][1] = users.get(i).getFirstName();
						donnes[i][2] = users.get(i).getLastName();
						donnes[i][3] = String.valueOf(users.get(i).getBirthDate());
						donnes[i][4] = users.get(i).getBirthPlace();
						donnes[i][5] = users.get(i).getJob();
						donnes[i][6] = users.get(i).getGender();
						donnes[i][7] = users.get(i).getEmail();
						donnes[i][8] = String.valueOf(users.get(i).getDeathDate());
						donnes[i][9] = users.get(i).getNationality();
						donnes[i][10] = users.get(i).getMotherName();
						donnes[i][11] = users.get(i).getFatherName();

					}

					table.setModel(new javax.swing.table.DefaultTableModel(donnes, new String[] { "id", "First name",
							"last name", "birth date", "birth place", "job", "Gender", "E-mail", "Death Date","Nationality","Mother Name" ,"Father Name"}));

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				;
			}

		});
		btnSupprimer.setBounds(454, 415, 89, 23);
		frame.getContentPane().add(btnSupprimer);

		JButton btnUpdate = new JButton("update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = table.getSelectedRow();

				int x = Integer.parseInt(donnes[a][0]);

				User user = UserDelegate.doFindUserById(x);
				String n = lastname.getText();
				String f = firstname.getText();
				String j = job.getText();
				String p = birthPlace.getText();
				String em = email.getText();
				Date d = dato.getDate();
				Date d1 = death.getDate();
				String t=nationality.getText();

				String fa=father.getText();
				String ma=mother.getText();
				if (fa.equals(""))
					user.setFatherName(donnes[a][11]);
				else

					user.setFatherName(fa);
				if (ma.equals(""))
					user.setMotherName(donnes[a][12]);
				else

					user.setMotherName(ma);
				
				
				if (f.equals(""))
					user.setFirstName(donnes[a][1]);
				else

					user.setFirstName(f);

				if (n.equals(""))
					user.setFirstName(donnes[a][2]);
				else
					user.setLastName(n);

				if (j.equals(""))
					user.setJob(donnes[a][5]);
				else
					user.setJob(j);

				user.setBirthDate(d);
				if (em.equals(""))
					user.setEmail(donnes[a][7]);
				else
					user.setEmail(em);
				user.setBirthPlace(donnes[a][4]);
		
				
				if (t.equals(""))
					user.setNationality(donnes[a][9]);
				else
					user.setNationality(t);
				user.setDeathDate(d1);
				
				int index=comboBox.getSelectedIndex();
				
				
					if (index==1) {user.setGender("Male");}
				
				else if  (index==2){user.setGender("Female");
				}
				else {user.setGender(donnes[a][6]);}
					
				
				
				

				if (UserDelegate.doUpdateUser(user))
					JOptionPane.showMessageDialog(null, "updated");
				else
					JOptionPane.showMessageDialog(null, "erreur");
				try {

					List<User> users = new ArrayList<User>();

					users = UserDelegate.doFindAllUsers();
					System.out.println("done");
					donnes = new String[users.size()][12];
					for (int i = 0; i < users.size(); i++) {

						donnes[i][0] = String.valueOf(users.get(i).getIdUser());
						donnes[i][1] = users.get(i).getFirstName();
						donnes[i][2] = users.get(i).getLastName();
						donnes[i][3] = String.valueOf(users.get(i).getBirthDate());
						donnes[i][4] = users.get(i).getBirthPlace();
						donnes[i][5] = users.get(i).getJob();
						donnes[i][6] = users.get(i).getGender();
						donnes[i][7] = users.get(i).getEmail();
						donnes[i][8] = String.valueOf(users.get(i).getDeathDate());
						donnes[i][9] = users.get(i).getNationality();
						donnes[i][10] = users.get(i).getMotherName();
						donnes[i][11] = users.get(i).getFatherName();

					}

					table.setModel(new javax.swing.table.DefaultTableModel(donnes, new String[] { "id", "First name",
							"last name", "birth date", "birth place", "job", "Gender", "E-mail", "Death Date","Nationality","Mother Name" ,"Father Name"}));

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		});
		btnUpdate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});
		btnUpdate.setBounds(454, 359, 89, 23);
		frame.getContentPane().add(btnUpdate);

		JButton btnPdf = new JButton("PDF");
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document document = new Document();
				try {

					User us = new User();
					int a = table.getSelectedRow();

					int x = Integer.parseInt(donnes[a][0]);

					String n = donnes[a][2];
					String f = donnes[a][1];
					String j = donnes[a][5];
					String p = donnes[a][4];
					String g = donnes[a][6];
					String d = donnes[a][3];

					PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\HP\\git\\PDF-" + donnes[a][2] + ".pdf"));
					document.open();

					Font font = new Font(Font.FontFamily.TIMES_ROMAN, 48, Font.ITALIC | Font.BOLD | Font.BOLD);

					Paragraph p1 = new Paragraph("User Information ");
					Paragraph p2 = new Paragraph("First Name :" + n);
					Paragraph p3 = new Paragraph("Last Name :" + f);
					Paragraph p4 = new Paragraph("Job :" + j);
					Paragraph p5 = new Paragraph("Birth Date:" + d);
					Paragraph p6 = new Paragraph("Birth Place:" + p);
					Paragraph p7 = new Paragraph("Gender:" + g);

					p1.setAlignment(Element.ALIGN_CENTER);
					p2.setAlignment(Element.ALIGN_CENTER);
					p3.setAlignment(Element.ALIGN_CENTER);
					p4.setAlignment(Element.ALIGN_CENTER);
					p5.setAlignment(Element.ALIGN_CENTER);
					p6.setAlignment(Element.ALIGN_CENTER);
					p7.setAlignment(Element.ALIGN_CENTER);

					document.add(p1);

					// add blank line
					document.add(Chunk.NEWLINE);
					document.add(p2);
					document.add(Chunk.NEWLINE);
					document.add(p3);
					document.add(Chunk.NEWLINE);
					document.add(p4);
					document.add(Chunk.NEWLINE);
					document.add(p5);
					document.add(Chunk.NEWLINE);
					document.add(p6);
					document.add(Chunk.NEWLINE);
					document.add(p7);
					document.add(Chunk.NEWLINE);

					document.close();
				} catch (Exception n) {
					System.out.println(n);
				}
				document.close();

			}
		});
		btnPdf.setBounds(663, 305, 116, 23);
		frame.getContentPane().add(btnPdf);

	
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-----", "Male", "Female"}));
	

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		comboBox.setBounds(168, 362, 70, 20);
		frame.getContentPane().add(comboBox);

		JLabel lblDeathDate = new JLabel("Death Date");
		lblDeathDate.setBounds(51, 214, 61, 14);
		frame.getContentPane().add(lblDeathDate);

		death.setBounds(168, 214, 87, 20);
		frame.getContentPane().add(death);

		JButton btnNewButton_1 = new JButton("Death Certificate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document document = new Document();
				try {

					User us = new User();
					int a = table.getSelectedRow();

					int x = Integer.parseInt(donnes[a][0]);

					String n = donnes[a][2];
					String f = donnes[a][1];
					String j = donnes[a][5];
					String p = donnes[a][4];
					String g = donnes[a][6];
					String d = donnes[a][3];
					String d1 = donnes[a][8];

					PdfWriter.getInstance(document,
							new FileOutputStream("C:\\Users\\HP\\git\\DeathCertifcate-" + donnes[a][2] + ".pdf"));
					document.open();

					Font font = new Font(Font.FontFamily.TIMES_ROMAN, 48, Font.ITALIC | Font.BOLD | Font.BOLD);

					Paragraph p1 = new Paragraph("Death Certificate ");
					Paragraph p2 = new Paragraph("First Name :" + n);
					Paragraph p3 = new Paragraph("Last Name :" + f);
					Paragraph p4 = new Paragraph("Job :" + j);
					Paragraph p5 = new Paragraph("Birth Date:" + d);
					Paragraph p6 = new Paragraph("Birth Place:" + p);
					Paragraph p7 = new Paragraph("Gender:" + g);
					Paragraph p8 = new Paragraph("Death Date:" + d1);

					p1.setAlignment(Element.ALIGN_CENTER);
					p2.setAlignment(Element.ALIGN_CENTER);
					p3.setAlignment(Element.ALIGN_CENTER);
					p4.setAlignment(Element.ALIGN_CENTER);
					p5.setAlignment(Element.ALIGN_CENTER);
					p6.setAlignment(Element.ALIGN_CENTER);
					p7.setAlignment(Element.ALIGN_CENTER);
					p8.setAlignment(Element.ALIGN_CENTER);

					document.add(p1);

					// add blank line
					document.add(Chunk.NEWLINE);
					document.add(p2);
					document.add(Chunk.NEWLINE);
					document.add(p3);
					document.add(Chunk.NEWLINE);
					document.add(p4);
					document.add(Chunk.NEWLINE);
					document.add(p5);
					document.add(Chunk.NEWLINE);
					document.add(p6);
					document.add(Chunk.NEWLINE);
					document.add(p7);
					document.add(Chunk.NEWLINE);

					document.add(p8);
					document.add(Chunk.NEWLINE);

					document.close();
				} catch (Exception n) {
					System.out.println(n);
				}
				document.close();

			}
		});
		btnNewButton_1.setBounds(663, 362, 116, 20);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnDownload = new JButton("Download");
		try {

			List<User> users = new ArrayList<User>();

			users = UserDelegate.doFindAllUsers();
			System.out.println("done");
			donnes = new String[users.size()][12];
			for (int i = 0; i < users.size(); i++) {

				donnes[i][0] = String.valueOf(users.get(i).getIdUser());
				donnes[i][1] = users.get(i).getFirstName();
				donnes[i][2] = users.get(i).getLastName();
				donnes[i][3] = String.valueOf(users.get(i).getBirthDate());
				donnes[i][4] = users.get(i).getBirthPlace();
				donnes[i][5] = users.get(i).getJob();
				donnes[i][6] = users.get(i).getGender();
				donnes[i][7] = users.get(i).getEmail();
				donnes[i][8] = String.valueOf(users.get(i).getDeathDate());
				donnes[i][9] = users.get(i).getNationality();
				donnes[i][10] = users.get(i).getMotherName();
				donnes[i][11] = users.get(i).getFatherName();

			}

			table.setModel(new javax.swing.table.DefaultTableModel(donnes, new String[] { "id", "First name",
					"last name", "birth date", "birth place", "job", "Gender", "E-mail", "Death Date","Nationality","Mother Name" ,"Father Name"}));

		} catch (Exception e1) {
			e1.printStackTrace();
		}
			nationality = new JTextField();
			nationality.setBounds(168, 416, 86, 20);
			frame.getContentPane().add(nationality);
			nationality.setColumns(10);
			
			JLabel lblNationality = new JLabel("Nationality");
			lblNationality.setBounds(65, 419, 77, 14);
			frame.getContentPane().add(lblNationality);
			
			JLabel label_5 = new JLabel("Gender");
			label_5.setBounds(65, 363, 46, 14);
			frame.getContentPane().add(label_5);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(null);
			lblNewLabel.setBounds(280, 11, 996, 560);
			frame.getContentPane().add(lblNewLabel);
			
			mother = new JTextField();
			mother.setBounds(168, 460, 86, 20);
			frame.getContentPane().add(mother);
			mother.setColumns(10);
			
			father = new JTextField();
			father.setBounds(168, 510, 86, 20);
			frame.getContentPane().add(father);
			father.setColumns(10);
			
			JLabel lblMothersName = new JLabel("Mother's Name");
			lblMothersName.setBounds(51, 463, 91, 14);
			frame.getContentPane().add(lblMothersName);
			
			JLabel lblFathersName = new JLabel("Father's Name");
			lblFathersName.setBounds(65, 510, 77, 17);
			frame.getContentPane().add(lblFathersName);

		
	}

}
