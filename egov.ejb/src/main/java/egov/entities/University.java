package egov.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class University implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUniversity;
	public int getIdUniversity() {
		return idUniversity;
	}
	public void setIdUniversity(int idUniversity) {
		this.idUniversity = idUniversity;
	}
	private String nameUniversity;
	private String adress;
	private int phone;
	
	@OneToMany(mappedBy="university")
	private List<Establishment>establishment ;
	
	public String getNameUniversity() {
		return nameUniversity;
		
	}
	public void setName(String nameUniversity) {
		this.nameUniversity = nameUniversity;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public University(String nameUniversity, String adress, int phone) {
		super();
		this.nameUniversity = nameUniversity;
		this.adress = adress;
		this.phone = phone;
	}
	public University() {
		super();
	}
	public List<Establishment> getEstablishment() {
		return establishment;
	}
	public void setEstablishment(List<Establishment> establishment) {
		this.establishment = establishment;
	}
	public void setNameUniversity(String nameUniversity) {
		this.nameUniversity = nameUniversity;
	}
	

	

}
