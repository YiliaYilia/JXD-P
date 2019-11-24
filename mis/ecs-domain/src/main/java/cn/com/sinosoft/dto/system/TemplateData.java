package cn.com.sinosoft.dto.system;

import java.util.Date;
import java.util.List;

public class TemplateData {
	
	private String total;
	private List<tempData> rows;
	
	
	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}




	public List<tempData> getRows() {
		return rows;
	}


	public void setRows(List<tempData> rows) {
		this.rows = rows;
	}




	public static class tempData{
		private String tempid;
		private String tempname;
		private String funId;
		private String tempcontent;
		private String createTime;
		private String operatopname;
		private String functioncode;    //功能code
		private String typecode;        //类型code
		
		
		public String getFunId() {
			return funId;
		}
		public void setFunId(String funId) {
			this.funId = funId;
		}
		public String getTempid() {
			return tempid;
		}
		public void setTempid(String tempid) {
			this.tempid = tempid;
		}
		public String getTempname() {
			return tempname;
		}
		public void setTempname(String tempname) {
			this.tempname = tempname;
		}
		public String getTempcontent() {
			return tempcontent;
		}
		public void setTempcontent(String tempcontent) {
			this.tempcontent = tempcontent;
		}
		public String getCreateTime() {
			return createTime;
		}
		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}
		public String getOperatopname() {
			return operatopname;
		}
		public void setOperatopname(String operatopname) {
			this.operatopname = operatopname;
		}
		public String getFunctioncode() {
			return functioncode;
		}
		public void setFunctioncode(String functioncode) {
			this.functioncode = functioncode;
		}
		public String getTypecode() {
			return typecode;
		}
		public void setTypecode(String typecode) {
			this.typecode = typecode;
		}
		
		
		
		
		
	}
}
