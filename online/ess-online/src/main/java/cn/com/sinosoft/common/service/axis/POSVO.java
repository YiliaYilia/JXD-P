/**
 * POSVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class POSVO  implements java.io.Serializable {
    private java.lang.String policyNbr;

    private java.lang.String clientNbr;

    private java.lang.String applicantName;

    private java.lang.String policyEffDate;

    private java.lang.String policyChangeType;

    private java.lang.String premiumStatus;

    private java.lang.String productName;

    private cn.com.sinosoft.common.service.axis.POSRider[] riderDetail;

    private java.lang.String policyLoanStatus;

    private java.lang.String loanDate;

    private java.lang.String repaymentStatus;

    private java.lang.String repaymentDate;

    public POSVO() {
    }

    public POSVO(
           java.lang.String policyNbr,
           java.lang.String clientNbr,
           java.lang.String applicantName,
           java.lang.String policyEffDate,
           java.lang.String policyChangeType,
           java.lang.String premiumStatus,
           java.lang.String productName,
           cn.com.sinosoft.common.service.axis.POSRider[] riderDetail,
           java.lang.String policyLoanStatus,
           java.lang.String loanDate,
           java.lang.String repaymentStatus,
           java.lang.String repaymentDate) {
           this.policyNbr = policyNbr;
           this.clientNbr = clientNbr;
           this.applicantName = applicantName;
           this.policyEffDate = policyEffDate;
           this.policyChangeType = policyChangeType;
           this.premiumStatus = premiumStatus;
           this.productName = productName;
           this.riderDetail = riderDetail;
           this.policyLoanStatus = policyLoanStatus;
           this.loanDate = loanDate;
           this.repaymentStatus = repaymentStatus;
           this.repaymentDate = repaymentDate;
    }


    /**
     * Gets the policyNbr value for this POSVO.
     * 
     * @return policyNbr
     */
    public java.lang.String getPolicyNbr() {
        return policyNbr;
    }


    /**
     * Sets the policyNbr value for this POSVO.
     * 
     * @param policyNbr
     */
    public void setPolicyNbr(java.lang.String policyNbr) {
        this.policyNbr = policyNbr;
    }


    /**
     * Gets the clientNbr value for this POSVO.
     * 
     * @return clientNbr
     */
    public java.lang.String getClientNbr() {
        return clientNbr;
    }


    /**
     * Sets the clientNbr value for this POSVO.
     * 
     * @param clientNbr
     */
    public void setClientNbr(java.lang.String clientNbr) {
        this.clientNbr = clientNbr;
    }


    /**
     * Gets the applicantName value for this POSVO.
     * 
     * @return applicantName
     */
    public java.lang.String getApplicantName() {
        return applicantName;
    }


    /**
     * Sets the applicantName value for this POSVO.
     * 
     * @param applicantName
     */
    public void setApplicantName(java.lang.String applicantName) {
        this.applicantName = applicantName;
    }


    /**
     * Gets the policyEffDate value for this POSVO.
     * 
     * @return policyEffDate
     */
    public java.lang.String getPolicyEffDate() {
        return policyEffDate;
    }


    /**
     * Sets the policyEffDate value for this POSVO.
     * 
     * @param policyEffDate
     */
    public void setPolicyEffDate(java.lang.String policyEffDate) {
        this.policyEffDate = policyEffDate;
    }


    /**
     * Gets the policyChangeType value for this POSVO.
     * 
     * @return policyChangeType
     */
    public java.lang.String getPolicyChangeType() {
        return policyChangeType;
    }


    /**
     * Sets the policyChangeType value for this POSVO.
     * 
     * @param policyChangeType
     */
    public void setPolicyChangeType(java.lang.String policyChangeType) {
        this.policyChangeType = policyChangeType;
    }


    /**
     * Gets the premiumStatus value for this POSVO.
     * 
     * @return premiumStatus
     */
    public java.lang.String getPremiumStatus() {
        return premiumStatus;
    }


    /**
     * Sets the premiumStatus value for this POSVO.
     * 
     * @param premiumStatus
     */
    public void setPremiumStatus(java.lang.String premiumStatus) {
        this.premiumStatus = premiumStatus;
    }


    /**
     * Gets the productName value for this POSVO.
     * 
     * @return productName
     */
    public java.lang.String getProductName() {
        return productName;
    }


    /**
     * Sets the productName value for this POSVO.
     * 
     * @param productName
     */
    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }


    /**
     * Gets the riderDetail value for this POSVO.
     * 
     * @return riderDetail
     */
    public cn.com.sinosoft.common.service.axis.POSRider[] getRiderDetail() {
        return riderDetail;
    }


    /**
     * Sets the riderDetail value for this POSVO.
     * 
     * @param riderDetail
     */
    public void setRiderDetail(cn.com.sinosoft.common.service.axis.POSRider[] riderDetail) {
        this.riderDetail = riderDetail;
    }


    /**
     * Gets the policyLoanStatus value for this POSVO.
     * 
     * @return policyLoanStatus
     */
    public java.lang.String getPolicyLoanStatus() {
        return policyLoanStatus;
    }


    /**
     * Sets the policyLoanStatus value for this POSVO.
     * 
     * @param policyLoanStatus
     */
    public void setPolicyLoanStatus(java.lang.String policyLoanStatus) {
        this.policyLoanStatus = policyLoanStatus;
    }


    /**
     * Gets the loanDate value for this POSVO.
     * 
     * @return loanDate
     */
    public java.lang.String getLoanDate() {
        return loanDate;
    }


    /**
     * Sets the loanDate value for this POSVO.
     * 
     * @param loanDate
     */
    public void setLoanDate(java.lang.String loanDate) {
        this.loanDate = loanDate;
    }


    /**
     * Gets the repaymentStatus value for this POSVO.
     * 
     * @return repaymentStatus
     */
    public java.lang.String getRepaymentStatus() {
        return repaymentStatus;
    }


    /**
     * Sets the repaymentStatus value for this POSVO.
     * 
     * @param repaymentStatus
     */
    public void setRepaymentStatus(java.lang.String repaymentStatus) {
        this.repaymentStatus = repaymentStatus;
    }


    /**
     * Gets the repaymentDate value for this POSVO.
     * 
     * @return repaymentDate
     */
    public java.lang.String getRepaymentDate() {
        return repaymentDate;
    }


    /**
     * Sets the repaymentDate value for this POSVO.
     * 
     * @param repaymentDate
     */
    public void setRepaymentDate(java.lang.String repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof POSVO)) return false;
        POSVO other = (POSVO) obj;
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
            ((this.clientNbr==null && other.getClientNbr()==null) || 
             (this.clientNbr!=null &&
              this.clientNbr.equals(other.getClientNbr()))) &&
            ((this.applicantName==null && other.getApplicantName()==null) || 
             (this.applicantName!=null &&
              this.applicantName.equals(other.getApplicantName()))) &&
            ((this.policyEffDate==null && other.getPolicyEffDate()==null) || 
             (this.policyEffDate!=null &&
              this.policyEffDate.equals(other.getPolicyEffDate()))) &&
            ((this.policyChangeType==null && other.getPolicyChangeType()==null) || 
             (this.policyChangeType!=null &&
              this.policyChangeType.equals(other.getPolicyChangeType()))) &&
            ((this.premiumStatus==null && other.getPremiumStatus()==null) || 
             (this.premiumStatus!=null &&
              this.premiumStatus.equals(other.getPremiumStatus()))) &&
            ((this.productName==null && other.getProductName()==null) || 
             (this.productName!=null &&
              this.productName.equals(other.getProductName()))) &&
            ((this.riderDetail==null && other.getRiderDetail()==null) || 
             (this.riderDetail!=null &&
              java.util.Arrays.equals(this.riderDetail, other.getRiderDetail()))) &&
            ((this.policyLoanStatus==null && other.getPolicyLoanStatus()==null) || 
             (this.policyLoanStatus!=null &&
              this.policyLoanStatus.equals(other.getPolicyLoanStatus()))) &&
            ((this.loanDate==null && other.getLoanDate()==null) || 
             (this.loanDate!=null &&
              this.loanDate.equals(other.getLoanDate()))) &&
            ((this.repaymentStatus==null && other.getRepaymentStatus()==null) || 
             (this.repaymentStatus!=null &&
              this.repaymentStatus.equals(other.getRepaymentStatus()))) &&
            ((this.repaymentDate==null && other.getRepaymentDate()==null) || 
             (this.repaymentDate!=null &&
              this.repaymentDate.equals(other.getRepaymentDate())));
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
        if (getClientNbr() != null) {
            _hashCode += getClientNbr().hashCode();
        }
        if (getApplicantName() != null) {
            _hashCode += getApplicantName().hashCode();
        }
        if (getPolicyEffDate() != null) {
            _hashCode += getPolicyEffDate().hashCode();
        }
        if (getPolicyChangeType() != null) {
            _hashCode += getPolicyChangeType().hashCode();
        }
        if (getPremiumStatus() != null) {
            _hashCode += getPremiumStatus().hashCode();
        }
        if (getProductName() != null) {
            _hashCode += getProductName().hashCode();
        }
        if (getRiderDetail() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRiderDetail());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRiderDetail(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPolicyLoanStatus() != null) {
            _hashCode += getPolicyLoanStatus().hashCode();
        }
        if (getLoanDate() != null) {
            _hashCode += getLoanDate().hashCode();
        }
        if (getRepaymentStatus() != null) {
            _hashCode += getRepaymentStatus().hashCode();
        }
        if (getRepaymentDate() != null) {
            _hashCode += getRepaymentDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(POSVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "POSVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyNbr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientNbr");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "ClientNbr"));
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
        elemField.setFieldName("policyChangeType");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyChangeType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("premiumStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "PremiumStatus"));
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
        elemField.setFieldName("riderDetail");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "RiderDetail"));
        elemField.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "POSRider"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "POSRider"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyLoanStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyLoanStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loanDate");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "LoanDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("repaymentStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "RepaymentStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("repaymentDate");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "RepaymentDate"));
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
