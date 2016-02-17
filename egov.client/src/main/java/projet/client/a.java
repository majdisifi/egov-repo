package projet.client;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import egov.entities.User;

import sessionbeans.IUserManagementRemote;

public class a {

	@Test
	public void Test_u() {
		Context context;

		try {
			context = new InitialContext();

			IUserManagementRemote ge = (IUserManagementRemote) context
					.lookup("egov.ejb/UserManagement!sessionbeans.IUserManagementRemote");

			User user = new User();
			
			user.setLastName("Abdelaziz !");
			user.setJob("Ingenieur ");
		
			ge.addUser(user);

		} catch (NamingException e) {

	
			e.printStackTrace();
		}

	}
}