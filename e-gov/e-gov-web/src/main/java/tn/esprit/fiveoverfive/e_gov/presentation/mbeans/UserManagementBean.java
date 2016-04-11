package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import egov.entities.Account;
import egov.entities.Car;
import egov.entities.User;
import sessionbeans.IUserMangementLocal;

@ManagedBean
@ViewScoped
public class UserManagementBean {
	@EJB
	private IUserMangementLocal iUserMangementLocal;
	
	private List<User> users = new ArrayList<>();
	private User user = new User();
	private User userSelected = new User();
	
	


	

	public User getUser() {
		return user;
	}

	public void setAccount(User user) {
		this.user = user;
	}

	public User getUserSelected() {
		return userSelected;
	}

	public void setUserSelected(User userSelected) {
		this.userSelected = userSelected;
	}

	

	public void setUsers(List<User> users) {
		this.users = users;
	}
	public String doAddUser() {
		iUserMangementLocal.addUser(user);
		return "/pages/userManagement/listUser?faces-redirect=true";
	}
	
	public String doDeleteUser(User userSelected) {
		iUserMangementLocal.remove(userSelected);
		return "/pages/userManagement/listUser?faces-redirect=true";
	}

	public String doUpdateUser() {
		iUserMangementLocal.update(userSelected);
		return "/pages/userManagement/listUser?faces-redirect=true";
	}

	public void doSelectUser(User u) {
		userSelected = u;
	}

	public List<User> getUsers1(){
		users = iUserMangementLocal.findAll();
		return users;
	}

	public void setCars(List<User> users) {
		this.users = users;
	}
	

}
