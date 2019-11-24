package cn.com.sinosoft.web.business;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonConfig;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.convention.annotation.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.utils.DateAndTime;
import cn.com.sinosoft.core.utils.ExportUtil;
import cn.com.sinosoft.core.utils.JsonDateValueProcessor;
import cn.com.sinosoft.core.utils.JsonUtils;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.product.GeClaimManagement;
import cn.com.sinosoft.domain.product.GeClaimRider;
import cn.com.sinosoft.domain.sell.GeOrder;
import cn.com.sinosoft.domain.sell.GePolicy;
import cn.com.sinosoft.domain.system.GeDepartment;
import cn.com.sinosoft.domain.system.GeUser;
import cn.com.sinosoft.dto.sell.ClaimDto;
import cn.com.sinosoft.dto.sell.ClaimDto.ClaimRow;
import cn.com.sinosoft.dto.system.ECSUser;
import cn.com.sinosoft.product.service.ClaimService;
import cn.com.sinosoft.product.service.DepartmentService;
import cn.com.sinosoft.user.service.UserService;

/**
 * 理赔查询
 * @author liangkesai
 * @date 2018年6月25日 下午4:57:49
 */
public class ClaimAction extends Struts2Action{
	
	private static final long serialVersionUID = 1L;
	
	public static Logger logger = LoggerFactory.getLogger(ClaimAction.class);
	
	@Autowired
	private ClaimService cs;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private UserService userService;
	
	private GeClaimManagement geClaimManagement;
	
	private String claimManagementNo;
	
	private String remark; //备注
	
	private String amount; //理赔额
	
	@Action(value="claimList")
	public String jumpClaimListPage(){
		ECSUser user = (ECSUser)this.getHttpSession().getAttribute("user");
		String usertype = user.getGeUser().getUsertype();
		List<GeDepartment> departmentList = null ;
		if(usertype.equals("admin")){
			departmentList = departmentService.getAllDepartment();
			this.setRequestAttribute("departmentList", departmentList);
		}else{
			GeUser geUser = userService.getGeUserById(user.getGeUser().getUserid());
			Set<GeDepartment> departments = geUser.getGeDepartments();
			this.setRequestAttribute("departmentList", departments);
		}
		return "/page/claimList";
	}
	
	/**
	 * 查询理赔列表
	 */
	@Action(value="findClaimData")
	public void findAllClaim(){
		String userid = super.getHttpServletRequest().getParameter("userid");
		GeUser geUser = userService.getGeUserById(userid);
		Page<GeClaimManagement> claimPage = null;
		//兼容以前数据——增加市场字段后，将以前的数据补全该字段值
		cs.completionDepartmentForClaim();
		if(geUser.getUsertype().equals("admin")){
			claimPage = cs.getClaim(geClaimManagement, page, rows);
		}else{
		    Set<GeDepartment> departments = geUser.getGeDepartments();
		    if(departments.size() > 0) {
		    	claimPage = cs.getClaim(departments,geClaimManagement, page, rows);
		    }
		}
		List<ClaimRow> listRows = new ArrayList<ClaimRow>();
		ClaimDto claimData = new ClaimDto();
		for (GeClaimManagement data : (List<GeClaimManagement>)claimPage.getData()) {
			ClaimRow row = new ClaimRow();
			BeanUtils.copyProperties(data, row);
			listRows.add(row);
		}
		claimData.setTotal(claimPage.getTotal()+"");
		claimData.setRows(listRows);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss")); 
		renderJson(JsonUtils.convertObject(claimData,jsonConfig));
	}
	
	/**
	 * 理赔详情
	 * @return
	 */
	@Action(value="claimInfo")
	public String claimDetail(){
		geClaimManagement = cs.getClaimByClaimNo(claimManagementNo);
		this.setRequestAttribute("geClaimManagement", geClaimManagement);
		this.setRequestAttribute("geClaimRider", geClaimManagement.getGeClaimRider());
		return "/page/claimInfo";
	}

	/**
	 * 理赔退回按钮
	 * @return
	 */	
	@Action(value="claimSendBack")
	public String claimSendBack(){
		logger.info("gyx_claimManagementNo:"+claimManagementNo);
		geClaimManagement = cs.getClaimByClaimNo(claimManagementNo);
		geClaimManagement.setRemark(remark);
		geClaimManagement.setState("03");
		cs.updateClaimRemark(geClaimManagement);
		return "/page/claimList";
	}
	
	/**
	 * 理赔审核中按钮 改变状态
	 * @return
	 */	
	@Action(value="claimAudit")
	public void claimAudit(){
		System.out.println("claimManagementNo="+claimManagementNo);
		geClaimManagement = cs.getClaimByClaimNo(claimManagementNo);
		geClaimManagement.setState("04");
		cs.updateClaimRemark(geClaimManagement);
		try {
			getHttpServletResponse().sendRedirect("../business/claimInfo?claimManagementNo="+claimManagementNo+"&date="+new Date());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 理赔完成按钮 改变状态 录入理赔额
	 * @return
	 */
	@Action(value="claimFinish")
	public void claimFinish(){
		geClaimManagement = cs.getClaimByClaimNo(claimManagementNo);
		geClaimManagement.setState("05");
		geClaimManagement.setAmount(amount);
		cs.updateClaimRemark(geClaimManagement);
		try {
			getHttpServletResponse().sendRedirect("../business/claimInfo?claimManagementNo="+claimManagementNo+"&date="+new Date());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 理赔资料下载
	 */
	@Action(value="exportData")
	public void exportData(){
		HttpServletResponse response = getHttpServletResponse();
		geClaimManagement = cs.getClaimByClaimNo(claimManagementNo);
		Set<GeClaimRider> geClaimRiders = geClaimManagement.getGeClaimRider();
		logger.info("理赔资料下载开始下载"+claimManagementNo);
		List<String> files = new ArrayList<String>();
		if(geClaimRiders.size()>0){
			for (GeClaimRider geClaimRider : geClaimRiders) {
				files.add(geClaimRider.getRiderPath());
			}
			try {
				String downloadFilename = geClaimManagement.getPolicyCode()+".zip";//文件的名称
				downloadFilename = URLEncoder.encode(downloadFilename, "UTF-8");//转换中文否则可能会产生乱码
				response.setContentType("application/octet-stream");// 指明response的返回对象是文件流 
				response.setHeader("Content-Disposition", "attachment;filename=" + downloadFilename);// 设置在下载框默认显示的文件名
				ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
				for (int i=0;i<files.size();i++) {
				    URL url = new URL(files.get(i));
				    zos.putNextEntry(new ZipEntry(i+".jpg"));
				    InputStream fis = url.openConnection().getInputStream();   
				    byte[] buffer = new byte[1024];     
				    int r = 0;     
				    while ((r = fis.read(buffer)) != -1) {     
				        zos.write(buffer, 0, r);     
				    }     
				    fis.close();   
				}  
				zos.flush();     
				zos.close();
				logger.info("理赔资料下载完成"+downloadFilename);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	
	        
	/**
	 * 导出Excel
	 * @throws ParseException
	 */
	@Action(value="expClaim")
	public void expClaim() throws ParseException{
		Date starttime=null;
		Date endtime =null;
		HttpServletRequest request = super.getHttpServletRequest();
		String policyno = request.getParameter("policyno");
		String applicantname = request.getParameter("applicantname");
		String startTime = request.getParameter("srarttime");
		String endTime = request.getParameter("endtime");
		String statesearch = request.getParameter("statesearch");
		String deptid = request.getParameter("deptid");
		String userid = request.getParameter("userid");
		GeUser geUser = userService.getGeUserById(userid);
		Set<GeDepartment> departments = null ;
		if(!geUser.getUsertype().equals("admin")){
			departments = geUser.getGeDepartments();
		}
		if(applicantname!=null&&applicantname.length()>0){
			try {
				applicantname=new String(applicantname.getBytes("iso-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		geClaimManagement=new GeClaimManagement();
		geClaimManagement.setPolicyCode(policyno);
		geClaimManagement.setName(applicantname);
		geClaimManagement.setState(statesearch);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(startTime!=null&&startTime.length()>0){
			 starttime = format.parse(startTime);
		}if(endTime!=null&&endTime.length()>0){
			 endtime = format.parse(endTime);
		}
		geClaimManagement.setStarttime(starttime);
		geClaimManagement.setEndtime(endtime);
		List<GeClaimManagement> claimlist=null;
		try {
			logger.info("cs:"+cs);
			claimlist = cs.findbyquery(geClaimManagement,departments);
		} catch (Exception e1) {
			logger.error("claim导出错误：",e1.getStackTrace());
		}
		for(GeClaimManagement c:claimlist){
			if(c.getInsrelationApp().equals("SF")){
				c.setInsrelationApp("本人");
			}else if(c.getInsrelationApp().equals("FA")){
				c.setInsrelationApp("父亲");
			}else if(c.getInsrelationApp().equals("MO")){
				c.setInsrelationApp("母亲");
			}
			
			if(c.getClaimManagementType().equals("1")){
				c.setClaimManagementType("住院津贴");
			}else if(c.getClaimManagementType().equals("2")){
				c.setClaimManagementType("医疗报销");
			}else if(c.getClaimManagementType().equals("3")){
				c.setClaimManagementType("重大疾病");		
			}else if(c.getClaimManagementType().equals("4")){
				c.setClaimManagementType("伤残");
			}else if(c.getClaimManagementType().equals("5")){
				c.setClaimManagementType("身故");
			}
			
			if(c.getIsInsure().equals("Y")){
				c.setIsInsure("是");
			}else if(c.getIsInsure().equals("N")){
				c.setIsInsure("否");
			}
			
			if(c.getState().equals("01")){
				c.setState("已报案");
			}else if(c.getState().equals("02")){
				c.setState("已提交");
			}else if(c.getState().equals("03")){
				c.setState("已退回");
			}else if(c.getState().equals("04")){
				c.setState("审核中");
			}else if(c.getState().equals("05")){
				c.setState("已完成");
			}
			if(c.getDeptid()!=null){
				GeDepartment department = departmentService.getDepartmentByDetpid(c.getDeptid());
		    	String deptname = department==null?"":department.getDeptname();
		    	c.setDeptid(deptname);
			}
		}
		HttpServletResponse response = getHttpServletResponse();
		try {
			//导出excel文件的名字
			String filename = "理赔表-"+DateAndTime.getCurrentDateTime("yyyy-MM-dd");
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes("utf-8"), "iso8859-1")+".xls");
			//创建Excel
			HSSFWorkbook wb = new HSSFWorkbook();
			//创建第一个sheet
			HSSFSheet sheet = wb.createSheet("理赔表");
			//表头名称
			String titles = "保单号,申请人,索赔类别,被保险人出险日期,被保险人出险原因,被保险人当前职业,报案人联系电话,被保险人是否在其他公司有人身保险,公司名称,投保日期,购买险种名称以及保额,状态,申请时间,修改日期,被保险人姓名,被保险人证件号,组织机构"; 
			//对应的数据库字段 (查询出的list)
			String fields = "policyCode,name,claimManagementType,startDate,startCause,occupation,phone,isInsure,corporationName,insureDate,insuranceInfo,state,createDate,updateDate,insuredName,insuredIdNo,deptid";
			ExportUtil.outputHeaders(titles.split(","), sheet);
			ExportUtil.outputColumns(fields.split(","), claimlist, sheet, 1);
			//获取输出流，写入excel 并关闭
			ServletOutputStream out = response.getOutputStream();
			wb.write(out);
			out.flush();
			out.close();
			logger.info("理赔表导出Excel完成--开始时间:"+startTime+"--结束时间:"+endTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	public String getClaimManagementNo() {
		return claimManagementNo;
	}

	public void setClaimManagementNo(String claimManagementNo) {
		this.claimManagementNo = claimManagementNo;
	}
	
	public GeClaimManagement getGeClaimManagement() {
		return geClaimManagement;
	}

	public void setGeClaimManagement(GeClaimManagement geClaimManagement) {
		this.geClaimManagement = geClaimManagement;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
