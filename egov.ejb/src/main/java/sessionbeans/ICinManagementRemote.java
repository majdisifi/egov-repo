package sessionbeans;

import javax.ejb.Remote;

import egov.entities.User;

@Remote
public interface ICinManagementRemote {
	
	public void createCin(User user) ;

	public Boolean renewCin(User u) ;

}
