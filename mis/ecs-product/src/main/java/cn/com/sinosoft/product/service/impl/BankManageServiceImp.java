package cn.com.sinosoft.product.service.impl;

import cn.com.sinosoft.core.annotation.ECSOperator;
import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.Page;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.core.utils.StringUtils;
import cn.com.sinosoft.domain.sell.RenewalBankData;
import cn.com.sinosoft.product.service.BankManageService;
import org.hibernate.FlushMode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Transactional
public class BankManageServiceImp extends GenericHibernateDao<RenewalBankData, String> implements BankManageService {
    @Override
    public Page<RenewalBankData> findAllBankData(String bankCodeID, String bankNameID, int page, int rows) {
        QueryRule queryRule = QueryRule.getInstance();
        if(!StringUtils.isEmpty(bankCodeID)){
            queryRule.addLike("bankcode", "%"+bankCodeID+"%");
        }
        if(!StringUtils.isEmpty(bankNameID)){
            queryRule.addLike("bankname", "%"+bankNameID+"%");
        }
        queryRule.addAscOrder("bankcode");
        return this.find(queryRule, page, rows);
    }

    @Override
    public void saveOrUpdateBankData(RenewalBankData renewalBankData, String type) {
        if("update".equals(type)){
            super.update(renewalBankData);
        }else {
            super.save(renewalBankData);
        }
    }

    @Override
    public void deleteRenewalBankData(List<String> list) {
        //super.getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        List<RenewalBankData> bankDatas = new ArrayList<RenewalBankData>();
        for(String id:list){
            //bankDatas.add(findBankData(id));
            bankDatas.add(super.get(id));
        }
        super.deleteAll(bankDatas);
    }

    @Override
    public RenewalBankData findBankDataByID(String bankID) {
        return super.get(bankID);
    }


    @Override
    public List<RenewalBankData> findAllBankData(String bankCodeID, String bankNameID,String selecteds) {
        QueryRule queryRule = QueryRule.getInstance();
        if(!StringUtils.isEmpty(bankCodeID)){
            queryRule.addLike("bankcode", "%"+bankCodeID+"%");
        }
        if(!StringUtils.isEmpty(bankNameID)){
            queryRule.addLike("bankname", "%"+bankNameID+"%");
        }
        List<RenewalBankData> bankData = super.find(queryRule);
        List<RenewalBankData> banks = new ArrayList<RenewalBankData>();
//        List<String> ids = Arrays.asList(selecteds.split(","));
        if(bankData.size()>0){
            if(!StringUtils.isEmpty(selecteds)){
                List<String> ids = Arrays.asList(selecteds.split(","));
                for (String ID:ids) {
                    for (RenewalBankData rbd:bankData) {
                        if(rbd.getBankID().equals(ID)){
                            banks.add(rbd);
                        }
                    }
                }
                return banks;
            }else{
                return bankData;
            }
        }else{
            return null;
        }
    }

    @Override
    public List<RenewalBankData> findBankDataByBankCode(String bankcode) {
        QueryRule queryRule = QueryRule.getInstance();
        queryRule.addEqual("bankcode",bankcode);
        return find(queryRule);
    }


}
