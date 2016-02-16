package sessionbeans;

import java.util.List;

import javax.ejb.Remote;

import egov.entities.DriveLicence;

@Remote
public interface IDriveLicenceRemote {

	void addDriveLicence(DriveLicence dl );

	DriveLicence findByidDriveLicence(int numDrL);
	
	

	void update(DriveLicence dl);

	void flush();

	void remove(DriveLicence dl);

	List<DriveLicence> findAll();

	

}
