package sessionbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import egov.entities.University;


@Stateless
public class UniversityManagement implements UniversityManagementRemote {
	@PersistenceContext
	EntityManager Us;

	public Boolean addUniversity(University u) {

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

	public Boolean update(University u) {

		try {
			Us.merge(u);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Boolean remove(University u) {
		try {
			Us.remove(Us.merge(u));
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	public void removeUniversity(University u) {
		 Us.remove(Us.merge(u));
		
	}

	@Override
	public University  findUniversityById(int idUniversity) {
		University univ = null;
		try {
			univ = Us.find(University.class, idUniversity);

		} catch (Exception e) {

		}
		return univ;
	}
	

	@Override
	public List<University> findAll() {
		List<University> univs = new ArrayList<>();
		Query query = Us.createQuery("select u from University u");
		return query.getResultList();
	}
	
	@Override
	public Boolean removeUniversityById(int idUniversity) {
		University univ=new University();
		try {
			univ = Us.find(University.class, idUniversity);
			Us.remove(Us.merge(univ));
			return true;
		} catch (Exception e) {
			return false;
		}

		
		
	}

}
