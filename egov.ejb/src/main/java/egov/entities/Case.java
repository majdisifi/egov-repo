package egov.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Case implements Serializable {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCase;
	private String nameCase;
	private String judgment;
	private Date dateCase;
	@ManyToOne
	private User user2;  

	public int getIdB3() {
		return idCase;
	}

	public void setIdB3(int idCase) {
		this.idCase = idCase;
	}

	public String getNameCase() {
		return nameCase;
	}

	public void setNameCase(String nameCase) {
		this.nameCase = nameCase;
	}

	public String getJudgment() {
		return judgment;
	}

	public void setJudgment(String judgment) {
		this.judgment = judgment;
	}

	public Date getDateCase() {
		return dateCase;
	}

	public void setDateCase(Date dateCase) {
		this.dateCase = dateCase;
	}

	public User getUser() {
		return user2;
	}

	public void setUser(User user2) {
		this.user2	= user2;
	}

	public Case(int idCase, String nameCase, String judgment, Date dateCase, User user2) {
		super();
		this.idCase = idCase;
		this.nameCase = nameCase;
		this.judgment = judgment;
		this.dateCase = dateCase;
		this.user2 = user2;
	}

	public Case() {
		super();
	}

	
}
