/**
 * File Name:GenericHibernateDao.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月16日下午6:19:40
 */
package cn.com.sinosoft.core.hibernate;

import java.io.Serializable;
import java.util.List;

import cn.com.sinosoft.core.utils.ReflectUtil;

/**描述：<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月16日下午6:19:40 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class GenericHibernateDao<T extends Serializable, PK extends Serializable> 
		extends EntityDao implements GenericDao<T, PK> {
	protected Class<T> entityClass;
	
	public GenericHibernateDao(){
	    this.entityClass = ReflectUtil.getSuperClassGenricType(getClass());
	}
	
	public GenericHibernateDao(Class<T> entityClass){
		this.entityClass = entityClass;
	}
	
	/**方法名称：get <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月16日下午6:20:53 
	 * @see cn.com.sinosoft.core.hibernate.GenericDao#get(java.io.Serializable) 
	 * @param paramPK
	 * @return
	 */
	public T get(PK paramPK) {
		return get(entityClass, paramPK);
	}

	/**方法名称：exists <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月16日下午6:20:53 
	 * @see cn.com.sinosoft.core.hibernate.GenericDao#exists(java.io.Serializable) 
	 * @param paramPK
	 * @return
	 */
	public boolean exists(PK paramPK) {
		return exists(entityClass, paramPK);
	}
	
	/**
	 * 方法名称: exists<br>
	 * 描述：根据条件查看数据是否存在
	 * 作者: honghui
	 * 修改日期：2013年12月23日下午7:09:28
	 * @param rule
	 * @return
	 */
	public boolean exists(QueryRule rule){
		List list =this.find(rule);
		if(list.size()>0){
			 return true;
		}
		else{
			return false;
		}
	}
	
	

	/**方法名称：update <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月16日下午6:20:53 
	 * @see cn.com.sinosoft.core.hibernate.GenericDao#update(java.io.Serializable) 
	 * @param paramT
	 */
	public void update(T entity) {
		super.update(entity);
	}

	/**方法名称：deleteByPK <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月16日下午6:20:53 
	 * @see cn.com.sinosoft.core.hibernate.GenericDao#deleteByPK(java.io.Serializable) 
	 * @param paramPK
	 */
	public void deleteByPK(PK paramPK) {
		// TODO Auto-generated method stub
		deleteByPk(entityClass, paramPK);
	}

	/**方法名称：find <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月16日下午6:20:53 
	 * @see cn.com.sinosoft.core.hibernate.GenericDao#find(cn.com.sinosoft.core.hibernate.QueryRule) 
	 * @param queryRule
	 * @return
	 */
	public List<T> find(QueryRule queryRule) {
		return find(entityClass, queryRule);
	}

	/**方法名称：find <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月16日下午6:20:53 
	 * @see cn.com.sinosoft.core.hibernate.GenericDao#find(cn.com.sinosoft.core.hibernate.QueryRule, int, int) 
	 * @param queryRule
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page find(QueryRule queryRule, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return find(entityClass, queryRule, pageNo, pageSize);
	}

	/**方法名称：findUnique <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月16日下午6:20:53 
	 * @see cn.com.sinosoft.core.hibernate.GenericDao#findUnique(java.lang.String, java.lang.Object) 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public T findUnique(String propertyName, Object value) {
		return findUnique(entityClass, propertyName, value);
	}

	/**方法名称：findUnique <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月16日下午6:20:53 
	 * @see cn.com.sinosoft.core.hibernate.GenericDao#findUnique(cn.com.sinosoft.core.hibernate.QueryRule) 
	 * @param queryRule
	 * @return
	 */
	public T findUnique(QueryRule queryRule) {
		List<T> res = this.find(queryRule);
		if(res != null && res.size() >1){
			throw new IllegalStateException("查询出"+res.size()+"条数据，不合法");
		}
		else if(res != null && res.size()==1){
			return res.get(0);
		}
		else{
			return null;
		}
		
	}

	/**方法名称：mergeComplexObjectToTargetFromSource <br>
	 * 描述： <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月16日下午6:20:53 
	 * @see cn.com.sinosoft.core.hibernate.GenericDao#mergeComplexObjectToTargetFromSource(java.lang.Object, java.lang.Object, boolean) 
	 * @param paramObject1
	 * @param paramObject2
	 * @param paramBoolean
	 */
	public void mergeComplexObjectToTargetFromSource(Object paramObject1,
			Object paramObject2, boolean paramBoolean) {
		// TODO Auto-generated method stub
		
	}

	 public void merge(Object entity)
	  {
	    super.getHibernateTemplate().merge(entity);
	  }

	 
}
