package cn.com.sinosoft.web.action;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.core.utils.NumberUtil;
import cn.com.sinosoft.domain.sale.GeKTinsurancecashvalue;
import cn.com.sinosoft.domain.sale.GeKTpremiumrate;
import cn.com.sinosoft.domain.sale.GeRXinsurancecashvalue;
import cn.com.sinosoft.web.domain.Token;
import cn.com.sinosoft.web.entity.WeiXinUserEntity;
import cn.com.sinosoft.web.msl.BaseAction;
import cn.com.sinosoft.web.service.facade.GeKTinsurancecashvaluefindService;
import cn.com.sinosoft.web.service.facade.GeKTpremiumratefindService;
import cn.com.sinosoft.web.service.impl.WeiXinServiceImpl;
@ParentPackage(value = "ECS-STRUTS")
public class KTCalculatorAction extends BaseAction{
	private final static Logger logger = LoggerFactory.getLogger(KTCalculatorAction.class);
	@Autowired
	private GeKTpremiumratefindService geKtpremiumratefindService;
	@Autowired
	private GeKTinsurancecashvaluefindService geKtinsurancecashvaluefindService;
	private String result;
	DecimalFormat    df   = new DecimalFormat("#0.000");   
	/**
	 * 加载康泰计算器宣传页面
	 * @return
	 */
	@Action(value = "KTCalculator", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/KTcalculator/kt_index.jsp")
			})
	public String home(){
		String openId = null;
		HttpSession session  = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("openId")!=null){
			openId = (String)session.getAttribute("openId");
		}
		if(openId==null  || openId.length()==0){
			WeiXinServiceImpl weixin = new WeiXinServiceImpl();
			openId = weixin.getOpenId(request);  
		}
		try {
			session.setAttribute("openId", openId);//将获取的openId放置seesion域中
			logger.info("加载康泰计算器宣传页面: "+openId);
			
//			Token token = Token.getToken();
//	        String access_token = token.getAccessToken();
//	        WeiXinServiceImpl weixin = new WeiXinServiceImpl();
//	        WeiXinUserEntity weixinUser = new WeiXinUserEntity();
//	        weixinUser.setJSON(weixin.getUserData(access_token, openId));//获取用户信息
//	        Integer subscribe = weixinUser.getSubscribe();
//	        logger.info("关注状态: " + subscribe);
//	        if(null == subscribe || "".equals(subscribe)){
//	        	subscribe = 0;
//	        }
//	        
//	        
			resultBusiness(true);
		} catch (Exception e) {
			logger.info(openId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	

	/**
	 * 跳转康泰结果页面
	 * @return
	 */
	@Action(value = "KTresult", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/KTcalculator/kt_result.jsp")
			})
	public String KTresult(){
		String value60 = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String) session.getAttribute("openId");
		try {
			logger.info("加载康泰结果页");
			String name = new String(request.getParameter("xingming").getBytes("ISO-8859-1"), "UTF-8");   //生产用
//			String name = request.getParameter("xingming")==null?"":request.getParameter("xingming"); 		//投保人姓名  测试
			String insuredage = request.getParameter("insuredage")==null?"":request.getParameter("insuredage"); //投保年龄
			String sex = request.getParameter("sex")==null?"":request.getParameter("sex");						//性别
			String period = request.getParameter("period")==null?"":request.getParameter("period");				//年期
			String coverage = request.getParameter("coverage")==null?"":request.getParameter("coverage");		//保额
			double a = (Double.parseDouble(coverage))*10;					//份额 (1000元为1份)
			GeKTpremiumrate geKTpremiumrate = geKtpremiumratefindService.findKTpremiumrate(insuredage);
			String startPremium = null;
			String premium = null;
			if("M".equals(sex) && "1".equals(period)){			
				startPremium = df.format((Double.parseDouble(geKTpremiumrate.getM_single()))*a/10000); 
				premium = df.format((Double.parseDouble(geKTpremiumrate.getM_single()))*a/10000);
			}else if("M".equals(sex) && "3".equals(period)){
				startPremium = df.format((Double.parseDouble(geKTpremiumrate.getM_3years()))*a/10000); 
				double premium1 = Double.parseDouble(geKTpremiumrate.getM_3years());
				premium = df.format(premium1*3*a/10000);
			}else if("M".equals(sex) && "5".equals(period)){
				startPremium = df.format((Double.parseDouble(geKTpremiumrate.getM_5years()))*a/10000); 
				double premium1 = Double.parseDouble(geKTpremiumrate.getM_5years());
				premium = df.format(premium1*5*a/10000);
			}else if("M".equals(sex) && "10".equals(period)){
				startPremium = df.format((Double.parseDouble(geKTpremiumrate.getM_10years()))*a/10000); 
				double premium1 = Double.parseDouble(geKTpremiumrate.getM_10years());
				premium = df.format(premium1*10*a/10000);
			}else if("M".equals(sex) && "20".equals(period)){
				startPremium = df.format((Double.parseDouble(geKTpremiumrate.getM_20years()))*a/10000); 
				double premium1 = Double.parseDouble(geKTpremiumrate.getM_20years());
				premium = df.format(premium1*20*a/10000);
			}else if("F".equals(sex) && "1".equals(period)){
				startPremium = df.format((Double.parseDouble(geKTpremiumrate.getF_single()))*a/10000); 
				premium = df.format((Double.parseDouble(geKTpremiumrate.getF_single()))*a/10000);
			}else if("F".equals(sex) && "3".equals(period)){
				startPremium = df.format((Double.parseDouble(geKTpremiumrate.getF_3years()))*a/10000); 
				double premium1 = Double.parseDouble(geKTpremiumrate.getF_3years());
				premium = df.format(premium1*3*a/10000);
			}else if("F".equals(sex) && "5".equals(period)){
				startPremium = df.format((Double.parseDouble(geKTpremiumrate.getF_5years()))*a/10000); 
				double premium1 = Double.parseDouble(geKTpremiumrate.getF_5years());
				premium = df.format(premium1*5*a/10000);
			}else if("F".equals(sex) && "10".equals(period)){
				startPremium = df.format((Double.parseDouble(geKTpremiumrate.getF_10years()))*a/10000); 
				double premium1 = Double.parseDouble(geKTpremiumrate.getF_10years());
				premium = df.format(premium1*10*a/10000);
			}else if("F".equals(sex) && "20".equals(period)){
				startPremium = df.format((Double.parseDouble(geKTpremiumrate.getF_20years()))*a/10000); 
				double premium1 = Double.parseDouble(geKTpremiumrate.getF_20years());
				premium = df.format(premium1*20*a/10000);
			}
			logger.info("康泰金生产品: 投保人姓名:"+name+"--投保年龄:"+insuredage+"--性别:"+sex+"--年期:"+period+"--保额:"+coverage+"万--年交保费:"+startPremium+"万--首年保费:"+startPremium+"万--总保费:"+premium+"万--保额:"+coverage+"万元");
			if(Integer.parseInt(insuredage) >= 60){
				value60 = "0.00";
			}else {
				GeKTinsurancecashvalue year60= geKtinsurancecashvaluefindService.findKTinsurancecashvalue(period, sex, insuredage,String.valueOf(Integer.parseInt("60")-Integer.parseInt(insuredage)));
				value60 = df.format((Double.parseDouble(year60.getCashvalue()))*a/10000);
			}
			logger.info("查询康泰60岁现金价值");
			session.setAttribute("value60", value60);
			session.setAttribute("xingming", name);
			session.setAttribute("insuredage", insuredage);
			session.setAttribute("sex", sex);
			session.setAttribute("period", period);
			session.setAttribute("coverage", coverage);
			session.setAttribute("startPremium", startPremium);
			session.setAttribute("premium", premium);
		}catch (Exception e) {
			logger.error(openId+" : "+ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	
	
	/**
	 * 康泰金生现金价值计算
	 * @return
	 */
	@Action(value = "KTtrial", results = {
			@Result(name="success",type="json")
			})
	public String getKtCalculator(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String)session.getAttribute("openId");//取openId
		try {
			logger.info("康泰金生现金价值计算");
			String insuredage =  (String) (session.getAttribute("insuredage")==null?"":session.getAttribute("insuredage")); //投保年龄
			String sex = (String) (session.getAttribute("sex")==null?"":session.getAttribute("sex"));						//性别
			String period = (String) (session.getAttribute("period")==null?"":session.getAttribute("period"));				//年期
			String coverage = (String) (session.getAttribute("coverage")==null?"":session.getAttribute("coverage"));		//保额
			String valueage = request.getParameter("valueage")==null?"":request.getParameter("valueage");		//现金价值年龄
			double a = (Double.parseDouble(coverage))*10;					//份额 (1000元为1份)
			GeKTinsurancecashvalue KTinsurancecashvalue = geKtinsurancecashvaluefindService.findKTinsurancecashvalue(period, sex, insuredage,String.valueOf(Integer.parseInt(valueage)-Integer.parseInt(insuredage)));
			String value = df.format((Double.parseDouble(KTinsurancecashvalue.getCashvalue()))*a/10000);	
			logger.info("康泰金生产品: 投保年龄:"+insuredage+"--性别:"+sex+"--年期:"+period+"--保额:"+coverage+"万--"+valueage+"岁现金价值:"+value+"万元");	   
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("value", value);
			JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
			result = json.toString();
		} catch (Exception e) {
			logger.error(openId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}


	/**
	 * 生成康泰金生现金价值表
	 * @return
	 */
	@Action(value = "KTxj", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/KTcalculator/kt_xj.jsp")
			})
	public String getKtxj(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String openId = (String)session.getAttribute("openId");//取openId
		String value = null ; //现金价值
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			logger.info("康泰金生现金价值表生成");
			String insuredage =  (String) (session.getAttribute("insuredage")==null?"":session.getAttribute("insuredage")); //投保年龄
			String sex = (String) (session.getAttribute("sex")==null?"":session.getAttribute("sex"));						//性别
			String period = (String) (session.getAttribute("period")==null?"":session.getAttribute("period"));				//年期
			String coverage = (String) (session.getAttribute("coverage")==null?"":session.getAttribute("coverage"));		//保额
			double a = (Double.valueOf(coverage))*10;		//份额 (1000元为1份)
			for(int i = Integer.parseInt(insuredage)+1; i<107 ; i++){
				GeKTinsurancecashvalue KTinsurancecashvalue = geKtinsurancecashvaluefindService.findKTinsurancecashvalue(period, sex, insuredage,String.valueOf(i-Integer.parseInt(insuredage)));
				value = String.valueOf((Double.parseDouble(KTinsurancecashvalue.getCashvalue()))*a);
				String i1 = String.valueOf(i);
				map.put(i1, value);
			}
			JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
			request.setAttribute("map", json.toString());	
			logger.info("康泰金生现金价值表生成结束---"+json);
		} catch (Exception e) {
			logger.error(openId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	@Override
	protected void processResultBusiness(boolean resultSuccess,
			String resultCode, String resultDescription) {
		
	}




	public String getResult() {
		return result;
	}




	public void setResult(String result) {
		this.result = result;
	}


	
}
