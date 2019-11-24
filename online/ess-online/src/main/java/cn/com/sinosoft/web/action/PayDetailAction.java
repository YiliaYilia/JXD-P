package cn.com.sinosoft.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.common.service.axis.PayDeatilModel;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.web.service.facade.PayDetailService;

public class PayDetailAction extends Struts2Action{
	private static final long serialVersionUID = 1L;

	
	@Autowired
	private PayDetailService pds;
	
	
	
	/**
	 * 
	 * 向核心查询缴费明细
	 * @return page
	 */
	@Action(value="getPayDetail")
	public String getPayDetail(){
		HttpServletRequest request = super.getHttpServletRequest();
		String policyNo = request.getParameter("policyNo");
		List<PayDeatilModel> payDetailList = pds.getPayDetail(policyNo);
		request.setAttribute("payDetailList",payDetailList);
		return "../page/payDetail";
	}
}
