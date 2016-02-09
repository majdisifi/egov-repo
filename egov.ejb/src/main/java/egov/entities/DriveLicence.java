package egov.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class DriveLicence implements Serializable{
	 @Id
	 private int numDrL;
	 private String categorie;
	 private Date deliveryDate;
	 private Date deadlineDate;
	
	 @OneToOne
	 private User user;
	 @OneToOne
	 private Car car;
	public int getNumDrL() {
		return numDrL;
	}
	public void setNumDrL(int numDrL) {
		this.numDrL = numDrL;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Date getDeadlineDate() {
		return deadlineDate;
	}
	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	public DriveLicence(int numDrL, String categorie, Date deliveryDate, Date deadlineDate) {
		super();
		this.numDrL = numDrL;
		this.categorie = categorie;
		this.deliveryDate = deliveryDate;
		this.deadlineDate = deadlineDate;
	}
	public DriveLicence() {
		super();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	 

}
