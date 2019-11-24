/**
 * RoleQueryModel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class RoleQueryModel  implements java.io.Serializable {
    private java.lang.Integer code;

    private java.lang.String message;

    private cn.com.sinosoft.common.service.axis.PartyInformation[] tBenficPartyInformation;

    private cn.com.sinosoft.common.service.axis.PartyInformation[] tLifeAssdPartyInformation;

    private cn.com.sinosoft.common.service.axis.PartyInformation[] tPolPartyInformation;

    public RoleQueryModel() {
    }

    public RoleQueryModel(
           java.lang.Integer code,
           java.lang.String message,
           cn.com.sinosoft.common.service.axis.PartyInformation[] tBenficPartyInformation,
           cn.com.sinosoft.common.service.axis.PartyInformation[] tLifeAssdPartyInformation,
           cn.com.sinosoft.common.service.axis.PartyInformation[] tPolPartyInformation) {
           this.code = code;
           this.message = message;
           this.tBenficPartyInformation = tBenficPartyInformation;
           this.tLifeAssdPartyInformation = tLifeAssdPartyInformation;
           this.tPolPartyInformation = tPolPartyInformation;
    }


    /**
     * Gets the code value for this RoleQueryModel.
     * 
     * @return code
     */
    public java.lang.Integer getCode() {
        return code;
    }


    /**
     * Sets the code value for this RoleQueryModel.
     * 
     * @param code
     */
    public void setCode(java.lang.Integer code) {
        this.code = code;
    }


    /**
     * Gets the message value for this RoleQueryModel.
     * 
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this RoleQueryModel.
     * 
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }


    /**
     * Gets the tBenficPartyInformation value for this RoleQueryModel.
     * 
     * @return tBenficPartyInformation
     */
    public cn.com.sinosoft.common.service.axis.PartyInformation[] getTBenficPartyInformation() {
        return tBenficPartyInformation;
    }


    /**
     * Sets the tBenficPartyInformation value for this RoleQueryModel.
     * 
     * @param tBenficPartyInformation
     */
    public void setTBenficPartyInformation(cn.com.sinosoft.common.service.axis.PartyInformation[] tBenficPartyInformation) {
        this.tBenficPartyInformation = tBenficPartyInformation;
    }

    public cn.com.sinosoft.common.service.axis.PartyInformation getTBenficPartyInformation(int i) {
        return this.tBenficPartyInformation[i];
    }

    public void setTBenficPartyInformation(int i, cn.com.sinosoft.common.service.axis.PartyInformation _value) {
        this.tBenficPartyInformation[i] = _value;
    }


    /**
     * Gets the tLifeAssdPartyInformation value for this RoleQueryModel.
     * 
     * @return tLifeAssdPartyInformation
     */
    public cn.com.sinosoft.common.service.axis.PartyInformation[] getTLifeAssdPartyInformation() {
        return tLifeAssdPartyInformation;
    }


    /**
     * Sets the tLifeAssdPartyInformation value for this RoleQueryModel.
     * 
     * @param tLifeAssdPartyInformation
     */
    public void setTLifeAssdPartyInformation(cn.com.sinosoft.common.service.axis.PartyInformation[] tLifeAssdPartyInformation) {
        this.tLifeAssdPartyInformation = tLifeAssdPartyInformation;
    }

    public cn.com.sinosoft.common.service.axis.PartyInformation getTLifeAssdPartyInformation(int i) {
        return this.tLifeAssdPartyInformation[i];
    }

    public void setTLifeAssdPartyInformation(int i, cn.com.sinosoft.common.service.axis.PartyInformation _value) {
        this.tLifeAssdPartyInformation[i] = _value;
    }


    /**
     * Gets the tPolPartyInformation value for this RoleQueryModel.
     * 
     * @return tPolPartyInformation
     */
    public cn.com.sinosoft.common.service.axis.PartyInformation[] getTPolPartyInformation() {
        return tPolPartyInformation;
    }


    /**
     * Sets the tPolPartyInformation value for this RoleQueryModel.
     * 
     * @param tPolPartyInformation
     */
    public void setTPolPartyInformation(cn.com.sinosoft.common.service.axis.PartyInformation[] tPolPartyInformation) {
        this.tPolPartyInformation = tPolPartyInformation;
    }

    public cn.com.sinosoft.common.service.axis.PartyInformation getTPolPartyInformation(int i) {
        return this.tPolPartyInformation[i];
    }

    public void setTPolPartyInformation(int i, cn.com.sinosoft.common.service.axis.PartyInformation _value) {
        this.tPolPartyInformation[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RoleQueryModel)) return false;
        RoleQueryModel other = (RoleQueryModel) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.code==null && other.getCode()==null) || 
             (this.code!=null &&
              this.code.equals(other.getCode()))) &&
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            ((this.tBenficPartyInformation==null && other.getTBenficPartyInformation()==null) || 
             (this.tBenficPartyInformation!=null &&
              java.util.Arrays.equals(this.tBenficPartyInformation, other.getTBenficPartyInformation()))) &&
            ((this.tLifeAssdPartyInformation==null && other.getTLifeAssdPartyInformation()==null) || 
             (this.tLifeAssdPartyInformation!=null &&
              java.util.Arrays.equals(this.tLifeAssdPartyInformation, other.getTLifeAssdPartyInformation()))) &&
            ((this.tPolPartyInformation==null && other.getTPolPartyInformation()==null) || 
             (this.tPolPartyInformation!=null &&
              java.util.Arrays.equals(this.tPolPartyInformation, other.getTPolPartyInformation())));
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
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        if (getTBenficPartyInformation() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTBenficPartyInformation());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTBenficPartyInformation(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTLifeAssdPartyInformation() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTLifeAssdPartyInformation());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTLifeAssdPartyInformation(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTPolPartyInformation() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTPolPartyInformation());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTPolPartyInformation(), i);
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
        new org.apache.axis.description.TypeDesc(RoleQueryModel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "RoleQueryModel"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TBenficPartyInformation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "tBenficPartyInformation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "PartyInformation"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TLifeAssdPartyInformation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "tLifeAssdPartyInformation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "PartyInformation"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TPolPartyInformation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "tPolPartyInformation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "PartyInformation"));
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
