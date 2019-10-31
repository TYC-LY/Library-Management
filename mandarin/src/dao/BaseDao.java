package dao;

import java.util.List;

public interface BaseDao<TEntity> {
	
	TEntity get(long id);
	
	TEntity getSingle(String propertyName, Object propertyValue);
	
	void save(TEntity entity);
	
	void merge(TEntity entity);

	void delete(long id);
	void delete(TEntity entity);
	
	List<TEntity> findAll();
	List<TEntity> findAll(String cond);
	
	List<TEntity> findBy(String propertyName, Object propertyValue);
	List<TEntity> findBy(String propertyName, Object propertyValue,String cond);
	
	List<TEntity> findBySubString(String propertyName, String cond);
	
	
	
	void saveCopy(TEntity entity);
	
	List<TEntity> findByDuration(String propertyName, String startDate, String endDate, String propertyName_1, Object propertyValue, String condition);
}
