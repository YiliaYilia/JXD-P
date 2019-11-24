package cn.com.sinosoft.msl.service.shortPolicy;

import java.util.List;
import java.util.Map;

import cn.com.sinosoft.domain.sale.GeApplicantInsured;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.InsurancePolicy;

/**
 * 描述：在线投保流程<br>
 * 作者： 修改日期：
 * 
 */
public interface InsureShortPolicyService {
	
	/**
	 * 判断证件类型
	 * 
	 * @param applicantInsured
	 */
	String convertIdentifytype(GeApplicantInsured applicantInsured);
	/**
	 * 判断性别
	 * 
	 * @param applicantInsured
	 */
	String convertSex(GeApplicantInsured applicantInsured);

	/**
	 * 获取常用投保人列表
	 * 1.根据姓名和手机号查询常用投保人列表
	 * 2.返回是否成功
	 * @param name
	 * @param mobile 
	 * @return 查询是否成功
	 */
	boolean getCommonHolderList(String name, String mobile);
	
	/**
	 * 初始化通信地址省、市下拉列表
	 * 1.根据地区级别，上级地区编码
	 * 2.返回符合条件地区列表
	 * @param codeType
	 * @param seniorCode 
	 * @return 
	 */
	public String initAddressInfo(String codeType, String seniorCode);
	
	/**
	 * 记入常用投保人列表
	 * 1.将用户填写投保信息保存
	 * 2.返回是否成功
	 * @param name
	 * @param mobile 
	 * @return 查询是否成功
	 */
	boolean savePolicyInfo(GePolicy policy);

	/**
	 * 保存订单
	 * 1.创建新的订单对象
	 * 2.设置保单对象
	 * 3.设置投被保人对象: 存入Order表中的gepolicy对象的applicantInsureds中
	 * @param policy
	 * @param applicantInsured
	 * @return
	 */
	GeOrder insureInput(GePolicy policy, GeApplicantInsured applicantInsured);
	
	/**
	 * 确认核保
	 * 1.校验规则, 如下:
	 * 2.设置订单号
	 * 3.设置渠道(登录途径)名称, 渠道编号
	 * 4.调用核保接口
	 * 5.若核保成功, 那么保存投被保人数据
	 * 6.若核保成功, 那么保存保单数据
	 * 7.若核保成功, 那么保存订单数据
	 * 8.返回核保的错误提示信息, 这里底层会向上级抛出BaseException, ResultCode: 2101.
	 * @param orderNo 
	 * @param order
	 * @param channelCode
	 * @param transNo
	 */
	Map insureSubmit(String orderNo, GeOrder order, String channelCode, String transNo);
	
	/**
	 * 承保
	 * 1.校验规则, 如下:
	 * 2.设置订单号
	 * 3.设置渠道(登录途径)名称, 渠道编号
	 * 4.调用核保接口
	 * 5.若核保成功, 那么保存投被保人数据
	 * 6.若核保成功, 那么保存保单数据
	 * 7.若核保成功, 那么保存订单数据
	 * 8.返回核保的错误提示信息, 这里底层会向上级抛出BaseException, ResultCode: 2101.
	 * @param orderNo 
	 * @param channelCode
	 * @param transNo
	 */
	Map insurePromise(GeOrder order, String channelCode, String transNo,InsurancePolicy ip);
	
	InsurancePolicy returnInsurancePolicy(String orderNo, GeOrder order, String channelCode, String transNo);

}
