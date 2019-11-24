package cn.com.sinosoft.web.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.common.service.axis.WeChatQueryModel;
import cn.com.sinosoft.domain.sale.GeOrder;
import cn.com.sinosoft.domain.sale.GePolicy;
import cn.com.sinosoft.web.msl.BaseAction;
import cn.com.sinosoft.web.service.facade.OrderQueryService;
import cn.com.sinosoft.web.service.impl.WeiXinServiceImpl;

public class OrderQueryAction extends BaseAction {

	@Autowired
	OrderQueryService oqs;

	/**
	 * 查询订单列表 本地数据库
	 * 
	 * @param
	 * 
	 */

	@Action(value="todayOrderList")
	public String todayOrderList(){
		String openId =null;
		List<GeOrder> tOrderList =new ArrayList<GeOrder>();
		HttpSession session  = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("openId")!=null){
			openId = (String)session.getAttribute("openId");

		}
		if (openId == null || openId.length() == 0) {
			WeiXinServiceImpl weixin = new WeiXinServiceImpl();
			openId = weixin.getOpenId(request);
			session.setAttribute("openId", openId);
		}
		if(openId!=null&&openId.length()>0){
		logger.info("微信待支付订单,openid"+openId);
		 tOrderList = oqs.getTodayOrderList(openId);
		 logger.info("核心人工核保订单,openid"+openId);
		List<GeOrder> orders = oqs.todayOrder(openId);
		tOrderList.addAll(orders);
		}
		request.setAttribute("tOrderList", tOrderList);
		return "../page/orderlist";
	}

	/**
	 * 根据投保单号查询订单详情 接口
	 * 
	 * @param
	 */
	@Action(value = "todayOrderInfo")
	public String todayOrderInfo() {
		String tOrderCode = request.getParameter("torderCode");
//		WeChatQueryModel tOrderInfo = oqs.getTodayOrderInfo(tOrderCode);//接口中的详情
		GeOrder tOrder = oqs.getLocalOrderInfo(tOrderCode);//本地订单详情
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//格式化时间
//		request.setAttribute("tOrderInfo", tOrderInfo);
		request.setAttribute("tOrder", tOrder);
		request.setAttribute("submittime",format.format(tOrder.getSubmittime()));
		return "../page/orderinfo";
	}

	@Override
	protected void processResultBusiness(boolean resultSuccess, String resultCode, String resultDescription) {
	}

}
