package action;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import entity.Admin;
import service.AdminService;

public class AdminAction extends BaseAction<Admin, AdminService> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage = "";
	private int value;
	private int depo;
	private int peri;

	/**
	 * @return the finevalue
	 */

	private String user;
	private AdminService adminService;
	
	public String changePassword() throws Exception {
		String password = this.getModel().getPassword();
		String oripassword = this.getModel().getOripassword();
		long id=1;
		System.out.print(oripassword);
		Admin admin = this.getService().verify(id,oripassword);
		if (admin!= null) {
			System.out.print("ok1");
			this.getService().changePassword(password);
			setErrorMessage("No problem!");
		}
		else{setErrorMessage("Original Password is wrong!");}
		return SUCCESS;
	}
	
	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String signin() throws Exception {
		String username = this.getModel().getUsername();
		String password = this.getModel().getPassword();

		if (username == "") {
			System.out.print("aaa");
			this.errorMessage = "Username is required and cannot be empty.";
			return INPUT;
		}

		if (password == "" || password.length() > 10) {
			this.errorMessage = "Password must be within 10 digits, no spaces can appear.";
			return INPUT;
		}

		Admin admin = this.getService().verify(username, password);
		if (admin != null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("Admin", admin);
			this.user = username;
			return SUCCESS;
		}

		this.errorMessage = "Wrong username or password.";
		return INPUT;
	}// 超管登录

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	public static String hasLogin() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Admin admin = (Admin) session.get("admin");
		if (admin == null) {
			return INPUT;
		}
		return SUCCESS;
	}

	public String logout() throws Exception {
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}

	/**
	 * 页面加载时运行action,使标签得到value,deposit,returnPeriod
	 */
	public String onload() {

		int D = this.getDepo();
		depo = D;
		int v = this.getValue();
		value = v;
		int P = this.getPeri();
		peri = P;
		return SUCCESS;
	}

	// 修改FineValue
	public String modifyFine() throws Exception {
		int fineValue = this.getModel().getFineValue();
		this.getService().ModifyFine(fineValue);
		this.value = this.getValue();
		return SUCCESS;
	}

	// 修改deposit的值
	public String modifyDeposit() throws Exception {
		int deposit1 = this.getModel().getDeposit();
		System.out.print(deposit1);
		System.out.print("qwertyuiasdfghjxcvbn");
		this.getService().ModifyDeposit(deposit1);
		this.depo = this.getDepo();
		return SUCCESS;
	}
	
	
	// 修改ReturnPeriod的值
	public String modifyP() throws Exception {
		int i = this.getModel().getFineValue();
		System.out.print(i);
		System.out.print("qwertyuiasdfghjxcvbn");
		this.getService().ModifyPeriod(i);
		this.peri = this.getPeri();
		return SUCCESS;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		int i = this.getService().getValue();
		this.value = i;
		return value;
	}

	/**
	 * @return the depo
	 */
	public int getDepo() {
		int i = this.getService().getDeposit();
		this.depo = i;
		return depo;
	}

	/**
	 * @return the peri
	 */
	public int getPeri() {
		int i = this.getService().getReturnPeriod();
		this.peri = i;
		return peri;
	}


	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @param depo
	 *            the depo to set
	 */
	public void setDepo(int depo) {
		this.depo = depo;
	}

	/**
	 * @param peri
	 *            the peri to set
	 */
	public void setPeri(int peri) {
		this.peri = peri;
	}

}
