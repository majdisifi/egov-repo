package egov.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Car implements Serializable {
	@Id
	private int numImmatriculation;
	private String color;
	private String type;
	private String category;
	private String constructor;

	@ManyToOne
	private User user;

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

	public Car(int numImmatriculation, String color, String type, String category, String constructor, User user) {
		super();
		this.numImmatriculation = numImmatriculation;
		this.color = color;
		this.type = type;
		this.category = category;
		this.constructor = constructor;
		this.user = user;
	}

	public Car() {
		super();
	}

}
