package cn.com.sinosoft.product.service;

import java.util.List;
import cn.com.sinosoft.domain.product.GeProductAttribute;
import cn.com.sinosoft.domain.system.GeArea;
public interface ProductAttributeService {
	/**
	 * 方法名称: getGeProductAttributeAll<br>
	 * 描述：获取所有的产品属性
	 * 作者: liaojiping
	 * 修改日期：2014-1-2下午02:20:18
	 * @return
	 */
	public List<GeProductAttribute> getGeProductAttributeAll();
	
	/**
	 * 方法名称: existGeProductAttr<br>
	 * 描述:查看是否存在产品属性
	 * 作者: liaojiping
	 * 修改日期：2014-1-3下午12:03:02
	 * @param productAttrId
	 * @return
	 */
	public boolean existGeProductAttr(String productAttrId);
	
	/**
	 * 方法名称: addGeProductAttr<br>
	 * 描述：添加产品属性对象
	 * 作者: liaojiping
	 * 修改日期：2014-1-3下午01:56:57
	 * @param geProductAttr
	 */
	public void addGeProductAttr(GeProductAttribute geProductAttr);
	
	/**
	 * 方法名称: updateGeProductAttr<br>
	 * 描述：更新产品属性信息
	 * 作者: liaojiping
	 * 修改日期：2014-1-3下午05:13:24
	 * @param geProductAttr
	 */
	public void updateGeProductAttr(GeProductAttribute geProductAttr);
	
	/**
	 * 方法名称: getGeProductAttrChild<br>
	 * 描述：获取产品属性的子节点
	 * 作者: user
	 * 修改日期：2014-1-3下午05:14:24
	 * @param parentId
	 * @return
	 */
	public List<GeProductAttribute> getGeProductAttrChild(String parentId);
	
	/**
	 * 方法名称: deleteGeProductAttr<br>
	 * 描述：删除产品属性
	 * 作者: liaojiping
	 * 修改日期：2014-1-3下午05:24:05
	 * @param pk
	 */
	public void deleteGeProductAttr(String pk);
	
}
