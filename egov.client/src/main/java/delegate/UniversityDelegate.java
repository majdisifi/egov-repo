
package delegate;


import java.util.List;

import egov.entities.University;
import locator.ServiceLocator;
import sessionbeans.UniversityManagementRemote;



public class  UniversityDelegate  {
	public static UniversityManagementRemote remote;
	public static final String jndi="/egov.ejb/UniversityManagement!sessionbeans.UniversityManagementRemote";
	public static UniversityManagementRemote getProxy(){
		return (UniversityManagementRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	public static boolean doCreateUniversity(University univ){
		return getProxy().addUniversity(univ);
		
	}

	public static boolean doDeleteUniv(University univ){
		return getProxy().remove(univ);
		
	}

	public static boolean doUpdateUniv(University univ){
		return getProxy().update(univ);
		
	}

	public static University dofindUniversityById(int idUniversity){
		return getProxy().findUniversityById(idUniversity);
		
	}

	public static List<University> doFindAllUniversities(){
		return getProxy().findAll();
		
	}
	public static Boolean removeUniversityById(int id){
		return getProxy().removeUniversityById(id);
		
		
	}
	public static void removeUniversity(University u){
		 getProxy().removeUniversity(u);
	}

}