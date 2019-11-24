package cn.com.sinosoft.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.impl.cookie.PublicSuffixListParser;
import org.apache.struts2.convention.annotation.Action;
import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosoft.common.service.axis.BasicQuery;
import cn.com.sinosoft.core.web.Struts2Action;
import cn.com.sinosoft.web.service.facade.ElectronicPolicyQueryService;
import cn.com.sinosoft.web.service.impl.ElectronicPolicyQueryServiceImpl;
import cn.com.sinosoft.web.util.FTPUtil;

public class DownloadPolicyFileAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	private final static Logger logger = LoggerFactory.getLogger(DownloadPolicyFileAction.class);
	
	private ElectronicPolicyQueryService ElectronicPolicy=new ElectronicPolicyQueryServiceImpl();
	
	HttpServletRequest request = super.getHttpServletRequest();
	
	private String policyNum = request.getParameter("policyNum");//保单号
	
	@Action(value = "downloadPolicy")
	public void downloadPolicy() throws UnsupportedEncodingException{
		
	String ProductCode=request.getParameter("product");//getPolicyBasic action set 产品编码
	
	String productName=request.getParameter("name");//险种名称
	
	String policytime=request.getParameter("policytime");//保单时间是2016年八月4号12点之前为N，之后为Y
	
	String filepath=request.getParameter("filepath");//电子保单路径
	
	String pdfname = request.getParameter("pdf");//pdf文件名
//	String filepath="/gzl111/20160607/1815156A-044D-7947-A41D-7ED9CA368CDC.Eml";//电子保单路径
	
	if(filepath!=null&&filepath.length()>0){
		logger.info("电销电子保单路径"+filepath);
		try {
		//连接电销ftp，根据邮件路径查找eml文件,下载并解析pdf到本地服务器
			logger.info("险种名"+productName);
//		productName = new String(productName.getBytes("ISO-8859-1"),"UTF-8");
//		logger.info("险种名1"+productName);
		ElectronicPolicy.QueryElectronicPolicy(filepath,policyNum,productName,policytime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else{
		logger.info("电销无此电子保单，从核心查找	");
			//走核心接口查相应的pdf
			byte[] pdf=null;
			byte[] Cashpdf=null;
			if(ProductCode.equals("WENJIAXING")){
				pdf = ElectronicPolicy.getPDF(policyNum,"PD00000086");
				if(pdf!=null&&pdf.length>0){
					request.setAttribute("validate", "N");
					ElectronicPolicy.writeFile(pdf, "Epolicy",policyNum);
				}
			}
			else if(ProductCode.equals("UVRUILI-1")){
				pdf = ElectronicPolicy.getPDF(policyNum,"PD00000085");
				if(pdf!=null&&pdf.length>0){
					request.setAttribute("validate", "N");
					ElectronicPolicy.writeFile(pdf, "Epolicy",policyNum);
				}
			}
			else if(ProductCode.equals("UVRUILI-N")){
				pdf = ElectronicPolicy.getPDF(policyNum,"PD00000116");
				if(pdf!=null&&pdf.length>0){
					request.setAttribute("validate", "N");
					ElectronicPolicy.writeFile(pdf, "Epolicy",policyNum);
				}
			}
			else if(ProductCode.equals("UVRUILI-2")){
				pdf = ElectronicPolicy.getPDF(policyNum,"PD00000123");
				if(pdf!=null&&pdf.length>0){
					request.setAttribute("validate", "N");
					ElectronicPolicy.writeFile(pdf, "Epolicy",policyNum);
				}
			}
			else if(ProductCode.equals("TAWENKB-R")){
				pdf = ElectronicPolicy.getPDF(policyNum,"PD00000100");
				if(pdf!=null&&pdf.length>0){
					request.setAttribute("validate", "N");
					ElectronicPolicy.writeFile(pdf, "Epolicy",policyNum);
				}
			}
			else if(ProductCode.equals("HEALTHGD")){
				pdf = ElectronicPolicy.getPDF(policyNum,"PD00000112");
				if(pdf!=null&&pdf.length>0){
					request.setAttribute("validate", "N");
					ElectronicPolicy.writeFile(pdf, "Epolicy",policyNum);
				}
			}
			else if(ProductCode.equals("UVZHISNG-2")){
				pdf = ElectronicPolicy.getPDF(policyNum,"PD00000096");
				if(pdf!=null&&pdf.length>0){
					request.setAttribute("validate", "N");
					ElectronicPolicy.writeFile(pdf, "Epolicy",policyNum);
				}
			}
			else if(ProductCode.equals("JINGZHIRS")){
				pdf = ElectronicPolicy.getPDF(policyNum,"PD00000119");
				if(pdf!=null&&pdf.length>0){
					request.setAttribute("validate", "N");
					ElectronicPolicy.writeFile(pdf, "Epolicy",policyNum);
				}
			}
			else if(ProductCode.equals("SLELI-D")){
				pdf = ElectronicPolicy.getPDF(policyNum,"PD00000122");
				if(pdf!=null&&pdf.length>0){
					request.setAttribute("validate", "N");
					ElectronicPolicy.writeFile(pdf, "Epolicy",policyNum);
				}
			}
			else if(ProductCode.equals("JINGYINGRS")){
				pdf = ElectronicPolicy.getPDF(policyNum,"PD00000128");
				if(pdf!=null&&pdf.length>0){
					request.setAttribute("validate", "N");
					ElectronicPolicy.writeFile(pdf, "Epolicy",policyNum);
				}
			}
			if(ProductCode.equals("WENJIAXING")||ProductCode.equals("TAWENKB-R")||ProductCode.equals("JINGZHIRS")||ProductCode.equals("JINGYINGRS")){
				Cashpdf=ElectronicPolicy.getPDF(policyNum, "PD00000006");
				if(Cashpdf!=null||Cashpdf.length>0){
					ElectronicPolicy.writeFile(Cashpdf, "XCEW",policyNum);
				}
			}else if(ProductCode.equals("UVRUILI-1")||ProductCode.equals("UVRUILI-N")||ProductCode.equals("UVRUILI-2")||ProductCode.equals("UVZHISNG-2")){
				Cashpdf = ElectronicPolicy.getPDF(policyNum, "PD00000008");
				if(Cashpdf!=null||Cashpdf.length>0){
					ElectronicPolicy.writeFile(Cashpdf, "Ksecret",policyNum);
				}
			}
			if(request.getAttribute("validate")!="N"){
				logger.info("核心无此电子保单");
			}
			
		}

	HttpServletResponse response = getHttpServletResponse();
	HttpServletRequest request = super.getHttpServletRequest();
	OutputStream outputStream = null;
	InputStream inputStream = null;
	String localpath=null;
	String pdf=null;
//	String policyNum = (String) request.getSession().getAttribute("basic");
	pdf = new String(request.getParameter("pdf").getBytes("ISO-8859-1"),"UTF-8");//保单名
	// 获取接口里的电子保单，判断列表上面的数据，接口里是否存在true可以查看过下载
	try {
		localpath = FTPUtil.getFtpProperties("localpath");//文件路径不包括文件
		logger.info("文件路径"+localpath);
	} catch (IOException e1) {
		e1.printStackTrace();
	}
	pdf = pdf.replace("-","+");//“+”号程序会解码为空格，用“-”传值替换
	String filename = pdfname+".pdf";// 下载默认文件名
	String pathname = localpath+policyNum+"/"+filename;// 文件所在的路径，包括文件
	boolean isOnLine = true;
	File file = new File(pathname);
	logger.info("pathname:"+pathname);
	if (file.exists()){
		// 设置输出的格式
		response.setContentType("application/x-download");// 设置为下载application/x-download
		response.setContentType("application/octet-stream");
		logger.info("2");
		try {
			outputStream = response.getOutputStream();
			inputStream = new FileInputStream(file);
			byte[] buf = new byte[1024];
			int i = 0;
			logger.info("3");
			response.reset();
			logger.info("4");
			// 先在线查看，然后选择下载
				logger.info("5");
				URL u = new URL("file:///" + pathname);
				String contentType = u.openConnection().getContentType();
				response.setContentType(contentType);
				response.setHeader("Content-Disposition",
						"inline;filename=" + new String(filename.getBytes("UTF-8"), "iso-8859-1"));
			while ((i = inputStream.read(buf, 0, buf.length)) != -1) {
				outputStream.write(buf, 0, i);
				outputStream.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			logger.info("8");
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	}
//	/**
//	 * 打开并下载pdf
//	 * @throws UnsupportedEncodingException
//	 */
//	public void openDownloadPDF() throws UnsupportedEncodingException{}
}
