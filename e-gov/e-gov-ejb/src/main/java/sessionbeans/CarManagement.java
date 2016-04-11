 package sessionbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import egov.entities.Car;
import egov.entities.User;




@Stateless
public class CarManagement implements ICarManagementRemote,ICarManagementLocal {
	@PersistenceContext
	EntityManager Us;

	public Boolean addCar(Car c) {

		try {
			Us.persist(c);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public void flush() {
		Us.flush();
	}

	public Boolean update(Car u) {

		try {
			
			Us.merge(u);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Boolean remove(Car c) {
		try {
			Us.remove(Us.merge(c));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Car findCarByNumIm(int numImmatriculation) {
		Car car = null;
		try {
			car = Us.find(Car.class, numImmatriculation);

		} catch (Exception e) {

		}
		return car;
	}

	public List<Car> findAll() {
		List<Car>  cars = new ArrayList<>();
		Query query = Us.createQuery("select u from Car u");
		return query.getResultList();
	}

	
	

	public List<Car> findAllCarByIdUser( User u)
	{
		
		TypedQuery<Car> query =  Us.createNamedQuery("findCaroByUser", Car.class);
		query.setParameter("var", u.getIdUser());
		List<Car> cars= query.getResultList();
		return cars;
		
		
		
	}
	
	public Boolean removeCarByNum(int numImmatriculation){
	Car car=new Car();
	try {
		car = Us.find(Car.class,numImmatriculation);
		Us.remove(Us.merge(car));
		return true;
	} catch (Exception e) {
		return false;
	}

}
	
	public void affecterCarUser(Car c , User u)
	{
		c=Us.find(Car.class, c.getImmatriculation());
		u=Us.find(User.class, u.getIdUser());
		List<Car> cars=new ArrayList<>();
		cars=u.getCars();
		
		
		c.setUser(u);
		Us.merge(c);
		cars.add(c);
		u.setCars(cars);
		Us.merge(u);
		
	}}


