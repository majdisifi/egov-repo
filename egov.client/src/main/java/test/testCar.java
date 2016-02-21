package test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import egov.entities.Car;
import egov.entities.User;
import sessionbeans.ICarManagementRemote;
import sessionbeans.IUserManagementRemote;
public class testCar {

	@Test
	public void AddCar() {
		Context context;

		try {
			context = new InitialContext();

			ICarManagementRemote ge = (ICarManagementRemote) context
					.lookup("egov.ejb/CarManagement!sessionbeans.ICarManagementRemote");

Car car = new Car();
car.setImmatriculation(5555415);
car.setCategory("Coupé");
car.setColor("rouge");
car.setType("Golf");

car.setConstructor("almand");
		ge.addCar(car);

		} catch (NamingException e) {

	
			e.printStackTrace();
		}
	}
	@Test
	public void updateCar() {
		Context context;

		try {
			context = new InitialContext();

			ICarManagementRemote ge = (ICarManagementRemote) context
					.lookup("egov.ejb/CarManagement!sessionbeans.ICarManagementRemote");

			Car car  = ge.findCarByNumIm(5555415);
			car.setCategory("Sport");
			car.setColor("bleu");
			car.setType("bmw");
			car.setConstructor("almand");
		
			if (ge.update(car)) {
				System.out.println("modification avec succes");
			} else
				System.out.println("Erreur de modification");

		} catch (NamingException e) {

	
			e.printStackTrace();
		}

	}
	@Test
	public void deleteCar() {
		Context context;

		try {
			context = new InitialContext();

			ICarManagementRemote ge = (ICarManagementRemote) context
					.lookup("egov.ejb/CarManagement!sessionbeans.ICarManagementRemote");

			Car car  = ge.findCarByNumIm(45722);
			if (ge.remove(car)) {
				System.out.println("Supréssion avec succes");
			} else
				System.out.println("Erreur de Supression");
		
			

		} catch (NamingException e) {

	
			e.printStackTrace();
		}

	}
	
}



