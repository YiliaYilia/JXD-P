package cn.com.sinosoft.domain.sale;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "renewal_bank")
public class RenewalBankData implements java.io.Serializable {
    private String bankID;
    private String bankcode;
    private String bankname;
    private String paychannel;
    private String singlelmt;
    private String daylmt;
    private String status;
    private String remark;
    private Date createtime;
    private String createuser;
    private Date updatetime;
    private String updateuser;
    private String bak1;
    private String bak2;
    private String bak3;
    @Id
    @Column(name = "bankID", unique = true)
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    public String getBankID() {
        return bankID;
    }

    public void setBankID(String bankID) {
        this.bankID = bankID;
    }

    @Column(name = "bank_code", unique = true)
    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }
    @Column(name = "bank_name")
    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }
    @Column(name = "pay_channel")
    public String getPaychannel() {
        return paychannel;
    }

    public void setPaychannel(String paychannel) {
        this.paychannel = paychannel;
    }
    @Column(name = "single_lmt")
    public String getSinglelmt() {
        return singlelmt;
    }

    public void setSinglelmt(String singlelmt) {
        this.singlelmt = singlelmt;
    }
    @Column(name = "day_lmt")
    public String getDaylmt() {
        return daylmt;
    }

    public void setDaylmt(String daylmt) {
        this.daylmt = daylmt;
    }
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    @Column(name = "create_user")
    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
    @Column(name = "update_user")
    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser;
    }
    @Column(name = "bak1")
    public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1;
    }
    @Column(name = "bak2")
    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2;
    }
    @Column(name = "bak3")
    public String getBak3() {
        return bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3;
    }

}
