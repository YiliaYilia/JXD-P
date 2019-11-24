package cn.com.sinosoft.web.action;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.common.service.axis.AccountVO;
import cn.com.sinosoft.common.service.axis.SwitchAccountVO;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.user.GE_ACCOUNT_MAP;
import cn.com.sinosoft.ess.product.common.Data;
import cn.com.sinosoft.web.domain.IIMSSession;
import cn.com.sinosoft.web.service.facade.GE_ACCOUNT_MAPService;
import cn.com.sinosoft.web.service.facade.InvestmentAccountService;
import cn.com.sinosoft.web.service.facade.InvestmentSwitchPolicyService;
import cn.com.sinosoft.web.service.impl.WeiXinServiceImpl;



public class InvestmentSwitchPolicyAction extends Struts2Action {
	private final static Logger logger = LoggerFactory.getLogger(InvestmentSwitchPolicyAction.class);
	
	private static Properties pro = new Properties();
	static{
		try {
			pro.load(new InputStreamReader(InvestmentSwitchPolicyAction.class.getResourceAsStream("/config/login.properties"), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Autowired
	InvestmentSwitchPolicyService investmentSwitchPolicyService;
	@Autowired
	InvestmentAccountService investmentAccountService;
	@Autowired
	GE_ACCOUNT_MAPService ge_ACCOUNT_MAPService;
	
	/**
	 * 跳转至投连险用户登陆页面
	 * @return
	 */
	@Action(value="toCoustomerLoginPage")
	public String toCoustomerLoginPage(){
		HttpServletRequest request = super.getHttpServletRequest();
		String policyNum = request.getParameter("policyNum")==null?"":request.getParameter("policyNum");
		String coustomerid = request.getParameter("coustomerid")==null?"":request.getParameter("coustomerid");
		String productCode = request.getParameter("productCode")==null?"":request.getParameter("productCode");
		//新加的字段 用于取得投资账户信息
		String investment = request.getParameter("investment")==null?"":request.getParameter("investment");
		String productName = "";
		try {
			productName = request.getParameter("productName")==null?"":new String(request.getParameter("productName").getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		this.setRequestAttribute("policyNum", policyNum);
		this.setRequestAttribute("coustomerid", coustomerid);
		this.setRequestAttribute("productCode", productCode);
		this.setRequestAttribute("productName", productName);
		this.setRequestAttribute("investment", investment);
		return "../page/coustomerLogin";
	}
	/**
	 * 用户登陆验证
	 */
	@Action(value="coustomerLogin")
	public void coustomerLogin(){
		String content = "";
		String flag = "";
		String resultsjon = "";
		HttpServletRequest request = super.getHttpServletRequest();
		String coustomerid = request.getParameter("coustomerid")==null?"":request.getParameter("coustomerid");
		String passWord = request.getParameter("passWord")==null?"":request.getParameter("passWord");
		IIMSSession iIMSSession = new IIMSSession();
		flag = iIMSSession.login(coustomerid,passWord);//登录
		if(flag.equals("0")){
			String sessionId = iIMSSession.getSessionId();
			request.getSession().setAttribute("sessionId", sessionId);//将sessionId放至session域中
		}else{
			content = pro.getProperty(flag) != null?pro.getProperty(flag):pro.getProperty("other");
		}
		resultsjon = "{\"flag\":\""+flag+"\",\"content\":\""+content+"\"}";
		super.renderJson(resultsjon);
	}
	
	
	
	//显示投资账户资产转移列表
	@Action(value="getinvestmentAccount")
	public String getinvestmentAccount(){
		HttpServletRequest request = super.getHttpServletRequest();
		String productCode = request.getParameter("productCode")==null?"":request.getParameter("productCode");//产品代码
		String policyNum = request.getParameter("policyNum")==null?"":request.getParameter("policyNum");//保单号
		String productName = request.getParameter("productName")==null?"":request.getParameter("productName");//险种名称
		String sessionId = (String) request.getSession().getAttribute("sessionId");
		String investment = request.getParameter("investment")==null?"":request.getParameter("investment");
		//返回账户信息
		HashMap[] list = getPolicyInvestment(investment);
		//从官网接口返回的账户列表，此接口需sessionId和保单号
		AccountVO[] accountVOs = investmentSwitchPolicyService.getProductInvestmentAccount(productCode,sessionId);
		//对比账户列表并更新
		investmentAccountService.mergeAccount(accountVOs);
		this.setRequestAttribute("accountVOs",accountVOs);
		this.setRequestAttribute("productCode",productCode);
		this.setRequestAttribute("policyNum",policyNum);
		this.setRequestAttribute("productName",productName);
		this.setRequestAttribute("sessionId",sessionId);
		this.setRequestAttribute("investments", list);
		return "../page/assets";
	}
	
	/**
	 * 获取账户信息
	 * @param investment
	 * @return
	 */
	public HashMap[] getPolicyInvestment(String investment){
		HashMap[] list = new HashMap[0];
		HashMap tempMap = null;
		if(investment.length()>0){
			investment = investment.endsWith(",")?investment.substring(0, investment.length()-1):investment;
			BigDecimal value  = new BigDecimal(0);
			BigDecimal totalValue  = new BigDecimal(0);
			String[] total = investment.split(",");
			list = new HashMap[total.length];
			for(int i = 0;i<total.length;i++){
				String unit = total[i];
				if(Data.hasValue(unit)){
					tempMap = new HashMap();
					String[] row = unit.split("&");				
					for(String one:row){
						if(Data.hasValue(one)){
							String[] prama = one.split("=");
							if(prama.length ==2){
								tempMap.put(prama[0], prama[1]);
							}
						}
					}
					value =  new BigDecimal((String)tempMap.get("price")).multiply(new BigDecimal((String)tempMap.get("units")));
					totalValue = totalValue.add(value);
					tempMap.put("value", value.setScale(2,BigDecimal.ROUND_HALF_UP).toString());//价格
					list[i] = tempMap;
				}
			}
			BigDecimal rate = new BigDecimal(0);
			for(int i = 0;i<list.length;i++){
				list[i].put("totalValue", totalValue.setScale(2,BigDecimal.ROUND_HALF_UP).toString());
				rate = new BigDecimal((String)list[i].get("value"));
				rate = rate.divide(totalValue.intValue()>1?totalValue:new BigDecimal(1),BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
				list[i].put("rate", totalValue.intValue()>1?rate.setScale(2,BigDecimal.ROUND_HALF_UP).toString()+"%":"-");
			}
		}
		return list;
	}
	
	
	
	/**
	 * 资产转移方法
	 */
	@Action(value="changeinvestmentAccount")
	public void changeinvestmentAccount(){
		String OpenID = (String) this.getHttpServletRequest().getSession().getAttribute("OpenID");//从seesion中获取openId
		String resultStr = "无法进行资产转移！";
		String resultsjon = "{\"Contenct\":\"无法进行资产转移！\"}";
		HttpServletRequest request = super.getHttpServletRequest();
		//String productCode = request.getParameter("productCode")==null?"":request.getParameter("productCode");//产品代码
		String policyNum = request.getParameter("policyNum")==null?"":request.getParameter("policyNum");//保单号
		String productName = "";
		try {
			productName = request.getParameter("productName")==null?"":new String(request.getParameter("productName").getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String sessionId = request.getParameter("sessionId")==null?"":request.getParameter("sessionId");//从账户查询传过来的尚未过期的sessionId
		String keylist = request.getParameter("keylist")==null?"":request.getParameter("keylist");
		String[] keys = keylist.split("&");
		if(keys.length>0){
			HashMap hm = new HashMap();
			for(String key:keys){
				hm.put(key, (request.getParameter(key)==null||request.getParameter(key)=="")?"0":request.getParameter(key));
			}
			SwitchAccountVO[] SAVO = new SwitchAccountVO[hm.size()];
			for(int i=0;i<hm.size();i++){
				//根据账户id与资产转移代码的映射关系进行转换
				GE_ACCOUNT_MAP ge_account_map = ge_ACCOUNT_MAPService.getOne("account_id", keys[i]);
				String code = ge_account_map.getAccount_code();
				SAVO[i] = new SwitchAccountVO(code,hm.get(keys[i]).toString());
//				SAVO[i].setIvmtAcctID(keys[i]);
//				SAVO[i].setSwitchRatio(hm.get(keys[i]).toString());
			}
			//调取官网接口并将变更记录入库，此接口许保单号 账户号和转移比例及sessionid
			resultStr = investmentSwitchPolicyService.saveSwitchPolicy(policyNum, SAVO,productName,sessionId);//
			if(investmentSwitchPolicyService.getStatuscode()==1){
				resultsjon = "{\"Contenct\":\"转移申请已提交\"}";
				WeiXinServiceImpl weixin = new WeiXinServiceImpl();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
				String date = df.format(new Date());
				weixin.pushServiceMessage(OpenID, "您好！您的保单"+policyNum+"投资账户资产转移已于"+date+"申请成功");//发送客服消息
			}else{
				resultsjon = "{\"Contenct\":\""+resultStr+"\"}";
				logger.info("PolicyNum:"+policyNum+"转移申请提交失败:"+resultStr);
			}
		}
		super.renderJson(resultsjon);
	}
}
