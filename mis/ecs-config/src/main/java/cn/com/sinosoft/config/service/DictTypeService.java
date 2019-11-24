package cn.com.sinosoft.config.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.system.GeDictType;

/**
 * 描述：字典类型管理业务处理接口<br>
 * 作者：liyang <br>
 * 修改日期：2013-12-19上午11:23:59 <br>
 * E-mail: liyang12087@sinosoft.com.cn <br>
 */
public interface DictTypeService {

	/**
	 * 方法名称: 获取所有字典类型<br>
	 * 描述：
	 * 作者: liyang
	 * 修改日期：2013-12-19下午07:30:53
	 * @return
	 */
	public List<GeDictType> findAllDictType();
	
	/**
	 * 方法名称: findAllDictType<br>
	 * 描述：分页查询所有字典类型
	 * 作者: liyang
	 * 修改日期：2013-12-23下午02:25:09
	 * @param page
	 * @return
	 */
	public Page<GeDictType> findAllDictType(int page,int rows);
	
	/**
	 * 方法名称: 通过id获取字典类型对象<br>
	 * 描述：
	 * 作者: liyang
	 * 修改日期：2013-12-19下午07:31:19
	 * @param id
	 * @return
	 */
	public GeDictType findDictTypeById(String id);
	
	/**
	 * 方法名称: findDictTypeByName<br>
	 * 描述：通过字典名称获取类型
	 * 作者: honghui
	 * 修改日期：2013年12月24日下午7:09:19
	 * @param typeName
	 * @return
	 */
	public GeDictType findDictTypeByCode(String typeCode);
	
	
	/**
	 * 方法名称: saveOrUpadteDictType<br>
	 * 描述：保存或更新数据字典
	 * 作者: liyang
	 * 修改日期：2013-12-23下午04:55:15
	 * @param dictType
	 * @param type
	 */
	public void saveOrUpadteDictType(GeDictType dictType,String type);
	
	/**
	 * 方法名称: deleteDictTypeDatas<br>
	 * 描述：批量删除
	 * 作者: liyang
	 * 修改日期：2013-12-23下午06:01:31
	 * @param ids
	 */
	public void deleteDictTypeDatas(List<String> ids);
	
	/**
	 * 方法名称: findDictTypeByDictTypeCode<br>
	 * 描述：通过名称找类型
	 * 作者: liyang
	 * 修改日期：2013-12-23下午06:36:11
	 * @return
	 */
	public Page<GeDictType> findDictTypeByTypeName(String typeName,int page,int rows);
	
	/**
	 * 方法名称: ifExistDictType<br>
	 * 描述：类型代码是否重复
	 * 作者: liyang
	 * 修改日期：2013-12-24下午05:33:41
	 * @param dictTypeName
	 * @return
	 */
	public boolean ifExistDictType(String dictTypeCode);
	
	
	/**
	 * 方法名称: findTypeByCode<br>
	 * 描述：通过code找type
	 * 作者: liyang
	 * 修改日期：2013-12-25下午09:03:20
	 * @param typeCode
	 * @return
	 */
	public GeDictType findTypeByCode(String typeCode);
}
