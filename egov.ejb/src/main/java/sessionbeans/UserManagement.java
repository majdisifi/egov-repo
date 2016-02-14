package sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import egov.entities.User;


@Stateless
public class UserManagement implements IUserManagement {
	@PersistenceContext
	EntityManager Us ;
	
	public void  addEmploye(User u) {
		Us.persist(u);
	}
	
	public User findUserById(int id) {
		return Us.find(User.class,id);

	}
}
