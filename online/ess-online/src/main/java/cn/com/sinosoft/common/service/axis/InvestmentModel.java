/**
 * InvestmentModel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class InvestmentModel  implements java.io.Serializable {
    private java.lang.String investmentName;

    private java.lang.String price;

    private java.lang.String priceDate;

    private java.lang.String units;

    public InvestmentModel() {
    }

    public InvestmentModel(
           java.lang.String investmentName,
           java.lang.String price,
           java.lang.String priceDate,
           java.lang.String units) {
           this.investmentName = investmentName;
           this.price = price;
           this.priceDate = priceDate;
           this.units = units;
    }


    /**
     * Gets the investmentName value for this InvestmentModel.
     * 
     * @return investmentName
     */
    public java.lang.String getInvestmentName() {
        return investmentName;
    }


    /**
     * Sets the investmentName value for this InvestmentModel.
     * 
     * @param investmentName
     */
    public void setInvestmentName(java.lang.String investmentName) {
        this.investmentName = investmentName;
    }


    /**
     * Gets the price value for this InvestmentModel.
     * 
     * @return price
     */
    public java.lang.String getPrice() {
        return price;
    }


    /**
     * Sets the price value for this InvestmentModel.
     * 
     * @param price
     */
    public void setPrice(java.lang.String price) {
        this.price = price;
    }


    /**
     * Gets the priceDate value for this InvestmentModel.
     * 
     * @return priceDate
     */
    public java.lang.String getPriceDate() {
        return priceDate;
    }


    /**
     * Sets the priceDate value for this InvestmentModel.
     * 
     * @param priceDate
     */
    public void setPriceDate(java.lang.String priceDate) {
        this.priceDate = priceDate;
    }


    /**
     * Gets the units value for this InvestmentModel.
     * 
     * @return units
     */
    public java.lang.String getUnits() {
        return units;
    }


    /**
     * Sets the units value for this InvestmentModel.
     * 
     * @param units
     */
    public void setUnits(java.lang.String units) {
        this.units = units;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InvestmentModel)) return false;
        InvestmentModel other = (InvestmentModel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.investmentName==null && other.getInvestmentName()==null) || 
             (this.investmentName!=null &&
              this.investmentName.equals(other.getInvestmentName()))) &&
            ((this.price==null && other.getPrice()==null) || 
             (this.price!=null &&
              this.price.equals(other.getPrice()))) &&
            ((this.priceDate==null && other.getPriceDate()==null) || 
             (this.priceDate!=null &&
              this.priceDate.equals(other.getPriceDate()))) &&
            ((this.units==null && other.getUnits()==null) || 
             (this.units!=null &&
              this.units.equals(other.getUnits())));
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
        if (getInvestmentName() != null) {
            _hashCode += getInvestmentName().hashCode();
        }
        if (getPrice() != null) {
            _hashCode += getPrice().hashCode();
        }
        if (getPriceDate() != null) {
            _hashCode += getPriceDate().hashCode();
        }
        if (getUnits() != null) {
            _hashCode += getUnits().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InvestmentModel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "InvestmentModel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("investmentName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "investmentName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("price");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "price"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priceDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "priceDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("units");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "units"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
