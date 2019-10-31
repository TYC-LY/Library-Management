package entity;

import java.util.Date;

public class Reader extends BaseEntity {
	
	public Reader() {
		super(0);
	}

	private String username;
	private String email;
	private String password;
	private String repeatpw;
	private String phoneNumber;
	private int borrowBookNumber;
	private boolean fineState;
	private Date createDate;
	private boolean checkState;

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isFineState() {
		return fineState;
	}

	public void setFineState(boolean fineState) {
		this.fineState = fineState;
	}

	public int getBorrowBookNumber() {
		return borrowBookNumber;
	}

	public void setBorrowBookNumber(int borrowBookNumber) {
		this.borrowBookNumber = borrowBookNumber;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isCheckState() {
		return checkState;
	}

	public void setCheckState(boolean checkState) {
		this.checkState = checkState;
	}
	
}
