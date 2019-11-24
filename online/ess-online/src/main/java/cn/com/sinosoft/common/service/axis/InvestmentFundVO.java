/**
 * InvestmentFundVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class InvestmentFundVO  implements java.io.Serializable {
    private java.lang.String date;

    private java.lang.String bidPrice;

    private java.lang.String ivmtAcctDate;

    private java.lang.String bidRaiseOrFall;

    private java.lang.String totalBidRaiseOrFall;

    public InvestmentFundVO() {
    }

    public InvestmentFundVO(
           java.lang.String date,
           java.lang.String bidPrice,
           java.lang.String ivmtAcctDate,
           java.lang.String bidRaiseOrFall,
           java.lang.String totalBidRaiseOrFall) {
           this.date = date;
           this.bidPrice = bidPrice;
           this.ivmtAcctDate = ivmtAcctDate;
           this.bidRaiseOrFall = bidRaiseOrFall;
           this.totalBidRaiseOrFall = totalBidRaiseOrFall;
    }


    /**
     * Gets the date value for this InvestmentFundVO.
     * 
     * @return date
     */
    public java.lang.String getDate() {
        return date;
    }


    /**
     * Sets the date value for this InvestmentFundVO.
     * 
     * @param date
     */
    public void setDate(java.lang.String date) {
        this.date = date;
    }


    /**
     * Gets the bidPrice value for this InvestmentFundVO.
     * 
     * @return bidPrice
     */
    public java.lang.String getBidPrice() {
        return bidPrice;
    }


    /**
     * Sets the bidPrice value for this InvestmentFundVO.
     * 
     * @param bidPrice
     */
    public void setBidPrice(java.lang.String bidPrice) {
        this.bidPrice = bidPrice;
    }


    /**
     * Gets the ivmtAcctDate value for this InvestmentFundVO.
     * 
     * @return ivmtAcctDate
     */
    public java.lang.String getIvmtAcctDate() {
        return ivmtAcctDate;
    }


    /**
     * Sets the ivmtAcctDate value for this InvestmentFundVO.
     * 
     * @param ivmtAcctDate
     */
    public void setIvmtAcctDate(java.lang.String ivmtAcctDate) {
        this.ivmtAcctDate = ivmtAcctDate;
    }


    /**
     * Gets the bidRaiseOrFall value for this InvestmentFundVO.
     * 
     * @return bidRaiseOrFall
     */
    public java.lang.String getBidRaiseOrFall() {
        return bidRaiseOrFall;
    }


    /**
     * Sets the bidRaiseOrFall value for this InvestmentFundVO.
     * 
     * @param bidRaiseOrFall
     */
    public void setBidRaiseOrFall(java.lang.String bidRaiseOrFall) {
        this.bidRaiseOrFall = bidRaiseOrFall;
    }


    /**
     * Gets the totalBidRaiseOrFall value for this InvestmentFundVO.
     * 
     * @return totalBidRaiseOrFall
     */
    public java.lang.String getTotalBidRaiseOrFall() {
        return totalBidRaiseOrFall;
    }


    /**
     * Sets the totalBidRaiseOrFall value for this InvestmentFundVO.
     * 
     * @param totalBidRaiseOrFall
     */
    public void setTotalBidRaiseOrFall(java.lang.String totalBidRaiseOrFall) {
        this.totalBidRaiseOrFall = totalBidRaiseOrFall;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InvestmentFundVO)) return false;
        InvestmentFundVO other = (InvestmentFundVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.date==null && other.getDate()==null) || 
             (this.date!=null &&
              this.date.equals(other.getDate()))) &&
            ((this.bidPrice==null && other.getBidPrice()==null) || 
             (this.bidPrice!=null &&
              this.bidPrice.equals(other.getBidPrice()))) &&
            ((this.ivmtAcctDate==null && other.getIvmtAcctDate()==null) || 
             (this.ivmtAcctDate!=null &&
              this.ivmtAcctDate.equals(other.getIvmtAcctDate()))) &&
            ((this.bidRaiseOrFall==null && other.getBidRaiseOrFall()==null) || 
             (this.bidRaiseOrFall!=null &&
              this.bidRaiseOrFall.equals(other.getBidRaiseOrFall()))) &&
            ((this.totalBidRaiseOrFall==null && other.getTotalBidRaiseOrFall()==null) || 
             (this.totalBidRaiseOrFall!=null &&
              this.totalBidRaiseOrFall.equals(other.getTotalBidRaiseOrFall())));
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
        if (getDate() != null) {
            _hashCode += getDate().hashCode();
        }
        if (getBidPrice() != null) {
            _hashCode += getBidPrice().hashCode();
        }
        if (getIvmtAcctDate() != null) {
            _hashCode += getIvmtAcctDate().hashCode();
        }
        if (getBidRaiseOrFall() != null) {
            _hashCode += getBidRaiseOrFall().hashCode();
        }
        if (getTotalBidRaiseOrFall() != null) {
            _hashCode += getTotalBidRaiseOrFall().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InvestmentFundVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "InvestmentFundVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "Date"));
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
        elemField.setFieldName("ivmtAcctDate");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "IvmtAcctDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bidRaiseOrFall");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "BidRaiseOrFall"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalBidRaiseOrFall");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "TotalBidRaiseOrFall"));
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
