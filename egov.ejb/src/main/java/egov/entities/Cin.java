package egov.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class Cin implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cin;
	
	private Date deliveryDate;
	@OneToOne
	private User user;

	public int getCin() {
		return cin;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
