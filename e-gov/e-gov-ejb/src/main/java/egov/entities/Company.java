package egov.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCompany;
	private String name;
	private String field;
	private String sector;
	private String adress;

	@OneToMany(mappedBy = "company")
	private List<CompanyOffer> companyOffers;
	@OneToMany(mappedBy = "company")
	private List<Work> work;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int idCompany() {
		return idCompany;
	}

	public void setId(int idCompany) {
		this.idCompany = idCompany;
	}

	public List<Work> getWork() {
		return work;
	}

	public void setWork(List<Work> work) {
		this.work = work;
	}

	public Company(int idCompany, String name, String field, String sector, String adress, List<User> user,
			List<Work> work) {
		super();
		this.idCompany = idCompany;
		this.name = name;
		this.field = field;
		this.sector = sector;
		this.adress = adress;

		this.work = work;
	}

	public Company() {
		super();
	}

}
