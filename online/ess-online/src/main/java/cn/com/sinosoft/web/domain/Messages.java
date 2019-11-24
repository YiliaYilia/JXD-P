package cn.com.sinosoft.web.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 短信报文封装类
 * @author lwy
 *
 */
@XmlRootElement
@XmlType(propOrder = {"publicInfo","message"})  
public class Messages {
	private PublicInfo publicInfo;
	private Message message;
	@XmlElement(name="publicInfo")
	public PublicInfo getPublicInfo() {
		return publicInfo;
	}
	public void setPublicInfo(PublicInfo publicInfo) {
		this.publicInfo = publicInfo;
	}
	@XmlElement(name="message")
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
	
	public Messages() {
		super();
	}
	public Messages(PublicInfo publicInfo, Message message) {
		super();
		this.publicInfo = publicInfo;
		this.message = message;
	}

}
