package cn.com.sinosoft.common.service.axis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ADD")
public class Add {
	@XmlElement(required = true,name="BUSIINFO")
    private BusiInfo busiInfo;
	
	

	public Add() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Add(BusiInfo busiInfo) {
		super();
		this.busiInfo = busiInfo;
	}

	public BusiInfo getBusiInfo() {
		return busiInfo;
	}

	public void setBusiInfo(BusiInfo busiInfo) {
		this.busiInfo = busiInfo;
	}
	
}
