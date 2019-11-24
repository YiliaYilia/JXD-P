package cn.com.sinosoft.product.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.core.utils.StringUtils;
import cn.com.sinosoft.domain.product.GeClaimManagement;
import cn.com.sinosoft.domain.sell.GeOrder;
import cn.com.sinosoft.domain.sell.GePolicy;
import cn.com.sinosoft.domain.system.GeDepartment;
import cn.com.sinosoft.product.axis.domain.BasicQuery;
import cn.com.sinosoft.product.axis.service.PolicyBasicQueryService;
import cn.com.sinosoft.product.service.ClaimService;
import cn.com.sinosoft.product.service.DepartmentService;

@Component
public class ClaimServiceImpl extends GenericHibernateDao<GeClaimManagement, String> implements ClaimService{
	
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private PolicyBasicQueryService policyBasicQueryService;
	
	/**
	 * 分页查询理赔列表
	 */
	@Override
	public Page<GeClaimManagement> getClaim(GeClaimManagement geClaim,int page, int rows) {
		QueryRule queryRule = QueryRule.getInstance();
		if(geClaim!=null){
			if(!StringUtils.isEmpty(geClaim.getPolicyCode())){
				queryRule.addLike("policyCode", "%"+geClaim.getPolicyCode()+"%");
			}
			if(!StringUtils.isEmpty(geClaim.getName())){
				queryRule.addLike("name", "%"+geClaim.getName()+"%");
			}
			if(geClaim.getStarttime()!=null){
				queryRule.addGreaterEqual("createDate",geClaim.getStarttime());
			}
			if(geClaim.getEndtime()!=null){
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(geClaim.getEndtime());
				calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
				queryRule.addLessEqual("createDate",calendar.getTime());
			}
			if(!StringUtils.isEmpty(geClaim.getState())){
				queryRule.addEqual("state", geClaim.getState());
			}
		}
		queryRule.addDescOrder("createDate");
		Page<GeClaimManagement> find = super.find(queryRule, page, rows);
		for(GeClaimManagement geClaimManagement: (List<GeClaimManagement>)find.getData()){
			String detpid = geClaimManagement.getDeptid()==null?"":geClaimManagement.getDeptid();
	    	GeDepartment department = departmentService.getDepartmentByDetpid(detpid);
	    	String deptname = department==null?"":department.getDeptname();
	    	geClaimManagement.setDeptid(deptname);
		}
		return find;
	}

	/**
	 * 查询理赔详细信息
	 */
	@Override
	public GeClaimManagement getClaimByClaimNo(String claimManagementNo) {
		return super.get(claimManagementNo);
	}

	/**
	 * 录入退回原因
	 */
	@Override
	public void updateClaimRemark(GeClaimManagement claim) {
		super.update(claim);
	}
	/**
	 * 理赔信息导出信息查询
	 * @param claim
	 */
	public List<GeClaimManagement> findbyquery(GeClaimManagement claim,Set<GeDepartment> departments){
		QueryRule instance = QueryRule.getInstance();
			if(claim.getPolicyCode()!=null&&claim.getPolicyCode().length()>0){
				instance.addLike("policyCode","%"+claim.getPolicyCode()+"%");
			}
			if(claim.getName()!=null&&claim.getName().length()>0){
				instance.addLike("name", "%"+claim.getName()+"%");
			}
			if(claim.getState()!=null&&claim.getState().length()>0){
				instance.addEqual("state", claim.getState());
			}
			if(claim.getStarttime()!=null){
				instance.addGreaterEqual("createDate", claim.getStarttime());
			}
			if(claim.getEndtime()!=null){
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(claim.getEndtime());
				calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
				instance.addLessThan("createDate",calendar.getTime());
			}
			if(departments != null){
				List<Object> gdList = new ArrayList<Object>();
				for (GeDepartment department : departments) {
					Object deptid = department.getDeptid();
						gdList.add(deptid);
				}
				instance.addIn("deptid", gdList);
			}
		instance.addDescOrder("createDate");
		return super.find(instance);
	}
 
	@Override
	public Page<GeClaimManagement> getClaim(Set<GeDepartment> departments,
			GeClaimManagement geClaim, int page, int rows) {
		boolean flag = true;
		List<Object> gdList = new ArrayList<Object>();
		for (GeDepartment department : departments) {
			Object deptid = department.getDeptid();
				gdList.add(deptid);
		}
		QueryRule queryRule = QueryRule.getInstance();
		if(geClaim!=null){
			if(!StringUtils.isEmpty(geClaim.getPolicyCode())){
				queryRule.addLike("policyCode", "%"+geClaim.getPolicyCode()+"%");
			}
			if(!StringUtils.isEmpty(geClaim.getName())){
				queryRule.addLike("name", "%"+geClaim.getName()+"%");
			}
			if(geClaim.getStarttime()!=null){
				queryRule.addGreaterEqual("createDate",geClaim.getStarttime());
			}
			if(geClaim.getEndtime()!=null){
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(geClaim.getEndtime());
				calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
				queryRule.addLessEqual("createDate",calendar.getTime());
			}
			if(!StringUtils.isEmpty(geClaim.getState())){
				queryRule.addEqual("state", geClaim.getState());
			}
			if(!StringUtils.isEmpty(geClaim.getDeptid())){
				for (Object object : gdList) {
					if (geClaim.getDeptid().equals((String)object)) {
						flag = false;
					}
				}
				if(!flag){
					queryRule.addEqual("deptid", geClaim.getDeptid());
				}
			}
		}
		if (flag) {
			queryRule.addIn("deptid", gdList);
		}
		queryRule.addDescOrder("createDate");
		Page<GeClaimManagement> find = super.find(queryRule, page, rows);
		for(GeClaimManagement geClaimManagement: (List<GeClaimManagement>)find.getData()){
			String detpid = geClaimManagement.getDeptid()==null?"":geClaimManagement.getDeptid();
	    	GeDepartment department = departmentService.getDepartmentByDetpid(detpid);
	    	String deptname = department==null?"":department.getDeptname();
	    	geClaimManagement.setDeptid(deptname);
		}
		return find;
	}

	@Override
	public void completionDepartmentForClaim() {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addIsNull("deptid");
		List<GeClaimManagement> claimList= super.find(queryRule);
		for(GeClaimManagement claim: claimList){
			//从核心抓取该保单所属市场
			BasicQuery policyBasic = policyBasicQueryService.policyBasicQuery(claim.getPolicyCode());
			if(policyBasic != null && policyBasic.getBranchcode() != null){
				claim.setDeptid(policyBasic.getBranchcode());
				updateClaim(claim);
			}
		}
	}

	@Override
	public void updateClaim(GeClaimManagement claim) {
		super.update(claim);
	}

}
