package cn.com.sinosoft.msl.model.insurancePolicy.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import cn.com.sinosoft.ess.protal.common.JaxbMapper;
import cn.com.sinosoft.msl.model.common.request.Head;


@XmlType(propOrder={"head","body"})
@XmlRootElement(name="TranData")
public class TranDataReq {

	private Head head ;
	
	private Body body ;

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
		TranDataReq e = new TranDataReq();
		Head h = new Head();
		Body b = new Body();
		h.setFuncFlag("1001");
		h.setSysCode("EBS");
		h.setTranDate("213123");
		h.setTransrNo("123");
		h.setTranTime("23213");
		b.setChannelCd("12312");
		b.setContNo("123123");
		b.setOldTranNo("3123123");
		b.setPayDate("123123");
		b.setPayTime("312312");
		b.setPayType("123123");
		b.setProposalPrtNo("213123");
		b.setSysRefNumber("213123");
		b.setTranSchnl("213");
		b.setZoneNo("213");
		e.setBody(b);
		e.setHead(h);
		
		String reqxml = JaxbMapper.toXml(e, "GBK");
		
		System.out.println(reqxml);
	}
	
}
