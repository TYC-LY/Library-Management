package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import entity.Librarian;
import service.LibrarianService;

public class LibrarianAction extends BaseAction<Librarian, LibrarianService> {

	private static final long serialVersionUID = 1L;

	private Librarian tempLibrarian;
	private String tempLibrarianId;
	
	//admin
	private String registerMessage;
	private String delectMessage;
	private String changeMessage;
	private List<Librarian> librariantemp=new ArrayList<Librarian>();

	public String login() throws Exception {
		String username = this.getModel().getUsername();
		String password = this.getModel().getPassword();
		//System.out.println(username + password);
		if (username == null) {
			this.errorMessage = "Please enter your username";
			return INPUT;
		}
		if (password == null) {
			this.errorMessage = "Please enter your password";
			return INPUT;
		}
		Librarian librarian = this.getService().verify(username, password);
		if (librarian != null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("librarian", librarian);
			return SUCCESS;
		}
		this.errorMessage = "Your username or password is wrong";
		return INPUT;
	}

	public static String hasLogin() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Librarian librarian = (Librarian) session.get("librarian");
		if (librarian == null) {
			return INPUT;
		}
		return SUCCESS;
	}

	public String logout() throws Exception {
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}
	

	public String answerSecurityQuestion() throws Exception {
		String username = this.getModel().getUsername();
		String securityAnswer = this.getModel().getSecurityAnswer();
		//System.out.println(username + securityAnswer);
		Librarian librarian = this.getService().verifySecurityQuestion(username, securityAnswer);
		if (librarian != null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("librarian", librarian);
			return SUCCESS;
		}
		this.errorMessage = "Your answer is wrong!";
		return INPUT;
	}
	
	public String changePassword() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
    	tempLibrarian = (Librarian) session.get("librarian");
    	String password = this.getModel().getPassword();
		String repeatpw = this.getModel().getRepeatpw();
		if (password.equals(repeatpw)) {
			tempLibrarian.setPassword(password);
    	this.getService().mergeLibrarian(tempLibrarian);
    	return SUCCESS;
		}
		//System.out.println(password+repeatpw);
		this.errorMessage = "Please keep the same password!";
		return INPUT;
	}

	//admin
	public String checkUsername() throws Exception{
		String username = this.getModel().getUsername();
	
		if (username =="") {
			this.registerMessage="Username can not be blank!";
			this.changeMessage="Username can not be blank!";
			this.delectMessage="Username can not be blank!";
			//System.out.print(delectMessage+"a");
			return INPUT;
		}//判断是否为空
		
		if (username.length()>15) {
			this.registerMessage="Username should be in 15 digits!";
			this.changeMessage="Username should be in 15 digits!";
			this.delectMessage="Username should be in 15 digits!";
			return INPUT;
		}//判断是否超15字
		
		return SUCCESS;
	}
	
	public String register() throws Exception {
		//System.out.print("sss");
		String username = this.getModel().getUsername();
		String password="00010001";
		Librarian librarian = this.getService(). checkUsername(username);
		if (librarian != null) {
			this.registerMessage="Username have been registered!";
    		return INPUT;
		}//判断是否已有相同的用户名
		librarian=this.getModel();
		librarian.setPassword(password);
		librarian.setUsername(username);
		librarian.setSecurityAnswer(this.getModel().getSecurityAnswer());
		this.getService().addLibrarian(librarian);//数据入库！！！！！
		this.registerMessage="Register Success!";
		return SUCCESS;
		}
		
	public String manager() throws Exception{
	    int length=this.getService().count();
	    String[] username=this.getService().getAllUsername(length);
	    List<Librarian> librarian=new ArrayList<Librarian>();
//	    Librarian a=null;
//	    long c=1;
//	    String check="";
//	    int time=0;
//		for(int i=0;i<username.length;i++){
//		    System.out.print(username[i]);
//		    check=username[i];
//		    if(check.equals("0000000000000000")){
//		    a=this.getService().getLibrarianByID(c);}
//		    else{
//		    a=this.getService().getLibrarianByID(c);
//		    if(a!=null){librarian.add(time, a);}
//		    time=time+1;
//		    }
//		    c=c+1;
//		}
//		this.librariantemp=librarian;
	    this.librariantemp=this.getService().getAllUsers();
		return SUCCESS;
	}//得到所有的管理员账号（排除了"0000000000000000"这种标记删除了的）
	
	public String search() throws Exception{
		String username=this.getModel().getUsername();
		if(username.equals("0000000000000000")){}//排除标记为删除的
		else{
		Librarian librarian=this.getService().getLibrarianByUsername(username);
		this.librariantemp.clear();
		if(librarian!=null){
		this.librariantemp.add(0, librarian);}}
		return SUCCESS;
	}//查询特定的管理员账号
	
	public String delectLibrarian() throws Exception{
		String username=this.getModel().getUsername();
		Librarian librarian = this.getService(). checkUsername(username);
		if (librarian == null) {
			this.delectMessage="Username does not exist!";
    		return INPUT;
		}//判断是否存在该用户名		
		this.getService().delectLibrarian(librarian);
		this.delectMessage="Delect Success!";
		return SUCCESS;
	}//删除特定的管理员账号
	
	public String changeLibrarian() throws Exception{
		String username=this.getModel().getUsername();
		long id=this.getModel().getId();
		
		Librarian librarian = this.getService().getLibrarianById(id);
		if (librarian == null) {
			this.changeMessage="No librarian account with this id!";
    		return INPUT;
		}//判断是否已有相同的用户名
//		if(librarian.getUsername().equals("0000000000000000")){
//			this.changeMessage="No librarian account with this id!";
//    		return INPUT;
//		}//判断是否已删除用户名
		
		librarian=this.getService().checkUsername(username);
		if(librarian!=null){
			this.changeMessage="Username have been registered!";
    		return INPUT;
		}//判断该用户名是否已经被占用
		
		this.getService().changeLibrarian(id,username);
		this.changeMessage="Change Success!";
		return SUCCESS;
	}//编辑的管理员账号
	
	public String getTempLibrarianId() {
		return tempLibrarianId;
	}

	public void setTempLibrarianId(String tempLibrarianId) {
		this.tempLibrarianId = tempLibrarianId;
	}

	public Librarian getTempLibrarian() {
		return tempLibrarian;
	}

	public void setTempLibrarian(Librarian tempLibrarian) {
		this.tempLibrarian = tempLibrarian;
	}

	/**
	 * @return the registerMessage
	 */
	public String getRegisterMessage() {
		return registerMessage;
	}

	/**
	 * @param registerMessage the registerMessage to set
	 */
	public void setRegisterMessage(String registerMessage) {
		this.registerMessage = registerMessage;
	}

	/**
	 * @return the delectMessage
	 */
	public String getDelectMessage() {
		return delectMessage;
	}

	/**
	 * @param delectMessage the delectMessage to set
	 */
	public void setDelectMessage(String delectMessage) {
		this.delectMessage = delectMessage;
	}

	/**
	 * @return the changeMessage
	 */
	public String getChangeMessage() {
		return changeMessage;
	}

	/**
	 * @param changeMessage the changeMessage to set
	 */
	public void setChangeMessage(String changeMessage) {
		this.changeMessage = changeMessage;
	}

	/**
	 * @return the librariantemp
	 */
	public List<Librarian> getLibrariantemp() {
		return librariantemp;
	}

	/**
	 * @param librariantemp the librariantemp to set
	 */
	public void setLibrariantemp(List<Librarian> librariantemp) {
		this.librariantemp = librariantemp;
	}
	
}
