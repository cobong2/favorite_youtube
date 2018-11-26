package com.myproject.myapp.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
	@RequestMapping("loginForm")
	public String loginForm() {
		return "admin/loginForm";
	}

	@RequestMapping("main")
	public String main() {
		return "admin/main";
	}

	@RequestMapping("accessDenied")
	public String accessDenied() {
		return "admin/loginForm";
	}
}
