package sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import egov.entities.Cin;





@Stateless
public class CinManagement {
	
	@PersistenceContext
	EntityManager c;

	public void addCin(Cin cin) {
		c.persist(cin);

	}
	public Cin findCin(Cin cin) {
		return c.find(Cin.class,cin);

	}
	
	public void flush() {
		c.flush();
	}

	public void update(Cin cin) {
		c.merge(cin);

	}

	public void remove(Cin cin) {

		c.remove(c.merge(cin));

	}


}
