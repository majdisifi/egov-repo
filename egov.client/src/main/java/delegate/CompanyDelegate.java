package delegate;

import java.util.List;

import egov.entities.Company;

import locator.ServiceLocator;
import sessionbeans.ICompanyManagementRemote;


public class CompanyDelegate {
	public static ICompanyManagementRemote remote;
	public static final String jndi="/egov.ejb/CompanyManagement!sessionbeans.ICompanyManagementRemote";
	public static ICompanyManagementRemote getProxy(){
		return (ICompanyManagementRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	public static boolean CreateCompany(Company company){
		return getProxy().addCompany(company);
		
	}

	public static boolean doDeleteCompany(Company company){
		return getProxy().remove(company);
		
	}

	public static boolean doUpdateCompany(Company company){
		return getProxy().update(company);
		
	}

	public static Company doFindCompanyById(int idCompany){
		return getProxy().findCompanyById(idCompany);
		
	}

	public static List<Company> doFindAllCompanies(){
		return getProxy().findAll();
		
	}
	public static Boolean removeCompanyByIdCompany(int idCompany){
		return getProxy().removeCompanyById(idCompany);
		
	}
	public static Boolean doRemoveCompany(Company company){
		return getProxy().remove(company);
	}
	
	public static Company doRemovecompany(Integer idCompany)
	{
		return getProxy().findcomanyByIdCompany(idCompany);
}
}