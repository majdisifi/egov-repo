package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import delegate.AccountDelegate;
import delegate.UserDelegate;
import egov.entities.Account;
import egov.entities.User;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SendMoney extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String[][] donnes;
	private JTable table_1;
	private JButton btnSend;
	private JTextField ammount;
	private JLabel lblAmmount;
	private JTextField numAc;
	private JLabel lblNumAccount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendMoney frame = new SendMoney();
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
	public SendMoney() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 466);
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
		scrollPane.setBounds(80, 68, 362, 144);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("Actualize");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(98, 337, 89, 23);
		contentPane.add(btnNewButton);
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	        	
				int a = table.getSelectedRow();
				float am=Float.parseFloat(ammount.getText());
				
				
				int num2=Integer.parseInt(numAc.getText());
				int num1=5;
				if (AccountDelegate.SendMoney(num1, num2, am))
					JOptionPane.showMessageDialog(null, "Money has been sent");
				else
					JOptionPane.showMessageDialog(null, "erreur");
				
				//int num1=Integer.parseInt(donnes[a][2]);
				//System.out.println(num1);
				
				
				/*
				float am=Float.parseFloat(ammount.getText());
			
				int num2=5;
				if (AccountDelegate.SendMoney(num1, num2, am))
					JOptionPane.showMessageDialog(null, "Money has been sent");
				else
					JOptionPane.showMessageDialog(null, "erreur");
			
			*/
			}
				
			
		});
		btnSend.setBounds(279, 337, 89, 23);
		contentPane.add(btnSend);
		
		ammount = new JTextField();
		ammount.setBounds(257, 257, 86, 20);
		contentPane.add(ammount);
		ammount.setColumns(10);
		
		lblAmmount = new JLabel("Ammount");
		lblAmmount.setBounds(167, 260, 46, 14);
		contentPane.add(lblAmmount);
		
		numAc = new JTextField();
		numAc.setBounds(257, 288, 86, 20);
		contentPane.add(numAc);
		numAc.setColumns(10);
		
		lblNumAccount = new JLabel("Num Account");
		lblNumAccount.setBounds(144, 291, 79, 14);
		contentPane.add(lblNumAccount);
		List<Account> accounts = new ArrayList<Account>();

		accounts = AccountDelegate.doFindAccounts();
		System.out.println("done");
		donnes = new String[accounts.size()][4];
		for (int i = 0; i < accounts.size(); i++) {

			donnes[i][0] = accounts.get(i).getUser().getFirstName();
			donnes[i][1] = accounts.get(i).getUser().getLastName();
			donnes[i][2] = String.valueOf(accounts.get(i).getNum());
			donnes[i][3] = String.valueOf(accounts.get(i).getAmmount());

		}

		table_1.setModel(new javax.swing.table.DefaultTableModel(donnes,
				new String[] { "First Name", "Last Name", "Account Number", "Ammount" }));
	
	}

}
