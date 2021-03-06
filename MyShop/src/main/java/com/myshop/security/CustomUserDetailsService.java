package com.myshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.myshop.domain.UserVO;
import com.myshop.mapper.UserMapper;

public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
//		System.out.println("username:" + username);
		UserVO user = mapper.userGet(username);
//		System.out.println("userid:" + user.getUserid());
//		System.out.println("userpw:" + user.getUserpw());
        if(user==null) {
            throw new UsernameNotFoundException(username);
        }
		return new CustomUser(user);
	}

}
