package cn.com.sinosoft.dto.product;

import java.util.Date;
import java.util.List;

/**
 * 描述：销售流程数据<br>
 * 作者：Leeyao<br>
 * 修改日期：2014年1月2日上午11:54:59<br>
 * E-mail: liysz0441@sinosoft.com.cn<br>
 */
public class FlowData {
	private String total;
	private List<FlowDataRow> rows;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List<FlowDataRow> getRows() {
		return rows;
	}

	public void setRows(List<FlowDataRow> rows) {
		this.rows = rows;
	}

	public static class FlowDataRow {
		private String flowno;
		private String flowname;
		private Date createtime;
		private Date updatetime;
		private String operator;
		public String getFlowno() {
			return flowno;
		}
		public void setFlowno(String flowno) {
			this.flowno = flowno;
		}
		public String getFlowname() {
			return flowname;
		}
		public void setFlowname(String flowname) {
			this.flowname = flowname;
		}
		public Date getCreatetime() {
			return createtime;
		}
		public void setCreatetime(Date createtime) {
			this.createtime = createtime;
		}
		public Date getUpdatetime() {
			return updatetime;
		}
		public void setUpdatetime(Date updatetime) {
			this.updatetime = updatetime;
		}
		public String getOperator() {
			return operator;
		}
		public void setOperator(String operator) {
			this.operator = operator;
		}
	}
}
