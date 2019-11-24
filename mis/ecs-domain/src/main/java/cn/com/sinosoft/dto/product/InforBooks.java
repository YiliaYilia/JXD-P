package cn.com.sinosoft.dto.product;

import java.util.List;

/**
 * 描述：<br>
 * 作者：Leeyao<br>
 * 修改日期：2014年1月9日下午5:39:05<br>
 * E-mail: liysz0441@sinosoft.com.cn<br>
 */
public class InforBooks {
	private String total;
	private List<InforBook> rows;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List<InforBook> getRows() {
		return rows;
	}

	public void setRows(List<InforBook> rows) {
		this.rows = rows;
	}
	
	public static class InforBook{
		private String informcontent;
		private String informoption;
		public String getInformcontent() {
			return informcontent;
		}
		public void setInformcontent(String informcontent) {
			this.informcontent = informcontent;
		}
		public String getInformoption() {
			return informoption;
		}
		public void setInformoption(String informoption) {
			this.informoption = informoption;
		}
	}
}
