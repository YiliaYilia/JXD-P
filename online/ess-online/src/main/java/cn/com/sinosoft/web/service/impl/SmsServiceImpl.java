package cn.com.sinosoft.web.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.web.service.facade.SmsService;

@Service("smsService")
public class SmsServiceImpl implements SmsService {
	private final static Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);
    @Resource(name="smsTemplate")
    private JdbcTemplate smsTemplate;
    
	@Override
	public void send(String phoneNo, String message) {
		if (phoneNo.trim().length()==0) {
			throw new RuntimeException("空手机号");
		}
		String sql = "insert into sm_send_sm_list (" +
					 "	serviceID,sendtarget,smcontent,priority" +
					 "	,RcompleteTimeBegin,RcompleteTimeEnd" +
					 "	,RcompleteHourBegin,RcompleteHourEnd" +
					 "	,RequestTime,Roadby" +
					 "	,sendtargetdesc) " +
					 "values(" +
					 "	'E-Commerce',?,?,0" +
					 "	,GetDate(),GetDate()" +
					 "	,0,1439" +
					 "	,GetDate(),1" +
					 "	,'电商短信验证-'+CONVERT(varchar(100),GETDATE(),25))";
		try {
			smsTemplate.update(sql, new Object[] {phoneNo, message});
			logger.debug("Sending message["+message+"] to ["+phoneNo + "]...");
		} catch (DataAccessException e) {
			logger.warn("Send failed, resend again...");
			try {
				smsTemplate.update(sql, new Object[] {phoneNo, message});
			} catch (DataAccessException e1) {
				logger.warn("Resend message[" + message + "] to [" + phoneNo
						+ "] failed, caused by: " + e.getLocalizedMessage());
				throw e;
			}
		}
	}

}
