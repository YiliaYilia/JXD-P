/**
 * File Name:GenericDao.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月16日下午6:17:43
 */
package cn.com.sinosoft.core.hibernate;

import java.io.Serializable;
import java.util.List;

/**描述：<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月16日下午6:17:43 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public interface GenericDao<T extends Serializable, PK extends Serializable> {
  public  T get(PK paramPK);

  public  boolean exists(PK paramPK);

  public  void save(Object paramObject);

  public  void update(T paramT);

  public  void deleteByPK(PK paramPK);

  public  void delete(Object paramObject);

  public  List<T> find(QueryRule queryRule);

  public  Page find(QueryRule queryRule, int paramInt1, int paramInt2);

  public  T findUnique(String paramString, Object paramObject);

  public  T findUnique(QueryRule queryRule);

  public  void mergeComplexObjectToTargetFromSource(Object paramObject1, Object paramObject2, boolean paramBoolean);
}
