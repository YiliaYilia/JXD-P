package cn.com.sinosoft.product.service;

import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.domain.sell.RenewalBankData;

import java.util.List;

public abstract interface BankManageService {
    public Page<RenewalBankData> findAllBankData(String bankCodeID,String bankNameID,int page,int rows);
    public void saveOrUpdateBankData(RenewalBankData rbd,String type);
    public void deleteRenewalBankData(List<String> list);
    public RenewalBankData findBankDataByID(String bankID);
    public List<RenewalBankData> findAllBankData(String bankCodeID,String bankNameID,String selectedID);
    public List<RenewalBankData> findBankDataByBankCode(String bankcode);
}
