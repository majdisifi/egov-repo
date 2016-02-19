package delegate;


import java.util.List;

import egov.entities.User;
import locator.ServiceLocator;
import sessionbeans.IUserManagementRemote;



public class UserDelegate {
	public static IUserManagementRemote remote;
	public static final String jndi="bebetter-ejb/ManageUser!tn.esprit.bebetter.services.managemenent.user.ManageUserRemote";
	public static IUserManagementRemote getProxy(){
		return (IUserManagementRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	public static boolean CreateUser(User user){
		return getProxy().addUser(user);
		
	}

	public static boolean doDeleteUser(User user){
		return getProxy().remove(user);
		
	}

	public static boolean doUpdateUser(User user){
		return getProxy().update(user);
		
	}

	public static User doFindUserById(int id){
		return getProxy().findUserById(id);
		
	}

	public static List<User> doFindAllUsers(){
		return getProxy().findAll();
		
	}
}