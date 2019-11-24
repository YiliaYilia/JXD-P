package cn.com.sinosoft.web.business;

import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.utils.DateAndTime;
import cn.com.sinosoft.core.utils.JsonDateValueProcessor;
import cn.com.sinosoft.core.utils.JsonUtils;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.sell.GeChangepolicy;
import cn.com.sinosoft.dto.sell.BankchangeDto;
import cn.com.sinosoft.dto.sell.BankchangeDto.BankchangeRow;
import cn.com.sinosoft.product.service.bankQueryService;
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

public class bankaccChangeAction extends Struts2Action{
	
	public static Logger log = LoggerFactory.getLogger(bankaccChangeAction.class);
	
	private static final long serialVersionUID = 1L;
	private GeChangepolicy changepolicy;
	
	@Autowired
	private bankQueryService queryService;
	
	private String  policyno=null;
	
	private Date datestarttime=null;
	
	private Date dateendtime=null;
	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	@Action(value="bankchangeList",results={
		@Result(name="success",location="/business/page/bankchangeList.jsp"),
		@Result(name="error",location="error.jsp")})
	public String bankchangeList(){
		return SUCCESS;
	}
	
	@Action(value="findbankAll")
	public void findbankAll(){
		String starttime= super.getHttpServletRequest().getParameter("starttime");
		String endtime = super.getHttpServletRequest().getParameter("endtime");
		String applicantname=null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(starttime!=null&&starttime.length()>0){
			try {
				datestarttime = format.parse(starttime);//开始时间转date类型
			} catch (ParseException e) {
				log.info("String转date异常");
				e.printStackTrace();
			}//结束时间转date类型
		}
		if(endtime!=null&&endtime.length()>0){
			try {
				dateendtime = format.parse(endtime);
			} catch (ParseException e) {
				log.info("String转date异常");
				e.printStackTrace();
			}
		}
		if(changepolicy!=null){
			policyno=changepolicy.getPolicyno().length()==0?null:changepolicy.getPolicyno();
			applicantname=changepolicy.getApplicantname().length()==0?null:changepolicy.getApplicantname();
			
		}
		 Page<GeChangepolicy> findbank = queryService.findbank(policyno,applicantname,datestarttime,dateendtime, page, rows);
		 List<GeChangepolicy> data = findbank.getData();
		 BankchangeDto bt=new BankchangeDto();
		 ArrayList<BankchangeRow> changeRowList = new ArrayList<BankchangeRow>();
		 for(GeChangepolicy da:data){
			 BankchangeRow bankchangeRow = new BankchangeRow();
			 BeanUtils.copyProperties(da,bankchangeRow);
			 changeRowList.add(bankchangeRow);
		 }
		 bt.setRows(changeRowList);
		 bt.setTotal(findbank.getTotal()+"");
		 JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss")); 
		renderJson(JsonUtils.convertObject(bt,jsonConfig));
	}

	public GeChangepolicy getChangepolicy() {
		return changepolicy;
	}

	public void setChangepolicy(GeChangepolicy changepolicy) {
		this.changepolicy = changepolicy;
	}

	
	
	@Action(value="expBankchangeList")
	 public boolean expBankchangeList() throws UnsupportedEncodingException {
		String policyno = super.getHttpServletRequest().getParameter("policyno").length()==0?null:super.getHttpServletRequest().getParameter("policyno");
		String applicantname = super.getHttpServletRequest().getParameter("applicantname").length()==0?null:new String(super.getHttpServletRequest().getParameter("applicantname").getBytes("ISO-8859-1"),"UTF-8");
		String starttime = super.getHttpServletRequest().getParameter("srarttime");
		String endtime = super.getHttpServletRequest().getParameter("endtime");
		boolean flag=false;
		if(starttime!=null&&starttime.length()>0){
			try {
				datestarttime = format.parse(starttime);//开始时间转date类型
			} catch (ParseException e) {
				log.info("String转date异常");
				e.printStackTrace();
			}//结束时间转date类型
		}
		if(endtime!=null&&endtime.length()>0){
			try {
				dateendtime = format.parse(endtime);
			} catch (ParseException e) {
				log.info("String转date异常");
				e.printStackTrace();
			}
		}
		List<GeChangepolicy> allGeChangepolicy = queryService.getAllGeChangepolicy(policyno, null, datestarttime, dateendtime);
		HttpServletResponse response;
	 try {
			response = getHttpServletResponse();
			response.setContentType("application/octet-stream;charset=utf-8");
			response.setContentType("application/msexcel");
			String  filename = "allGeChangepolicy"+DateAndTime.getCurrentDateTime("yyyyMMdd") + ".xls";
			response.addHeader("Content-Disposition","attachment;filename=" + new String(filename.getBytes("utf-8"), "iso-8859-1")); 
			OutputStream os = response.getOutputStream();
			flag =this.report(os,allGeChangepolicy);
		
//			os.close();
//			out.clear();
//			out = pageContext.pushBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 return flag;
	}
	
	public boolean report(OutputStream os, List<GeChangepolicy> accounts) {
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
				WritableSheet ws = wwb.createSheet("银行账号修改记录表", 0);
				ws.addCell(new Label(0, 0, "保单号", headFormat));
				ws.setColumnView(0, 13);
				ws.addCell(new Label(1, 0, "投保人姓名", headFormat));
				ws.setColumnView(1, 14);
				ws.addCell(new Label(2, 0, "原银行名称", headFormat));
				ws.setColumnView(2, 24);         
				ws.addCell(new Label(3, 0, "原银行卡号", headFormat));
				ws.setColumnView(3, 24);         
				ws.addCell(new Label(4, 0, "新银行名称", headFormat));
				ws.setColumnView(4, 24);         
				ws.addCell(new Label(5, 0, "新银行卡号", headFormat));
				ws.setColumnView(5, 24);         
				ws.addCell(new Label(6, 0, "修改时间", headFormat));
				ws.setColumnView(6, 24);
				
				int i=0;
				for(GeChangepolicy gechangepolicy : accounts){
					ws.addCell(new Label(0, i+1,gechangepolicy.getPolicyno()==null?"":gechangepolicy.getPolicyno(), normalFormat));
					ws.addCell(new Label(1, i+1,gechangepolicy.getApplicantname()==null?"":gechangepolicy.getApplicantname() , normalFormat));
					ws.addCell(new Label(2, i+1,gechangepolicy.getBank()==null?"":gechangepolicy.getBank(), normalFormat));
					ws.addCell(new Label(3, i+1,gechangepolicy.getBankaccountnumber()==null?"":gechangepolicy.getBankaccountnumber(), normalFormat));
					ws.addCell(new Label(4, i+1,gechangepolicy.getBankC()==null?"":gechangepolicy.getBankC(),normalFormat));
					ws.addCell(new Label(5, i+1,gechangepolicy.getBankaccountnumberC()==null?"":gechangepolicy.getBankaccountnumberC(), normalFormat));
					ws.addCell(new Label(6, i+1,gechangepolicy.getUpdateTime()==null?"":gechangepolicy.getUpdateTime().toString(), normalFormat));
					i++;
				}
				
				
				
				
				
				wwb.write();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} 
			finally{
				try {
					if(wwb != null){
						wwb.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
	
	
}
