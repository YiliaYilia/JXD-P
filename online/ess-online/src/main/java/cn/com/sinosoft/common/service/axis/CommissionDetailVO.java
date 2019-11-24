/**
 * CommissionDetailVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class CommissionDetailVO  implements java.io.Serializable {
    private java.lang.String policyNbr;

    private java.lang.String applicantName;

    private java.lang.String policyEffDate;

    private java.lang.String premiumPaid;

    private java.lang.String totalCommAmt;

    private java.lang.String commStatus;

    public CommissionDetailVO() {
    }

    public CommissionDetailVO(
           java.lang.String policyNbr,
           java.lang.String applicantName,
           java.lang.String policyEffDate,
           java.lang.String premiumPaid,
           java.lang.String totalCommAmt,
           java.lang.String commStatus) {
           this.policyNbr = policyNbr;
           this.applicantName = applicantName;
           this.policyEffDate = policyEffDate;
           this.premiumPaid = premiumPaid;
           this.totalCommAmt = totalCommAmt;
           this.commStatus = commStatus;
    }


    /**
     * Gets the policyNbr value for this CommissionDetailVO.
     * 
     * @return policyNbr
     */
    public java.lang.String getPolicyNbr() {
        return policyNbr;
    }


    /**
     * Sets the policyNbr value for this CommissionDetailVO.
     * 
     * @param policyNbr
     */
    public void setPolicyNbr(java.lang.String policyNbr) {
        this.policyNbr = policyNbr;
    }


    /**
     * Gets the applicantName value for this CommissionDetailVO.
     * 
     * @return applicantName
     */
    public java.lang.String getApplicantName() {
        return applicantName;
    }


    /**
     * Sets the applicantName value for this CommissionDetailVO.
     * 
     * @param applicantName
     */
    public void setApplicantName(java.lang.String applicantName) {
        this.applicantName = applicantName;
    }


    /**
     * Gets the policyEffDate value for this CommissionDetailVO.
     * 
     * @return policyEffDate
     */
    public java.lang.String getPolicyEffDate() {
        return policyEffDate;
    }


    /**
     * Sets the policyEffDate value for this CommissionDetailVO.
     * 
     * @param policyEffDate
     */
    public void setPolicyEffDate(java.lang.String policyEffDate) {
        this.policyEffDate = policyEffDate;
    }


    /**
     * Gets the premiumPaid value for this CommissionDetailVO.
     * 
     * @return premiumPaid
     */
    public java.lang.String getPremiumPaid() {
        return premiumPaid;
    }


    /**
     * Sets the premiumPaid value for this CommissionDetailVO.
     * 
     * @param premiumPaid
     */
    public void setPremiumPaid(java.lang.String premiumPaid) {
        this.premiumPaid = premiumPaid;
    }


    /**
     * Gets the totalCommAmt value for this CommissionDetailVO.
     * 
     * @return totalCommAmt
     */
    public java.lang.String getTotalCommAmt() {
        return totalCommAmt;
    }


    /**
     * Sets the totalCommAmt value for this CommissionDetailVO.
     * 
     * @param totalCommAmt
     */
    public void setTotalCommAmt(java.lang.String totalCommAmt) {
        this.totalCommAmt = totalCommAmt;
    }


    /**
     * Gets the commStatus value for this CommissionDetailVO.
     * 
     * @return commStatus
     */
    public java.lang.String getCommStatus() {
        return commStatus;
    }


    /**
     * Sets the commStatus value for this CommissionDetailVO.
     * 
     * @param commStatus
     */
    public void setCommStatus(java.lang.String commStatus) {
        this.commStatus = commStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CommissionDetailVO)) return false;
        CommissionDetailVO other = (CommissionDetailVO) obj;
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
            ((this.applicantName==null && other.getApplicantName()==null) || 
             (this.applicantName!=null &&
              this.applicantName.equals(other.getApplicantName()))) &&
            ((this.policyEffDate==null && other.getPolicyEffDate()==null) || 
             (this.policyEffDate!=null &&
              this.policyEffDate.equals(other.getPolicyEffDate()))) &&
            ((this.premiumPaid==null && other.getPremiumPaid()==null) || 
             (this.premiumPaid!=null &&
              this.premiumPaid.equals(other.getPremiumPaid()))) &&
            ((this.totalCommAmt==null && other.getTotalCommAmt()==null) || 
             (this.totalCommAmt!=null &&
              this.totalCommAmt.equals(other.getTotalCommAmt()))) &&
            ((this.commStatus==null && other.getCommStatus()==null) || 
             (this.commStatus!=null &&
              this.commStatus.equals(other.getCommStatus())));
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
        if (getApplicantName() != null) {
            _hashCode += getApplicantName().hashCode();
        }
        if (getPolicyEffDate() != null) {
            _hashCode += getPolicyEffDate().hashCode();
        }
        if (getPremiumPaid() != null) {
            _hashCode += getPremiumPaid().hashCode();
        }
        if (getTotalCommAmt() != null) {
            _hashCode += getTotalCommAmt().hashCode();
        }
        if (getCommStatus() != null) {
            _hashCode += getCommStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CommissionDetailVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "CommissionDetailVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyNbr"));
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
        elemField.setFieldName("policyEffDate");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyEffDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("premiumPaid");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "PremiumPaid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalCommAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "TotalCommAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "CommStatus"));
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
