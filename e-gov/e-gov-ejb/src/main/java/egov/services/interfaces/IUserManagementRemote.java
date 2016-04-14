package egov.services.interfaces;
import java.util.List;

import javax.ejb.Remote;

import egov.entities.Car;
import egov.entities.Kase;
import egov.entities.User;

@Remote
public interface IUserManagementRemote {

Boolean addUser(User u);
Boolean update(User u);
void flush();
Boolean remove(User u);
Boolean removeUserById(int id);
List<User> findAll();
User findUserById(int id);

User authentificate(String login,String pwd);


List<Car> findCarByIdUser(int id);
String findpwd(String email);
List<Kase> CaseByUser(User m);

}
