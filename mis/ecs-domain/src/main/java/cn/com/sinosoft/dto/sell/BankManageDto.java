package cn.com.sinosoft.dto.sell;

import java.util.Date;
import java.util.List;

public class BankManageDto {
    private String total;
    private List<BankManageRow> rows;

    public String getTotal()
    {
        return this.total; }

    public void setTotal(String total) {
        this.total = total; }

    public List<BankManageRow> getRows() {
        return this.rows; }

    public void setRows(List<BankManageRow> rows) {
        this.rows = rows;
    }

    public static class BankManageRow {
        private String bankID;
        private String bankcode;
        private String bankname;
        private String paychannel;
        private String singlelmt;
        private String daylmt;
        private String status;
        private String remark;
        private String createtime;
        private String createuser;
        private String updatetime;
        private String updateuser;
        private String bak1;
        private String bak2;
        private String bak3;
        public String getBankID() {
            return bankID;
        }

        public void setBankID(String bankID) {
            this.bankID = bankID;
        }
        public String getBankcode() {
            return bankcode;
        }

        public void setBankcode(String bankcode) {
            this.bankcode = bankcode;
        }

        public String getBankname() {
            return bankname;
        }

        public void setBankname(String bankname) {
            this.bankname = bankname;
        }

        public String getPaychannel() {
            return paychannel;
        }

        public void setPaychannel(String paychannel) {
            this.paychannel = paychannel;
        }

        public String getSinglelmt() {
            return singlelmt;
        }

        public void setSinglelmt(String singlelmt) {
            this.singlelmt = singlelmt;
        }

        public String getDaylmt() {
            return daylmt;
        }

        public void setDaylmt(String daylmt) {
            this.daylmt = daylmt;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getCreateuser() {
            return createuser;
        }

        public void setCreateuser(String createuser) {
            this.createuser = createuser;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public String getUpdateuser() {
            return updateuser;
        }

        public void setUpdateuser(String updateuser) {
            this.updateuser = updateuser;
        }

        public String getBak1() {
            return bak1;
        }

        public void setBak1(String bak1) {
            this.bak1 = bak1;
        }

        public String getBak2() {
            return bak2;
        }

        public void setBak2(String bak2) {
            this.bak2 = bak2;
        }

        public String getBak3() {
            return bak3;
        }

        public void setBak3(String bak3) {
            this.bak3 = bak3;
        }
    }
}
