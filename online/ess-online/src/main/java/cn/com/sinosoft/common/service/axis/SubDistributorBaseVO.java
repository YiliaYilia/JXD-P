/**
 * SubDistributorBaseVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class SubDistributorBaseVO  implements java.io.Serializable {
    private java.lang.String subDistributorName;

    private java.lang.String subDistributorCode;

    private java.lang.String subDistributorLevel;

    public SubDistributorBaseVO() {
    }

    public SubDistributorBaseVO(
           java.lang.String subDistributorName,
           java.lang.String subDistributorCode,
           java.lang.String subDistributorLevel) {
           this.subDistributorName = subDistributorName;
           this.subDistributorCode = subDistributorCode;
           this.subDistributorLevel = subDistributorLevel;
    }


    /**
     * Gets the subDistributorName value for this SubDistributorBaseVO.
     * 
     * @return subDistributorName
     */
    public java.lang.String getSubDistributorName() {
        return subDistributorName;
    }


    /**
     * Sets the subDistributorName value for this SubDistributorBaseVO.
     * 
     * @param subDistributorName
     */
    public void setSubDistributorName(java.lang.String subDistributorName) {
        this.subDistributorName = subDistributorName;
    }


    /**
     * Gets the subDistributorCode value for this SubDistributorBaseVO.
     * 
     * @return subDistributorCode
     */
    public java.lang.String getSubDistributorCode() {
        return subDistributorCode;
    }


    /**
     * Sets the subDistributorCode value for this SubDistributorBaseVO.
     * 
     * @param subDistributorCode
     */
    public void setSubDistributorCode(java.lang.String subDistributorCode) {
        this.subDistributorCode = subDistributorCode;
    }


    /**
     * Gets the subDistributorLevel value for this SubDistributorBaseVO.
     * 
     * @return subDistributorLevel
     */
    public java.lang.String getSubDistributorLevel() {
        return subDistributorLevel;
    }


    /**
     * Sets the subDistributorLevel value for this SubDistributorBaseVO.
     * 
     * @param subDistributorLevel
     */
    public void setSubDistributorLevel(java.lang.String subDistributorLevel) {
        this.subDistributorLevel = subDistributorLevel;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SubDistributorBaseVO)) return false;
        SubDistributorBaseVO other = (SubDistributorBaseVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.subDistributorName==null && other.getSubDistributorName()==null) || 
             (this.subDistributorName!=null &&
              this.subDistributorName.equals(other.getSubDistributorName()))) &&
            ((this.subDistributorCode==null && other.getSubDistributorCode()==null) || 
             (this.subDistributorCode!=null &&
              this.subDistributorCode.equals(other.getSubDistributorCode()))) &&
            ((this.subDistributorLevel==null && other.getSubDistributorLevel()==null) || 
             (this.subDistributorLevel!=null &&
              this.subDistributorLevel.equals(other.getSubDistributorLevel())));
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
        if (getSubDistributorName() != null) {
            _hashCode += getSubDistributorName().hashCode();
        }
        if (getSubDistributorCode() != null) {
            _hashCode += getSubDistributorCode().hashCode();
        }
        if (getSubDistributorLevel() != null) {
            _hashCode += getSubDistributorLevel().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SubDistributorBaseVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "SubDistributorBaseVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subDistributorName");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "SubDistributorName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subDistributorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "SubDistributorCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subDistributorLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "SubDistributorLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
