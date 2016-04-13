package egov.services.interfaces;
import java.util.List;

import javax.ejb.Remote;

import egov.entities.Company;

@Remote
public interface ICompanyManagementRemote {

	
Boolean addCompany(Company c);

	

	Boolean update(Company c);

	void flush();

	Boolean remove(Company c);
	Boolean removeCompanyById(int idCompany );

	List<Company> findAll();
	Company findCompanyById(int id);
    Company findcomanyByIdCompany(Integer idCompany ); 
}
