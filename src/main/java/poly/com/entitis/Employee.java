package poly.com.entitis;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;

	@NotBlank
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	private String fullname;

	private int gender;
	@Temporal(TemporalType.TIMESTAMP)
	private Date birth;
	
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

	public Employee() {
		super();

	}

	
	

	public Employee(String id, @NotBlank String username, @NotBlank String password, @NotBlank String fullname,
			int gender, Date birth, @NotBlank String phone, @NotBlank String peopleID, Date issuedDate,
			@NotBlank String releaseLocation, @NotBlank String temporaryResidenceAddress,
			@NotBlank String permanentAddress, @Email(message = "Emasetil should be valid") String email,
			@NotBlank String image) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.gender = gender;
		this.birth = birth;
		this.phone = phone;
		this.peopleID = peopleID;
		this.issuedDate = issuedDate;
		this.releaseLocation = releaseLocation;
		this.temporaryResidenceAddress = temporaryResidenceAddress;
		this.permanentAddress = permanentAddress;
		this.email = email;
		this.image = image;
	}




	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
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

}
