package cn.com.sinosoft.config.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.system.GeTemplate;

public interface TemplateService {
	/**
	 * 方法名称: 查找所有系统模板<br>
	 * 描述：
	 * 作者: yangqidu
	 * 修改日期：2013-12-19下午07:25:38
	 * @return
	 */
	public List<GeTemplate> findAllTemplate();
	/**
	 * 方法名称:修改系统模板<br>
	 * 描述：
	 * 作者: yangqidu
	 * 修改日期：2013-12-19下午07:25:38
	 * @return
	 */
	public void updateTemplate(GeTemplate geNoteTemplate);
	/**
	 * 方法名称: 根据id获得单个的系统模板<br>
	 * 描述：
	 * 作者: yangqidu
	 * 修改日期：2013-12-19下午07:25:38
	 * @return
	 */
	public GeTemplate getGeTemplateByID(String getmpid);
	/**
	 * 方法名称: 删除系统模板<br>
	 * 描述：
	 * 作者: yangqidu
	 * 修改日期：2013-12-19下午07:25:38
	 * @return
	 */
	public void deleteTemplate(String getmpid);
	/**
	 * 方法名称: 判断系统模板是否存在<br>
	 * 描述：
	 * 作者: yangqidu
	 * 修改日期：2013-12-19下午07:25:38
	 * @return 存在：true   不存在：false
	 */
	public boolean existTemplate(String tempname,String funcode,String typecode);
	/**
	 * 方法名称: 保存系统模板<br>
	 * 描述：
	 * 作者: yangqidu
	 * 修改日期：2013-12-19下午07:25:38
	 * @return
	 */
	public void saveTemplate(GeTemplate geTemplate);
	/**
	 * 方法名称: 根据模板名称分页模糊查询系统模板（模板名称允许为空）<br>
	 * 描述：
	 * 作者: yangqidu
	 * 修改日期：2013-12-19下午07:25:38
	 * @return
	 */
	public Page findAllTemplateByTempName(int pageNo, int pageSize,String tempname);
	/**
	 * 方法名称: 根据模板名称查询所有的系统模板<br>
	 * 描述：
	 * 作者: yangqidu
	 * 修改日期：2013-12-19下午07:25:38
	 * @return
	 */
	public List<GeTemplate> findTemplateListByTempName(String tempName);
	
	/**
	 * 方法名称: findTemplateByName<br>
	 * 描述：通过名字找模板
	 * 作者: liyang
	 * 修改日期：2014-1-7下午07:16:47
	 * @param tempName
	 * @return
	 */
	public GeTemplate findTemplateByName(String tempName);
}
