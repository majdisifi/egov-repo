package sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;








@Stateless
public class CinManagement {
	
	@PersistenceContext
	EntityManager em;

	
	public void flush() {
		em.flush();
	}


}
