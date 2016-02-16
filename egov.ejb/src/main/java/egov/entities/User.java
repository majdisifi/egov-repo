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

public class User implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUser;
	private String firstName;
	private String lastName;
	private Date BirthDate;
	private String job;
	private Date deathDate;
	private Blob photo;
	private Blob fingerPrint;
	
	@OneToMany(mappedBy="user1")
	private List<Establishment>establishment ;
	
	@OneToMany(mappedBy="user")
	private List<Work>work ;
	
	
	
	@OneToMany (mappedBy="user")
	private List<Account> accounts;
    @OneToMany (mappedBy="user")
	private List<Car> cars;
   
      @OneToMany(mappedBy="user")
    private List<Bills_fines> bills;
     
    
     @OneToMany (mappedBy="user")
    
     private List<Case> case1;
     

     
     

 
     
    
     
     

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

	public List<Bills_fines> getBills() {
		return bills;
	}
	public void setBills(List<Bills_fines> bills) {
		this.bills = bills;
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
	public User( String firstName, String lastName, Date birthDate, String job, Date deathDate, Blob photo,
			Blob fingerPrint, int idF) {
		super();
		
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
	public List<Work> getWork() {
		return work;
	}
	public void setWork(List<Work> work) {
		this.work = work;
	}

	public List<Case> getCase1() {
		return case1;
	}
	public void setCase1(List<Case> case1) {
		this.case1 = case1;
	}
	public User(int idUser, String firstName, String lastName, Date birthDate, String job, Date deathDate, Blob photo,
			Blob fingerPrint, List<Work> work, List<Company> company, List<Account> accounts, List<Car> cars,
			List<Bills_fines> bills, List<Case> case1, int idF) {
		super();
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		BirthDate = birthDate;
		this.job = job;
		this.deathDate = deathDate;
		this.photo = photo;
		this.fingerPrint = fingerPrint;
		this.work = work;
		this.accounts = accounts;
		this.cars = cars;
		this.bills = bills;
		this.case1 = case1;
		this.idF = idF;
	}
	

}
