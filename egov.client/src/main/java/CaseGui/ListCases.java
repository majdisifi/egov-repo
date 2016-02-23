package CaseGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.LayoutManager;
import java.lang.String;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import delegate.KaseDelegate;
import delegate.UserDelegate;
import egov.entities.Kase;
import egov.entities.User;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ListSelectionModel;

import java.awt.Panel;
import java.awt.ScrollPane;


import java.awt.Label;

import javax.swing.JScrollPane;
import javax.swing.JToggleButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import java.awt.SystemColor;
public class ListCases extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel	model;
	private JComboBox filterList;
	TableRowSorter<TableModel> sorter ;
	public int a;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListCases frame = new ListCases();
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
	public ListCases() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 721, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		getContentPane().setForeground(Color.WHITE);
		setTitle("List");
	
		//setBounds(100, 100, 520, 377);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 709, 33);
		panel.setBackground(UIManager.getColor("Button.shadow"));
		panel.setLayout(null);

		
		String[] filterTypeStrings = { "   Case Name    ", "    Judgment    "};
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1038, 369);
		panel.add(panel_1);
		panel_1.setBackground(SystemColor.window);
		panel_1.setForeground(Color.WHITE);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(733, 71, 295, 298);
		panel_1.add(lblNewLabel);
		
				//Create the combo box, select item at index 4.
				//Indices start at 0, so 4 specifies the pig.
				filterList = new JComboBox(filterTypeStrings);
				filterList.setBounds(124, 11, 88, 20);
				panel_1.add(filterList);
				filterList.setSelectedIndex(1);
				
				JButton btnNewButton_1 = new JButton("OK",new ImageIcon("G:\\cours ESPRIT\\fadhel\\provisoire2\\egov.ejb\\src\\main\\java\\images\\OK.gif"));
				btnNewButton_1.setBounds(311, 10, 75, 23);
				panel_1.add(btnNewButton_1);
				
				JButton btnNewButton_2 = new JButton("Add", new ImageIcon("images/Add.gif"));
				btnNewButton_2.setBounds(396, 10, 69, 23);
				panel_1.add(btnNewButton_2);
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
//						
						AjoutOFCase cs=new AjoutOFCase();
						cs.setVisible(true);
					cs.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
								loadTableData();
								}
							});						
				
					}
				});
				btnNewButton_2.setToolTipText("Create");
				
				JButton btnNewButton = new JButton("Delete",new ImageIcon("G:\\cours ESPRIT\\fadhel\\provisoire2\\egov.ejb\\src\\main\\java\\images\\Delete.gif"));
				btnNewButton.setBounds(469, 10, 110, 23);
				panel_1.add(btnNewButton);
				
				
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						deleteShop();
						}
				});
				
				btnNewButton.setToolTipText("Delete");
				//	panel.setBounds(0, 0, 494, 33);
					
					
					JTextPane txtpnRechercher = new JTextPane();
					txtpnRechercher.setBounds(10, 11, 47, 20);
					panel_1.add(txtpnRechercher);
					txtpnRechercher.setBackground(UIManager.getColor("Button.background"));
					txtpnRechercher.setText("Search");
					
					textField = new JTextField();
					textField.setBounds(67, 11, 47, 20);
					panel_1.add(textField);
					textField.setColumns(10);
					
					JButton btnNewButton_3 = new JButton("UpDate");
					btnNewButton_3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							Integer i=table.getSelectedRow();
							javax.swing.table.TableModel model = table.getModel();
						  a= (Integer) model.getValueAt(i, 0);
							System.out.println(a);
							UpdateCase Mm=new UpdateCase(a);
							Mm.setVisible(true);
					Mm.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							//loadTableData();
								}
								});
						}
					});
					btnNewButton_3.setBounds(222, 10, 89, 23);
					panel_1.add(btnNewButton_3);
					
					JButton btnStatisitics = new JButton("Statisitics ");
					btnStatisitics.setIcon(new ImageIcon("G:\\cours ESPRIT\\fadhel\\provisoire2\\egov.ejb\\src\\main\\java\\images\\3d bar chart.gif"));
					btnStatisitics.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							
							DefaultPieDataset PieDataset =new DefaultPieDataset ();	
							
					        
						       List <User> Listu =  UserDelegate.doFindAllUsers();
										        
										for (User m:Listu){
										     int nbr=UserDelegate.CaseByUser(m).size();
										      System.out.println(nbr);
										     PieDataset.setValue(m.getLastName(),nbr);
										        
										}
										        JFreeChart chart = ChartFactory.createPieChart("The Cases of the Users", PieDataset, true, true,true);
										        PiePlot p = (PiePlot)chart.getPlot();
										      
										        ChartFrame frame =new ChartFrame("Users",chart);
										        frame.setVisible(true);
										        frame.setSize(430, 500);
							
							
						}
					});
					btnStatisitics.setBounds(589, 10, 120, 23);
					panel_1.add(btnStatisitics);
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					     System.out.println("Start Filter");
					     String text = textField.getText();
					     int type = filterList.getSelectedIndex();
					     RowFilter<TableModel, Object> rf = null;
					     //If current expression doesn't parse, don't update.
					     try {
					         rf = RowFilter.regexFilter(text, type);
					     } catch (java.util.regex.PatternSyntaxException e1) {
					         return;
					     }
					     sorter.setRowFilter(rf);
					  }
					
				});
		
		JTextArea txtrKlbhkgb = new JTextArea();
		txtrKlbhkgb.setLineWrap(true);
		txtrKlbhkgb.setWrapStyleWord(true);
		txtrKlbhkgb.setBackground(UIManager.getColor("Button.light"));
		txtrKlbhkgb.setText("les formateures");
		txtrKlbhkgb.setBounds(37, 42, 148, 22);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 34, 709, 429);
		
		table = new JTable();
		
		table.setCellSelectionEnabled(true);
		table.setAutoCreateRowSorter(true);
		
		
//		table.setPreferredScrollableViewportSize(new Dimension(400, 70));
        table.setFillsViewportHeight(true);
 
		table.setForeground(Color.BLACK);
		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		//table.setCellSelectionEnabled(true);
		table.setBackground(Color.WHITE);

		loadTableData();
		
		
		
			    
        
//    	    RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
//			      public boolean include(Entry entry) {
//			        Integer population = (Integer) entry.getValue(1);
//			        return population.intValue() > 3;
//			      }
//			    };

			 //   TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
			  //  sorter.setRowFilter(filter);
			   // table.setRowSorter(sorter);
			    
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        scrollPane_1.setColumnHeaderView(scrollPane);
		getContentPane().setLayout(null);
		
		getContentPane( ).add(panel);
		getContentPane( ).add(scrollPane_1, BorderLayout.NORTH);
	}
	public void loadTableData(){
		model = new DefaultTableModel(
				new Object[][] {
						
				},
				new String[] {
				"CaseNum","dateCase", "Judgment", "nameCase",  "User",
			}
		);

		
			List<Kase>ls=KaseDelegate.doFindAllCases();
		
			for(Kase  app:ls){
				//sh=(Kase)app;
				System.out.println(app.getNameCase());
			
				model.addRow(new Object[]{app.getIdCase(),app.getDateCase(),app.getJudgment(),app.getNameCase(),app.getUser().getFirstName()});
	
			}
			table.setModel(model);
			sorter = new TableRowSorter<TableModel>(model);
			  //  sorter.setRowFilter(filter);
			    table.setRowSorter(sorter);
		
			
			
	}
			
	private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();
 
        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
        
        
        
    }
	
	public void deleteShop()
	{
	Integer i=table.getSelectedRow();
		javax.swing.table.TableModel model = table.getModel();
	int  a= (Integer) model.getValueAt(i, 0);
		System.out.println(a);
       
	Kase shop =KaseDelegate.doFindCaseById(a);
		KaseDelegate.doDeleteCase(shop);
        loadTableData();
		
	
	}

}
