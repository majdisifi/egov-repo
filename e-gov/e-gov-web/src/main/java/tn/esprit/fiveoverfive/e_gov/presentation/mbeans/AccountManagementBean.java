package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import egov.entities.Account;
import sessionbeans.IAccountManagementLocal;

@ManagedBean
@SessionScoped
public class AccountManagementBean {
	// injection
	@EJB
	private IAccountManagementLocal iAccountManagementLocal;

	// models
	private Account account = new Account();

	// methodes
	public String doAddAccount() {
		iAccountManagementLocal.addAccount(account);
		return "";
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
