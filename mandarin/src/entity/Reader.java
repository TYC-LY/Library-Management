package entity;

public class Reader extends BaseEntity {
	
	public Reader(long id) {
		super(id);
	}

	private String username;
	private String email;
	private String password;
	private String repaetpw;

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

	public String getRepaetpw() {
		return repaetpw;
	}

	public void setRepaetpw(String repaetpw) {
		this.repaetpw = repaetpw;
	}
	
}
