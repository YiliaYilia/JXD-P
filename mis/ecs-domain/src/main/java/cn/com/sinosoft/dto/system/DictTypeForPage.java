package cn.com.sinosoft.dto.system;

import java.util.Date;
import java.util.List;

import cn.com.sinosoft.domain.system.GeDictData;
import cn.com.sinosoft.domain.system.GeDictType;

/**
 * 描述：字典类型用的DTO<br>
 * 作者：liyang <br>
 * 修改日期：2013-12-23下午02:39:21 <br>
 * E-mail: liyang12087@sinosoft.com.cn <br>
 */
public class DictTypeForPage {

	private String total;
	private List<DictTypeRow> rows;
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}


	public List<DictTypeRow> getRows() {
		return rows;
	}

	public void setRows(List<DictTypeRow> rows) {
		this.rows = rows;
	}

	public static class DictTypeRow {
		private String dicttypeid;
		private String dicttypename;
		private String dicttypecode;
		private String dicttypesk;
		private String createtimestr;
		private String operatorname;
		public String getDicttypeid() {
			return dicttypeid;
		}
		public void setDicttypeid(String dicttypeid) {
			this.dicttypeid = dicttypeid;
		}
		public String getDicttypename() {
			return dicttypename;
		}
		public void setDicttypename(String dicttypename) {
			this.dicttypename = dicttypename;
		}
		public String getDicttypecode() {
			return dicttypecode;
		}
		public void setDicttypecode(String dicttypecode) {
			this.dicttypecode = dicttypecode;
		}
		public String getDicttypesk() {
			return dicttypesk;
		}
		public void setDicttypesk(String dicttypesk) {
			this.dicttypesk = dicttypesk;
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
	
		
	}

}
