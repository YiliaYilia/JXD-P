/**
 * File Name:ECSOperatorAspect.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月27日下午12:34:47
 */
package cn.com.sinosoft.log.aspect;

import java.lang.reflect.Method;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.springsecurity.SpringSecurityUtil;
import cn.com.sinosoft.core.utils.ReflectUtil;
import cn.com.sinosoft.domain.system.GeDailyRecord;
import cn.com.sinosoft.log.service.DailyRecordService;


/**描述：ECS系统操作切面（主要是监控对系统的增删改等操作）<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月27日下午12:34:47 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
@Aspect
@Component
public class ECSOperatorAspect {
	@Autowired
	private DailyRecordService dailyRecordService;
	/**
	 * 方法名称: operator<br>
	 * 描述：定义一个切入点，主要是在那些方法（关注点）中需要添加操作
	 * 作者: honghui
	 * 修改日期：2013年12月27日下午12:39:59
	 */
	@Pointcut(value="execution(@cn.com.sinosoft.core.annotation.ECSOperator * cn.com.sinosoft..*ServiceImpl.save*(..)) || execution(@cn.com.sinosoft.core.annotation.ECSOperator * cn.com.sinosoft..*ServiceImpl.update*(..)) || execution(@cn.com.sinosoft.core.annotation.ECSOperator * cn.com.sinosoft..*ServiceImpl.delete*(..)) || execution(@cn.com.sinosoft.core.annotation.ECSOperator * cn.com.sinosoft..*ServiceImpl.add*(..))")
	public void operator(){};
	
	/**
	 * 方法名称: recordOperator<br>
	 * 描述：环绕通知 在前置通知之后和最终通知执行完毕之后结束
	 * 作者: honghui
	 * 修改日期：2013年12月27日下午1:36:12
	 * @param point
	 */
	@Around(value="operator()")
	public Object recordOperator(ProceedingJoinPoint point){
		Object[] param = point.getArgs(); //方法参数列表
		long begin = 0L; //开始时间
		long end =0L;//结束时间
		//处理结果
		Object result = null;
		try {
			begin = System.currentTimeMillis();
			result = point.proceed(param);
			end = System.currentTimeMillis();
			String operatorName = SpringSecurityUtil.getCurrentUserName();//操作人
			String expend = (end-begin)+""; //一共花费多长时间
			Signature signature = point.getSignature();  //返回当前连接点签名 
			MethodSignature methodSignature = (MethodSignature) signature;  
			Method method = methodSignature.getMethod();  
			ECSOperator operator = (ECSOperator)ReflectUtil.getAnnotation(method, ECSOperator.class);
			GeDailyRecord geDailyRecord = new GeDailyRecord(); //日志
			geDailyRecord.setCreateTime(new Date()); //创建时间
			geDailyRecord.setExpendTime(expend); //执行花费时间
			geDailyRecord.setOperatorName(operatorName); //操作人
			geDailyRecord.setRecordType(""); //操作类型
			geDailyRecord.setDescription(operator.operator());//操作描述
			dailyRecordService.addDailyRecord(geDailyRecord);
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
