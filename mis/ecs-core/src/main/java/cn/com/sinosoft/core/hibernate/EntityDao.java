/**
 * File Name:EntityDao.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月16日下午3:35:58
 */
package cn.com.sinosoft.core.hibernate;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import cn.com.sinosoft.core.exception.PersistenceException;
import cn.com.sinosoft.core.exception.enumerate.ExceptionGrade;

/**描述：<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月16日下午3:35:58 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class EntityDao extends HibernateDaoSupport implements ApplicationContextAware{
	/**sprign 上下文环境*/
	private  ApplicationContext applicationContext;
	
	/**
	 * 方法名称: get<br>
	 * 描述：获取单个实体
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:39:56
	 * @param entityClass 实体类
	 * @param id 组件
	 * @return 返回单个实体
	 */
	public <T> T get(Class<T> entityClass,Serializable id){
		return get(entityClass,id,false);
	}
	
	/**
	 * 方法名称: get<br>
	 * 描述：获取单个实体，是否启动查询缓存
	 * 作者: honghui
	 * 修改日期：2014年1月10日下午12:21:23
	 * @param entityClass
	 * @param id
	 * @param isQueryCache
	 * @return
	 */
	public <T> T get(Class<T> entityClass,Serializable id ,boolean isQueryCache){
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		hibernateTemplate.setCacheQueries(isQueryCache);
		try {
			return getHibernateTemplate().get(entityClass, id);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new PersistenceException(ExceptionGrade.GENERAL,e);
		}
	}
	
	/**
	 * 方法名称: getAll<br>
	 * 描述：查询所有实体
	 * 作者: honghui
	 * 修改日期：2014年1月10日下午12:22:50
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> getAll(Class<T> entityClass){
		return getAll(entityClass,false);
	}
	/**
	 * 方法名称: getAll<br>
	 * 描述：获取所有实体,是否开启查询缓存
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:41:24
	 * @param entityClass 实体类
	 * @param isQueryCache 是否开启查询缓存
	 * @return 返回所有实体
	 */
	public <T> List<T> getAll(Class<T> entityClass,boolean isQueryCache){
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		hibernateTemplate.setCacheQueries(isQueryCache);
		try {
			return hibernateTemplate.loadAll(entityClass);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new PersistenceException(ExceptionGrade.GENERAL,e);
		}
		
	}
	/**
	 * 方法名称: save<br>
	 * 描述：保存单个实体
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:42:38
	 * @param entity 实体对象
	 */
	public void save(Object entity){
		try {
			getHibernateTemplate().saveOrUpdate(entity);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 方法名称: update<br>
	 * 描述：更新单个实体
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午6:30:27
	 * @param entity
	 */
	public void update(Object entity){
		try {
			getHibernateTemplate().update(entity);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new PersistenceException(ExceptionGrade.SEVERITY,e);
		}
		
	}
	/**
	 * 方法名称: saveAll<br>
	 * 描述：保存多个实体
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:44:23
	 * @param entitys 多个实体
	 */
	public void saveAll(List entitys ){
		try {
			getHibernateTemplate().saveOrUpdateAll(entitys);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new PersistenceException(ExceptionGrade.SEVERITY,e);
		}
		
	}
	
	/**
	 * 方法名称: delete<br>
	 * 描述：删除一个实体
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:45:15
	 * @param entity 实体
	 */
	public void delete(Object entity){
		try {
			getHibernateTemplate().delete(entity);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new PersistenceException(ExceptionGrade.SEVERITY,e);
		}
		
	}
	/**
	 * 方法名称: deleteAll<br>
	 * 描述：删除多个实体
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:45:49
	 * @param entitys 多个实体
	 */
	public void deleteAll(List entitys){
		try {
			getHibernateTemplate().deleteAll(entitys);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new PersistenceException(ExceptionGrade.SEVERITY,e);
		}
		
	}
	
	/**
	 * 方法名称: deleteByPk<br>
	 * 描述：按主键删除某个实体
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:48:07
	 * @param entity 实体
	 * @param id 主键
	 */
	public <T> void deleteByPk(Class<T> entity,Serializable id){
		Object obj = get(entity,id);
		if(obj != null){
			delete(obj);
		}
	}

	/**
	 * 方法名称: evict<br>
	 * 描述：把指定的缓存对象进行清除
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:49:54
	 * @param entity
	 */
	public void evict(Object entity){
		try {
			getHibernateTemplate().evict(entity);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new PersistenceException(ExceptionGrade.SEVERITY,e);
		}
		
	}
	
	/**
	 * 方法名称: clear<br>
	 * 描述：把所有的缓存对象删除
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:50:39
	 */
	public void clear(){
		try {
			getHibernateTemplate().clear();
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new PersistenceException(ExceptionGrade.SEVERITY,e);
		}
		
	}
	
	/**
	 * 方法名称: findByHql<br>
	 * 描述：HQL 查询多条记录
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午4:12:01
	 * @param hql hql 语句
	 * @param values 参数值
	 * @return 多个实体
	 */
	public List findByHql(final String hql,final Object[] values){
		//如果hql不是字符串会抛出IllegalArgumentException违法的参数
		Assert.hasText(hql); 
		try {
			List list = getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(hql);
					for(int i=0;i<values.length;i++){
						query.setParameter(i, values[i]);
					}
					return query.list();
				}
			});
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceException(ExceptionGrade.GENERAL,e);
		}
		
		
	}
	
	
	/**
	 * 方法名称: findByHql<br>
	 * 描述：HQL 查询多条记录
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午4:12:01
	 * @param hql hql 语句
	 * @param top 多少条记录
	 * @param values 参数值
	 * @return 多个实体
	 */
	public List findByHql(final String hql,final int top ,final Object[] values){
		//如果hql不是字符串会抛出IllegalArgumentException违法的参数
		Assert.hasText(hql); 
		try {
			List list = getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(hql);
					for(int i=0;i<values.length;i++){
						query.setParameter(i, values[i]);
					}
					query.setFirstResult(0);
					query.setMaxResults(top);
					return query.list();
				}
			});
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceException(ExceptionGrade.GENERAL,e);
		}
		
		
	}
	
	/**
	 * 方法名称: findByHql<br>
	 * 描述：分页查询多条记录
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午5:00:44
	 * @param hql hql 语句
	 * @param pageNo 页号（从1开始）
	 * @param pageSize 页码大小
	 * @param values 参数值
	 * @return page对象
	 */
	public Page findByHql(final String hql,final int pageNo,final int pageSize ,final Object[] values){
		//如果hql不是字符串会抛出IllegalArgumentException违法的参数
		Assert.hasText(hql); 
		try {
			List list = getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(hql);
					for(int i=0;i<values.length;i++){
						query.setParameter(i, values[i]);
					}
					query.setFirstResult((pageNo-1)*pageSize);
					query.setMaxResults(pageNo*pageSize);
					return query.list();
				}
			});
			
			String newHql = "SELECT COUNT(1) "+hql.toUpperCase().substring(hql.toUpperCase().indexOf("FROM"));
			Object total  = getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(
						Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(hql);
					for(int i=0;i<values.length;i++){
						query.setParameter(i, values[i]);
					}
					return query.uniqueResult();
				}
			});
			return new Page(pageSize, pageNo, Integer.parseInt(total.toString()), list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceException(ExceptionGrade.GENERAL,e);
		}
		
		
	}
	
	/**
	 * 方法名称: findUnique<br>
	 * 描述：查询唯一数据
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午6:02:41
	 * @param entityClass
	 * @param propertyName
	 * @param value
	 * @return 单个实体
	 */
	public <T> T findUnique(Class<T> entityClass,String propertyName,Object value){
		try {
			QueryRule queryRule = QueryRule.getInstance();
			queryRule.addEqual(propertyName, value);
			List<T> list = find(entityClass, queryRule);
			if(list.isEmpty()){
				return null;
			}
			if(list.size() ==1){
				return list.get(0);
			}
			else{
				throw new IllegalStateException("查询出"+list.size()+"条数据，不合法");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceException(ExceptionGrade.GENERAL,e);
		}
		
	}
	
	/**
	 * 方法名称: find<br>
	 * 描述：查询
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午6:02:51
	 * @param entityClass
	 * @param queryRule
	 * @return 多条数据
	 */
	public <T> List<T> find(final Class<T> entityClass,final QueryRule queryRule){
		try {
			List<T> list = getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
				public List<T> doInHibernate(Session session) throws HibernateException,
						SQLException {
					Criteria criteria = session.createCriteria(entityClass);
					QueryRuleUtils.initCriteriaByQueryRule(criteria, queryRule);
					List<T> list = criteria.setFirstResult(0).list();
					return list;
				}
			});
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceException(ExceptionGrade.GENERAL,e);
		}
		
	}
	
	/**
	 * 方法名称: exists<br>
	 * 描述：是否存在实体
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午6:05:13
	 * @param entityClass
	 * @param id 主键
	 * @return
	 */
	public <T> boolean exists(Class<T> entityClass,Serializable id){
		try {
			Object entity = getHibernateTemplate().get(entityClass, id);
			return (entity != null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceException(ExceptionGrade.GENERAL,e);
		}
		
	}
	
	/**
	 * 方法名称: find<br>
	 * 描述：分页查询实体条数
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午6:14:58
	 * @param entityClass
	 * @param queryRule
	 * @param pageNo
	 * @param pageSize
	 * @return 分页查询实体条数
	 */
	public <T> Page find(final Class<T> entityClass,final QueryRule queryRule,final int pageNo,final int pageSize){
		try {
			Page page = getHibernateTemplate().execute(new HibernateCallback<Page>() {
				public Page doInHibernate(Session session) throws HibernateException,
						SQLException {
					Criteria criteria = session.createCriteria(entityClass);
					QueryRuleUtils.initCriteriaByQueryRule(criteria, queryRule);
					int total = findTotal(entityClass, session,queryRule);
					criteria.setFirstResult((pageNo-1)*pageSize);
					//criteria.setMaxResults(pageNo*pageSize);
					criteria.setMaxResults(pageSize);
					List list = criteria.list();
					Page page = new Page(pageSize, pageNo, total, list);
					return page;
				}
			});
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceException(ExceptionGrade.GENERAL,e);
		}
		
		
	}
	/**
	 * 方法名称: findTotal<br>
	 * 描述：找总数
	 * 作者: liyang
	 * 修改日期：2013-12-20下午08:52:43
	 * @param <T>
	 * @param entityClass
	 * @param session
	 * @return
	 */
	public <T> int findTotal(Class<T> entityClass,Session session,QueryRule queryRule){
		try {
			Criteria criteria = session.createCriteria(entityClass);
			QueryRuleUtils.initCriteriaByQueryRule(criteria, queryRule);
			return ((Number)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceException(ExceptionGrade.GENERAL,e);
		}
		
	}
	
	 
	/**方法名称：setApplicationContext <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月16日下午3:36:47 
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext) 
	 * @param arg0
	 * @throws BeansException
	 */
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	
}
