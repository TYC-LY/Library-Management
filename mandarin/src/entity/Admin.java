package entity;

public class Admin extends BaseEntity {
	private String username;
	private String password;
	private int fineValue;
	private int deposit;
	private int returnPeriod;
	private String oripassword;
	
	public Admin() {
		super(0);
	}

	public Admin(long id, String username, String password, int fineValue, int deposit, int returnPeriod,
			String oripassword) {
		super(id);
		this.username = username;
		this.password = password;
		this.fineValue = fineValue;
		this.deposit = deposit;
		this.returnPeriod = returnPeriod;
		this.oripassword = oripassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// admin���ܸ����Լ����û���
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the fineValue
	 */
	public int getFineValue() {
		return fineValue;
	}

	/**
	 * @param fineValue the fineValue to set
	 */
	public void setFineValue(int fineValue) {
		this.fineValue = fineValue;
	}

	/**
	 * @return the deposit
	 */
	public int getDeposit() {
		return deposit;
	}

	/**
	 * @param deposit the deposit to set
	 */
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	/**
	 * @return the returnPeriod
	 */
	public int getReturnPeriod() {
		return returnPeriod;
	}

	/**
	 * @param returnPeriod the returnPeriod to set
	 */
	public void setReturnPeriod(int returnPeriod) {
		this.returnPeriod = returnPeriod;
	}

	/**
	 * @return the oripassword
	 */
	public String getOripassword() {
		return oripassword;
	}

	/**
	 * @param oripassword the oripassword to set
	 */
	public void setOripassword(String oripassword) {
		this.oripassword = oripassword;
	}
	
}
