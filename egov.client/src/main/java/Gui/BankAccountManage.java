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

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class BankAccountManage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String[][] donnes;
	private JTable table_1;

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
		scrollPane.setBounds(30, 29, 534, 160);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setColumnHeaderView(table);

		table_1 = new JTable();
		scrollPane.setViewportView(table_1);

		JButton btnUpdate = new JButton("actualiser");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
			}

		});
		btnUpdate.setBounds(181, 281, 89, 23);
		contentPane.add(btnUpdate);

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
		btnDelete.setBounds(313, 281, 89, 23);
		contentPane.add(btnDelete);
	}
}
