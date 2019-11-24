package cn.com.sinosoft.msl.model.underWriting.request;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
//		TranDateReq e = new TranDateReq();
//		Head h = new Head();
//		Body b = new Body();
//		h.setFuncFlag("1001");
//		h.setSysCode("EBS");
//		h.setTranDate("213123");
//		h.setTransrNo("123");
//		h.setTranTime("23213");
//		b.setaPPChannel("01");
//		b.setTranSchnl("1");
//		b.setZoneNo("123");
//		b.setProposalPrtNo("123123");
//		b.setPolApplyDate("21312");
//		b.setContractEffDate("12312");
//		b.setDisCount("123");
//		b.setBeneficType("N");
//		Applicant a = new Applicant();
//		a.setAddress("213123");
//		a.setAppntZoneNo("0ad");
//		a.setAreaCode("133");
//		a.setBirthday("123123");
//		a.setEmail("123123");
//		a.setExtNumber("123123");
//		a.setGovtTermDate("3213123");
//		a.setiDNo("123123123");
//		a.setMobile("123123");
//		a.setiDType("1");
//		a.setName("123");
//		a.setPhone("123123123");
//		a.setRelaToInsured("1");
//		a.setSex("1");
//		a.setZipCode("1232");
//		
//		Beneficiary ben = new Beneficiary();
//		ArrayList<Beneficiary> liss = new ArrayList<Beneficiary>();
//		ben.setBirthday("123123");
//		ben.setGovtTermDate("123123");
//		ben.setGrade("1231239");
//		ben.setiDNo("1231239");
//		ben.setiDType("213943");
//		ben.setLot("932");
//		ben.setName("23123");
//		ben.setRelaToInsured("1");
//		ben.setSex("1");
//		ben.setType("213");
//		liss.add(ben);
//		
//		Risk r = new Risk();
//		List<Risk> list = new ArrayList<Risk>();
//		r.setAmnt("123");
//		r.setInsuYear("3");
//		r.setMainRiskCode("123");
//		r.setInsuYearFlag("1");
//		r.setMult("3123");
//		r.setPayEndYear("3");
//		r.setPayEndYearFlag("3");
//		r.setPayIntv("123");
//		r.setPrem("3");
//		r.setRiskCode("3123");
//		list.add(r);
//		Insured in = new Insured();
//		ArrayList<Insured> lis = new ArrayList<Insured>();
//		in.setAddress("213123");
//		in.setAppntZoneNo("0ad");
//		in.setAreaCode("133");
//		in.setBirthday("123123");
//		in.setEmail("123123");
//		in.setExtNumber("123123");
//		in.setGovtTermDate("3213123");
//		in.setiDNo("123123123");
//		in.setMobile("123123");
//		in.setiDType("1");
//		in.setName("123");
//		in.setPhone("123123123");
//		in.setRelaToInsured("1");
//		in.setSex("1");
//		in.setZipCode("1232");
//		in.setRisk(list);
//		lis.add(in);
//		b.setApplicant(a);
//		b.setInsured(lis);
//		b.setBeneficiary(liss);
//		e.setBody(b);
//		e.setHead(h);
//		
//		
//		String reqxml = JaxbMapper.toXml(e, "GBK");
//		
//		System.out.println(reqxml);
	}
}
