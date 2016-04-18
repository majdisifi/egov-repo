package egov.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Hopital {
 @Id
	private int idh;
	private String name;
	private String adresse;
	
	@OneToMany(mappedBy = "hopital", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Intervention> interventions;

	public List<Intervention> getInterventions() {
		return interventions;
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}

	public Hopital() {
		super();
	}

	public Hopital(int idh, String name, String adresse) {
		super();
		this.idh = idh;
		this.name = name;
		this.adresse = adresse;
	}

	public int getIdh() {
		return idh;
	}

	public void setIdh(int idh) {
		this.idh = idh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	

}
