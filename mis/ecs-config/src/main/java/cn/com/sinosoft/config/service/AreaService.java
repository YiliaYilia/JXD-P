package cn.com.sinosoft.config.service;

import java.util.List;

import cn.com.sinosoft.domain.system.GeArea;

/**描述：区域信息接口<br>
 * 作者：dengjiaxing <br>
 * 修改日期：2013-12-20下午08:18:39 <br>
 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
 */


public interface AreaService {
	
	/**
	 * 获取所有区域
	 */
	public List<GeArea> getGeAeraAll();
	/**
	 * 描述： 修改区域<br>
	 * 作者：dengjiaxing <br>
	 * 修改日期：2013-12-23上午11:05:04 <br>
	 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
	 * @param geResources
	 */
	public void updateGeArea(GeArea geArea);
	/**
	 * 描述： 删除区域<br>
	 * 作者：dengjiaxing <br>
	 * 修改日期：2013-12-23上午11:05:04 <br>
	 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
	 * @param geResources
	 */
	public void deleteGeArea(String pk);
	/**
	 * 描述： 查看区域是否存在<br>
	 * 作者：dengjiaxing <br>
	 * 修改日期：2013-12-23上午11:05:04 <br>
	 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
	 * @param geResources
	 */
	public boolean existGeArea(String gid);
	
	/**描述：添加区域<br>
	 * 作者：dengjiaxing <br>
	 * 修改日期：2013-12-23下午06:19:19 <br>
	 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
	 */
	public void addGeArea(GeArea geArea);
	
	/**描述：获取所有根区域<br>
	 * 作者：dengjiaxing <br>
	 * 修改日期：2013-12-25下午02:18:49 <br>
	 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
	 */
	public List<GeArea> getGeAreaRoot();
	
	/**描述：获取所有子区域<br>
	 * 作者：dengjiaxing <br>
	 * 修改日期：2013-12-25下午02:18:49 <br>
	 * E-mail:  dengjxsz0439@sinosoft.com.cn<br> 
	 */
	
	public List<GeArea> getGeAreaChild(String parentId);
	
	public GeArea getGeArea(String pk);
}