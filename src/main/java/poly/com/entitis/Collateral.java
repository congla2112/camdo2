package poly.com.entitis;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Collateral")
public class Collateral {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	private String collateralName;

	private String collateralStyle;

	private int status;

	private String note;

	private String image;

	public Collateral() {
		super();
	}

	public Collateral(String id, String collateralName, String collateralStyle, int status, String note, String image) {
		super();
		this.id = id;
		this.collateralName = collateralName;
		this.collateralStyle = collateralStyle;
		this.status = status;
		this.note = note;
		this.image = image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCollateralName() {
		return collateralName;
	}

	public void setCollateralName(String collateralName) {
		this.collateralName = collateralName;
	}

	public String getCollateralStyle() {
		return collateralStyle;
	}

	public void setCollateralStyle(String collateralStyle) {
		this.collateralStyle = collateralStyle;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
