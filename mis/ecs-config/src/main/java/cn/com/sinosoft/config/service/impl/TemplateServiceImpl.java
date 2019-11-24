package cn.com.sinosoft.config.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.config.service.TemplateService;
import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.system.GeTemplate;

@Component
public class TemplateServiceImpl extends GenericHibernateDao<GeTemplate, String> implements TemplateService {

	/**
	 * 查询所有的系统模板
	 */
	public List<GeTemplate> findAllTemplate() {
		return super.getAll(entityClass, false);
	}

	/**
	 * 修改系统模板
	 */
	@ECSOperator(operator="修改系统模板")
	public void updateTemplate(GeTemplate geNoteTemplate) {
		super.update(geNoteTemplate);
	}

	/**
	 * 根据id查询系统模板
	 */
	public GeTemplate getGeTemplateByID(String getmpid) {
		return super.get(getmpid);
	}

	/**
	 * 根据id删除系统模板
	 */
	@ECSOperator(operator="删除系统模板")
	public void deleteTemplate(String getmpid) {
		super.deleteByPK(getmpid);
	}

	/**
	 * 添加系统模板    
	 */
	@ECSOperator(operator="添加系统模板")
	public void saveTemplate(GeTemplate geNoteTemplate) {
		super.save(geNoteTemplate);
	}

	/**
	 * 判断该系统模板是否存在
	 */
	public boolean existTemplate(String tempname,String funcode,String typecode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("tempname", tempname);
		queryRule.addEqual("functioncode", funcode);
		queryRule.addEqual("typecode", typecode);
		GeTemplate geNoteTemplate = super.findUnique(queryRule);
		return geNoteTemplate != null;
	}

	/**
	 * 分页查询模板列表（根据模板名称模糊查询）
	 */
	@SuppressWarnings("rawtypes")
	public Page findAllTemplateByTempName(int pageNo, int pageSize,
			String tempname) {
		QueryRule queryRule = QueryRule.getInstance();
		if(null != tempname && !"".equals(tempname)){
			queryRule.addLike("tempname", tempname);
		}
		queryRule.addDescOrder("createTime");
		Page page = null;
		page = super.find(queryRule, pageNo, pageSize);
		return page;
	}

	/**
	 * 根据模板名称查询模板列表
	 */
	public List<GeTemplate> findTemplateListByTempName(String tempName) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("tempname", tempName);
		return super.find(queryRule);
	}

	/**
	 * 方法名称：findTemplateByName <br>
	 * 描述：根据名称找模板 <br>
	 * 作者：liyang <br>
	 * 修改日期：2014-1-7下午07:18:11 
	 * @see cn.com.sinosoft.config.service.TemplateService#findTemplateByName(java.lang.String) 
	 * @param tempName
	 * @return
	 */
	public GeTemplate findTemplateByName(String tempName) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("tempname", tempName);
		return super.findUnique(queryRule);
	}
	

}
