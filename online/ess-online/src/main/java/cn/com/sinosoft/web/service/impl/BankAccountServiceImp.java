package cn.com.sinosoft.web.service.impl;

import cn.com.sinosoft.core.hibernate.GenericHibernateDao;
import cn.com.sinosoft.core.hibernate.QueryRule;
import cn.com.sinosoft.domain.sale.BankAccount;
import cn.com.sinosoft.web.service.facade.BankAccountService;

import java.util.List;

public class BankAccountServiceImp extends GenericHibernateDao<BankAccount, String> implements BankAccountService {
    @Override
    public boolean saveBankAccount(BankAccount bankAccount) {
        try{
            super.save(bankAccount);
            return true;
        }catch (Exception e){
            e.getStackTrace();
        }
        return false;
    }

    @Override
    public BankAccount findBankAccountByCustomeridAndBankCode(String customerno, String bankcode) {
        QueryRule queryRule = QueryRule.getInstance();
        queryRule.addEqual("customerno",customerno);
        queryRule.addEqual("paybankcode",bankcode);
        return findUnique(queryRule);
    }
    @Override
    public List<BankAccount> findAllBankAccount(String customerid){
        QueryRule queryRule = QueryRule.getInstance();
        queryRule.addEqual("customerno",customerid);
        return find(queryRule);
    }
}
