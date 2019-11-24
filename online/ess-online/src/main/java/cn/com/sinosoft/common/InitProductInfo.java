package cn.com.sinosoft.common;


import cn.com.sinosoft.ess.protal.common.PraseXml;
import 	org.dom4j.Element;


public class InitProductInfo {

	static final PraseXml p = new PraseXml();
	
	private String productCode;
	private String productName;
	private String productImpagePath;
	private String productPrice;
	private String productDepict;

	static {
		try {
			String path = InitProductInfo.class.getResource("").getPath().replace("/cn/com/sinosoft/common", "").replace("%20", " ") + "products.xml";;
			p.initXmlByFile(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initProductNPACA(){
		Element productNPACA = p.getElement().element("productNPACA");
		this.productCode = productNPACA.element("productCode").getText();
		this.productName =	productNPACA.element("productName").getText();
		this.productImpagePath =productNPACA.element("productImpagePath").getText();
		this.productPrice =	productNPACA.element("productPrice").getText();
		this.productDepict =productNPACA.element("productDepict").getText();
	}
	
	public void initProductBCIB(){
		Element productBCIB = p.getElement().element("productBCIB");
		this.productCode = productBCIB.element("productCode").getText();
		this.productName =	productBCIB.element("productName").getText();
		this.productImpagePath =productBCIB.element("productImpagePath").getText();
		this.productPrice =	productBCIB.element("productPrice").getText();
		this.productDepict =productBCIB.element("productDepict").getText();
	}
	
	public void initProductFTA(){
		Element productFTA = p.getElement().element("productFTA");
		this.productCode = productFTA.element("productCode").getText();
		this.productName =	productFTA.element("productName").getText();
		this.productImpagePath =productFTA.element("productImpagePath").getText();
		this.productPrice =	productFTA.element("productPrice").getText();
		this.productDepict =productFTA.element("productDepict").getText();
	}
	
	public void initProductBSPG7(){
		Element productBSPG7 = p.getElement().element("productBSPG7");
		this.productCode = productBSPG7.element("productCode").getText();
		this.productName =	productBSPG7.element("productName").getText();
		this.productImpagePath =productBSPG7.element("productImpagePath").getText();
		this.productPrice =	productBSPG7.element("productPrice").getText();
		this.productDepict =productBSPG7.element("productDepict").getText();
	}
	
	public void initProductJEB(){
		Element productJEB = p.getElement().element("productJEB");
		this.productCode = productJEB.element("productCode").getText();
		this.productName =	productJEB.element("productName").getText();
		this.productImpagePath =productJEB.element("productImpagePath").getText();
		this.productPrice =	productJEB.element("productPrice").getText();
		this.productDepict =productJEB.element("productDepict").getText();
	}
		
	public void initProductAA(){
		Element productAA = p.getElement().element("productAA");
		this.productCode = productAA.element("productCode").getText();
		this.productName =	productAA.element("productName").getText();
		this.productImpagePath =productAA.element("productImpagePath").getText();
		this.productPrice =	productAA.element("productPrice").getText();
		this.productDepict =productAA.element("productDepict").getText();
	}
	
	
	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImpagePath() {
		return productImpagePath;
	}

	public void setProductImpagePath(String productImpagePath) {
		this.productImpagePath = productImpagePath;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDepict() {
		return productDepict;
	}

	public void setProductDepict(String productDepict) {
		this.productDepict = productDepict;
	}
}