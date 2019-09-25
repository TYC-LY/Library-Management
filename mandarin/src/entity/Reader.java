package entity;

public class Reader extends BaseEntity {
	
	public Reader() {
		super(0);
	}

	private String username;
	private String email;
	private String password;
	private String repeatpw;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatpw() {
		return repeatpw;
	}

	public void setRepeatpw(String repeatpw) {
		this.repeatpw = repeatpw;
	}
	
}
