package sessionbeans;

import java.util.List;

import javax.ejb.Remote;

import egov.entities.User;

@Remote
public interface IUserManagementRemote {

	void addUser(User u);

	User findById(int id);

	void update(User u);

	void flush();

	void remove(User u);

	List<User> findAll();

	List<User> findById1(int id);

}
