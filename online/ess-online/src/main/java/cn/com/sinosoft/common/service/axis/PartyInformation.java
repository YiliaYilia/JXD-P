/**
 * PartyInformation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class PartyInformation  implements java.io.Serializable {
    private java.lang.String name;

    private java.lang.String partyCode;

    private cn.com.sinosoft.common.service.axis.CardInformation[] tCardInformation;

    public PartyInformation() {
    }

    public PartyInformation(
           java.lang.String name,
           java.lang.String partyCode,
           cn.com.sinosoft.common.service.axis.CardInformation[] tCardInformation) {
           this.name = name;
           this.partyCode = partyCode;
           this.tCardInformation = tCardInformation;
    }


    /**
     * Gets the name value for this PartyInformation.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this PartyInformation.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the partyCode value for this PartyInformation.
     * 
     * @return partyCode
     */
    public java.lang.String getPartyCode() {
        return partyCode;
    }


    /**
     * Sets the partyCode value for this PartyInformation.
     * 
     * @param partyCode
     */
    public void setPartyCode(java.lang.String partyCode) {
        this.partyCode = partyCode;
    }


    /**
     * Gets the tCardInformation value for this PartyInformation.
     * 
     * @return tCardInformation
     */
    public cn.com.sinosoft.common.service.axis.CardInformation[] getTCardInformation() {
        return tCardInformation;
    }


    /**
     * Sets the tCardInformation value for this PartyInformation.
     * 
     * @param tCardInformation
     */
    public void setTCardInformation(cn.com.sinosoft.common.service.axis.CardInformation[] tCardInformation) {
        this.tCardInformation = tCardInformation;
    }

    public cn.com.sinosoft.common.service.axis.CardInformation getTCardInformation(int i) {
        return this.tCardInformation[i];
    }

    public void setTCardInformation(int i, cn.com.sinosoft.common.service.axis.CardInformation _value) {
        this.tCardInformation[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PartyInformation)) return false;
        PartyInformation other = (PartyInformation) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.partyCode==null && other.getPartyCode()==null) || 
             (this.partyCode!=null &&
              this.partyCode.equals(other.getPartyCode()))) &&
            ((this.tCardInformation==null && other.getTCardInformation()==null) || 
             (this.tCardInformation!=null &&
              java.util.Arrays.equals(this.tCardInformation, other.getTCardInformation())));
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
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPartyCode() != null) {
            _hashCode += getPartyCode().hashCode();
        }
        if (getTCardInformation() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTCardInformation());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTCardInformation(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PartyInformation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "PartyInformation"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "partyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TCardInformation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "tCardInformation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "CardInformation"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
