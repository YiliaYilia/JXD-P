package cn.com.sinosoft.dto.product;

import java.util.Date;
import java.util.List;

public class RiskData {

	private String total;
	private List<RiskDataRow> rows;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List<RiskDataRow> getRows() {
		return rows;
	}

	public void setRows(List<RiskDataRow> rows) {
		this.rows = rows;
	}

	public static class RiskDataRow {

		private String riskcode;
		private String riskname;
		private String risksimplename;
		private String coreriskcode;
		private String riskmark;
		private String businessarea;
		private String operator;
		private Date createtime;

		public String getRiskcode() {
			return riskcode;
		}

		public void setRiskcode(String riskcode) {
			this.riskcode = riskcode;
		}

		public String getRiskname() {
			return riskname;
		}

		public void setRiskname(String riskname) {
			this.riskname = riskname;
		}

		public String getRisksimplename() {
			return risksimplename;
		}

		public void setRisksimplename(String risksimplename) {
			this.risksimplename = risksimplename;
		}

		public String getCoreriskcode() {
			return coreriskcode;
		}

		public void setCoreriskcode(String coreriskcode) {
			this.coreriskcode = coreriskcode;
		}

		public String getRiskmark() {
			return riskmark;
		}

		public void setRiskmark(String riskmark) {
			this.riskmark = riskmark;
		}

		public String getBusinessarea() {
			return businessarea;
		}

		public void setBusinessarea(String businessarea) {
			this.businessarea = businessarea;
		}

		public String getOperator() {
			return operator;
		}

		public void setOperator(String operator) {
			this.operator = operator;
		}

		public Date getCreatetime() {
			return createtime;
		}

		public void setCreatetime(Date createtime) {
			this.createtime = createtime;
		}

	}

}
