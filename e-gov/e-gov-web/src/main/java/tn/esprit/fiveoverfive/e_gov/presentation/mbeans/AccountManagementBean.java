package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import egov.entities.Account;
import egov.services.interfaces.IAccountManagementLocal;

@ManagedBean
@SessionScoped
public class AccountManagementBean {
	// injection
	@EJB
	private IAccountManagementLocal iAccountManagementLocal;

	private List<Account> accounts = new ArrayList<>();
	private Account accountSelected = new Account();

	private Account account = new Account();

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Account getAccountSelected() {
		return accountSelected;
	}

	public void setAccountSelected(Account accountSelected) {
		this.accountSelected = accountSelected;
	}

	// methodes
	public String doAddAccount() {
		iAccountManagementLocal.addAccount(account);
		return "/pages/accountManagement/listAccounts?faces-redirect=true";
	}

	public String doDeleteAccount(Account accountSelected) {
		iAccountManagementLocal.removeAccount(accountSelected);
		return "/pages/accountManagement/listAccounts?faces-redirect=true";

	}

	public String doUpdateAccount() {
		iAccountManagementLocal.updateAccount(accountSelected);
		return "/pages/accountManagement/listAccounts?faces-redirect=true";
	}

	public void doSelectAccount(Account c) {
		accountSelected = c;
	}

	public List<Account> getAccounts() {
		accounts = iAccountManagementLocal.findAll();
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
