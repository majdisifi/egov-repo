package egov.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EstablishmentPk implements Serializable{
	private int idUser;
	private int idUniversity;
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdUniversity() {
		return idUniversity;
	}
	public void setNameUniversity(int idUniversity) {
		this.idUniversity = idUniversity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUser;
		result = prime * result + idUniversity;
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
		if (idUniversity != other.idUniversity)
			return false;
		return true;
	}
	public EstablishmentPk(int idUser, int idUniversity) {
		super();
		this.idUser = idUser;
		this.idUniversity = idUniversity;
	}
	public EstablishmentPk() {
		super();
	}
	
	

}
