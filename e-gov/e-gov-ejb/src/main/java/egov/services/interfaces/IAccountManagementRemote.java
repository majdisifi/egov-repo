package egov.services.interfaces;
import java.util.List;

import javax.ejb.Remote;

import egov.entities.Account;




@Remote
public interface IAccountManagementRemote {
	Boolean addAccount(Account a);
	Boolean updateAccount(Account a);
	void flush();
	Boolean removeAccount(Account c);
	
	List<Account> findAll();

	Account findAccountByNum(int num);
	Boolean SendMoney(int num1 , int num2 , float ammount);

}
