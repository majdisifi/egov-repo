package egov.services.interfaces;
import java.util.List;

import javax.ejb.Remote;

import egov.entities.Car;
import egov.entities.User;

@Remote
public interface ICarManagementRemote {
	Boolean addCar(Car c);

	Boolean update(Car c);

	void flush();

	Boolean remove(Car c);

	List<Car> findAll();

	Car findCarByNumIm(int numImmatriculation);

	List<Car> findAllCarByIdUser(User u);

	Boolean removeCarByNum(int numImmatriculation);

	void affecterCarUser(Car c, User u);

}
