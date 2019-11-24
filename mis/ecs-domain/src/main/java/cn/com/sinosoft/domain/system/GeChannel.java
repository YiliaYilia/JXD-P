package cn.com.sinosoft.domain.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 渠道图片配置
 * @author GHY
 *
 */
@Entity
@Table(name = "ge_channel")
public class GeChannel implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String channelCode;			//合作伙伴代码
	private String imgUrl;				//首页图片路径
	private String channelName;			//合作伙伴名称
	private String policyName;			//产品名称
	private String isAgentcode;			//推荐人编码是否必填  1：必填 0：可选
	private String deptCode; 			//机构
	private String policyUrl;			//产品链接
	private String policyMatrix;		//产品二维码路径
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "ID", unique = true, nullable = false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "CHANNELCODE")
	public String getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	
	@Column(name = "IMGURL")
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	@Column(name = "CHANNELNAME")
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	
	@Column(name = "POLICYNAME")
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	
	@Column(name = "ISAGENTCODE")
	public String getIsAgentcode() {
		return isAgentcode;
	}
	public void setIsAgentcode(String isAgentcode) {
		this.isAgentcode = isAgentcode;
	}
	
	@Column(name = "DEPTCODE")
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	
	@Column(name = "POLICYURL")
	public String getPolicyUrl() {
		return policyUrl;
	}
	public void setPolicyUrl(String policyUrl) {
		this.policyUrl = policyUrl;
	}
	
	@Column(name = "POLICYMATRIX")
	public String getPolicyMatrix() {
		return policyMatrix;
	}
	public void setPolicyMatrix(String policyMatrix) {
		this.policyMatrix = policyMatrix;
	}
	
}
