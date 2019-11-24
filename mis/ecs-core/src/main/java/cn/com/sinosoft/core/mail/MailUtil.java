package cn.com.sinosoft.core.mail;

import java.io.File;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.*;



/**描述：邮件工具类<br>
 * 作者：yangqidu <br>
 * 修改日期：2013年12月30日<br>
 */
public class MailUtil {
	private static String host_url = "";
	private static String mail_url = "";
	private static String port = "";
	private static String protocol = "";
	//private static String username = "";
	//private static String password = "";
	private static JavaMailSenderImpl sender = null;
	private static SimpleMailMessage message = null;
	private static Properties prop = null;
	private static MimeMessage mimemessage = null;
	private static MimeMessageHelper messageHelp = null;
	
	static{
		host_url = MailPropertityUtil.get("mailServerHost");//通过MailPropertityUtil拿到邮件配置信息
		mail_url = MailPropertityUtil.get("mailSenderAddress");
		port = MailPropertityUtil.get("port");
		protocol = MailPropertityUtil.get("protocol");
		//username = MailPropertityUtil.get("userName");
		//password = MailPropertityUtil.get("password");

		sender = new JavaMailSenderImpl();
		sender.setHost(host_url);
		//sender.setUsername(username);
		//sender.setPassword(password);
		sender.setPort(Integer.parseInt(port));
		sender.setProtocol(protocol);
		message = new SimpleMailMessage();
		message.setFrom(mail_url);
		mimemessage = sender.createMimeMessage();
		
		
		prop = new Properties();
		prop.put("mail.debug", "false");
		prop.put("mail.smtp.auth", "false");
		prop.put( "mail.smtp.starttls.enable" ,  "false" ) ;
		prop.put( "mail.smtp.ssl.enable" ,  "false" ) ;
		prop.put( "mail.smtp.connectiontimeout" ,  "60000" ) ;
		prop.put( "mail.smtp.timeout" ,  "60000" ) ;
		sender.setJavaMailProperties(prop);
		
	}
	
	/**
	 * 发送简单的文本邮件
	 * @param toAddress  接收人的email
	 * @param subject    邮件主题
	 * @param text   邮件内容
	 */
	public static void sendSimpleMail(String[] toAddress,String subject,String text,String[] cc){
		message.setTo(toAddress);
		if(cc != null){
			message.setCc(cc);
		}
		message.setSubject(subject);
		message.setText(text);
		sender.send(message);
	}

	/**
	 * 发送简单的HTML邮件
	 * @param toAddress  接收人的email
	 * @param subject    邮件主题
	 * @param text   邮件内容
	 * @throws MessagingException
	 */
	public static void sendSimpleHTMLMail(String toAddress,String subject,String text) throws MessagingException{
		messageHelp.setTo(toAddress);
		messageHelp.setSubject(subject);
		messageHelp.setText(text, true);
		sender.send(mimemessage);
	}
	
	
	/**
	 * 发送带图片、附件的邮件
	 * @param toAddress  接收人的email
	 * @param subject    邮件主题
	 * @param text   邮件内容
	 * @param imgs   图片list<File>
	 * @param files   附件list<File>
	 * @throws MessagingException
	 */
	public static void sendFileMail(String toAddress,String subject,String text,List<File> imgs,List<File> files) throws MessagingException{
		try {
			messageHelp = new MimeMessageHelper(mimemessage,true,"UTF-8");
			messageHelp.setFrom(mail_url);
			messageHelp.setTo(toAddress);
			messageHelp.setSubject(subject);
			messageHelp.setText(text, true);
			
			if(imgs != null && imgs.size() > 0 && !imgs.isEmpty() ){
				for(int i = 0; i < imgs.size(); i++){
					FileSystemResource img = new FileSystemResource(imgs.get(i));
					messageHelp.addInline(imgs.get(i).getName(), img);
				}
			}
			
			if(files != null && files.size() > 0 && !files.isEmpty() ){
				for(int i = 0; i < files.size(); i++){
					FileSystemResource file = new FileSystemResource(files.get(i));
					messageHelp.addAttachment(files.get(i).getName(), file);
				}
			}
			sender.send(mimemessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 发送带有附件、抄送人、密件抄送人、图片、多个收件人、邮件
	 * 收件人、不允许为空
	 * @param addresslist  收件人地址
	 * @param subject   邮件主题
	 * @param text    邮件文本信息
	 * @param bcclist    密件抄送人地址
	 * @param cclist    抄送人地址 
	 * @param imgs     图片list
	 * @param files    附件list
	 * @throws MessagingException
	 */
	public static void send(String[] addresslist,String subject,String text,String[] bcclist,String[] cclist,List<File> imgs,List<File> files) throws MessagingException{
		
		/**
		 * 设置收件人地址
		 */
		InternetAddress[] address = new InternetAddress[addresslist.length];
		for (int i = 0; i < addresslist.length; i++) {
			address[i] = new InternetAddress(addresslist[i]);
		}
		
		/**
		 * 设置密件抄送人地址
		 */
		InternetAddress[] bccaddress = new InternetAddress[bcclist.length];
		if(bcclist.length > 0){
			for (int i = 0; i < bcclist.length; i++) {
				bccaddress[i] = new InternetAddress(bcclist[i]);
			}
			messageHelp.setBcc(bccaddress);
		}
		
		/**
		 * 设置抄送人地址
		 */
		InternetAddress[] ccaddress = new InternetAddress[cclist.length];
		if(cclist.length > 0){
			for (int i = 0; i < bcclist.length; i++) {
				ccaddress[i] = new InternetAddress(cclist[i]);
			}
			messageHelp.setCc(ccaddress);
		}
		
		
		messageHelp.setTo(address);
		messageHelp.setSubject(subject);
		messageHelp.setText(text, true);
		
		if(imgs.size() > 0 && !imgs.isEmpty() ){
			for(int i = 0; i < imgs.size(); i++){
				FileSystemResource img = new FileSystemResource(imgs.get(i));
				messageHelp.addInline(imgs.get(i).getName(), img);
			}
		}
		
		if(files.size() > 0 && !files.isEmpty() ){
			for(int i = 0; i < files.size(); i++){
				FileSystemResource file = new FileSystemResource(files.get(i));
				messageHelp.addAttachment(files.get(i).getName(), file);
			}
		}
		
		/**
		 * 发送邮件
		 */
		sender.send(mimemessage);
	}
	
	public static void main(String[] args) {
		//sendSimpleMail("yunxia.guo@oldmutual-guodian.com","微信邮件测试","理赔");
	}
	
}
