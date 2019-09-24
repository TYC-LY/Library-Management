package entity;

public class Admin extends BaseEntity {
	private String username;
	private String password;
	
	public Admin() {
		super(0);
	}

	public Admin(String username, String password) {
		this();
		this.username = username;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// admin不能更改自己的用户名
	public String getUsername() {
		return username;
	}
	
}
