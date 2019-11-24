package cn.com.sinosoft.web.system;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletOutputStream;
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
import cn.com.sinosoft.domain.system.DateChangeData;
import cn.com.sinosoft.dto.system.DateChangeForm;
import cn.com.sinosoft.dto.system.DateChangeForm.DateChangeFormRow;
import cn.com.sinosoft.user.service.DateChangeDataService;

public class DateChangeDataAction extends Struts2Action {
	public static Logger logger = LoggerFactory.getLogger(DateChangeDataAction.class);
	private static final long serialVersionUID = 1L;
	@Autowired
	DateChangeDataService dateChangeDataService;

	private DateChangeData dateChangeData;

	public DateChangeData getDateChangeData() {
		return dateChangeData;
	}

	public void setDateChangeData(DateChangeData dateChangeData) {
		this.dateChangeData = dateChangeData;
	}

	@Action(value = "dateChangeForm")
	public String dateChangeForm() {
		return "/page/main/dateChange";
	}
	
	DateFormat format2 = new SimpleDateFormat("yyyy年MM月dd日");
	public String formatDate(Date date) {
		String result = "";
		if (date != null) {
			result = format2.format(date);
		}
		return result;
	}

	/**
	 * 查询证件有效期变更列表
	 */
	@Action(value = "DateChangeDataSearch")
	public void dateChangeDataSearch() {

		Page<DateChangeData> pageObj = dateChangeDataService.findList(dateChangeData, page, rows);

		List<DateChangeData> list = pageObj.getData();
		DateChangeForm dateChangeForm = new DateChangeForm();
		dateChangeForm.setTotal(pageObj.getTotal() + "");
		List<DateChangeFormRow> rows = new ArrayList<DateChangeFormRow>();
		for (DateChangeData dateChangeData : list) {
			DateChangeFormRow row = new DateChangeFormRow();
			BeanUtils.copyProperties(dateChangeData, row);
			rows.add(row);
		}
		dateChangeForm.setRows(rows);
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor("yyyy-MM-dd"));
		renderJson(JsonUtils.convertObject(dateChangeForm, config));
	}

	@Action(value = "exportDateChange")
	public boolean exportDateChange() {
		
		HttpServletResponse response;
		try {
			String cardNo=super.getHttpServletRequest().getParameter("cardNo")==null?"":super.getHttpServletRequest().getParameter("cardNo");
			String insuretimebegin=super.getHttpServletRequest().getParameter("insuretimebegin")==null?"":super.getHttpServletRequest().getParameter("insuretimebegin");
			String insuretimeend=super.getHttpServletRequest().getParameter("insuretimeend")==null?"":super.getHttpServletRequest().getParameter("insuretimeend");
			Date startDate = null;
			Date endDate = null;
			DateChangeData changeData=new DateChangeData();
			changeData.setCardNo(cardNo);
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			if(insuretimebegin!=null && !insuretimebegin.equals("")){
				 startDate=format.parse(insuretimebegin);
				 changeData.setStarttime(startDate);
				 logger.info("证件有效期变更记录导出开始时间:"+insuretimebegin+"----"+startDate);
			 }
			 if(insuretimeend!=null && !insuretimeend.equals("")){
				 endDate=format.parse(insuretimeend);
				 changeData.setEndtime(endDate);
				 logger.info("证件有效期变更记录导出结束时间:"+insuretimeend+"----"+endDate);
			 }
			 List<DateChangeData> dateChangeDatas=dateChangeDataService.finList(changeData);
			 logger.info("dateChangeDatas--"+dateChangeDatas.size());
			response = getHttpServletResponse();
			 //导出excel文件的名字
			 String filename = "证件有效期变更记录_"+DateAndTime.getCurrentDateTime("yyyy-MM-dd");
			 response.setContentType("application/octet-stream");
			 
			 response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes("utf-8"), "iso8859-1")+".xls");
			 //创建Excel
			 HSSFWorkbook wb = new HSSFWorkbook();
			 //创建第一个sheet取名sheet0
			 HSSFSheet sheet = wb.createSheet("证件有效期变更列表");
			 //表头名称
			 String titles = "客户号,变更主体,证件类型,证件号码,证件有效期,证件图片（正）,证件图片（反）,变更时间"; 
			 //对应的数据库字段 (查询出的list)
			 String fields = "coustomerid,changeType,cardType,cardNo,expiredDate,front,contrary,updatetime";
			 ExportUtil.outputHeaders(titles.split(","), sheet);
			 ExportUtil.outputColumns(fields.split(","), dateChangeDatas, sheet, 1);
			 //获取输出流，写入excel 并关闭
			 ServletOutputStream out = response.getOutputStream();
			 wb.write(out);
			 out.flush();
			 out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
