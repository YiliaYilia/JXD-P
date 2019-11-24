package cn.com.sinosoft.domain.consult;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * Complain entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "COMPLAIN", schema = "MIS")
public class Complain implements java.io.Serializable {

	// Fields

	private String complainId;
	private String complainContent;
	private Date date;
	private String proposalNo;
	private String usersId;
	private String username;
	private String complainTypeId;
	private String isChecked;

	// Constructors

	/** default constructor */
	public Complain() {
	}

	/** full constructor */
	public Complain(String complainContent, Date date, String proposalNo, String usersId, String username,
			String complainTypeId, String isChecked) {
		this.complainContent = complainContent;
		this.date = date;
		this.proposalNo = proposalNo;
		this.usersId = usersId;
		this.username = username;
		this.complainTypeId = complainTypeId;
		this.isChecked = isChecked;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "COMPLAIN_ID", unique = true, nullable = false, length = 32)
	public String getComplainId() {
		return this.complainId;
	}

	public void setComplainId(String complainId) {
		this.complainId = complainId;
	}

	@Column(name = "COMPLAIN_CONTENT", length = 2000)
	public String getComplainContent() {
		return this.complainContent;
	}

	public void setComplainContent(String complainContent) {
		this.complainContent = complainContent;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE", length = 7)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "PROPOSAL_NO", length = 35)
	public String getProposalNo() {
		return this.proposalNo;
	}

	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}

	@Column(name = "USERS_ID", length = 32)
	public String getUsersId() {
		return this.usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	@Column(name = "USERNAME", length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "COMPLAIN_TYPE_ID", length = 32)
	public String getComplainTypeId() {
		return this.complainTypeId;
	}

	public void setComplainTypeId(String complainTypeId) {
		this.complainTypeId = complainTypeId;
	}

	@Column(name = "IS_CHECKED", length = 1)
	public String getIsChecked() {
		return this.isChecked;
	}

	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}

}