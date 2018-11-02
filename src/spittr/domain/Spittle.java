package spittr.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Spittle {
	@Id
	private  Long id;
	@Column(name = "message")
	private  String message;
	@Column(name = "spitime")
	private  Date time;
	@Column(name = "latitude")
	private Double latitude;
	@Column(name = "longitude")
	private Double longitude;

	public Spittle(Long id, String message, Date time, Double latitude, Double longtidue) {
		this.id = id;
		this.message = message;
		this.time = time;
		this.latitude = latitude;
		this.longitude = longtidue;
	}

	public Spittle(String message, Date time) {
		this(null, message, time, null, null);
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
