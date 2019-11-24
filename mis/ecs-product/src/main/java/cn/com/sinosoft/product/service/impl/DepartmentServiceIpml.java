package cn.com.sinosoft.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.system.GeDepartment;
import cn.com.sinosoft.product.service.DepartmentService;

@Component
public class DepartmentServiceIpml extends GenericHibernateDao<GeDepartment, String> implements DepartmentService{

	@Override
	public List<GeDepartment> getAllDepartment() {
		QueryRule queryRule = QueryRule.getInstance();
		List<GeDepartment> list = super.find(queryRule);
		return list;
	}

	@Override
	public GeDepartment getDepartmentByDetpid(String deptid) {
		return super.get(deptid);
	}

}
