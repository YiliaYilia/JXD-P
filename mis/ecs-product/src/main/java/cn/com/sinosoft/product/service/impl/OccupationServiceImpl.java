package cn.com.sinosoft.product.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.product.GeOccupation;
import cn.com.sinosoft.domain.product.GeProInsuredOccupation;
import cn.com.sinosoft.dto.product.OccupationTree;
import cn.com.sinosoft.product.service.OccupationService;
import cn.com.sinosoft.product.service.ProInsuredOccupationService;

@Component
public class OccupationServiceImpl extends GenericHibernateDao<GeOccupation, String>  implements OccupationService {
	@Autowired
	private ProInsuredOccupationService proInsuredOccupationService; 
	
	
	
	/**
	 * 方法名称: findOccupationTree<br>
	 * 描述：根据被保人配置序号 查询 职业树
	 * 作者: lihengjun
	 * 修改日期：2014年1月13日下午1:58:55
	 * @param insuredconfigno
	 * @return
	 */
	public List<OccupationTree> findOccupationTree(String insuredconfigno) {
		List<GeProInsuredOccupation> geProInsuredOccupations = proInsuredOccupationService.findByInsuredConfigno(insuredconfigno);
		List<OccupationTree> occupationTrees = new ArrayList<OccupationTree>();
		List<GeOccupation> geOccupations = this.getAll();
		for (GeOccupation geOccupation : geOccupations) {
			OccupationTree tree = new OccupationTree();
			tree.setId(geOccupation.getOccupationcode());
			tree.setParentId("0".equals(geOccupation.getPoccupationcode())?"":geOccupation.getPoccupationcode());
			tree.setText(geOccupation.getOccupationname());
			if(this.checkExists(geOccupation, geProInsuredOccupations)){
				tree.setChecked(true);
			}else{
				tree.setChecked(false);
			}
			occupationTrees.add(tree);
		}
		return occupationTrees;
	}
	
	private boolean checkExists(GeOccupation geOccupation,List<GeProInsuredOccupation> geProInsuredOccupations){
		for (int i = 0;geProInsuredOccupations!=null && i < geProInsuredOccupations.size(); i++) {
			GeProInsuredOccupation insOcc = geProInsuredOccupations.get(i);
			if(geOccupation.getOccupationcode().equals(insOcc.getOccupationcode())){
				geProInsuredOccupations.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public List<GeOccupation> findByQuery(QueryRule Query) {
		return super.find(Query);
	}
	
	public GeOccupation findUnique(QueryRule queryRule) {
		return super.findUnique(queryRule);
	}
	
	public List<GeOccupation> getAll() {
		return super.getAll(entityClass);
	}

	public void add(GeOccupation geOccupation) {
		super.save(geOccupation);
	}

	public void update(GeOccupation geOccupation) {
		super.update(geOccupation);
	}

	public GeOccupation get(String pk) {
		return this.get(pk);
	}

	public void delete(GeOccupation geOccupation) {
		super.delete(geOccupation);
	}

	
	
}
