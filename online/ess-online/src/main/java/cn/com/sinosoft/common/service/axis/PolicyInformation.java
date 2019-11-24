/**
 * PolicyInformation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class PolicyInformation  implements java.io.Serializable {
    private java.lang.Integer code;

    private java.lang.String message;

    private cn.com.sinosoft.common.service.axis.QueryModel[] model;

    public PolicyInformation() {
    }

    public PolicyInformation(
           java.lang.Integer code,
           java.lang.String message,
           cn.com.sinosoft.common.service.axis.QueryModel[] model) {
           this.code = code;
           this.message = message;
           this.model = model;
    }


    /**
     * Gets the code value for this PolicyInformation.
     * 
     * @return code
     */
    public java.lang.Integer getCode() {
        return code;
    }


    /**
     * Sets the code value for this PolicyInformation.
     * 
     * @param code
     */
    public void setCode(java.lang.Integer code) {
        this.code = code;
    }


    /**
     * Gets the message value for this PolicyInformation.
     * 
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this PolicyInformation.
     * 
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }


    /**
     * Gets the model value for this PolicyInformation.
     * 
     * @return model
     */
    public cn.com.sinosoft.common.service.axis.QueryModel[] getModel() {
        return model;
    }


    /**
     * Sets the model value for this PolicyInformation.
     * 
     * @param model
     */
    public void setModel(cn.com.sinosoft.common.service.axis.QueryModel[] model) {
        this.model = model;
    }

    public cn.com.sinosoft.common.service.axis.QueryModel getModel(int i) {
        return this.model[i];
    }

    public void setModel(int i, cn.com.sinosoft.common.service.axis.QueryModel _value) {
        this.model[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PolicyInformation)) return false;
        PolicyInformation other = (PolicyInformation) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.code==null && other.getCode()==null) || 
             (this.code!=null &&
              this.code.equals(other.getCode()))) &&
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            ((this.model==null && other.getModel()==null) || 
             (this.model!=null &&
              java.util.Arrays.equals(this.model, other.getModel())));
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
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        if (getModel() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getModel());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getModel(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PolicyInformation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "PolicyInformation"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("model");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "model"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "QueryModel"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
