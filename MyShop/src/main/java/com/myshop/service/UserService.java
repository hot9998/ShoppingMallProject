package com.myshop.service;

import java.util.List;

import com.myshop.domain.AuthVO;
import com.myshop.domain.UserVO;

public interface UserService {
//	회원가입
//	회원리스트
//	회원정보
//	회원수정
//	회원탈퇴
//	아이디 중복 체크
	public void userJoin(UserVO user, AuthVO auth);
	public List<UserVO> userList();
	public UserVO userGet(String userid);
	public void userUpdate(UserVO user);
	public void userDelete(String userid);
	public void authDelete(String userid);
	public String userIdCheck(String userid);
}
	