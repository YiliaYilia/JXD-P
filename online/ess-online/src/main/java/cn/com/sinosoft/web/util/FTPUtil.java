package cn.com.sinosoft.web.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpSession;

import sun.net.TelnetInputStream;
import sun.net.TelnetOutputStream;
import sun.net.ftp.FtpClient;

import org.apache.commons.lang.StringUtils;
//import org.apache.commons.net.ftp.FTPClient;
//import org.apache.commons.net.ftp.FTPClientConfig;
//import org.apache.commons.net.ftp.FTPFile;
//import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.parsing.FailFastProblemReporter;
import org.springframework.http.HttpRequest;



public class FTPUtil {
	private static Logger log = LoggerFactory.getLogger(FTPUtil.class);
	/**
	 * 功能：读取Properties配置文件
	 * @param  ftp
	 * @return ftp 配置文件类容 
	 * @throws IOException 
	 */
	public static String getFtpProperties(String ftp) throws IOException  {
		Properties properties = new Properties();
		properties.load(FTPUtil.class.getResourceAsStream("/config/FTP.properties"));
		return properties.getProperty(ftp);
	}
	
	/**
	 * 功能：连接Ftp服务器,下载指定文件到本地
	 * @param ip  		服务器名
	 * @param port		服务器端口
	 * @param username	登陆用户名
	 * @param userpwd   登陆密码
	 * @param localpath 本地路径
	 * @param filename  文件名
	 * @param path      Ftp访问路径
	 */
//	public static boolean getFTPConnecTionDownLoadFile(String ip,int port,String username,String userpwd,String path,String localpath,String filename,String policyNo){
//		 FTPClient ftpclient=new FTPClient();
//		 int reply;
//		 boolean success=false;
//		 String file=filename+".eml";
//		 
//		 try {
//			ftpclient.connect(ip,port);//连接
//			ftpclient.login(username, userpwd); //登陆
//			 // 看返回的值是不是230，如果是，表示登陆成功  
//			 reply = ftpclient.getReplyCode();  
//		  if(reply==230){
//			  log.info("登陆Ftp服务器"+ip+"成功");
//		  }
//			 // 以2开头的返回值就会为真  
//		  if (!FTPReply.isPositiveCompletion(reply)) {  
//			  ftpclient.disconnect();  
//			  log.info("连接服务器失败"); 
//		  }
//		  String s=System.getProperty("file.encoding"); 
//		  log.info("系统编码"+s);
//		  if(path!=null&&path.length()>0){
//			   //跳转到指定目录，并处理编码
//			   boolean changeWorkingDirectory = ftpclient.changeWorkingDirectory(new String(path.getBytes("GBK"),"iso-8859-1"));
//			 if(changeWorkingDirectory){
//				 log.info("跳转到FTP目录："+path+"成功");
//			 }else{
//				 log.info("跳转FTP目录："+path+"失败");
//			 }
//			 }
////		  ftpclient.enterLocalPassiveMode();
//		  FTPFile[] fs= ftpclient.listFiles();
//		  FTPFile[] fs= ftpclient.get("");
//				log.info("数组长度为"+fs.length);
//			for(FTPFile ff:fs){
//			  log.info("该路径下有以下文件："+ff.getName());
//			 if(ff.getName().equalsIgnoreCase(file)){//下载，如果文件存在则下载
//				 File locaFile=new File(localpath+policyNo);
//				 if(!locaFile.exists()||!locaFile.isDirectory()){
//					 locaFile.mkdir();
//					 log.info("创建目录:"+locaFile);
//				 }
//				 FileOutputStream fileOutputStream = new FileOutputStream(locaFile+"/"+file);
//				 log.info("从ftp下载"+filename+"到目录："+locaFile);
//				 ftpclient.retrieveFile(ff.getName(), fileOutputStream);
//				 fileOutputStream.close();
//				  success=true;
//			 }
//			}
//			 ftpclient.logout();
//		 } catch (SocketException e) {
//			log.error("连接服务器异常");
//			e.printStackTrace();
//		 } catch (IOException e) {
//			 log.info("io异常");
//			e.printStackTrace();
//		 };
//		 return success;
//	}
	
	
	
	/**
	 * 功能：连接Ftp服务器,下载指定文件到本地
	 * @param ip  		服务器名
	 * @param port		服务器端口
	 * @param username	登陆用户名
	 * @param userpwd   登陆密码
	 * @param localpath 本地路径
	 * @param filename  文件名
	 * @param path      Ftp访问路径
	 */
	public static boolean getFTPConnecTionDownLoadFile(String ip,int port,String username,String userpwd,String path,String localpath,String filename,String policyNo){
		FtpClient ftpclient=new FtpClient();
		 int reply;
		 boolean success=false;
		 String file=filename+".eml";
		 TelnetInputStream is = null;
	      FileOutputStream os = null;
		 try {
			ftpclient.openServer(ip,port);//连接
			ftpclient.login(username, userpwd); //登陆
			ftpclient.binary();
			log.info("连接成功");
			 if (path.length() != 0){
	           //把远程系统上的目录切换到参数path所指定的目录
			ftpclient.cd(path);
	            }
			ftpclient.binary();
		     //获取远程机器上的文件filename，借助TelnetInputStream把该文件传送到本地。
		            is = ftpclient.get(file);
		            log.info(file);
		           String locaFile=localpath+policyNo;
		           File f=new File(locaFile);
		            if(!f.exists()||!f.isDirectory()){
						 f.mkdir();
						 log.info("创建目录:"+locaFile);
					 }
		            File file_in = new File(localpath+policyNo+"/"+file);
		            log.info(localpath);
		            os = new FileOutputStream(file_in);
		            byte[] bytes = new byte[1024];
		            int c;
		            while ((c = is.read(bytes)) != -1) {
		                os.write(bytes, 0, c);
		            }
		            log.info("ftp下载成功");
		            success=true;
		        } catch (IOException ex) {
		            log.info("ftp下载失败");
		            ex.printStackTrace();
		            throw new RuntimeException(ex);
		        } finally{
		            try {
		                if(is != null){
		                    is.close();
		                }
		            } catch (IOException e) {
		                e.printStackTrace();
		            } finally {
		                try {
		                    if(os != null){
		                        os.close();
		                    }
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		            }
		        }
		 return success;
	}
	
	/**
	 * 功能：解析eml文件
	 * 如果eml为Multipart包裹,需要拆解为part,依次解析part内容
	 * @param loclpath本地路径
	 * @param filename文件名
	 * @return 
	 * @throws Exception
	 */
	public static void parserFile(String localpath,String filename,String policyNo,String productName,String policytime) throws Exception {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);//获取邮件收发Session会话
		File path=new File(localpath+policyNo+"/"+filename+".eml");//需要解析文件的所在路径，包含文件名
		InputStream inMsg = new FileInputStream(path);
		Message msg = new MimeMessage(session, inMsg);
		Object o = msg.getContent();
		if (o instanceof Multipart) {//如果是Multipart包裹型，拆解包裹为part,再解析内容
			log.info("Multipart包裹");
			Multipart multipart = (Multipart) o;
			reMultipart(multipart,localpath,policyNo,productName,policytime);
		} else if (o instanceof Part) { //如果为part,解析内容
			log.info("Part类型");
			Part part = (Part) o;
			rePart(part,localpath,policyNo,productName,policytime);
		} else {
			log.info("类型" + msg.getContentType()+"无法解析");
		}
		inMsg.close();
	}
	
	/**
	 * 功能：拆分eml包裹（含所有邮件内容(包裹+正文+附件)）
	 * @param multipart包裹
	 * @param path存储路径
	 * @param filename文件名
	 */
	private static void reMultipart(Multipart multipart,String localpath,String policyNo,String productName,String policytime) {
		 try {
			log.info("邮件共有" + multipart.getCount() + "部分组成");
			for (int j = 0, n = multipart.getCount(); j < n; j++) {
				log.info("处理第" + j + "部分");
				Part part = multipart.getBodyPart(j);// 解包, 取出 MultiPart的各个部分,
				// 每部分可能是邮件内容,也可能是另一个小包裹(MultipPart)
				// 判断此包裹内容是不是一个小包裹
					if (part.getContent() instanceof Multipart) {
						Multipart p = (Multipart) part.getContent();// 转成小包裹
						// 递归迭代
						reMultipart(p,localpath,policyNo,productName,policytime);
					} else {
						rePart(part,localpath,policyNo,productName,policytime);
					}
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *功能：解析eml附件(pdf),写入指定路径
	 * @param part
	 * @param path 存储路径
	 * @param filename 文件名
	 */
	private static void rePart(Part part,String localpath,String policyNo,String productName,String policytime) {
		InputStream in=null;
		FileOutputStream out=null;
		try {
			if (part.getDisposition() != null) {
				String strFileNmae = part.getFileName();
				if(!StringUtils.isEmpty(strFileNmae))
				{	// MimeUtility.decodeText解决附件名乱码问题
					strFileNmae=MimeUtility.decodeText(strFileNmae);
					log.info("发现附件: "+ strFileNmae);
					in = part.getInputStream();// 打开附件的输入流
					// 读取附件字节并存储到当前路径
					File file=new File(localpath+policyNo);
					if(!file.exists()||!file.isDirectory()){
						file.mkdir();
						log.info("创建目录："+file);
					}
//					productName="TM16523003";//測試用——————————————————————————
					log.info("存储到："+file+"/"+strFileNmae);
					log.info("-------"+productName);
					log.info("======="+productName.contains("稳驾行"));
					if(policytime.equals("N")){
							if(productName.contains("安康B")){//瑞泰安康之选医疗保障计划电子保单
								if(strFileNmae.equals("安康B封面+目录.pdf")){
									strFileNmae="Acover.pdf";
								}
								if(strFileNmae.equals("安康B条款.pdf")){
									strFileNmae="Aclause.pdf";
								}
								if(strFileNmae.equals("安康B投保提示.pdf")){
									strFileNmae="APrompt.pdf";
								}
								if(strFileNmae.equals("安康B投保须知+反洗钱+客服指南+封底.pdf")){
									strFileNmae="Ainsurance.pdf";
								}
							}
							else if(productName.contains("安康之选")){//瑞泰安康之选医疗保障计划电子保单
								if(strFileNmae.equals("安康之选封面+目录.pdf")){
									strFileNmae="Acover1.pdf";
								}
								if(strFileNmae.equals("安康之选条款.pdf")){
									strFileNmae="Aclause1.pdf";
								}
								if(strFileNmae.equals("安康之选投保提示.pdf")){
									strFileNmae="APrompt1.pdf";
								}
								if(strFileNmae.equals("安康之选投保须知+反洗钱+客服指南+封底.pdf")){
									strFileNmae="Ainsurance1.pdf";
								}
							}
						else if(productName.contains("健康之选")){//瑞泰健康之选C保障计划电子保单
							if(strFileNmae.equals("健康之选C反洗钱+投保须知+特别提示+客服指南+封底.pdf")){
								strFileNmae="Jinsurance.pdf";
							}
							if(strFileNmae.equals("健康之选C封面+目录.pdf")){
								strFileNmae="Jcover.pdf";
							}
							if(strFileNmae.equals("健康之选C条款.pdf")){
								strFileNmae="Jclause.pdf";
							}
							if(strFileNmae.equals("健康之选C投保提示.pdf")){
								strFileNmae="Jprompt.pdf";
							}
						}
						else if(productName.contains("稳驾行")){//瑞泰稳驾行两全保险电子保单
							if(strFileNmae.equals("稳驾行反洗钱+客服指南+封底.pdf")){
								strFileNmae="Winsurance.pdf";
							}
							if(strFileNmae.equals("稳驾行封面+目录.pdf")){
								strFileNmae="Wcover.pdf";
							}
							if(strFileNmae.equals("稳驾行投保提示.pdf")){
								strFileNmae="Wprompt.pdf";
							}
							if(strFileNmae.equals("稳驾行投保须知+条款.pdf")){
								strFileNmae="Wclause.pdf";
							}
						}
						if(strFileNmae.equals("保单正本.pdf")){
							strFileNmae="original.pdf";
						}
						if(strFileNmae.equals("授权书.pdf")){
							strFileNmae="book.pdf";
						}
						if(strFileNmae.equals("投保单.pdf")){
							strFileNmae="Ipolicy.pdf";
						}
						if(strFileNmae.equals("现金价值表.pdf")){
							strFileNmae="value.pdf";
						}
					}
					if(policytime.equals("Y")){
						if(strFileNmae.equals("瑞泰人寿电子保单.pdf")){
							strFileNmae="after20160804policy.pdf";
						}
					}
					out = new FileOutputStream(file+"/"+strFileNmae);
					int data;
					while ((data = in.read()) != -1) {
						out.write(data);
					}
				}
			} 
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {//关流
			try {
				if(out!=null){
					out.close();
				}
				if(in!=null){
					in.close();
				}
			} catch (IOException e) {
				log.info("关流失败");
				e.printStackTrace();
			}
		}
	}

	
}
