package cn.com.sinosoft.web.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 短信接口回复报文封装实体
 * @author lwy
 *
 */

@XmlRootElement(name = "tXLife")
@XmlType(propOrder = {"transResult","errSource","errMsg"})  
public class TXLife {
	private String transResult;
	private String errSource;
	private String errMsg;
	
	public TXLife() {
		super();
	}
	
	public TXLife(String transResult, String errSource, String errMsg) {
		super();
		this.transResult = transResult;
		this.errSource = errSource;
		this.errMsg = errMsg;
	}
	@XmlElement(name="transResult")
	public String getTransResult() {
		return transResult;
	}
	public void setTransResult(String transResult) {
		this.transResult = transResult;
	}
	@XmlElement(name="errSource")
	public String getErrSource() {
		return errSource;
	}
	public void setErrSource(String errSource) {
		this.errSource = errSource;
	}
	@XmlElement(name="errMsg")
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	
	
	
	
}
