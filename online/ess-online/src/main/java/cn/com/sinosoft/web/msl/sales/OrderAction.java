package cn.com.sinosoft.web.msl.sales;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.ess.product.service.OrderSearchService;
import cn.com.sinosoft.ess.product.service.PolicySearchService;
import cn.com.sinosoft.web.msl.BaseAction;
import cn.com.sinosoft.web.service.impl.WeiXinServiceImpl;


public class OrderAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Logger logger = LoggerFactory.getLogger(OrderAction.class);
	@Autowired
	private OrderSearchService oss; 
	@Autowired
	private PolicySearchService pssi;
	
	private GeOrder geOrder;
	
	
	//荣誉证书
	@Action(value="findHonor", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/charity/honorSearch.jsp")
			})
	public String findHonor(){ 
		WeiXinServiceImpl weixin = new WeiXinServiceImpl();
		String openId = weixin.getOpenId(request);
		//logger.info("openId======"+openId);
		GePolicy gePolicy = null;
		//OpenId="oipGbs1ygVGqlXzioB6K4E-IESRU";
	   //String openId = "oipGbsyNIdnQYSD_zNDyQo8cN5o0";
		if(openId!=null&&openId.length()>0){
			logger.info("根据openId"+openId+"进行荣誉证书查询");
			List<GeOrder> orderList = oss.getOrder(openId);
			Double num=0.00;
			if(orderList!=null&&orderList.size()>0){
				geOrder = orderList.get(0);
			
				Double orderamount = geOrder.getOrderamount();
				
				Double stipend = geOrder.getStipend()==null?0.00:geOrder.getStipend();
				geOrder.setStipend(stipend);
				Double bookmoney = geOrder.getBookmoney()==null?0.00:geOrder.getBookmoney();
				geOrder.setBookmoney(bookmoney);
				num = orderamount+stipend+bookmoney;
				logger.info("policyNo:  "+geOrder.getPolicyno());
				gePolicy = pssi.getPolicyInfoByPolicyNo(geOrder.getPolicyno());
			}else{
				geOrder = new GeOrder();
			}
			request.setAttribute("geOrder",geOrder);
			request.setAttribute("gePolicy", gePolicy);
			request.setAttribute("num",num);
		}
		return SUCCESS;  
	}

	
	
	@Action(value="findHonorStatus", results = {
			@Result(name="success", location="/WEB-INF/jsp/page/charity/demand.jsp")
			})
	public String findHonorStatus(){ 
		WeiXinServiceImpl weixin = new WeiXinServiceImpl();
		String openId = weixin.getOpenId(request);
		logger.info("openId======"+openId);
	//	openId="oipGbs1ygVGqlXzioB6K4E-IESRU";
		if(openId!=null&&openId.length()>0){
			logger.info("根据openId"+openId+"进行荣誉证书查询");
			List<GeOrder> orderList = oss.getOrder(openId);
			if(orderList!=null&&orderList.size()>0){
				geOrder = orderList.get(0);
				String bookStatus = geOrder.getBookStatus();//爱心书库状态
				if(bookStatus!=null&&bookStatus.length()>0){
					request.setAttribute("bookStatus",bookStatus);
				}else{
					request.setAttribute("bookStatus","暂无进度");
				}
				String sgiftStatus = geOrder.getGiftStatus();//助学金状态
				if(sgiftStatus!=null&&sgiftStatus.length()>0){
					request.setAttribute("sgiftStatus",sgiftStatus);
				}else{
					request.setAttribute("sgiftStatus","暂无进度");
				}
			}else{
				request.setAttribute("bookStatus","暂无进度");
				request.setAttribute("sgiftStatus","暂无进度");
			}

		}
		return SUCCESS;  
	}

	@Override
	protected void processResultBusiness(boolean resultSuccess,
			String resultCode, String resultDescription) {
		
	}
}
 