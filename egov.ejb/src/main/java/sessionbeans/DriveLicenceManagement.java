package sessionbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import egov.entities.DriveLicence;



@Stateless
public class DriveLicenceManagement implements IDriveLicenceRemote {
	@PersistenceContext
	EntityManager Us;

	public void addDriveLicence(DriveLicence dl) {
		Us.persist(dl);
	}

	public void flush() {
		Us.flush();
	}

	public void update(DriveLicence dl) {
		Us.merge(dl);

	}

	public void remove(DriveLicence dl) {

		Us.remove(Us.merge(dl));

	}

	@Override
	public DriveLicence findByidDriveLicence(int numDrL) {
		Us.find(DriveLicence.class, numDrL);
		return null;
	}
	
	
	@Override
	public List<DriveLicence> findAll() {
		List<DriveLicence> licences = new ArrayList<>();
		licences= (List<DriveLicence>) Us.createQuery("select dl from DriveLicence dl").getResultList();
		return licences;
	}
	
}
