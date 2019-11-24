package cn.com.sinosoft.product.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.core.utils.StringUtils;
import cn.com.sinosoft.domain.sell.GePolicy;
import cn.com.sinosoft.domain.system.GeDepartment;
import cn.com.sinosoft.product.service.DepartmentService;
import cn.com.sinosoft.product.service.PolicyService;

@Component
public class PolicyServiceImpl extends GenericHibernateDao<GePolicy, String> implements PolicyService{
	/**
	 * 分页查询保单列表
	 */
	@Autowired
	private DepartmentService ds;
	
	public Page<GePolicy> getPolicy(Set<GeDepartment> departments,GePolicy gePolicy, int page,int rows) {
		boolean flag = true;
		List<Object> gdList = new ArrayList<Object>();
		for (GeDepartment department : departments) {
			Object deptid = department.getDeptid();
				gdList.add(deptid);
		}
		QueryRule queryRule = QueryRule.getInstance();
		if(gePolicy!=null){
			if(!StringUtils.isEmpty(gePolicy.getPolicycode())){
				queryRule.addLike("policycode", "%"+gePolicy.getPolicycode()+"%");
			}
			if(!StringUtils.isEmpty(gePolicy.getProductname())){
				queryRule.addEqual("productname", gePolicy.getProductname());
			}
			if(!StringUtils.isEmpty(gePolicy.getApplicantname())){
				queryRule.addLike("applicantname", "%"+gePolicy.getApplicantname()+"%");
			}
			if(!StringUtils.isEmpty(gePolicy.getStatus())){
				queryRule.addEqual("status", gePolicy.getStatus());
			}
			if(!StringUtils.isEmpty(gePolicy.getDeptid())){
				for (Object object : gdList) {
					if (gePolicy.getDeptid().equals((String)object)) {
						flag = false;
					}
				}
				if(!flag){
					queryRule.addEqual("deptid", gePolicy.getDeptid());
				}
			}
			if(!StringUtils.isEmpty(gePolicy.getBrno())){
				queryRule.addLike("brno", "%"+gePolicy.getBrno()+"%");
			}
			if(!StringUtils.isEmpty(gePolicy.getAgentcode())){
				queryRule.addLike("agentcode", "%"+gePolicy.getAgentcode()+"%");
			}
			if(gePolicy.getStarttime()!=null){
				queryRule.addGreaterEqual("insuretime",gePolicy.getStarttime());
			}
			if(gePolicy.getEndtime()!=null){
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(gePolicy.getEndtime());
				calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
				queryRule.addLessEqual("insuretime",calendar.getTime());
			}
		}
		if (flag) {
			queryRule.addIn("deptid", gdList);
		}
		queryRule.addNotEqual("status", "1");
		queryRule.addNotEqual("status", "2");
		queryRule.addDescOrder("insuretime");
		Page<GePolicy> find1 = super.find(queryRule, page, rows);
		for(GePolicy gePolicy1: (List<GePolicy>)find1.getData()){
			String detpid = gePolicy1.getDeptid()==null?"":gePolicy1.getDeptid();
	    	GeDepartment department = ds.getDepartmentByDetpid(detpid);
	    	String deptname = department==null?"":department.getDeptname();
			gePolicy1.setDeptid(deptname);
		}
		return find1;
	}
	public Page<GePolicy> getCharityPolicy(GePolicy gePolicy, int page,int rows) {
		QueryRule queryRule = QueryRule.getInstance();
		if(gePolicy!=null){
			if(!StringUtils.isEmpty(gePolicy.getPolicycode())){
				queryRule.addLike("policycode", "%"+gePolicy.getPolicycode()+"%");
			}
			if(!StringUtils.isEmpty(gePolicy.getProductname())){
				queryRule.addEqual("productname", gePolicy.getProductname());
			}
			if(!StringUtils.isEmpty(gePolicy.getApplicantname())){
				queryRule.addLike("applicantname", "%"+gePolicy.getApplicantname()+"%");
			}
			if(!StringUtils.isEmpty(gePolicy.getStatus())){
				queryRule.addEqual("status", gePolicy.getStatus());
			}
			if(gePolicy.getStarttime()!=null){
				queryRule.addGreaterEqual("insuretime",gePolicy.getStarttime());
			}
			if(gePolicy.getEndtime()!=null){
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(gePolicy.getEndtime());
				calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
				queryRule.addLessEqual("insuretime",calendar.getTime());
			}
		}
		queryRule.addEqual("charityflag", "0"); //赠险标识
		queryRule.addNotEqual("status", "1");
		queryRule.addNotEqual("status", "2");
		queryRule.addDescOrder("insuretime");
		return this.find(queryRule, page, rows);
	}

	public GePolicy getPolicyByPolicyno(String policyno) {
		return super.get(policyno);
	}

	public List<GePolicy> getAllPolicy(String policycode,String productname,String applicantname,String status,String starttime,String endtime,String agentcode,String brno,String deptid,Set<GeDepartment> departments) {
		boolean flag = true;
		List<Object> gdList = new ArrayList<Object>();
		for (GeDepartment department : departments) {
				gdList.add(department.getDeptid());
		}
		QueryRule queryRule = QueryRule.getInstance();
			if(!StringUtils.isEmpty(policycode)){
				queryRule.addLike("policycode", "%"+policycode+"%");
			}
			if(!StringUtils.isEmpty(productname)){
				queryRule.addEqual("productname", productname);
			}
			if(!StringUtils.isEmpty(applicantname)){
				queryRule.addLike("applicantname", "%"+applicantname+"%");
			}
			if(!StringUtils.isEmpty(agentcode)){
				queryRule.addLike("agentcode", "%"+agentcode+"%");
			}
			if(!StringUtils.isEmpty(brno)){
				queryRule.addLike("brno", "%"+brno+"%");
			}
			if(!StringUtils.isEmpty(status)){
				queryRule.addEqual("status", status);
			}
			if(!StringUtils.isEmpty(deptid)){
				for (Object object : gdList) {
					if (deptid.equals((String)object)) {
						flag = false;
					}
				}
				if(!flag){
					queryRule.addEqual("deptid", deptid);
				}
			}
			if(!StringUtils.isEmpty(starttime)){
				  try {
					DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");            
					    Date date = fmt.parse(starttime);
					    queryRule.addGreaterEqual("insuretime",date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
			}
			if(!StringUtils.isEmpty(endtime)){
				try {
					DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");            
					    Date date = fmt.parse(endtime);
					    Calendar calendar = Calendar.getInstance();
					    calendar.setTime(date);
					    calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
					    queryRule.addLessEqual("insuretime",calendar.getTime());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
			}
			if (flag) {
				queryRule.addIn("deptid", gdList);
			}
			queryRule.addNotEqual("status", "1");
			queryRule.addNotEqual("status", "2");
			queryRule.addDescOrder("insuretime");
			List<GePolicy> find = super.find(queryRule);
			for (GePolicy gePolicy : find) {
				String detpid = gePolicy.getDeptid()==null?"":gePolicy.getDeptid();
		    	GeDepartment department = ds.getDepartmentByDetpid(detpid);
		    	String deptname = department==null?"":department.getDeptname();
		    	gePolicy.setDeptid(deptname);
			}
		return find;
	}
	
	public List<GePolicy> getAllCharityPolicy(String policycode,String productname,String applicantname,String status,String starttime,String endtime) {
		QueryRule queryRule = QueryRule.getInstance();
		if(!StringUtils.isEmpty(policycode)){
			queryRule.addLike("policycode", "%"+policycode+"%");
		}
		if(!StringUtils.isEmpty(productname)){
			queryRule.addEqual("productname", productname);
		}
		if(!StringUtils.isEmpty(applicantname)){
			queryRule.addLike("applicantname", "%"+applicantname+"%");
		}
		if(!StringUtils.isEmpty(status)){
			queryRule.addEqual("status", status);
		}
		if(!StringUtils.isEmpty(starttime)){
			try {
				DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");            
				Date date = fmt.parse(starttime);
				queryRule.addGreaterEqual("insuretime",date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(!StringUtils.isEmpty(endtime)){
			try {
				DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");            
				Date date = fmt.parse(endtime);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
				queryRule.addLessEqual("insuretime",calendar.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		queryRule.addEqual("charityflag", "0"); //赠险标识
		queryRule.addNotEqual("status", "1");
		queryRule.addNotEqual("status", "2");
		queryRule.addDescOrder("insuretime");
		return super.find(queryRule);
	}
	
	@Override
	public Page<GePolicy> getPolicy(GePolicy gePolicy, int page, int rows) {
		QueryRule queryRule = QueryRule.getInstance();
		if(gePolicy!=null){
			if(!StringUtils.isEmpty(gePolicy.getPolicycode())){
				queryRule.addLike("policycode", "%"+gePolicy.getPolicycode()+"%");
			}
			if(!StringUtils.isEmpty(gePolicy.getProductname())){
				queryRule.addEqual("productname", gePolicy.getProductname());
			}
			if(!StringUtils.isEmpty(gePolicy.getApplicantname())){
				queryRule.addLike("applicantname", "%"+gePolicy.getApplicantname()+"%");
			}
			if(!StringUtils.isEmpty(gePolicy.getStatus())){
				queryRule.addEqual("status", gePolicy.getStatus());
			}
			if(!StringUtils.isEmpty(gePolicy.getDeptid())){
					queryRule.addEqual("deptid", gePolicy.getDeptid());
			}
			if(!StringUtils.isEmpty(gePolicy.getBrno())){
				queryRule.addLike("brno", "%"+gePolicy.getBrno()+"%");
			}
			if(!StringUtils.isEmpty(gePolicy.getAgentcode())){
				queryRule.addLike("agentcode", "%"+gePolicy.getAgentcode()+"%");
			}
			if(gePolicy.getStarttime()!=null){
				queryRule.addGreaterEqual("insuretime",gePolicy.getStarttime());
			}
			if(gePolicy.getEndtime()!=null){
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(gePolicy.getEndtime());
				calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
				queryRule.addLessEqual("insuretime",calendar.getTime());
			}
		}
		queryRule.addNotEqual("status", "1");
		queryRule.addNotEqual("status", "2");
		queryRule.addDescOrder("insuretime");
		Page<GePolicy> find1 = super.find(queryRule, page, rows);
		for(GePolicy gePolicy1: (List<GePolicy>)find1.getData()){
			String detpid = gePolicy1.getDeptid()==null?"":gePolicy1.getDeptid();
	    	GeDepartment department = ds.getDepartmentByDetpid(detpid);
	    	String deptname = department==null?"":department.getDeptname();
			gePolicy1.setDeptid(deptname);
		}
		return find1;
	}
	
	@Override
	public List<GePolicy> getAllPolicy(String policycode, String productname,String applicantname, String status, String starttime,String endtime, String agentcode, String brno, String deptid) {
		QueryRule queryRule = QueryRule.getInstance();
			if(!StringUtils.isEmpty(policycode)){
				queryRule.addLike("policycode", "%"+policycode+"%");
			}
			if(!StringUtils.isEmpty(productname)){
				queryRule.addEqual("productname", productname);
			}
			if(!StringUtils.isEmpty(applicantname)){
				queryRule.addLike("applicantname", "%"+applicantname+"%");
			}
			if(!StringUtils.isEmpty(agentcode)){
				queryRule.addLike("agentcode", "%"+agentcode+"%");
			}
			if(!StringUtils.isEmpty(brno)){
				queryRule.addLike("brno", "%"+brno+"%");
			}
			if(!StringUtils.isEmpty(status)){
				queryRule.addEqual("status", status);
			}
			if(!StringUtils.isEmpty(deptid)){
			    queryRule.addEqual("deptid", deptid);
			}
			if(!StringUtils.isEmpty(starttime)){
				  try {
					DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");            
					    Date date = fmt.parse(starttime);
					    queryRule.addGreaterEqual("insuretime",date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
			}
			if(!StringUtils.isEmpty(endtime)){
				try {
					DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");            
					    Date date = fmt.parse(endtime);
					    Calendar calendar = Calendar.getInstance();
					    calendar.setTime(date);
					    calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
					    queryRule.addLessEqual("insuretime",calendar.getTime());
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			queryRule.addNotEqual("status", "1");
			queryRule.addNotEqual("status", "2");
			queryRule.addDescOrder("insuretime");
			List<GePolicy> find = super.find(queryRule);
			for (GePolicy gePolicy : find) {
				String detpid = gePolicy.getDeptid()==null?"":gePolicy.getDeptid();
		    	GeDepartment department = ds.getDepartmentByDetpid(detpid);
		    	String deptname = department==null?"":department.getDeptname();
		    	gePolicy.setDeptid(deptname);
			}
		return find;
	}
}
