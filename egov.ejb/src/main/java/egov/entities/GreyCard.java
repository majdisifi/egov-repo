package egov.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
 @Entity
public class GreyCard implements Serializable{
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private int idGreyCard;
	 private String categorie;
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
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
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
		this.categorie = categorie;
		this.constructor = constructor;
		this.numImmatriculation = numImmatriculation;
	}
	public GreyCard() {
		super();
	}

	 
}
