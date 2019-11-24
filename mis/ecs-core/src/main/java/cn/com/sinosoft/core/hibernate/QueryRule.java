/**
 * File Name:QueryRule.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月16日下午2:42:57
 */
package cn.com.sinosoft.core.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.com.sinosoft.core.utils.StringUtils;

/**描述：查询规则<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月16日下午2:42:57 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public final class QueryRule implements Serializable{
	private static final long serialVersionUID = 1L;
	/**查询条件-排序（升序）*/
	protected static String RULE_ORDER_ASC="order_asc";
	/**查询条件-排序（降序）*/
	protected static String RULE_ORDER_DESC="order_desc";
	/**查询条件-Like模糊查询*/
	protected static String RULE_LIKE = "like";
	/**查询条件-In查询*/
	protected static String RULE_IN = "in";
	/**查询条件-两者之间*/
	protected static String RULE_BETWEEN = "between";
	/**查询条件-等于*/
	protected static String RULE_EQ = "eq";
	/**查询条件-不等于*/
	protected static String RULE_NOT_EQ = "not_eq";
	/**查询条件-大于*/
	protected static String RULE_GT = "gt";
	/**查询条件-大于等于*/
	protected static String RULE_GE = "ge";
	/**查询条件-小于*/
	protected static String RULE_LT = "lt";
	/**查询条件-小于等于*/
	protected static String RULE_LE = "le";
	/**查询条件-sql语句（只能作为条件）*/
	protected static String RULE_SQL = "sql";
	/**查询条件-为NULL*/
	protected static String RULE_IS_NULL = "is_null";
	/**查询条件-不为NULL*/
	protected static String RULE_IS_NOT_NULL = "is_not_null";
	/**查询条件-为空*/
	protected static String RULE_IS_EMPTY = "is_empty";
	/**查询条件-不为空*/
	protected static String RULE_IS_NOT_EMPTY = "is_not_empty";
	
	/**查询规则（条件）集合*/
	private List<Rule> ruleList = new ArrayList<Rule>();
	/***
	 * 防止实例化
	 */
	private QueryRule(){}

	

	public static QueryRule getInstance(){
	    return new QueryRule();
	}
	
	/**
	 * 方法名称: addAscOrder<br>
	 * 描述：添加排序条件-升序
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:02:04
	 * @param propertyName 属性名
	 */
	public void addAscOrder(String propertyName){
		this.ruleList.add(new Rule(RULE_ORDER_ASC, propertyName));
	}
	
	/**
	 * 方法名称: addDescOrder<br>
	 * 描述：添加排序条件-降序
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:02:46
	 * @param propertyName 属性名
	 */
	public void addDescOrder(String propertyName){
		this.ruleList.add(new Rule(RULE_ORDER_DESC, propertyName));
	}
	
	/**
	 * 方法名称: addIsNull<br>
	 * 描述：添加筛选条件-为NULL
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:03:33
	 * @param propertyName 属性名
	 */
	public void addIsNull(String propertyName){
		this.ruleList.add(new Rule(RULE_IS_NULL, propertyName));
	}
	
	/**
	 * 方法名称: addIsNotNull<br>
	 * 描述:添加筛选条件-不为NULL
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:04:20
	 * @param propertyName 属性名
	 */
	public void addIsNotNull(String propertyName){
		this.ruleList.add(new Rule(RULE_IS_NOT_NULL, propertyName));
	}
	
	/**
	 * 方法名称: addIsEmpty<br>
	 * 描述：添加筛选条件-为空
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:05:19
	 * @param propertyName 属性名
	 */
	public void addIsEmpty(String propertyName){
		this.ruleList.add(new Rule(RULE_IS_EMPTY, propertyName));
	}
	
	/**
	 * 方法名称: addIsNotEmpty<br>
	 * 描述：添加筛选条件-不为空
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:06:14
	 * @param propertyName 属性名
	 */
	public void addIsNotEmpty(String propertyName){
		this.ruleList.add(new Rule(RULE_IS_NOT_EMPTY, propertyName));
	}
	
	/**
	 * 方法名称: addLike<br>
	 * 描述：添加筛选条件-模糊查询
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:11:40
	 * @param propertyName 属性名
	 * @param value 参数值
	 */
	public void addLike(String propertyName, Object value){
		if(value != null && !StringUtils.isEmpty(value.toString())){
			this.ruleList.add(new Rule(RULE_LIKE, propertyName, new Object[] {value}));
		}
	}

	/**
	 * 方法名称: addEqual<br>
	 * 描述：添加筛选条件-等于
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:13:00
	 * @param propertyName 属性名
	 * @param value 参数值
	 */
	public void addEqual(String propertyName, Object value){
		if(value != null && !StringUtils.isEmpty(value.toString())){
			this.ruleList.add(new Rule(RULE_EQ, propertyName, new Object[] { value }));
		}
	}

	/**
	 * 方法名称: addBetween<br>
	 * 描述：添加筛选条件-两者之间
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:16:41
	 * @param propertyName 属性名
	 * @param values 参数值（至少两个）
	 */
	public void addBetween(String propertyName, Object[] values){
		if(values != null && values.length >=2){
			if(!StringUtils.isEmpty(values[0].toString()) && !StringUtils.isEmpty(values[1].toString())){
				 this.ruleList.add(new Rule(RULE_BETWEEN, propertyName, values));
			}
		}
	}

	/**
	 * 方法名称: addIn<br>
	 * 描述：添加筛选条件-IN
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:18:43
	 * @param propertyName 属性名
	 * @param values 参数值
	 */
	public void addIn(String propertyName, List<Object> values){
		if(values != null && !values.isEmpty()){
			this.ruleList.add(new Rule(RULE_IN, propertyName, values.toArray()));
		}
	}
	
	/**
	 * 方法名称: addIn<br>
	 * 描述：添加筛选条件-IN
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:20:38
	 * @param propertyName 属性名
	 * @param values 参数值
	 */
	public void addIn(String propertyName, Object[] values){
		if(values != null && values.length >=1){
			this.ruleList.add(new Rule(RULE_IN, propertyName, values));
		}
	}

	/**
	 * 方法名称: addNotEqual<br>
	 * 描述：添加筛选条件-不等于
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:22:04
	 * @param propertyName 属性名
	 * @param value 参数值
	 */
	public void addNotEqual(String propertyName, Object value){
		if(value != null && !StringUtils.isEmpty(value.toString())){
			this.ruleList.add(new Rule(RULE_NOT_EQ, propertyName, new Object[] { value }));
		}
	}
	
	/**
	 * 方法名称: addGreaterThan<br>
	 * 描述：添加筛选条件-大于
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:23:11
	 * @param propertyName 属性名
	 * @param value 参数值
	 */
	public void addGreaterThan(String propertyName, Object value){
		if(value != null && !StringUtils.isEmpty(value.toString())){
			this.ruleList.add(new Rule(RULE_GT, propertyName, new Object[] { value }));
		}
	}
	
	/**
	 * 方法名称: addGreaterEqual<br>
	 * 描述：添加筛选条件-大于等于
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:24:26
	 * @param propertyName 属性名
	 * @param value 参数值
	 */
	public void addGreaterEqual(String propertyName, Object value){
		if(value != null && !StringUtils.isEmpty(value.toString())){
			this.ruleList.add(new Rule(RULE_GE, propertyName, new Object[] { value }));
		}
	}
	/**
	 * 方法名称: addLessThan<br>
	 * 描述：添加筛选条件-小于
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:25:32
	 * @param propertyName 属性名
	 * @param value 参数值
	 */
	public void addLessThan(String propertyName, Object value){
		if(value != null && !StringUtils.isEmpty(value.toString())){
			this.ruleList.add(new Rule(RULE_LT, propertyName, new Object[] { value }));
		}
	}
	
	/**
	 * 方法名称: addLessEqual<br>
	 * 描述：添加筛选条件-小于等于
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:26:10
	 * @param propertyName 属性名
	 * @param value 参数值
	 */
	public void addLessEqual(String propertyName, Object value){
		if(value != null && !StringUtils.isEmpty(value.toString())){
			this.ruleList.add(new Rule(RULE_LE, propertyName, new Object[] { value }));
		}
	}
	
	/**
	 * 方法名称: addSql<br>
	 * 描述：添加sql查询
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午3:26:56
	 * @param sql 语句
	 */
	public void addSql(String sql){
		this.ruleList.add(new Rule(RULE_SQL, sql));
	}

	public List<Rule> getRules(){
		return this.ruleList;
	}

}
