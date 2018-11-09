package spittr.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Spittle implements Serializable{
	//using for the serializable for WebService in bytes message
	static final long serialVersionUID = 2L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "message")
	private String message;
	@Column(name = "spitime")
	private Date time;
	@Column(name = "latitude")
	private Double latitude;
	@Column(name = "longitude")
	private Double longitude;
	@Column(name = "username")
	private String username;

	public Spittle(Long id, String message, Date time, Double latitude, Double longtidue, String username) {
		this.id = id;
		this.message = message;
		this.time = time;
		this.latitude = latitude;
		this.longitude = longtidue;
		this.username = username;
	}

	public Spittle(String message, Date time) {
		this(null, message, time, null, null, null);
	}

	// constructor for test use , input the id field from 0 to max;
	public Spittle(Long id, String message, Date time) {
		this.id = id;
		this.message = message;
		this.time = time;
	}

	public Spittle() {

	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public Date getTime() {
		return time;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public String getUsername() {
		return username;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "id", "time");
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id", "time");
	}

	@Override
	public String toString() {
		return "Spittle id(" + id + "),createAt:" + time + ", positoin:" + latitude + "," + longitude;
	}

}
