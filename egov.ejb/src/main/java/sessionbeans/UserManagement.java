package sessionbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import egov.entities.User;


@Stateless
public class UserManagement implements IUserManagementRemote {
	@PersistenceContext
	EntityManager Us;

	public void addUser(User u) {
		Us.persist(u);
	}

	public void flush() {
		Us.flush();
	}

	public void update(User u) {
		Us.merge(u);

	}

	public void remove(User u) {

		Us.remove(Us.merge(u));

	}

	@Override
	public User findById(int id) {
		Us.find(User.class, id);
		return null;
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		users = (List<User>) Us.createQuery("select u from User u").getResultList();
		return users;
	}
}
