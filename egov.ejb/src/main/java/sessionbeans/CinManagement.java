package sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import egov.entities.Cin;






@Stateless
public class CinManagement {
	
	@PersistenceContext
	EntityManager em;

	public void addCin(Cin cin) {
		em.persist(cin);

	}
	public Cin findCin(Cin cin) {
		return em.find(Cin.class,cin);

	}

	
	public void flush() {
		em.flush();
	}

	public void update(Cin cin) {
		em.merge(cin);

	}

	public void remove(Cin cin) {

		em.remove(em.merge(cin));

	}


}
