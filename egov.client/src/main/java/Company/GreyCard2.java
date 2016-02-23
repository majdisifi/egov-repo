package Company;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



import delegate.CarDelegate;
import delegate.CompanyDelegate;
import delegate.UserDelegate;
import egov.entities.Car;
import egov.entities.Company;
import javax.swing.ImageIcon;

public class GreyCard2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel	model;
	TableRowSorter<TableModel> sorter ;
	public int a;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GreyCard2 frame = new GreyCard2();
					
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
	public GreyCard2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setBackground(new Color(199, 21, 133));
		setFont(new Font("Vivaldi", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(GreyCard2.class.getResource("/images/List.gif")));
		getContentPane().setForeground(Color.WHITE);
		setTitle("GreyCardList");
	
		//setBounds(100, 100, 520, 377);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 709, 33);
		panel.setBackground(UIManager.getColor("Button.shadow"));
		panel.setLayout(null);

		
		//String[] filterTypeStrings = { "    Name    ", "    Address    "};
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1038, 369);
		panel.add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setForeground(Color.WHITE);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(733, 71, 295, 298);
		panel_1.add(lblNewLabel);
		
		JButton btnPieChart = new JButton("Add");
		btnPieChart.setIcon(new ImageIcon("C:\\Users\\Lenovo\\git\\egov-repo\\egov.client\\src\\main\\java\\images\\Add.gif"));
		btnPieChart.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnPieChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			/*	DefaultPieDataset PieDataset =new DefaultPieDataset ();	
				
		        
			       List<egov.entities.User> ListMag =  UserDelegate.doFindAllUsers();
							        
							for (egov.entities.User m:ListMag){
							     int nbr= UserDelegate.doNbreCarByUser(m).size();
							      System.out.println(nbr);
							     PieDataset.setValue(m.getLastName(),nbr);
							        
							}
							        JFreeChart chart = ChartFactory.createPieChart("The Articles Repartition By Magazine", PieDataset, true, true,true);
							        PiePlot p = (PiePlot)chart.getPlot();
							       // p.setForegroundAlpha(TOP_ALIGNMENT);
							        ChartFrame frame =new ChartFrame("Magazine PieChart",chart);
							        frame.setVisible(true);
							        frame.setSize(430, 500);*/
				
							        
				AjoutComp a=new AjoutComp();
				a.setVisible(true);
				
				a.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e){
						
					}
				});
				
		  
				
			}
			
			
		});
		btnPieChart.setBounds(10, 11, 89, 23);
		panel_1.add(btnPieChart);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon("C:\\Users\\Lenovo\\git\\egov-repo\\egov.client\\src\\main\\java\\images\\Delete.gif"));
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteCompany();
			}
		});
		btnDelete.setBounds(193, 11, 122, 23);
		panel_1.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\Lenovo\\git\\egov-repo\\egov.client\\src\\main\\java\\images\\Apply.gif"));
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer i=table.getSelectedRow();
				javax.swing.table.TableModel model = table.getModel();
			  a= (Integer) model.getValueAt(i, 0);
				System.out.println(a);
				UpDateComp Mm=new UpDateComp(a);
				Mm.setVisible(true);
		Mm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//loadTableData();
					}
					});
				
				
				
			}
		});
		btnUpdate.setBounds(433, 11, 135, 23);
		panel_1.add(btnUpdate);
		
		JTextArea txtrKlbhkgb = new JTextArea();
		txtrKlbhkgb.setLineWrap(true);
		txtrKlbhkgb.setWrapStyleWord(true);
		txtrKlbhkgb.setBackground(UIManager.getColor("Button.light"));
		
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
		

		
			    

        JScrollPane scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        scrollPane_1.setColumnHeaderView(scrollPane);
		getContentPane().setLayout(null);
		
		getContentPane( ).add(panel);
		getContentPane( ).add(scrollPane_1);
	}
	public void loadTableData(){
		model = new DefaultTableModel(
				new Object[][] {
						
				},
			new String[] {"Id","Name", "Field", "Sector","Adress"		}	);

		
			List<Company>ls=CompanyDelegate.doFindAllCompanies();
		
		for(Company Com:ls){
				//System.out.println(sh.getTitle());
				//System.out.println(app.getUser().getIdUser());
				model.addRow(new Object[]{Com.idCompany(),Com.getName(),Com.getField(),Com.getSector(),Com.getAdress()
						});
			
			}
			table.setModel(model);
			sorter = new TableRowSorter<TableModel>(model);

			    table.setRowSorter(sorter);
	
			
			
	}
			
	private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();
 
        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print(" row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
        
        
        
    }
	public void deleteCompany()
	{
	Integer i=table.getSelectedRow();
		javax.swing.table.TableModel model = table.getModel();
	int  a= (Integer) model.getValueAt(i, 0);
		System.out.println(a);
       
	Company cmp =CompanyDelegate.doFindCompanyById(a);
		CompanyDelegate.doDeleteCompany(cmp);
        loadTableData();
		
	
	}

}
