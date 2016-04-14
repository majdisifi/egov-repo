package egov.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import egov.entities.CompanyOffer;

@Remote
public interface CompanyOfferManagementRemote {
	List<CompanyOffer> findAllCompanyOffers();

	Boolean createCompanyOffer(Integer companyId, CompanyOffer companyOffer);
}
