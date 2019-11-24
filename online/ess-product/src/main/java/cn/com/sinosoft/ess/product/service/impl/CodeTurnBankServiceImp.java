package cn.com.sinosoft.ess.product.service.impl;

import org.springframework.stereotype.Component;

import cn.com.sinosoft.ess.product.service.CodeTurnBankService;
@Component
public class CodeTurnBankServiceImp implements CodeTurnBankService {
	@Override
	public String codeTurnbank(String code) {
		String bank=null;
		if(code.equals("100102"))
			bank="工商银行";
		else if(code.equals("100103"))
			bank="农业银行";
		else if(code.equals("130104"))
			bank="中国银行";
		else if(code.equals("130105"))
			bank="建设银行";
		else if(code.equals("100308"))
			bank="招商银行";
		else if(code.equals("100305"))
			bank="民生银行";
		else if(code.equals("100307"))
			bank="深发/平安银行";
		else if(code.equals("100310"))
			bank="浦发银行";
		else if(code.equals("100309"))
			bank="兴业银行";
		else if(code.equals("100303"))
			bank="光大银行";
		else if(code.equals("100304"))
			bank="华夏银行";
		else if(code.equals("100306"))
			bank="广发银行";
		else if(code.equals("100302"))
			bank="中信银行";
		else if(code.equals("090004"))
			bank="中信银行信用卡";
		else if(code.equals("100403"))
			bank="邮政储蓄银行";
		return bank;
	}
}
