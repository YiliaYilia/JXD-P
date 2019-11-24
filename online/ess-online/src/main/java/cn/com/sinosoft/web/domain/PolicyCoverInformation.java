package cn.com.sinosoft.web.domain;

public class PolicyCoverInformation {
	
	private String productName;
	private String productCode;
	private String productType;
	
	
	
	public PolicyCoverInformation() {
		
	}

	public PolicyCoverInformation(String productName, String productCode,
			String productType) {
		super();
		this.productName = productName;
		this.productCode = productCode;
		this.productType = productType;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	
	
	

}
