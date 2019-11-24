package cn.com.sinosoft.config.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.config.service.DictTypeService;
import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.system.GeDictType;

@Component
public class DictTypeServiceImpl extends GenericHibernateDao<GeDictType, String> implements DictTypeService {
	/**
	 * 方法名称：查找所有类型 <br>
	 * 描述： <br>
	 * 作者：liyang <br>
	 * 修改日期：2013-12-19下午05:59:31 
	 * @see cn.com.sinosoft.config.service.DictTypeService#findAllDictType() 
	 * @return
	 */
	public List<GeDictType> findAllDictType() {
		
		
		return this.getAll(entityClass, false);
	}

	
	/**
	 * 方法名称：通过id获取字典类型 <br>
	 * 描述： <br>
	 * 作者：liyang <br>
	 * 修改日期：2013-12-19下午07:31:39 
	 * @see cn.com.sinosoft.config.service.DictTypeService#findDictTypeById(java.lang.String) 
	 * @param id
	 * @return
	 */
	public GeDictType findDictTypeById(String id) {

		return this.get(id);
		
	}


	/**
	 * 方法名称：findAllDictType <br>
	 * 描述：分页查找字典类型 <br>
	 * 作者：liyang <br>
	 * 修改日期：2013-12-23下午02:30:39 
	 * @see cn.com.sinosoft.config.service.DictTypeService#findAllDictType(java.util.Map) 
	 * @param page
	 * @return
	 */
	public Page<GeDictType> findAllDictType(int page,int rows) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addDescOrder("createtime");
		return this.find(queryRule, page,rows);
	}
	/**
	 * 方法名称：saveOrUpadteDictType <br>
	 * 描述： 保存或更新数据字典类型<br>
	 * 作者：liyang <br>
	 * 修改日期：2013-12-23下午04:55:54 
	 * @see cn.com.sinosoft.config.service.DictTypeService#saveOrUpadteDictType(cn.com.sinosoft.domain.system.GeDictType, java.lang.String) 
	 * @param dictType
	 * @param type
	 */
	@ECSOperator(operator="保存或更新数据字典类型")
	public void saveOrUpadteDictType(GeDictType dictType, String type) {
		if("update".equals(type)){
			super.update(dictType);
		}else {
			super.save(dictType);
		}
		
	}


	/**
	 * 方法名称：deleteDictTypeDatas <br>
	 * 描述： 批量删除<br>
	 * 作者：liyang <br>
	 * 修改日期：2013-12-23下午06:02:18 
	 * @see cn.com.sinosoft.config.service.DictTypeService#deleteDictTypeDatas(java.util.List) 
	 * @param ids
	 */
	@ECSOperator(operator="删除数据字典类型")
	public void deleteDictTypeDatas(List<String> ids) {
		List<GeDictType> dictTypes = new ArrayList<GeDictType>();
		for(String id:ids){
			dictTypes.add(super.get(id));
		}
		super.deleteAll(dictTypes);
	}


	/**
	 * 方法名称：findDictTypeByTypeName <br>
	 * 描述： <br>
	 * 作者：liyang <br>
	 * 修改日期：2013-12-23下午06:37:48 
	 * @see cn.com.sinosoft.config.service.DictTypeService#findDictTypeByTypeName(java.util.Map, java.lang.String) 
	 * @param page
	 * @param typeName
	 * @return
	 */
	public Page<GeDictType> findDictTypeByTypeName(String typeName,int page,int rows) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addLike("dicttypename", "%"+typeName+"%");
		queryRule.addDescOrder("createtime");
		return super.find(queryRule,page,rows);
	}

	/**方法名称：findDictTypeByName <br>
	 * 描述：通过字典代码获取类型 <br>
	 * 作者：honghui <br>
	 * 修改日期：2013年12月24日下午7:09:51 
	 * @see cn.com.sinosoft.config.service.DictTypeService#findDictTypeByName(java.lang.String) 
	 * @param typeName
	 * @return
	 */
	public GeDictType findDictTypeByCode(String typeCode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("dicttypecode", typeCode);
		return findUnique(queryRule);
	}
	/**
	 * 方法名称：ifExistDictType <br>
	 * 描述： 类型代码是否存在<br>
	 * 作者：liyang <br>
	 * 修改日期：2013-12-24下午05:34:35 
	 * @see cn.com.sinosoft.config.service.DictTypeService#ifExistDictType(java.lang.String) 
	 * @param dictTypeName
	 * @return
	 */
	public boolean ifExistDictType(String dictTypeCode) {
		
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("dicttypecode", dictTypeCode);
		List<GeDictType> list = super.find(queryRule);
		return list.size()!=0;
	}
	
	
	/**
	 * 方法名称：findTypeByCode <br>
	 * 描述：通过code找type <br>
	 * 作者：liyang <br>
	 * 修改日期：2013-12-25下午09:06:08 
	 * @see cn.com.sinosoft.config.service.DictTypeService#findTypeByCode(java.lang.String) 
	 * @param typeCode
	 * @return
	 */
	public GeDictType findTypeByCode(String typeCode){
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("dicttypecode", typeCode);
		return super.findUnique(queryRule);
	}
}
