package poly.com.entitis;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Capital") // nguồn vốn
public class Capital {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@NotBlank
	private String shareholder; // cổ đông

	@NotBlank
	private float stock; // cổ phần

	public Capital() {
		super();
	}

	public Capital(String id, @NotBlank String shareholder, @NotBlank float stock) {
		super();
		this.id = id;
		this.shareholder = shareholder;
		this.stock = stock;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShareholder() {
		return shareholder;
	}

	public void setShareholder(String shareholder) {
		this.shareholder = shareholder;
	}

	public float getStock() {
		return stock;
	}

	public void setStock(float stock) {
		this.stock = stock;
	}

}
