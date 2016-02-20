package sessionbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import egov.entities.Account;
import egov.entities.Car;

@Stateless
public class AccountManagement implements IAccountManagementRemote{
	@PersistenceContext
	EntityManager em;
	@Override
	public Boolean addAccount(Account a) {
		try {
			em.persist(a);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateAccount(Account a) {
		try {
			em.merge(a);
			return true;
		} catch (Exception e) {
			return false;
		}
	
	}

	@Override
	public void flush() {
		em.flush();
		
	}

	@Override
	public Boolean removeAccount(Account a) {
		try {
			em.remove(a);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Boolean removeCarById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findAll() {
		List<Account>  accounts = new ArrayList<>();
		Query query = em.createQuery("select a from Account a");
		return query.getResultList();
	}
	

	@Override
	public Account findAccountByNum(int num) {
		Account account = null;
		try {
			account = em.find(Account.class,num);

		} catch (Exception e) {

		}
		return account;
	}

	
	

}
