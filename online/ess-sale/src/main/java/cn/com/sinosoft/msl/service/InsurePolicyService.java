package cn.com.sinosoft.msl.service;


import java.util.List;

import java.util.Set;

//import cn.com.sinosoft.domain.msl.remote.MslRegion;
import cn.com.sinosoft.domain.sale.GeApplicantInsured;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;
//import cn.com.sinosoft.domain.system.CustomerBindingIdentity;

/**
 * 描述：在线投保流程<br>
 * 作者：CaryXu <br>
 * 修改日期：2015年4月30日 12:39:41 <br>
 * E-mail: Xukaizhen@sinosoft.com.cn <br>
 */
public interface InsurePolicyService {
	/**
	 * 判断productcode是否合法,
	 * 是PAH,PAT,PAC
	 * 其他或者空的话就返回null
	 * @param productcode
	 * @return
	 */
	boolean validateProductCode(String productcode);
	/**
	 * 通过productcode来查询状态为2(支付成功)的订单集合
	 * 页面用来显示已成交数量
	 * @param productcode
	 * @return
	 */
	List<GeOrder> dealCount(String productcode);
	
	/**
	 * 根据产品代码显示对应的保额
	 * 1.根据产品代码查询对应的保险金额
	 * 2.为inputAmount添加有序的保险金额
	 * 3.返回是否成功
	 * @param productcode
	 * @param inputAmount 
	 * @return 查询是否成功
	 */
	List<String> showPolicyAmount(String productcode, List<String> policyAmountList);
	
	/**
	 * 根据产品代码显示对应的保险期间
	 * 1.根据产品代码查询对应的保险期间
	 * 2.为periodTypeList添加有序的保险期间单位类型
	 * 3.为periodNumberList添加有序的保险期间单位数量
	 * 4.返回是否成功
	 * @param productcode
	 * @param inputPeriodNumber 
	 * @param inputPeriodType 
	 * @return 查询是否成功
	 */
	boolean showPolicyPeriod(String productcode, List<String> periodTypeList, List<String> periodNumberList);
//	
//	/**
//	 * 回显客户信息
//	 * 1.判断cusotemer对象是否存在
//	 * 2.调用查询客户信息接口
//	 * 3.设置applicantInsured对象的手机号码和邮箱地址
//	 * 4.如果cusotemer=null, 返回false
//	 * 5.如果查询客户信息接口失败, 上抛BaseException
//	 * @param cusotemer
//	 * @param applicantInsured
//	 */
//	boolean echoCustomer(CustomerBindingIdentity cusotemer,GeApplicantInsured applicantInsured);

	/**
	 * 保存订单
	 * 1.创建新的订单对象
	 * 2.设置保单对象
	 * 3.设置投被保人对象: 存入Order表中的gepolicy对象的applicantInsureds中
	 * @param policy
	 * @param applicantInsured
	 * @return
	 */
	GeOrder insureInput(GePolicy policy, Set<GeApplicantInsured> applicantInsureds);


	/**
	 * 确认核保
	 * 1.校验规则, 如下:
	 * ResultCode: 2011	姓名字数校验：姓名小于2个字符，提示错误“姓名有误，请核实”；
	 * ResultCode: 2012	被保人年龄过小校验：被保人年龄小于18周岁时，提示错误“被保人年龄小于18周岁”；
	 * ResultCode: 2013	被保人年龄过大校验：被保人年龄大于70周岁时，提示错误“被保人年龄大于70周岁”；
	 * ResultCode: 2014	手机号码位数校验：手机号码应为11位，且必须为13、14、15、17、18开头的数字，若不是，提示错误“请输入正确的手机号码”；
	 * ResultCode: 2015	电子邮件格式校验：电子邮件中应包含＂＠＂字符，否则提示错误“请输入正确的电子邮件地址”；
	 * ResultCode: 2016	身份证件位数校验：身份证不为18位，提示错误“请输入正确的身份证号”；
	 * ResultCode: 2017	保障起始日校验：应大于等于投保日+1，小于等于投保日+180，否则系统提示错误“请输入正确的保障起始日”
	 * 2.设置订单号
	 * 3.设置渠道(登录途径)名称, 渠道编号
	 * 4.设置登录方式
	 * 5.调用核保接口
	 * 6.若核保成功, 那么保存投被保人数据
	 * 7.若核保成功, 那么保存保单数据
	 * 8.若核保成功, 那么保存订单数据
	 * 9.返回核保的错误提示信息, 这里底层会向上级抛出BaseException, ResultCode: 2101.
	 * @param orderNo 
	 * @param order
	 * @param channelCode
	 * @param loginWay  
	 */
	int insureSubmit(String orderNo, GeOrder order, String channelCode, String loginWay); 
//	
//	/**
//	 * 回显录入信息选中的投保地区
//	 * 1.获取投被保人的投保地区Code
//	 * 2.设置MslRegion对象的投保地区Code
//	 * 3.返回这个MslRegion对象
//	 * @param order
//	 * @return 查找provinceList里的MslRegion对象
//	 */
//	MslRegion echoRegion(GeOrder order);
//
//	/**
//	 * 
//	 * @param orderCode
//	 * @return
//	 */
//	boolean insurePolicy(String orderCode);
	
	
	/**
	 * 1.算性别
	 * 2.算生日
	 * 3.将处理设置到Order关联的投被保人属性
	 * @param order
	 * @return
	 */
	boolean birthdayAndGender(GeOrder order);
	
	/**
	 * 初始化保险生效时间
	 * 1.创建系统当前时间, 一般用new java.util.Date()
	 * 2.为保单对象设置当前时间
	 * 3.返回 boolean值: true设置成功
	 * @param policy
	 */
	boolean takeEffectTimeInit(GePolicy policy);
	
}
