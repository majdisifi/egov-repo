package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import delegate.AccountDelegate;
import delegate.UserDelegate;
import egov.entities.Account;
import egov.entities.User;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BankAccountManage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String[][] donnes;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankAccountManage frame = new BankAccountManage();
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
	public BankAccountManage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 93, 534, 160);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setColumnHeaderView(table);

		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		table_2 = new JTable();
		scrollPane.setColumnHeaderView(table_2);

		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account ac = new Account();
				int a = table.getSelectedRow();
				int x = Integer.parseInt(donnes[a][3]);
				Account c=AccountDelegate.doAccount(x);
				c.setUser(null);
				AccountDelegate.doDeleteAccount(ac);
				
			}
		});
		btnDelete.setBounds(70, 281, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnPdf = new JButton("pdf");
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document document = new Document();
		        try{
		        	
		        	
		        	User us = new User();
					int a = table.getSelectedRow();
	             
					int x = Integer.parseInt(donnes[a][0]);
					
					
				
		        	String fn =donnes[a][2];
					String ln = donnes[a][1];
					String num=donnes[a][0];
					String am=donnes[a][4];
				
					
		        	
		        	PdfWriter.getInstance(document, new FileOutputStream("D:\\AccountStatement-"+donnes[a][1]+".pdf"));
		            document.open();
		           
		            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 48, Font.ITALIC | Font.BOLD | Font.BOLD);
		            
		            Paragraph p1 = new Paragraph("First Name "+fn);
		            Paragraph p2 = new Paragraph("Last Name :" +ln);
		            Paragraph p3 = new Paragraph("Account Number :" +num);
		            Paragraph p4 = new Paragraph("Ammount  :" +am);
		         
		          
		          
		            p1.setAlignment(Element.ALIGN_CENTER);
		            p2.setAlignment(Element.ALIGN_CENTER);
		            p3.setAlignment(Element.ALIGN_CENTER);
		            p4.setAlignment(Element.ALIGN_CENTER);
		            
		       
		        
		            
		 
		            document.add(p1);
		            
		            //add blank line
		    	    document.add( Chunk.NEWLINE );
		            document.add(p2);
		            document.add( Chunk.NEWLINE );
		            document.add(p3);
		            document.add( Chunk.NEWLINE );
		            document.add(p4);
		         
		       
		           
		           
		            document.close();
		        }
		        catch(Exception n){
		            System.out.println(n);
		        }
		        document.close();
		    
			}
				
			
		});
		btnPdf.setBounds(431, 281, 89, 23);
		contentPane.add(btnPdf);
		
		JLabel lblUsersAccount = new JLabel("User's Account");
		lblUsersAccount.setBounds(249, 23, 89, 39);
		contentPane.add(lblUsersAccount);
		

		List<Account> accounts = new ArrayList<Account>();

		accounts = AccountDelegate.doFindAccounts();
		System.out.println("done");
		donnes = new String[accounts.size()][8];
		for (int i = 0; i < accounts.size(); i++) {

			donnes[i][0] = accounts.get(i).getUser().getFirstName();
			donnes[i][1] = accounts.get(i).getUser().getLastName();
			donnes[i][2] = String.valueOf(accounts.get(i).getNum());
			donnes[i][3] = String.valueOf(accounts.get(i).getAmmount());

		}

		table_1.setModel(new javax.swing.table.DefaultTableModel(donnes,
				new String[] { "First Name", "Last Name", "Account Number", "Ammount" }));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(249, 281, 89, 23);
		contentPane.add(btnAdd);
	}
		
	}
	
	
