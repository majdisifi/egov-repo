package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import delegate.CarDelegate;
import delegate.UserDelegate;
import egov.entities.Car;
import egov.entities.User;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ManageCar extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String[][] donnes;
	List<Car> us;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageCar frame = new ManageCar();
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
	public ManageCar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 72, 534, 160);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(84, 277, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setBounds(242, 277, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(424, 277, 89, 23);
		contentPane.add(btnDelete);
		
		JLabel lblCarList = new JLabel("Car List");
		lblCarList.setBounds(263, 28, 46, 14);
		contentPane.add(lblCarList);
	
	try {

		List<Car> cars = new ArrayList<Car>();

		cars=CarDelegate.findAll();
		System.out.println("done");
		donnes = new String[cars.size()][4];
		for (int i = 0; i < cars.size(); i++) {
			
			
			donnes[i][0] =String.valueOf(cars.get(i).getImmatriculation());
			donnes[i][1] = cars.get(i).getCategory();
			donnes[i][2] = cars.get(i).getColor();
	
			donnes[i][3] = cars.get(i).getConstructor();
			donnes[i][4] = cars.get(i).getType();
			donnes[i][5] = cars.get(i).getGender();
			donnes[i][7] = users.get(i).getEmail();
			donnes[i][8] = String.valueOf(users.get(i).getDeathDate());
			private int numImmatriculation;
			private String color;
			private String type;
			private String category;
			private String constructor;
			

		}

		table.setModel(new javax.swing.table.DefaultTableModel(donnes,
				new String[] { "numImmatriculation","color name", "type", "category", "constructor place"}));

	} catch (Exception e1) {
		e1.printStackTrace();
	}}

}
