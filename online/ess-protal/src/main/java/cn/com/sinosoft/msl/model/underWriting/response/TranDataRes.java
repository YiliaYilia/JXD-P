package cn.com.sinosoft.msl.model.underWriting.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import cn.com.sinosoft.ess.protal.common.JaxbMapper;
import cn.com.sinosoft.msl.model.common.response.Head;


@XmlType(propOrder={"head","body"})
@XmlRootElement(name="TranData")
public class TranDataRes {

	private Head head;
	
	private Body body;

	@XmlElement(name="Head")
	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}
	
	@XmlElement(name="Body")
	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}
	
	public static void main(String[] args) {
//		TranDateRes e = new TranDateRes();
//		Head h = new Head();
//		Body b = new Body();
//		h.setDesc("213");
//		h.setFlag("12");
//		b.setContNo("213213");
//		b.setProposalPrtNo("213123");
//		b.setTransNo("123123");
//		e.setBody(b);
//		e.setHead(h);
//		String reqxml = JaxbMapper.toXml(e, "GBK");
//		
//		System.out.println(reqxml);
	}
	
}
