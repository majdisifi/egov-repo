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

public class ManageUser {

	private JFrame frame;
	private JTextField job;
	private JTextField lastname;
	private JTextField firstname;
	private JTextField birthPlace;
	private JTextField email;
	JScrollPane scrollPane = new JScrollPane();
	private JTable table;
	private JTextField gender;
	String[][] donnes;
	List<User> us;
	private JTable table_1;
	

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
		frame.setBounds(100, 100, 963, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("Birth Date");
		label.setBounds(63, 223, 48, 14);
		frame.getContentPane().add(label);

		JDateChooser dato = new JDateChooser();
		job = new JTextField();
		job.setColumns(10);
		job.setBounds(168, 175, 86, 20);
		frame.getContentPane().add(job);

		JLabel label_1 = new JLabel("Job");
		label_1.setBounds(63, 178, 29, 14);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Last Name");
		label_2.setBounds(63, 136, 50, 14);
		frame.getContentPane().add(label_2);

		lastname = new JTextField();
		lastname.setColumns(10);
		lastname.setBounds(168, 133, 86, 20);
		frame.getContentPane().add(lastname);

		firstname = new JTextField();
		firstname.setColumns(10);
		firstname.setBounds(168, 97, 86, 20);
		frame.getContentPane().add(firstname);

		JLabel label_3 = new JLabel("First Name");
		label_3.setBounds(63, 100, 51, 14);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("Managing User Account");
		
		label_4.setBounds(283, 11, 260, 23);
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
				JOptionPane.showMessageDialog(null, "Added");

			}
		});

		scrollPane.setViewportView(table);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		button.setBounds(351, 333, 65, 23);
		frame.getContentPane().add(button);

		dato.setBounds(167, 217, 87, 20);
		frame.getContentPane().add(dato);

		birthPlace = new JTextField();
		birthPlace.setColumns(10);
		birthPlace.setBounds(168, 258, 86, 20);
		frame.getContentPane().add(birthPlace);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(168, 299, 86, 20);
		frame.getContentPane().add(email);

		JLabel lblEmal = new JLabel("E-mal");
		lblEmal.setBounds(63, 302, 46, 14);
		frame.getContentPane().add(lblEmal);

		JLabel lblBirthPlace = new JLabel("Birth Place");
		lblBirthPlace.setBounds(63, 260, 58, 17);
		frame.getContentPane().add(lblBirthPlace);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User user=new User();
				user=us.get(table.getSelectedRow());
				firstname.setText(user.getFirstName());
				lastname.setText(user.getLastName());
				job.setText(user.getJob());
				dato.setDate(user.getBirthDate());
				birthPlace.setText(user.getBirthPlace());
				email.setText(user.getEmail());
				gender.setText(user.getGender());
				
				
				
			}
		});
		scrollPane_1.setBounds(306, 77, 534, 160);
		frame.getContentPane().add(scrollPane_1);

		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		table_1 = new JTable();
		scrollPane_1.setColumnHeaderView(table_1);

		gender = new JTextField();
		gender.setBounds(168, 350, 86, 20);
		frame.getContentPane().add(gender);
		gender.setColumns(10);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(63, 353, 46, 14);
		frame.getContentPane().add(lblGender);

	
		JButton btnNewButton = new JButton("actualize");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					List<User> users = new ArrayList<User>();

					users = UserDelegate.doFindAllUsers();
					System.out.println("done");
					donnes = new String[users.size()][8];
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
		btnNewButton.setBounds(471, 333, 89, 23);
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
				;
			}

		});
		btnSupprimer.setBounds(610, 333, 89, 23);
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
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				
				
			}
		});
		btnUpdate.setBounds(748, 333, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnPdf = new JButton("pdf");
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document document = new Document();
		        try{
		        	
		        	
		        	User us = new User();
					int a = table.getSelectedRow();
	             
					int x = Integer.parseInt(donnes[a][0]);
					
					
				
		        	String n =donnes[a][2];
					String f = donnes[a][1];
					String j = donnes[a][5];
					String p = donnes[a][4];
					String g = donnes[a][6];
					//Date d = dato.getDate();
		        	
		        	PdfWriter.getInstance(document, new FileOutputStream("D:\\Egov.pdf"));
		            document.open();
		            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 48, Font.ITALIC | Font.BOLD | Font.BOLD);
		            Paragraph p1 = new Paragraph(n);
		            Paragraph p2 = new Paragraph(f);
		            Paragraph p3 = new Paragraph(j);
		            Paragraph p4 = new Paragraph(p);
		            Paragraph p5 = new Paragraph(g);
		          
		            
		            p1.setAlignment(Element.ALIGN_CENTER);
		            p2.setAlignment(Element.ALIGN_CENTER);
		            p3.setAlignment(Element.ALIGN_CENTER);
		            p4.setAlignment(Element.ALIGN_CENTER);
		            p5.setAlignment(Element.ALIGN_CENTER);
		 
		            document.add(p1);
		            
		            //add blank line
		    	    document.add( Chunk.NEWLINE );
		            document.add(p2);
		            document.add( Chunk.NEWLINE );
		            document.add(p3);
		            document.add( Chunk.NEWLINE );
		            document.add(p4);
		            document.add( Chunk.NEWLINE );
		            document.add(p5);
		            document.add( Chunk.NEWLINE );
		           
		            document.close();
		        }
		        catch(Exception n){
		            System.out.println(n);
		        }
		        document.close();
		    
			}
		});
		btnPdf.setBounds(541, 257, 89, 23);
		frame.getContentPane().add(btnPdf);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
					
			}
		});
		comboBox.setBounds(98, 32, 28, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnDownload = new JButton("Download");
	}	
}

		