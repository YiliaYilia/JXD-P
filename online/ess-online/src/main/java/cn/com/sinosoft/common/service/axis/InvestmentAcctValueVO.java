/**
 * InvestmentAcctValueVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class InvestmentAcctValueVO  implements java.io.Serializable {
    private java.lang.String ivmtAcctDate;

    private cn.com.sinosoft.common.service.axis.AccountValueVO[] alAcctValue;

    private java.lang.String repBenefit;

    public InvestmentAcctValueVO() {
    }

    public InvestmentAcctValueVO(
           java.lang.String ivmtAcctDate,
           cn.com.sinosoft.common.service.axis.AccountValueVO[] alAcctValue,
           java.lang.String repBenefit) {
           this.ivmtAcctDate = ivmtAcctDate;
           this.alAcctValue = alAcctValue;
           this.repBenefit = repBenefit;
    }


    /**
     * Gets the ivmtAcctDate value for this InvestmentAcctValueVO.
     * 
     * @return ivmtAcctDate
     */
    public java.lang.String getIvmtAcctDate() {
        return ivmtAcctDate;
    }


    /**
     * Sets the ivmtAcctDate value for this InvestmentAcctValueVO.
     * 
     * @param ivmtAcctDate
     */
    public void setIvmtAcctDate(java.lang.String ivmtAcctDate) {
        this.ivmtAcctDate = ivmtAcctDate;
    }


    /**
     * Gets the alAcctValue value for this InvestmentAcctValueVO.
     * 
     * @return alAcctValue
     */
    public cn.com.sinosoft.common.service.axis.AccountValueVO[] getAlAcctValue() {
        return alAcctValue;
    }


    /**
     * Sets the alAcctValue value for this InvestmentAcctValueVO.
     * 
     * @param alAcctValue
     */
    public void setAlAcctValue(cn.com.sinosoft.common.service.axis.AccountValueVO[] alAcctValue) {
        this.alAcctValue = alAcctValue;
    }


    /**
     * Gets the repBenefit value for this InvestmentAcctValueVO.
     * 
     * @return repBenefit
     */
    public java.lang.String getRepBenefit() {
        return repBenefit;
    }


    /**
     * Sets the repBenefit value for this InvestmentAcctValueVO.
     * 
     * @param repBenefit
     */
    public void setRepBenefit(java.lang.String repBenefit) {
        this.repBenefit = repBenefit;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InvestmentAcctValueVO)) return false;
        InvestmentAcctValueVO other = (InvestmentAcctValueVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ivmtAcctDate==null && other.getIvmtAcctDate()==null) || 
             (this.ivmtAcctDate!=null &&
              this.ivmtAcctDate.equals(other.getIvmtAcctDate()))) &&
            ((this.alAcctValue==null && other.getAlAcctValue()==null) || 
             (this.alAcctValue!=null &&
              java.util.Arrays.equals(this.alAcctValue, other.getAlAcctValue()))) &&
            ((this.repBenefit==null && other.getRepBenefit()==null) || 
             (this.repBenefit!=null &&
              this.repBenefit.equals(other.getRepBenefit())));
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
        if (getIvmtAcctDate() != null) {
            _hashCode += getIvmtAcctDate().hashCode();
        }
        if (getAlAcctValue() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAlAcctValue());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAlAcctValue(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRepBenefit() != null) {
            _hashCode += getRepBenefit().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InvestmentAcctValueVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "InvestmentAcctValueVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ivmtAcctDate");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "IvmtAcctDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("alAcctValue");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "AlAcctValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("com.skandia.linkwebService", "AccountValueVO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("com.skandia.linkwebService", "AccountValueVO"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("repBenefit");
        elemField.setXmlName(new javax.xml.namespace.QName("com.skandia.linkwebService", "RepBenefit"));
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
