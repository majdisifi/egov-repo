package utility;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import egov.entities.University;
import egov.services.interfaces.UniversityManagementLocal;

/**
 * Session Bean implementation class Util
 */
@Singleton
@LocalBean
@Startup
public class Util {

	@EJB
	private UniversityManagementLocal universityManagementLocal;

	/**
	 * Default constructor.
	 */
	public Util() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initDB() {
		University university = new University("ESPRIT", "GHAZELA", 123456);
		University university2 = new University("TIME", "TUNIS", 1234789);

		universityManagementLocal.addUniversity(university);
		universityManagementLocal.addUniversity(university2);

	}

}
