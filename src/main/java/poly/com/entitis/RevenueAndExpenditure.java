package poly.com.entitis;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "RevenueAndExpenditure") // QUẢN LÝ THU CHI
public class RevenueAndExpenditure {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	private String employee;

	private String customer;

	private Date dayTrading; // Ngày giao dịch

	private float revenue;// thu

	private float expenditure; // chi

	public RevenueAndExpenditure() {
		super();

	}

	public RevenueAndExpenditure(String id, String employee, String customer, Date dayTrading, float revenue,
			float expenditure) {
		super();
		this.id = id;
		this.employee = employee;
		this.customer = customer;
		this.dayTrading = dayTrading;
		this.revenue = revenue;
		this.expenditure = expenditure;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Date getDayTrading() {
		return dayTrading;
	}

	public void setDayTrading(Date dayTrading) {
		this.dayTrading = dayTrading;
	}

	public float getRevenue() {
		return revenue;
	}

	public void setRevenue(float revenue) {
		this.revenue = revenue;
	}

	public float getExpenditure() {
		return expenditure;
	}

	public void setExpenditure(float expenditure) {
		this.expenditure = expenditure;
	}

}
