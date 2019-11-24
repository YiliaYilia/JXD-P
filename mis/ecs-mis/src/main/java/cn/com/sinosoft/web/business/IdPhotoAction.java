package cn.com.sinosoft.web.business;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
import cn.com.sinosoft.domain.sell.IdPhotoData;
import cn.com.sinosoft.dto.sell.IdPhotoDto;
import cn.com.sinosoft.dto.sell.IdPhotoDto.IdPhotoRow;
import cn.com.sinosoft.product.service.IdPhotoService;

public class IdPhotoAction extends Struts2Action{
	
	private static final long serialVersionUID = 1L;
	
	public static Logger logger = LoggerFactory.getLogger(IdPhotoAction.class);
	
	@Autowired
	IdPhotoService idPhotoService;
	
	private IdPhotoData idPhotoData;

	@Action(value="idPhoto")
	public String idPhotoHome(){
		logger.info("证件照查询页面跳转成功");
		return "/page/idPhoto";
	}
	
	@Action(value="getIdData")
	public void getIdData(){
		logger.info("证件照查询开始加载");
		Page<IdPhotoData> pageObj = idPhotoService.findList(idPhotoData, page, rows);
		List<IdPhotoData> list = pageObj.getData();
		IdPhotoDto idPhotoDto = new IdPhotoDto();
		idPhotoDto.setTotal(pageObj.getTotal() + "");
		List<IdPhotoRow> rows = new ArrayList<IdPhotoRow>();
		for (IdPhotoData idPhotoData : list) {
			IdPhotoRow row = new IdPhotoRow();
			BeanUtils.copyProperties(idPhotoData, row);
			rows.add(row);
		}
		idPhotoDto.setRows(rows);
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor("yyyy-MM-dd"));
		renderJson(JsonUtils.convertObject(idPhotoDto, config));
		logger.info("证件照查询完成");
	}
	
	@Action(value = "exportIdPhoto")
	public void exportIdPhoto(){
		try {
			HttpServletResponse response = getHttpServletResponse();
			String proposalContNo = super.getHttpServletRequest().getParameter("proposalContNo")==null?"":super.getHttpServletRequest().getParameter("proposalContNo");
			String startTime = super.getHttpServletRequest().getParameter("startTime")==null?"":super.getHttpServletRequest().getParameter("startTime");
			String endTime = super.getHttpServletRequest().getParameter("endTime")==null?"":super.getHttpServletRequest().getParameter("endTime");
			String ids = super.getHttpServletRequest().getParameter("IDs")==null?"":super.getHttpServletRequest().getParameter("IDs");
			Date startDate = null;
			Date endDate = null;
			List<IdPhotoData> IdPhotoDatas = new ArrayList<IdPhotoData>();
			IdPhotoData photoData = new IdPhotoData();
			//判断没有勾选数据
			if("".equals(ids) || ids==null){
				photoData.setProposalContNo(proposalContNo);
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				if(startTime!=null && !startTime.equals("")){
					startDate=format.parse(startTime);
					photoData.setStarttime(startDate);
				}
				if(endTime!=null && !endTime.equals("")){
					endDate=format.parse(endTime);
					photoData.setEndtime(endDate);
				}
				IdPhotoDatas = idPhotoService.findAllIdPhoto(photoData);
			}else{//有勾选数据导出勾选
				if(ids.contains(",")){
					//勾选多条
					String[] id = ids.split(",");
					for(int i=0;i<id.length;i++){
						photoData.setId(id[i]);
						List<IdPhotoData> idPhotoDatass = idPhotoService.findAllIdPhoto(photoData);
						IdPhotoDatas.add(idPhotoDatass.get(0));
					}
				}else{
					//勾选1条
					photoData.setId(ids);
					IdPhotoDatas = idPhotoService.findAllIdPhoto(photoData);
				}
			}
			//编码替换为汉字
			for(IdPhotoData a : IdPhotoDatas){
				a.setApplicantInsured_idType(codeToName(a.getApplicantInsured_idType(), "IDTYPE"));
				a.setRecognizee_idType(codeToName(a.getRecognizee_idType(),"IDTYPE"));
			}
			//导出excel文件的名字
			String filename = "证件照_"+DateAndTime.getCurrentDateTime("yyyy-MM-dd");
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes("utf-8"), "iso8859-1")+".xls");
			//创建Excel
			HSSFWorkbook wb = new HSSFWorkbook();
			//创建第一个sheet取名sheet0
			HSSFSheet sheet = wb.createSheet("证件照");
			//表头名称
			String titles = "投保单号,产品名称,投保人姓名,投保人证件类型,投保人证件号码,投保人证件有效期,投保人证件照（正）,投保人证件照（反）,被保人姓名,被保人证件类型,被保人证件号码,被保人证件有效期,被保人证件照（正）,被保人证件照（反）,上传时间"; 
			//对应的数据库字段 (查询出的list)
			String fields = "proposalContNo,policyCode,applicantInsured_name,applicantInsured_idType,applicantInsured_IdNo,applicantInsured_endTime,applicantInsured_frontal,applicantInsured_reverse,recognizee_name,recognizee_idType,recognizee_IdNo,recognizee_endTime,recognizee_frontal,recognizee_reverse,uploadTime";
			ExportUtil.outputHeaders(titles.split(","), sheet);
			ExportUtil.outputColumns(fields.split(","), IdPhotoDatas, sheet, 1);
			//获取输出流，写入excel 并关闭
			ServletOutputStream out = response.getOutputStream();
			wb.write(out);
			out.flush();
			out.close();
			logger.info("证件照导出Excel完成--开始时间:"+startTime+"--结束时间:"+endTime+"--投保单号:"+proposalContNo+"--ids:"+ids);
		} catch (Exception e) {
			logger.error("证件照导出异常");
			e.printStackTrace();
		}
	}
	
	
	@Action(value = "exportIdPhotoToZip")
	public void exportIdPhotoToZip(){
		
		HttpServletResponse response = getHttpServletResponse();
		String ids = super.getHttpServletRequest().getParameter("IDs")==null?"":super.getHttpServletRequest().getParameter("IDs");
		logger.info("证件照图片开始下载"+ids);
		String[] files = null ;
		List<IdPhotoData> IdPhotoDatas = new ArrayList<IdPhotoData>();
		IdPhotoData photoData = new IdPhotoData();
		if(ids != null && !"".equals(ids)){
			photoData.setId(ids);
			IdPhotoDatas = idPhotoService.findAllIdPhoto(photoData);
		}
		if(IdPhotoDatas.size() == 1){
			String applicantInsured_frontal = IdPhotoDatas.get(0).getApplicantInsured_frontal();//投保人证件照(正)
			String applicantInsured_reverse = IdPhotoDatas.get(0).getApplicantInsured_reverse();//投保人证件照(反)
			String recognizee_frontal = IdPhotoDatas.get(0).getRecognizee_frontal();		//被保人证件照(正)
			String recognizee_reverse = IdPhotoDatas.get(0).getRecognizee_reverse();		//被保人证件照(反)
			files = new String[]{applicantInsured_frontal,applicantInsured_reverse,recognizee_frontal,recognizee_reverse};
			try {
	        	String downloadFilename = IdPhotoDatas.get(0).getProposalContNo()+".zip";//文件的名称
	        	downloadFilename = URLEncoder.encode(downloadFilename, "UTF-8");//转换中文否则可能会产生乱码
	        	response.setContentType("application/octet-stream");// 指明response的返回对象是文件流 
	        	response.setHeader("Content-Disposition", "attachment;filename=" + downloadFilename);// 设置在下载框默认显示的文件名
	        	ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
	        	for (int i=0;i<files.length;i++) {
	                URL url = new URL(files[i]);
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
	             logger.info("证件照图片下载完成"+downloadFilename);
	         } catch (UnsupportedEncodingException e) {
	             e.printStackTrace();
	         } catch (IOException e) {
	             e.printStackTrace();
	         } 
		}
	}
	
	
	String codeToName(String code , String Type){
		if("IDTYPE".equals(Type)){
			if("I".equals(code)){
				return "身份证";
			}else if("P".equals(code)){
				return "护照";
			}else if("S".equals(code)){
				return "军官证/士兵证";
			}else if("M".equals(code)){
				return "回乡证";
			}else if("O".equals(code)){
				return "户口簿";
			}else if("H".equals(code)){
				return "港澳通行证";
			}else if("T".equals(code)){
				return "台胞证";
			}		
		}
		return code;
	}
	
	public IdPhotoData getIdPhotoData() {
		return idPhotoData;
	}

	public void setIdPhotoData(IdPhotoData idPhotoData) {
		this.idPhotoData = idPhotoData;
	}
}
