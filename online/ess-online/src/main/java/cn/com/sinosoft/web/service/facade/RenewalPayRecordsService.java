package cn.com.sinosoft.web.service.facade;

import cn.com.sinosoft.domain.sale.RenewalPayRecords;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public interface RenewalPayRecordsService {
    public void saveRecords(String policyCode, String appntname, String duenum, String dueDate, String paystate,String paybank, String paybankcode, String bankstate, String mobile, double premium,String serialno,String resultstate);
    public void updateRecords(String updateKey, String serialno,boolean timeflag, String paystatevalue, String resultstatevalue);
    public RenewalPayRecords findByPolicyNo(String policyno);
}
