package cn.com.sinosoft.web.action;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.common.service.axis.BasicQuery;
import cn.com.sinosoft.common.service.axis.ClientBindModel;
import cn.com.sinosoft.common.service.axis.LifeADTPModel;
import cn.com.sinosoft.common.service.axis.QueryModel;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.sale.GE_ProductcodeOTM;
import cn.com.sinosoft.domain.sale.GeInvestment;
import cn.com.sinosoft.domain.sale.GeMobileCustomer;
import cn.com.sinosoft.ess.product.common.Data;
import cn.com.sinosoft.sale.service.InvestmentService;
import cn.com.sinosoft.sale.service.PolicyMobileService;
import cn.com.sinosoft.web.entity.IDTypeEntity;
import cn.com.sinosoft.web.service.facade.ClientBindService;
import cn.com.sinosoft.web.service.facade.LifeADTPService;
import cn.com.sinosoft.web.service.facade.PolicyBasicQueryService;
import cn.com.sinosoft.web.service.facade.PolicyListQueryService;
import cn.com.sinosoft.web.service.impl.ElectronicPolicyQueryServiceImpl;

public class PolicyQueryAction extends Struts2Action{
	private static final long serialVersionUID = 1L;
	private final static Logger logger = LoggerFactory.getLogger(PolicyQueryAction.class);
	@Autowired
	private ElectronicPolicyQueryServiceImpl electronicPolicyQueryServiceImpl;
	@Autowired
	private PolicyListQueryService policyListQueryService;
	@Autowired
	private PolicyMobileService policyMobileService;
	@Autowired
	private PolicyBasicQueryService policyBasicQueryService;
	@Autowired
	private ClientBindService clientBindService;
	@Autowired
	private InvestmentService investmentService;
	@Autowired
	private LifeADTPService lifeADTPService;
	
	private QueryModel[] policyList;
	private  BasicQuery policyBasic;
	private GeInvestment geInvestment;

	/**
	 * 功能：查询保单列表
	 * 描述：通过微信ID查询本地库绑定的用户信息(可以绑定多个用户)，调用核心接口查询保单列表并拼装
	 * 作者： ZhangTiancong
	 * @param	OpenID		微信ID
	 */
	@Action(value="getPolicyList")
	public String getPolicyList(){
		//需求，如果一个openID绑定多个客户，则只取一个以长险为主
		try{
			logger.info("get into getPolicyList");
			String OpenID = this.getHttpServletRequest().getParameter("OpenID");
//			String OpenID = "oipGbs6aOJCQcO0jGszXYVdAmp_I";
			logger.info("用户OPenId===="+OpenID);
			this.getHttpServletRequest().getSession().setAttribute("OpenID", OpenID);
			if(Data.hasValue(OpenID) && !"null".equals(OpenID) && clientBindService.checkOpenID(OpenID).size()>0){
				List<GeMobileCustomer> mcList = policyMobileService.getOrderByNo(OpenID);
				GeMobileCustomer geMobileCustomer = null;
				for(GeMobileCustomer temp:mcList){
					if(temp.getType() != null && "2".equals(temp.getType())){//如果客户号为短险
						geMobileCustomer = temp;
					}else if(temp.getType() != null && "1".equals(temp.getType())){//如果客户为长险
						geMobileCustomer = temp;
						break;
					}
				}
				String idType = geMobileCustomer.getIdtype();
				String idNo = geMobileCustomer.getIdnumber();
				String clientName = geMobileCustomer.getName();
				String partyCode = geMobileCustomer.getCoustomerid();
				String roleCode = "POLICY-HOL";
				if(geMobileCustomer.getType()!=null && "2".equals(geMobileCustomer.getType())){	
					//只有短险客户，则重新去核心查询是否有长险客户。目的：客户先买短险绑定微信后又去买长险，若使用同一证件则无法查询到长险信息
					//查询该客户是否被其他用户绑定
					List<GeMobileCustomer> customers = clientBindService.findCustomers(idType, idNo, clientName, "1");
					if(customers != null && customers.size()==0){//该客户长险信息未被其他微信绑定
						//查询长险并绑定到该openid上
						ClientBindModel clientBind = clientBindService.clientBindQuery(IDTypeEntity.formatIDType("saveType","longType", idType), idNo, clientName,OpenID);
					}
				}
				policyList = policyListQueryService.depacketizeQuery(policyList,clientName,idType,idNo,partyCode,roleCode);
				if(policyList.length<1){
					this.setRequestAttribute("Contenct", "保单查询失败");
				}
			}else{
				policyList = new QueryModel[0];
				this.setRequestAttribute("OpenID", OpenID);
				logger.info("openid:" + OpenID + ",未查到该微信绑定客户");
				return "../page/index";
			}
		}catch (Exception e) {
			this.setRequestAttribute("Contenct", "保单查询失败");
			policyList = new QueryModel[0];
			logger.error("保单列表查询异常", e);
		}
		this.setRequestAttribute("policyList", policyList);
		policyList = null;
		return "../page/policylist";
	}
	
	/**
	 * 功能：查询保单基本信息
	 * 描述：调用核心查询基本信息接口，成功代码-0
	 * 作者： ZhangTiancong
	 * @param	policyNo		保单号
	 */
	@Action(value="getPolicyBasic")
	public String getPolicyBasic(){
		
		HttpServletRequest request = super.getHttpServletRequest();
		String policyNo = request.getParameter("policyNo")==null?"":request.getParameter("policyNo");
//		String policyNo ="TM16729026";
//		String replace = policyNo.replace("","");
//		logger.info("判断是否微信单，保单号："+policyNo);
//		List policylist = WechatPolicy.findpolicybypolicyNo(policyNo);
//		logger.info("policylist:"+policylist.size());
//		if(policylist!=null&&policylist.size()!=0){
//			request.setAttribute("channel","wechat");
//			logger.info("微信支付保单");
//		}
	/*	GePolicy policylist = BanNumService.getPolicybypolicyno(policyNo);
		if(policylist!=null){
		request.setAttribute("channel","wechat");
		logger.info("微信支付保单");
	}*/
		
	
		if(Data.hasValue(policyNo)){
		//查询短险
		policyBasic = policyBasicQueryService.ShortPolicyBasic(policyNo);
		if("0".equals(policyBasic.getCode().toString())){
			this.setRequestAttribute("coustomerid", policyBasic.getPartyCode());
			logger.info("查询短险保单详情成功，客户号："+policyBasic.getPartyCode());
			logger.info("保单状态："+policyBasic.getPolicystatus());
			this.setRequestAttribute("policyBasic", policyBasic);
		}else{
			//查询长险
			policyBasic = policyBasicQueryService.policyBasicQuery(policyNo);
			if("0".equals(policyBasic.getCode().toString())){
				logger.info("查询长险保单详情成功，客户号："+policyBasic.getPartyCode());
				logger.info("保单状态："+policyBasic.getPolicystatus());
				String policysource = policyBasic.getPolicysource();//渠道
				String filepath = electronicPolicyQueryServiceImpl.getDOCUMENTPATH(policyBasic.getPolicyNum());//根据保单号查询电销有无电子保单
//				String filepath = electronicPolicyQueryServiceImpl.getDOCUMENTPATH("TM16729026");//根据保单号查询电销有无电子保单,测试用
				String policytime=null;
				if(policysource.equals("TMR")){//电销
					if(filepath!=null){
						SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//					Date date = electronicPolicyQueryServiceImpl.getDate("TM16729026");//根据保单号从电销数据库获取保单时间
						Date date = electronicPolicyQueryServiceImpl.getDate(policyBasic.getPolicyNum());
						String format2 = format.format(date);
						logger.info("电销电子保单创建时间"+format2);
						if(date!=null){
							try {
								Date date1 = format.parse("2016-08-04 00:12:00");//2016年八月4号12点之后的只有一个电子保单pdf
								if(date.after(date1)){
									policytime="Y";
									request.setAttribute("policytime","Y");
								}
								if(date.before(date1)){
									policytime="N";
									request.setAttribute("policytime","N");
								}
							} catch (ParseException e1) {
								logger.info("String转date异常");
								e1.printStackTrace();
							}
						}
						request.setAttribute("validate", "Y");
					}else{
						logger.info("此电销产品无电子保单");
					}
				}
				else {
					request.setAttribute("validate", "N");
				}
				
				List<GE_ProductcodeOTM> pdfname = electronicPolicyQueryServiceImpl.findPdfnamebycode(policyBasic.getProductCode(),policyBasic.getProductName(),filepath);
				request.setAttribute("pdfname",pdfname);
				request.setAttribute("policytime",policytime);
				request.setAttribute("filepath",filepath);
						
				//policyBasic.setTerm(policyBasic.getTerm()+"年");
				logger.info("TotalValue="+policyBasic.getTotalValue());
				logger.info("InsuranceType="+policyBasic.getInsuranceType());
			/*	logger.info("Investments="+policyBasic.getInvestments());
				
			 	if(!Data.hasValue(policyBasic.getTotalValue())){
					if ("ULINDLIFE".equals(policyBasic.getInsuranceType()) && policyBasic.getInvestments() != null && policyBasic.getInvestments().length>0){
						//投连
						BigDecimal value  = null;
						BigDecimal totalvalue = new BigDecimal(0);
						for(InvestmentModel investment:policyBasic.getInvestments()){
							value = new BigDecimal(investment.getUnits()).multiply(new BigDecimal(investment.getPrice()));
							totalvalue = totalvalue.add(value);
						}
						policyBasic.setTotalValue(totalvalue.toString());
					}
				}*/
				if(!Data.hasValue(policyBasic.getTotalValue())){
					//投连
					if ("ULINDLIFE".equals(policyBasic.getInsuranceType()) && policyBasic.getInvestmentAccount()!= null && policyBasic.getInvestmentAccount().length()>0){
						logger.info("兄弟");
						policyBasic.setInvestments(policyBasic.getTInvestmentModel());
						String InvestmentAccount = this.policyBasic.getInvestmentAccount();
			            String[] split = InvestmentAccount.split(".");
			            if ((split.length >= 2) && (split[1].length() >= 2)) {
			            	InvestmentAccount = InvestmentAccount.substring(0, InvestmentAccount.indexOf(".") + 3);
			            }
						policyBasic.setTotalValue(InvestmentAccount);
						logger.info("投连险总价值"+InvestmentAccount);
					}
				}
				if(Data.hasValue(policyBasic.getTotalValue())&&!" ".equals(policyBasic.getTotalValue())){
					policyBasic.setTotalValue(new BigDecimal(policyBasic.getTotalValue()).setScale(2,BigDecimal.ROUND_HALF_UP).toString());
				}
			if(policyBasic.getSubSource().equals("090008")||policyBasic.getSubSource().equals("090009")){
					request.setAttribute("channel","wechat");
					logger.info("微信支付保单");
				}
				this.setRequestAttribute("policyBasic", policyBasic);
				request.getSession().setAttribute("basic", policyBasic.getPolicyNum());
				this.setRequestAttribute("coustomerid", policyBasic.getPartyCode());
			}else{
				this.setRequestAttribute("Contenct", "保单查询失败");	
				logger.info(policyNo+"长险查询基本信息失败，原因："+policyBasic.getContenct());
			}
		}
		
		}
		return "../page/policyinfo";
		
	}
	 
	/**
	 * 功能：投连险保单投资信息
	 * 描述：重组投连险保单投资信息转发至详细信息页
	 * 作者： ZhangTiancong
	 */
	@Action(value="getInvestment")
	public String getPolicyInvestment(){
		HttpServletRequest request = super.getHttpServletRequest();
		String investment = request.getParameter("investment")==null?"":request.getParameter("investment");
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
					tempMap.put("price",new BigDecimal((String)tempMap.get("price")).setScale(2,BigDecimal.ROUND_HALF_UP).toString());
					tempMap.put("units",new BigDecimal((String)tempMap.get("units")).setScale(2,BigDecimal.ROUND_HALF_UP).toString());
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
		this.setRequestAttribute("investments", list);
		return "../page/investmentvalue";
	}
	
	/**查询万能险
	 * @return
	 */
	@Action(value="getUniversal")
	public String getPolicyUniversal(){
		HttpServletRequest request = super.getHttpServletRequest();
		String rate = request.getParameter("rate")==null?"":request.getParameter("rate");
		String month = request.getParameter("month")==null?"":request.getParameter("month");
		String totalValue = request.getParameter("totalValue")==null?"":request.getParameter("totalValue");
		if(Data.hasValue(rate)){
			rate = new BigDecimal(rate).setScale(2,BigDecimal.ROUND_HALF_UP).toString();
		}
		month = month.matches("0[0-9]{1}")?month.substring(1):month;
		if(Data.hasValue(totalValue)){
			totalValue = new BigDecimal(totalValue).setScale(2,BigDecimal.ROUND_HALF_UP).toString();
		}
		
		this.setRequestAttribute("rate", rate);
		this.setRequestAttribute("month", month);
		this.setRequestAttribute("totalValue", totalValue);
		return "../page/universalvalue";
		
	}
	
	/**
	 * 跳转到追加页面
	 * @return
	 */
	@Action(value="addInvestment")
	public String addInvestment(){
		HttpServletRequest request = super.getHttpServletRequest();
		String accountBank = request.getParameter("accountBank")==null?"":request.getParameter("accountBank");
		String bankCardId = request.getParameter("bankCardId")==null?"":request.getParameter("bankCardId");
        int length=bankCardId.length();
        String showBankCardId = null;
        if(length>15){
        	showBankCardId ="***************"+bankCardId.substring(length);
        } else {
        	showBankCardId = bankCardId;
        	logger.error("接口返回银行卡号有误："+bankCardId);
        }
		String policyNo = request.getParameter("policyNum")==null?"":request.getParameter("policyNum");
		String applicantName = request.getParameter("applicantName")==null?"":request.getParameter("applicantName");
		this.setRequestAttribute("accountBank", accountBank);
		this.setRequestAttribute("showBankCardId", showBankCardId);
		this.setRequestAttribute("bankCardId", bankCardId);
		this.setRequestAttribute("policyNo", policyNo);
		this.setRequestAttribute("applicantName", applicantName);
		return "../page/addInvestment";
	}
	
	/**
	 * 追加信息保存
	 * @return
	 */
	@Action(value="saveInvestment")
	public String saveInvestment(){
		try {
			geInvestment.setCreateTime(new Date());
			investmentService.saveInvestment(geInvestment);
			logger.error(geInvestment.getPolicyNo()+"追加投资信息保存成功：");
		} catch (Exception e) {
			logger.error(geInvestment.getPolicyNo()+"追加投资信息保存失败："+e);
		}
		return "../page/policyService";
	}
	
	/**
	 * 当天是否申请过追加
	 * @return
	 */
	@Action(value="isExistByPolicyNo")
	public void isExistByPolicyNo(){
		String resultsjon = "";
		String contenct = "";
		int code = 2;
		HttpServletRequest request = super.getHttpServletRequest();
		String policyNo = request.getParameter("policyNo")==null?"":request.getParameter("policyNo");
		String amount = request.getParameter("amount")==null?"":request.getParameter("amount");
		String bankCardID = request.getParameter("bankCardID")==null?"":request.getParameter("bankCardID");
		try {
			//b=true 当天已追加
			boolean b = investmentService.isExistByPolicyNo(policyNo);
			if(!b){
				//接口返回银行卡号不为空才可以继续追加操作
				if(!"".equals(bankCardID)){
					//调用追加接口
					LifeADTPModel life = lifeADTPService.getLifeADTP(policyNo, amount);
					if(null != life){
						contenct = life.getContenct();
						code = life.getCode();
						if(code == 0){
							//追加成功
							logger.info(policyNo +"调用核心接口追加成功  content:"+contenct+" code:"+code);
						} else {
							logger.error(policyNo+ "调用核心接口追加投资失败：content"+contenct+" code:"+code);
						}
					} else {
						logger.error("追加投资接口调用失败！");
						contenct="你好，系统繁忙！如需帮助请致电客服专线4008109339。";
					}
					
				} else {
					contenct = "预留银行卡号为空，无法进行追加投资操作！";
					logger.error("追加暂停，用户没有有效的银行卡号："+bankCardID);
				}
			}
			else {
		        contenct = "每天一张保单只能追加一次投资，请明日继续追加！";
		        logger.error("当天已经追加过，无法追加：" + policyNo);
		      }
			resultsjon = "{\"flag\":\""+b+"\",\"contenct\":\""+contenct+"\",\"code\":\""+code+"\"}";
			super.renderJson(resultsjon);
		} catch (Exception e) {
			logger.error("是否申请追加异常："+e);
		}
	}

	public GeInvestment getGeInvestment() {
		return geInvestment;
	}

	public void setGeInvestment(GeInvestment geInvestment) {
		this.geInvestment = geInvestment;
	}
	
}
