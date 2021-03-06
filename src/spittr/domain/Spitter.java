package spittr.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.IndexColumn;

@Entity
public class Spitter implements Serializable {
	//using for the serializable for WebService in bytes message
	static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username")
	@NotNull
	@Size(min = 5, max = 16, message = "{username.size}")
	private String username;

	@Column(name = "password")
	@NotNull
	@Size(min = 5, max = 25, message = "{password.size}")
	private String password;

	@Column(name = "firstname")
	@NotNull
	@Size(min = 2, max = 30, message = "{firstName.size}")
	private String firstName;

	@Column(name = "lastname")
	@NotNull
	@Size(min = 2, max = 30, message = "{lastName.size}")
	private String lastName;

	public Spitter() {
	}

	public Spitter(Long id, String username, String password, String firstName, String lastName) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Spitter(String username, String password, String firstName, String lastName) {
		this(null, username, password, firstName, lastName);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	@Override
	public String toString() {
		return "UserName:" + this.username + System.getProperty("line.separator") + "Password:" + this.password
				+ System.getProperty("line.separator") + "FirstName:" + this.firstName
				+ System.getProperty("line.separator") + "LastName:" + this.lastName;
	}

	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "firstName", "lastName", "username", "password", "email");
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "firstName", "lastName", "username", "password", "email");
	}
}
