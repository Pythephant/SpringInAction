package spittr;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {

	private Long id;

	@NotNull
	@Size(min = 5, max = 16)
	private String username;

	@NotNull
	@Size(min = 5, max = 25)
	private String password;

	@NotNull
	@Size(min=2, max = 30)
	private String firstName;

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

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Spitter(String username, String password, String firstName, String lastName) {
		this(null, username, password, firstName, lastName);
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserName:" + this.username + System.getProperty("line.separator") + "Password:" + this.password
				+ System.getProperty("line.separator") + "FirstName:" + this.firstName
				+ System.getProperty("line.separator") + "LastName:" + this.lastName;
	}
}
