package sessionbeans;

import java.util.List;

import javax.ejb.Remote;

import egov.entities.University;
import egov.entities.User;

@Remote
public interface UniversityManagementRemote {

	

		Boolean addUniversity(University u);
		Boolean update(University u);
		void flush();
		Boolean remove(University u);
	    void removeUniversity(University u);
		List<University> findAll();
		University findUniversityById(int idUniversity);
		Boolean removeUniversityById(int idUniversity);
	
	

}
