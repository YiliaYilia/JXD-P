/**
 * UnitPriceVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class UnitPriceVO  implements java.io.Serializable {
    private java.lang.String ivmtAcctFundName;

    private java.lang.String ivmtAcctFundID;

    private java.lang.String productName;

    private java.lang.String offerPrice;

    private java.lang.String bidingPrice;

    private java.lang.String date;

    private java.lang.String productCode;

    public UnitPriceVO() {
    }

    public UnitPriceVO(
           java.lang.String ivmtAcctFundName,
           java.lang.String ivmtAcctFundID,
           java.lang.String productName,
           java.lang.String offerPrice,
           java.lang.String bidingPrice,
           java.lang.String date,
           java.lang.String productCode) {
           this.ivmtAcctFundName = ivmtAcctFundName;
           this.ivmtAcctFundID = ivmtAcctFundID;
           this.productName = productName;
           this.offerPrice = offerPrice;
           this.bidingPrice = bidingPrice;
           this.date = date;
           this.productCode = productCode;
    }


    /**
     * Gets the ivmtAcctFundName value for this UnitPriceVO.
     * 
     * @return ivmtAcctFundName
     */
    public java.lang.String getIvmtAcctFundName() {
        return ivmtAcctFundName;
    }


    /**
     * Sets the ivmtAcctFundName value for this UnitPriceVO.
     * 
     * @param ivmtAcctFundName
     */
    public void setIvmtAcctFundName(java.lang.String ivmtAcctFundName) {
        this.ivmtAcctFundName = ivmtAcctFundName;
    }


    /**
     * Gets the ivmtAcctFundID value for this UnitPriceVO.
     * 
     * @return ivmtAcctFundID
     */
    public java.lang.String getIvmtAcctFundID() {
        return ivmtAcctFundID;
    }


    /**
     * Sets the ivmtAcctFundID value for this UnitPriceVO.
     * 
     * @param ivmtAcctFundID
     */
    public void setIvmtAcctFundID(java.lang.String ivmtAcctFundID) {
        this.ivmtAcctFundID = ivmtAcctFundID;
    }


    /**
     * Gets the productName value for this UnitPriceVO.
     * 
     * @return productName
     */
    public java.lang.String getProductName() {
        return productName;
    }


    /**
     * Sets the productName value for this UnitPriceVO.
     * 
     * @param productName
     */
    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }


    /**
     * Gets the offerPrice value for this UnitPriceVO.
     * 
     * @return offerPrice
     */
    public java.lang.String getOfferPrice() {
        return offerPrice;
    }


    /**
     * Sets the offerPrice value for this UnitPriceVO.
     * 
     * @param offerPrice
     */
    public void setOfferPrice(java.lang.String offerPrice) {
        this.offerPrice = offerPrice;
    }


    /**
     * Gets the bidingPrice value for this UnitPriceVO.
     * 
     * @return bidingPrice
     */
    public java.lang.String getBidingPrice() {
        return bidingPrice;
    }


    /**
     * Sets the bidingPrice value for this UnitPriceVO.
     * 
     * @param bidingPrice
     */
    public void setBidingPrice(java.lang.String bidingPrice) {
        this.bidingPrice = bidingPrice;
    }


    /**
     * Gets the date value for this UnitPriceVO.
     * 
     * @return date
     */
    public java.lang.String getDate() {
        return date;
    }


    /**
     * Sets the date value for this UnitPriceVO.
     * 
     * @param date
     */
    public void setDate(java.lang.String date) {
        this.date = date;
    }


    /**
     * Gets the productCode value for this UnitPriceVO.
     * 
     * @return productCode
     */
    public java.lang.String getProductCode() {
        return productCode;
    }


    /**
     * Sets the productCode value for this UnitPriceVO.
     * 
     * @param productCode
     */
    public void setProductCode(java.lang.String productCode) {
        this.productCode = productCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UnitPriceVO)) return false;
        UnitPriceVO other = (UnitPriceVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ivmtAcctFundName==null && other.getIvmtAcctFundName()==null) || 
             (this.ivmtAcctFundName!=null &&
              this.ivmtAcctFundName.equals(other.getIvmtAcctFundName()))) &&
            ((this.ivmtAcctFundID==null && other.getIvmtAcctFundID()==null) || 
             (this.ivmtAcctFundID!=null &&
              this.ivmtAcctFundID.equals(other.getIvmtAcctFundID()))) &&
            ((this.productName==null && other.getProductName()==null) || 
             (this.productName!=null &&
              this.productName.equals(other.getProductName()))) &&
            ((this.offerPrice==null && other.getOfferPrice()==null) || 
             (this.offerPrice!=null &&
              this.offerPrice.equals(other.getOfferPrice()))) &&
            ((this.bidingPrice==null && other.getBidingPrice()==null) || 
             (this.bidingPrice!=null &&
              this.bidingPrice.equals(other.getBidingPrice()))) &&
            ((this.date==null && other.getDate()==null) || 
             (this.date!=null &&
              this.date.equals(other.getDate()))) &&
            ((this.productCode==null && other.getProductCode()==null) || 
             (this.productCode!=null &&
              this.productCode.equals(other.getProductCode())));
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
        if (getIvmtAcctFundName() != null) {
            _hashCode += getIvmtAcctFundName().hashCode();
        }
        if (getIvmtAcctFundID() != null) {
            _hashCode += getIvmtAcctFundID().hashCode();
        }
        if (getProductName() != null) {
            _hashCode += getProductName().hashCode();
        }
        if (getOfferPrice() != null) {
            _hashCode += getOfferPrice().hashCode();
        }
        if (getBidingPrice() != null) {
            _hashCode += getBidingPrice().hashCode();
        }
        if (getDate() != null) {
            _hashCode += getDate().hashCode();
        }
        if (getProductCode() != null) {
            _hashCode += getProductCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UnitPriceVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "UnitPriceVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ivmtAcctFundName");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "IvmtAcctFundName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ivmtAcctFundID");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "IvmtAcctFundID"));
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
        elemField.setFieldName("offerPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "OfferPrice"));
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
        elemField.setFieldName("date");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "Date"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productCode");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "ProductCode"));
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
