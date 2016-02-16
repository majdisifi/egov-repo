package egov.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EstablishmentPk implements Serializable{
	private int idUser;
	private int nameUniversity;
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getNameUniversity() {
		return nameUniversity;
	}
	public void setNameUniversity(int nameUniversity) {
		this.nameUniversity = nameUniversity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUser;
		result = prime * result + nameUniversity;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstablishmentPk other = (EstablishmentPk) obj;
		if (idUser != other.idUser)
			return false;
		if (nameUniversity != other.nameUniversity)
			return false;
		return true;
	}
	public EstablishmentPk(int idUser, int nameUniversity) {
		super();
		this.idUser = idUser;
		this.nameUniversity = nameUniversity;
	}
	public EstablishmentPk() {
		super();
	}
	
	

}
