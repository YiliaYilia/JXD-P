package cn.com.sinosoft.common.service.axis;

import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;


public class CRSInterfaceModel implements java.io.Serializable {

	//返回码
	private Integer code;
	//返回错误
	private String contenct;
	//返回最新的税收声明ID
	private String taxDeclaraID;
	//返回Jsonmodel
	private JsonDataModel jdModel;
	
	private static TypeDesc typeDesc =
	        new TypeDesc(CRSInterfaceModel.class, true);

	static {
	    typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "CRSInterfaceModel"));
	    ElementDesc elemField = new ElementDesc();
	    elemField.setFieldName("code");
	    elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "code"));
	    elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
	    elemField.setMinOccurs(0);
	    elemField.setNillable(false);
	    typeDesc.addFieldDesc(elemField);
	    elemField = new org.apache.axis.description.ElementDesc();
	    elemField.setFieldName("contenct");
	    elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "contenct"));
	    elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	    elemField.setMinOccurs(0);
	    elemField.setNillable(true);
	    typeDesc.addFieldDesc(elemField);
	    elemField = new org.apache.axis.description.ElementDesc();
	    elemField.setFieldName("taxDeclaraID");
	    elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "taxDeclaraID"));
	    elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
	    elemField.setMinOccurs(0);
	    elemField.setNillable(true);
	    typeDesc.addFieldDesc(elemField);
	    elemField = new ElementDesc();
	    elemField = new org.apache.axis.description.ElementDesc();
	    elemField.setFieldName("jdModel");
	    elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "jdModel"));
	    elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "JsonDataModel"));
	    elemField.setMinOccurs(0);
	    elemField.setNillable(true);
	    typeDesc.addFieldDesc(elemField);
	}
	
	public CRSInterfaceModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CRSInterfaceModel(Integer code, String contenct, String taxDeclaraID,
			JsonDataModel jdModel) {
		super();
		this.code = code;
		this.contenct = contenct;
		this.taxDeclaraID = taxDeclaraID;
		this.jdModel = jdModel;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getContenct() {
		return contenct;
	}

	public void setContenct(String contenct) {
		this.contenct = contenct;
	}

	public String getTaxDeclaraID() {
		return taxDeclaraID;
	}

	public void setTaxDeclaraID(String taxDeclaraID) {
		this.taxDeclaraID = taxDeclaraID;
	}

	public JsonDataModel getJdModel() {
		return jdModel;
	}

	public void setJdModel(JsonDataModel jdModel) {
		this.jdModel = jdModel;
	}

	public static TypeDesc getTypeDesc() {
		return typeDesc;
	}

	public static void setTypeDesc(TypeDesc typeDesc) {
		CRSInterfaceModel.typeDesc = typeDesc;
	}

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

	
}
