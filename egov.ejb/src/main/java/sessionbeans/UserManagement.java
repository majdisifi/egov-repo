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
	public User authentificate(String login, String pwd) {
		User user= null;
		Query query=Us.createQuery("Select u from User u where u.login=:login and u.pwd=:pwd");
		query.setParameter("login", login).setParameter("pwd", pwd);
		try {
			user=(User) query.getSingleResult();
			
		} catch (Exception e) {
			 user=null;
		}
		return user;
	}

}
