package cn.com.sinosoft.msl.service.impl;


import java.util.List;
import java.util.ResourceBundle;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//import cn.com.sinosoft.core.utils.HttpUtil;
//import cn.com.sinosoft.domain.msl.local.MslOffice;
import cn.com.sinosoft.domain.msl.remote.MslRegion;
import cn.com.sinosoft.ess.config.service.OfficeService;
import cn.com.sinosoft.ess.config.service.RegionalService;
import cn.com.sinosoft.ess.config.service.impl.RegionalServiceImpl;
import cn.com.sinosoft.ess.protal.parser.BancassuranceXmlParser;
import cn.com.sinosoft.ess.protal.parser.impl.BancassuranceXmlParserImpl;
//import cn.com.sinosoft.ess.protal.common.ConfigProp;
//import cn.com.sinosoft.ess.protal.common.PortalProp;
import cn.com.sinosoft.msl.service.RegionalOfficeService;

@Component
@Service("regionalOfficeService")
public class RegionalOfficeServiceImpl implements RegionalOfficeService{
	@Autowired
	private OfficeService officeService;
	@Autowired
	private RegionalService regionalService;
	
	
	public MslRegion regionInit(List<MslRegion> provinceList, String type) {
		MslRegion region = null;
		if("address".equals(type)){
			provinceList.addAll(regionalService.getPronviceList());
		}else if("office".equals(type)){
			List<String> list=officeService.getOfficeCityCode();
	 		provinceList.addAll(regionalService.getPronviceList(list));
			region = new MslRegion();
			region.setProvinceCode(-1);
			region.setProvinceName("请选择");
			region.setCityCode(-1);
			region.setCityName("请选择");
		}
		
		return region;
	}
	
	public OfficeService getOfficeService() {
		return officeService;
	}

	public void setOfficeService(OfficeService officeService) {
		this.officeService = officeService;
	}

	public RegionalService getRegionalService() {
		return regionalService;
	}

	public void setRegionalService(RegionalService regionalService) {
		this.regionalService = regionalService;
	}

}
