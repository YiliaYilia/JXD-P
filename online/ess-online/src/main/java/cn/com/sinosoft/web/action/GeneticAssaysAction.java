package cn.com.sinosoft.web.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.sale.GeneticAssays;
import cn.com.sinosoft.web.service.facade.GeneticAssaysService;
import cn.com.sinosoft.web.service.impl.WeiXinServiceImpl;

public class GeneticAssaysAction extends Struts2Action{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static Logger logger = LoggerFactory.getLogger(GeneticAssaysAction.class);
	
	
	@Autowired
	private GeneticAssaysService assaysService;
	
	HttpSession session  = ServletActionContext.getRequest().getSession();
	
	@Action(value="index")
	public String index() {
		String openId =null;
		if(session.getAttribute("openId")!=null){
			openId = (String)session.getAttribute("openId");
		}
		if (openId == null || openId.length() == 0) {
			WeiXinServiceImpl weixin = new WeiXinServiceImpl();
			openId = weixin.getOpenId(super.getHttpServletRequest());
		}
			session.setAttribute("openid", openId);
			return "../GeneticAssays/page/main";
	
	}
	
	@Action(value="getGeneticAssays")
	public void getGeneticAssays() {
		String resultsjon =null;
		String openId = (String)session.getAttribute("openid");
		String name= null;
		String address= null;
		String phone= null;
		if(openId!=null&&openId.length() != 0){
			if(assaysService.GeneticAssaysCheck(openId)){
				resultsjon = "{\"flag\":\"2\",\"content\":\"已经存在\"}";
				logger.info("此用户已经录入过，openid:"+openId);
			}else{
				 name=super.getHttpServletRequest().getParameter("name");
				 address=super.getHttpServletRequest().getParameter("address");
				 phone=super.getHttpServletRequest().getParameter("phone");
				logger.info("基因检测信息录入开始，openid:"+openId+",name:"+name+",phone:"+phone+",address:"+address);
				GeneticAssays assays=new GeneticAssays();
				assays.setAddress(address);
				assays.setName(name);
				assays.setPhone(phone);
				assays.setOpenid(openId);
				assays.setTime(new Date());
				try {
					assaysService.saveGeneticAssays(assays);
					resultsjon = "{\"flag\":\"1\",\"content\":\"成功\"}";
					logger.info("基因检测信息录入成功，openid:"+openId+",name:"+name+",phone:"+phone+",address"+address);
				} catch (Exception e) {
					e.printStackTrace();
					resultsjon = "{\"flag\":\"0\",\"content\":\"失败\"}";
					logger.info("基因检测信息录入失败，openid:"+openId+",name:"+name+",phone:"+phone+",address"+address);
				}
			}
			
		}else{
			resultsjon = "{\"flag\":\"3\",\"content\":\"失败\"}";
			logger.info("基因检测信息录入失败，openid为空");
		}
		super.renderJson(resultsjon);
	}
	
}
