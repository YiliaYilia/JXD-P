package cn.com.sinosoft.web.service.impl;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.RenewalPayRecords;
import cn.com.sinosoft.web.service.facade.RenewalPayRecordsService;
import cn.com.sinosoft.web.util.CommonUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class RenewalPayRecordsServiceImp extends GenericHibernateDao<RenewalPayRecords,String> implements RenewalPayRecordsService {
    private static Log logger = LogFactory.getLog(RenewalServiceImpl.class);

    @Override
    public void saveRecords(String policyCode, String appntname, String duenum, String dueDate, String paystate,String paybank, String paybankcode, String bankstate, String mobile, double premium,String serialno,String resultstate) {
        RenewalPayRecords renewalPayRecords = new RenewalPayRecords();
        renewalPayRecords.setPolicyno(policyCode);
        renewalPayRecords.setAppntname(appntname);
        renewalPayRecords.setDuenum(duenum);
        renewalPayRecords.setDuetime(dueDate);
        renewalPayRecords.setPaystate(paystate);
        renewalPayRecords.setPaybank(paybank);
        renewalPayRecords.setPaybankcode(paybankcode);
        renewalPayRecords.setBankstate(bankstate);
        renewalPayRecords.setMobile(mobile);
        renewalPayRecords.setPremium(premium);
        renewalPayRecords.setSerialnumber(serialno);
        renewalPayRecords.setResultstate(resultstate);
        renewalPayRecords.setCreatetime(new Date());
        super.save(renewalPayRecords);

    }

    @Override
    public RenewalPayRecords findByPolicyNo(String policyno) {
        QueryRule queryRule = QueryRule.getInstance();
        queryRule.addEqual("policyno",policyno);
        return findUnique(queryRule);
    }

    @Override
    public void updateRecords(String updateKey,String serialno, boolean timeflag,String paystatevalue,String resultstatevalue) {
        RenewalPayRecords renewalPayRecords =findByPolicyNo(updateKey);
        renewalPayRecords.setSerialnumber(serialno);
        if(timeflag){
            renewalPayRecords.setPaytime(new Date());
        }
        renewalPayRecords.setResultstate(resultstatevalue);
        renewalPayRecords.setPaystate(paystatevalue);
        super.update(renewalPayRecords);

    }

}
