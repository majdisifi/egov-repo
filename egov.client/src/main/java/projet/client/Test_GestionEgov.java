package projet.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import egov.entities.GreyCard;
import egov.entities.User;
import sessionbeans.IGreyCardManagementRemote;
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
			user.setFirstName("Zribi");
			user.setLastName("Ines");
			user.setJob("ingenieur");
			ge.addUser(user);

			// Date date =new Date(06,02,2015);
			// Date date1 =new Date(01,12,3000);

			// user.setBirthDate(date);

			// user.setDeathDate(date1);
			// user.setPhoto();
			// user.setFingerPrint();

		} catch (NamingException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * @Test public void Test_find_query() { Context context;
	 * 
	 * try { context = new InitialContext(); IUserManagementRemote ge =
	 * (IUserManagementRemote) context
	 * .lookup("egov.ejb/UserManagement!sessionbeans.IUserManagementRemote");
	 * 
	 * 
	 * 
	 * List<User> users = (List<User>) ge.findById(99); for (User users1 :
	 * users) {
	 * 
	 * System.out.println(users1.getFirstName());
	 * 
	 * }
	 * 
	 * } catch (NamingException e) {
	 * 
	 * // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */
	@Test
	public void test1() {
		Context context;

		try {
			context = new InitialContext();

			IGreyCardManagementRemote ge = (IGreyCardManagementRemote) context
					.lookup("egov.ejb/GreyCardManagement!sessionbeans.IGreyCardManagementRemote");

			GreyCard GreyCard = new GreyCard();
			GreyCard.setIdGreyCard(1);
			GreyCard.setCategory("mmm");
			GreyCard.setConstructor("jjjjj");
			GreyCard.setCar(null);
			GreyCard.setNumImmatriculation(5666);
			ge.addGreyCard(GreyCard);

		} catch (NamingException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
