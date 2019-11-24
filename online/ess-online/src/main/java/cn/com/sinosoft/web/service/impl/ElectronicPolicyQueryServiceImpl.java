package cn.com.sinosoft.web.service.impl;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.common.service.axis.DownLoadDocLocator;
import cn.com.sinosoft.common.service.axis.DownLoadDocPortType;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.GE_ProductcodeOTM;
import cn.com.sinosoft.web.service.facade.ElectronicPolicyQueryService;
import cn.com.sinosoft.web.util.FTPUtil;
import cn.com.sinosoft.web.util.jdbcUtil;

@Component
public class ElectronicPolicyQueryServiceImpl extends  GenericHibernateDao<GE_ProductcodeOTM, String> implements ElectronicPolicyQueryService {
	private static final String String = null;
	private  static Logger log = LoggerFactory.getLogger(ElectronicPolicyQueryServiceImpl.class);
	@Override
	public void QueryElectronicPolicy(String filepath,String policyNo,String productName,String policytime) throws Exception {
			boolean DownLoadFile=false;
			String ip= FTPUtil.getFtpProperties("ip");
			String username=FTPUtil.getFtpProperties("username");
			String userpwd=FTPUtil.getFtpProperties("userpwd");
			String port=FTPUtil.getFtpProperties("port");
			String localpath=FTPUtil.getFtpProperties("localpath");
			int  intport = Integer.valueOf(port);
			String[] split = filepath.split("/|\\.");
			int length = split.length;
			String path = split[2];//拆分的文件目录
			String filename=split[3];//拆分的目录下文件名
			String suffix = split[4];//文件后缀
			DownLoadFile=FTPUtil.getFTPConnecTionDownLoadFile(ip, intport, username, userpwd, path, localpath, filename,policyNo);//连接ftp,并下载eml到本地服务器
			if(DownLoadFile){//下载成功返回true才能解析
				log.info("解析eml");
				FTPUtil.parserFile(localpath,filename,policyNo,productName,policytime);//解析eml
			}
	}
	
	@Override
	public void delete(){
		log.info("定时删除电子保单");
		String localpath=null;
		try {
			localpath = FTPUtil.getFtpProperties("localpath");
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file=new File(localpath);
		if(!file.exists()){
			log.info("路径不存在");
		}
		if(!file.isDirectory()){
			log.info("目录有误");
		}
		String[] list = file.list();
		if(list.length==0){
			log.info("文件夹内为空");
		}
		File temp=null;
		for(int i=0;i<list.length;i++){
			String filecode = (String)System.getProperties().get("file.encoding");
			log.info("文件编码"+filecode);
				temp=new File(file+"/"+list[i]);
				log.info("temp"+temp);
			if(temp.isFile()){
				log.info("删除"+list[i]);
				temp.delete();
			}
		}
	}
	/**
	 * 功能：从核心获取pdf byte流
	 */
	@Override
	public byte[] getPDF(String policyNo,String PrintID) {
		DownLoadDocLocator service=new DownLoadDocLocator();
		byte[] pdf=null;
		try {
			DownLoadDocPortType downLoad = service.getDownLoadDocHttpSoap11Endpoint();
			pdf = downLoad.getDoc(policyNo, PrintID);//从核心获取电子保单byte流
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return pdf;
	}
	/**
	 * 功能：获取电销pdf路径
	 */
	@Override
	public String getDOCUMENTPATH(String policyNo) {
		Connection connection = jdbcUtil.getconnection();
		policyNo="'"+policyNo+"'";
		 String sql="select DOCUMENTOUT.DOCUMENTPATH from DOCUMENTOUT where DOCUMENTOUT.STRINGFIELD1="+policyNo+"order by DOCUMENTOUT.CREATEDDATE desc" ;
		 String path=null;
		 String pathfirst=null;
		 try {
			Statement Statement = connection.createStatement();
			ResultSet result = Statement.executeQuery(sql);
			while (result.next()) {
				path = result.getString(1);
				if(result.getRow()==1){
					pathfirst=path;
				}
			}
			log.info(pathfirst);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pathfirst;
	}
	/**
	 * 功能：将电子保单写入本地服务器
	 */
	@Override
	public void writeFile(byte pdf[], String pdfname,String policyNO) {
		FileOutputStream out=null;
		try {
			String localpath= FTPUtil.getFtpProperties("localpath");
			File file=new File(localpath+policyNO);
			if(!file.exists()||!file.isDirectory()){//文件路径,如果目录不存在则创建
				file.mkdir();
				log.info("创建目录："+file);
				}
			log.info("从核心获取pdf写入:"+file+"/"+pdfname+".pdf");
		    out=new FileOutputStream(file+"/"+pdfname+".pdf");
			for(int i=0;i<pdf.length;i++){
					out.write(pdf[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			log.error("IO异常");
			e.printStackTrace();
	}
		finally{
			if(out!=null){
				try {
					out.close();	
				} catch (IOException e) {
					log.error("关流失败");
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Date getDate(String policyNo) {
		Connection connection = jdbcUtil.getconnection();
		policyNo="'"+policyNo+"'";
		 String sql="select DOCUMENTOUT.CREATEDDATE from DOCUMENTOUT where DOCUMENTOUT.STRINGFIELD1="+policyNo;
		 Date time=null;
		 try {
			Statement Statement = connection.createStatement();
			ResultSet result = Statement.executeQuery(sql);
			while (result.next()) {
				time = result.getTimestamp(1);
				log.info("----"+time);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return time;
	}

	@Override
	public List<GE_ProductcodeOTM> findPdfnamebycode(String prodauctcode,String name,String path) {
		 QueryRule query = QueryRule.getInstance();
		 if(path!=null){
			 if(name.contains("健康之选")){
				 query.addEqual("code", "健康之选");
			 }else if(name.contains("安康之选")){
				 query.addEqual("code","安康之选");
			 }else if(name.contains("稳驾行")){
				 query.addEqual("code","稳驾行");
			 } else if(name.contains("安康B")){
			 query.addEqual("code","安康B");
		 }
		 }else{
			 query.addEqual("code", prodauctcode);
		 }
		return super.find(query);
	}


	

	
}
