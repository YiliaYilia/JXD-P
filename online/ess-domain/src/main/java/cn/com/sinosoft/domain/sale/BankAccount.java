package cn.com.sinosoft.domain.sale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "renewal_bank_account")
public class BankAccount implements java.io.Serializable {
    private String customerno;
    private String appntname;
    private String paybankname;
    private String paybankcode;
    private Date createtime;
    private String bak1;
    private String bak2;
    private String bak3;
    @Id
    @Column(name = "bankID", unique = true)
    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }
    @Column(name = "appnt_name" )
    public String getAppntname() {
        return appntname;
    }

    public void setAppntname(String appntname) {
        this.appntname = appntname;
    }
    @Column(name = "pay_bank_name" )
    public String getPaybankname() {
        return paybankname;
    }

    public void setPaybankname(String paybankname) {
        this.paybankname = paybankname;
    }
    @Column(name = "pay_bank_code" )
    public String getPaybankcode() {
        return paybankcode;
    }

    public void setPaybankcode(String paybankcode) {
        this.paybankcode = paybankcode;
    }
    @Column(name = "create_time" )
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    @Column(name = "bak1" )
    public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1;
    }
    @Column(name = "bak2" )
    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2;
    }
    @Column(name = "bak3" )
    public String getBak3() {
        return bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3;
    }
}
