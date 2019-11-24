package cn.com.sinosoft.msl.model.insurancePolicy.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.com.sinosoft.ess.protal.common.JaxbMapper;
import cn.com.sinosoft.msl.model.common.response.Head;



@XmlRootElement(name="TranData")
public class TranDataRes {
	
	private Head head;

	@XmlElement(name="Head")
	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}
	public static void main(String[] args) {
		TranDataRes e = new TranDataRes();
		Head h = new Head();
		h.setDesc("213");
		h.setFlag("12");
		e.setHead(h);
		String reqxml = JaxbMapper.toXml(e, "GBK");
		
		System.out.println(reqxml);
	}
	
}
