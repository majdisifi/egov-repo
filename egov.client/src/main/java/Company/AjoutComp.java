package Company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import delegate.CompanyDelegate;
import egov.entities.Company;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class AjoutComp extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldField;
	private JTextField textFieldSector;
	private JTextField textFieldAdress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutComp frame = new AjoutComp();
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
	public AjoutComp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 49, 82, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Field");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 92, 82, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sector");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 134, 82, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Adress");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 183, 82, 14);
		contentPane.add(lblNewLabel_3);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(111, 46, 190, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldField = new JTextField();
		textFieldField.setBounds(113, 89, 190, 20);
		contentPane.add(textFieldField);
		textFieldField.setColumns(10);
		
		textFieldSector = new JTextField();
		textFieldSector.setBounds(116, 131, 190, 20);
		contentPane.add(textFieldSector);
		textFieldSector.setColumns(10);
		
		textFieldAdress = new JTextField();
		textFieldAdress.setBounds(119, 180, 182, 20);
		contentPane.add(textFieldAdress);
		textFieldAdress.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Lenovo\\git\\egov-repo\\egov.client\\src\\main\\java\\images\\Apply.gif"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Company company=new Company();
				company.setName(textFieldName.getText());
				company.setField(textFieldField.getText());
				company.setSector(textFieldSector.getText());
				company.setAdress(textFieldAdress.getText());
				
				if (textFieldName.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "emty name's case");
				}
			
				
				
					
					
					
					
					
					
					if(CompanyDelegate.CreateCompany(company))
						{
					JOptionPane.showMessageDialog(null," Company added ");
					
					
					/*company.setName("");
					company.setField("");
					company.setSector("");
					company.setAdress("");*/
						}
				else{}
				
				
			}
		});
		btnNewButton.setBounds(117, 228, 126, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Lenovo\\git\\egov-repo\\egov.client\\src\\main\\java\\images\\Previous.gif"));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GreyCard2 a=new GreyCard2();
				a.setVisible(true);
				
				a.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e){
						
					}
				});
				
				
				
			}
		});
		btnNewButton_1.setBounds(298, 228, 126, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblAddCompany = new JLabel("Add Company");
		lblAddCompany.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAddCompany.setBounds(131, 11, 146, 28);
		contentPane.add(lblAddCompany);
	}
}
