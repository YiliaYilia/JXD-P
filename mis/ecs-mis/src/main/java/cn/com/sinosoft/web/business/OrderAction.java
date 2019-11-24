package cn.com.sinosoft.web.business;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Alignment;
import jxl.write.Border;
import jxl.write.BorderLineStyle;
import jxl.write.Label;
import jxl.write.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.sf.json.JsonConfig;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.utils.DateAndTime;
import cn.com.sinosoft.core.utils.JsonDateValueProcessor;
import cn.com.sinosoft.core.utils.JsonUtils;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.sell.GeOrder;
import cn.com.sinosoft.domain.sell.GePolicy;
import cn.com.sinosoft.domain.system.GeDepartment;
import cn.com.sinosoft.domain.system.GeUser;
import cn.com.sinosoft.dto.sell.OrderDto.OrderRow;
import cn.com.sinosoft.dto.sell.OrderDto;
import cn.com.sinosoft.dto.sell.PolicyDto;
import cn.com.sinosoft.dto.sell.PolicyDto.PolicyRow;
import cn.com.sinosoft.dto.system.ECSUser;
import cn.com.sinosoft.product.service.DepartmentService;
import cn.com.sinosoft.product.service.OrderService;
import cn.com.sinosoft.product.service.PolicyService;
import cn.com.sinosoft.user.service.UserService;

public class OrderAction extends Struts2Action{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private OrderService os;
	@Autowired
	private PolicyService ps;
	@Autowired
	private DepartmentService ds;
	@Autowired
	private UserService us;
	
	private GeOrder geOrder;
	
	private String orderno;
	
	private String policyStatus="";
	private String agentCode="";
	private String preferentialCode="";

	@Action(value="orderList")
	public String jumpOrderListPage(){
		ECSUser user = (ECSUser)this.getHttpSession().getAttribute("user");
		String usertype = user.getGeUser().getUsertype();
		List<GeDepartment> departmentList = null ;
		if(usertype.equals("admin")){
			departmentList = ds.getAllDepartment();
			this.setRequestAttribute("departmentList", departmentList);
		}else{
			GeUser geUser = us.getGeUserById(user.getGeUser().getUserid());
			Set<GeDepartment> departments = geUser.getGeDepartments();
			this.setRequestAttribute("departmentList", departments);
		}
		return "/page/orderList";
	}
	@Action(value="charityOrderList")
	public String charityOrderListPage(){
		return "/page/charityOrderList";
	}
	
	/**
	 * 订单列表
	 */
	@Action(value="findOrderData")
	public void findAllOrder(){
		String userid = super.getHttpServletRequest().getParameter("userid");
		GeUser geUser = us.getGeUserById(userid);
		Page<GeOrder> orderPage = null ;
		if(geUser.getUsertype().equals("admin")){
			orderPage = os.getOrder(geOrder, page, rows);
		}else{
			Set<GeDepartment> departments = geUser.getGeDepartments();
//			List<GeDepartment> departmentList = ds.getAllDepartment();
//			if(departments.size()!=departmentList.size()){
//			   for (Iterator<GeDepartment> iterator = departments.iterator(); iterator.hasNext();) {
//					GeDepartment geDepartment = (GeDepartment) iterator.next();
//					if(geDepartment.getDeptid().equals("RES_DEPT")){
//					   iterator.remove();
//					}
//				}
//			}
			if(departments.size()==0){
			}else{
				orderPage = os.getOrder(departments,geOrder, page, rows);
			}
		}
		List<OrderRow>  listRows = new ArrayList<OrderRow>();
		OrderDto orderData = new OrderDto(); 
		for(GeOrder data: (List<GeOrder>)orderPage.getData()){
			Set<GePolicy> policys = data.getPolicys();
			for(GePolicy data1: policys){
				policyStatus=data1.getStatus()==null?"":data1.getStatus();
				agentCode = data1.getAgentcode()==null?"":data1.getAgentcode();
				preferentialCode = data1.getPreferentialcode()==null?"":data1.getPreferentialcode();
			}
			OrderRow row = new OrderRow();
			BeanUtils.copyProperties(data, row);
			row.setPolicyStatus(policyStatus);
			row.setAgentCode(agentCode);
			row.setPreferentialCode(preferentialCode);
			listRows.add(row);
		}
		orderData.setTotal(orderPage.getTotal() + "");
		orderData.setRows(listRows);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss")); 
		renderJson(JsonUtils.convertObject(orderData,jsonConfig));
	}
	
	@Action(value="findCharityOrderData")
	public void findCharityOrderData(){
		Page<GeOrder> orderPage = os.getCharityOrder(geOrder, page, rows);
		List<OrderRow>  listRows = new ArrayList<OrderRow>();
		OrderDto orderData = new OrderDto(); 
		for(GeOrder data: (List<GeOrder>)orderPage.getData()){
			OrderRow row = new OrderRow();
			BeanUtils.copyProperties(data, row);
			listRows.add(row);
		}
		orderData.setTotal(orderPage.getTotal() + "");
		orderData.setRows(listRows);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss")); 
		renderJson(JsonUtils.convertObject(orderData,jsonConfig));
	}
	/**
	 * 订单导出
	 * @throws UnsupportedEncodingException 
	 * 
	 */
	 @Action(value="expOrder")
	 public boolean expOrder() throws UnsupportedEncodingException{
		    String userid = super.getHttpServletRequest().getParameter("userid");
			GeUser geUser = us.getGeUserById(userid);
			String ordercode = super.getHttpServletRequest().getParameter("ordercode");
			String paystatus = super.getHttpServletRequest().getParameter("paystatus");
			String productname = super.getHttpServletRequest().getParameter("productname")==null?"":new String(super.getHttpServletRequest().getParameter("productname").getBytes("ISO-8859-1"),"gbk");
			String applicantname = super.getHttpServletRequest().getParameter("recipientname")==null?"":new String(super.getHttpServletRequest().getParameter("recipientname").getBytes("ISO-8859-1"),"gbk");
			String starttime = super.getHttpServletRequest().getParameter("starttime");
			String endtime = super.getHttpServletRequest().getParameter("endtime");
			String status = super.getHttpServletRequest().getParameter("accoutnstatus");
			String deptid = super.getHttpServletRequest().getParameter("deptid");
			 List<GeOrder> order = null ;
			if(geUser.getUsertype().equals("admin")){
				order = os.getAllOrder(ordercode,paystatus,applicantname,productname,starttime,endtime,status,deptid);
			}else{
				Set<GeDepartment> departments = geUser.getGeDepartments();
//				List<GeDepartment> departmentList = ds.getAllDepartment();
//				if(departments.size()!=departmentList.size()){
//				   for (Iterator<GeDepartment> iterator = departments.iterator(); iterator.hasNext();) {
//						GeDepartment geDepartment = (GeDepartment) iterator.next();
//						if(geDepartment.getDeptid().equals("RES_DEPT")){
//						   iterator.remove();
//						}
//					}
//				}
				if(departments.size()==0){
				}else{
					order = os.getAllOrder(ordercode,paystatus,applicantname,productname,starttime,endtime,status,deptid,departments);
				}
	       }
		 HttpServletResponse response;
		 try {
				response = getHttpServletResponse();
				response.setContentType("application/octet-stream;charset=utf-8");
				response.setContentType("application/msexcel");
				String  filename = "orderlist" + DateAndTime.getCurrentDateTime("yyyyMMdd") + ".xls";
				response.addHeader("Content-Disposition","attachment;filename=" + new String(filename.getBytes("utf-8"), "iso-8859-1")); 
				OutputStream os = response.getOutputStream();
				OrderAction eorder = new OrderAction();
				boolean flag =  eorder.report(os, order);
			
//				os.close();
//				out.clear();
//				out = pageContext.pushBody();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 return true;
	 }
	 
	 
	 
	 @Action(value="expCharityOrder")
	 public boolean expCharityOrder() throws UnsupportedEncodingException{
		 String ordercode = super.getHttpServletRequest().getParameter("ordercode");
		 String paystatus = super.getHttpServletRequest().getParameter("paystatus");
		 String productname = super.getHttpServletRequest().getParameter("productname")==null?"":new String(super.getHttpServletRequest().getParameter("productname").getBytes("ISO-8859-1"),"gbk");
		 String applicantname = super.getHttpServletRequest().getParameter("recipientname")==null?"":new String(super.getHttpServletRequest().getParameter("recipientname").getBytes("ISO-8859-1"),"gbk");
		 String starttime = super.getHttpServletRequest().getParameter("starttime");
		 String endtime = super.getHttpServletRequest().getParameter("endtime");
		 String status = super.getHttpServletRequest().getParameter("accoutnstatus");
		 List<GeOrder> order = os.getAllCharityOrder(ordercode,paystatus,applicantname,productname,starttime,endtime,status);
		 HttpServletResponse response;
		 try {
			 response = getHttpServletResponse();
			 response.setContentType("application/octet-stream;charset=utf-8");
			 response.setContentType("application/msexcel");
			 String  filename = "orderlist" + DateAndTime.getCurrentDateTime("yyyyMMdd") + ".xls";
			 response.addHeader("Content-Disposition","attachment;filename=" + new String(filename.getBytes("utf-8"), "iso-8859-1")); 
			 OutputStream os = response.getOutputStream();
			 OrderAction eorder = new OrderAction();
			 boolean flag =  eorder.report(os, order);
			 
//				os.close();
//				out.clear();
//				out = pageContext.pushBody();
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 return true;
	 }
	 
	 
	 
		public boolean report(OutputStream os, List<GeOrder> order) {
			WritableWorkbook wwb = null;
				try {
					wwb = Workbook.createWorkbook(os);
					WritableFont headColor = new WritableFont(WritableFont.ARIAL, 10,WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,Colour.BLACK);//设置字体的颜色格式大小
					WritableFont headFont = new WritableFont(headColor);//使用上面定义的字体格式
					WritableCellFormat headFormat = new WritableCellFormat(headFont);//设置单元格格式
					headFormat.setBorder(Border.ALL, BorderLineStyle.THIN);// 设置线条线框的格式;
					headFormat.setVerticalAlignment(VerticalAlignment.CENTRE);// 设置垂直对齐
					headFormat.setAlignment(Alignment.CENTRE);// 设置水平对齐方式
					WritableFont normalFont = new WritableFont(WritableFont.createFont("宋体"), 10);
					WritableCellFormat normalFormat = new WritableCellFormat(normalFont);
					normalFormat.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
					normalFormat.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
					normalFormat.setAlignment(Alignment.LEFT);// 水平对齐
					normalFormat.setWrap(true);// 是否换行
					// 创建Excel工作表:用户
					WritableSheet ws = wwb.createSheet("订单表", 0);
					ws.addCell(new Label(0, 0, "订单号", headFormat));
					ws.setColumnView(0, 13);
					ws.addCell(new Label(1, 0, "产品名称", headFormat));
					ws.setColumnView(1, 14);
					ws.addCell(new Label(2, 0, "投保人姓名", headFormat));
					ws.setColumnView(2, 24);
					ws.addCell(new Label(3, 0, "被保人姓名", headFormat));
					ws.setColumnView(3, 24);
					ws.addCell(new Label(4, 0, "保单号 ", headFormat));
					ws.setColumnView(4, 24);
					ws.addCell(new Label(5, 0, "保单状态", headFormat));
					ws.setColumnView(5, 24);
					ws.addCell(new Label(6, 0, "对账状态", headFormat));
					ws.setColumnView(6, 24);
					ws.addCell(new Label(7, 0, "投保时间", headFormat));
					ws.setColumnView(7, 24);
					ws.addCell(new Label(8, 0, "微信订单编号", headFormat));
					ws.setColumnView(8, 24);
					ws.addCell(new Label(9, 0, "产品编号", headFormat));
					ws.setColumnView(9, 24);
					ws.addCell(new Label(10, 0, "订单金额", headFormat));
					ws.setColumnView(10, 24);
					ws.addCell(new Label(11, 0, "保单状态", headFormat));
					ws.setColumnView(11, 24);
					ws.addCell(new Label(12, 0, "推荐码", headFormat));
					ws.setColumnView(12, 24);
					ws.addCell(new Label(13, 0, "活动码", headFormat));
					ws.setColumnView(13, 24);
					ws.addCell(new Label(14, 0, "组织机构", headFormat));
					ws.setColumnView(14, 24);
					DateFormat format2= new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒"); 
					int i=0;
					for(GeOrder geOrder : order){
						Set<GePolicy> policys = geOrder.getPolicys();
						for(GePolicy data1: policys){
							policyStatus=data1.getStatus();
							agentCode = data1.getAgentcode();
							preferentialCode = data1.getPreferentialcode();
						}
						ws.addCell(new Label(0, i+1, geOrder.getOrdercode()==null?"":geOrder.getOrdercode(), normalFormat));//订单号
						ws.addCell(new Label(1, i+1,geOrder.getProductname()==null?"":geOrder.getProductname() , normalFormat));//产品名称
						ws.addCell(new Label(2, i+1,geOrder.getApplicantname()==null?"":geOrder.getApplicantname(), normalFormat));//投保人姓名
						ws.addCell(new Label(3, i+1,geOrder.getRecipientname()==null?"":geOrder.getRecipientname(), normalFormat));//被保人姓名
						ws.addCell(new Label(4, i+1,geOrder.getPolicyno()==null?"":geOrder.getPolicyno() , normalFormat));//保单号
						ws.addCell(new Label(5, i+1,geOrder.getPaystatus()==null?"":checkType(geOrder.getPaystatus(),"PAY") , normalFormat));//保单状态
						ws.addCell(new Label(6, i+1,geOrder.getStatus()==null?"":checkType(geOrder.getStatus(),"STA") , normalFormat));//对账状态
						ws.addCell(new Label(7, i+1,geOrder.getSubmittime()==null?"":format2.format(geOrder.getSubmittime()) , normalFormat));//投保时间
						ws.addCell(new Label(8, i+1,geOrder.getGatewayrno()==null?"":geOrder.getGatewayrno() , normalFormat));//wexin订单号
						ws.addCell(new Label(9, i+1,geOrder.getCoreproductcode()==null?"":geOrder.getCoreproductcode(), normalFormat));//产品编号
						ws.addCell(new Label(10, i+1,geOrder.getOrderamount()==null?"":geOrder.getOrderamount().toString(), normalFormat));//订单金额
						ws.addCell(new Label(11, i+1,policyStatus==null?"":checkType(policyStatus,"PLICYSTATUS"), normalFormat));//保单状态
						ws.addCell(new Label(12, i+1,agentCode==null?"":agentCode, normalFormat));//推荐码
						ws.addCell(new Label(13, i+1,preferentialCode==null?"":preferentialCode, normalFormat));//活动码
						ws.addCell(new Label(14, i+1,geOrder.getDeptid()==null?"":geOrder.getDeptid(), normalFormat));//活动码
						i++;
					}
					wwb.write();
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				} finally{
					try {
						if(wwb != null){
							wwb.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		}
	 
	 
	 
	 
	 
	 
	 
	/**
	 * 订单详情
	 * @return
	 */
	@Action(value="orderInfo")
	public String orderDetail(){
		geOrder = os.getOrderByOrderno(orderno);
		this.setRequestAttribute("order", geOrder);
		return "/page/orderInfo";
	}
	
	/**
	 * 订单下保单列表
	 * @return
	 */
	@Action(value="getPolicyDataForOrder")
	public void getPolicyDataForOrder(){
		geOrder = os.getOrderByOrderno(orderno);
		
		Set<GePolicy> policy = geOrder.getPolicys();
		
		List<PolicyRow>  listRows = new ArrayList<PolicyRow>();
		PolicyDto policyData = new PolicyDto(); 
		for(GePolicy data: policy){
			PolicyRow row = new PolicyRow();
			BeanUtils.copyProperties(data, row);
			listRows.add(row);
		}
		policyData.setTotal(10 + "");
		policyData.setRows(listRows);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss")); 
		renderJson(JsonUtils.convertObject(policyData,jsonConfig));
	}
	
	public GeOrder getGeOrder() {
		return geOrder;
	}

	public void setGeOrder(GeOrder geOrder) {
		this.geOrder = geOrder;
	}

	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	
	
	public String checkType(String type,String flag){
		String result ="";
		if(flag=="PAY"){
			if(type.equals("0")){
				result="未支付";
			}
			if(type.equals("1")){
				result="支付成功";
			}
			if(type.equals("2")){
				result="未支付的已撤单";
			}
			if(type.equals("3")){
				result="支付中";
			}
			if(type.equals("4")){
				result="交易可疑";
			}
			if(type.equals("5")){
				result="支付失败";
			}
			if(type.equals("6")){
				result="支付成功且退款成功的已撤单";
			}
			if(type.equals("7")){
				result="退款中";
			}
			if(type.equals("8")){
				result="订单完成";
			}
		}
		if(flag=="STA"){
			if(type.equals("0")){
				result="未对账";
			}
			if(type.equals("1")){
				result="对账成功";
			}
			if(type.equals("2")){
				result="对账失败";
			}
			if(type.equals("3")){
				result="本地成功，支付接口失败";
			}
		}
		if(flag=="PLICYSTATUS"){
			if(type.equals("1")){
				result="核保成功";
			}
			if(type.equals("2")){
				result="核保失败";
			}
			if(type.equals("3")){
				result="承保成功";
			}
			if(type.equals("4")){
				result="承保失败";
			}
		}
		
		
		return result;
	}
}