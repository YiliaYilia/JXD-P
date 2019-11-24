package cn.com.sinosoft.domain.sale;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "renewal_pay_records_logs")
public class RenewalPayRecordsLogs implements java.io.Serializable{
    private String id;
    private String policyno;
    private String appntname;
    private String duenum;
    private String duetime;
    //支付时间
    private Date paytime;
    //支付状态
    private String paystate;
    private String paybank;
    private String paybankcode;
    private String bankstate;
    private String mobile;
    private double premium;
    private String serialnumber;
    //挂起状态
    private String resultstate;
    private Date createtime;
    private Date updatetime;

    @Id
    @Column(name = "id", unique = true)
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Column(name = "policy_no")
    public String getPolicyno() {
        return policyno;
    }

    public void setPolicyno(String policyno) {
        this.policyno = policyno;
    }
    @Column(name = "appnt_name")
    public String getAppntname() {
        return appntname;
    }

    public void setAppntname(String appntname) {
        this.appntname = appntname;
    }
    @Column(name = "due_num")
    public String getDuenum() {
        return duenum;
    }

    public void setDuenum(String duenum) {
        this.duenum = duenum;
    }
    @Column(name = "due_time")
    public String getDuetime() {
        return duetime;
    }

    public void setDuetime(String duetime) {
        this.duetime = duetime;
    }
    @Column(name = "pay_time")
    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }
    @Column(name = "pay_state")
    public String getPaystate() {
        return paystate;
    }

    public void setPaystate(String paystate) {
        this.paystate = paystate;
    }
    @Column(name = "pay_bank")
    public String getPaybank() {
        return paybank;
    }

    public void setPaybank(String paybank) {
        this.paybank = paybank;
    }
    @Column(name = "pay_bank_code")
    public String getPaybankcode() {
        return paybankcode;
    }

    public void setPaybankcode(String paybankcode) {
        this.paybankcode = paybankcode;
    }
    @Column(name = "bank_state")
    public String getBankstate() {
        return bankstate;
    }

    public void setBankstate(String bankstate) {
        this.bankstate = bankstate;
    }

    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    @Column(name = "premium")
    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }
    @Column(name = "serial_number")
    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }
    @Column(name = "result_state")
    public String getResultstate() {
        return resultstate;
    }

    public void setResultstate(String resultstate) {
        this.resultstate = resultstate;
    }
    @Column(name = "create_time")
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    @Column(name = "update_time")
    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
