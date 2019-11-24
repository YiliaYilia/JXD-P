package cn.com.sinosoft.domain.yinbaotongWKB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"lCInsuredCount","lCInsured"}) 
public class LCInsureds {
	private String lCInsuredCount;//被保人个数
	private LCInsured lCInsured;//被保人信息
	
	public LCInsureds() {
		super();
	}
	public LCInsureds(String lCInsuredCount, LCInsured lCInsured) {
		super();
		this.lCInsuredCount = lCInsuredCount;
		this.lCInsured = lCInsured;
	}
	@XmlElement(name="lCInsured")
	public LCInsured getlCInsured() {
		return lCInsured;
	}
	public void setlCInsured(LCInsured lCInsured) {
		this.lCInsured = lCInsured;
	}
	@XmlElement(name="lCInsuredCount")
	public String getlCInsuredCount() {
		return lCInsuredCount;
	}
	public void setlCInsuredCount(String lCInsuredCount) {
		this.lCInsuredCount = lCInsuredCount;
	}
}
