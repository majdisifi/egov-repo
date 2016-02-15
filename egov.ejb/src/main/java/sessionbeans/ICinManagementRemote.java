package sessionbeans;

import javax.ejb.Remote;

import egov.entities.Cin;

@Remote
public interface ICinManagementRemote {
	
	void addCin(Cin cin);
	
	public Cin findCin(Cin cin);
	
	void flush();
	
	void update(Cin cin);
	
	
	void remove(Cin cin);

}
