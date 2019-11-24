package cn.com.sinosoft.config.service;

import java.util.List;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.system.GeDictData;

/**
 * 描述：字典数据管理业务处理接口<br>
 * 作者：liyang <br>
 * 修改日期：2013-12-19上午11:23:59 <br>
 * E-mail: liyang12087@sinosoft.com.cn <br>
 */
public interface DictDataService {

	/**
	 * 方法名称: 查找所有字典数据<br>
	 * 描述：
	 * 作者: liyang
	 * 修改日期：2013-12-19下午07:25:38
	 * @return
	 */
	public Page<GeDictData> findAllDictData(int page,int rows);
	
	/**
	 * 方法名称: 保存数据字典<br>
	 * 描述：
	 * 作者: liyang
	 * 修改日期：2013-12-19下午07:26:48
	 * @param geDictData
	 */
	public void saveOrUpdateDictData(GeDictData geDictData,String type);
	
	/**
	 * 方法名称: 通过id批量删除数据字典<br>
	 * 描述：
	 * 作者: liyang
	 * 修改日期：2013-12-19下午08:38:21
	 * @param dictIds
	 */
	public void deleteDictDatas(List<String> ids);
	
	/**
	 * 方法名称: findDictDataByID<br>
	 * 描述：通过ID查找数据字典
	 * 作者: liyang
	 * 修改日期：2013-12-20上午10:11:10
	 * @param id
	 * @return
	 */
	public GeDictData findDictDataByID(String id);
	
	/**
	 * 方法名称: findDictDataByTypeID<br>
	 * 描述：根据类型ID找数据字典
	 * 作者: liyang
	 * 修改日期：2013-12-20下午04:58:03
	 * @param ID
	 * @return
	 */
	public Page<GeDictData> findDictDataByTypeID(String ID,int page,int rows);
	
	
	/**
	 * 方法名称: ifExistByTypeAndDataCode<br>
	 * 描述：类型ID下字典代码是否存在
	 * 作者: liyang
	 * 修改日期：2013-12-24下午02:26:45
	 * @param dictTypeID
	 * @param dictDataName
	 * @return
	 */
	public boolean ifExistByTypeAndDataCode(String dictTypeID,String dictDataCode);

	
	/**
	 * 方法名称: findDictNameByCode<br>
	 * 描述：code找name
	 * 作者: liyang
	 * 修改日期：2013-12-25下午08:37:47
	 * @param dictCode
	 * @return
	 */
	public GeDictData findDictByCode(String dictCode,String dictTypeID);

	
	/**
	 * 方法名称: findDictDataByDictDataCode<br>
	 * 描述: 根据名称找数据字典
	 * 作者: liyang
	 * 修改日期：2013-12-24下午02:26:45
	 * @param dictTypeID
	 * @param dictDataName
	 * @return
	 */
	public GeDictData findDictDataByDictDataCode(String dictDataCode);
	

}












