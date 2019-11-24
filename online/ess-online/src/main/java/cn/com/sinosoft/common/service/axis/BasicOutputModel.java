/**
 * BasicOutputModel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class BasicOutputModel  implements java.io.Serializable {
    private Integer resultCode;

    private Object resultJson;

    private String resultMessage;

    public BasicOutputModel() {
    }

    public BasicOutputModel(
           Integer resultCode,
           Object resultJson,
           String resultMessage) {
           this.resultCode = resultCode;
           this.resultJson = resultJson;
           this.resultMessage = resultMessage;
    }


    /**
     * Gets the resultCode value for this BasicOutputModel.
     * 
     * @return resultCode
     */
    public Integer getResultCode() {
        return resultCode;
    }


    /**
     * Sets the resultCode value for this BasicOutputModel.
     * 
     * @param resultCode
     */
    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }


    /**
     * Gets the resultJson value for this BasicOutputModel.
     * 
     * @return resultJson
     */
    public Object getResultJson() {
        return resultJson;
    }


    /**
     * Sets the resultJson value for this BasicOutputModel.
     * 
     * @param resultJson
     */
    public void setResultJson(Object resultJson) {
        this.resultJson = resultJson;
    }


    /**
     * Gets the resultMessage value for this BasicOutputModel.
     * 
     * @return resultMessage
     */
    public String getResultMessage() {
        return resultMessage;
    }


    /**
     * Sets the resultMessage value for this BasicOutputModel.
     * 
     * @param resultMessage
     */
    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof BasicOutputModel)) return false;
        BasicOutputModel other = (BasicOutputModel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.resultCode==null && other.getResultCode()==null) || 
             (this.resultCode!=null &&
              this.resultCode.equals(other.getResultCode()))) &&
            ((this.resultJson==null && other.getResultJson()==null) || 
             (this.resultJson!=null &&
              this.resultJson.equals(other.getResultJson()))) &&
            ((this.resultMessage==null && other.getResultMessage()==null) || 
             (this.resultMessage!=null &&
              this.resultMessage.equals(other.getResultMessage())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getResultCode() != null) {
            _hashCode += getResultCode().hashCode();
        }
        if (getResultJson() != null) {
            _hashCode += getResultJson().hashCode();
        }
        if (getResultMessage() != null) {
            _hashCode += getResultMessage().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BasicOutputModel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "BasicOutputModel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "resultCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultJson");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "resultJson"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "resultMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
