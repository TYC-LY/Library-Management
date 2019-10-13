package dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class BaseDaoImpl<TEntity> implements BaseDao<TEntity>{
	private SessionFactory sf; // �漰��hibernate��ʹ��
	private Class<TEntity> entityClass; // ���ڻ�ȡʵ���Ӧ�ı�����SQL�������Ҫ������
	
	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}
	
	protected Session getSession() {
		return sf.openSession();
	}
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		// ����ʵ��ʹ�õ��ඨ���Ӧ������
		Class<?> c = this.getClass();
		Type t = c.getGenericSuperclass();
		if(t instanceof ParameterizedType) {
			Type[] types = ((ParameterizedType)t).getActualTypeArguments();
			entityClass = (Class<TEntity>)types[0];
		}
	}
	
	@Override
	public void save(TEntity entity) {
		Session session = this.getSession();
		// ��ʼһ�����ݿ�����
		session.beginTransaction();
		session.saveOrUpdate(entity);
		// �ύ����
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public void saveCopy(TEntity entity) {
		Session session = this.getSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
	}
	
	public void merge(TEntity entity) {
		Session session = this.getSession();
		// ��ʼһ�����ݿ�����
		session.beginTransaction();
		session.merge(entity);
		// �ύ����
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public void delete(TEntity entity) {
		Session session = this.getSession();
		// ��ʼһ�����ݿ�����
		session.beginTransaction();
		session.delete(entity);
		// �ύ����
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public void delete(long id) {
		TEntity entity = get(id);
		delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TEntity> findAll(String condition) {
		if(condition != null) {
			condition = "order by " + condition;
		}
		else {
			condition = "";
		}
		// �����ݿ��е����ݽ���������ѯ
		List<TEntity> entities = this.getSession().createQuery("from " + entityClass.getSimpleName() + condition).list();
		return entities;
	}
	
	@Override
	public List<TEntity> findAll() {
		// ���������findAll(String condition)���򻯴���
		return this.findAll(null);
	}
	
	public List<TEntity> findBy(String propertyName, Object propertyValue, String condition) {
		if(condition != null) {
			condition = "order by " + condition;
		}
		else {
			condition = "";
		}
		String queryString = "from " + entityClass.getSimpleName() + " e ";
		// ��̫���"=:propertyValue"��д��
		queryString += "where e." + propertyName + "=:propertyValue" + condition;
		Query query = this.getSession().createQuery(queryString);
		List<TEntity> entities = query.setParameter("propertyValue", propertyValue).list();
		return entities;
	}
	
	@Override
	public List<TEntity> findBy(String propertyName, Object propertyValue) {
		// ���÷���findBy(propertyName,propertyValue,condition);
		return findBy(propertyName, propertyValue, null);
	}
	
	public List<TEntity> findBySubString(String propertyName, String condition) {
		String queryString = "from " + entityClass.getSimpleName() + " e ";
		queryString += "where e." +propertyName + " like '%" + condition + "%";
		List<TEntity> entities = this.getSession().createQuery(queryString).list();
		return entities;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public TEntity get(long id) {
		Session session = this.getSession();
		session.beginTransaction();
		TEntity entity = (TEntity)session.get(entityClass, id);
		session.getTransaction().commit();
		session.close();
		return entity;
	}
	
	@Override
	public TEntity getSingle(String propertyName, Object propertyValue) {
		// ���÷���findBy(propertyName,propertyValue);
		List<TEntity> entities = findBy(propertyName, propertyValue);
		if(entities != null && entities.size() > 0) {
			return entities.get(0);
		}
		return null;
	}
}
