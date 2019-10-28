package dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.oracle.webservices.internal.api.message.PropertySet.Property;

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
	
	/**
	 * find entities within the duration
	 * @param propertyName The default value of it is createDate. Or returnDate
	 * @param startDate The beginning day of the duration
	 * @param endDate The ending day of the duration 
	 * @param propertyName_1 The name of the property, such as payState
	 * @param propertyValue The value of the property
	 * @param condition The standard of the ordered list
	 */
	public List<TEntity> findByDuration(String propertyName, String startDate, String endDate, String propertyName_1, Object propertyValue, String condition)
	{
//		if(condition != null) {
//			condition = " order by " + condition + " DESC";
//		} else {
//			condition = "";
//		}
//		String queryString = "from " + entityClass.getSimpleName() + " e ";
//		queryString += "where e." + propertyName + ">=" + startDate;
//		queryString += " and e." + propertyName + "<=" + endDate + condition;
//		Query query = this.getSession().createQuery(queryString);
//		List<TEntity> entities = query.list();
//		
//		return entities;
		Session session = this.getSession();
		Criteria criteria = session.createCriteria(this.entityClass);
		
		if(condition != null) {
			criteria.addOrder(Order.desc(condition).ignoreCase());
		}
		
		Criterion start = Restrictions.ge(propertyName, Date.valueOf(startDate));
		Criterion end = Restrictions.le(propertyName, Date.valueOf(endDate));
		
		LogicalExpression andExp = Restrictions.and(start, end);
		criteria.add(andExp);
		
		if(propertyName_1 != null) {
			criteria.add(Restrictions.eq(propertyName_1, propertyValue));
		}
		
		List<TEntity> entities = criteria.list();
		
		return entities;
	}
}
