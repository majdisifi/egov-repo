package egov.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class University {
	@Id
	private String name;
	private String adress;
	private int phone;
	
	@ManyToMany
	private List<User>user ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public University(String name, String adress, int phone) {
		super();
		this.name = name;
		this.adress = adress;
		this.phone = phone;
	}
	public University() {
		super();
	}
	

	

}
