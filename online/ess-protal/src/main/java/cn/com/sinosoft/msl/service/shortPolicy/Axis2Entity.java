package cn.com.sinosoft.msl.service.shortPolicy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;

import cn.com.sinosoft.ess.protal.common.PortalProp;

import cn.com.sinosoft.msl.model.underWriting.shortPolicy.request.InsurancePolicy;

import com.omgd.ec.ws.Agreement;
import com.omgd.ec.ws.AppRequest;
import com.omgd.ec.ws.BankAccount;
import com.omgd.ec.ws.DoApp;
import com.omgd.ec.ws.DoAppE;
import com.omgd.ec.ws.Entry_type0;
import com.omgd.ec.ws.ExtraAttrs_type0;
import com.omgd.ec.ws.Holder;
import com.omgd.ec.ws.Insured;
import com.omgd.ec.ws.Policy;
import com.omgd.ec.ws.Product;
import com.omgd.ec.ws.TransRequHeader;

public class Axis2Entity {
	
	public static DoAppE returnEntity(InsurancePolicy ipolicy){
		DoAppE doAppE = new DoAppE();
		DoApp doApp = new DoApp();
		AppRequest appRequest = new AppRequest();
			Agreement agreement = new Agreement();
				agreement.setAppPrompt(ipolicy.getAgreement().isAppPrompt());
				agreement.setDebitAuth(false);
				agreement.setProductSummary(ipolicy.getAgreement().isProductSummary());
			appRequest.setAgreement(agreement);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(ipolicy.getHeader().getTransDate());
			System.out.println("交易日期：  "+calendar.getTime());
			TransRequHeader header = new TransRequHeader();
				header.setChannelId(PortalProp.getString("shortPolicyChannelId"));
				header.setTransDate(calendar);
				header.setTransNo(ipolicy.getHeader().getTransNo());
			Holder holder = new Holder();
			OMFactory fac = OMAbstractFactory.getOMFactory();
			OMNamespace omNs = fac.createOMNamespace("" , "" );
             //调用服务端的方法
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 
			Calendar calendarR = Calendar.getInstance();
			calendarR.setTime(ipolicy.getHolder().getBirthday());
				
				holder.setEmail(ipolicy.getHolder().getEmail());//测试新加的
				
				holder.setBirthday(calendarR);
				holder.setGender(ipolicy.getHolder().getGender());
				holder.setIdNo(ipolicy.getHolder().getIdNo());
				holder.setIdType(ipolicy.getHolder().getIdType()==null?"":ipolicy.getHolder().getIdType());
				holder.setMobile(ipolicy.getHolder().getMobile()==null?"":ipolicy.getHolder().getMobile());
				holder.setName(ipolicy.getHolder().getName()==null?"":ipolicy.getHolder().getName());
				holder.setOccupationCode(ipolicy.getHolder().getOccupationCode()==null?"":ipolicy.getHolder().getOccupationCode());
				holder.setProvince(ipolicy.getHolder().getProvinceId()==null?"":ipolicy.getHolder().getProvinceId());
				String provinceId = ipolicy.getHolder().getProvinceId();
				holder.setRelationWithInsured(ipolicy.getHolder().getRelationWithInsured()==null?"":ipolicy.getHolder().getRelationWithInsured());
				holder.setWorkType(ipolicy.getHolder().getWorkType()==null?"":ipolicy.getHolder().getWorkType());
			appRequest.setHolder(holder);
			
			Product product = new Product();
					
				product.setAutoRenewInd(false);
				product.setBillingAmt(Double.parseDouble(ipolicy.getProduct().getBillingAmt()==null?"":ipolicy.getProduct().getBillingAmt()));
				product.setCode(ipolicy.getProduct().getCode()==null?"":ipolicy.getProduct().getCode());
				product.setName(ipolicy.getProduct().getName()==null?"":ipolicy.getProduct().getName());
				
				Calendar calendarE = Calendar.getInstance();
				calendarE.setTime(ipolicy.getProduct().getEffDate());
				System.out.println("生效日期：  "+calendarE.getTime());
				product.setEffDate(calendarE);
				product.setPeriod(ipolicy.getProduct().getPeriod());
					Policy[] policyArry = new Policy[1];
					Policy policy = new Policy();
						policy.setCode(ipolicy.getProduct().getPolicyList().get(0).getCode());//"BPA-PT"
						policy.setEffDate(calendarE);
						policy.setName("轮船及运营汽车意外身故与残疾");//暂时写死（接口文档未定义，接口调试需要）
						
						ExtraAttrs_type0 extraAttrs_type0 = new ExtraAttrs_type0();
						Entry_type0 entry = new Entry_type0();
						
						entry.setKey(ipolicy.getExtraAttrs().getEntry().get(0).getKey());//"unit"
						entry.setValue(ipolicy.getExtraAttrs().getEntry().get(0).getValue());//份数
						Entry_type0[] entryArry = {
								entry
						};
						extraAttrs_type0.setEntry(entryArry);
						policy.setExtraAttrs(extraAttrs_type0);
						
						policy.setPeriod(ipolicy.getProduct().getPeriod());
						policy.setPeriodUnit(ipolicy.getProduct().getPeriodUnit());
						policy.setPremTerm(Integer.parseInt(ipolicy.getProduct().getPremTerm()));
						policy.setPremType(ipolicy.getProduct().getPremType());
						policy.setPremium(ipolicy.getProduct().getPremium());
						policy.setSumins(ipolicy.getProduct().getSumins());
						policyArry[0] = policy;
				product.setPolicy(policyArry);
				product.setPeriodUnit(ipolicy.getProduct().getPeriodUnit());
				product.setPremTerm(ipolicy.getProduct().getPremTerm());
				product.setPremType(ipolicy.getProduct().getPremType());
				product.setPremium(ipolicy.getProduct().getPremium());
				product.setSumins(ipolicy.getProduct().getSumins());
				
				BankAccount bankAccount = new BankAccount();
				bankAccount.setAcctName(ipolicy.getHolder().getName()==null?"":ipolicy.getHolder().getName());
				bankAccount.setAcctNo("NA");
				bankAccount.setBankCode("080012");
				
				appRequest.setAgreement(agreement);
				appRequest.setHeader(header);
				appRequest.setHolder(holder);
				appRequest.setProduct(product);
				appRequest.setBankAccount(bankAccount);
			doApp.setRequest(appRequest);
		doAppE.setDoApp(doApp);
		return doAppE;
	}

}
