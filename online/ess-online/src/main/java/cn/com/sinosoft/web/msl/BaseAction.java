package cn.com.sinosoft.web.msl;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.sinosoft.core.utils.DateUtil;
import cn.com.sinosoft.core.utils.NumberUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 任何Action 必须继承 基类.
 * 常用字段: SUCCESS, FAIL, INIT, NONE.
 * 常用属性: Map session, HttpServletRequest request, HttpServletResponse response.
 * @author CaryXu
 *
 */
public abstract class BaseAction extends ActionSupport implements SessionAware,
		ServletRequestAware,ServletResponseAware{

	protected final static String INIT = "init";
	protected final static String FAIL = "fail";
	
	protected Map session;

	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	public static Logger logger = LoggerFactory.getLogger("rootLogger");
	
	/**
	 * 随机数: 用于前端页面强制刷新
	 */
	private static long random = new Date().getTime();
	
	/**
	 * 业务处理成功: 必填,true表示业务处理正常, false表示业务处理非正常(校验不通过,异常抛出等)
	 */
	private boolean resultSuccess;
	
	/**
	 * 业务处理代码: 选填, 默认为"0000", 处理正常"1000", 处理不通过"2000", 系统异常"9000"
	 */
	private String resultCode;
	
	/**
	 * 业务处理描述: 选填, 默认空的字符串
	 */
	private String resultDescription;
	
	/**
	 * 当Action方法处理结束后, 应调用此方法, 返回业务处理结果.
	 * @param resultSuccess true表示业务处理正常, false表示业务处理非正常(校验不通过,异常抛出等)
	 */
	protected void resultBusiness(boolean resultSuccess){
		resultBusiness(resultSuccess, "0000", "");
	}
	
	/**
	 * 当Action方法处理结束后, 应调用此方法, 返回业务处理结果.
	 * @param resultSuccess true表示业务处理正常, false表示业务处理非正常(校验不通过,异常抛出等)
	 * @param resultCode 业务处理的代码,页面可根据代码显示不同的话术
	 */
	protected void resultBusiness(boolean resultSuccess, String resultCode){
		resultBusiness(resultSuccess, resultCode, "");
	}
	
	/**
	 * 当Action方法处理结束后, 应调用此方法, 返回业务处理结果.
	 * @param resultSuccess true表示业务处理正常, false表示业务处理非正常(校验不通过,异常抛出等)
	 * @param resultCode 业务处理的代码
	 * @param resultDescription 业务处理的话术
	 */
	protected void resultBusiness(boolean resultSuccess, String resultCode, String resultDescription){
		this.setResultSuccess(resultSuccess);
		this.setResultCode(resultCode);
		this.setResultDescription(resultDescription);
		processResultBusiness(resultSuccess, resultCode, resultDescription);
	}
	
	/**
	 * 子类实现此抽象方法, 若无特殊定义则留空方法.
	 * @param resultSuccess true表示业务处理正常, false表示业务处理非正常(校验不通过,异常抛出等)
	 * @param resultCode 业务处理的代码
	 * @param resultDescription 业务处理的话术
	 */
	protected abstract void processResultBusiness(boolean resultSuccess, String resultCode, String resultDescription);
	
	/**
	 *  日期格式化
	 * @return
	 */
	public String dateFormat(Date date, String format) {
		String sessionId=request.getSession().getId();
		try{
			logger.info("BaseAction.DateFormat: "+sessionId);
			return DateUtil.DateToString(date, format);
		}catch (Exception e) {
			logger.info(sessionId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
	}
	
	/**
	 *  日期格式化
	 * @return
	 */
	public String dateFormat(Date date) {
		String sessionId=request.getSession().getId();
		try{
			logger.info("BaseAction.DateFormat: "+sessionId);
			return DateUtil.DateToString(date, "yyyy-MM-dd");
		}catch (Exception e) {
			logger.info(sessionId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
	}
	
	/**
	 *  数字格式化
	 * @return
	 */
	public String numberFormat(double number, String format) {
		String sessionId=request.getSession().getId();
		try{
			logger.info("BaseAction.NumberFormat: "+sessionId);
			if(format == null)
				format = "#0";//默认整数
			if(number < 1)
				format = "#0.0";//默认一个小数位
			return NumberUtil.formatNumber(number, format);
		}catch (Exception e) {
			logger.info(sessionId+"："+e.getMessage());
			logger.error(ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			resultBusiness(false, "9000","系统异常");
			return ERROR;
		}
	}
	
	
	
	/**
	 * 方法名称: renderJson<br>
	 * 描述：返回JSON格式数据
	 * 作者: honghui
	 * 修改日期：2013年12月22日下午5:21:00
	 * @param text
	 */
	public void renderJson(String text){
		render(text,"text/json;charset=UTF-8");
	}
	
	
	/**
	 * 方法名称: render<br>
	 * 描述：返回给浏览器
	 * 作者: honghui
	 * 修改日期：2013年12月17日下午8:40:57
	 * @param text
	 * @param contentType
	 */
	public void render(String text, String contentType){
	    HttpServletResponse response;
	    try{
	      response = ServletActionContext.getResponse();
	      response.setContentType(contentType);
	      response.getWriter().write(text);
	      response.getWriter().flush();
	    } 
	    catch (IOException e) {
	      throw new IllegalStateException(e);
	    }
	}
	
	/**
	 *  数字格式化: 重载
	 * @return
	 */
	public String numberFormat(double number) {
		return numberFormat(number, null);
	}
	
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
	
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDescription() {
		return resultDescription;
	}

	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}

	public boolean getResultSuccess() {
		return resultSuccess;
	}

	public void setResultSuccess(boolean resultSuccess) {
		this.resultSuccess = resultSuccess;
	}

	public long getRandom() {
		return random;
	}

}
