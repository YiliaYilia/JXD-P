package cn.com.sinosoft.msl.model.underWriting.shortPolicy.request;
/**
 * 
 * 投保须知实体类
 * @author guilong
 *
 */
public class Agreement {
	private boolean appPrompt;//是否已阅读并理解人身保险 投保提示
	private boolean debitAuth;//是否已阅读转账授权说明书
	private boolean productSummary;//是否已阅读并理解产品说明书及条款
	
	public boolean isAppPrompt() {
		return appPrompt;
	}
	public void setAppPrompt(boolean appPrompt) {
		this.appPrompt = appPrompt;
	}
	public boolean isDebitAuth() {
		return debitAuth;
	}
	public void setDebitAuth(boolean debitAuth) {
		this.debitAuth = debitAuth;
	}
	public boolean isProductSummary() {
		return productSummary;
	}
	public void setProductSummary(boolean productSummary) {
		this.productSummary = productSummary;
	}
	
	public Agreement(boolean appPrompt,boolean debitAuth,boolean productSummary){
		super();
		this.appPrompt = appPrompt;
		this.debitAuth = debitAuth;
		this.productSummary = productSummary;
	}
	
	public Agreement() {  
        super(); 
    } 
}
