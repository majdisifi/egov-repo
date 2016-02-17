package egov.entities;

import java.io.Serializable;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity

public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUser;
	private String firstName;
	private String lastName;
	private Date BirthDate;
	private String job;
	private Date deathDate;
	private Blob photo;
	private Blob fingerPrint;
	@OneToMany(mappedBy = "user1")
	private List<Establishment> establishment;
	@OneToMany(mappedBy = "user")
	private List<Work> work;
	@OneToMany(mappedBy = "user")
	private List<Account> accounts;
	
	@OneToMany(mappedBy = "user")
	private List<Car> cars;
	@OneToMany(mappedBy = "user")
	private List<Bills_fines> bills;
	@OneToMany(mappedBy ="user2")
	private List<Case> case2;

	public int getIdUser() {
		return idUser;
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
	public List<Establishment> getEstablishment() {
		return establishment;
	}
	public void setEstablishment(List<Establishment> establishment) {
		this.establishment = establishment;
	}
	public List<Work> getWork() {
		return work;
	}
	public void setWork(List<Work> work) {
		this.work = work;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	public List<Bills_fines> getBills() {
		return bills;
	}
	public void setBills(List<Bills_fines> bills) {
		this.bills = bills;
	}
	public List<Case> getCase() {
		return case2;
	}
	public void setCase(List<Case> case2) {
		this.case2 = case2;
	}
	public User(String firstName, String lastName, Date birthDate, String job, Date deathDate, Blob photo,
			Blob fingerPrint, List<Establishment> establishment, List<Work> work, List<Account> accounts,
			List<Car> cars, List<Bills_fines> bills, List<Case> case2) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		BirthDate = birthDate;
		this.job = job;
		this.deathDate = deathDate;
		this.photo = photo;
		this.fingerPrint = fingerPrint;
		this.establishment = establishment;
		this.work = work;
		this.accounts = accounts;
		this.cars = cars;
		this.bills = bills;
		this.case2 = case2;
	}
	public User() {
		super();
	}
	
	

}
