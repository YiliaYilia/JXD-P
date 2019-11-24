package cn.com.sinosoft.product.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.utils.ExcelImport;
import cn.com.sinosoft.domain.sell.GeChildlist;
import cn.com.sinosoft.product.service.ChildListService;

@Component
public class ChildListServiceImpl extends GenericHibernateDao<GeChildlist, String> implements ChildListService {

	public boolean saveChild(String filepath) {
		Map<String, String> header = new HashMap<String, String>();
		header.put("姓名", "name");
		header.put("性别", "sex");
		header.put("证件类型", "identifytype");
		header.put("证件号码", "identifynumber");
		header.put("邮编", "zipcode");
		header.put("电话", "mobile");
		header.put("邮箱", "email");
		header.put("地址", "address");
		header.put("出生日期", "birthday");
		header.put("学历", "grade");
		header.put("地区", "province");
		header.put("投保人告知", "notice");
		header.put("备注", "remark");
		header.put("照片URL", "imageurl");
		header.put("学杂费", "tuition");
		ExcelImport export = new ExcelImport(header);
		try {
			export.init(new FileInputStream(new File(filepath)));
			List<GeChildlist> child = export.bindToModels(GeChildlist.class, true);
//			if (export.hasError()){
//				System.out.println(export.getError().toString());
//				child.clear();
//				return false;
//			}else{
				this.saveAll(child);
//			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	

}
