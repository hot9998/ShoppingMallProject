package com.myshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myshop.domain.UserVO;
import com.myshop.service.UserService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	@Autowired
	UserService service;

//	包府磊 雀盔包府
	@GetMapping("/list")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String list(Model model) {
		List<UserVO> user = service.userList();
		model.addAttribute("user", user);
		return "/user/list";
	}

//	包府磊 雀盔昏力	
	@GetMapping("/delete")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String delete(@ModelAttribute("userid") String userid) {
		service.userDelete(userid);
		return "redirect:/admin/list";
	}

}
