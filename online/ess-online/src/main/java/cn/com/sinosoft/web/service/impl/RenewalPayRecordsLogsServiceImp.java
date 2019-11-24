package cn.com.sinosoft.web.service.impl;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.domain.sale.RenewalPayRecordsLogs;
import cn.com.sinosoft.web.service.facade.RenewalPayRecordsLogsService;
import cn.com.sinosoft.web.util.CommonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.util.StringUtil;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class RenewalPayRecordsLogsServiceImp extends GenericHibernateDao<RenewalPayRecordsLogs,String> implements RenewalPayRecordsLogsService {
    private static Log logger = LogFactory.getLog(RenewalServiceImpl.class);

    @Override
    public void saveRecords(String policyCode, String appntname, String duenum, String dueDate, boolean timeflag,String paysate,String paybank, String paybankcode, String bankstate, String mobile, double premium,String serialnumber,String resultstate) {
        RenewalPayRecordsLogs renewalPayRecords = new RenewalPayRecordsLogs();
        renewalPayRecords.setPolicyno(policyCode);
        renewalPayRecords.setAppntname(appntname);
        renewalPayRecords.setDuenum(duenum);
        renewalPayRecords.setDuetime(dueDate);
        renewalPayRecords.setPaybank(paybank);
        renewalPayRecords.setPaybankcode(paybankcode);
        renewalPayRecords.setBankstate(bankstate);
        renewalPayRecords.setMobile(mobile);
        renewalPayRecords.setPremium(premium);
        renewalPayRecords.setSerialnumber(serialnumber);
        renewalPayRecords.setCreatetime(new Date());
        renewalPayRecords.setPaystate(paysate);
        if(timeflag){
            renewalPayRecords.setPaytime(new Date());
        }
            super.save(renewalPayRecords);
    }



}
