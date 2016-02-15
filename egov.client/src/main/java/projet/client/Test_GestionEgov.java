package projet.client;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import egov.entities.User;

import sessionbeans.IUserManagementRemote;

public class Test_GestionEgov {

	@Test
	public void test() {
		Context context;

		try {
			context = new InitialContext();

			IUserManagementRemote ge = (IUserManagementRemote) context
					.lookup("egov.ejb/UserManagement!sessionbeans.IUserManagementRemote");

			User user = new User();
		
			user.setFirstName("Sakly");
			user.setLastName("azziz");
			user.setJob("7a77ay");

			ge.addUser(user);

		} catch (NamingException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void Test_find_query() {
		Context context;

		try {
			context = new InitialContext();
			IUserManagementRemote ge = (IUserManagementRemote) context
					.lookup("egov.ejb/UserManagement!sessionbeans.IUserManagementRemote");

	

				List<User> users = (List<User>) ge.findById(99);
				for (User users1 : users) {

				System.out.println(users1.getFirstName());

			}

		} catch (NamingException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
