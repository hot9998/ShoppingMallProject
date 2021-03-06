package com.myshop.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.myshop.domain.UserVO;

import lombok.Getter;

@Getter
public class CustomUser extends User {
	private static final long serialVersionUID = 1L;
	private UserVO user;
	public CustomUser(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}
	
	public CustomUser(UserVO user) {
		super(user.getUserid(), user.getUserpw(), user.getAuthlist().stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getUserauth())).collect(Collectors.toList()));
		this.user = user;
	}
	
	public UserVO getUser() {
		return user;
	}
	
	public void setUser(UserVO user) {
		this.user = user;
	}

}
