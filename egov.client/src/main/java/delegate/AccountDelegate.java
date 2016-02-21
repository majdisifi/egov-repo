package delegate;

import java.util.List;

import egov.entities.Account;
import locator.ServiceLocator;
import sessionbeans.IAccountManagementRemote;;

public class AccountDelegate {
	public static IAccountManagementRemote remote;
	public static final String jndi="egov.ejb/AccountManagement!sessionbeans.IAccountManagementRemote";
	public static IAccountManagementRemote getProxy(){
		return (IAccountManagementRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	public static boolean CreateUser(Account account){
		return getProxy().addAccount(account);
		
	}

	public static boolean doDeleteAccount(Account account){
		return getProxy().removeAccount(account);
		
	}

	public static boolean doUpdateUser(Account account){
		return getProxy().updateAccount(account);
		
	}

	public static Account doAccount(int num){
		return getProxy().findAccountByNum(num);
		
	}

	public static List<Account> doFindAccounts(){
		return getProxy().findAll();
		
	}
	
}

