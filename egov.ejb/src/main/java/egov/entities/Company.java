package egov.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {
	@Id
	private int id;
	private String name;
	private String field;
	private String sector;
	private String adress;
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
	
}
