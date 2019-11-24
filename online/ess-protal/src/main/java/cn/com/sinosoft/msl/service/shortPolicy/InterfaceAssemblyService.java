package cn.com.sinosoft.msl.service.shortPolicy;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.omgd.ec.ws.DoAppE;
import com.omgd.ec.ws.DoAppResponseE;

import cn.com.sinosoft.core.exception.BaseException;
import cn.com.sinosoft.ess.protal.webservice.Axis2ClientUtils;


public class InterfaceAssemblyService {
	
	private static final Logger logger = LoggerFactory.getLogger(InterfaceAssemblyService.class);
	
	private static final String SHORTPOLICY_WEBSERVICE_URL = "SHORTPOLICY_WebServiceURL";
	private static final String SHORTPOLICY_WEBSERVICE_NAMESPACE = "SHORTPOLICY_WebServiceNamespace";

	
	public static DoAppResponseE underWriting(DoAppE doAppE) throws BaseException, JAXBException {
		DoAppResponseE response = null;
		response =  Axis2ClientUtils.callRemoteService(doAppE);
		return response;
	}
	
	public static DoAppResponseE blewWriting(DoAppE doAppE) throws BaseException, JAXBException {
		DoAppResponseE response = null;
		response =  Axis2ClientUtils.callRemoteService(doAppE);
		return response;
	}
}