package Company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import delegate.CompanyDelegate;
import delegate.UserDelegate;
import egov.entities.Company;
import egov.entities.User;

import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.awt.event.ActionEvent;

public class UpDateComp extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField field;
	private JTextField sector;
	private JTextField adress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil frame = new Acceuil();
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
	public UpDateComp(int i) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		name = new JTextField();
		name.setColumns(10);
		
		field = new JTextField();
		field.setColumns(10);
		
		sector = new JTextField();
		sector.setColumns(10);
		
		adress = new JTextField();
		adress.setColumns(10);
		
		
		JLabel lblName = new JLabel("Name");
		
		JLabel lblField = new JLabel("Field");
		
		JLabel lblSector = new JLabel("Sector");
		
		JLabel lblAdress = new JLabel("Adress");
		
		JButton ok = new JButton("Submit");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Company company=CompanyDelegate.doFindCompanyById(i);
				
				company.setName(name.getText());
				company.setField(field.getText());
				company.setSector(sector.getText());
				company.setAdress(adress.getText());
			
				
				if(CompanyDelegate.doUpdateCompany(company))
						{
					JOptionPane.showMessageDialog(null," Company Modified ");
					
					
			     /*	company.setName("");
					company.setField("");
					company.setSector("");
					company.setAdress("");*/
						}
				else{}
			}
		});
		
		
		JButton ok1 =new JButton("Back");
		ok1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*	GreyCard2 a=new GreyCard2();
				a.setVisible(true);
				
				a.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e){
						
					}
				});*/
				
				GreyCard2 a=new GreyCard2();
				a.setVisible(true);
				
				a.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e){
						
					}
				});
				
				
			}
		});
		
		
		
		
		JLabel lblAddCompany = new JLabel("Modify Company");
		lblAddCompany.setFont(new Font("Source Sans Pro ExtraLight", Font.BOLD, 14));
		
	
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(112, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblName)
						.addComponent(lblField)
						.addComponent(lblSector, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAdress)
						)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(ok)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							
							.addComponent(ok1)
							.addGap(38)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(sector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(adress, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))))
					.addGap(137))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(164)
					.addComponent(lblAddCompany, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAddCompany, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(field, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblField))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(sector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSector))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdress)
						.addComponent(adress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					
					.addGap(19)
					.addComponent(ok)
					.addGap(19))
				.addComponent(ok1)
		);
		contentPane.setLayout(gl_contentPane);
	}
}
