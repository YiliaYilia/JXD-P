package cn.com.sinosoft.web.service.facade;

import cn.com.sinosoft.domain.sale.RenewalPayRecords;

import java.util.Map;

public interface RenewalPayRecordsLogsService {
    public void saveRecords(String policyCode, String appntname, String duenum, String dueDate, boolean timeflag,String paysate,String paybank, String paybankcode, String bankstate, String mobile, double premium,String serialnumber,String resultstate);

}
