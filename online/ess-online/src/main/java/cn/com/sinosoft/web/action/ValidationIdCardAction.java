package cn.com.sinosoft.web.action;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import cn.com.sinosoft.web.msl.BaseAction;
/**
 * 校验身份证格式
 * 出生日期与身份证是否相符
 * 性别与身份证是否相符
 */
import cn.com.sinosoft.web.util.IdNumberValidator;
@ParentPackage(value = "ECS-STRUTS")
public class ValidationIdCardAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	
	
//	private String resultFlag="0";
	/**
	 * 校验身份证格式
	 * @param idType : 证件类型
	 * @param idNum ：证件号码
	 * @return true : 身份证格式正确; false : 身份证格式错误
	 */
	@Action(value="validationIdCard")
	public void validationIdCard() {
		String idNum=request.getParameter("idNum");
		if(IdNumberValidator.verify(idNum)){
			renderJson("{\"resultFlag\":\"1\"}");
			return;
		}
		renderJson("{\"resultFlag\":\"0\"}");
	}
	
	/**
	 * 校验性别是否与身份证相符
	 * @param idNum ：证件号码
	 * @param sex ：性别 M or  F
	 * @return true : 性别与身份证记录性别匹配; false : 性别与身份证记录性别不匹配
	 */
	@Action(value="validationIdCardGender")
	public void validationIdCardGender() {
		String idNum=request.getParameter("idNum");
		String sex=request.getParameter("sex");
		if(IdNumberValidator.verify("SHENFEN_CARD",idNum, sex)){
			renderJson("{\"resultFlag\":\"1\"}");
			return ;
		}
		renderJson("{\"resultFlag\":\"0\"}");
		
	}
	
	
	/**
	 * 校验出生日期是否与身份证相符
	 * @param idNum ：证件号码
	 * @param birthDate ：生日
	 * @return true : 生日与身份证记录性别匹配; false : 生日与身份证记录性别不匹配
	 * @throws ParseException 
	 */
	@Action(value="validationIdCardBirthDate")
	public void validationIdCardBirthDate(){
		try{
			String idNum=request.getParameter("idNum");
			String birthDateStr=request.getParameter("birthDate");
			DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
			Date birthDate=null;
			if(birthDateStr!=null && !birthDateStr.equals("")){
				birthDate=fmt.parse(birthDateStr);
			}
			if(IdNumberValidator.verify(idNum, birthDate)){
				renderJson("{\"resultFlag\":\"1\"}");
				return;
			}
			renderJson("{\"resultFlag\":\"0\"}");
		}catch(Exception e){
			e.printStackTrace();
			renderJson("{\"resultFlag\":\"0\"}");
		}
		
	}
	@Action(value="getBirthDateByIdCard")
	public void getBirthDateByIdCard(){
		DateFormat fmt =new SimpleDateFormat("yyyy年MM月dd日");
		try{
			String idNumber=request.getParameter("idNum");
			Date birthDate=IdNumberValidator.idNumber2BirthDate(idNumber);
			//日期格式化 xxx年xx月xx日
			renderJson("{\"resultFlag\":\"1\",\"birthDateStr\":\""+fmt.format(birthDate)+"\"}");
			return;
		}catch(Exception e){
			e.printStackTrace();
			renderJson("{\"resultFlag\":\"0\",\"birthDateStr\":\""+fmt.format(new Date())+"\"}");
		}
		
	}
	
	
	@Override
	protected void processResultBusiness(boolean resultSuccess, String resultCode, String resultDescription) {
		// TODO Auto-generated method stub
		
	}

	
}
