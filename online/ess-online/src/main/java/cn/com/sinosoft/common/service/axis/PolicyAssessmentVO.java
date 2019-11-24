/**
 * PolicyAssessmentVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class PolicyAssessmentVO  implements java.io.Serializable {
    private java.lang.String fundName;

    private java.lang.String fundId;

    private java.lang.String unitPriceDate;

    private java.lang.String unitQuantity;

    private java.lang.String bidingPrice;

    private java.lang.String premiumPaid;

    private java.lang.String ivmtValue;

    private java.lang.String ivmtChoice;

    private java.lang.String sumPremiumPaid;

    private java.lang.String sumIvmtValue;

    public PolicyAssessmentVO() {
    }

    public PolicyAssessmentVO(
           java.lang.String fundName,
           java.lang.String fundId,
           java.lang.String unitPriceDate,
           java.lang.String unitQuantity,
           java.lang.String bidingPrice,
           java.lang.String premiumPaid,
           java.lang.String ivmtValue,
           java.lang.String ivmtChoice,
           java.lang.String sumPremiumPaid,
           java.lang.String sumIvmtValue) {
           this.fundName = fundName;
           this.fundId = fundId;
           this.unitPriceDate = unitPriceDate;
           this.unitQuantity = unitQuantity;
           this.bidingPrice = bidingPrice;
           this.premiumPaid = premiumPaid;
           this.ivmtValue = ivmtValue;
           this.ivmtChoice = ivmtChoice;
           this.sumPremiumPaid = sumPremiumPaid;
           this.sumIvmtValue = sumIvmtValue;
    }


    /**
     * Gets the fundName value for this PolicyAssessmentVO.
     * 
     * @return fundName
     */
    public java.lang.String getFundName() {
        return fundName;
    }


    /**
     * Sets the fundName value for this PolicyAssessmentVO.
     * 
     * @param fundName
     */
    public void setFundName(java.lang.String fundName) {
        this.fundName = fundName;
    }


    /**
     * Gets the fundId value for this PolicyAssessmentVO.
     * 
     * @return fundId
     */
    public java.lang.String getFundId() {
        return fundId;
    }


    /**
     * Sets the fundId value for this PolicyAssessmentVO.
     * 
     * @param fundId
     */
    public void setFundId(java.lang.String fundId) {
        this.fundId = fundId;
    }


    /**
     * Gets the unitPriceDate value for this PolicyAssessmentVO.
     * 
     * @return unitPriceDate
     */
    public java.lang.String getUnitPriceDate() {
        return unitPriceDate;
    }


    /**
     * Sets the unitPriceDate value for this PolicyAssessmentVO.
     * 
     * @param unitPriceDate
     */
    public void setUnitPriceDate(java.lang.String unitPriceDate) {
        this.unitPriceDate = unitPriceDate;
    }


    /**
     * Gets the unitQuantity value for this PolicyAssessmentVO.
     * 
     * @return unitQuantity
     */
    public java.lang.String getUnitQuantity() {
        return unitQuantity;
    }


    /**
     * Sets the unitQuantity value for this PolicyAssessmentVO.
     * 
     * @param unitQuantity
     */
    public void setUnitQuantity(java.lang.String unitQuantity) {
        this.unitQuantity = unitQuantity;
    }


    /**
     * Gets the bidingPrice value for this PolicyAssessmentVO.
     * 
     * @return bidingPrice
     */
    public java.lang.String getBidingPrice() {
        return bidingPrice;
    }


    /**
     * Sets the bidingPrice value for this PolicyAssessmentVO.
     * 
     * @param bidingPrice
     */
    public void setBidingPrice(java.lang.String bidingPrice) {
        this.bidingPrice = bidingPrice;
    }


    /**
     * Gets the premiumPaid value for this PolicyAssessmentVO.
     * 
     * @return premiumPaid
     */
    public java.lang.String getPremiumPaid() {
        return premiumPaid;
    }


    /**
     * Sets the premiumPaid value for this PolicyAssessmentVO.
     * 
     * @param premiumPaid
     */
    public void setPremiumPaid(java.lang.String premiumPaid) {
        this.premiumPaid = premiumPaid;
    }


    /**
     * Gets the ivmtValue value for this PolicyAssessmentVO.
     * 
     * @return ivmtValue
     */
    public java.lang.String getIvmtValue() {
        return ivmtValue;
    }


    /**
     * Sets the ivmtValue value for this PolicyAssessmentVO.
     * 
     * @param ivmtValue
     */
    public void setIvmtValue(java.lang.String ivmtValue) {
        this.ivmtValue = ivmtValue;
    }


    /**
     * Gets the ivmtChoice value for this PolicyAssessmentVO.
     * 
     * @return ivmtChoice
     */
    public java.lang.String getIvmtChoice() {
        return ivmtChoice;
    }


    /**
     * Sets the ivmtChoice value for this PolicyAssessmentVO.
     * 
     * @param ivmtChoice
     */
    public void setIvmtChoice(java.lang.String ivmtChoice) {
        this.ivmtChoice = ivmtChoice;
    }


    /**
     * Gets the sumPremiumPaid value for this PolicyAssessmentVO.
     * 
     * @return sumPremiumPaid
     */
    public java.lang.String getSumPremiumPaid() {
        return sumPremiumPaid;
    }


    /**
     * Sets the sumPremiumPaid value for this PolicyAssessmentVO.
     * 
     * @param sumPremiumPaid
     */
    public void setSumPremiumPaid(java.lang.String sumPremiumPaid) {
        this.sumPremiumPaid = sumPremiumPaid;
    }


    /**
     * Gets the sumIvmtValue value for this PolicyAssessmentVO.
     * 
     * @return sumIvmtValue
     */
    public java.lang.String getSumIvmtValue() {
        return sumIvmtValue;
    }


    /**
     * Sets the sumIvmtValue value for this PolicyAssessmentVO.
     * 
     * @param sumIvmtValue
     */
    public void setSumIvmtValue(java.lang.String sumIvmtValue) {
        this.sumIvmtValue = sumIvmtValue;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PolicyAssessmentVO)) return false;
        PolicyAssessmentVO other = (PolicyAssessmentVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fundName==null && other.getFundName()==null) || 
             (this.fundName!=null &&
              this.fundName.equals(other.getFundName()))) &&
            ((this.fundId==null && other.getFundId()==null) || 
             (this.fundId!=null &&
              this.fundId.equals(other.getFundId()))) &&
            ((this.unitPriceDate==null && other.getUnitPriceDate()==null) || 
             (this.unitPriceDate!=null &&
              this.unitPriceDate.equals(other.getUnitPriceDate()))) &&
            ((this.unitQuantity==null && other.getUnitQuantity()==null) || 
             (this.unitQuantity!=null &&
              this.unitQuantity.equals(other.getUnitQuantity()))) &&
            ((this.bidingPrice==null && other.getBidingPrice()==null) || 
             (this.bidingPrice!=null &&
              this.bidingPrice.equals(other.getBidingPrice()))) &&
            ((this.premiumPaid==null && other.getPremiumPaid()==null) || 
             (this.premiumPaid!=null &&
              this.premiumPaid.equals(other.getPremiumPaid()))) &&
            ((this.ivmtValue==null && other.getIvmtValue()==null) || 
             (this.ivmtValue!=null &&
              this.ivmtValue.equals(other.getIvmtValue()))) &&
            ((this.ivmtChoice==null && other.getIvmtChoice()==null) || 
             (this.ivmtChoice!=null &&
              this.ivmtChoice.equals(other.getIvmtChoice()))) &&
            ((this.sumPremiumPaid==null && other.getSumPremiumPaid()==null) || 
             (this.sumPremiumPaid!=null &&
              this.sumPremiumPaid.equals(other.getSumPremiumPaid()))) &&
            ((this.sumIvmtValue==null && other.getSumIvmtValue()==null) || 
             (this.sumIvmtValue!=null &&
              this.sumIvmtValue.equals(other.getSumIvmtValue())));
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
        if (getFundName() != null) {
            _hashCode += getFundName().hashCode();
        }
        if (getFundId() != null) {
            _hashCode += getFundId().hashCode();
        }
        if (getUnitPriceDate() != null) {
            _hashCode += getUnitPriceDate().hashCode();
        }
        if (getUnitQuantity() != null) {
            _hashCode += getUnitQuantity().hashCode();
        }
        if (getBidingPrice() != null) {
            _hashCode += getBidingPrice().hashCode();
        }
        if (getPremiumPaid() != null) {
            _hashCode += getPremiumPaid().hashCode();
        }
        if (getIvmtValue() != null) {
            _hashCode += getIvmtValue().hashCode();
        }
        if (getIvmtChoice() != null) {
            _hashCode += getIvmtChoice().hashCode();
        }
        if (getSumPremiumPaid() != null) {
            _hashCode += getSumPremiumPaid().hashCode();
        }
        if (getSumIvmtValue() != null) {
            _hashCode += getSumIvmtValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PolicyAssessmentVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "PolicyAssessmentVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fundName");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "FundName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fundId");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "FundId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unitPriceDate");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "UnitPriceDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unitQuantity");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "UnitQuantity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bidingPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "BidingPrice"));
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
        elemField.setFieldName("ivmtValue");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "IvmtValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ivmtChoice");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "IvmtChoice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sumPremiumPaid");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "SumPremiumPaid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sumIvmtValue");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "SumIvmtValue"));
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
