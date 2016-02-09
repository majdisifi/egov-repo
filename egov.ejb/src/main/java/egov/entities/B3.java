package egov.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class B3 implements Serializable{
	  @Id
	private int idB3;
	private String Description;
	
	@OneToOne
	 private User user;
	public int getIdB3() {
		return idB3;
	}
	public void setIdB3(int idB3) {
		this.idB3 = idB3;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

	public B3(int idB3, String description) {
		super();
		this.idB3 = idB3;
		Description = description;
		
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public B3() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
