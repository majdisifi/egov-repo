package egov.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import egov.entities.Company;
import egov.services.interfaces.ICompanyManagementRemote;

@Stateless
public class CompanyManagement implements ICompanyManagementRemote {
	@PersistenceContext
	EntityManager Cm;

	public Boolean addCompany(Company c) {

		try {
			Cm.persist(c);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void flush() {
		Cm.flush();
	}

	public Boolean update(Company c) {

		try {
			Cm.merge(c);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Boolean remove(Company c) {
		try {
			Cm.remove(Cm.merge(c));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Company findCompanyById(int idCompany) {
		Company company = null;
		try {
			company = Cm.find(Company.class, idCompany);

		} catch (Exception e) {

		}
		return company;
	}

	@Override
	public List<Company> findAll() {
		List<Company> companies = new ArrayList<>();
		Query query = Cm.createQuery("select c from Company c");
		return query.getResultList();
	}

	/*
	 * @Override User user=new User(); try { user = Us.find(User.class, id);
	 * Us.remove(Us.merge(user)); return true; } catch (Exception e) { return
	 * false; }
	 */
	@Override
	public Boolean removeCompanyById(int idCompany) {
		Company company = new Company();
		try {
			company = Cm.find(Company.class, idCompany);
			Cm.remove(Cm.merge(company));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Company findcomanyByIdCompany(Integer idCompany) {
		Company found = null;

		String query = "select u from Company u where u.idCompany= :idCompany";

		Query queryU = Cm.createQuery(query).setParameter("idCompany", idCompany);
		try {
			found = new Company();
			found = (Company) queryU.getSingleResult();
		} catch (Exception e) {
		}
		return found;

	}

}
