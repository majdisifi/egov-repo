package sessionbeans;

import java.util.List;

import javax.ejb.Remote;

import egov.entities.Account;




@Remote
public interface IAccountManagementRemote {
	Boolean addAccount(Account a);
	Boolean updateAccount(Account a);
	void flush();
	Boolean removeAccount(Account c);
	Boolean removeCarById(int id);
	List<Account> findAll();
	Account findAccountByNum(int num);

}
