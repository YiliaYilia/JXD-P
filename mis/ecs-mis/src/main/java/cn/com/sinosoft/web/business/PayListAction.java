package cn.com.sinosoft.web.business;

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
import cn.com.sinosoft.domain.sell.GePayList;
import cn.com.sinosoft.dto.sell.PayListDto;
import cn.com.sinosoft.dto.sell.PayListDto.PayListRow;
import cn.com.sinosoft.product.service.OrderService;
import cn.com.sinosoft.product.service.PayListService;

public class PayListAction extends Struts2Action{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PayListService payservice;
	@Autowired
	private OrderService os;
	
	private GePayList gePayList;
	
	
	
	/**
	 * 支付列表跳转
	 * */
	@Action(value="payList")
	public String jumpOrderListPage(){
		return "/page/payList";
	}
	
	DateFormat format2= new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒"); 
	/**
	 * 支付列表
	 * */
	@Action(value="findPayListData")
	 public void findPayListData(){
		Page <GePayList> payPage = payservice.getPayList(gePayList, page, rows);
		List <PayListRow> payRows = new ArrayList<PayListRow>();
		PayListDto payData = new PayListDto();
		for(GePayList data : (List<GePayList>)payPage.getData()){
			PayListRow row = new PayListRow();
			BeanUtils.copyProperties(data, row);
			String orderCode = row.getOrderid();
			GeOrder orderInfo = os.getOrderByOrderCode(orderCode);
			if(orderInfo!=null){
				row.setProductname(orderInfo.getProductname()==null?"":orderInfo.getProductname());
				row.setApplicantname(orderInfo.getApplicantname()==null?"":orderInfo.getApplicantname());
				row.setPolicyno(orderInfo.getPolicyno()==null?"":orderInfo.getPolicyno());
				row.setActivecode(orderInfo.getAgentidentitycode()==null?"":orderInfo.getAgentidentitycode());
			}
			payRows.add(row);
		}
		payData.setTotal(payPage.getTotal()+"");
		payData.setRows(payRows);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss")); 
		renderJson(JsonUtils.convertObject(payData,jsonConfig));
	}


	
	@Action(value="expPayList")
	 public boolean expPolicy() throws UnsupportedEncodingException{
		List <PayListRow> payRows = new ArrayList<PayListRow>();
		String policyno = super.getHttpServletRequest().getParameter("policyno");
		String orderid = super.getHttpServletRequest().getParameter("orderid");
		String applicantname = super.getHttpServletRequest().getParameter("applicantname")==null?"":new String(super.getHttpServletRequest().getParameter("applicantname").getBytes("ISO-8859-1"),"UTF-8");
		String isback = super.getHttpServletRequest().getParameter("isback");
		String starttime = super.getHttpServletRequest().getParameter("starttime");
		String endtime = super.getHttpServletRequest().getParameter("endtime");
		List<GePayList> payLists =payservice.getAllPayList(policyno,orderid,applicantname,isback,starttime,endtime);
		for(GePayList data : payLists){
			PayListRow row = new PayListRow();
			BeanUtils.copyProperties(data, row);
			String orderCode = row.getOrderid();
			GeOrder orderInfo = os.getOrderByOrderCode(orderCode);
			if(orderInfo!=null){
				row.setProductname(orderInfo.getProductname()==null?"":orderInfo.getProductname());
				row.setApplicantname(orderInfo.getApplicantname()==null?"":orderInfo.getApplicantname());
				row.setPolicyno(orderInfo.getPolicyno()==null?"":orderInfo.getPolicyno());
				row.setActivecode(orderInfo.getAgentidentitycode()==null?"":orderInfo.getAgentidentitycode());
				row.setMount(orderInfo.getOrderamount()==null?"":String.valueOf(orderInfo.getOrderamount()));
			}
			payRows.add(row);
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
				PayListAction epolicy = new PayListAction();
				boolean flag =  epolicy.report(os, payRows);
			
//				os.close();
//				out.clear();
//				out = pageContext.pushBody();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 return true;
	 }
	
	
	public boolean report(OutputStream os, List<PayListRow> payLists) {
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
				WritableSheet ws = wwb.createSheet("支付表", 0);
				ws.addCell(new Label(0, 0, "订单号", headFormat));
				ws.setColumnView(0, 13);
				ws.addCell(new Label(1, 0, "保单号", headFormat));
				ws.setColumnView(1, 14);
				ws.addCell(new Label(2, 0, "投保人姓名", headFormat));
				ws.setColumnView(2, 24);
				ws.addCell(new Label(3, 0, "产品名称 ", headFormat));
				ws.setColumnView(3, 24);
				ws.addCell(new Label(4, 0, "活动码", headFormat));
				ws.setColumnView(4, 24);
				ws.addCell(new Label(5, 0, "渠道编码", headFormat));
				ws.setColumnView(5, 24);
				ws.addCell(new Label(6, 0, "金额", headFormat));
				ws.setColumnView(6, 24);
				ws.addCell(new Label(7, 0, "支付时间", headFormat));
				ws.setColumnView(7, 24);
				ws.addCell(new Label(8, 0, "是否退款", headFormat));
				ws.setColumnView(8, 24);
				
				int i=0;
				for(PayListRow gePayList : payLists){
					ws.addCell(new Label(0, i+1, gePayList.getOrderid()==null?"":gePayList.getOrderid(), normalFormat));
					ws.addCell(new Label(1, i+1,gePayList.getPolicyno()==null?"":gePayList.getPolicyno(), normalFormat));
//					ws.addCell(new Label(2, i+1,gePayList.getApplicantname()==null?"":gePayList.getApplicantname(), normalFormat));
//					ws.addCell(new Label(3, i+1,gePayList.getProductname()==null?"":gePayList.getProductname(), normalFormat));
					ws.addCell(new Label(4, i+1,gePayList.getActivecode()==null?"":gePayList.getActivecode(), normalFormat));
					ws.addCell(new Label(5, i+1,gePayList.getChannelcode()==null?"":gePayList.getChannelcode() , normalFormat));
					ws.addCell(new Label(6, i+1,gePayList.getMount()==null?"":gePayList.getMount(), normalFormat));
					ws.addCell(new Label(7, i+1,gePayList.getPaytime()==null?"":formatDate(gePayList.getPaytime()), normalFormat));
					ws.addCell(new Label(8, i+1,gePayList.getIsback()==null?"":checkType(gePayList.getIsback()), normalFormat));
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
	
	
	
	
	public GePayList getGePayList() {
		return gePayList;
	}


	public void setGePayList(GePayList gePayList) {
		this.gePayList = gePayList;
	}
	
	
	
	
	public String formatDate(Date date){
		
		String result="";
		if(date!=null){
			result= format2.format(date);
		}
		return result;
	}
	public String checkType(String type){
		String result ="";
			if(type.equals("1")){
				result="已退款";
			}
			if(type.equals("0")){
				result="未退款";
			}
		return result;
	}
}
