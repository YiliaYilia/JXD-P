package cn.com.sinosoft.domain.msl;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="msl_insurancerate")
public class MslInsuranceRate implements Serializable{
	
	/**
	 * 网销专属产品费率计算: 三款产品的的试算因子
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	private String serialNo;
	
	/**
	 * 产品名称: 中宏私家车意外伤害保险, 中宏旅游意外伤害保险, 中宏法定节假日意外伤害保险
	 */
	private String prodoctName;//
	
	/**
	 * 产品代码: 中宏私家车意外伤害保险A, 中宏旅游意外伤害保险B, 中宏法定节假日意外伤害保险C
	 */
	private String prodoctCode;//
	
	/**
	 * 保障期间的数量: 1, 3,7,14，单位天、年
	 */
	private String policyPeriodNumber;
	
	/**
	 * 保障期间的类型: 年, 月, 天
	 */
	private String policyPeriodType;
	
	/**
	 * 缴费期间的数量: 趸交0, 3年期缴..., 18缴至成年
	 */
	private int payPeriodNumber;//
	
	/**
	 * 缴费期间的类型: 年, 月, 日
	 */
	private String payPeriodType;
	
	/**
	 * 备用字段
	 * 性别: 男0, 女1
	 */
	private int gender;
	
	/**
	 * 备用字段
	 * 年龄
	 */
	private int age;
	
	/**
	 * 备用字段
	 * 基数保额: 以100的倍数作为试算因子. 产品输入的保额必须是100的倍数, 最后得出试算保费的数字乘以此倍数.
	 */
	private double baseAmount;
	
	/**
	 * 备用字段
	 * 基数保费
	 */
	private double basePremium;
	
	/**
	 * 创建时间: 插入记录时的时间
	 */
	private Date createTime;
	
	/**
	 * 修改时间: 每次更新的时间
	 */
	private Date modifyTime;

	@Id
	@Column(name = "SerialNo", nullable = false)
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	@Column(name = "BASEAMOUNT")
	public double getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(double baseAmount) {
		this.baseAmount = baseAmount;
	}
	@Column(name = "BASEPREMIUM")
	public double getBasePremium() {
		return basePremium;
	}

	public void setBasePremium(double basePremium) {
		this.basePremium = basePremium;
	}
	@Column(name = "PRODOCTNAME")
	public String getProdoctName() {
		return prodoctName;
	}

	public void setProdoctName(String prodoctName) {
		this.prodoctName = prodoctName;
	}
	@Column(name = "PRODOCTCODE")
	public String getProdoctCode() {
		return prodoctCode;
	}

	public void setProdoctCode(String prodoctCode) {
		this.prodoctCode = prodoctCode;
	}
	@Column(name = "PAYPERIODNUMBER")
	public int getPayPeriodNumber() {
		return payPeriodNumber;
	}

	public void setPayPeriodNumber(int payPeriodNumber) {
		this.payPeriodNumber = payPeriodNumber;
	}
	@Column(name = "PAYPERIODTYPE")
	public String getPayPeriodType() {
		return payPeriodType;
	}

	public void setPayPeriodType(String payPeriodType) {
		this.payPeriodType = payPeriodType;
	}
	@Column(name = "GENDER")
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}
	@Column(name = "AGE")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@Column(name = "CREATETIME")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name = "MODIFYTIME")
	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	@Column(name = "POLICYPERIODNUMBER")
	public String getPolicyPeriodNumber() {
		return policyPeriodNumber;
	}

	public void setPolicyPeriodNumber(String policyPeriodNumber) {
		this.policyPeriodNumber = policyPeriodNumber;
	}
	
	@Column(name = "POLICYPERIODTYPE")
	public String getPolicyPeriodType() {
		return policyPeriodType;
	}

	public void setPolicyPeriodType(String policyPeriodType) {
		this.policyPeriodType = policyPeriodType;
	}
	
	
}
