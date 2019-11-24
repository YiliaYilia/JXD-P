/**
 * File Name:ECSUser.java
 * @Description: 
 * Copyright 2013 China Life Insurance Company Ltd.
 * @author:honghui
 * @version:v1.0
 * Createdate:2013年12月16日下午8:57:57
 */
package cn.com.sinosoft.dto.system;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import cn.com.sinosoft.domain.system.GeUser;

/**描述：ECS系统用户<br>
 * 作者：honghui <br>
 * 修改日期：2013年12月16日下午8:57:57 <br>
 * E-mail: wanhonghui@sinosoft.com.cn <br> 
 */
public class ECSUser extends User {
	private GeUser geUser;
	/**
	 * @param username
	 * @param password
	 * @param enabled
	 * @param accountNonExpired
	 * @param credentialsNonExpired
	 * @param accountNonLocked
	 * @param authorities
	 */
	public ECSUser(GeUser geUser,String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		this.geUser = geUser;
	}
	
	public GeUser getGeUser() {
		return geUser;
	}
	public void setGeUser(GeUser geUser) {
		this.geUser = geUser;
	}
	
	
}
