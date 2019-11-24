/**
 * File Name:QueryRuleUtils.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月16日下午5:10:08
 */
package cn.com.sinosoft.core.hibernate;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import cn.com.sinosoft.core.utils.StringUtils;

/**描述：对筛选规则进行处理类<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月16日下午5:10:08 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class QueryRuleUtils {
	
	public static void initCriteriaByQueryRule(Criteria criteria , QueryRule queryRule){
		List<Rule> rules = queryRule.getRules();
		for(Rule rule:rules){
			if(QueryRule.RULE_ORDER_ASC.equals(rule.getQueryType())){
				processOrderAsc(criteria, rule);;
			}
			else if(QueryRule.RULE_ORDER_DESC.equals(rule.getQueryType())){
				processOrderDesc(criteria, rule);
			}
			else if(QueryRule.RULE_LIKE.equals(rule.getQueryType())){
				processLike(criteria, rule);
			}
			else if(QueryRule.RULE_IN.equals(rule.getQueryType())){
				processIN(criteria, rule);
			}
			else if(QueryRule.RULE_BETWEEN.equals(rule.getQueryType())){
				processBetween(criteria, rule);
			}
			else if(QueryRule.RULE_EQ.equals(rule.getQueryType())){
				processEqual(criteria, rule);
			}
			else if(QueryRule.RULE_NOT_EQ.equals(rule.getQueryType())){
				processNotEqual(criteria, rule);
			}
			else if(QueryRule.RULE_GT.equals(rule.getQueryType())){
				processGreaterThen(criteria, rule);
			}
			else if(QueryRule.RULE_GE.equals(rule.getQueryType())){
				processGreaterEqual(criteria, rule);
			}
			else if(QueryRule.RULE_LT.equals(rule.getQueryType())){
				processLessThen(criteria, rule);
			}
			else if(QueryRule.RULE_LE.equals(rule.getQueryType())){
				processLessEqual(criteria, rule);
			}
			else if(QueryRule.RULE_SQL.equals(rule.getQueryType())){
				processSQL(criteria, rule);
			}
			else if(QueryRule.RULE_IS_NULL.equals(rule.getQueryType())){
				processIsNull(criteria, rule);
			}
			else if(QueryRule.RULE_IS_NOT_NULL.equals(rule.getQueryType())){
				processIsNotNull(criteria, rule);
			}
			else if(QueryRule.RULE_IS_EMPTY.equals(rule.getQueryType())){
				processIsEmpty(criteria, rule);
			}
			else if(QueryRule.RULE_IS_NOT_EMPTY.equals(rule.getQueryType())){
				processIsNotEmpty(criteria, rule);
			}
			else{
				throw new IllegalArgumentException("类型 " + rule.getQueryType() + "不支持");
			}
			
		}
	}
	
	/**
	 * 方法名称: processLike<br>
	 * 描述：加工like模糊条件
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午5:22:52
	 * @param criteria
	 * @param rule
	 */
	public static void processLike(Criteria criteria,Rule rule){
		if(!ArrayUtils.isEmpty(rule.getValues())){
			Object obj = rule.getValues()[0];
			if(obj != null){
				String value = obj.toString();
				if(!StringUtils.isEmpty(value)){
					value = value.replace("*", "%");
					criteria.add(Restrictions.like(rule.getPropertyName(), value));
				}
			}
		}
	}
	
	/**
	 * 方法名称: processBetween<br>
	 * 描述：加工两者之间条件
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午5:25:56
	 * @param criteria
	 * @param rule
	 */
	public static void processBetween(Criteria criteria,Rule rule){
		if(!ArrayUtils.isEmpty(rule.getValues())){
			criteria.add(Restrictions.between(rule.getPropertyName(), rule.getValues()[0], rule.getValues()[1]));
		}
	}
	
	/**
	 * 方法名称: processEqual<br>
	 * 描述：加工等于条件
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午5:27:40
	 * @param criteria
	 * @param rule
	 */
	public static void processEqual(Criteria criteria,Rule rule) {
	    if (!ArrayUtils.isEmpty(rule.getValues())){
	    	criteria.add(Restrictions.eq(rule.getPropertyName(), rule.getValues()[0]));
	    }
	     
	 }
	
	/**
	 * 方法名称: processNotEqual<br>
	 * 描述：加工不等于条件
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午5:28:34
	 * @param criteria
	 * @param rule
	 */
	public static void processNotEqual(Criteria criteria,Rule rule) {
	    if (!ArrayUtils.isEmpty(rule.getValues())){
	    	criteria.add(Restrictions.ne(rule.getPropertyName(), rule.getValues()[0]));
	    }
	}

	/**
	 * 方法名称: processGreaterThen<br>
	 * 描述：加工大于条件
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午5:29:20
	 * @param criteria
	 * @param rule
	 */
	public static void processGreaterThen(Criteria criteria,Rule rule) {
	    if (!ArrayUtils.isEmpty(rule.getValues())){
	    	criteria.add(Restrictions.gt(rule.getPropertyName(), rule.getValues()[0]));
	    }
	}

	/**
	 * 方法名称: processGreaterEqual<br>
	 * 描述：加工大于等于条件
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午5:32:17
	 * @param criteria
	 * @param rule
	 */
	public static void processGreaterEqual(Criteria criteria,Rule rule) {
	    if (!ArrayUtils.isEmpty(rule.getValues())){
	    	 criteria.add(Restrictions.ge(rule.getPropertyName(), rule.getValues()[0]));
	    }
	}

	/**
	 * 方法名称: processLessThen<br>
	 * 描述：加工小于条件
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午5:32:52
	 * @param criteria
	 * @param rule
	 */
	public static void processLessThen(Criteria criteria,Rule rule) {
	    if (!ArrayUtils.isEmpty(rule.getValues())){
	    	 criteria.add(Restrictions.lt(rule.getPropertyName(), rule.getValues()[0]));
	    }
	}
	
	/**
	 * 方法名称: processLessEqual<br>
	 * 描述：加工小于等于条件
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午5:33:32
	 * @param criteria
	 * @param rule
	 */
	public static void processLessEqual(Criteria criteria,Rule rule) {
	    if (!ArrayUtils.isEmpty(rule.getValues())){
	    	criteria.add(Restrictions.le(rule.getPropertyName(), rule.getValues()[0]));
	    }
	 }
	
	/**
	 * 方法名称: processSQL<br>
	 * 描述：加工hql片段作为条件
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午5:34:56
	 * @param criteria
	 * @param rule
	 */
	public static void processSQL(Criteria criteria,Rule rule) {
	    criteria.add(Restrictions.sqlRestriction(rule.getPropertyName()));
	}

	/**
	 * 方法名称: processIsNull<br>
	 * 描述：加工为NULL条件
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午5:35:45
	 * @param criteria
	 * @param rule
	 */
	public static void processIsNull(Criteria criteria,Rule rule) {
	    criteria.add(Restrictions.isNull(rule.getPropertyName()));
	}
	/**
	 * 方法名称: processIsNotNull<br>
	 * 描述：加工不为NULL条件
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午5:36:29
	 * @param criteria
	 * @param rule
	 */
	public static void processIsNotNull(Criteria criteria,Rule rule) {
	    criteria.add(Restrictions.isNotNull(rule.getPropertyName()));
	}
	
	/**
	 * 方法名称: processIsNotEmpty<br>
	 * 描述：加工不为空条件
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午5:36:47
	 * @param criteria
	 * @param rule
	 */
	public static void processIsNotEmpty(Criteria criteria,Rule rule) {
	    criteria.add(Restrictions.isNotEmpty(rule.getPropertyName()));
	}
	
	/**
	 * 方法名称: processIsEmpty<br>
	 * 描述：加工为空条件
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午5:37:06
	 * @param criteria
	 * @param rule
	 */
	public static void processIsEmpty(Criteria criteria,Rule rule) {
	    criteria.add(Restrictions.isEmpty(rule.getPropertyName()));
	}
	
	
	/**
	 * 方法名称: processOrderAsc<br>
	 * 描述：加工排序条件
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午5:37:06
	 * @param criteria
	 * @param rule
	 */
	public static void processOrderAsc(Criteria criteria,Rule rule) {
	    criteria.addOrder(Order.asc(rule.getPropertyName()));
	}
	
	/**
	 * 方法名称: processOrderAsc<br>
	 * 描述：加工排序条件
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午5:37:06
	 * @param criteria
	 * @param rule
	 */
	public static void processOrderDesc(Criteria criteria,Rule rule) {
	    criteria.addOrder(Order.desc(rule.getPropertyName()));
	}
	
	/**
	 * 方法名称: processIN<br>
	 * 描述：添加IN条件
	 * 作者: honghui
	 * 修改日期：2013年12月16日下午5:37:26
	 * @param criteria
	 * @param rule
	 */
	public static void processIN(Criteria criteria,Rule rule){
	    if (!ArrayUtils.isEmpty(rule.getValues())){
	    	if ((rule.getValues().length == 1) && (rule.getValues()[0] != null) && (rule.getValues()[0] instanceof List)) {
	  	      List list = (List)rule.getValues()[0];
	  	      if ((list != null) && (!(list.isEmpty())))
	  	        criteria.add(Restrictions.in(rule.getPropertyName(), list));
	  	    }
	  	    else {
	  	      criteria.add(Restrictions.in(rule.getPropertyName(), rule.getValues()));
	  	    }
	}

	    
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
