package GuiUniversity;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import egov.entities.University;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import delegate.UniversityDelegate;
import delegate.UserDelegate;
import java.awt.event.MouseAdapter;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;




public class displayUniversity extends JFrame {
	 List <University> Listuniversity;
	 Integer index ; 
	 JFrame frame;

	private JPanel contentPane;
	private JTable table;
String[][] donnes;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayUniversity frame = new displayUniversity();
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
	public displayUniversity() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(289, 36, 278, 143);
		contentPane.add(table);
		
		JLabel lblGestionDesUniversits = new JLabel("University Management");
		lblGestionDesUniversits.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblGestionDesUniversits.setBounds(180, 11, 227, 14);
		contentPane.add(lblGestionDesUniversits);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\mariem\\git\\egov-repo\\egov.client\\src\\main\\java\\images\\Back.gif"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(289, 213, 118, 23);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("supprimer");
		btnDelete.setIcon(new ImageIcon("C:\\Users\\mariem\\git\\egov-repo\\egov.client\\src\\main\\java\\images\\Delete.gif"));
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			
			
			public void mouseClicked(MouseEvent arg0) {
				 {

					int a = table.getSelectedRow();

					int x = Integer.parseInt(donnes[a][0]);
					
 System.out.println(x);
					if (UniversityDelegate.removeUniversityById(x))
						JOptionPane.showMessageDialog(null, "deleted");
					else
						JOptionPane.showMessageDialog(null, "erreur");

					try {

						List<University> univs = new ArrayList<University>();

						univs  = UniversityDelegate.doFindAllUniversities();
						System.out.println("done");
						donnes = new String[univs.size()][4];
						
						for (int i = 0; i < univs.size(); i++) {
							
							donnes[i][3] = univs.get(i).getNameUniversity();
							donnes[i][1] = univs.get(i).getAdress();
							donnes[i][2] = String.valueOf(univs.get(i).getPhone());
							donnes[i][0] = String.valueOf(univs.get(i).getIdUniversity());
							
							
							
							
							
						}

						table.setModel(new javax.swing.table.DefaultTableModel(donnes,
								new String[] { "id","Name", "Adresse", "Phone" }));
						
					

					} catch (Exception e1) {
						e1.printStackTrace();
					}
					;

				}
			}
		});
		/*btnDelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				index=new Integer(table.getSelectedRow());
				University u=Listuniversity.get(index);
				UniversityDelegate.removeUniversity(u);
			}
		});*/
		btnDelete.setBounds(431, 212, 136, 23);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel = new JLabel("Update");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if (row != -1) {
					
					
					frame.setVisible(false);
				} else {
					
					frame.setVisible(true);
				}
			}
			
		});
		lblNewLabel.setBounds(500, 216, -116, 14);
		contentPane.add(lblNewLabel);

		try {

			List<University> univs = new ArrayList<University>();

			univs  = UniversityDelegate.doFindAllUniversities();
			System.out.println("done");
			donnes = new String[univs.size()][4];
			
			for (int i = 0; i < univs.size(); i++) {
				
				donnes[i][3] = univs.get(i).getNameUniversity();
				donnes[i][1] = univs.get(i).getAdress();
				donnes[i][2] = String.valueOf(univs.get(i).getPhone());
				donnes[i][0] = String.valueOf(univs.get(i).getIdUniversity());
				
				
				
				
				
			}

			table.setModel(new javax.swing.table.DefaultTableModel(donnes,
					new String[] { "id","Name", "Adresse", "Phone" }));
			
			JLabel name = new JLabel("Name:");
			name.setFont(new Font("Times New Roman", Font.BOLD, 14));
			name.setBounds(10, 53, 46, 14);
			contentPane.add(name);
			
			JLabel adress = new JLabel("Adress:");
			adress.setFont(new Font("Times New Roman", Font.BOLD, 14));
			adress.setBounds(10, 78, 59, 14);
			contentPane.add(adress);
			
			JLabel phone = new JLabel("Phone:");
			phone.setFont(new Font("Times New Roman", Font.BOLD, 14));
			phone.setBounds(10, 116, 46, 14);
			contentPane.add(phone);
			
			textField = new JTextField();
			textField.setBounds(69, 51, 172, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(69, 75, 172, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(69, 113, 172, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
			
			JButton btnNewButton_1 = new JButton("Update");
			btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\mariem\\git\\egov-repo\\egov.client\\src\\main\\java\\images\\Apply.gif"));
			btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnNewButton_1.addMouseListener(new MouseAdapter() {
				
				@Override
				
				public void mouseClicked(MouseEvent arg0) {
					int a = table.getSelectedRow();

					int x = Integer.parseInt(donnes[a][0]);

					University univ = UniversityDelegate.dofindUniversityById(x);
					String n = name.getText();
					String ad = adress.getText();
					String p = phone.getText();
					
					

						if (n.equals(""))
							univ.setNameUniversity(donnes[a][1]);
						else
							
					univ.setNameUniversity(n);
						

						if (ad.equals(""))
						univ.setAdress(donnes[a][2]);
							else	
					univ.setAdress(ad);
						
						if (p.equals(""))
						univ.setPhone(Integer.parseInt(donnes[a][3]));
							else	
					univ.setPhone(Integer.parseInt(p));
						
				

					if (UniversityDelegate.doUpdateUniv(univ))
						JOptionPane.showMessageDialog(null, "updated");
					else
							JOptionPane.showMessageDialog(null, "erreur");

				}
			});
			btnNewButton_1.setBounds(125, 212, 116, 23);
			contentPane.add(btnNewButton_1);
			
			JButton update1 = new JButton("add");
			update1.setIcon(new ImageIcon("C:\\Users\\mariem\\git\\egov-repo\\egov.client\\src\\main\\java\\images\\Add.gif"));
			update1.setFont(new Font("Times New Roman", Font.BOLD, 14));
			update1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					addUniversity a=new addUniversity();
					a.setVisible(true);
					
					a.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e){
							
						}
					});
					
				}
			});
			update1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int a = table.getSelectedRow();

					int x = Integer.parseInt(donnes[a][0]);

					University univ = UniversityDelegate.dofindUniversityById(x);
					String n = name.getText();
					String ad = adress.getText();
					int p =Integer.parseInt( phone.getText());
					
					

						if (n.equals(""))
							univ.setNameUniversity(donnes[a][1]);
						else
							
					univ.setNameUniversity(n);
						

						if (ad.equals(""))
						univ.setAdress(donnes[a][2]);
							else	
					univ.setAdress(ad);
						
						if (p==0)
						univ.setPhone(Integer.parseInt(donnes[a][3]));
							else	
					univ.setPhone(p);
						
				

					if (UniversityDelegate.doUpdateUniv(univ))
						JOptionPane.showMessageDialog(null, "updated");
					else
							JOptionPane.showMessageDialog(null, "erreur");

				}
					
				
			});
			update1.setBounds(10, 211, 89, 23);
			contentPane.add(update1);
			
		

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
