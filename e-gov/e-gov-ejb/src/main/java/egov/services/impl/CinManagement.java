package egov.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import egov.entities.User;
import egov.services.interfaces.ICinManagementRemote;

@Stateless
public class CinManagement implements ICinManagementRemote {

	@PersistenceContext
	EntityManager em;

	public void createCin(User user) {
		em.persist(user);

	}

	public Boolean renewCin(User u) {

		try {
			em.merge(u);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
