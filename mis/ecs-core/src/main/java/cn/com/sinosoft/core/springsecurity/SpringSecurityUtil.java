package cn.com.sinosoft.core.springsecurity;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
/**
 * 描述：Springsecurity 工具类<br>
 * 作者：wanhonghui <br>
 * 修改日期：2013年8月26日下午3:41:06 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br>
 */
public class SpringSecurityUtil {
	/**
	 * 方法名称: getCurrentUser<br>
	 * 描述：获取当前用户
	 * 作者: wanhonghui
	 * 修改日期：2013年8月23日下午1:43:49
	 * @return 返回springsecurity当前用户
	 */
	public static <T extends User> T getCurrentUser() throws ClassCastException {
		Authentication authentication = getAuthentication();
		if(authentication != null){
			Object user= authentication.getPrincipal();
			return (T)user;
		}
		return null;
	}
	
	/**
	 * 方法名称: getCurrentUserName<br>
	 * 描述：获取当前用户名称
	 * 作者: wanhonghui
	 * 修改日期：2013年8月23日下午1:50:53
	 * @return 当前登陆用户名，如果不存在返回“”
	 */
	public static String getCurrentUserName(){
		Authentication authentication = getAuthentication();
		if(authentication == null || authentication.getPrincipal() == null){
			return "";
		}
		return authentication.getName();
	}
	
	/**
	 * 方法名称: getCurrentUserIp<br>
	 * 描述：获取当前用户IP
	 * 作者: wanhonghui
	 * 修改日期：2013年8月23日下午1:53:03
	 * @return Ip信息
	 */
	public static String getCurrentUserIp(){
		Authentication authentication = getAuthentication();

		if (authentication == null) {
			return "";
		}

		Object details = authentication.getDetails();
		if (!(details instanceof WebAuthenticationDetails)) {
			return "";
		}
		WebAuthenticationDetails webDetails = (WebAuthenticationDetails) details;
		return webDetails.getRemoteAddress();
	}
	
	
	/**
	 * 方法名称: hasAnyRole<br>
	 * 描述：判断用户是否拥有角色, 如果用户拥有参数中的任意一个角色则返回true.
	 * 作者: wanhonghui
	 * 修改日期：2013年8月23日下午1:54:49
	 * @param roles
	 * @return true:拥有角色  false 没有该角色
	 */
	public static boolean hasAnyRole(String... roles) {
		Authentication authentication = getAuthentication();

		if (authentication == null) {
			return false;
		}
		Collection<GrantedAuthority> grantedAuthorityList = authentication.getAuthorities();
		for (String role : roles) {
			for (GrantedAuthority authority : grantedAuthorityList) {
				if (role.equals(authority.getAuthority())) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	/**
	 * 方法名称: getAuthentication<br>
	 * 描述：获取当前认证对象
	 * 作者: wanhonghui
	 * 修改日期：2013年8月23日下午1:47:10
	 * @return 认证对象
	 */
	public static Authentication getAuthentication(){
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication= context.getAuthentication();
		return authentication;
	}

}
