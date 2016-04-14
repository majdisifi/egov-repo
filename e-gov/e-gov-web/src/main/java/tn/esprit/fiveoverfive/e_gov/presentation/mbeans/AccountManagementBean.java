package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import egov.entities.Account;
import egov.entities.Car;
import egov.entities.User;
import sessionbeans.IAccountManagementLocal;

@ManagedBean
@ViewScoped
public class AccountManagementBean {
private IAccountManagementLocal iAccountManagementLocal;
private List<Account> accounts = new ArrayList<>();
private Account account = new Account();
private Account accountSelected = new Account();

public IAccountManagementLocal getiAccountManagementLocal() {
	return iAccountManagementLocal;
}
public void setiAccountManagementLocal(IAccountManagementLocal iAccountManagementLocal) {
	this.iAccountManagementLocal = iAccountManagementLocal;
}
public List<Account> getAccounts() {

	accounts = iAccountManagementLocal.findAll();
	return accounts;
}
public void setAccounts(List<Account> accounts) {
	this.accounts = accounts;
}
public Account getAccountSelected() {
	return accountSelected;
}
public void setAccountSelected(Account accountSelected) {
	this.accountSelected = accountSelected;
}
public Account getAccount() {
	return account;
}
public void setAccount(Account account) {
	this.account = account;
}


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

public void doSelectAccount(Account u) {
	accountSelected = u;
}
}
