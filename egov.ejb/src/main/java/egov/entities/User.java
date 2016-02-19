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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int idUser;
	private String firstName;
	private String lastName;
	private Date BirthDate;
	private String job;
	private Date deathDate;
	private Blob photo;
	private Blob fingerPrint;
	private String birthPlace;
	private String login;
	private String email;
	private String password;
	private String status;
	@ManyToOne
	private User mere;
	@ManyToOne
	private User pere;
	
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
	@OneToMany(mappedBy = "user")
	private List<Kase> kase;


	public List<Kase> getKase() {
		return kase;
	}
	public void setKase(List<Kase> kase) {
		this.kase = kase;
	}
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
	
	
	public User getMere() {
		return mere;
	}
	public void setMere(User mere) {
		this.mere = mere;
	}
	public User getPere() {
		return pere;
	}
	public void setPere(User pere) {
		this.pere = pere;
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
	
	
	
	public User(String firstName, String lastName, Date birthDate, String job, Date deathDate, Blob photo,
			Blob fingerPrint, String birthPlace, String login, String email, String password, String status,
			List<Establishment> establishment, List<Work> work, List<Account> accounts, List<Car> cars,
			List<Bills_fines> bills, List<Kase> kase) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		BirthDate = birthDate;
		this.job = job;
		this.deathDate = deathDate;
		this.photo = photo;
		this.fingerPrint = fingerPrint;
		this.birthPlace = birthPlace;
		this.login = login;
		this.email = email;
		this.password = password;
		this.status = status;
		this.establishment = establishment;
		this.work = work;
		this.accounts = accounts;
		this.cars = cars;
		this.bills = bills;
		this.kase = kase;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User() {
		super();
	}

	
	

}
