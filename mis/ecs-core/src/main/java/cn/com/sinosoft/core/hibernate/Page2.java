package cn.com.sinosoft.core.hibernate;
import java.util.List;


public class Page2 {
	
	private int pageSize;
	private int currentPage;
	private int pageCount;
	private int recordCount;
	private int nextPage;
	private int beforePage;
	private List result;
	
	public List getResult() {
		return result;
	}
	public void setResult(List result) {
		this.result = result;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
		if (recordCount % this.pageSize == 0) {
			this.pageCount = recordCount / this.pageSize;
		} else {
			this.pageCount = recordCount / this.pageSize + 1;
		}
		if (this.pageCount == 1) {
			this.nextPage = 1;
			this.beforePage = 1;
			this.currentPage = 1;
		} else if (this.currentPage >= this.pageCount) {
			this.currentPage = this.pageCount;
			this.nextPage = this.pageCount;
			this.beforePage = this.pageCount - 1;
		} else if (this.currentPage < 1) {
			this.currentPage = 1;
			this.beforePage = 1;
			this.nextPage = 2;
		} else {
			if (this.currentPage == 1) {
				this.beforePage = 1;
			} else {
				this.beforePage = this.currentPage - 1;
			}
			this.nextPage = this.currentPage + 1;
		}
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getBeforePage() {
		return beforePage;
	}
	public void setBeforePage(int beforePage) {
		this.beforePage = beforePage;
	}
}