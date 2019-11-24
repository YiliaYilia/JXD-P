package cn.com.sinosoft.web.service.facade;

import java.util.List;

import cn.com.sinosoft.domain.sale.GeneticAssays;

public interface GeneticAssaysService {

	public void saveGeneticAssays(GeneticAssays assays);
	
	public boolean GeneticAssaysCheck(String openid);
}
