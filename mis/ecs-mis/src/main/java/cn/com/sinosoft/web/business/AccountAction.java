package cn.com.sinosoft.web.business;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import net.sf.json.JsonConfig;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.utils.DateAndTime;
import cn.com.sinosoft.core.utils.JsonDateValueProcessor;
import cn.com.sinosoft.core.utils.JsonUtils;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.sell.GeAccount;
import cn.com.sinosoft.dto.sell.AccountDto.AccountRow;
import cn.com.sinosoft.dto.sell.AccountDto;
import cn.com.sinosoft.product.service.AccountService;

public class AccountAction  extends Struts2Action{


	@Autowired
	private AccountService as;

	private GeAccount geAccount;



	DateFormat format2= new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");

	@Action(value="accountList")
	public String jumpAccountListPage(){
		return "/page/accountList";
	}

	@Action(value="findAccountData")
	public void findAllAccount(){
		Page<GeAccount> accountPage = as.getAccount(geAccount, page, rows);
		List<AccountRow> listRows = new ArrayList<AccountRow>();
		AccountDto accountData = new AccountDto();
		for(GeAccount data:(List<GeAccount>)accountPage.getData()){
			AccountRow row = new AccountRow();
			BeanUtils.copyProperties(data, row);
			listRows.add(row);
		}
		accountData.setTotal(accountPage.getTotal()+"");
		accountData.setRows(listRows);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss"));
		renderJson(JsonUtils.convertObject(accountData,jsonConfig));
	}

	public GeAccount getGeAccount() {
		return geAccount;
	}

	public void setGeAccount(GeAccount geAccount) {
		this.geAccount = geAccount;
	}


	/***
	 *
	 * 对账导出
	 */
	@Action(value="expAccount")
	public boolean expOrder() throws UnsupportedEncodingException{
		String ordercode = super.getHttpServletRequest().getParameter("ordercode");
		String productname = super.getHttpServletRequest().getParameter("productname")==null?"":new String(super.getHttpServletRequest().getParameter("productname").getBytes("ISO-8859-1"),"UTF-8");
		String applicantname = super.getHttpServletRequest().getParameter("applicantname")==null?"":new String(super.getHttpServletRequest().getParameter("applicantname").getBytes("ISO-8859-1"),"UTF-8");
		String starttime = super.getHttpServletRequest().getParameter("starttime");
		String endtime = super.getHttpServletRequest().getParameter("endtime");
		List<GeAccount> accounts = as.getAllAccount(ordercode,applicantname,productname,starttime,endtime);
		HttpServletResponse response;
		try {
			response = getHttpServletResponse();
			response.setContentType("application/octet-stream;charset=utf-8");
			response.setContentType("application/msexcel");
			String  filename = "orderlist" + DateAndTime.getCurrentDateTime("yyyyMMdd") + ".xls";
			response.addHeader("Content-Disposition","attachment;filename=" + new String(filename.getBytes("utf-8"), "iso-8859-1"));
			OutputStream os = response.getOutputStream();
			AccountAction eorder = new AccountAction();
			boolean flag =  eorder.report(os, accounts);

//			os.close();
//			out.clear();
//			out = pageContext.pushBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}


	public boolean report(OutputStream os, List<GeAccount> accounts) {
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
			ws.addCell(new Label(1, 0, "微信订单号", headFormat));
			ws.setColumnView(1, 14);
			ws.addCell(new Label(2, 0, "产品名称", headFormat));
			ws.setColumnView(2, 24);
			ws.addCell(new Label(3, 0, "保额", headFormat));
			ws.setColumnView(3, 24);
			ws.addCell(new Label(4, 0, "保费 ", headFormat));
			ws.setColumnView(4, 24);
			ws.addCell(new Label(5, 0, "投保人", headFormat));
			ws.setColumnView(5, 24);
			ws.addCell(new Label(6, 0, "投保人手机", headFormat));
			ws.setColumnView(6, 24);
			ws.addCell(new Label(7, 0, "被保人姓名", headFormat));
			ws.setColumnView(7, 24);
			ws.addCell(new Label(8, 0, "产品编号", headFormat));
			ws.setColumnView(8, 24);
			ws.addCell(new Label(9, 0, "交易时间", headFormat));
			ws.setColumnView(9, 24);
			int i=0;
			for(GeAccount geAccount : accounts){
				ws.addCell(new Label(0, i+1,geAccount.getOrdercode()==null?"":geAccount.getOrdercode(), normalFormat));
				ws.addCell(new Label(1, i+1,geAccount.getCircpaymentno()==null?"":geAccount.getCircpaymentno() , normalFormat));
				ws.addCell(new Label(2, i+1,geAccount.getProductname()==null?"":geAccount.getProductname(), normalFormat));
				ws.addCell(new Label(3, i+1,geAccount.getOrderamount()==null?"":geAccount.getOrderamount().toString(), normalFormat));
				ws.addCell(new Label(4, i+1,geAccount.getPrem()+"" , normalFormat));
				ws.addCell(new Label(5, i+1,geAccount.getApplicantname()==null?"":geAccount.getApplicantname(), normalFormat));
				ws.addCell(new Label(6, i+1,geAccount.getApplicantPhone()==null?"":geAccount.getApplicantPhone() , normalFormat));
				ws.addCell(new Label(7, i+1,geAccount.getInsuredname()==null?"":geAccount.getInsuredname() , normalFormat));
				ws.addCell(new Label(8, i+1,geAccount.getProdoctcode()==null?"":geAccount.getProdoctcode(), normalFormat));
				ws.addCell(new Label(9, i+1,geAccount.getPaytime()==null?"":geAccount.getPaytime(), normalFormat));
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

}
