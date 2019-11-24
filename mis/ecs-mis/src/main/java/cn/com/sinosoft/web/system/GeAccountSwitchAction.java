package cn.com.sinosoft.web.system;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import cn.com.sinosoft.domain.system.GeAccountSwitch;
import cn.com.sinosoft.dto.system.GeAccountSwitchForm;
import cn.com.sinosoft.dto.system.GeAccountSwitchForm.GeAccountSwitchRow;
import cn.com.sinosoft.user.service.GeAccountSwitchService;

public class GeAccountSwitchAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	@Autowired
	GeAccountSwitchService geAccountSwitchService;

	GeAccountSwitch geAccountSwitch;

	public GeAccountSwitch getGeAccountSwitch() {
		return geAccountSwitch;
	}

	public void setGeAccountSwitch(GeAccountSwitch geAccountSwitch) {
		this.geAccountSwitch = geAccountSwitch;
	}

	@Action(value = "GeAccountSwitchForm")
	public String geAccountSwitchForm() {
		return "/page/main/GeAccountSwitch";
	}

	// /**
	// * 根据保单号查询投资账户转移列表
	// * */
	// @Action(value="GeAccountSwitchSearch1")
	// public void geAccountSwitchSearch1(){
	// String policynum = "";
	// if(geAccountSwitch != null){
	// policynum = geAccountSwitch.getPolicynum();
	// }
	// Page<GeAccountSwitch> pageObj =
	// geAccountSwitchService.findList(policynum,page,rows);
	// List<GeAccountSwitch> list = pageObj.getData();
	// GeAccountSwitchForm geAccountSwitchForm = new GeAccountSwitchForm();
	// geAccountSwitchForm.setTotal(pageObj.getTotal() + "");
	// List<GeAccountSwitchRow> rows = new ArrayList<GeAccountSwitchRow>();
	// for (GeAccountSwitch geAccountSwitch : list) {
	// GeAccountSwitchRow row = new GeAccountSwitchRow();
	// BeanUtils.copyProperties(geAccountSwitch, row);
	// rows.add(row);
	// }
	// geAccountSwitchForm.setRows(rows);
	// String result = JSONObject.fromObject(geAccountSwitchForm).toString();
	// super.render(result, "text/json;charset=UTF-8");
	//
	// }

	/**
	 * 根据保单号查询投资账户转移列表(加了条件模糊查询)
	 */
	@Action(value = "GeAccountSwitchSearch")
	public void geAccountSwitchSearch() {
		Page<GeAccountSwitch> pageObj = geAccountSwitchService.findList1(geAccountSwitch, page, rows);
		List<GeAccountSwitch> list = pageObj.getData();
		GeAccountSwitchForm geAccountSwitchForm = new GeAccountSwitchForm();
		geAccountSwitchForm.setTotal(pageObj.getTotal() + "");
		List<GeAccountSwitchRow> rows = new ArrayList<GeAccountSwitchRow>();
		for (GeAccountSwitch geAccountSwitch : list) {
			GeAccountSwitchRow row = new GeAccountSwitchRow();
			BeanUtils.copyProperties(geAccountSwitch, row);
			rows.add(row);
		}
		geAccountSwitchForm.setRows(rows);
		String result = JSONObject.fromObject(geAccountSwitchForm).toString();
		super.render(result, "text/json;charset=UTF-8");
	}
	@Action(value = "exportGeAccountSwitch")
	public Boolean exportGeAccountSwitch()throws UnsupportedEncodingException {
		HttpServletResponse response;
		 Boolean  flag=false;
		try {
			String policynum = super.getHttpServletRequest().getParameter("policynum") == null ? "": super.getHttpServletRequest().getParameter("policynum");
			String productName = super.getHttpServletRequest().getParameter("productName") == null ? "": java.net.URLDecoder.decode(super.getHttpServletRequest().getParameter("productName"), "utf-8");
			String accountName = super.getHttpServletRequest().getParameter("accountName") == null ? "": java.net.URLDecoder.decode(super.getHttpServletRequest().getParameter("accountName"), "utf-8");
			String makedateBegin =super.getHttpServletRequest().getParameter("makedateBegin") == null ? "": super.getHttpServletRequest().getParameter("makedateBegin");
			String makedateEnd = super.getHttpServletRequest().getParameter("makedateEnd") == null ? "": super.getHttpServletRequest().getParameter("makedateEnd");
			Date startDate = null;
			Date endDate = null;
			GeAccountSwitch accountSwitch=new GeAccountSwitch();
			accountSwitch.setAccountName(accountName);
			accountSwitch.setProductName(productName);
			accountSwitch.setPolicynum(policynum);
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			if(makedateBegin!=null && !makedateBegin.equals("")){
				 startDate=format.parse(makedateBegin);
			 }
			 if(makedateEnd!=null && !makedateEnd.equals("")){
				 endDate=format.parse(makedateEnd);
			 }
			List<GeAccountSwitch> geAccountSwitchs = geAccountSwitchService.findAll(accountSwitch);
			response = getHttpServletResponse();
			response.setContentType("application/octet-stream;charset=utf-8");
			response.setContentType("application/msexcel");
			String filename = "geAccountSwitch_" + DateAndTime.getCurrentDateTime("yyyyMMdd") + ".xls";
			response.addHeader("Content-Disposition",
					"attachment;filename=" + new String(filename.getBytes("utf-8"), "iso-8859-1"));
			OutputStream os = response.getOutputStream();
			flag =report(os, geAccountSwitchs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean report(OutputStream os, List<GeAccountSwitch> geAccountSwitchs) {
		WritableWorkbook wwb = null;
		try {
			wwb = Workbook.createWorkbook(os);
			WritableFont headColor = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.BLACK);// 设置字体的颜色格式大小
			WritableFont headFont = new WritableFont(headColor);// 使用上面定义的字体格式
			WritableCellFormat headFormat = new WritableCellFormat(headFont);// 设置单元格格式
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
			WritableSheet ws = wwb.createSheet("证件有效期变更列表", 0);
			ws.addCell(new Label(0, 0, "保单号", headFormat));
			ws.setColumnView(0, 13);
			ws.addCell(new Label(1, 0, "账户名称", headFormat));
			ws.setColumnView(1, 14);
//			ws.addCell(new Label(2, 0, "险种名称", headFormat));
//			ws.setColumnView(2, 24);
			ws.addCell(new Label(2, 0, "修改比例", headFormat));
			ws.setColumnView(2, 24);
			ws.addCell(new Label(3, 0, "操作时间 ", headFormat));
			ws.setColumnView(3, 24);
			int i = 0;
			for (GeAccountSwitch geAccountSwitch : geAccountSwitchs) {
				ws.addCell(new Label(0, i + 1, geAccountSwitch.getPolicynum(), normalFormat));// 保单号
//				ws.addCell(new Label(1, i + 1, geAccountSwitch.getProductName(), normalFormat));// 险种名称
				ws.addCell(new Label(1, i + 1, geAccountSwitch.getAccountName(), normalFormat));// 账户名称
				ws.addCell(new Label(2, i + 1, geAccountSwitch.getSwitchratio(), normalFormat));// 修改比例
				ws.addCell(new Label(3, i + 1, geAccountSwitch.getMakedate(), normalFormat));// 操作时间
				i++;
			}
			wwb.write();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (wwb != null) {
					wwb.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
