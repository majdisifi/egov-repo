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
public class UserManagement implements IUserManagementRemote {
	@PersistenceContext
	EntityManager Us;

	public Boolean addUser(User u) {

		try {
			Us.persist(u);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public void flush() {
		Us.flush();
	}

	public Boolean update(User u) {

		try {
			Us.merge(u);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Boolean remove(User u) {
		try {
			Us.remove(Us.merge(u));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public User findUserById(int id) {
		User user = null;
		try {
			user = Us.find(User.class, id);

		} catch (Exception e) {

		}
		return user;
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		Query query = Us.createQuery("select u from User u");
		return query.getResultList();
	}

	@Override
	public List<Car> findCarByIdUser(int id) {
		User user = null;
		user = Us.find(User.class, id);
		List<Car> cars = new ArrayList<>();
		Query query = Us.createQuery("select c from car c where c.idUser=:id");
		return query.getResultList();
	}

	@Override
	public Boolean removeUserById(int id) {
		User user=new User();
		try {
			user = Us.find(User.class, id);
			Us.remove(Us.merge(user));
			return true;
		} catch (Exception e) {
			return false;
		}

		
		
	}

}
