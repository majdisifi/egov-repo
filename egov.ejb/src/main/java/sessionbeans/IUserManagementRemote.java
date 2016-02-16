package sessionbeans;

import java.util.List;

import javax.ejb.Remote;

import egov.entities.User;

@Remote
public interface IUserManagementRemote {

	Boolean addUser(User u);

	

	Boolean update(User u);

	void flush();

	Boolean remove(User u);

	List<User> findAll();
	User findUserById(int id);

}
