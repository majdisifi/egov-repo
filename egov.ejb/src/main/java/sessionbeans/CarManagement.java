package sessionbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import egov.entities.Car;
import egov.entities.User;



@Stateless
public class CarManagement implements ICarManagementRemote {
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

	@Override
	public Car findCarByNumIm(int numImmatriculation) {
		Car car = null;
		try {
			car = Us.find(Car.class, numImmatriculation);

		} catch (Exception e) {

		}
		return car;
	}

	@Override
	public List<User> findAll() {
		List<Car>  cars = new ArrayList<>();
		Query query = Us.createQuery("select u from Car u");
		return query.getResultList();
	}

}


