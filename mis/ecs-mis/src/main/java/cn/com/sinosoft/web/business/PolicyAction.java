package cn.com.sinosoft.web.business;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.hibernate.Session;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.utils.DateAndTime;
import cn.com.sinosoft.core.utils.JsonDateValueProcessor;
import cn.com.sinosoft.core.utils.JsonUtils;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.product.GeProductMain;
import cn.com.sinosoft.domain.product.GeRisk;
import cn.com.sinosoft.domain.sell.GeApplicantinsured;
import cn.com.sinosoft.domain.sell.GeBeneficiary;
import cn.com.sinosoft.domain.sell.GePolicy;
import cn.com.sinosoft.domain.system.GeDepartment;
import cn.com.sinosoft.domain.system.GeUser;
import cn.com.sinosoft.dto.product.ProductMainDto;
import cn.com.sinosoft.dto.product.RiskData;
import cn.com.sinosoft.dto.product.RiskData.RiskDataRow;
import cn.com.sinosoft.dto.sell.PolicyDto;
import cn.com.sinosoft.dto.sell.PolicyDto.PolicyRow;
import cn.com.sinosoft.dto.system.ECSUser;
import cn.com.sinosoft.product.service.DepartmentService;
import cn.com.sinosoft.product.service.PolicyService;
import cn.com.sinosoft.user.service.UserService;

/**描述：<br>
 * 作者：zlc <br>
 * 修改日期：2014-3-15下午3:41:55 <br>
 */
@SuppressWarnings("serial")
public class PolicyAction extends Struts2Action{
	DateFormat format2= new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒"); 
	private static final Logger logger = Logger.getLogger(PolicyAction.class);
	
	@Autowired
	private PolicyService ps;
	
	@Autowired
	private DepartmentService ds;
	
	@Autowired
	private UserService us;
	
	private GePolicy gePolicy;
	
	private String policyno;

	private String insuretimebegin;
	
	private String insuretimeend;
	

	@Action(value="policyList")
	public String jumpPolicyListPage(){
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
		return "/page/policyList";
	}
	
	@Action(value="findPolicyData")
	public void findAllPolicy(){
		String userid = super.getHttpServletRequest().getParameter("userid");
		GeUser geUser = us.getGeUserById(userid);
		Page<GePolicy> policyPage = null ;
		if(geUser.getUsertype().equals("admin")){
			policyPage = ps.getPolicy(gePolicy, page, rows);
		}else{
		    Set<GeDepartment> departments = geUser.getGeDepartments();
//		    List<GeDepartment> departmentList = ds.getAllDepartment();
//		    if(departments.size()!=departmentList.size()){
//			   for(Iterator<GeDepartment> iterator = departments.iterator(); iterator.hasNext();) {
//				   GeDepartment geDepartment = (GeDepartment) iterator.next();
//				   if(geDepartment.getDeptid().equals("RES_DEPT")){
//					  iterator.remove();
//					 }
//				  }
//		      }
		    if(departments.size()==0){
		    }else{
		         policyPage = ps.getPolicy(departments,gePolicy, page, rows);
		    }
		}
		List<PolicyRow>  listRows = new ArrayList<PolicyRow>();
		PolicyDto policyData = new PolicyDto(); 
		for(GePolicy data: (List<GePolicy>)policyPage.getData()){
			PolicyRow row = new PolicyRow();
			BeanUtils.copyProperties(data, row);
			listRows.add(row);
		}
		policyData.setTotal(policyPage.getTotal() + "");
		policyData.setRows(listRows);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss")); 
		renderJson(JsonUtils.convertObject(policyData,jsonConfig));
	}
	
	
	@Action(value="expPolicy")
	 public boolean expPolicy() throws UnsupportedEncodingException{
		String userid = super.getHttpServletRequest().getParameter("userid");
		GeUser geUser = us.getGeUserById(userid);
		String policycode = super.getHttpServletRequest().getParameter("policycode");
		String productname = super.getHttpServletRequest().getParameter("productname")==null?"":new String(super.getHttpServletRequest().getParameter("productname").getBytes("ISO-8859-1"),"gbk");
		String applicantname = super.getHttpServletRequest().getParameter("applicantname")==null?"":new String(super.getHttpServletRequest().getParameter("applicantname").getBytes("ISO-8859-1"),"gbk");
		logger.info("产品名称:"+productname);
		String status = super.getHttpServletRequest().getParameter("status");
		String starttime = super.getHttpServletRequest().getParameter("starttime");
		String endtime = super.getHttpServletRequest().getParameter("endtime");
		String agentcode = super.getHttpServletRequest().getParameter("agentcode");
		String brno = super.getHttpServletRequest().getParameter("brno");
		String deptid = super.getHttpServletRequest().getParameter("deptid");
		List<GePolicy> policys = null;
		if(geUser.getUsertype().equals("admin")){
			policys = ps.getAllPolicy(policycode,productname,applicantname,status,starttime,endtime,agentcode,brno,deptid);
		}else{
			Set<GeDepartment> departments = geUser.getGeDepartments();
//			List<GeDepartment> departmentList = ds.getAllDepartment();
//			if(departments.size()!=departmentList.size()){
//			   for (Iterator<GeDepartment> iterator = departments.iterator(); iterator.hasNext();) {
//				    GeDepartment geDepartment = (GeDepartment) iterator.next();
//				    if(geDepartment.getDeptid().equals("RES_DEPT")){
//					   iterator.remove();
//					}
//				}
//			}
			 if(departments.size()==0){
			    }else{
			    	policys = ps.getAllPolicy(policycode,productname,applicantname,status,starttime,endtime,agentcode,brno,deptid,departments);
			    }
		}
	//	super.getHttpServletRequest();
		HttpServletResponse response;
		 try {
				response = getHttpServletResponse();
				response.setContentType("application/octet-stream;charset=utf-8");
				response.setContentType("application/msexcel");
				String  filename = "policylist" + DateAndTime.getCurrentDateTime("yyyyMMdd") + ".xls";
				response.addHeader("Content-Disposition","attachment;filename=" + new String(filename.getBytes("utf-8"), "iso-8859-1")); 
				OutputStream os = response.getOutputStream();
				PolicyAction epolicy = new PolicyAction();
				boolean flag =  epolicy.report(os, policys);
			
//				os.close();
//				out.clear();
//				out = pageContext.pushBody();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 return true;
	 }
		
		
	public boolean report(OutputStream os, List<GePolicy> policys) {
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
				WritableSheet ws = wwb.createSheet("保单表", 0);
				ws.addCell(new Label(0, 0, "保单号", headFormat));
				ws.setColumnView(0, 13);
				ws.addCell(new Label(1, 0, "产品名称", headFormat));
				ws.setColumnView(1, 14);
				ws.addCell(new Label(2, 0, "投保日期", headFormat));
				ws.setColumnView(2, 24);
				ws.addCell(new Label(3, 0, "投保人 ", headFormat));
				ws.setColumnView(3, 24);
				ws.addCell(new Label(4, 0, "被保人", headFormat));
				ws.setColumnView(4, 24);
				ws.addCell(new Label(5, 0, "生效日期", headFormat));
				ws.setColumnView(5, 24);
				ws.addCell(new Label(6, 0, "截止日期", headFormat));
				ws.setColumnView(6, 24);
				ws.addCell(new Label(7, 0, "保费", headFormat));
				ws.setColumnView(7, 24);
				ws.addCell(new Label(8, 0, "总保额", headFormat));
				ws.setColumnView(8, 24);
				ws.addCell(new Label(9, 0, "状态", headFormat));
				ws.setColumnView(9, 24);
				ws.addCell(new Label(10, 0, "活动码", headFormat));
				ws.setColumnView(10, 24);
				ws.addCell(new Label(11, 0, "推荐码", headFormat));
				ws.setColumnView(11, 24);
				ws.addCell(new Label(12, 0, "渠道编码", headFormat));
				ws.setColumnView(12, 24);
				ws.addCell(new Label(13, 0, "投保人证件类型", headFormat));
				ws.setColumnView(13, 24);
				ws.addCell(new Label(14, 0, "投保人证件号", headFormat));
				ws.setColumnView(14, 24);
				ws.addCell(new Label(15, 0, "投保人手机号", headFormat));
				ws.setColumnView(15, 24);
				ws.addCell(new Label(16, 0, "投保人邮箱", headFormat));
				ws.setColumnView(16, 24);
				ws.addCell(new Label(17, 0, "投保人地址", headFormat));
				ws.setColumnView(17, 24);
				ws.addCell(new Label(18, 0, "被保人证件类型", headFormat));
				ws.setColumnView(18, 24);
				ws.addCell(new Label(19, 0, "被保人证件号", headFormat));
				ws.setColumnView(19, 24);
				ws.addCell(new Label(20, 0, "被保人手机号", headFormat));
				ws.setColumnView(20, 24);
				ws.addCell(new Label(21, 0, "被保人邮箱", headFormat));
				ws.setColumnView(21, 24);
				ws.addCell(new Label(22, 0, "被保人地址", headFormat));
				ws.setColumnView(22, 24);
				ws.addCell(new Label(23, 0, "组织机构", headFormat));
				ws.setColumnView(23, 24);
				int i=0;
				for(GePolicy gePolicy : policys){
					Iterator<GeApplicantinsured> geApplicantinsured = gePolicy.getApplicantinsureds().iterator();
					ws.addCell(new Label(0, i+1, gePolicy.getPolicycode()==null?"":gePolicy.getPolicycode(), normalFormat));
					ws.addCell(new Label(1, i+1,gePolicy.getProductname()==null?"":gePolicy.getProductname(), normalFormat));
					ws.addCell(new Label(2, i+1,gePolicy.getInsuretime()==null?"":formatDate(gePolicy.getInsuretime()), normalFormat));
					ws.addCell(new Label(3, i+1,gePolicy.getApplicantname()==null?"":gePolicy.getApplicantname(), normalFormat));
					ws.addCell(new Label(4, i+1,gePolicy.getInsuredname()==null?"":gePolicy.getInsuredname(), normalFormat));
					ws.addCell(new Label(5, i+1,gePolicy.getTakeeffecttime()==null?"":gePolicy.getTakeeffecttime().toString(), normalFormat));
					ws.addCell(new Label(6, i+1,gePolicy.getDeadlinetime()==null?"":gePolicy.getDeadlinetime().toString() , normalFormat));
					ws.addCell(new Label(7, i+1,gePolicy.getSumbasepremium()==null?"":gePolicy.getSumbasepremium().toString() , normalFormat));
					ws.addCell(new Label(8, i+1,gePolicy.getSumamount()==null?"":gePolicy.getSumamount().toString(), normalFormat));
					ws.addCell(new Label(9, i+1,gePolicy.getStatus()==null?"":checkType(gePolicy.getStatus()), normalFormat));
					ws.addCell(new Label(10,i+1,gePolicy.getPreferentialcode()==null?"":gePolicy.getPreferentialcode(), normalFormat));
					ws.addCell(new Label(11,i+1,gePolicy.getAgentcode()==null?"":gePolicy.getAgentcode(), normalFormat));
					ws.addCell(new Label(12,i+1,gePolicy.getBrno()==null?"":gePolicy.getBrno(), normalFormat));
					while(geApplicantinsured.hasNext()){
						GeApplicantinsured next = geApplicantinsured.next();
						if(next.getFlag().equals("1")){
							ws.addCell(new Label(13,i+1,next.getIdentifytype()==null?"":this.checkIdentifytype(next.getIdentifytype()), normalFormat));
							ws.addCell(new Label(14,i+1,next.getIdentifynumber()==null?"":next.getIdentifynumber(), normalFormat));
							ws.addCell(new Label(15,i+1,next.getMobile()==null?"":next.getMobile(), normalFormat));
							ws.addCell(new Label(16,i+1,next.getEmail()==null?"":next.getEmail(), normalFormat));
							ws.addCell(new Label(17,i+1,next.getAddress()==null?"":next.getAddress(), normalFormat));
						}
						if(next.getFlag().equals("2")){
							ws.addCell(new Label(18,i+1,next.getIdentifytype()==null?"":this.checkIdentifytype(next.getIdentifytype()), normalFormat));
							ws.addCell(new Label(19,i+1,next.getIdentifynumber()==null?"":next.getIdentifynumber(), normalFormat));
							ws.addCell(new Label(20,i+1,next.getMobile()==null?"":next.getMobile(), normalFormat));
							ws.addCell(new Label(21,i+1,next.getEmail()==null?"":next.getEmail(), normalFormat));
							ws.addCell(new Label(22,i+1,next.getAddress()==null?"":next.getAddress(), normalFormat));
						}
					}
					ws.addCell(new Label(23,i+1,gePolicy.getDeptid()==null?"":gePolicy.getDeptid(), normalFormat));
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
	
	public boolean report1(OutputStream os, List<GePolicy> policys) {
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
				WritableSheet ws = wwb.createSheet("保单表", 0);
				ws.addCell(new Label(0, 0, "保单号", headFormat));
				ws.setColumnView(0, 13);
				ws.addCell(new Label(1, 0, "产品名称", headFormat));
				ws.setColumnView(1, 14);
				ws.addCell(new Label(2, 0, "投保日期", headFormat));
				ws.setColumnView(2, 24);
				ws.addCell(new Label(3, 0, "投保人 ", headFormat));
				ws.setColumnView(3, 24);
				ws.addCell(new Label(4, 0, "被保人", headFormat));
				ws.setColumnView(4, 24);
				ws.addCell(new Label(5, 0, "生效日期", headFormat));
				ws.setColumnView(5, 24);
				ws.addCell(new Label(6, 0, "截止日期", headFormat));
				ws.setColumnView(6, 24);
				ws.addCell(new Label(7, 0, "保费", headFormat));
				ws.setColumnView(7, 24);
				ws.addCell(new Label(8, 0, "总保额", headFormat));
				ws.setColumnView(8, 24);
				ws.addCell(new Label(9, 0, "状态", headFormat));
				ws.setColumnView(9, 24);
				ws.addCell(new Label(10, 0, "活动码", headFormat));
				ws.setColumnView(10, 24);
				ws.addCell(new Label(11, 0, "推荐码", headFormat));
				ws.setColumnView(11, 24);
				
				int i=0;
				for(GePolicy gePolicy : policys){
					ws.addCell(new Label(0, i+1, gePolicy.getPolicycode()==null?"":gePolicy.getPolicycode(), normalFormat));
					ws.addCell(new Label(1, i+1,gePolicy.getProductname()==null?"":gePolicy.getProductname(), normalFormat));
					ws.addCell(new Label(2, i+1,gePolicy.getInsuretime()==null?"":formatDate(gePolicy.getInsuretime()), normalFormat));
					ws.addCell(new Label(3, i+1,gePolicy.getApplicantname()==null?"":gePolicy.getApplicantname(), normalFormat));
					ws.addCell(new Label(4, i+1,gePolicy.getInsuredname()==null?"":gePolicy.getInsuredname(), normalFormat));
					ws.addCell(new Label(5, i+1,gePolicy.getTakeeffecttime()==null?"":gePolicy.getTakeeffecttime().toString(), normalFormat));
					ws.addCell(new Label(6, i+1,gePolicy.getDeadlinetime()==null?"":gePolicy.getDeadlinetime().toString() , normalFormat));
					ws.addCell(new Label(7, i+1,gePolicy.getSumbasepremium()==null?"":gePolicy.getSumbasepremium().toString() , normalFormat));
					ws.addCell(new Label(8, i+1,gePolicy.getSumamount()==null?"":gePolicy.getSumamount().toString(), normalFormat));
					ws.addCell(new Label(9, i+1,gePolicy.getStatus()==null?"":checkType(gePolicy.getStatus()), normalFormat));
					ws.addCell(new Label(10,i+1,gePolicy.getPreferentialcode()==null?"":gePolicy.getPreferentialcode(), normalFormat));
					ws.addCell(new Label(11,i+1,gePolicy.getAgentcode()==null?"":gePolicy.getAgentcode(), normalFormat));
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
 
 
	
	public String formatDate(Date date){
		
		String result="";
		if(date!=null){
			result= format2.format(date);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	@Action(value="policyInfo")
	public String policyDetail(){
		gePolicy = ps.getPolicyByPolicyno(policyno);
		Set<GeApplicantinsured> applicantinsured = gePolicy.getApplicantinsureds();
		Set<GeBeneficiary> beneficiarie = gePolicy.getBeneficiaries();
		
		GeApplicantinsured applicant = new GeApplicantinsured();
		
		List<GeApplicantinsured> insureds = new ArrayList<GeApplicantinsured>();
		List<GeBeneficiary> beneficiaries = new ArrayList<GeBeneficiary>();
		for (GeApplicantinsured geApplicantinsured : applicantinsured) {
			if(geApplicantinsured.getFlag().equals("1")){
				applicant = geApplicantinsured;
			}else if(geApplicantinsured.getFlag().equals("2")){
				insureds.add(geApplicantinsured);
			}else{
				applicant = geApplicantinsured;
				insureds.add(geApplicantinsured);
			}
		}
		
		for (GeBeneficiary geBeneficiary : beneficiarie) {
			beneficiaries.add(geBeneficiary);
		}
		
		this.setRequestAttribute("policy", gePolicy);
		this.setRequestAttribute("applicant", applicant);
		this.setRequestAttribute("insureds", insureds);
		this.setRequestAttribute("beneficiaries", beneficiaries);
		return "/page/policyInfo";
	}

	
	public GePolicy getGePolicy() {
		return gePolicy;
	}

	public void setGePolicy(GePolicy gePolicy) {
		this.gePolicy = gePolicy;
	}

	public String getPolicyno() {
		return policyno;
	}

	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}
	
	public String getInsuretimebegin() {
		return insuretimebegin;
	}

	public void setInsuretimebegin(String insuretimebegin) {
		this.insuretimebegin = insuretimebegin;
	}

	public String getInsuretimeend() {
		return insuretimeend;
	}

	public void setInsuretimeend(String insuretimeend) {
		this.insuretimeend = insuretimeend;
	}

	
	
	
	public String checkType(String type){
		String result ="";
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
		return result;
	}
	
	
	
	//赠险部分
	
	@Action(value="charityPolicyList")
	public String jumpcharityPage(){
		return "/page/charityPolicyList";
	}
	
	
	@Action(value="charityFindPolicyData")
	public void findAllCharityPolicy(){
		Page<GePolicy> policyPage = ps.getCharityPolicy(gePolicy, page, rows);
		List<PolicyRow>  listRows = new ArrayList<PolicyRow>();
		PolicyDto policyData = new PolicyDto(); 
		for(GePolicy data: (List<GePolicy>)policyPage.getData()){
			PolicyRow row = new PolicyRow();
			BeanUtils.copyProperties(data, row);
			listRows.add(row);
		}
		policyData.setTotal(policyPage.getTotal() + "");
		policyData.setRows(listRows);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss")); 
		renderJson(JsonUtils.convertObject(policyData,jsonConfig));
	}
	
	
	@Action(value="expCharityPolicy")
	 public boolean expCharityPolicy() throws UnsupportedEncodingException{
		String policycode = super.getHttpServletRequest().getParameter("policycode");
		String productname = super.getHttpServletRequest().getParameter("productname")==null?"":new String(super.getHttpServletRequest().getParameter("productname").getBytes("ISO-8859-1"),"gbk");
		String applicantname = super.getHttpServletRequest().getParameter("applicantname")==null?"":new String(super.getHttpServletRequest().getParameter("applicantname").getBytes("ISO-8859-1"),"gbk");
		String status = super.getHttpServletRequest().getParameter("status");
		String starttime = super.getHttpServletRequest().getParameter("starttime");
		String endtime = super.getHttpServletRequest().getParameter("endtime");
		List<GePolicy> policys = ps.getAllCharityPolicy(policycode,productname,applicantname,status,starttime,endtime);
	//	super.getHttpServletRequest();
		HttpServletResponse response;
		 try {			
				response = getHttpServletResponse();
				response.setContentType("application/octet-stream;charset=utf-8");
				response.setContentType("application/msexcel");
				String  filename = "policylist" + DateAndTime.getCurrentDateTime("yyyyMMdd") + ".xls";
				response.addHeader("Content-Disposition","attachment;filename=" + new String(filename.getBytes("utf-8"), "iso-8859-1")); 
				OutputStream os = response.getOutputStream();
				PolicyAction epolicy = new PolicyAction();
				boolean flag =  epolicy.report1(os, policys);
			
//				os.close();
//				out.clear();
//				out = pageContext.pushBody();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 return true;
	 }
	
	public String checkIdentifytype(String identifytype){
		String result ="";
		if(identifytype.equals("I")){
			result="身份证";
		}
		if(identifytype.equals("P")){
			result="护照";
		}
		if(identifytype.equals("S")){
			result="军官证";
		}
		if(identifytype.equals("M")){
			result="回乡证";
		}
		if(identifytype.equals("H")){
			result="港澳通行证";
		}
		if(identifytype.equals("T")){
			result="台胞证";
		}
		if(identifytype.equals("O")){
			result="其他";
		}
		return result;
	}
		
	
}