package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {

	// 未初始化，Spring通过其工厂方法注入
	private static SessionFactory sf = null;

	@SuppressWarnings("deprecation")
	public static SessionFactory getSessionFactory() {

		if (sf == null) {
			try {
				Configuration cfg = new Configuration();
				sf = cfg.configure().buildSessionFactory();
			} catch (Throwable ex) {
				System.err.println("Initialize Session Factory Failed:" + ex);
				throw new ExceptionInInitializerError(ex);
			}
		}
		return sf;
	}

}
