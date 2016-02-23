package CaseGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.data.general.DefaultPieDataset;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import delegate.CompanyDelegate;
import delegate.KaseDelegate;
import delegate.UserDelegate;
import egov.entities.Company;
import egov.entities.Kase;
import egov.entities.User;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class UpdateCase extends JFrame {

	private JPanel contentPane;
	private JTextField nameCase;
	private JTextField judgment;
	private JTextField datecase;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutOFCase frame = new AjoutOFCase();
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
	public UpdateCase(int i) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name Case");
		lblNewLabel.setBounds(20, 72, 95, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblJudgment = new JLabel("Judgment");
		lblJudgment.setBounds(20, 117, 95, 24);
		contentPane.add(lblJudgment);
		
		JLabel lblDateCase = new JLabel("Date Case");
		lblDateCase.setBounds(20, 164, 71, 24);
		contentPane.add(lblDateCase);
		
		nameCase = new JTextField();
		nameCase.setBounds(174, 74, 86, 20);
		contentPane.add(nameCase);
		nameCase.setColumns(10);
		
		judgment = new JTextField();
		judgment.setBounds(174, 119, 86, 20);
		contentPane.add(judgment);
		judgment.setColumns(10);
		
		JDateChooser dato = new JDateChooser();
		dato.setBounds(173, 164, 87, 20);
		contentPane.add(dato);
		
		JLabel lblAddcase = new JLabel("UpDateCase");
		lblAddcase.setBounds(173, 11, 211, 14);
		lblAddcase.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblAddcase);
		 List<User>Typs = new ArrayList<>();
		 Typs=UserDelegate.doFindAllUsers();
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(174, 209, 86, 20);
		 for ( int j=0; j < Typs.size(); j++)
	        {
		    	comboBox.addItem(Typs.get(j).getFirstName());
	      	  
	        }
		    comboBox.setSelectedIndex(0);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("UpDate");
		btnNewButton.setBounds(10, 248, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Date d=dato.getDate();
				Kase cases=KaseDelegate.doFindCaseById(i);
				cases.setNameCase(nameCase.getText());
				cases.setJudgment(judgment.getText());
				cases.setDateCase(d);
				
				int type = comboBox.getSelectedIndex();
				User user=UserDelegate.doFindUserById(type);
					
				
				cases.setUser(user);
				
				if(KaseDelegate.doUpdateCase(cases))
					
				{
			JOptionPane.showMessageDialog(null," Case modified ");
			}
				else{}
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Print");
		btnNewButton_2.setBounds(231, 248, 89, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListCases cs=new ListCases();
				cs.setVisible(true);
			cs.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
						
						}
					});		

			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(335, 9, 89, 23);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btnRetour);
		
		
		/*JButton btnNewButton_4 = new JButton("Pie Chart");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultPieDataset pieDataset=new DefaultPieDataset();
				pieDataset.setValue("one", new Integer(10));
				pieDataset.setValue("two", new Integer(20));
				pieDataset.setValue("three", new Integer(30));
				pieDataset.setValue("for", new Integer(40));
				
				
			});
		btnNewButton_4.setBounds(171, 419, 89, 23);
		contentPane.add(btnNewButton_4);*/
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(20, 210, 58, 27);
		contentPane.add(lblUser);
		  
		
	}
}
