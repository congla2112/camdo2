package poly.com.entitis;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "NotificationMessage")
public class NotificationMessage {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	private String sender; // người gửi

	private String receiver; // người nhận

	private Date date; // ngày gửi

	private String content; // nội dung

	private String stutas; // trạng thái

	public NotificationMessage() {
		super();
	
	}

	public NotificationMessage(String id, String sender, String receiver, Date date, String content, String stutas) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.date = date;
		this.content = content;
		this.stutas = stutas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStutas() {
		return stutas;
	}

	public void setStutas(String stutas) {
		this.stutas = stutas;
	}

}
