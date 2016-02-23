package test;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import delegate.CarDelegate;
import delegate.UserDelegate;
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
car.setImmatriculation(4566);
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

			Car car  = ge.findCarByNumIm(444);
			//User aa = UserDelegate.doFindUserById(1);
			car.setCategory("aaaaaaaaaaaaaaaaa");
			//car.setUser(aa);
			
			
		
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
		
			Car car  = CarDelegate.findCarByNumIm(15);
			//System.out.println(car.getColor());
			User user = car.getUser();
			UserDelegate.doDeleteUser(user);
			CarDelegate.remove(car);
	
	}
	
	@Test
	public void Test_Car_user() {
		Context context;
		Context context1;
		try {
			context = new InitialContext();
			ICarManagementRemote ge = (ICarManagementRemote) context
					.lookup("egov.ejb/CarManagement!sessionbeans.ICarManagementRemote");
			
			IUserManagementRemote re = (IUserManagementRemote) context
					.lookup("egov.ejb/UserManagement!sessionbeans.IUserManagementRemote");
			Car car = new Car();
			car.setImmatriculation(12456);
			car.setCategory("Bmmmmmmw");
			car.setColor("Bleu");
			
			User user = re.findUserById(9);
			List<Car> c = new ArrayList<>();
			car.setUser(user);
			c.add(car);
			user.setCars(c);
			
		re.update(user);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
	
}



