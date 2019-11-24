/**
 * BasicQuery.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.sinosoft.product.axis.domain;

public class BasicQuery  implements java.io.Serializable {
    private java.lang.String FA;

    private java.lang.String accountBank;

    private java.lang.String assured;

    private java.lang.String assuredName;

    private java.lang.String bankCardID;

    private java.lang.String branchcode;

    private java.lang.Integer code;

    private java.lang.String contenct;

    private java.lang.String distributor;

    private java.lang.String[] extraProductName;

    private java.lang.String inceptionDate;

    private java.lang.String insuranceType;

    private java.lang.String investmentAccount;

    private java.lang.String month;

    private java.lang.String partyCode;

    private java.lang.String payTermYears;

    private java.lang.String polName;

    private java.lang.String policyNum;

    private java.lang.String policysource;

    private java.lang.String policystatus;

    private java.lang.String productCode;

    private java.lang.String productName;

    private java.lang.String rate;

    private java.lang.String renewalIndicator;

    private java.lang.String subSource;

    private cn.com.sinosoft.product.axis.domain.InvestmentModel[] tInvestmentModel;

    private java.lang.String term;
    //另加字段
    private cn.com.sinosoft.product.axis.domain.InvestmentModel[] investments;
    //保单渠道（按照网销、电销等区分）
    private String policyChannel;
    //产品类型（按照重疾，高净值等区分）
    private String productType;
    //标准保费
    private String standardPremium;
    
    

    public cn.com.sinosoft.product.axis.domain.InvestmentModel[] getInvestments() {
		return investments;
	}

	public void setInvestments(cn.com.sinosoft.product.axis.domain.InvestmentModel[] investments) {
		this.investments = investments;
	}

	private java.lang.String totalValue;

    public BasicQuery() {
    }

    public BasicQuery(
           java.lang.String FA,
           java.lang.String accountBank,
           java.lang.String assured,
           java.lang.String assuredName,
           java.lang.String bankCardID,
           java.lang.String branchcode,
           java.lang.Integer code,
           java.lang.String contenct,
           java.lang.String distributor,
           java.lang.String[] extraProductName,
           java.lang.String inceptionDate,
           java.lang.String insuranceType,
           java.lang.String investmentAccount,
           java.lang.String month,
           java.lang.String partyCode,
           java.lang.String payTermYears,
           java.lang.String polName,
           java.lang.String policyNum,
           java.lang.String policysource,
           java.lang.String policystatus,
           java.lang.String productCode,
           java.lang.String productName,
           java.lang.String rate,
           java.lang.String renewalIndicator,
           java.lang.String subSource,
           cn.com.sinosoft.product.axis.domain.InvestmentModel[] tInvestmentModel,
           java.lang.String term,
           java.lang.String totalValue,
           String policyChannel,
           String productType,
           String standardPremium) {
           this.FA = FA;
           this.accountBank = accountBank;
           this.assured = assured;
           this.assuredName = assuredName;
           this.bankCardID = bankCardID;
           this.branchcode = branchcode;
           this.code = code;
           this.contenct = contenct;
           this.distributor = distributor;
           this.extraProductName = extraProductName;
           this.inceptionDate = inceptionDate;
           this.insuranceType = insuranceType;
           this.investmentAccount = investmentAccount;
           this.month = month;
           this.partyCode = partyCode;
           this.payTermYears = payTermYears;
           this.polName = polName;
           this.policyNum = policyNum;
           this.policysource = policysource;
           this.policystatus = policystatus;
           this.productCode = productCode;
           this.productName = productName;
           this.rate = rate;
           this.renewalIndicator = renewalIndicator;
           this.subSource = subSource;
           this.tInvestmentModel = tInvestmentModel;
           this.term = term;
           this.totalValue = totalValue;
           this.policyChannel = policyChannel;
           this.productType = productType;
           this.standardPremium = standardPremium;
    }


    /**
     * Gets the FA value for this BasicQuery.
     * 
     * @return FA
     */
    public java.lang.String getFA() {
        return FA;
    }


    /**
     * Sets the FA value for this BasicQuery.
     * 
     * @param FA
     */
    public void setFA(java.lang.String FA) {
        this.FA = FA;
    }


    /**
     * Gets the accountBank value for this BasicQuery.
     * 
     * @return accountBank
     */
    public java.lang.String getAccountBank() {
        return accountBank;
    }


    /**
     * Sets the accountBank value for this BasicQuery.
     * 
     * @param accountBank
     */
    public void setAccountBank(java.lang.String accountBank) {
        this.accountBank = accountBank;
    }


    /**
     * Gets the assured value for this BasicQuery.
     * 
     * @return assured
     */
    public java.lang.String getAssured() {
        return assured;
    }


    /**
     * Sets the assured value for this BasicQuery.
     * 
     * @param assured
     */
    public void setAssured(java.lang.String assured) {
        this.assured = assured;
    }


    /**
     * Gets the assuredName value for this BasicQuery.
     * 
     * @return assuredName
     */
    public java.lang.String getAssuredName() {
        return assuredName;
    }


    /**
     * Sets the assuredName value for this BasicQuery.
     * 
     * @param assuredName
     */
    public void setAssuredName(java.lang.String assuredName) {
        this.assuredName = assuredName;
    }


    /**
     * Gets the bankCardID value for this BasicQuery.
     * 
     * @return bankCardID
     */
    public java.lang.String getBankCardID() {
        return bankCardID;
    }


    /**
     * Sets the bankCardID value for this BasicQuery.
     * 
     * @param bankCardID
     */
    public void setBankCardID(java.lang.String bankCardID) {
        this.bankCardID = bankCardID;
    }


    /**
     * Gets the branchcode value for this BasicQuery.
     * 
     * @return branchcode
     */
    public java.lang.String getBranchcode() {
        return branchcode;
    }


    /**
     * Sets the branchcode value for this BasicQuery.
     * 
     * @param branchcode
     */
    public void setBranchcode(java.lang.String branchcode) {
        this.branchcode = branchcode;
    }


    /**
     * Gets the code value for this BasicQuery.
     * 
     * @return code
     */
    public java.lang.Integer getCode() {
        return code;
    }


    /**
     * Sets the code value for this BasicQuery.
     * 
     * @param code
     */
    public void setCode(java.lang.Integer code) {
        this.code = code;
    }


    /**
     * Gets the contenct value for this BasicQuery.
     * 
     * @return contenct
     */
    public java.lang.String getContenct() {
        return contenct;
    }


    /**
     * Sets the contenct value for this BasicQuery.
     * 
     * @param contenct
     */
    public void setContenct(java.lang.String contenct) {
        this.contenct = contenct;
    }


    /**
     * Gets the distributor value for this BasicQuery.
     * 
     * @return distributor
     */
    public java.lang.String getDistributor() {
        return distributor;
    }


    /**
     * Sets the distributor value for this BasicQuery.
     * 
     * @param distributor
     */
    public void setDistributor(java.lang.String distributor) {
        this.distributor = distributor;
    }


    /**
     * Gets the extraProductName value for this BasicQuery.
     * 
     * @return extraProductName
     */
    public java.lang.String[] getExtraProductName() {
        return extraProductName;
    }


    /**
     * Sets the extraProductName value for this BasicQuery.
     * 
     * @param extraProductName
     */
    public void setExtraProductName(java.lang.String[] extraProductName) {
        this.extraProductName = extraProductName;
    }

    public java.lang.String getExtraProductName(int i) {
        return this.extraProductName[i];
    }

    public void setExtraProductName(int i, java.lang.String _value) {
        this.extraProductName[i] = _value;
    }


    /**
     * Gets the inceptionDate value for this BasicQuery.
     * 
     * @return inceptionDate
     */
    public java.lang.String getInceptionDate() {
        return inceptionDate;
    }


    /**
     * Sets the inceptionDate value for this BasicQuery.
     * 
     * @param inceptionDate
     */
    public void setInceptionDate(java.lang.String inceptionDate) {
        this.inceptionDate = inceptionDate;
    }


    /**
     * Gets the insuranceType value for this BasicQuery.
     * 
     * @return insuranceType
     */
    public java.lang.String getInsuranceType() {
        return insuranceType;
    }


    /**
     * Sets the insuranceType value for this BasicQuery.
     * 
     * @param insuranceType
     */
    public void setInsuranceType(java.lang.String insuranceType) {
        this.insuranceType = insuranceType;
    }


    /**
     * Gets the investmentAccount value for this BasicQuery.
     * 
     * @return investmentAccount
     */
    public java.lang.String getInvestmentAccount() {
        return investmentAccount;
    }


    /**
     * Sets the investmentAccount value for this BasicQuery.
     * 
     * @param investmentAccount
     */
    public void setInvestmentAccount(java.lang.String investmentAccount) {
        this.investmentAccount = investmentAccount;
    }


    /**
     * Gets the month value for this BasicQuery.
     * 
     * @return month
     */
    public java.lang.String getMonth() {
        return month;
    }


    /**
     * Sets the month value for this BasicQuery.
     * 
     * @param month
     */
    public void setMonth(java.lang.String month) {
        this.month = month;
    }


    /**
     * Gets the partyCode value for this BasicQuery.
     * 
     * @return partyCode
     */
    public java.lang.String getPartyCode() {
        return partyCode;
    }


    /**
     * Sets the partyCode value for this BasicQuery.
     * 
     * @param partyCode
     */
    public void setPartyCode(java.lang.String partyCode) {
        this.partyCode = partyCode;
    }


    /**
     * Gets the payTermYears value for this BasicQuery.
     * 
     * @return payTermYears
     */
    public java.lang.String getPayTermYears() {
        return payTermYears;
    }


    /**
     * Sets the payTermYears value for this BasicQuery.
     * 
     * @param payTermYears
     */
    public void setPayTermYears(java.lang.String payTermYears) {
        this.payTermYears = payTermYears;
    }


    /**
     * Gets the polName value for this BasicQuery.
     * 
     * @return polName
     */
    public java.lang.String getPolName() {
        return polName;
    }


    /**
     * Sets the polName value for this BasicQuery.
     * 
     * @param polName
     */
    public void setPolName(java.lang.String polName) {
        this.polName = polName;
    }


    /**
     * Gets the policyNum value for this BasicQuery.
     * 
     * @return policyNum
     */
    public java.lang.String getPolicyNum() {
        return policyNum;
    }


    /**
     * Sets the policyNum value for this BasicQuery.
     * 
     * @param policyNum
     */
    public void setPolicyNum(java.lang.String policyNum) {
        this.policyNum = policyNum;
    }


    /**
     * Gets the policysource value for this BasicQuery.
     * 
     * @return policysource
     */
    public java.lang.String getPolicysource() {
        return policysource;
    }


    /**
     * Sets the policysource value for this BasicQuery.
     * 
     * @param policysource
     */
    public void setPolicysource(java.lang.String policysource) {
        this.policysource = policysource;
    }


    /**
     * Gets the policystatus value for this BasicQuery.
     * 
     * @return policystatus
     */
    public java.lang.String getPolicystatus() {
        return policystatus;
    }


    /**
     * Sets the policystatus value for this BasicQuery.
     * 
     * @param policystatus
     */
    public void setPolicystatus(java.lang.String policystatus) {
        this.policystatus = policystatus;
    }


    /**
     * Gets the productCode value for this BasicQuery.
     * 
     * @return productCode
     */
    public java.lang.String getProductCode() {
        return productCode;
    }


    /**
     * Sets the productCode value for this BasicQuery.
     * 
     * @param productCode
     */
    public void setProductCode(java.lang.String productCode) {
        this.productCode = productCode;
    }


    /**
     * Gets the productName value for this BasicQuery.
     * 
     * @return productName
     */
    public java.lang.String getProductName() {
        return productName;
    }


    /**
     * Sets the productName value for this BasicQuery.
     * 
     * @param productName
     */
    public void setProductName(java.lang.String productName) {
        this.productName = productName;
    }


    /**
     * Gets the rate value for this BasicQuery.
     * 
     * @return rate
     */
    public java.lang.String getRate() {
        return rate;
    }


    /**
     * Sets the rate value for this BasicQuery.
     * 
     * @param rate
     */
    public void setRate(java.lang.String rate) {
        this.rate = rate;
    }


    /**
     * Gets the renewalIndicator value for this BasicQuery.
     * 
     * @return renewalIndicator
     */
    public java.lang.String getRenewalIndicator() {
        return renewalIndicator;
    }


    /**
     * Sets the renewalIndicator value for this BasicQuery.
     * 
     * @param renewalIndicator
     */
    public void setRenewalIndicator(java.lang.String renewalIndicator) {
        this.renewalIndicator = renewalIndicator;
    }


    /**
     * Gets the subSource value for this BasicQuery.
     * 
     * @return subSource
     */
    public java.lang.String getSubSource() {
        return subSource;
    }


    /**
     * Sets the subSource value for this BasicQuery.
     * 
     * @param subSource
     */
    public void setSubSource(java.lang.String subSource) {
        this.subSource = subSource;
    }


    /**
     * Gets the tInvestmentModel value for this BasicQuery.
     * 
     * @return tInvestmentModel
     */
    public cn.com.sinosoft.product.axis.domain.InvestmentModel[] getTInvestmentModel() {
        return tInvestmentModel;
    }


    /**
     * Sets the tInvestmentModel value for this BasicQuery.
     * 
     * @param tInvestmentModel
     */
    public void setTInvestmentModel(cn.com.sinosoft.product.axis.domain.InvestmentModel[] tInvestmentModel) {
        this.tInvestmentModel = tInvestmentModel;
    }

    public cn.com.sinosoft.product.axis.domain.InvestmentModel getTInvestmentModel(int i) {
        return this.tInvestmentModel[i];
    }

    public void setTInvestmentModel(int i, cn.com.sinosoft.product.axis.domain.InvestmentModel _value) {
        this.tInvestmentModel[i] = _value;
    }


    /**
     * Gets the term value for this BasicQuery.
     * 
     * @return term
     */
    public java.lang.String getTerm() {
        return term;
    }


    /**
     * Sets the term value for this BasicQuery.
     * 
     * @param term
     */
    public void setTerm(java.lang.String term) {
        this.term = term;
    }


    /**
     * Gets the totalValue value for this BasicQuery.
     * 
     * @return totalValue
     */
    public java.lang.String getTotalValue() {
        return totalValue;
    }


    /**
     * Sets the totalValue value for this BasicQuery.
     * 
     * @param totalValue
     */
    public void setTotalValue(java.lang.String totalValue) {
        this.totalValue = totalValue;
    }
    
    

    public String getPolicyChannel() {
		return policyChannel;
	}

	public void setPolicyChannel(String policyChannel) {
		this.policyChannel = policyChannel;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getStandardPremium() {
		return standardPremium;
	}

	public void setStandardPremium(String standardPremium) {
		this.standardPremium = standardPremium;
	}

	private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BasicQuery)) return false;
        BasicQuery other = (BasicQuery) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.FA==null && other.getFA()==null) || 
             (this.FA!=null &&
              this.FA.equals(other.getFA()))) &&
            ((this.accountBank==null && other.getAccountBank()==null) || 
             (this.accountBank!=null &&
              this.accountBank.equals(other.getAccountBank()))) &&
            ((this.assured==null && other.getAssured()==null) || 
             (this.assured!=null &&
              this.assured.equals(other.getAssured()))) &&
            ((this.assuredName==null && other.getAssuredName()==null) || 
             (this.assuredName!=null &&
              this.assuredName.equals(other.getAssuredName()))) &&
            ((this.bankCardID==null && other.getBankCardID()==null) || 
             (this.bankCardID!=null &&
              this.bankCardID.equals(other.getBankCardID()))) &&
            ((this.branchcode==null && other.getBranchcode()==null) || 
             (this.branchcode!=null &&
              this.branchcode.equals(other.getBranchcode()))) &&
            ((this.code==null && other.getCode()==null) || 
             (this.code!=null &&
              this.code.equals(other.getCode()))) &&
            ((this.contenct==null && other.getContenct()==null) || 
             (this.contenct!=null &&
              this.contenct.equals(other.getContenct()))) &&
            ((this.distributor==null && other.getDistributor()==null) || 
             (this.distributor!=null &&
              this.distributor.equals(other.getDistributor()))) &&
            ((this.extraProductName==null && other.getExtraProductName()==null) || 
             (this.extraProductName!=null &&
              java.util.Arrays.equals(this.extraProductName, other.getExtraProductName()))) &&
            ((this.inceptionDate==null && other.getInceptionDate()==null) || 
             (this.inceptionDate!=null &&
              this.inceptionDate.equals(other.getInceptionDate()))) &&
            ((this.insuranceType==null && other.getInsuranceType()==null) || 
             (this.insuranceType!=null &&
              this.insuranceType.equals(other.getInsuranceType()))) &&
            ((this.investmentAccount==null && other.getInvestmentAccount()==null) || 
             (this.investmentAccount!=null &&
              this.investmentAccount.equals(other.getInvestmentAccount()))) &&
            ((this.month==null && other.getMonth()==null) || 
             (this.month!=null &&
              this.month.equals(other.getMonth()))) &&
            ((this.partyCode==null && other.getPartyCode()==null) || 
             (this.partyCode!=null &&
              this.partyCode.equals(other.getPartyCode()))) &&
            ((this.payTermYears==null && other.getPayTermYears()==null) || 
             (this.payTermYears!=null &&
              this.payTermYears.equals(other.getPayTermYears()))) &&
            ((this.polName==null && other.getPolName()==null) || 
             (this.polName!=null &&
              this.polName.equals(other.getPolName()))) &&
            ((this.policyNum==null && other.getPolicyNum()==null) || 
             (this.policyNum!=null &&
              this.policyNum.equals(other.getPolicyNum()))) &&
            ((this.policysource==null && other.getPolicysource()==null) || 
             (this.policysource!=null &&
              this.policysource.equals(other.getPolicysource()))) &&
            ((this.policystatus==null && other.getPolicystatus()==null) || 
             (this.policystatus!=null &&
              this.policystatus.equals(other.getPolicystatus()))) &&
            ((this.productCode==null && other.getProductCode()==null) || 
             (this.productCode!=null &&
              this.productCode.equals(other.getProductCode()))) &&
            ((this.productName==null && other.getProductName()==null) || 
             (this.productName!=null &&
              this.productName.equals(other.getProductName()))) &&
            ((this.rate==null && other.getRate()==null) || 
             (this.rate!=null &&
              this.rate.equals(other.getRate()))) &&
            ((this.renewalIndicator==null && other.getRenewalIndicator()==null) || 
             (this.renewalIndicator!=null &&
              this.renewalIndicator.equals(other.getRenewalIndicator()))) &&
            ((this.subSource==null && other.getSubSource()==null) || 
             (this.subSource!=null &&
              this.subSource.equals(other.getSubSource()))) &&
            ((this.tInvestmentModel==null && other.getTInvestmentModel()==null) || 
             (this.tInvestmentModel!=null &&
              java.util.Arrays.equals(this.tInvestmentModel, other.getTInvestmentModel()))) &&
            ((this.term==null && other.getTerm()==null) || 
             (this.term!=null &&
              this.term.equals(other.getTerm()))) &&
            ((this.totalValue==null && other.getTotalValue()==null) || 
             (this.totalValue!=null &&
              this.totalValue.equals(other.getTotalValue()))) &&
            ((this.policyChannel==null && other.getPolicyChannel()==null) || 
             (this.policyChannel!=null &&
              this.policyChannel.equals(other.getPolicyChannel()))) &&
            ((this.productType==null && other.getProductType()==null) || 
             (this.productType!=null &&
              this.productType.equals(other.getProductType()))) &&
            ((this.standardPremium==null && other.getStandardPremium()==null) || 
             (this.standardPremium!=null &&
              this.standardPremium.equals(other.getStandardPremium())));
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
        if (getFA() != null) {
            _hashCode += getFA().hashCode();
        }
        if (getAccountBank() != null) {
            _hashCode += getAccountBank().hashCode();
        }
        if (getAssured() != null) {
            _hashCode += getAssured().hashCode();
        }
        if (getAssuredName() != null) {
            _hashCode += getAssuredName().hashCode();
        }
        if (getBankCardID() != null) {
            _hashCode += getBankCardID().hashCode();
        }
        if (getBranchcode() != null) {
            _hashCode += getBranchcode().hashCode();
        }
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getContenct() != null) {
            _hashCode += getContenct().hashCode();
        }
        if (getDistributor() != null) {
            _hashCode += getDistributor().hashCode();
        }
        if (getExtraProductName() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExtraProductName());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExtraProductName(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInceptionDate() != null) {
            _hashCode += getInceptionDate().hashCode();
        }
        if (getInsuranceType() != null) {
            _hashCode += getInsuranceType().hashCode();
        }
        if (getInvestmentAccount() != null) {
            _hashCode += getInvestmentAccount().hashCode();
        }
        if (getMonth() != null) {
            _hashCode += getMonth().hashCode();
        }
        if (getPartyCode() != null) {
            _hashCode += getPartyCode().hashCode();
        }
        if (getPayTermYears() != null) {
            _hashCode += getPayTermYears().hashCode();
        }
        if (getPolName() != null) {
            _hashCode += getPolName().hashCode();
        }
        if (getPolicyNum() != null) {
            _hashCode += getPolicyNum().hashCode();
        }
        if (getPolicysource() != null) {
            _hashCode += getPolicysource().hashCode();
        }
        if (getPolicystatus() != null) {
            _hashCode += getPolicystatus().hashCode();
        }
        if (getProductCode() != null) {
            _hashCode += getProductCode().hashCode();
        }
        if (getProductName() != null) {
            _hashCode += getProductName().hashCode();
        }
        if (getRate() != null) {
            _hashCode += getRate().hashCode();
        }
        if (getRenewalIndicator() != null) {
            _hashCode += getRenewalIndicator().hashCode();
        }
        if (getSubSource() != null) {
            _hashCode += getSubSource().hashCode();
        }
        if (getTInvestmentModel() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTInvestmentModel());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTInvestmentModel(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTerm() != null) {
            _hashCode += getTerm().hashCode();
        }
        if (getTotalValue() != null) {
            _hashCode += getTotalValue().hashCode();
        }
        if (getPolicyChannel() != null) {
            _hashCode += getPolicyChannel().hashCode();
        }
        if (getProductType() != null) {
            _hashCode += getProductType().hashCode();
        }
        if (getStandardPremium() != null) {
            _hashCode += getStandardPremium().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BasicQuery.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "BasicQuery"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "FA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountBank");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "accountBank"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("assured");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "assured"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("assuredName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "assuredName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankCardID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "bankCardID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("branchcode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "branchcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contenct");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "contenct"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("distributor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "distributor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extraProductName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "extraProductName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inceptionDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "inceptionDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insuranceType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "insuranceType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("investmentAccount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "investmentAccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("month");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "month"));
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
        elemField.setFieldName("payTermYears");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "payTermYears"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("polName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "polName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyNum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "policyNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policysource");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "policysource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policystatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "policystatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "productCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "productName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "rate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("renewalIndicator");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "renewalIndicator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subSource");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "subSource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TInvestmentModel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "tInvestmentModel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "InvestmentModel"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("term");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "term"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "totalValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("policyChannel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "policyChannel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "productType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("standardPremium");
        elemField.setXmlName(new javax.xml.namespace.QName("http://model.webservices.sinosoft.com/xsd", "standardPremium"));
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
