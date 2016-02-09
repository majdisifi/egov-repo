package egov.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class User implements Serializable{
@Id
	private int idUser;
	private String firstName;
	private String lastName;
	private Date BirthDate;
	private String job;
	private Date deathDate;
	private Blob photo;
	private Blob fingerPrint;
	@OneToMany (mappedBy="user")
	private List<Account> accounts;
    @OneToMany (mappedBy="user")
	private List<Car> cars;
     @OneToMany(mappedBy="user")
    private List<Job> jobs;
      @OneToMany(mappedBy="user")
    private List<Bills_fines> bills;
     @OneToOne (mappedBy="user")
     private DriveLicence driveLicence;
     @OneToOne (mappedBy="user")
     private B3 b3;
     @OneToOne (mappedBy="user")
     private Cin cin;
     
     
     

	private int idF;

	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public int getIdUser() {
		return idUser;
	}
	
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	public List<Bills_fines> getBills() {
		return bills;
	}
	public void setBills(List<Bills_fines> bills) {
		this.bills = bills;
	}
	public DriveLicence getDriveLicence() {
		return driveLicence;
	}
	public void setDriveLicence(DriveLicence driveLicence) {
		this.driveLicence = driveLicence;
	}
	public B3 getB3() {
		return b3;
	}
	public void setB3(B3 b3) {
		this.b3 = b3;
	}
	public Cin getCin() {
		return cin;
	}
	public void setCin(Cin cin) {
		this.cin = cin;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getDeathDate() {
		return deathDate;
	}
	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	public Blob getFingerPrint() {
		return fingerPrint;
	}
	public void setFingerPrint(Blob fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	public int getIdF() {
		return idF;
	}
	public void setIdF(int idF) {
		this.idF = idF;
	}
	public User(int idUser, String firstName, String lastName, Date birthDate, String job, Date deathDate, Blob photo,
			Blob fingerPrint, int idF) {
		super();
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		BirthDate = birthDate;
		this.job = job;
		this.deathDate = deathDate;
		this.photo = photo;
		this.fingerPrint = fingerPrint;
		this.idF = idF;
	}
	public User() {
		super();
	}
	

}
