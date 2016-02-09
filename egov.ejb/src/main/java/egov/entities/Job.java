package egov.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Job implements Serializable{
	@Id
	private int idJob;
	private String name;
	private String field;
	@ManyToOne

	private User user;
	public int getIdJob() {
		return idJob;
	}
	public void setIdJob(int idJob) {
		this.idJob = idJob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

	public Job(int idJob, String name, String field) {
		super();
		this.idJob = idJob;
		this.name = name;
		this.field = field;
	
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Job() {
		super();
	}

    
    

}
