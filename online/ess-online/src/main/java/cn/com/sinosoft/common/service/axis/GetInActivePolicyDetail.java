/**
 * GetInActivePolicyDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class GetInActivePolicyDetail  implements java.io.Serializable {
    private String operator;

    private String systemCode;

    private String policyCode;

    public GetInActivePolicyDetail() {
    }

    public GetInActivePolicyDetail(
           String operator,
           String systemCode,
           String policyCode) {
           this.operator = operator;
           this.systemCode = systemCode;
           this.policyCode = policyCode;
    }


    /**
     * Gets the operator value for this GetInActivePolicyDetail.
     * 
     * @return operator
     */
    public String getOperator() {
        return operator;
    }


    /**
     * Sets the operator value for this GetInActivePolicyDetail.
     * 
     * @param operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }


    /**
     * Gets the systemCode value for this GetInActivePolicyDetail.
     * 
     * @return systemCode
     */
    public String getSystemCode() {
        return systemCode;
    }


    /**
     * Sets the systemCode value for this GetInActivePolicyDetail.
     * 
     * @param systemCode
     */
    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }


    /**
     * Gets the policyCode value for this GetInActivePolicyDetail.
     * 
     * @return policyCode
     */
    public String getPolicyCode() {
        return policyCode;
    }


    /**
     * Sets the policyCode value for this GetInActivePolicyDetail.
     * 
     * @param policyCode
     */
    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof GetInActivePolicyDetail)) return false;
        GetInActivePolicyDetail other = (GetInActivePolicyDetail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.operator==null && other.getOperator()==null) || 
             (this.operator!=null &&
              this.operator.equals(other.getOperator()))) &&
            ((this.systemCode==null && other.getSystemCode()==null) || 
             (this.systemCode!=null &&
              this.systemCode.equals(other.getSystemCode()))) &&
            ((this.policyCode==null && other.getPolicyCode()==null) || 
             (this.policyCode!=null &&
              this.policyCode.equals(other.getPolicyCode())));
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
        if (getOperator() != null) {
            _hashCode += getOperator().hashCode();
        }
        if (getSystemCode() != null) {
            _hashCode += getSystemCode().hashCode();
        }
        if (getPolicyCode() != null) {
            _hashCode += getPolicyCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetInActivePolicyDetail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.sinosoft.com", ">getInActivePolicyDetail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operator");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "operator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("systemCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "systemCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "policyCode"));
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
