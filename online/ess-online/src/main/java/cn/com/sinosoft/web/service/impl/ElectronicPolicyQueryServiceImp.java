/*package cn.com.sinosoft.web.service.impl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.LinkedHashSet;

import javax.ws.rs.DELETE;
import javax.xml.rpc.ServiceException;

import org.omg.Messaging.SyncScopeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.io.path.Path;

import cn.com.sinosoft.common.service.axis.DownLoadDocLocator;
import cn.com.sinosoft.common.service.axis.DownLoadDocPortType;
import cn.com.sinosoft.web.service.facade.ElectronicPolicyQueryService;
import cn.com.sinosoft.web.util.FTPUtil;
@Component
public class ElectronicPolicyQueryServiceImp implements ElectronicPolicyQueryService {
	private Logger log=LoggerFactory.getLogger(ElectronicPolicyQueryServiceImp.class);
	@Override
	public boolean QueryElectronicPolicy(String filename) throws Exception {
		boolean ConnecTion=false;
		boolean DownLoadFile=false;
		boolean parserFile=false;
		try {
			//获取Properties字段
			String ip= FTPUtil.getFtpProperties("ip");
			String username=FTPUtil.getFtpProperties("username");
			String userpwd=FTPUtil.getFtpProperties("userpwd");
			String port=FTPUtil.getFtpProperties("port");
			String file=FTPUtil.getFtpProperties("file");//ftp路径
			String localfile=FTPUtil.getFtpProperties("localfile");//本地路径
			int  intport = Integer.valueOf(port);
			ConnecTion=FTPUtil.getFTPConnecTion(ip,intport, username, userpwd);//连接ftp
			if(ConnecTion){
				DownLoadFile=FTPUtil.DownLoadFile(localfile, filename, file);//下载eml到本地
				if(DownLoadFile){
					parserFile=FTPUtil.parserFile(localfile, filename);//解析eml
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		FTPUtil.parserFile("E:\\eml", "123.eml");
		return DownLoadFile; 
	}
	
	@Override
	public void delete() {
		String localpath="E:\\eml\\";
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
			if(localpath.endsWith(file.separator)){
				temp=new File(file+"/"+list[i]);
			}
			if(temp.isFile()){
				log.info("删除"+list[i]);
				temp.delete();
			}
		}
	}

	@Override
	public byte[] getPDF(String policyNo) {
		DownLoadDocLocator service=new DownLoadDocLocator();
		try {
			DownLoadDocPortType downLoad= service.getDownLoadDocHttpSoap11Endpoint();
				byte[] pdf = downLoad.getDoc(policyNo, "PD00000085");
//				FileOutputStream OutputStream=new FileOutputStream("E:\\eml\\abc.pdf");
//				for(int i=0;i<pdf.length;i++){
//						try {
//							OutputStream.write(pdf[i]);
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//				}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	
	
	
}
*/