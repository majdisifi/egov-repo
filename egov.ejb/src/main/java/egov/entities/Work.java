package egov.entities;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Work implements Serializable {
	@EmbeddedId
	private WorkPk pk;
	private String jobType;
	private Date assignmentDate;
	private String duration;
	@JoinColumn(name="idUser",insertable=false,updatable=false)
	@ManyToOne
	private User user;
	@JoinColumn(name="idCompany",insertable=false,updatable=false)
	@ManyToOne
	private Company company;
	public Work() {
		super();
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public Date getAssignmentDate() {
		return assignmentDate;
	}
	public void setAssignmentDate(Date assignmentDate) {
		this.assignmentDate = assignmentDate;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Work(String jobType, Date assignmentDate, String duration, User user, Company company) {
		super();
		this.jobType = jobType;
		this.assignmentDate = assignmentDate;
		this.duration = duration;
		this.user = user;
		this.company = company;
	}

}
