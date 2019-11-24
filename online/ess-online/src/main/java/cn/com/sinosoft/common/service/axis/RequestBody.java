package cn.com.sinosoft.common.service.axis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "soapenv:Body")
public class RequestBody {

	@XmlElement(required = true,name="ADD")
	private Add add;

	public RequestBody() {
		super();
	}
	

	public RequestBody(Add add) {
		super();
		this.add = add;
	}



	public Add getAdd() {
		return add;
	}

	public void setAdd(Add add) {
		this.add = add;
	}
	
}
