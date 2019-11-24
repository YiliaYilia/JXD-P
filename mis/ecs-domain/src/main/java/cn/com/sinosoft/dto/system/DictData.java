package cn.com.sinosoft.dto.system;

import java.util.Date;
import java.util.List;

import cn.com.sinosoft.domain.system.GeDictData;
import cn.com.sinosoft.domain.system.GeDictType;

public class DictData {

	private String total;
	private List<DictDataRow> rows;
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}


	public List<DictDataRow> getRows() {
		return rows;
	}

	public void setRows(List<DictDataRow> rows) {
		this.rows = rows;
	}

	public static class DictDataRow {
		private String dictdataid;
		private String dictdatacode;
		private String dictdatadesc;
		private String dictdataname;
		private String dicttypecode;
		private String dicttypename;
		private String createtimestr;
		private String operatorname;
		
		public String getDicttypecode() {
			return dicttypecode;
		}
		public void setDicttypecode(String dicttypecode) {
			this.dicttypecode = dicttypecode;
		}
		public String getCreatetimestr() {
			return createtimestr;
		}
		public void setCreatetimestr(String createtimestr) {
			this.createtimestr = createtimestr;
		}
		
		public String getOperatorname() {
			return operatorname;
		}
		public void setOperatorname(String operatorname) {
			this.operatorname = operatorname;
		}
		public String getDictdataid() {
			return dictdataid;
		}
		public void setDictdataid(String dictdataid) {
			this.dictdataid = dictdataid;
		}
		public String getDictdataname() {
			return dictdataname;
		}
		public void setDictdataname(String dictdataname) {
			this.dictdataname = dictdataname;
		}
		public String getDictdatadesc() {
			return dictdatadesc;
		}
		public void setDictdatadesc(String dictdatadesc) {
			this.dictdatadesc = dictdatadesc;
		}
		public String getDictdatacode() {
			return dictdatacode;
		}
		public void setDictdatacode(String dictdatacode) {
			this.dictdatacode = dictdatacode;
		}
		public String getDicttypename() {
			return dicttypename;
		}
		public void setDicttypename(String dicttypename) {
			this.dicttypename = dicttypename;
		}
		
		
	}

}
