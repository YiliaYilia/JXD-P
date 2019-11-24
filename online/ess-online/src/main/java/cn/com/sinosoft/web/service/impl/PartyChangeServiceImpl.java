package cn.com.sinosoft.web.service.impl;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import cn.com.sinosoft.common.service.axis.*;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.jmx.snmp.Timestamp;

import cn.com.sinosoft.domain.user.DateChangeData;
import cn.com.sinosoft.web.service.facade.DateChangeDataService;
import cn.com.sinosoft.web.service.facade.PartyChangeService;
import cn.com.sinosoft.web.util.TrustAnyHostnameVerifier;
import cn.com.sinosoft.web.util.TrustAnyTrustManger;

@Service
public class PartyChangeServiceImpl implements PartyChangeService {

	private static Log logger = LogFactory.getLog(PartyChangeServiceImpl.class);
	@Autowired
	DateChangeDataService dateChangeDataService;

	/*
	 * 调用核心进行微信信息查询
	 * @param CoustomerId 客户号
	 * @return 接口返回对象
	 * */
	public PartyChangeModel WeChatQuery(String customerId){
		PolicyWeChatQueryLocator service = new PolicyWeChatQueryLocator();
		PartyChangeModel result  = new PartyChangeModel();
		try{
			PolicyWeChatQueryPortType portType = service.getPolicyWeChatQueryHttpSoap11Endpoint();
			result = portType.getPartyInfo(customerId);
		}catch(Exception e){
			logger.error("个人信息变更异常",e);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 个人信息变更
	 * @param pcm 个人信息实体
	 * @return 接口返回对象
	 */
	public PartyChangeReturnModel PartyChange(PartyChangeModel pcm){
		PartyChangeLocator service = new PartyChangeLocator();
		PartyChangeReturnModel result  = new PartyChangeReturnModel();
		try{
			PartyChangePortType portType = service.getPartyChangeHttpSoap11Endpoint();
			result = portType.getPartyChangeDetail(pcm);
		}catch(Exception e){
			logger.error("个人信息变更异常",e);
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 个人信息查询
	 * @param policyNum 保单号
	 * @return 接口返回对象
	 */
	public RoleQueryModel RoleQuery(String policyNum){
		 RoleQueryLocator service = new RoleQueryLocator();
		 RoleQueryModel result = new RoleQueryModel();
			try{
				RoleQueryPortType portType = service.getRoleQueryHttpSoap11Endpoint();
				result = portType.getRoleQueryInformation(policyNum);
			}catch(Exception e){
				logger.error("个人信息查询异常",e);
			}
			return result;
	 }
	
	
	
	public static void main(String[] args) {
		PartyChangeServiceImpl test  = new PartyChangeServiceImpl();
		test.RoleQuery("SK00001933");
	}

	@Override
	public CRSInterfaceModel dealPartyTaxType(String partyCode, String taxType,
			String operate, String callBy,String country) {
		PartyChangeLocator service = new PartyChangeLocator();
		CRSInterfaceModel result  = new CRSInterfaceModel();
		try{
			PartyChangePortType portType = service.getPartyChangeHttpSoap11Endpoint();
			result = portType.dealPartyTaxType(partyCode,taxType,operate,callBy,country);
		}catch(Exception e){
			logger.error("个人信息变更异常",e);
			e.printStackTrace();
		}
		return result;
	}
	
	public String identityOCR(String partyCode, String partyType,String cardNo, String type,
			MultiPartRequestWrapper req, String identityOCRUrl, String identityImageTempPath){ 
		Map retMap = new HashMap();
		String mediaPath = null;
		Enumeration<String> fileParameterNames = req.getFileParameterNames();
		while(fileParameterNames != null && fileParameterNames.hasMoreElements()){
			String inputName = (String) fileParameterNames.nextElement();
			String[] contentType = req.getContentTypes(inputName);
			if(contentType != null && contentType.length != 0){
				String[] fileNames = req.getFileNames(inputName);
				if(fileNames != null && fileNames.length != 0){
					String fileName=fileNames[0];
	                String fileExt = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
	                File file = req.getFiles(inputName)[0];
		        	String ret = submitOCRPost(identityOCRUrl,file);
		        	JSONObject json = JSONObject.fromObject(ret);
		        	logger.info("旷世OCR返回结果："+json.toString());
		        	if(type != null && "front".equals(type)){
		        		if(json.get("side") !=null && "front".equals(json.get("side")) 
			        			&& json.get("id_card_number") !=null && !"".equals(json.get("id_card_number"))){//识别结果为身份证正面
		        			if("pol".equals(partyType) || "lifeAssd".equals(partyType)){//投保人或被保险人
		        				if(json.get("id_card_number").equals(cardNo)){//证件号一致
				        			retMap.put("message", "OCR识别成功，上传的影像与投保时投保人（或被保险人）的身份证一致");
					        		retMap.put("flag", "0");
				        		}else{//证件号不一致
				        			retMap.put("message", "上传的影像必须为您投保时投保人（或被保险人）的身份证，请重新操作");
					        		retMap.put("flag", "1");
				        		}
		        			}else if("benfic".equals(partyType)){//身故受益人
		        				if(json.get("id_card_number").equals(cardNo)){//证件号一致
				        			retMap.put("message", "OCR识别成功，上传的影像与身故受益人身份证一致");
					        		retMap.put("flag", "0");
				        		}else{//证件号不一致
				        			retMap.put("message", "上传的影像必须为身故受益人的身份证，请重新操作");
					        		retMap.put("flag", "1");
				        		}
			            	}
			        	}else{//识别结果为身份证背面或不为身份证
			        		retMap.put("message", "上传的影像必须为身份证，请重新操作");
			        		retMap.put("flag", "-1");
			        	}
	        		}else if(type != null && "contrary".equals(type)){
	        			String validDate = json.getString("valid_date");
	        			if(json.get("side") !=null && "back".equals(json.get("side")) 
			        			&& validDate !=null && !"".equals(validDate) 
			        			&& json.get("issued_by") !=null && !"".equals(json.get("issued_by"))){//识别结果为身份证背面
		        			validDate = validDate.split("-")[1];
		        			if("长期".equals(validDate)){
		        				retMap.put("year", "9999");
			        			retMap.put("month", "12");
			        			retMap.put("day", "31");
		        			}else{
		        				retMap.put("year", validDate.split("\\.")[0]);
			        			retMap.put("month", Integer.parseInt(validDate.split("\\.")[1]));
			        			retMap.put("day", Integer.parseInt(validDate.split("\\.")[2]));
		        			}
			        		retMap.put("message", "OCR识别成功，识别结果为身份证背面");
			        		retMap.put("flag", "0");
			        	}else{//识别结果为身份证正面或不为身份证
			        		retMap.put("message", "上传的影像必须为身份证，请重新操作");
			        		retMap.put("flag", "-1");
			        	}
		        	}
		        	if(retMap.get("flag") != null && "0".equals(retMap.get("flag"))){
		        		String newFileName = System.currentTimeMillis() + "." + fileExt;
			            try{
			            	identityImageTempPath = identityImageTempPath + "IdentityImageTemp/"; //文件存储位置
			                File uploadedFile = new File(identityImageTempPath, newFileName);
			                mediaPath = identityImageTempPath + newFileName;
			                if(!uploadedFile.isFile()){
			                    uploadedFile.createNewFile();
			                }
			                byte[] buffer = new byte[1024];
			                FileOutputStream fos = new FileOutputStream(uploadedFile);
			                InputStream in = new FileInputStream(file);
			                int num = 0;
			                while((num = in.read(buffer))>0){
			                    fos.write(buffer, 0, num);
			                }
			                in.close();
			                fos.close(); 
			                if(type.equals("front")){
			                	retMap.put("mediaPathFront", newFileName);
			                }else if(type.equals("contrary")){
			                	retMap.put("mediaPathContrary", newFileName);
			                }
			            }catch (Exception e){
			            	logger.error(e.getMessage());
			            	retMap.put("message", "无法识别图片内容，请重新上传");
			            	retMap.put("flag", "-1");
			            	logger.info(JSONObject.fromObject(retMap).toString());
			            	return JSONObject.fromObject(retMap).toString();
		                }
		        	}
				}
			}
		}
		logger.info(JSONObject.fromObject(retMap).toString());
		return JSONObject.fromObject(retMap).toString();
	}
	
	public Boolean copyPicture(String oldFilePath, String newFilePath, String filePath){
		oldFilePath = filePath + "IdentityImageTemp/" + oldFilePath;
		newFilePath = filePath + "IdentityImage/" + newFilePath;
		File oldFile = new File(oldFilePath);
		File newFile = new File(newFilePath);
		try {
			InputStream in = new FileInputStream(oldFile);
			FileOutputStream out = new FileOutputStream(newFile);
			byte[] buffer = new byte[1024];
            int num = 0;
            while((num = in.read(buffer))>0){
                out.write(buffer, 0, num);
            }
            in.close();
            out.close(); 
            return true;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
	}
	public String savePicture(String partyCode, String partyType,String cardNo, String type,String filePath,
			MultiPartRequestWrapper req){ 
		String mediaPath = null;
		Enumeration<String> fileParameterNames = req.getFileParameterNames();
		while(fileParameterNames != null && fileParameterNames.hasMoreElements()){
			String inputName = (String) fileParameterNames.nextElement();
			String[] contentType = req.getContentTypes(inputName);
			if(contentType != null && contentType.length != 0){
				String[] fileNames = req.getFileNames(inputName);
				if(fileNames != null && fileNames.length != 0){
					String fileName=fileNames[0];
	                String fileExt = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
	                File file = req.getFiles(inputName)[0];
	                String newFileName;
	                if(cardNo != null && !"".equals(cardNo)){
	                	newFileName = partyCode + "_" + partyType + "_" + cardNo+"_" + type+"." + fileExt;
	                }else{
	                	newFileName = partyCode + "_" + partyType +"_" + type+"." + fileExt;
	                }
	                try{
	                	filePath = filePath + "IdentityImage"; //文件存储位置
	                    File uploadedFile = new File(filePath, newFileName);
	                    mediaPath = filePath + newFileName;
	                    if(!uploadedFile.isFile()){
	                        uploadedFile.createNewFile();
	                    }
	                    byte[] buffer = new byte[1024];
	                    FileOutputStream fos = new FileOutputStream(uploadedFile);
	                    InputStream in = new FileInputStream(file);
	                    int num = 0;
	                    while((num = in.read(buffer))>0){
	                        fos.write(buffer, 0, num);
	                    }
	                    in.close();
	                    fos.close(); 
		        		/*DateChangeData dateChangeData = new DateChangeData();
	        			dateChangeData.setCoustomerid(partyCode);//设置主键
	        			if(type.equals("front")){
	        				dateChangeData.setFront(mediaPath);
	        			}else if(type.equals("contrary")){
	        				dateChangeData.setContrary(mediaPath);
	        			}
	        			dateChangeDataService.saveImagePath("coustomerid",partyCode,dateChangeData,type);*/
	                }catch (Exception e){
	                	logger.error(e.getMessage());
		        		
	                }
				}
			}
		}
		return mediaPath;
	}
	
	private String submitOCRPost(String url, File file){
		DataOutputStream out = null;
		BufferedReader in = null;
		String result = "";
		try{
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, new TrustManager[]{new TrustAnyTrustManger()},  new SecureRandom());
			URL realUrl = new URL(url);
			HttpsURLConnection conn = (HttpsURLConnection) realUrl.openConnection();
			conn.setSSLSocketFactory(sc.getSocketFactory());
			conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
			conn.setDoOutput(true);
			conn.setDoInput(true);
			String BOUNDARY = "-----------7d4a6d158c9";//定义数据分割线
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/5.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			conn.setRequestProperty("Charsert", "UTF-8");
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
			conn.connect();
			out = new DataOutputStream(conn.getOutputStream());
			byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();//定义最后数据分割线
			
			StringBuffer sb = new StringBuffer();
			sb.append("--");
			sb.append(BOUNDARY);
			sb.append("\r\n");
			sb.append("Content-Disposition: form-data; name=\"image\";filename=\""+file.getName()+"\"");
			sb.append("\r\n");
			sb.append("Content-Type:application/octet-stream");
			sb.append("\r\n");
			sb.append("\r\n");
			out.write(sb.toString().getBytes());
			
			DataInputStream in1 = new DataInputStream(new FileInputStream(file));
			int bytes = 0;
			byte[] bufferOut = new byte[1024];
			while((bytes = in1.read(bufferOut)) != -1){
				out.write(bufferOut,0,bytes);
			}
			in1.close();
			out.write(endData);
			out.flush();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String line;
			while((line = in.readLine()) != null){
				result += line;
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try {
				if(out != null){
					out.close();
				}
				if(in != null){
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Map<String, String> expiredDateCheck(String partyCode) {
		Map<String, String> retMap = new HashMap<String, String>();
		//查询该客户证件有效期是否过期或为空
		PartyChangeModel partyChangeModel = this.WeChatQuery(partyCode);
		String expiredDate = partyChangeModel.getExpiredDate();
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		try {
			if(expiredDate != null 
					&& !"".equals(expiredDate) 
					&& !"null".equals(expiredDate) 
					&& (df.parse(expiredDate).getTime()-(df.parse(df.format(new Date())).getTime()))>=0){
				//证件有效期不为空且有效
				retMap.put("code", "0");
				retMap.put("message", "证件有效期有效");
			}else{
				//证件有效期为空或失效，则先进行证件有效期变更
				String cardNo = partyChangeModel.getIdNo();
				String cardType = partyChangeModel.getIdType();
				retMap.put("partyType", "pol");
				retMap.put("partyCode", partyCode);
				retMap.put("cardNo", cardNo);
				retMap.put("cardType", cardType);
				retMap.put("expiredDate", expiredDate);
				retMap.put("code", "1");
				retMap.put("message", "您的证件有效期已过期或未填写证件有效期，请先在瑞泰人寿保险有限公司微信公众号中更新您的证件有效期，详询4008109339。");
			}
		} catch (Exception e) {
			logger.error("expiredDateCheckByOpenId异常：",e);
			retMap.put("code", "-1");
			retMap.put("message", "证件有效期校验异常。如需帮助请致电客服专线4008109339");
		}
		return retMap;
	}
}
