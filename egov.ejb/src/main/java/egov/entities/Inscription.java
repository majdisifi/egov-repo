package egov.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Inscription {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int numInscrip;
	private Date DateInscrip;
	private String studyEsb;
	private String level;
	private float feesReg;
	
	@ManyToOne
	private User user;

	public int getNumInscrip() {
		return numInscrip;
	}

	public void setNumInscrip(int numInscrip) {
		this.numInscrip = numInscrip;
	}

	public Date getDateInscrip() {
		return DateInscrip;
	}

	public void setDateInscrip(Date dateInscrip) {
		DateInscrip = dateInscrip;
	}

	public String getStudyEsb() {
		return studyEsb;
	}

	public void setStudyEsb(String studyEsb) {
		this.studyEsb = studyEsb;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Inscription() {
		super();
	}

	public Inscription(int numInscrip, Date dateInscrip, String studyEsb, String level, float feesReg, User user) {
		super();
		this.numInscrip = numInscrip;
		DateInscrip = dateInscrip;
		this.studyEsb = studyEsb;
		this.level = level;
		this.feesReg = feesReg;
		this.user = user;
	}

	public float getFeesReg() {
		return feesReg;
	}

	public void setFeesReg(float feesReg) {
		this.feesReg = feesReg;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	} 
	

}
