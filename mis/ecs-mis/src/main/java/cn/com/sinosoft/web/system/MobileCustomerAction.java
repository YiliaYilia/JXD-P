package cn.com.sinosoft.web.system;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

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
import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.utils.DateAndTime;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.system.MobileCustomer;
import cn.com.sinosoft.dto.system.MobileUserData;
import cn.com.sinosoft.dto.system.MobileUserData.MobileUserDataRow;
import cn.com.sinosoft.user.service.MobileCustomerService;

public class MobileCustomerAction extends Struts2Action  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	MobileCustomerService mobileCustomerService;
	
	public MobileCustomer getMobileCustomer() {
		return mobileCustomer;
	}


	public void setMobileCustomer(MobileCustomer mobileCustomer) {
		this.mobileCustomer = mobileCustomer;
	}

	private MobileCustomer mobileCustomer;
	

	@Action(value = "mobileUserManager")
	public String jumpMobileManagerPage() {
		return "/page/main/mobileUser";
	}
	
	
	/**
	 * 查询用户列表
	 * */
	@Action(value="mobileCustomerSearch")
	public void mobileCustomerSearch(){
		Page<MobileCustomer> pageObj = mobileCustomerService.getMobileCustomerByNameAndIdNumber(mobileCustomer,page, rows);
		MobileUserData userDate = new MobileUserData();
		List<MobileCustomer> users = (List<MobileCustomer>)pageObj.getData();
		userDate.setTotal(pageObj.getTotal() + "");
		List<MobileUserDataRow> rows = new ArrayList<MobileUserDataRow>();
		for (MobileCustomer mobileCustomer : users) {
			MobileUserDataRow row = new MobileUserDataRow();
			BeanUtils.copyProperties(mobileCustomer, row);
			rows.add(row);
		}
		userDate.setRows(rows);
		String result = JSONObject.fromObject(userDate).toString();
		super.render(result, "text/json;charset=UTF-8");
		
	}
	
	/**
	 * 解绑
	 * */
	@Action(value="releaseCustomer")
	public void releaseCustomer(){
		String name = getHttpServletRequest().getParameter("name");
		String microid = getHttpServletRequest().getParameter("microid");
		int i  = mobileCustomerService.updateCustomer(name, microid);
		if(i > 0){
			super.renderJson("true");
		} else {
			super.renderJson("false");
		}
	}

	/**
	 * 绑定
	 */
	@Action(value="binding")
	public void binding(){
		String name = getHttpServletRequest().getParameter("name");
		String idType = getHttpServletRequest().getParameter("idType");
		String idNumber = getHttpServletRequest().getParameter("idNumber");
		String openId = getHttpServletRequest().getParameter("openId");
		int i = mobileCustomerService.bindingCustomer(name,idType,idNumber,openId);
		if(i > 0){
			super.renderJson("true");
		} else {
			super.renderJson("false");
		}
	}
	
	@Action(value="exportMobileUser")
	public boolean exportMobileUser(){
		List<MobileCustomer> users  = mobileCustomerService.getMobileCustomer();
		HttpServletResponse response;
		try {
			response = getHttpServletResponse();
			response.setContentType("application/octet-stream;charset=utf-8");
			response.setContentType("application/msexcel");
			String  filename = "micromsg_user_" + DateAndTime.getCurrentDateTime("yyyyMMdd") + ".xls";
			response.addHeader("Content-Disposition","attachment;filename=" + new String(filename.getBytes("utf-8"), "iso-8859-1")); 
			OutputStream os = response.getOutputStream();
			MobileCustomerAction customer = new MobileCustomerAction();
			boolean flag =  customer.report(os, users);
		
//			os.close();
//			out.clear();
//			out = pageContext.pushBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	
	public boolean report(OutputStream os, List<MobileCustomer> users) {
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
				WritableSheet ws = wwb.createSheet("绑定客户列表", 0);
				ws.addCell(new Label(0, 0, "客户号", headFormat));
				ws.setColumnView(0, 13);
				ws.addCell(new Label(1, 0, "客户姓名", headFormat));
				ws.setColumnView(1, 14);
				ws.addCell(new Label(2, 0, "证件类型", headFormat));
				ws.setColumnView(2, 24);
				ws.addCell(new Label(3, 0, "证件号码", headFormat));
				ws.setColumnView(3, 24);
				ws.addCell(new Label(4, 0, "性别 ", headFormat));
				ws.setColumnView(4, 24);
				ws.addCell(new Label(5, 0, "生日", headFormat));
				ws.setColumnView(5, 24);
				ws.addCell(new Label(6, 0, "邮箱", headFormat));
				ws.setColumnView(6, 24);
				ws.addCell(new Label(7, 0, "地址", headFormat));
				ws.setColumnView(7, 24);
				ws.addCell(new Label(8, 0, "邮编", headFormat));
				ws.setColumnView(8, 24);
				ws.addCell(new Label(9, 0, "电话", headFormat));
				ws.setColumnView(9, 24);
				ws.addCell(new Label(10, 0, "绑定时间", headFormat));
				ws.setColumnView(10, 24);
				ws.addCell(new Label(11, 0, "修改时间", headFormat));
				ws.setColumnView(11, 24);
				int i=0;
				for(MobileCustomer mobileCustomer : users){
					ws.addCell(new Label(0, i+1,mobileCustomer.getCoustomerid() , normalFormat));
					ws.addCell(new Label(1, i+1,mobileCustomer.getName() , normalFormat));
					ws.addCell(new Label(2, i+1,checkType(mobileCustomer.getIdtype(),"IDTYPE") , normalFormat));
					ws.addCell(new Label(3, i+1,mobileCustomer.getIdnumber() , normalFormat));
					ws.addCell(new Label(4, i+1,checkType(mobileCustomer.getSex(),"SEX") , normalFormat));
					ws.addCell(new Label(5, i+1,mobileCustomer.getBirthday() , normalFormat));
					ws.addCell(new Label(6, i+1,mobileCustomer.getEmail() , normalFormat));
					ws.addCell(new Label(7, i+1,mobileCustomer.getAddress() , normalFormat));
					ws.addCell(new Label(8, i+1,mobileCustomer.getPostcode() , normalFormat));
					ws.addCell(new Label(9, i+1,mobileCustomer.getTelphone() , normalFormat));
					ws.addCell(new Label(10, i+1,mobileCustomer.getCreattime() , normalFormat));
					ws.addCell(new Label(11, i+1,mobileCustomer.getUpdatetime() , normalFormat));
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
	
	public String checkType(String type,String flag){
		String result ="";
		if(flag=="IDTYPE"){
			if(type.equals("ID_CARD")){
				result="身份证";
			}
			if(type.equals("PASSPORT")){
				result="护照";
			}
			if(type.equals("MOC")){
				result="军官证";
			}
			if(type.equals("DRIVING_LICENSE")){
				result="驾照";
			}
			if(type.equals("BC")){
				result="出生证明";
			}
			if(type.equals("CTC")){
				result="台胞证";
			}
			if(type.equals("SOLDIERS")){
				result="士兵证";
			}
			if(type.equals("HKMTP")){
				result="港澳通行证";
			}
			if(type.equals("MID")){
				result="港澳台回乡证";
			}
			if(type.equals("HHR")){
				result="户口本";
			}
			if(type.equals("OTHERS")){
				result="其他";
			}
			if(type.equals("BIRTHCERT")){
				result="出生日期";
			}
		}
		if(flag=="SEX"){
			if(type.equals("M")){
				result="男";
			}else{
				result="女";
			}
		}
		if(flag=="STATE"){
			if(type.equals("0")){
				result="无效";
			}else{
				result="有效";
			}
		}
		return result;
	}
	
}
