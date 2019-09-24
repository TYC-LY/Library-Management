package entity;

public class Reader extends BaseEntity{
	private String username;
	private String password;
	private String email;
	private String phonNumber;
	private int borrowBookNumber;
	private boolean fineState;
	
	public Reader() {
		super(0);
		// TODO Auto-generated constructor stub
	}

	public Reader(long id, String username, String password, String email, String phonNumber, int borrowBookNumber,
			boolean fineState) {
		this();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phonNumber = phonNumber;
		this.borrowBookNumber = borrowBookNumber;
		this.fineState = fineState;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonNumber() {
		return phonNumber;
	}

	public void setPhonNumber(String phonNumber) {
		this.phonNumber = phonNumber;
	}

	public int getBorrowBookNumber() {
		return borrowBookNumber;
	}

	public void setBorrowBookNumber(int borrowBookNumber) {
		this.borrowBookNumber = borrowBookNumber;
	}

	public boolean isFineState() {
		return fineState;
	}

	public void setFineState(boolean fineState) {
		this.fineState = fineState;
	}

}
