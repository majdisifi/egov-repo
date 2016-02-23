package GuiUniversity;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import delegate.UniversityDelegate;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import egov.entities.University;
import sessionbeans.UniversityManagement;
import javax.swing.JTree;
import java.awt.Font;
import javax.swing.ImageIcon;

public class addUniversity extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldname;
	private JTextField textFieldadress;
	private JTextField textFieldphone;
	/**
	 * @wbp.nonvisual location=43,369
	 */
	private final JTree tree = new JTree();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addUniversity frame = new addUniversity();
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
	public addUniversity() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblname = new JLabel("University");
		lblname.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblname.setBounds(10, 67, 63, 14);
		contentPane.add(lblname);
		
		JLabel lbladress = new JLabel("Adress");
		lbladress.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbladress.setBounds(10, 107, 46, 14);
		contentPane.add(lbladress);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPhone.setBounds(10, 149, 46, 14);
		contentPane.add(lblPhone);
		
		textFieldname = new JTextField();
		textFieldname.setBounds(99, 64, 200, 20);
		contentPane.add(textFieldname);
		textFieldname.setColumns(10);
		
		textFieldadress = new JTextField();
		textFieldadress.setBounds(99, 100, 200, 29);
		contentPane.add(textFieldadress);
		textFieldadress.setColumns(10);
		
		textFieldphone = new JTextField();
		textFieldphone.setBounds(99, 146, 200, 20);
		contentPane.add(textFieldphone);
		textFieldphone.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\mariem\\git\\egov-repo\\egov.client\\src\\main\\java\\images\\Add.gif"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              University univ =new University();
				
				univ.setName(textFieldname.getText());
				univ.setAdress(textFieldadress.getText());
				univ.setPhone(Integer.parseInt((textFieldphone.getText())));
				
					
			UniversityDelegate.doCreateUniversity(univ);	
					
				
			}
		});
		btnNewButton.setBounds(297, 199, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton Retourbtn = new JButton("Retour");
		Retourbtn.setIcon(new ImageIcon("C:\\Users\\mariem\\git\\egov-repo\\egov.client\\src\\main\\java\\images\\Back.gif"));
		Retourbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Retourbtn.setBounds(56, 199, 111, 23);
		contentPane.add(Retourbtn);
	}
}

