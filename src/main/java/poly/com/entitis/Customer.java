package poly.com.entitis;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@NotBlank
	private String fullname;

	@Temporal(TemporalType.TIMESTAMP)
	private Date birth;

	private int gender;

	@NotBlank
	private String phone;

	@NotBlank
	private String peopleID;// số chứng minh thư nhân dân

	@Temporal(TemporalType.TIMESTAMP)
	private Date issuedDate;// ngày cấp

	@NotBlank
	private String releaseLocation;// nơi phát hành

	@NotBlank
	private String temporaryResidenceAddress;// địa chỉ tạm trú

	@NotBlank
	private String permanentAddress;// địa chỉ thường trú

	@Email(message = "Emasetil should be valid")
	private String email;

	@NotBlank
	private String image;

	@NotBlank
	private String job;

	private String income;// thu nhập

	private String companyName;

	private String Contact;
	
	private String fatherFullName;
	
	private String fatherPhoneNumber;
	
	private String motherFullName;
	
	private String motherPhoneNumber;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String id, @NotBlank String fullname, Date birth, int gender, @NotBlank String phone,
			@NotBlank String peopleID, Date issuedDate, @NotBlank String releaseLocation,
			@NotBlank String temporaryResidenceAddress, @NotBlank String permanentAddress,
			@Email(message = "Emasetil should be valid") String email, @NotBlank String image, @NotBlank String job,
			String income, String companyName, String contact, String fatherFullName, String fatherPhoneNumber,
			String motherFullName, String motherPhoneNumber) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
		this.peopleID = peopleID;
		this.issuedDate = issuedDate;
		this.releaseLocation = releaseLocation;
		this.temporaryResidenceAddress = temporaryResidenceAddress;
		this.permanentAddress = permanentAddress;
		this.email = email;
		this.image = image;
		this.job = job;
		this.income = income;
		this.companyName = companyName;
		Contact = contact;
		this.fatherFullName = fatherFullName;
		this.fatherPhoneNumber = fatherPhoneNumber;
		this.motherFullName = motherFullName;
		this.motherPhoneNumber = motherPhoneNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPeopleID() {
		return peopleID;
	}

	public void setPeopleID(String peopleID) {
		this.peopleID = peopleID;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getReleaseLocation() {
		return releaseLocation;
	}

	public void setReleaseLocation(String releaseLocation) {
		this.releaseLocation = releaseLocation;
	}

	public String getTemporaryResidenceAddress() {
		return temporaryResidenceAddress;
	}

	public void setTemporaryResidenceAddress(String temporaryResidenceAddress) {
		this.temporaryResidenceAddress = temporaryResidenceAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getFatherFullName() {
		return fatherFullName;
	}

	public void setFatherFullName(String fatherFullName) {
		this.fatherFullName = fatherFullName;
	}

	public String getFatherPhoneNumber() {
		return fatherPhoneNumber;
	}

	public void setFatherPhoneNumber(String fatherPhoneNumber) {
		this.fatherPhoneNumber = fatherPhoneNumber;
	}

	public String getMotherFullName() {
		return motherFullName;
	}

	public void setMotherFullName(String motherFullName) {
		this.motherFullName = motherFullName;
	}

	public String getMotherPhoneNumber() {
		return motherPhoneNumber;
	}

	public void setMotherPhoneNumber(String motherPhoneNumber) {
		this.motherPhoneNumber = motherPhoneNumber;
	}

	
	
	

}
