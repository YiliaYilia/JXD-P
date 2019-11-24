package cn.com.sinosoft.web.msl.sales;

import org.apache.struts2.convention.annotation.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.ess.config.service.GeDepartmentService;
import cn.com.sinosoft.web.msl.BaseAction;

public class DepartmentAction extends BaseAction {
	public static Logger logger = LoggerFactory.getLogger(DepartmentAction.class);
	
	@Autowired
	private GeDepartmentService depser;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Action(value="existDepart")
	public void existDepartment(){
		logger.info("查询组织机构是否存在");
		String resultsjon = null;
		String deptCode = request.getParameter("agentCode");
		String deptCode1 = deptCode.substring(0, 2).toUpperCase();
		boolean boo = depser.findByDeptCode(deptCode1);
		if(boo){
			resultsjon = "{\"flag\":\"0\",\"content\":\""+deptCode1+"\"}";
		}else{
			resultsjon = "{\"flag\":\"1\",\"content\":\"推荐人编码填写有误\"}";
		}
		super.renderJson(resultsjon);
		logger.info("查询组织机构返回json："+resultsjon);
	}

	@Override
	protected void processResultBusiness(boolean resultSuccess,
			String resultCode, String resultDescription) {
		// TODO Auto-generated method stub
		
	}
}
