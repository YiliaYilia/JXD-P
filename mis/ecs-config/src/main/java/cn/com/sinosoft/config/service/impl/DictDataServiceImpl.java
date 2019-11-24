package cn.com.sinosoft.config.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.config.service.DictDataService;
import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.system.GeDictData;

/**
 * 描述：字典数据业务处理实现类<br>
 * 作者：liyang <br>
 * 修改日期：2013-12-19上午11:26:10 <br>
 * E-mail: liyang12087@sinosoft.com.cn <br>
 */
@Component
public class DictDataServiceImpl  extends GenericHibernateDao<GeDictData, String> implements DictDataService {
	/**
	 * 方法名称：查找所有字典数据 <br>
	 * 描述： <br>
	 * 作者：liyang <br>
	 * 修改日期：2013-12-19上午11:26:35 
	 * @see cn.com.sinosoft.config.service.DictDataService#findAllDictData() 
	 * @return
	 */
	public Page findAllDictData(int page,int rows) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addIsNotNull("dictdataid");
		queryRule.addDescOrder("geDictType.dicttypeid");
		queryRule.addDescOrder("createtime");
		return this.find(queryRule, page, rows);
	}

	/**
	 * 方法名称：保存数据字典 <br>
	 * 描述： <br>
	 * 作者：liyang <br>
	 * 修改日期：2013-12-19下午07:26:38 
	 * @see cn.com.sinosoft.config.service.DictDataService#saveDictData(cn.com.sinosoft.domain.system.GeDictData) 
	 * @param geDictData
	 */
	@ECSOperator(operator="保存或更新字典")
	public void saveOrUpdateDictData(GeDictData geDictData,String type) {
		if("update".equals(type)){
			super.update(geDictData);
		}else {
			super.save(geDictData);
		}
	}

	/**
	 * 方法名称：通过Id批量删除数据字典 <br>
	 * 描述： <br>
	 * 作者：liyang <br>
	 * 修改日期：2013-12-19下午08:39:55 
	 * @see cn.com.sinosoft.config.service.DictDataService#deleteDictDatas(java.util.List) 
	 * @param ids
	 */
	@ECSOperator(operator="删除数据字典")
	public void deleteDictDatas(List<String> ids) {
		
		List<GeDictData> dictDatas = new ArrayList<GeDictData>();
		for(String id:ids){
			dictDatas.add(super.get(id));
		}
		super.deleteAll(dictDatas);
	}

	/**
	 * 方法名称：findDictDataByID <br>
	 * 描述：通过ID查找数据字典 <br>
	 * 作者：liyang <br>
	 * 修改日期：2013-12-20上午10:11:34 
	 * @see cn.com.sinosoft.config.service.DictDataService#findDictDataByID(java.lang.String) 
	 * @param id
	 * @return
	 */
	public GeDictData findDictDataByID(String id) {

		return super.get(id);
	}

	/**
	 * 方法名称：findDictDataByTypeID <br>
	 * 描述： 通过类型ID找字典<br>
	 * 作者：liyang <br>
	 * 修改日期：2013-12-20下午05:01:55 
	 * @see cn.com.sinosoft.config.service.DictDataService#findDictDataByTypeID(java.lang.String) 
	 * @param ID
	 * @return
	 */
	public Page<GeDictData> findDictDataByTypeID(String ID,int page,int rows) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("geDictType.dicttypeid", ID);
		queryRule.addDescOrder("geDictType.dicttypeid");
		queryRule.addDescOrder("createtime");
		return super.find(queryRule,page,rows);
	}

	/**
	 * 方法名称：ifExistByTypeAndDataCode <br>
	 * 描述： 类型ID下字典名称是否存在<br>
	 * 作者：liyang <br>
	 * 修改日期：2013-12-24下午02:27:11 
	 * @see cn.com.sinosoft.config.service.DictDataService#ifExistDictDataByTypeAndDataName(java.lang.String, java.lang.String) 
	 * @param dictTypeID
	 * @param dictDataName
	 * @return
	 */
	public boolean ifExistByTypeAndDataCode(String dictTypeID,
			String dictDataCode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("geDictType.dicttypeid", dictTypeID);
		queryRule.addEqual("dictdatacode", dictDataCode);
		
		List<GeDictData> list = super.find(queryRule);
		
		return list.size()!=0;
	}
	

	public GeDictData findDictDataByDictDataCode(String dictDataCode) {
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("dictdatacode", dictDataCode);
		return super.findUnique(queryRule);
	}
	
	/**
	 * 方法名称：findDictNameByCode <br>
	 * 描述： 通过code找字典<br>
	 * 作者：liyang <br>
	 * 修改日期：2013-12-25下午08:40:25 
	 * @see cn.com.sinosoft.config.service.DictDataService#findDictValueByName(java.lang.String) 
	 * @param dictCode
	 * @return
	 */
	public GeDictData findDictByCode(String dictCode,String dictTypeID){
		
		QueryRule queryRule = QueryRule.getInstance();
		queryRule.addEqual("dictdatacode", dictCode);
		queryRule.addEqual("geDictType.dicttypeid", dictTypeID);
		return findUnique(queryRule);
	}
	
	
}






