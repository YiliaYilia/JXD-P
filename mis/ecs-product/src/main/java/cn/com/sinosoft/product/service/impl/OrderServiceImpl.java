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
import cn.com.sinosoft.domain.sell.GeOrder;
import cn.com.sinosoft.domain.sell.GePolicy;
import cn.com.sinosoft.domain.system.GeDepartment;
import cn.com.sinosoft.product.service.DepartmentService;
import cn.com.sinosoft.product.service.OrderService;

@Component
public class OrderServiceImpl extends GenericHibernateDao<GeOrder, String> implements OrderService {

	@Autowired
	private DepartmentService ds;
	
	public Page<GeOrder> getOrder(Set<GeDepartment> departments,GeOrder geOrder, int page, int rows) {
		boolean flag = true;
		List<Object> gdList = new ArrayList<Object>();
		for (GeDepartment department : departments) {
			Object deptid = department.getDeptid();
				gdList.add(deptid);
		}
		QueryRule queryRule = QueryRule.getInstance();
		if(geOrder!=null){
			if(!StringUtils.isEmpty(geOrder.getOrdercode())){
				queryRule.addLike("ordercode", "%"+geOrder.getOrdercode()+"%");
			}
			if(!StringUtils.isEmpty(geOrder.getStatus())){
				queryRule.addEqual("status", geOrder.getStatus());
			}
			if(!StringUtils.isEmpty(geOrder.getPaystatus())){
				queryRule.addEqual("paystatus", geOrder.getPaystatus());
			}
			if(!StringUtils.isEmpty(geOrder.getApplicantname())){
				queryRule.addLike("applicantname", "%"+geOrder.getApplicantname()+"%");
			}
			if(!StringUtils.isEmpty(geOrder.getProductname())){
				queryRule.addEqual("productname", geOrder.getProductname());
			}
			if(!StringUtils.isEmpty(geOrder.getDeptid())){
				for (Object object : gdList) {
					if (geOrder.getDeptid().equals((String)object)) {
						flag = false;
					}
				}
				if(!flag){
					queryRule.addEqual("deptid", geOrder.getDeptid());
				}
			}
			if(geOrder.getStarttime()!=null){
				queryRule.addGreaterEqual("submittime",geOrder.getStarttime());
			}
			if(geOrder.getEndtime()!=null){
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(geOrder.getEndtime());
				calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
				queryRule.addLessEqual("submittime",calendar.getTime());
			}
		}
		if (flag) {
			queryRule.addIn("deptid", gdList);
		}
		queryRule.addDescOrder("submittime");
		Page<GeOrder> find = super.find(queryRule, page, rows);
		for(GeOrder GeOrder: (List<GeOrder>)find.getData()){
			String detpid = GeOrder.getDeptid()==null?"":GeOrder.getDeptid();
	    	GeDepartment department = ds.getDepartmentByDetpid(detpid);
	    	String deptname = department==null?"":department.getDeptname();
	    	GeOrder.setDeptid(deptname);
		}
		return find;
	}
	public Page<GeOrder> getCharityOrder(GeOrder geOrder, int page, int rows) {
		QueryRule queryRule = QueryRule.getInstance();
		if(geOrder!=null){
			if(!StringUtils.isEmpty(geOrder.getOrdercode())){
				queryRule.addLike("ordercode", "%"+geOrder.getOrdercode()+"%");
			}
			if(!StringUtils.isEmpty(geOrder.getStatus())){
				queryRule.addEqual("status", geOrder.getStatus());
			}
			if(!StringUtils.isEmpty(geOrder.getPaystatus())){
				queryRule.addEqual("paystatus", geOrder.getPaystatus());
			}
			if(!StringUtils.isEmpty(geOrder.getRecipientname())){
				queryRule.addLike("applicantname", "%"+geOrder.getRecipientname()+"%");
			}
			if(!StringUtils.isEmpty(geOrder.getProductname())){
				queryRule.addEqual("productname", geOrder.getProductname());
			}
			if(geOrder.getStarttime()!=null){
				queryRule.addGreaterEqual("submittime",geOrder.getStarttime());
			}
			if(geOrder.getEndtime()!=null){
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(geOrder.getEndtime());
				calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
				queryRule.addLessEqual("submittime",calendar.getTime());
			}
		}
		queryRule.addEqual("charityflag", "0"); //赠险标识
		queryRule.addDescOrder("submittime");
		return this.find(queryRule, page, rows);
	}

	public GeOrder getOrderByOrderno(String orderno) {
		return super.get(orderno);
	}

	public List<GeOrder> getAllOrder(String ordercode,String paystatus,String applicantname,String productname,String starttime,String endtime,String status,String deptid,Set<GeDepartment> departments){
		boolean flag = true;
		List<Object> gdList = new ArrayList<Object>();
		for (GeDepartment department : departments) {
				gdList.add(department.getDeptid());
		}
		QueryRule queryRule = QueryRule.getInstance();
		if(!StringUtils.isEmpty(ordercode)){
			queryRule.addLike("ordercode", "%"+ordercode+"%");
		}
		if(!StringUtils.isEmpty(paystatus)){
			queryRule.addEqual("paystatus", paystatus);
		}
		if(!StringUtils.isEmpty(status)){
			queryRule.addEqual("status", status);
		}
		if(!StringUtils.isEmpty(applicantname)){
			queryRule.addLike("applicantname", "%"+applicantname+"%");
		}
		if(!StringUtils.isEmpty(productname)){
			queryRule.addEqual("productname", productname);
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
				    queryRule.addGreaterEqual("submittime",date);
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
				    queryRule.addLessEqual("submittime",calendar.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (flag) {
			queryRule.addIn("deptid", gdList);
		}
		queryRule.addDescOrder("submittime");
		List<GeOrder> find = super.find(queryRule);
		for (GeOrder geOrder : find) {
			String detpid = geOrder.getDeptid()==null?"":geOrder.getDeptid();
	    	GeDepartment department = ds.getDepartmentByDetpid(detpid);
	    	String deptname = department==null?"":department.getDeptname();
	    	geOrder.setDeptid(deptname);
		}
	return find;
	}
	public List<GeOrder> getAllCharityOrder(String ordercode,String paystatus,String applicantname,String productname,String starttime,String endtime,String status){
		QueryRule queryRule = QueryRule.getInstance();
		if(!StringUtils.isEmpty(ordercode)){
			queryRule.addLike("ordercode", "%"+ordercode+"%");
		}
		if(!StringUtils.isEmpty(paystatus)){
			queryRule.addEqual("paystatus", paystatus);
		}
		if(!StringUtils.isEmpty(status)){
			queryRule.addEqual("status", status);
		}
		if(!StringUtils.isEmpty(applicantname)){
			queryRule.addLike("applicantname", "%"+applicantname+"%");
		}
		if(!StringUtils.isEmpty(productname)){
			queryRule.addEqual("productname", productname);
		}
		if(!StringUtils.isEmpty(starttime)){
			try {
				DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");            
				Date date = fmt.parse(starttime);
				queryRule.addGreaterEqual("submittime",date);
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
				queryRule.addLessEqual("submittime",calendar.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		queryRule.addEqual("charityflag", "0"); //赠险标识
		queryRule.addDescOrder("submittime");
		return super.find(queryRule);
	}
	public GeOrder getOrderByOrderCode(String ordercode) {
		QueryRule queryRule = QueryRule.getInstance();
		if(!StringUtils.isEmpty(ordercode)){
			queryRule.addEqual("ordercode", ordercode);
		}
		return super.findUnique(queryRule);
	}
	@Override
	public Page<GeOrder> getOrder(GeOrder geOrder, int page, int rows) {
		QueryRule queryRule = QueryRule.getInstance();
		if(geOrder!=null){
			if(!StringUtils.isEmpty(geOrder.getOrdercode())){
				queryRule.addLike("ordercode", "%"+geOrder.getOrdercode()+"%");
			}
			if(!StringUtils.isEmpty(geOrder.getStatus())){
				queryRule.addEqual("status", geOrder.getStatus());
			}
			if(!StringUtils.isEmpty(geOrder.getPaystatus())){
				queryRule.addEqual("paystatus", geOrder.getPaystatus());
			}
			if(!StringUtils.isEmpty(geOrder.getApplicantname())){
				queryRule.addLike("applicantname", "%"+geOrder.getApplicantname()+"%");
			}
			if(!StringUtils.isEmpty(geOrder.getProductname())){
				queryRule.addEqual("productname", geOrder.getProductname());
			}
			if(!StringUtils.isEmpty(geOrder.getDeptid())){
				queryRule.addEqual("deptid", geOrder.getDeptid());
			}
			if(geOrder.getStarttime()!=null){
				queryRule.addGreaterEqual("submittime",geOrder.getStarttime());
			}
			if(geOrder.getEndtime()!=null){
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(geOrder.getEndtime());
				calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
				queryRule.addLessEqual("submittime",calendar.getTime());
			}
		}
		queryRule.addDescOrder("submittime");
		Page<GeOrder> find = super.find(queryRule, page, rows);
		for(GeOrder GeOrder: (List<GeOrder>)find.getData()){
			String detpid = GeOrder.getDeptid()==null?"":GeOrder.getDeptid();
	    	GeDepartment department = ds.getDepartmentByDetpid(detpid);
	    	String deptname = department==null?"":department.getDeptname();
	    	GeOrder.setDeptid(deptname);
		}
		return find;
	}
	@Override
	public List<GeOrder> getAllOrder(String ordercode, String paystatus,String applicantname, String productname, String starttime,String endtime, String status, String deptid) {
		QueryRule queryRule = QueryRule.getInstance();
		if(!StringUtils.isEmpty(ordercode)){
			queryRule.addLike("ordercode", "%"+ordercode+"%");
		}
		if(!StringUtils.isEmpty(paystatus)){
			queryRule.addEqual("paystatus", paystatus);
		}
		if(!StringUtils.isEmpty(status)){
			queryRule.addEqual("status", status);
		}
		if(!StringUtils.isEmpty(applicantname)){
			queryRule.addLike("applicantname", "%"+applicantname+"%");
		}
		if(!StringUtils.isEmpty(productname)){
			queryRule.addEqual("productname", productname);
		}
		if(!StringUtils.isEmpty(deptid)){
				queryRule.addEqual("deptid", deptid);
		}
		if(!StringUtils.isEmpty(starttime)){
			  try {
				DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");            
				    Date date = fmt.parse(starttime);
				    queryRule.addGreaterEqual("submittime",date);
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
				    queryRule.addLessEqual("submittime",calendar.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		queryRule.addDescOrder("submittime");
		List<GeOrder> find = super.find(queryRule);
		for (GeOrder geOrder : find) {
			String detpid = geOrder.getDeptid()==null?"":geOrder.getDeptid();
	    	GeDepartment department = ds.getDepartmentByDetpid(detpid);
	    	String deptname = department==null?"":department.getDeptname();
	    	geOrder.setDeptid(deptname);
		}
	return find;
	}

}
