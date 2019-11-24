package cn.com.sinosoft.web.business;
/**
 * 
 *@author  kathy.han
 *@create date:20160310
 *@desc 追加投资查询 
 * 
*/
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonConfig;

import org.apache.struts2.convention.annotation.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.utils.DateAndTime;
import cn.com.sinosoft.core.utils.JsonDateValueProcessor;
import cn.com.sinosoft.core.utils.JsonUtils;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.domain.product.GeInvestment;
import cn.com.sinosoft.dto.sell.InvestmentDto;
import cn.com.sinosoft.dto.sell.InvestmentDto.InvestmentRow;
import cn.com.sinosoft.product.service.InvestmentService;
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

public class InvestmentAction extends Struts2Action{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private InvestmentService investmentService;
	
	private GeInvestment geInvestment;
	
	public static Logger logger = LoggerFactory.getLogger(InvestmentAction.class);
	
	@Action(value="investmentList")
	public String jumpInvestmentListPage(){
		return "/page/investmentList";
	}
	
	
	
	//分页查询
	@Action(value="findInvestmentData")
	public void findInvestmentByPage() throws Exception{
		try{
			 String startTime = super.getHttpServletRequest().getParameter("startTime")==null?"":super.getHttpServletRequest().getParameter("startTime");
			 String endTime = super.getHttpServletRequest().getParameter("endTime")==null?"":super.getHttpServletRequest().getParameter("endTime");
			 Date startDate=null;
			 Date endDate=null;
			 DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
			 if(startTime!=null && !startTime.equals("")){
				 startDate=fmt.parse(startTime);
				 geInvestment.setStartTime(startDate);
			 }
			 if(endTime!=null && !endTime.equals("")){
				 endDate=fmt.parse(endTime);
				 geInvestment.setEndTime(endDate);
			 }
			 
			Page<GeInvestment> investmentPage =investmentService.getInvestmentList(geInvestment,page, rows);
			List<InvestmentRow> listRows = new ArrayList<InvestmentRow>();
			InvestmentDto investmentData = new InvestmentDto();
			String bankCardId="";
			for (GeInvestment data : (List<GeInvestment>)investmentPage.getData()) {
				InvestmentRow row = new InvestmentRow();
				bankCardId=data.getBankCardId()==null?"":data.getBankCardId();
				if(bankCardId.length()>4){
					bankCardId="****"+bankCardId.substring(bankCardId.length()-4,bankCardId.length());
				}
				data.setBankCardId(bankCardId);//银行卡号只显示后4位
				BeanUtils.copyProperties(data, row);
				listRows.add(row);
			}
			investmentData.setTotal(investmentPage.getTotal()+"");
			investmentData.setRows(listRows);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor("yyyy-MM-dd HH:mm:ss")); 
			renderJson(JsonUtils.convertObject(investmentData,jsonConfig));
		}
		catch (Exception e) {
			e.printStackTrace();
     }
		 
	}
	
	/**
	 * 追加投资导出Excel
	 * @throws UnsupportedEncodingException 
	 * 
	 */
	 @Action(value="expInvestment")
	 public Boolean expInvestment() throws UnsupportedEncodingException{
		 HttpServletResponse response;
		 Boolean  flag=false;
		 try {
		 	 String policyNo = super.getHttpServletRequest().getParameter("policyNo")==null?"":super.getHttpServletRequest().getParameter("policyNo");
		 	 //投保人姓名包含中文,需要进行解码处理
			 String applicantName = super.getHttpServletRequest().getParameter("applicantName")==null?"":java.net.URLDecoder.decode(super.getHttpServletRequest().getParameter("applicantName"),"utf-8");
			 String startTime = super.getHttpServletRequest().getParameter("startTime")==null?"":super.getHttpServletRequest().getParameter("startTime");
			 String endTime = super.getHttpServletRequest().getParameter("endTime")==null?"":super.getHttpServletRequest().getParameter("endTime");
			 Date startDate=null;
			 Date endDate=null;
			 
			 GeInvestment _geInvestment=new GeInvestment();
			 _geInvestment.setPolicyNo(policyNo);
			 _geInvestment.setApplicantName(applicantName);
			 DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");            
			 if(startTime!=null && !startTime.equals("")){
				 startDate=fmt.parse(startTime);
			 }
			 if(endTime!=null && !endTime.equals("")){
				 endDate=fmt.parse(endTime);
			 }
			 
			 List<GeInvestment> investmentList=investmentService.getAllInvestment(_geInvestment);
		     response = getHttpServletResponse();
			 response.setContentType("application/octet-stream;charset=utf-8");
			 response.setContentType("application/msexcel");
			 String  filename = "investmentList" + DateAndTime.getCurrentDateTime("yyyyMMddhhmm") + ".xls";
			 response.addHeader("Content-Disposition","attachment;filename=" + new String(filename.getBytes("utf-8"), "iso-8859-1")); 
			 OutputStream outputStream = response.getOutputStream();
			 flag =  report(outputStream, investmentList);
		 } catch (Exception e) {
				e.printStackTrace();
	     }
		 return flag;
	 }
	
	 public Boolean report(OutputStream outputStream, List<GeInvestment> investmentList) {
			WritableWorkbook workBook = null;
			try {
				workBook = Workbook.createWorkbook(outputStream);
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
				// 创建sheet
				WritableSheet wsheet = workBook.createSheet("追加投资列表", 0);
				//第一行标题行
				wsheet.addCell(new Label(0, 0, "保单号", headFormat));
				wsheet.setColumnView(0, 13);
				wsheet.addCell(new Label(1, 0, "投保人姓名", headFormat));
				wsheet.setColumnView(1, 14);
				wsheet.addCell(new Label(2, 0, "开户行", headFormat));
				wsheet.setColumnView(2, 24);
				wsheet.addCell(new Label(3, 0, "银行卡号", headFormat));
				wsheet.setColumnView(3, 24);
				wsheet.addCell(new Label(4, 0, "追加金额 ", headFormat));
				wsheet.setColumnView(4, 24);
				wsheet.addCell(new Label(5, 0, "操作时间", headFormat));
				wsheet.setColumnView(5, 24);
				DateFormat format2= new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒"); 
				int i=0;
				String bankCardId="";
				for(GeInvestment geInvestment : investmentList){
					bankCardId=geInvestment.getBankCardId()==null?"":geInvestment.getBankCardId();
					if(bankCardId.length()>4){
						bankCardId="****"+bankCardId.substring(bankCardId.length()-4,bankCardId.length());
					}
					wsheet.addCell(new Label(0, i+1, geInvestment.getPolicyNo()==null?"":geInvestment.getPolicyNo(), normalFormat));//保单号
					wsheet.addCell(new Label(1, i+1,geInvestment.getApplicantName()==null?"":geInvestment.getApplicantName() , normalFormat));//投保人姓名
					wsheet.addCell(new Label(2, i+1,geInvestment.getAccountBank()==null?"":geInvestment.getAccountBank(), normalFormat));//开户行
					wsheet.addCell(new Label(3, i+1,bankCardId, normalFormat));//银行卡号 只显示后4位
					wsheet.addCell(new Label(4, i+1,geInvestment.getAmount()==null?"":geInvestment.getAmount() , normalFormat));//追加金额
					wsheet.addCell(new Label(5, i+1,geInvestment.getCreateTime()==null?"":format2.format(geInvestment.getCreateTime()) , normalFormat));//申请追加时间
					i++;
				}
				workBook.write();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} finally{
				try {
					if(workBook != null){
						workBook.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	}

	public GeInvestment getGeInvestment() {
		return geInvestment;
	}

	public void setGeInvestment(GeInvestment geInvestment) {
		this.geInvestment = geInvestment;
	}

}
