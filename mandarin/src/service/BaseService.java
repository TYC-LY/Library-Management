package service;

import dao.BaseDao;

public class BaseService<TEntity> {
	
	// 未初始化，Spring通过其setter注入
	private BaseDao<TEntity> dao;

	public BaseDao<TEntity> getDao() {
		return dao;
	}

	public void setDao(BaseDao<TEntity> dao) {
		this.dao = dao;
	}
	
}
