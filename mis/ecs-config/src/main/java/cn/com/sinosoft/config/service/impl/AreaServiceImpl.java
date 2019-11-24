package cn.com.sinosoft.config.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.config.service.AreaService;
import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.system.GeArea;



/**描述：区域信息接口实现类<br>
 * 作者：dengjiaxing <br>
 * 修改日期：2013-12-20下午08:20:17 <br>
 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
 */


@Component
public class AreaServiceImpl extends GenericHibernateDao<GeArea, String> implements AreaService {

	

	/**方法名称：getGeAeraAll <br>
	 * 描述：获取所有的区域 <br>
	 * 作者：dengjiaxing <br>
	 * 修改日期：2013-12-20下午08:20:17 <br>
	 * @return 返回所有区域
	 */
	public List<GeArea> getGeAeraAll() {
		// TODO Auto-generated method stub
		return this.getAll(GeArea.class,true);
	}

	/**
	 * 描述： 修改区域<br>
	 * 作者：dengjiaxing <br>
	 * 修改日期：2013-12-23上午11:05:04 <br>
	 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
	 * @param geResources
	 */
	@ECSOperator(operator=" 修改区域")
	public void updateGeArea(GeArea geArea) {
		update(geArea);
	}
	/**
	 * 描述： 删除区域<br>
	 * 作者：dengjiaxing <br>
	 * 修改日期：2013-12-23上午11:05:04 <br>
	 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
	 * @param geResources
	 */
	@ECSOperator(operator=" 删除区域")
	public void deleteGeArea(String pk) {
		deleteByPK(pk);
	}

	/**
	 * 描述： 查看区域是否存在<br>
	 * 作者：dengjiaxing <br>
	 * 修改日期：2013-12-23上午11:05:04 <br>
	 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
	 * @param geResources
	 */
	public boolean existGeArea(String gid) {
		return super.exists(gid);
	}

	/**描述：添加区域<br>
	 * 作者：dengjiaxing <br>
	 * 修改日期：2013-12-23下午06:19:19 <br>
	 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
	 */
	@ECSOperator(operator=" 添加区域")
	public void addGeArea(GeArea geArea){
		super.save(geArea);
	}
	
	/**描述：获取所有根区域<br>
	 * 作者：dengjiaxing <br>
	 * 修改日期：2013-12-25下午02:18:49 <br>
	 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
	 */
	public List<GeArea> getGeAreaRoot(){
		QueryRule queryRule = QueryRule.getInstance();
		GeArea pArea = new GeArea();
		pArea.setGid("0");
		queryRule.addEqual("parentArea",pArea);
		return find(queryRule);
	}
	
	/**描述：获取所有子区域<br>
	 * 作者：dengjiaxing <br>
	 * 修改日期：2013-12-25下午02:18:49 <br>
	 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
	 */
	
	public List<GeArea> getGeAreaChild(String parentId){
		QueryRule queryRule = QueryRule.getInstance();
		GeArea pArea = new GeArea();
		pArea.setGid(parentId);
		queryRule.addEqual("parentArea",pArea);
		queryRule.addDescOrder("createTime");
		return find(queryRule);
	}
	
	public GeArea getGeArea(String pk){
		return super.get(pk);
	}
}
