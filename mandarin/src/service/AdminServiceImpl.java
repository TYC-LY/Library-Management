package service;

import java.util.List;

import entity.Admin;
import entity.Librarian;

public class AdminServiceImpl extends BaseService<Admin> implements AdminService {

	@Override
	public Admin verify(String username, String password) {
		// TODO Auto-generated method stub
				Admin admin = this.getDao().getSingle("username", username);
				if(admin == null) {
					return null;
				}
				if(admin.getPassword().equals(password)){
					return admin;
				}
				return null;
	}

	@Override
	public void register(Librarian librarian) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Librarian getLibrarianById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Librarian> getAllLibrarian() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mergeAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Admin verify(long id, String password ) {
		// TODO Auto-generated method stub
		Admin admin=this.getDao().getSingle("id", id);
		if(admin.getPassword().equals(password)){
			return admin;
		}
		return null;
	}



	@Override
	public void changePassword(String password) {
		long id=1;
		Admin admin=this.getDao().getSingle("id", id);
		admin.setPassword(password);
		this.getDao().save(admin);
	}
	





	/* (non-Javadoc)
	 * @see service.AdminService#ModifyFine(int)
	 */
	@Override
	public void ModifyFine(int fineValue) {
		Admin admin=this.getDao().get(1);
		admin.setFineValue(fineValue);
		this.getDao().save(admin);
		
	}


	@Override
	public int getValue() {
		long id=1;
		Admin admin=this.getDao().getSingle("id", id);
		int value = admin.getFineValue();
		return value;
	}


	/* (non-Javadoc)
	 * @see service.AdminService#ModifyDeposit(int)
	 */
	@Override
	public void ModifyDeposit(int deposit1) {
		Admin admin=this.getDao().get(1);
		admin.setDeposit(deposit1);
		this.getDao().save(admin);
		
	}



	/* (non-Javadoc)
	 * @see service.AdminService#getDeposit()
	 */
	@Override
	public int getDeposit() {
		long id=1;
		Admin admin=this.getDao().getSingle("id", id);
		int deposit = admin.getDeposit();
		return deposit;
	}



	/* (non-Javadoc)
	 * @see service.AdminService#ModifyPeriod(int)
	 */
	@Override
	public void ModifyPeriod(int period) {
		Admin admin=this.getDao().get(1);
		admin.setReturnPeriod(period);
		this.getDao().save(admin);
		
	}



	/* (non-Javadoc)
	 * @see service.AdminService#getReturnPeriod()
	 */
	@Override
	public int getReturnPeriod() {
		long id=1;
		Admin admin=this.getDao().getSingle("id", id);
		int returnPeriod = admin.getReturnPeriod();
		return returnPeriod;
	}

}
