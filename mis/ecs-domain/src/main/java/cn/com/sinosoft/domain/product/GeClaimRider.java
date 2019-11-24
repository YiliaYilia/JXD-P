package cn.com.sinosoft.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 理赔附件
 * @author GHY
 */
@Entity
@Table(name = "GE_CLAIM_RIDER")
public class GeClaimRider implements java.io.Serializable {
	
	private static final long serialVersionUID = 8764039499637610818L;
	
	private String id;				
	private String riderPath;		//附件路径
	private GeClaimManagement claimManagement;
	
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
	
	@Column(name = "RIDERPATH")
	public String getRiderPath() {
		return riderPath;
	}
	
	public void setRiderPath(String riderPath) {
		this.riderPath = riderPath;
	}
	
	@ManyToOne(targetEntity = cn.com.sinosoft.domain.product.GeClaimManagement.class)
	@JoinColumn(name="CLAIMMANAGEMENTNO",referencedColumnName="CLAIMMANAGEMENTNO")//加入一列作为外键
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	public GeClaimManagement getClaimManagement() {
		return claimManagement;
	}
	public void setClaimManagement(GeClaimManagement claimManagement) {
		this.claimManagement = claimManagement;
	}
	
}
