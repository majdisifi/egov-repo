package projet.client;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;

import egov.entities.User;

import sessionbeans.IUserManagementRemote;

public class TestUser {
	static IUserManagementRemote remote;

	public static void testAjout(IUserManagementRemote remote) {
		User user = new User();
	 user.setIdUser(5);
		user.setFirstName(" ololilol");
		user.setLastName("Abdelaziz !");
		user.setJob("Ingenieur ");
		if (remote.addUser(user)) {
			System.out.println(" ** Ajout avec succes **");
		} else
			System.out.println("** Erreur d'ajout **");
	}

	public static void testUpdate(IUserManagementRemote remote) {
		User user = remote.findUserById(3);
		user.setFirstName("abir");
		user.setLastName("boughanmi");
		user.setJob("la7ama");
		if (remote.update(user)) {
			System.out.println("modification avec succes");
		} else
			System.out.println("Erreur de modification");
	}

	public static void testDelete(IUserManagementRemote remote) {
		User user = remote.findUserById(1);

		if (remote.remove(user)) {
			System.out.println("Supréssion avec succes");
		} else
			System.out.println("Erreur de Supression");
	}

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			remote = (IUserManagementRemote) context
					.lookup("egov.ejb/UserManagement!sessionbeans.IUserManagementRemote");
		testAjout(remote);
			// testUpdate(remote);
			// testDelete(remote);
		} catch (NamingException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
