/**
 * GetInActivePolicyList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.common.service.axis;

public class GetInActivePolicyList  implements java.io.Serializable {
    private String operator;

    private String systemCode;

    private String startDate;

    private String endDate;

    private String agentCode;

    private String policyCode;

    private String applicantName;

    public GetInActivePolicyList() {
    }

    public GetInActivePolicyList(
           String operator,
           String systemCode,
           String startDate,
           String endDate,
           String agentCode,
           String policyCode,
           String applicantName) {
           this.operator = operator;
           this.systemCode = systemCode;
           this.startDate = startDate;
           this.endDate = endDate;
           this.agentCode = agentCode;
           this.policyCode = policyCode;
           this.applicantName = applicantName;
    }


    /**
     * Gets the operator value for this GetInActivePolicyList.
     * 
     * @return operator
     */
    public String getOperator() {
        return operator;
    }


    /**
     * Sets the operator value for this GetInActivePolicyList.
     * 
     * @param operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }


    /**
     * Gets the systemCode value for this GetInActivePolicyList.
     * 
     * @return systemCode
     */
    public String getSystemCode() {
        return systemCode;
    }


    /**
     * Sets the systemCode value for this GetInActivePolicyList.
     * 
     * @param systemCode
     */
    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }


    /**
     * Gets the startDate value for this GetInActivePolicyList.
     * 
     * @return startDate
     */
    public String getStartDate() {
        return startDate;
    }


    /**
     * Sets the startDate value for this GetInActivePolicyList.
     * 
     * @param startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


    /**
     * Gets the endDate value for this GetInActivePolicyList.
     * 
     * @return endDate
     */
    public String getEndDate() {
        return endDate;
    }


    /**
     * Sets the endDate value for this GetInActivePolicyList.
     * 
     * @param endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    /**
     * Gets the agentCode value for this GetInActivePolicyList.
     * 
     * @return agentCode
     */
    public String getAgentCode() {
        return agentCode;
    }


    /**
     * Sets the agentCode value for this GetInActivePolicyList.
     * 
     * @param agentCode
     */
    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }


    /**
     * Gets the policyCode value for this GetInActivePolicyList.
     * 
     * @return policyCode
     */
    public String getPolicyCode() {
        return policyCode;
    }


    /**
     * Sets the policyCode value for this GetInActivePolicyList.
     * 
     * @param policyCode
     */
    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
    }


    /**
     * Gets the applicantName value for this GetInActivePolicyList.
     * 
     * @return applicantName
     */
    public String getApplicantName() {
        return applicantName;
    }


    /**
     * Sets the applicantName value for this GetInActivePolicyList.
     * 
     * @param applicantName
     */
    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof GetInActivePolicyList)) return false;
        GetInActivePolicyList other = (GetInActivePolicyList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.operator==null && other.getOperator()==null) || 
             (this.operator!=null &&
              this.operator.equals(other.getOperator()))) &&
            ((this.systemCode==null && other.getSystemCode()==null) || 
             (this.systemCode!=null &&
              this.systemCode.equals(other.getSystemCode()))) &&
            ((this.startDate==null && other.getStartDate()==null) || 
             (this.startDate!=null &&
              this.startDate.equals(other.getStartDate()))) &&
            ((this.endDate==null && other.getEndDate()==null) || 
             (this.endDate!=null &&
              this.endDate.equals(other.getEndDate()))) &&
            ((this.agentCode==null && other.getAgentCode()==null) || 
             (this.agentCode!=null &&
              this.agentCode.equals(other.getAgentCode()))) &&
            ((this.policyCode==null && other.getPolicyCode()==null) || 
             (this.policyCode!=null &&
              this.policyCode.equals(other.getPolicyCode()))) &&
            ((this.applicantName==null && other.getApplicantName()==null) || 
             (this.applicantName!=null &&
              this.applicantName.equals(other.getApplicantName())));
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
        if (getOperator() != null) {
            _hashCode += getOperator().hashCode();
        }
        if (getSystemCode() != null) {
            _hashCode += getSystemCode().hashCode();
        }
        if (getStartDate() != null) {
            _hashCode += getStartDate().hashCode();
        }
        if (getEndDate() != null) {
            _hashCode += getEndDate().hashCode();
        }
        if (getAgentCode() != null) {
            _hashCode += getAgentCode().hashCode();
        }
        if (getPolicyCode() != null) {
            _hashCode += getPolicyCode().hashCode();
        }
        if (getApplicantName() != null) {
            _hashCode += getApplicantName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetInActivePolicyList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.sinosoft.com", ">getInActivePolicyList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operator");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "operator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("systemCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "systemCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "startDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "endDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("agentCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "agentCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "policyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicantName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.sinosoft.com", "applicantName"));
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
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
