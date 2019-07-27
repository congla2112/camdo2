package poly.com.entitis;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Contract") // hợp đồng
public class Contract {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	private String customerName;

	private String CollateralName; // tên tài sản

	private float money;

	private Date loanDay; // ngày vay

	private float interestRate; // lãi suất

	private float monthlyInterest; // lãi hàng tháng

	private String employyeName;

	private String stutas;

	private String message;

	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contract(String id, String customerName, String collateralName, float money, Date loanDay,
			float interestRate, float monthlyInterest, String employyeName, String stutas, String message) {
		super();
		this.id = id;
		this.customerName = customerName;
		CollateralName = collateralName;
		this.money = money;
		this.loanDay = loanDay;
		this.interestRate = interestRate;
		this.monthlyInterest = monthlyInterest;
		this.employyeName = employyeName;
		this.stutas = stutas;
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCollateralName() {
		return CollateralName;
	}

	public void setCollateralName(String collateralName) {
		CollateralName = collateralName;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public Date getLoanDay() {
		return loanDay;
	}

	public void setLoanDay(Date loanDay) {
		this.loanDay = loanDay;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public float getMonthlyInterest() {
		return monthlyInterest;
	}

	public void setMonthlyInterest(float monthlyInterest) {
		this.monthlyInterest = monthlyInterest;
	}

	public String getEmployyeName() {
		return employyeName;
	}

	public void setEmployyeName(String employyeName) {
		this.employyeName = employyeName;
	}

	public String getStutas() {
		return stutas;
	}

	public void setStutas(String stutas) {
		this.stutas = stutas;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
