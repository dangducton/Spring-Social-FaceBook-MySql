package com.dangducton.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dangducton.model.UserInfo;

@Controller
public class HomeController {

	@GetMapping(value = "/")
	public String home(Model model) {
		model.addAttribute("user", new UserInfo());
		return "view/home";
	}

	@GetMapping(value = "/loginfailure")
	public String loginfailure(Model model) {
		model.addAttribute("user", new UserInfo());
		model.addAttribute("errormessage", "Tài khoản và mật khẩu không chính xác");
		return "view/home";
	}
	@GetMapping(value = "/accessdenied")
	public String accessdenied(Model model) {
		model.addAttribute("user", new UserInfo());
		model.addAttribute("errormessage", "Không đủ quyền");
		return "view/home";
	}
	
	@GetMapping(value = "/logout")
	public String logoutSuccess(Model model,HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null) {
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		model.addAttribute("user", new UserInfo());
		model.addAttribute("status", "Bạn đã đăng xuất");
		return "view/home";
	}
}
