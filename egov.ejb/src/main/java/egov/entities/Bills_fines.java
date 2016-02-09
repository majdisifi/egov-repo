package egov.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
  @Entity

public class Bills_fines implements Serializable{
	   @Id
	   private int number;
	   private float ammount;
	  
		@ManyToOne

private User user;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public float getAmmount() {
		return ammount;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setAmmount(float ammount) {
		this.ammount = ammount;
	}

	public Bills_fines(int number, float ammount) {
		super();
		this.number = number;
		this.ammount = ammount;
	
	}
	public Bills_fines() {
		super();
	}
	   

}
