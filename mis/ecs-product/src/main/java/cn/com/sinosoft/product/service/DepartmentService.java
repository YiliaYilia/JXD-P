package cn.com.sinosoft.product.service;

import java.util.List;

import cn.com.sinosoft.domain.system.GeDepartment;

public interface DepartmentService {
	
	public List<GeDepartment> getAllDepartment();
	
	public GeDepartment getDepartmentByDetpid(String deptid);

}
