/**
 * PolicyTransactionVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class PolicyTransactionVO  implements java.io.Serializable {
    private java.lang.String policyVersionNbr;

    private java.lang.String effectiveDate;

    private java.lang.String transType;

    private java.lang.String transAmt;

    public PolicyTransactionVO() {
    }

    public PolicyTransactionVO(
           java.lang.String policyVersionNbr,
           java.lang.String effectiveDate,
           java.lang.String transType,
           java.lang.String transAmt) {
           this.policyVersionNbr = policyVersionNbr;
           this.effectiveDate = effectiveDate;
           this.transType = transType;
           this.transAmt = transAmt;
    }


    /**
     * Gets the policyVersionNbr value for this PolicyTransactionVO.
     * 
     * @return policyVersionNbr
     */
    public java.lang.String getPolicyVersionNbr() {
        return policyVersionNbr;
    }


    /**
     * Sets the policyVersionNbr value for this PolicyTransactionVO.
     * 
     * @param policyVersionNbr
     */
    public void setPolicyVersionNbr(java.lang.String policyVersionNbr) {
        this.policyVersionNbr = policyVersionNbr;
    }


    /**
     * Gets the effectiveDate value for this PolicyTransactionVO.
     * 
     * @return effectiveDate
     */
    public java.lang.String getEffectiveDate() {
        return effectiveDate;
    }


    /**
     * Sets the effectiveDate value for this PolicyTransactionVO.
     * 
     * @param effectiveDate
     */
    public void setEffectiveDate(java.lang.String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    /**
     * Gets the transType value for this PolicyTransactionVO.
     * 
     * @return transType
     */
    public java.lang.String getTransType() {
        return transType;
    }


    /**
     * Sets the transType value for this PolicyTransactionVO.
     * 
     * @param transType
     */
    public void setTransType(java.lang.String transType) {
        this.transType = transType;
    }


    /**
     * Gets the transAmt value for this PolicyTransactionVO.
     * 
     * @return transAmt
     */
    public java.lang.String getTransAmt() {
        return transAmt;
    }


    /**
     * Sets the transAmt value for this PolicyTransactionVO.
     * 
     * @param transAmt
     */
    public void setTransAmt(java.lang.String transAmt) {
        this.transAmt = transAmt;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PolicyTransactionVO)) return false;
        PolicyTransactionVO other = (PolicyTransactionVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.policyVersionNbr==null && other.getPolicyVersionNbr()==null) || 
             (this.policyVersionNbr!=null &&
              this.policyVersionNbr.equals(other.getPolicyVersionNbr()))) &&
            ((this.effectiveDate==null && other.getEffectiveDate()==null) || 
             (this.effectiveDate!=null &&
              this.effectiveDate.equals(other.getEffectiveDate()))) &&
            ((this.transType==null && other.getTransType()==null) || 
             (this.transType!=null &&
              this.transType.equals(other.getTransType()))) &&
            ((this.transAmt==null && other.getTransAmt()==null) || 
             (this.transAmt!=null &&
              this.transAmt.equals(other.getTransAmt())));
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
        if (getPolicyVersionNbr() != null) {
            _hashCode += getPolicyVersionNbr().hashCode();
        }
        if (getEffectiveDate() != null) {
            _hashCode += getEffectiveDate().hashCode();
        }
        if (getTransType() != null) {
            _hashCode += getTransType().hashCode();
        }
        if (getTransAmt() != null) {
            _hashCode += getTransAmt().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PolicyTransactionVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyTransactionVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyVersionNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyVersionNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("effectiveDate");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "EffectiveDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transType");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "TransType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "TransAmt"));
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
