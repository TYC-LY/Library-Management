package service;

import entity.Reader;

public class ReaderServiceImpl extends BaseService<Reader> implements ReaderService {

	@Override
	public Reader verify(String email, String password) {
		Reader reader = this.getDao().getSingle("email", email);
		if (reader == null) {
//			System.out.println("娌℃湁鍙栧嚭鏉ワ紒锛侊紒");
			return null;
		}
// 鍔犲瘑
//		String dealedPassword = Encrypt.encrypt(password + user.getSalt());
		if (reader.getPassword().equals(password)) {
			return reader;
		}
//		System.out.println("瀵嗙爜涓嶅锛侊紒锛�");
		return null;
	}
	
	@Override
	public void register(Reader reader) {
		// TODO Auto-generated method stub
//		reader.setColor("default");
//		reader.setSalt(Encrypt.getSalt());
//		reader.setPassword(Encrypt.encrypt(reader.getPassword()+reader.getSalt()));
//		reader.setPicfilename("default.png");
		this.getDao().save(reader);
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		Reader reader = this.getDao().getSingle("email", email);
		if(reader == null) {
			return true;
		}
		return false;
	}

}
