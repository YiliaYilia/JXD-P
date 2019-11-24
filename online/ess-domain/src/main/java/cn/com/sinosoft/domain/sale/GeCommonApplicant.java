package cn.com.sinosoft.domain.sale;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "GE_COMMONAPPLICANT")
public class GeCommonApplicant implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private String id; //id
	
	private String openid; //openid
	
	private String name; //姓名
	
	private String idtype; //证件类型
	
	private String idno; //证件号码
	
	private String flag; //标识 1-投保人，2-被保人
	
	private String sex;//性别
	
	private Date birthday;//生日
	
	private String address;//地址
	
	private String mobile; //手机
	
	private String email;// 邮箱
	
	private Date createtime;//创建时间
	
	/** default constructor */
	public GeCommonApplicant(){
		
	}
	public GeCommonApplicant(String id,String openid,String name,String idtype,String idno,String flag,
			String sex,Date birthday,String address,String mobile,String email,Date createtime){
			this.id=id;
			this.openid=openid;
			this.name=name;
			this.idtype=idtype;
			this.idno=idno;
			this.flag=flag;
			this.sex=sex;
			this.birthday=birthday;
			this.address=address;
			this.mobile=mobile;
			this.email=email;
			this.createtime=createtime;
		}
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "ID", unique = true, nullable = false)
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "OPENID")
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "IDTYPE")
	public String getIdtype() {
		return idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	@Column(name = "IDNO")
	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	@Column(name = "FLAG")
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Column(name = "SEX")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "BIRTHDAY")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "MOBILE")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "CREATETIME")
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	
	
}
