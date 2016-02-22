package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import egov.entities.Account;
import egov.entities.Car;
import egov.entities.User;

import sessionbeans.IAccountManagementRemote;
import sessionbeans.ICarManagementRemote;
import sessionbeans.IUserManagementRemote;

public class TestAccount {

	@Test
	public void AddTest() {
		Context context;

		try {
		
			Account account = new Account();
			account.setAmmount(4000);
			
			

			
				context = new InitialContext();

				IAccountManagementRemote ge = (IAccountManagementRemote) context
						.lookup("egov.ejb/AccountManagement!sessionbeans.IAccountManagementRemote");

			
			
			if (ge.addAccount(account)) {
			
				System.out.println("ajout avec succes");
			} else
				System.out.println("Erreur d'ajout");

		} catch (NamingException e) {

	
			e.printStackTrace();
		}}
		
		@Test
		public void deleteAccount() {
			Context context1;

			try {
				context1 = new InitialContext();

				IAccountManagementRemote ge = (IAccountManagementRemote) context1
						.lookup("egov.ejb/AccountManagement!sessionbeans.IAccountManagementRemote");

				Account account  = ge.findAccountByNum(10);
				 ge.removeAccount(account);
					
				
				

			} catch (NamingException e) {

		
				e.printStackTrace();
			}

		}
		
		public void updateAccount() {
			Context context1;

			try {
				context1 = new InitialContext();

				IAccountManagementRemote ge = (IAccountManagementRemote) context1
						.lookup("egov.ejb/AccountManagement!sessionbeans.IAccountManagementRemote");

				Account account  = ge.findAccountByNum(2);
				account.setAmmount(1500);
				
				if (ge.updateAccount(account)) {
					System.out.println("modification avec succes");
				} else
					System.out.println("Erreur de modification");

			} catch (NamingException e) {

		
				e.printStackTrace();
			}

		}
		@Test
		public void TestAccountUser() {
			Context context;
			Context context1;
			try {
				context = new InitialContext();
				context1= new InitialContext();
				IUserManagementRemote gi = (IUserManagementRemote) context
						.lookup("egov.ejb/UserManagement!sessionbeans.IUserManagementRemote");



				IAccountManagementRemote ge = (IAccountManagementRemote) context1
						.lookup("egov.ejb/AccountManagement!sessionbeans.IAccountManagementRemote");

				// employe account , labo user
				Account account = new Account();
				account.setAmmount(1422);
				
				User user = gi.findUserById(9);
				List<Account> ac = new ArrayList<>();
				account.setUser(user);
				ac.add(account);
				user.setAccounts(ac);
				gi.update(user);

			} catch (NamingException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	


