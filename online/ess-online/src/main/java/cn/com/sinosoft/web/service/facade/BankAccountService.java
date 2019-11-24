package cn.com.sinosoft.web.service.facade;

import cn.com.sinosoft.domain.sale.BankAccount;

import java.util.List;

public interface BankAccountService {

    public BankAccount findBankAccountByCustomeridAndBankCode(String customerid, String bankcode);
    public boolean saveBankAccount(BankAccount bankAccount);
    public List<BankAccount> findAllBankAccount(String customerid);
}
