package egov.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
 @Entity
public class GreyCard implements Serializable{
	 @Id
	 private int idGreyCard;
	 private String category;
	 private String constructor;
	 private int numImmatriculation;
	 @OneToOne
	 private Car car;
	public int getIdGreyCard() {
		return idGreyCard;
	}
	public void setIdGreyCard(int idGreyCard) {
		this.idGreyCard = idGreyCard;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getConstructor() {
		return constructor;
	}
	public void setConstructor(String constructor) {
		this.constructor = constructor;
	}
	public int getNumImmatriculation() {
		return numImmatriculation;
	}
	public void setNumImmatriculation(int numImmatriculation) {
		this.numImmatriculation = numImmatriculation;
	}

	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public GreyCard(int idGreyCard, String categorie, String constructor, int numImmatriculation) {
		super();
		this.idGreyCard = idGreyCard;
		this.category = category;
		this.constructor = constructor;
		this.numImmatriculation = numImmatriculation;
	}
	public GreyCard() {
		super();
	}

	 
}
