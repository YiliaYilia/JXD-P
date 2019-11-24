package cn.com.sinosoft.ess.protal.model.insure.base;

import javax.xml.bind.annotation.XmlElement;


/**
 * 描述：受益人<br>
 * 作者：GHY <br>
 * 修改日期：2014-3-12上午10:36:48 <br>
 * E-mail: gaohongyang13607@sinosoft.com.cn <br>
 */
public class LCBnfTbl {
	
	private String beneficiaryno;		//预留
	private String bentype;				//受益人类别
	private String benorder;			//受益顺序
	private String benname;				//姓名
	private String benbirthday;			//生日
	private String bensex;				//性别
	private String benidtype;			//证件类型
	private String benidnumber;			//证件号码
	private String govtTermDate;		//证件有效期
	private String benrate;				//受益比例
	private String benrelationtopins;	//与被保人关系
	private String beneficType;			//受益人是否法定
	
	
	@XmlElement(name="BnfNo")
	public String getBeneficiaryno() {
		return beneficiaryno;
	}
	public void setBeneficiaryno(String beneficiaryno) {
		this.beneficiaryno = beneficiaryno;
	}
	
	@XmlElement(name="Type")
	public String getBentype() {
		return bentype;
	}
	public void setBentype(String bentype) {
		this.bentype = bentype;
	}
	
	@XmlElement(name="Grade")
	public String getBenorder() {
		return benorder;
	}
	public void setBenorder(String benorder) {
		this.benorder = benorder;
	}
	
	@XmlElement(name="Name")
	public String getBenname() {
		return benname;
	}
	public void setBenname(String benname) {
		this.benname = benname;
	}
	
	@XmlElement(name="Birthday")
	public String getBenbirthday() {
		return benbirthday;
	}
	public void setBenbirthday(String benbirthday) {
		this.benbirthday = benbirthday;
	}
	
	@XmlElement(name="Sex")
	public String getBensex() {
		return bensex;
	}
	public void setBensex(String bensex) {
		this.bensex = bensex;
	}
	
	@XmlElement(name="IDType")
	public String getBenidtype() {
		return benidtype;
	}
	public void setBenidtype(String benidtype) {
		this.benidtype = benidtype;
	}
	
	@XmlElement(name="IDNo")
	public String getBenidnumber() {
		return benidnumber;
	}
	public void setBenidnumber(String benidnumber) {
		this.benidnumber = benidnumber;
	}
	
	@XmlElement(name="GovtTermDate")
	public String getGovtTermDate() {
		return govtTermDate;
	}
	public void setGovtTermDate(String govtTermDate) {
		this.govtTermDate = govtTermDate;
	}
	
	@XmlElement(name="Lot")
	public String getBenrate() {
		return benrate;
	}
	public void setBenrate(String benrate) {
		this.benrate = benrate;
	}
	
	@XmlElement(name="RelaToInsured")
	public String getBenrelationtopins() {
		return benrelationtopins;
	}
	public void setBenrelationtopins(String benrelationtopins) {
		this.benrelationtopins = benrelationtopins;
	}
	
	@XmlElement(name="BeneficType")
	public String getBeneficType() {
		return beneficType;
	}
	public void setBeneficType(String beneficType) {
		this.beneficType = beneficType;
	}
	
	
	
}
