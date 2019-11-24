package cn.com.sinosoft.domain.yinbaotong;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"flag","desc"})  
public class DailyBalance {
	private String flag;
	private String desc;
	@XmlElement(name="flag")
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	@XmlElement(name="desc")
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public DailyBalance(String flag, String desc) {
		super();
		this.flag = flag;
		this.desc = desc;
	}
	public DailyBalance() {
		super();
	}
	
}
