/**
 * ClaimSettlementVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class ClaimSettlementVO  implements java.io.Serializable {
    private java.lang.String policyNbr;

    private java.lang.String productName;

    private java.lang.String applicantName;

    private java.lang.String customerNbr;

    private java.lang.String policyEffectiveDate;

    private java.lang.String settlementType;

    private java.lang.String settlementStatus;

    public ClaimSettlementVO() {
    }

    public ClaimSettlementVO(
           java.lang.String policyNbr,
           java.lang.String productName,
           java.lang.String applicantName,
           java.lang.String customerNbr,
           java.lang.String policyEffectiveDate,
           java.lang.String settlementType,
           java.lang.String settlementStatus) {
           this.policyNbr = policyNbr;
           this.productName = productName;
           this.applicantName = applicantName;
           this.customerNbr = customerNbr;
           this.policyEffectiveDate = policyEffectiveDate;
           this.settlementType = settlementType;
           this.settlementStatus = settlementStatus;
    }


    /**
     * Gets the policyNbr value for this ClaimSettlementVO.
     * 
     * @return policyNbr
     */
    public java.lang.String getPolicyNbr() {
        return policyNbr;
    }


    /**
     * Sets the policyNbr value for this ClaimSettlementVO.
     * 
     * @param policyNbr
     */
    public void setPolicyNbr(java.lang.String policyNbr) {
        this.policyNbr = policyNbr;
    }


    /**
     * Gets the productName value for this ClaimSettlementVO.
     * 
     * @return productName
     */
    public java.lang.String getProductName() {
        return productName;
    }


    /**
     * Sets the productName value for this ClaimSettlementVO.
     * 
     * @param productName
     */
    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }


    /**
     * Gets the applicantName value for this ClaimSettlementVO.
     * 
     * @return applicantName
     */
    public java.lang.String getApplicantName() {
        return applicantName;
    }


    /**
     * Sets the applicantName value for this ClaimSettlementVO.
     * 
     * @param applicantName
     */
    public void setApplicantName(java.lang.String applicantName) {
        this.applicantName = applicantName;
    }


    /**
     * Gets the customerNbr value for this ClaimSettlementVO.
     * 
     * @return customerNbr
     */
    public java.lang.String getCustomerNbr() {
        return customerNbr;
    }


    /**
     * Sets the customerNbr value for this ClaimSettlementVO.
     * 
     * @param customerNbr
     */
    public void setCustomerNbr(java.lang.String customerNbr) {
        this.customerNbr = customerNbr;
    }


    /**
     * Gets the policyEffectiveDate value for this ClaimSettlementVO.
     * 
     * @return policyEffectiveDate
     */
    public java.lang.String getPolicyEffectiveDate() {
        return policyEffectiveDate;
    }


    /**
     * Sets the policyEffectiveDate value for this ClaimSettlementVO.
     * 
     * @param policyEffectiveDate
     */
    public void setPolicyEffectiveDate(java.lang.String policyEffectiveDate) {
        this.policyEffectiveDate = policyEffectiveDate;
    }


    /**
     * Gets the settlementType value for this ClaimSettlementVO.
     * 
     * @return settlementType
     */
    public java.lang.String getSettlementType() {
        return settlementType;
    }


    /**
     * Sets the settlementType value for this ClaimSettlementVO.
     * 
     * @param settlementType
     */
    public void setSettlementType(java.lang.String settlementType) {
        this.settlementType = settlementType;
    }


    /**
     * Gets the settlementStatus value for this ClaimSettlementVO.
     * 
     * @return settlementStatus
     */
    public java.lang.String getSettlementStatus() {
        return settlementStatus;
    }


    /**
     * Sets the settlementStatus value for this ClaimSettlementVO.
     * 
     * @param settlementStatus
     */
    public void setSettlementStatus(java.lang.String settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClaimSettlementVO)) return false;
        ClaimSettlementVO other = (ClaimSettlementVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.policyNbr==null && other.getPolicyNbr()==null) || 
             (this.policyNbr!=null &&
              this.policyNbr.equals(other.getPolicyNbr()))) &&
            ((this.productName==null && other.getProductName()==null) || 
             (this.productName!=null &&
              this.productName.equals(other.getProductName()))) &&
            ((this.applicantName==null && other.getApplicantName()==null) || 
             (this.applicantName!=null &&
              this.applicantName.equals(other.getApplicantName()))) &&
            ((this.customerNbr==null && other.getCustomerNbr()==null) || 
             (this.customerNbr!=null &&
              this.customerNbr.equals(other.getCustomerNbr()))) &&
            ((this.policyEffectiveDate==null && other.getPolicyEffectiveDate()==null) || 
             (this.policyEffectiveDate!=null &&
              this.policyEffectiveDate.equals(other.getPolicyEffectiveDate()))) &&
            ((this.settlementType==null && other.getSettlementType()==null) || 
             (this.settlementType!=null &&
              this.settlementType.equals(other.getSettlementType()))) &&
            ((this.settlementStatus==null && other.getSettlementStatus()==null) || 
             (this.settlementStatus!=null &&
              this.settlementStatus.equals(other.getSettlementStatus())));
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
        if (getPolicyNbr() != null) {
            _hashCode += getPolicyNbr().hashCode();
        }
        if (getProductName() != null) {
            _hashCode += getProductName().hashCode();
        }
        if (getApplicantName() != null) {
            _hashCode += getApplicantName().hashCode();
        }
        if (getCustomerNbr() != null) {
            _hashCode += getCustomerNbr().hashCode();
        }
        if (getPolicyEffectiveDate() != null) {
            _hashCode += getPolicyEffectiveDate().hashCode();
        }
        if (getSettlementType() != null) {
            _hashCode += getSettlementType().hashCode();
        }
        if (getSettlementStatus() != null) {
            _hashCode += getSettlementStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClaimSettlementVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "ClaimSettlementVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productName");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "ProductName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicantName");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "ApplicantName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "CustomerNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyEffectiveDate");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyEffectiveDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("settlementType");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "SettlementType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("settlementStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "SettlementStatus"));
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
