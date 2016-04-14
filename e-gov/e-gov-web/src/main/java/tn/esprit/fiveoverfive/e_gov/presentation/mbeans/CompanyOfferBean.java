package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import egov.entities.CompanyOffer;
import egov.services.interfaces.CompanyOfferManagementLocal;

@ManagedBean
@ViewScoped
public class CompanyOfferBean {
	private List<CompanyOffer> companyOffers = new ArrayList<>();
	private CompanyOffer companyOffer = new CompanyOffer();
	private Integer companyId;
	
	@EJB
	private CompanyOfferManagementLocal companyOfferManagementLocal;
	

	public String doCreateCompanyOffer() {
		companyOfferManagementLocal.createCompanyOffer(companyId, companyOffer);
		return "";
	}

	public List<CompanyOffer> getCompanyOffers() {
		companyOffers = companyOfferManagementLocal.findAllCompanyOffers();
		return companyOffers;
	}

	public void setCompanyOffers(List<CompanyOffer> companyOffers) {
		this.companyOffers = companyOffers;
	}

	public CompanyOffer getCompanyOffer() {
		return companyOffer;
	}

	public void setCompanyOffer(CompanyOffer companyOffer) {
		this.companyOffer = companyOffer;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

}
