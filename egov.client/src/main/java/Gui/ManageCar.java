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
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageCar extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String[][] donnes;
	String[][] donnes1;
	List<Car> us;
	
	private JTextField Imm;
	private JTextField color;
	private JTextField type;
	private JTextField category;
	private JTextField constructor;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JButton btnShowCars;
	private JLabel lblImmatriculation;
	private JLabel lblColor;
	private JLabel lblConstuctor;
	private JLabel lblCategory;
	private JLabel lblType;

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
		setBounds(100, 100, 997, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(372, 60, 534, 160);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String im = Imm.getText();
				String col = color.getText();
				String typ= type.getText();
				String cons=constructor.getText();
				String cat=category.getText();
				
				
			
				

				Car car = new Car();
					car.setImmatriculation(Integer.parseInt(im));
					car.setColor(col);
					car.setType(typ);
					car.setConstructor(cons);
					car.setCategory(cat);
					CarDelegate.addCar(car);
					
					User user=UserDelegate.doFindUserById(1);
				CarDelegate.affecterCarUser(car, user);
			
				JOptionPane.showMessageDialog(null, "Car Added");
				
				
				
				///

				try {

					List<Car> cars = new ArrayList<Car>();

					cars=CarDelegate.findAll();
					System.out.println("done");
					donnes = new String[cars.size()][7];
					for (int i = 0; i < cars.size(); i++) {
						
						
						donnes[i][0] =String.valueOf(cars.get(i).getImmatriculation());
						donnes[i][1] = cars.get(i).getCategory();
						donnes[i][2] = cars.get(i).getColor();
				
						donnes[i][3] = cars.get(i).getConstructor();
						donnes[i][4] = cars.get(i).getType();
						
						donnes[i][5] = cars.get(i).getUser().getFirstName();
						donnes[i][6] = cars.get(i).getUser().getLastName();
						
						
						
						

					}

					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "numImmatriculation","category", "color", "constructor", "type","First_Name","last name"}));
					
					
					
					

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			
				
				
				
				
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(415, 250, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = table.getSelectedRow();

				int x = Integer.parseInt(donnes[a][0]);
				

				String aa=category.getText();
						String b=color.getText();
						String c=constructor.getText();
						String d=type.getText();
						
				Car car = CarDelegate.findCarByNumIm(x);
				
				if (aa.equals(""))
					car.setCategory(donnes[a][1]);
					
				else

					car.setCategory(aa);
				
				
				if (b.equals(""))
					car.setColor(donnes[a][2]);
					
				else

					car.setColor(b);
				
				if (c.equals(""))
					car.setConstructor(donnes[a][3]);
					
				else

					car.setConstructor(c);
				
				
				if (d.equals(""))
					car.setType(donnes[a][4]);
					
				else

					car.setType(d);
				
				
				
				
				
				
				
				//System.out.println(donnes[a][1]);
				CarDelegate.update(car);
				/*
				String im = Imm.getText();
				String col = color.getText();
				String typ= type.getText();
				String cons=constructor.getText();
				String cat=category.getText();
				

				if (im.equals(""))
					car.setImmatriculation(Integer.parseInt(donnes[a][0]));
				else

					car.setImmatriculation(Integer.parseInt(im));

				if (col.equals(""))
					car.setColor(donnes[a][2]);
				else
					car.setColor(col);

				if (typ.equals(""))
					car.setType(donnes[a][4]);
				else
					car.setType(typ);
				
				if (cons.equals(""))
					car.setType(donnes[a][3]);
				else
					car.setConstructor(cons);

				if (cat.equals(""))
					car.setCategory(donnes[a][1]);
				else
					car.setCategory(cat);



				if (CarDelegate.update(car))
					JOptionPane.showMessageDialog(null, " Car updated");
				else
					JOptionPane.showMessageDialog(null, "erreur");*/
				
				//////////
				
				try {

					List<Car> cars = new ArrayList<Car>();

					cars=CarDelegate.findAll();
					System.out.println("done");
					donnes = new String[cars.size()][7];
					for (int i = 0; i < cars.size(); i++) {
						
						
						donnes[i][0] =String.valueOf(cars.get(i).getImmatriculation());
						donnes[i][1] = cars.get(i).getCategory();
						donnes[i][2] = cars.get(i).getColor();
				
						donnes[i][3] = cars.get(i).getConstructor();
						donnes[i][4] = cars.get(i).getType();
						
						donnes[i][5] = cars.get(i).getUser().getFirstName();
						donnes[i][6] = cars.get(i).getUser().getLastName();
						
						
						
						

					}

					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "numImmatriculation","category", "color", "constructor", "type","First_Name","last name"}));
					
					
					
					

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(583, 250, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				Car c = new Car();
				int a = table.getSelectedRow();
                 
				int x = Integer.parseInt(donnes[a][0]);
			
				Car car  = CarDelegate.findCarByNumIm(x);
				//System.out.println(car.getColor());
				User user = car.getUser();
				UserDelegate.doDeleteUser(user);
				

				if (CarDelegate.remove(car))
					JOptionPane.showMessageDialog(null, "Car Deleted");
				
				else
					JOptionPane.showMessageDialog(null, "erreur");
				
				////
				
				
				try {

					List<Car> cars = new ArrayList<Car>();

					cars=CarDelegate.findAll();
					System.out.println("done");
					donnes = new String[cars.size()][7];
					for (int i = 0; i < cars.size(); i++) {
						
						
						donnes[i][0] =String.valueOf(cars.get(i).getImmatriculation());
						donnes[i][1] = cars.get(i).getCategory();
						donnes[i][2] = cars.get(i).getColor();
				
						donnes[i][3] = cars.get(i).getConstructor();
						donnes[i][4] = cars.get(i).getType();
						
						donnes[i][5] = cars.get(i).getUser().getFirstName();
						donnes[i][6] = cars.get(i).getUser().getLastName();
						
						
						
						

					}

					table.setModel(new javax.swing.table.DefaultTableModel(donnes,
							new String[] { "numImmatriculation","category", "color", "constructor", "type","First_Name","last name"}));
					
					
					
					

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(754, 250, 89, 23);
		contentPane.add(btnDelete);
		
		JLabel lblCarList = new JLabel("Car List");
		lblCarList.setBounds(576, 23, 46, 14);
		contentPane.add(lblCarList);
	
	try {

		List<Car> cars = new ArrayList<Car>();

		cars=CarDelegate.findAll();
		System.out.println("done");
		donnes = new String[cars.size()][7];
		for (int i = 0; i < cars.size(); i++) {
			
			
			donnes[i][0] =String.valueOf(cars.get(i).getImmatriculation());
			donnes[i][1] = cars.get(i).getCategory();
			donnes[i][2] = cars.get(i).getColor();
	
			donnes[i][3] = cars.get(i).getConstructor();
			donnes[i][4] = cars.get(i).getType();
			
			donnes[i][5] = cars.get(i).getUser().getFirstName();
			donnes[i][6] = cars.get(i).getUser().getLastName();
			
			
			
			

		}

		table.setModel(new javax.swing.table.DefaultTableModel(donnes,
				new String[] { "numImmatriculation","category", "color", "constructor", "type","First_Name","last name"}));
		
		
		
		

	} catch (Exception e1) {
		e1.printStackTrace();
	}
	
		Imm = new JTextField();
		Imm.setBounds(188, 118, 86, 20);
		contentPane.add(Imm);
		Imm.setColumns(10);
		
		color = new JTextField();
		color.setBounds(188, 171, 86, 20);
		contentPane.add(color);
		color.setColumns(10);
		
		type = new JTextField();
		type.setBounds(188, 232, 86, 20);
		contentPane.add(type);
		type.setColumns(10);
		
		category = new JTextField();
		category.setBounds(188, 292, 86, 20);
		contentPane.add(category);
		category.setColumns(10);
		
		constructor = new JTextField();
		constructor.setBounds(188, 350, 86, 20);
		contentPane.add(constructor);
		constructor.setColumns(10);
		
		

	
		btnShowCars = new JButton("Show User of the Car");
		btnShowCars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
			}
		});
		btnShowCars.setBounds(503, 302, 149, 23);
		contentPane.add(btnShowCars);
		
		lblImmatriculation = new JLabel("Immatriculation");
		lblImmatriculation.setBounds(82, 120, 100, 17);
		contentPane.add(lblImmatriculation);
		
		lblColor = new JLabel("Color");
		lblColor.setBounds(102, 174, 46, 14);
		contentPane.add(lblColor);
		
		lblConstuctor = new JLabel("Constuctor");
		lblConstuctor.setBounds(99, 351, 66, 19);
		contentPane.add(lblConstuctor);
		
		lblCategory = new JLabel("Category");
		lblCategory.setBounds(102, 295, 46, 14);
		contentPane.add(lblCategory);
		
		lblType = new JLabel("Type");
		lblType.setBounds(102, 235, 46, 14);
		contentPane.add(lblType);

	}

}
