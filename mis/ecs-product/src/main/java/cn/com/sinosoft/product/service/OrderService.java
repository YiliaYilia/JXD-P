package cn.com.sinosoft.product.service;

import java.util.List;
import java.util.Set;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.sell.GeOrder;
import cn.com.sinosoft.domain.system.GeDepartment;

public interface OrderService {

	public Page<GeOrder> getOrder(Set<GeDepartment> departments,GeOrder geOrder,int page,int rows);
	
	public Page<GeOrder> getOrder(GeOrder geOrder,int page,int rows);
	
	public Page<GeOrder> getCharityOrder(GeOrder geOrder,int page,int rows);
	
	public GeOrder getOrderByOrderno(String orderno);
	
	public GeOrder getOrderByOrderCode(String ordercode);
	
	public List<GeOrder> getAllOrder(String ordercode,String paystatus,String applicantname,String productname,String starttime,String endtime,String status,String deptid,Set<GeDepartment> departments);
	
	public List<GeOrder> getAllOrder(String ordercode,String paystatus,String applicantname,String productname,String starttime,String endtime,String status,String deptid);
	
	public List<GeOrder> getAllCharityOrder(String ordercode,String paystatus,String applicantname,String productname,String starttime,String endtime,String status);
}
