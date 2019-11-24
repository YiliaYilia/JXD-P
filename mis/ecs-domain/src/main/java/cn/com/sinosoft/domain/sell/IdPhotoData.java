package cn.com.sinosoft.domain.sell;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 证件照片存放表
 * @author liangkesai
 * @date 2018年2月28日 下午3:21:26
 */
@Entity
@Table(name = "idPhotoData")
public class IdPhotoData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String policyCode;				//产品代码
	private String uploadTime;				//上传时间
	private String applicantInsured_name;	//投保人姓名
	private String applicantInsured_idType;	//投保人证件类型
	private String applicantInsured_IdNo;	//投保人证件号码
	private String applicantInsured_endTime;//投保人证件生效期
	private String applicantInsured_frontal;//投保人证件照(正)
	private String applicantInsured_reverse;//投保人证件照(反)
	private String recognizee_name;			//被保人姓名
	private String recognizee_idType;		//被保人证件类型
	private String recognizee_IdNo;			//被保人证件号码
	private String recognizee_endTime;		//被保人证件生效期
	private String recognizee_frontal;		//被保人证件照(正)
	private String recognizee_reverse;		//被保人证件照(反)
	private String proposalContNo;			//投保单号
	
	private Date starttime;
	private Date endtime;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")   
	@Column(name = "ID", unique = true, nullable = false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "policyCode")
	public String getPolicyCode() {
		return policyCode;
	}
	public void setPolicyCode(String policyCode) {
		this.policyCode = policyCode;
	}
	
	@Column(name = "uploadTime")
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	
	@Column(name = "applicantInsured_name")
	public String getApplicantInsured_name() {
		return applicantInsured_name;
	}
	public void setApplicantInsured_name(String applicantInsured_name) {
		this.applicantInsured_name = applicantInsured_name;
	}
	
	@Column(name = "applicantInsured_idType")
	public String getApplicantInsured_idType() {
		return applicantInsured_idType;
	}
	public void setApplicantInsured_idType(String applicantInsured_idType) {
		this.applicantInsured_idType = applicantInsured_idType;
	}
	
	@Column(name = "applicantInsured_IdNo")
	public String getApplicantInsured_IdNo() {
		return applicantInsured_IdNo;
	}
	public void setApplicantInsured_IdNo(String applicantInsured_IdNo) {
		this.applicantInsured_IdNo = applicantInsured_IdNo;
	}
	
	@Column(name = "applicantInsured_endTime")
	public String getApplicantInsured_endTime() {
		return applicantInsured_endTime;
	}
	public void setApplicantInsured_endTime(String applicantInsured_endTime) {
		this.applicantInsured_endTime = applicantInsured_endTime;
	}
	
	@Column(name = "applicantInsured_frontal")
	public String getApplicantInsured_frontal() {
		return applicantInsured_frontal;
	}
	public void setApplicantInsured_frontal(String applicantInsured_frontal) {
		this.applicantInsured_frontal = applicantInsured_frontal;
	}
	
	@Column(name = "applicantInsured_reverse")
	public String getApplicantInsured_reverse() {
		return applicantInsured_reverse;
	}
	public void setApplicantInsured_reverse(String applicantInsured_reverse) {
		this.applicantInsured_reverse = applicantInsured_reverse;
	}
	
	@Column(name = "recognizee_name")
	public String getRecognizee_name() {
		return recognizee_name;
	}
	public void setRecognizee_name(String recognizee_name) {
		this.recognizee_name = recognizee_name;
	}
	
	@Column(name = "recognizee_idType")
	public String getRecognizee_idType() {
		return recognizee_idType;
	}
	public void setRecognizee_idType(String recognizee_idType) {
		this.recognizee_idType = recognizee_idType;
	}
	
	@Column(name = "recognizee_IdNo")
	public String getRecognizee_IdNo() {
		return recognizee_IdNo;
	}
	public void setRecognizee_IdNo(String recognizee_IdNo) {
		this.recognizee_IdNo = recognizee_IdNo;
	}
	
	@Column(name = "recognizee_endTime")
	public String getRecognizee_endTime() {
		return recognizee_endTime;
	}
	public void setRecognizee_endTime(String recognizee_endTime) {
		this.recognizee_endTime = recognizee_endTime;
	}
	
	@Column(name = "recognizee_frontal")
	public String getRecognizee_frontal() {
		return recognizee_frontal;
	}
	public void setRecognizee_frontal(String recognizee_frontal) {
		this.recognizee_frontal = recognizee_frontal;
	}
	
	@Column(name = "recognizee_reverse")
	public String getRecognizee_reverse() {
		return recognizee_reverse;
	}
	public void setRecognizee_reverse(String recognizee_reverse) {
		this.recognizee_reverse = recognizee_reverse;
	}
	
	@Column(name = "proposalContNo")
	public String getProposalContNo() {
		return proposalContNo;
	}
	public void setProposalContNo(String proposalContNo) {
		this.proposalContNo = proposalContNo;
	}
	@Column(name = "starttime")
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	@Column(name = "endtime")
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	
}
