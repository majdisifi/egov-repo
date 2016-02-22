package delegate;

import java.util.List;

import egov.entities.Car;
import egov.entities.User;
import locator.ServiceLocator;
import sessionbeans.IAccountManagementRemote;
import sessionbeans.ICarManagementRemote;
import sessionbeans.IUserManagementRemote;

public class CarDelegate {
	public static ICarManagementRemote remote;
	public static final String jndi="egov.ejb/CarManagement!sessionbeans.ICarManagementRemote";
	public static ICarManagementRemote getProxy(){
		return (ICarManagementRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	public static boolean addCar(Car c){
		return getProxy().addCar(c);
	}
	public static boolean update(Car c){
		return getProxy().update(c);
	}
	
	public static boolean remove(Car c){
		return getProxy().remove(c);
	}
	public static  List<Car> findAll(){
		return getProxy().findAll();
	}
	public static  Car findCarByNumIm(int numImmatriculation){
		return getProxy().findCarByNumIm(numImmatriculation);
	}
}
