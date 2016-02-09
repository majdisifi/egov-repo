package egov.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Car implements Serializable{
	@Id
	private int numImmatriculation;
	private String color;
	private String type;
	@ManyToOne
	private User user;    
	@OneToOne (mappedBy="car")
	private GreyCard greyCard;
	
	public int getImmatriculation() {
		return numImmatriculation;
	}
	public void setImmatriculation(int numImmatriculation) {
		this.numImmatriculation = numImmatriculation;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
	public int getNumImmatriculation() {
		return numImmatriculation;
	}
	public void setNumImmatriculation(int numImmatriculation) {
		this.numImmatriculation = numImmatriculation;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public GreyCard getGreyCard() {
		return greyCard;
	}
	public void setGreyCard(GreyCard greyCard) {
		this.greyCard = greyCard;
	}
	public Car(int numImmatriculation, String color, String type) {
		super();
		this.numImmatriculation = numImmatriculation;
		this.color = color;
		this.type = type;
	}
	public Car() {
		super();
	}
	
	

}
