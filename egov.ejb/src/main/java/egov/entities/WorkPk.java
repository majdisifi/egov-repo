package egov.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class WorkPk implements Serializable{
	
	private int idUser;
	private int idCompany;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCompany;
		result = prime * result + idUser;
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
		WorkPk other = (WorkPk) obj;
		if (idCompany != other.idCompany)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}
	public WorkPk(int idUser, int idCompany) {
		super();
		this.idUser = idUser;
		this.idCompany = idCompany;
	}
	public WorkPk() {
		super();
	}
	

}
