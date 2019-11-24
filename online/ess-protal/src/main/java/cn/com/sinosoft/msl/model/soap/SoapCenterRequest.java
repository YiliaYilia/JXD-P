package cn.com.sinosoft.msl.model.soap;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import cn.com.sinosoft.ess.protal.util.XMLUtil;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.Agreement;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.Entry;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.ExtraAttrs;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.Header;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.InsuraPerson;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.InsurancePolicy;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.Policy;
import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.Product;

@XmlRootElement(name="request")
@XmlType(propOrder = { "agreement","header","holder","insured","product"})  
public class SoapCenterRequest {
	
	    /*private InsuraPerson advisor;
		@XmlElement(name="advisor")
		public InsuraPerson getAdvisor() {  
	        return advisor;  
	    }  
	  
	    public void setAdvisor(InsuraPerson advisor) {  
	        this.advisor = advisor;  
	    }*/
	    
	    private Agreement agreement;
	    @XmlElement(name="agreement")
		public Agreement getAgreement() {  
	        return agreement;  
	    }  
	  
	    public void setAgreement(Agreement agreement) {  
	        this.agreement = agreement;  
	    }
	    
	    /*private BankAccount bankAccount;
		@XmlElement(name="bankAccount")
		public BankAccount getBankAccount() {  
	        return bankAccount;  
	    }  
	  
	    public void setBankAccount(BankAccount bankAccount) {  
	        this.bankAccount = bankAccount;  
	    }
		
	    private Beneficiary benef;
		@XmlElement(name="benef")
		public Beneficiary getBenef() {  
	        return benef;  
	    }  
	  
	    public void setBenef(Beneficiary benef) {  
	        this.benef = benef;  
	    }
		
	    private ExtraAttrs extraAttrs;
	    @XmlElement(name="extraAttrs")
		public  ExtraAttrs getExtraAttrs() {  
	        return extraAttrs;  
	    }  
	  
	    public void setExtraAttrs(ExtraAttrs extraAttrs) {  
	        this.extraAttrs = extraAttrs;  
	    }*/
		
	    private Header header;
	    @XmlElement(name="header")
	    public Header getHeader() {  
	        return header;  
	    }  
	  
	    public void setHeader(Header header) {  
	        this.header = header;  
	    }
	    
	    private InsuraPerson holder;
	    @XmlElement(name="holder")
	    public InsuraPerson getHolder(){
	    	return holder;
	    }
	    
	    public void setHolder(InsuraPerson holder){
	    	this.holder = holder;
	    }
	    
	    private InsuraPerson insured;
	    @XmlElement(name="insured")
	    public InsuraPerson getInsured(){
	    	return insured;
	    }
	    
	    public void setInsured(InsuraPerson insured){
	    	this.insured = insured;
	    }
	    
	    private Product product;
	    @XmlElement(name="product")
	    public Product getProduct() {  
	        return product;  
	    }  
	  
	    public void setProduct(Product product) {  
	        this.product = product;  
	    }
	  
	    public SoapCenterRequest(Agreement agreement, Header header, InsuraPerson holder,
	    		Product product) {  
	        super();  
	        this.agreement = agreement;  
	        this.header = header;
	        this.holder = holder;
	        this.product = product;
	    }  
	  
	    //无参够着函数一定需要，否则JXBContext无法正常解析。  
	    public SoapCenterRequest() {  
	        super();  
	    }  
	    
	    public static String marshal(Object object) throws Exception {
			JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
			OutputStream outputStream = new ByteArrayOutputStream();
			Marshaller marshaller = jaxbContext.createMarshaller();
			// 指定XML 头一行信息不生成
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			// 设定XML投头的格式
			//marshaller.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			// 设置编码
			//marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			// 用来指定是否使用换行和缩排对已编组XML数据进行格式化的属性名称
			//marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(object, outputStream);
			return outputStream.toString();
		}
	
    public static void beanToXML() throws Exception {  
    	InsurancePolicy insurancePolicy = new InsurancePolicy();
		Agreement agreement = new Agreement(true,false,true);
		Map<String,String> map1 = new HashMap<String,String>();
		map1.put("unit", "1");
		//map1.put("Specification", "本保险单的保险期间为：2015-06-25");
		InsuraPerson holder = new InsuraPerson(new Date(), "M",
				"11010219890924231X", "A", "18201452355",  "张三",  "A1001_1", "110100", "A10", "0");
		Policy policy1 = new Policy("1",new Date(),map1,"BPA-PT","D","0","0",1.20,350000.00);
		List<Policy> policyList = new ArrayList<Policy>();
		policyList.add(policy1);
		Product product = new Product("false","10.0","TATIANB02",new Date(),1,policyList,"D","0",1.20,350000.00);
		Header header = new Header("WECHAT01",new Date(),"2014571500056");
		
		insurancePolicy.setAgreement(agreement);
		insurancePolicy.setHeader(header);
		insurancePolicy.setHolder(holder);
	//	insurancePolicy.setInsured(insured);
		insurancePolicy.setProduct(product);
		SoapCenterRequest req = new SoapCenterRequest(agreement,header,holder,product);  
		String xml = marshal(req);
        System.out.println(XMLUtil.formatXML(xml, "UTF-8"));
    }  
	
	public static void main(String[] args) throws Exception {
		beanToXML();
	}
}