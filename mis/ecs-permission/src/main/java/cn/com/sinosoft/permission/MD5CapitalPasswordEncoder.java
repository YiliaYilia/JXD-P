package cn.com.sinosoft.permission;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
/**
 * 描述：MD5密码验证<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月16日下午9:02:59 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br>
 */
public class MD5CapitalPasswordEncoder extends Md5PasswordEncoder {
	public String encodePassword(String s, Object obj)
			throws DataAccessException {
		return (super.encodePassword(s, obj)).toUpperCase();
	}

	public boolean isPasswordValid(String encPass, String rawPass, Object salt)
			throws DataAccessException {
		return (super.isPasswordValid(encPass, rawPass, salt));
	}
	
}