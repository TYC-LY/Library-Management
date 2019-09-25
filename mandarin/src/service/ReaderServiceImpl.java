package service;

import entity.Reader;

public class ReaderServiceImpl extends BaseService<Reader> implements ReaderService {

	@Override
	public Reader verify(String email, String password) {
		Reader reader = this.getDao().getSingle("email", email);
		if (reader == null) {
//			System.out.println("没有取出来！！！");
			return null;
		}
// 加密
//		String dealedPassword = Encrypt.encrypt(password + user.getSalt());
		if (reader.getPassword().equals(password)) {
			return reader;
		}
//		System.out.println("密码不对！！！");
		return null;
	}

}
