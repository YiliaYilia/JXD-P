/**
 * TopUpVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class TopUpVO  implements java.io.Serializable {
    private java.lang.String policyHolderName;

    private java.lang.String policyNbr;

    private java.lang.String clientNbr;

    private java.lang.String effectiveDate;

    private java.lang.String sellingInst;

    private java.lang.String distributorName;

    private java.lang.String distributorContactNbr1;

    private java.lang.String distributorContactNbr2;

    private java.lang.String distributorContactNbr3;

    private java.lang.String productName;

    private java.lang.String insuredTerm;

    private java.lang.Boolean riderYN;

    private java.lang.String insuredAmt;

    private cn.com.sinosoft.common.service.axis.AccountIdVO[] accountVO;

    private java.lang.String sellingInstID;

    private java.lang.String distributorID;

    private java.lang.String productCodeN;

    private java.lang.String unitTerm;

    public TopUpVO() {
    }

    public TopUpVO(
           java.lang.String policyHolderName,
           java.lang.String policyNbr,
           java.lang.String clientNbr,
           java.lang.String effectiveDate,
           java.lang.String sellingInst,
           java.lang.String distributorName,
           java.lang.String distributorContactNbr1,
           java.lang.String distributorContactNbr2,
           java.lang.String distributorContactNbr3,
           java.lang.String productName,
           java.lang.String insuredTerm,
           java.lang.Boolean riderYN,
           java.lang.String insuredAmt,
           cn.com.sinosoft.common.service.axis.AccountIdVO[] accountVO,
           java.lang.String sellingInstID,
           java.lang.String distributorID,
           java.lang.String productCodeN,
           java.lang.String unitTerm) {
           this.policyHolderName = policyHolderName;
           this.policyNbr = policyNbr;
           this.clientNbr = clientNbr;
           this.effectiveDate = effectiveDate;
           this.sellingInst = sellingInst;
           this.distributorName = distributorName;
           this.distributorContactNbr1 = distributorContactNbr1;
           this.distributorContactNbr2 = distributorContactNbr2;
           this.distributorContactNbr3 = distributorContactNbr3;
           this.productName = productName;
           this.insuredTerm = insuredTerm;
           this.riderYN = riderYN;
           this.insuredAmt = insuredAmt;
           this.accountVO = accountVO;
           this.sellingInstID = sellingInstID;
           this.distributorID = distributorID;
           this.productCodeN = productCodeN;
           this.unitTerm = unitTerm;
    }


    /**
     * Gets the policyHolderName value for this TopUpVO.
     * 
     * @return policyHolderName
     */
    public java.lang.String getPolicyHolderName() {
        return policyHolderName;
    }


    /**
     * Sets the policyHolderName value for this TopUpVO.
     * 
     * @param policyHolderName
     */
    public void setPolicyHolderName(java.lang.String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }


    /**
     * Gets the policyNbr value for this TopUpVO.
     * 
     * @return policyNbr
     */
    public java.lang.String getPolicyNbr() {
        return policyNbr;
    }


    /**
     * Sets the policyNbr value for this TopUpVO.
     * 
     * @param policyNbr
     */
    public void setPolicyNbr(java.lang.String policyNbr) {
        this.policyNbr = policyNbr;
    }


    /**
     * Gets the clientNbr value for this TopUpVO.
     * 
     * @return clientNbr
     */
    public java.lang.String getClientNbr() {
        return clientNbr;
    }


    /**
     * Sets the clientNbr value for this TopUpVO.
     * 
     * @param clientNbr
     */
    public void setClientNbr(java.lang.String clientNbr) {
        this.clientNbr = clientNbr;
    }


    /**
     * Gets the effectiveDate value for this TopUpVO.
     * 
     * @return effectiveDate
     */
    public java.lang.String getEffectiveDate() {
        return effectiveDate;
    }


    /**
     * Sets the effectiveDate value for this TopUpVO.
     * 
     * @param effectiveDate
     */
    public void setEffectiveDate(java.lang.String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    /**
     * Gets the sellingInst value for this TopUpVO.
     * 
     * @return sellingInst
     */
    public java.lang.String getSellingInst() {
        return sellingInst;
    }


    /**
     * Sets the sellingInst value for this TopUpVO.
     * 
     * @param sellingInst
     */
    public void setSellingInst(java.lang.String sellingInst) {
        this.sellingInst = sellingInst;
    }


    /**
     * Gets the distributorName value for this TopUpVO.
     * 
     * @return distributorName
     */
    public java.lang.String getDistributorName() {
        return distributorName;
    }


    /**
     * Sets the distributorName value for this TopUpVO.
     * 
     * @param distributorName
     */
    public void setDistributorName(java.lang.String distributorName) {
        this.distributorName = distributorName;
    }


    /**
     * Gets the distributorContactNbr1 value for this TopUpVO.
     * 
     * @return distributorContactNbr1
     */
    public java.lang.String getDistributorContactNbr1() {
        return distributorContactNbr1;
    }


    /**
     * Sets the distributorContactNbr1 value for this TopUpVO.
     * 
     * @param distributorContactNbr1
     */
    public void setDistributorContactNbr1(java.lang.String distributorContactNbr1) {
        this.distributorContactNbr1 = distributorContactNbr1;
    }


    /**
     * Gets the distributorContactNbr2 value for this TopUpVO.
     * 
     * @return distributorContactNbr2
     */
    public java.lang.String getDistributorContactNbr2() {
        return distributorContactNbr2;
    }


    /**
     * Sets the distributorContactNbr2 value for this TopUpVO.
     * 
     * @param distributorContactNbr2
     */
    public void setDistributorContactNbr2(java.lang.String distributorContactNbr2) {
        this.distributorContactNbr2 = distributorContactNbr2;
    }


    /**
     * Gets the distributorContactNbr3 value for this TopUpVO.
     * 
     * @return distributorContactNbr3
     */
    public java.lang.String getDistributorContactNbr3() {
        return distributorContactNbr3;
    }


    /**
     * Sets the distributorContactNbr3 value for this TopUpVO.
     * 
     * @param distributorContactNbr3
     */
    public void setDistributorContactNbr3(java.lang.String distributorContactNbr3) {
        this.distributorContactNbr3 = distributorContactNbr3;
    }


    /**
     * Gets the productName value for this TopUpVO.
     * 
     * @return productName
     */
    public java.lang.String getProductName() {
        return productName;
    }


    /**
     * Sets the productName value for this TopUpVO.
     * 
     * @param productName
     */
    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }


    /**
     * Gets the insuredTerm value for this TopUpVO.
     * 
     * @return insuredTerm
     */
    public java.lang.String getInsuredTerm() {
        return insuredTerm;
    }


    /**
     * Sets the insuredTerm value for this TopUpVO.
     * 
     * @param insuredTerm
     */
    public void setInsuredTerm(java.lang.String insuredTerm) {
        this.insuredTerm = insuredTerm;
    }


    /**
     * Gets the riderYN value for this TopUpVO.
     * 
     * @return riderYN
     */
    public java.lang.Boolean getRiderYN() {
        return riderYN;
    }


    /**
     * Sets the riderYN value for this TopUpVO.
     * 
     * @param riderYN
     */
    public void setRiderYN(java.lang.Boolean riderYN) {
        this.riderYN = riderYN;
    }


    /**
     * Gets the insuredAmt value for this TopUpVO.
     * 
     * @return insuredAmt
     */
    public java.lang.String getInsuredAmt() {
        return insuredAmt;
    }


    /**
     * Sets the insuredAmt value for this TopUpVO.
     * 
     * @param insuredAmt
     */
    public void setInsuredAmt(java.lang.String insuredAmt) {
        this.insuredAmt = insuredAmt;
    }


    /**
     * Gets the accountVO value for this TopUpVO.
     * 
     * @return accountVO
     */
    public cn.com.sinosoft.common.service.axis.AccountIdVO[] getAccountVO() {
        return accountVO;
    }


    /**
     * Sets the accountVO value for this TopUpVO.
     * 
     * @param accountVO
     */
    public void setAccountVO(cn.com.sinosoft.common.service.axis.AccountIdVO[] accountVO) {
        this.accountVO = accountVO;
    }


    /**
     * Gets the sellingInstID value for this TopUpVO.
     * 
     * @return sellingInstID
     */
    public java.lang.String getSellingInstID() {
        return sellingInstID;
    }


    /**
     * Sets the sellingInstID value for this TopUpVO.
     * 
     * @param sellingInstID
     */
    public void setSellingInstID(java.lang.String sellingInstID) {
        this.sellingInstID = sellingInstID;
    }


    /**
     * Gets the distributorID value for this TopUpVO.
     * 
     * @return distributorID
     */
    public java.lang.String getDistributorID() {
        return distributorID;
    }


    /**
     * Sets the distributorID value for this TopUpVO.
     * 
     * @param distributorID
     */
    public void setDistributorID(java.lang.String distributorID) {
        this.distributorID = distributorID;
    }


    /**
     * Gets the productCodeN value for this TopUpVO.
     * 
     * @return productCodeN
     */
    public java.lang.String getProductCodeN() {
        return productCodeN;
    }


    /**
     * Sets the productCodeN value for this TopUpVO.
     * 
     * @param productCodeN
     */
    public void setProductCodeN(java.lang.String productCodeN) {
        this.productCodeN = productCodeN;
    }


    /**
     * Gets the unitTerm value for this TopUpVO.
     * 
     * @return unitTerm
     */
    public java.lang.String getUnitTerm() {
        return unitTerm;
    }


    /**
     * Sets the unitTerm value for this TopUpVO.
     * 
     * @param unitTerm
     */
    public void setUnitTerm(java.lang.String unitTerm) {
        this.unitTerm = unitTerm;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TopUpVO)) return false;
        TopUpVO other = (TopUpVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.policyHolderName==null && other.getPolicyHolderName()==null) || 
             (this.policyHolderName!=null &&
              this.policyHolderName.equals(other.getPolicyHolderName()))) &&
            ((this.policyNbr==null && other.getPolicyNbr()==null) || 
             (this.policyNbr!=null &&
              this.policyNbr.equals(other.getPolicyNbr()))) &&
            ((this.clientNbr==null && other.getClientNbr()==null) || 
             (this.clientNbr!=null &&
              this.clientNbr.equals(other.getClientNbr()))) &&
            ((this.effectiveDate==null && other.getEffectiveDate()==null) || 
             (this.effectiveDate!=null &&
              this.effectiveDate.equals(other.getEffectiveDate()))) &&
            ((this.sellingInst==null && other.getSellingInst()==null) || 
             (this.sellingInst!=null &&
              this.sellingInst.equals(other.getSellingInst()))) &&
            ((this.distributorName==null && other.getDistributorName()==null) || 
             (this.distributorName!=null &&
              this.distributorName.equals(other.getDistributorName()))) &&
            ((this.distributorContactNbr1==null && other.getDistributorContactNbr1()==null) || 
             (this.distributorContactNbr1!=null &&
              this.distributorContactNbr1.equals(other.getDistributorContactNbr1()))) &&
            ((this.distributorContactNbr2==null && other.getDistributorContactNbr2()==null) || 
             (this.distributorContactNbr2!=null &&
              this.distributorContactNbr2.equals(other.getDistributorContactNbr2()))) &&
            ((this.distributorContactNbr3==null && other.getDistributorContactNbr3()==null) || 
             (this.distributorContactNbr3!=null &&
              this.distributorContactNbr3.equals(other.getDistributorContactNbr3()))) &&
            ((this.productName==null && other.getProductName()==null) || 
             (this.productName!=null &&
              this.productName.equals(other.getProductName()))) &&
            ((this.insuredTerm==null && other.getInsuredTerm()==null) || 
             (this.insuredTerm!=null &&
              this.insuredTerm.equals(other.getInsuredTerm()))) &&
            ((this.riderYN==null && other.getRiderYN()==null) || 
             (this.riderYN!=null &&
              this.riderYN.equals(other.getRiderYN()))) &&
            ((this.insuredAmt==null && other.getInsuredAmt()==null) || 
             (this.insuredAmt!=null &&
              this.insuredAmt.equals(other.getInsuredAmt()))) &&
            ((this.accountVO==null && other.getAccountVO()==null) || 
             (this.accountVO!=null &&
              java.util.Arrays.equals(this.accountVO, other.getAccountVO()))) &&
            ((this.sellingInstID==null && other.getSellingInstID()==null) || 
             (this.sellingInstID!=null &&
              this.sellingInstID.equals(other.getSellingInstID()))) &&
            ((this.distributorID==null && other.getDistributorID()==null) || 
             (this.distributorID!=null &&
              this.distributorID.equals(other.getDistributorID()))) &&
            ((this.productCodeN==null && other.getProductCodeN()==null) || 
             (this.productCodeN!=null &&
              this.productCodeN.equals(other.getProductCodeN()))) &&
            ((this.unitTerm==null && other.getUnitTerm()==null) || 
             (this.unitTerm!=null &&
              this.unitTerm.equals(other.getUnitTerm())));
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
        if (getPolicyHolderName() != null) {
            _hashCode += getPolicyHolderName().hashCode();
        }
        if (getPolicyNbr() != null) {
            _hashCode += getPolicyNbr().hashCode();
        }
        if (getClientNbr() != null) {
            _hashCode += getClientNbr().hashCode();
        }
        if (getEffectiveDate() != null) {
            _hashCode += getEffectiveDate().hashCode();
        }
        if (getSellingInst() != null) {
            _hashCode += getSellingInst().hashCode();
        }
        if (getDistributorName() != null) {
            _hashCode += getDistributorName().hashCode();
        }
        if (getDistributorContactNbr1() != null) {
            _hashCode += getDistributorContactNbr1().hashCode();
        }
        if (getDistributorContactNbr2() != null) {
            _hashCode += getDistributorContactNbr2().hashCode();
        }
        if (getDistributorContactNbr3() != null) {
            _hashCode += getDistributorContactNbr3().hashCode();
        }
        if (getProductName() != null) {
            _hashCode += getProductName().hashCode();
        }
        if (getInsuredTerm() != null) {
            _hashCode += getInsuredTerm().hashCode();
        }
        if (getRiderYN() != null) {
            _hashCode += getRiderYN().hashCode();
        }
        if (getInsuredAmt() != null) {
            _hashCode += getInsuredAmt().hashCode();
        }
        if (getAccountVO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccountVO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccountVO(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSellingInstID() != null) {
            _hashCode += getSellingInstID().hashCode();
        }
        if (getDistributorID() != null) {
            _hashCode += getDistributorID().hashCode();
        }
        if (getProductCodeN() != null) {
            _hashCode += getProductCodeN().hashCode();
        }
        if (getUnitTerm() != null) {
            _hashCode += getUnitTerm().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TopUpVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "TopUpVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyHolderName");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyHolderName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("effectiveDate");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "EffectiveDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sellingInst");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "SellingInst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distributorName");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "DistributorName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distributorContactNbr1");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "DistributorContactNbr1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distributorContactNbr2");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "DistributorContactNbr2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distributorContactNbr3");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "DistributorContactNbr3"));
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
        elemField.setFieldName("insuredTerm");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "InsuredTerm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("riderYN");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "RiderYN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuredAmt");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "InsuredAmt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountVO");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "AccountVO"));
        elemField.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "AccountIdVO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "AccountIdVO"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sellingInstID");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "SellingInstID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distributorID");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "DistributorID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productCodeN");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "ProductCodeN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unitTerm");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "UnitTerm"));
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
