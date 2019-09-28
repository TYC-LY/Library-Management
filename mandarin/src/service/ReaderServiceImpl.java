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
	

}
