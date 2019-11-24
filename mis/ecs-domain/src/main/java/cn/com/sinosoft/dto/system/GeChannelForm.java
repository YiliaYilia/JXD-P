package cn.com.sinosoft.dto.system;

import java.util.List;

public class GeChannelForm {
	private String total;
	private List<GeChannelRow> rows;
	
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List<GeChannelRow> getRows() {
		return rows;
	}

	public void setRows(List<GeChannelRow> rows) {
		this.rows = rows;
	}

	public static class GeChannelRow{
		private String id;
		private String channelCode;// 合作机构代码
		private String imgUrl;//首页图片路径
		private String channelName;// 合作机构名称
		private String policyName; //产品名称
		private String isAgentcode;		//推荐人编码是否必填  1：必填 0：可选
		private String deptCode; //机构
		private String policyUrl;			//产品链接
		private String policyMatrix;		//产品二维码路径
		
		private String showDeptCode; 
		private String showPolicyName;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getChannelCode() {
			return channelCode;
		}
		public void setChannelCode(String channelCode) {
			this.channelCode = channelCode;
		}
		public String getImgUrl() {
			return imgUrl;
		}
		public void setImgUrl(String imgUrl) {
			this.imgUrl = imgUrl;
		}
		public String getChannelName() {
			return channelName;
		}
		public void setChannelName(String channelName) {
			this.channelName = channelName;
		}
		public String getPolicyName() {
			return policyName;
		}
		public void setPolicyName(String policyName) {
			this.policyName = policyName;
		}
		public String getIsAgentcode() {
			return isAgentcode;
		}
		public void setIsAgentcode(String isAgentcode) {
			this.isAgentcode = isAgentcode;
		}
		public String getDeptCode() {
			return deptCode;
		}
		public void setDeptCode(String deptCode) {
			this.deptCode = deptCode;
		}
		public String getShowDeptCode() {
			return showDeptCode;
		}
		public void setShowDeptCode(String showDeptCode) {
			this.showDeptCode = showDeptCode;
		}
		public String getShowPolicyName() {
			return showPolicyName;
		}
		public void setShowPolicyName(String showPolicyName) {
			this.showPolicyName = showPolicyName;
		}
		public String getPolicyUrl() {
			return policyUrl;
		}
		public void setPolicyUrl(String policyUrl) {
			this.policyUrl = policyUrl;
		}
		public String getPolicyMatrix() {
			return policyMatrix;
		}
		public void setPolicyMatrix(String policyMatrix) {
			this.policyMatrix = policyMatrix;
		}
		
	}

}
