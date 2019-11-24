package cn.com.sinosoft.web.service.facade;

import java.util.List;

import cn.com.sinosoft.common.service.axis.ClientBindModel;
import cn.com.sinosoft.domain.sale.GeMobileCustomer;

/**
 * <p>Title: ClientBindService</p>
 * <p>Description:用户绑定</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company:sinosoft</p>
 * @author ZhangTiancong
 * @version 1.0
 */
public interface ClientBindService {
	
	/**
	 * 功能：用户绑定信息查询(长险)
	 * 描述：接口查询用户信息并存库
	 * @param	idType		证件类型
	 * @param	idNo		证件号码
	 * @param	clientName	用户姓名
	 * @param	OpenID		微信ID
	 * @return 	报文实体
	 */
	ClientBindModel clientBindQuery(String idType,String idNo,String clientName,String OpenID);
	
	/**
	 * 功能：用户绑定信息查询(短险)
	 * 描述：接口查询用户信息并存库
	 * @param	idType		证件类型
	 * @param	idNo		证件号码
	 * @param	clientName	用户姓名
	 * @param	OpenID		微信ID
	 * @return 	true-保存成功  false-保存失败
	 */
	boolean ShortClientBind(String idType,String idNo,String clientName,String OpenID);

	/**
	 * 功能：已绑定用户验证
	 * 描述：数据库验证用户是否已绑定当前微信
	 * @param	idType		证件类型
	 * @param	idNo		证件号码
	 * @param	clientName	用户姓名
	 * @param	OpenID		微信ID
	 * @return 用户信息列表
	 */
	List<GeMobileCustomer> checkCustomer(String idType,String idNo,String clientName,String OpenID);
	
	/**
	 * 功能：是否绑定微信查询
	 * 描述：数据库验证当前微信是否绑定过
	 * 作者： ZhangTiancong
	 * @param	OpenID		微信ID
	 * @return 用户信息列表
	 */
	List<GeMobileCustomer> checkOpenID(String OpenID);
	
	 void updateCustomerBymicroid(String email,String address,String postcode,String telphone,String customerid);
	 
	 public GeMobileCustomer getOne(String propertyName, Object value);
	 
	 public boolean checkCustomer(String idType,String idNo,String clientName);
	 
	 /**
	  * 获取手机号
	  * @param idType
	  * @param idNo
	  * @param clientName
	  * @param OpenID
	  * @return
	  */
	 public String findPhone(String idType,String idNo,String clientName,String OpenID);
	 
	 /**
	  * 功能：根据条件查询客户
	  * 描述：
	  * @param	idType		证件类型
	  * @param	idNo		证件号码
	  * @param	clientName	用户姓名
	  * @param	OpenID		微信ID
	  * @return 用户信息列表
	  */
	 public List<GeMobileCustomer> findCustomers(String idType,String idNo,String clientName,String type);
	 
	 /**
	  * 功能：更新客户信息
	  * @param mobileCustomer
	  */
	 public void updateCustomer(GeMobileCustomer mobileCustomer);
}
