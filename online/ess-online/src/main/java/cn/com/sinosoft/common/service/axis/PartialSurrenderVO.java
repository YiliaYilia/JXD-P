/**
 * PartialSurrenderVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class PartialSurrenderVO  implements java.io.Serializable {
    private java.lang.String ivmtAcctID;

    private java.lang.String ivmtAcctName;

    private java.lang.String ivmtAcctValue;

    private java.lang.String bidPrice;

    private java.lang.String ivmtUnit;

    public PartialSurrenderVO() {
    }

    public PartialSurrenderVO(
           java.lang.String ivmtAcctID,
           java.lang.String ivmtAcctName,
           java.lang.String ivmtAcctValue,
           java.lang.String bidPrice,
           java.lang.String ivmtUnit) {
           this.ivmtAcctID = ivmtAcctID;
           this.ivmtAcctName = ivmtAcctName;
           this.ivmtAcctValue = ivmtAcctValue;
           this.bidPrice = bidPrice;
           this.ivmtUnit = ivmtUnit;
    }


    /**
     * Gets the ivmtAcctID value for this PartialSurrenderVO.
     * 
     * @return ivmtAcctID
     */
    public java.lang.String getIvmtAcctID() {
        return ivmtAcctID;
    }


    /**
     * Sets the ivmtAcctID value for this PartialSurrenderVO.
     * 
     * @param ivmtAcctID
     */
    public void setIvmtAcctID(java.lang.String ivmtAcctID) {
        this.ivmtAcctID = ivmtAcctID;
    }


    /**
     * Gets the ivmtAcctName value for this PartialSurrenderVO.
     * 
     * @return ivmtAcctName
     */
    public java.lang.String getIvmtAcctName() {
        return ivmtAcctName;
    }


    /**
     * Sets the ivmtAcctName value for this PartialSurrenderVO.
     * 
     * @param ivmtAcctName
     */
    public void setIvmtAcctName(java.lang.String ivmtAcctName) {
        this.ivmtAcctName = ivmtAcctName;
    }


    /**
     * Gets the ivmtAcctValue value for this PartialSurrenderVO.
     * 
     * @return ivmtAcctValue
     */
    public java.lang.String getIvmtAcctValue() {
        return ivmtAcctValue;
    }


    /**
     * Sets the ivmtAcctValue value for this PartialSurrenderVO.
     * 
     * @param ivmtAcctValue
     */
    public void setIvmtAcctValue(java.lang.String ivmtAcctValue) {
        this.ivmtAcctValue = ivmtAcctValue;
    }


    /**
     * Gets the bidPrice value for this PartialSurrenderVO.
     * 
     * @return bidPrice
     */
    public java.lang.String getBidPrice() {
        return bidPrice;
    }


    /**
     * Sets the bidPrice value for this PartialSurrenderVO.
     * 
     * @param bidPrice
     */
    public void setBidPrice(java.lang.String bidPrice) {
        this.bidPrice = bidPrice;
    }


    /**
     * Gets the ivmtUnit value for this PartialSurrenderVO.
     * 
     * @return ivmtUnit
     */
    public java.lang.String getIvmtUnit() {
        return ivmtUnit;
    }


    /**
     * Sets the ivmtUnit value for this PartialSurrenderVO.
     * 
     * @param ivmtUnit
     */
    public void setIvmtUnit(java.lang.String ivmtUnit) {
        this.ivmtUnit = ivmtUnit;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PartialSurrenderVO)) return false;
        PartialSurrenderVO other = (PartialSurrenderVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ivmtAcctID==null && other.getIvmtAcctID()==null) || 
             (this.ivmtAcctID!=null &&
              this.ivmtAcctID.equals(other.getIvmtAcctID()))) &&
            ((this.ivmtAcctName==null && other.getIvmtAcctName()==null) || 
             (this.ivmtAcctName!=null &&
              this.ivmtAcctName.equals(other.getIvmtAcctName()))) &&
            ((this.ivmtAcctValue==null && other.getIvmtAcctValue()==null) || 
             (this.ivmtAcctValue!=null &&
              this.ivmtAcctValue.equals(other.getIvmtAcctValue()))) &&
            ((this.bidPrice==null && other.getBidPrice()==null) || 
             (this.bidPrice!=null &&
              this.bidPrice.equals(other.getBidPrice()))) &&
            ((this.ivmtUnit==null && other.getIvmtUnit()==null) || 
             (this.ivmtUnit!=null &&
              this.ivmtUnit.equals(other.getIvmtUnit())));
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
        if (getIvmtAcctID() != null) {
            _hashCode += getIvmtAcctID().hashCode();
        }
        if (getIvmtAcctName() != null) {
            _hashCode += getIvmtAcctName().hashCode();
        }
        if (getIvmtAcctValue() != null) {
            _hashCode += getIvmtAcctValue().hashCode();
        }
        if (getBidPrice() != null) {
            _hashCode += getBidPrice().hashCode();
        }
        if (getIvmtUnit() != null) {
            _hashCode += getIvmtUnit().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PartialSurrenderVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "PartialSurrenderVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ivmtAcctID");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "IvmtAcctID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ivmtAcctName");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "IvmtAcctName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ivmtAcctValue");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "IvmtAcctValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bidPrice");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "BidPrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ivmtUnit");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "IvmtUnit"));
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
