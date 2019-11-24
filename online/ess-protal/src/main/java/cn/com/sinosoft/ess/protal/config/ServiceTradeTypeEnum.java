/**
 * File Name:Constant.java
 * @Description: 
 * Copyright 2014 Sinosoft Company Ltd.
 * @author:wangpengfei
 * @version:v1.0
 * Createdate:2014-3-12上午11:15:39
 */
package cn.com.sinosoft.ess.protal.config;


/**描述：<br>
 * 作者：wangpengfei <br>
 * 修改日期：2014-3-12上午11:15:39 <br>
 * E-mail: wangpengfei14079@sinosoft.com.cn <br> 
 */
public enum ServiceTradeTypeEnum {

	TRANDATA_HEAD_FUNCFLAG_1("1","核保"),
	TRANDATA_HEAD_FUNCFLAG_2("2","签单"),
	TRANDATA_HEAD_FUNCFLAG_3("3","对账"),
	TRANDATA_HEAD_FUNCFLAG_4("4","撤单");

    private String tradeType;
    private String description; 

    ServiceTradeTypeEnum(String tradeType,String description) {
       this.tradeType = tradeType;
       this.description=description;
    }

    public String tradeType() {
		return tradeType;
	}
    public String description() {
		return description;
	}
    
    public static ServiceTradeTypeEnum getStrategy(String tradeType) {
        for(ServiceTradeTypeEnum type : ServiceTradeTypeEnum.values()) {
            if(type.tradeType().equalsIgnoreCase(tradeType)) {
                return type;
            }
        }
        return null;
    }
}
