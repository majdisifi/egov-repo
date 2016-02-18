package test;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import egov.entities.User;

import sessionbeans.IUserManagementRemote;

public class testUser2 {

	@Test
	public void AddTest() {
		Context context;

		try {
			context = new InitialContext();

			IUserManagementRemote ge = (IUserManagementRemote) context
					.lookup("egov.ejb/UserManagement!sessionbeans.IUserManagementRemote");

			User user = new User();
			user.setFirstName("			ZIZ !");
			user.setLastName("Abdelaziz !");
			user.setJob("Ingenieur ");
			
			
			if (ge.addUser(user)) {
				System.out.println("ajout avec succes");
			} else
				System.out.println("Erreur d'ajout");

		} catch (NamingException e) {

	
			e.printStackTrace();
		}

	}
	
	@Test
	public void updateTest() {
		Context context;

		try {
			context = new InitialContext();

			IUserManagementRemote ge = (IUserManagementRemote) context
					.lookup("egov.ejb/UserManagement!sessionbeans.IUserManagementRemote");

			User user = ge.findUserById(5);
			user.setFirstName("			ZIZ !");
			user.setLastName("Abdelaziz !");
			user.setJob("Ingenieur ");
		
			if (ge.update(user)) {
				System.out.println("modification avec succes");
			} else
				System.out.println("Erreur de modification");

		} catch (NamingException e) {

	
			e.printStackTrace();
		}

	}
	@Test
	public void deleteTest() {
		Context context;

		try {
			context = new InitialContext();

			IUserManagementRemote ge = (IUserManagementRemote) context
					.lookup("egov.ejb/UserManagement!sessionbeans.IUserManagementRemote");

			User user = ge.findUserById(1);
		
			if (ge.remove(user)) {
				System.out.println("Supréssion avec succes");
			} else
				System.out.println("Erreur de Supression");
		
			

		} catch (NamingException e) {

	
			e.printStackTrace();
		}

	}
}