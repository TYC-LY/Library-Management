package dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class BaseDaoImpl<TEntity> implements BaseDao<TEntity> {

	// 未初始化，将被Spring调用setSessionFactory注入
	private SessionFactory sf;
	// 在构造函数中初始化
	private Class<TEntity> entityClass;

	// 注入SessionFactory
	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}

	// 通过SessionFactory获取Session
	protected Session getSession() {
		return sf.openSession();
	}

	// 构造函数
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Class<?> c = this.getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] types = ((ParameterizedType) t).getActualTypeArguments();
			entityClass = (Class<TEntity>) types[0];
		}
	}

	// get entity by id
	@SuppressWarnings("unchecked")
	@Override
	public TEntity get(long id) {
		Session session = this.getSession();
		session.beginTransaction();
		TEntity entity = (TEntity) session.get(entityClass, id);
		session.getTransaction().commit();
		session.close();
		return entity;
	}

	// get single entity by 字段名和值
	@Override
	public TEntity getSingle(String propertyName, Object propertyValue) {
		// findBy返回的是List，即使只有一个entity
		List<TEntity> entities = findBy(propertyName, propertyValue);
		if (entities != null && entities.size() > 0) {
			// 取出唯一一个entity
			return entities.get(0);
		}
		return null;
	}

	// 新建数据
	@Override
	public void save(TEntity entity) {
		Session session = this.getSession();
		session.beginTransaction();
		session.saveOrUpdate(entity);
		session.getTransaction().commit();
		session.close();
	}

	// 更新数据
	public void merge(TEntity entity) {
		Session session = this.getSession();
		session.beginTransaction();
		session.merge(entity);
		session.getTransaction().commit();
		session.close();
	}

	// 删除数据 by 实体
	@Override
	public void delete(TEntity entity) {
		Session session = this.getSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}

	// 删除数据 by id
	@Override
	public void delete(long id) {
		TEntity entity = get(id);
		// 同样需要用实体删除数据
		delete(entity);
	}
	
	// 返回表中默认排序的所有entities
	@Override
	public List<TEntity> findAll() {
		return this.findAll(null);
	}
	
	// 返回表中通过cond规定好顺序的所有entities
	@SuppressWarnings("unchecked")
	@Override
	public List<TEntity> findAll(String cond) {
		if (cond != null) {
			cond = " order by " + cond;
		} else {
			cond = "";
		}
		List<TEntity> entities = this.getSession().createQuery("from " + entityClass.getSimpleName() + cond).list();
		return entities;
	}

	// 返回表中默认排序的特定entities
	@Override
	public List<TEntity> findBy(String propertyName, Object propertyValue) {
		return findBy(propertyName, propertyValue, null);
	}
	
	// 返回表中通过cond排规定好序的特定entities
	@SuppressWarnings("unchecked")
	public List<TEntity> findBy(String propertyName, Object propertyValue, String cond) {
		if (cond != null) {
			cond = " order by " + cond;
		} else {
			cond = "";
		}
		String queryString = "from " + entityClass.getSimpleName() + " e ";
		queryString += "where e." + propertyName + "=:propertyValue" + cond;
		Query query = this.getSession().createQuery(queryString);
		List<TEntity> entities = query.setParameter("propertyValue", propertyValue).list();
		return entities;
	}

	// 用cond匹配字段
	@SuppressWarnings("unchecked")
	public List<TEntity> findBySubString(String propertyName, String cond) {
		String queryString = "from " + entityClass.getSimpleName() + " e ";
		queryString += "where e." + propertyName + " like '%" + cond + "%'";
		List<TEntity> entities = this.getSession().createQuery(queryString).list();
		return entities;
	}

}
