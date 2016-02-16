package egov.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Claims {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idClaim;
	private String Subject;
	private String Contents;
	private Date deadlineDate;
	@ManyToOne
	private User user; 
	
	public Claims() {
		super();
	}
	public Claims(int idClaim, String subject, String contents, Date deadlineDate) {
		super();
		this.idClaim = idClaim;
		Subject = subject;
		Contents = contents;
		this.deadlineDate = deadlineDate;
	}
	public int getIdClaim() {
		return idClaim;
	}
	public void setIdClaim(int idClaim) {
		this.idClaim = idClaim;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getContents() {
		return Contents;
	}
	public void setContents(String contents) {
		Contents = contents;
	}
	public Date getDeadlineDate() {
		return deadlineDate;
	}
	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}
	

}
