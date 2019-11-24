package cn.com.sinosoft.domain.soap.requset.acceptinsurance;
/**
 * 描述：受益人<br>
 * 作者：wanhonghui <br>
 * 修改日期：2013年8月15日下午1:28:00 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br>
 */
public class LCBnf {
	/** 预留*/
	private String bnfType;
	/**预留*/
	private String bnfNo;
	/**收益顺序  非空*/
	private String bnfGrade;
	/**受益人姓名 非空*/
	private String name;
	/**受益人性别 非空*/
	private String sex;
	/**受益人出生日期 非空*/
	private String birthday;
	/**受益人证件类型 非空*/
	private String iDType;
	/**受益人证件号码 非空*/
	private String iDNo;
	/** 与被保人关系*/
	private String relationToInsured;
	/**受益比例 非空 */
	private String bnfLot;
	public String getBnfType() {
		return bnfType;
	}
	public void setBnfType(String bnfType) {
		this.bnfType = bnfType;
	}
	public String getBnfNo() {
		return bnfNo;
	}
	public void setBnfNo(String bnfNo) {
		this.bnfNo = bnfNo;
	}
	public String getBnfGrade() {
		return bnfGrade;
	}
	public void setBnfGrade(String bnfGrade) {
		this.bnfGrade = bnfGrade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getiDType() {
		return iDType;
	}
	public void setiDType(String iDType) {
		this.iDType = iDType;
	}
	public String getiDNo() {
		return iDNo;
	}
	public void setiDNo(String iDNo) {
		this.iDNo = iDNo;
	}
	public String getRelationToInsured() {
		return relationToInsured;
	}
	public void setRelationToInsured(String relationToInsured) {
		this.relationToInsured = relationToInsured;
	}
	public String getBnfLot() {
		return bnfLot;
	}
	public void setBnfLot(String bnfLot) {
		this.bnfLot = bnfLot;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
