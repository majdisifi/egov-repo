package delegate;

import egov.entities.User;
import locator.ServiceLocator;
import sessionbeans.ICinManagementRemote;
import sessionbeans.IUserManagementRemote;

public class CinDelegate {
	
	public static ICinManagementRemote remote;
	public static String jndi_cin="egov.ejb/CinManagement!sessionbeans.ICinManagementRemote";
	public static ICinManagementRemote getProxy(){
		return   (ICinManagementRemote) ServiceLocator.getInstance().getProxy(jndi_cin);
	}
	
	
	public void createCin(User user){
		
		getProxy().createCin(user);
	}

}
