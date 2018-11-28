package com.myproject.myapp.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.myapp.model.UserVO;
import com.myproject.myapp.model.YoutubeVO;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private AdminService service;

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

	@RequestMapping("join")
	public String joinGet() {
		return "admin/join";
	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String joinPost(UserVO vo) {
		System.out.println("joinPost!!");
		System.out.println("name: " + vo.getU_name());
		System.out.println("id: " + vo.getU_id());
		System.out.println("pw: " + vo.getU_pw());
		System.out.println("auth: " + vo.getU_auth());

		service.join(vo);
		return "redirect:loginForm";
	}

	@RequestMapping("insertURL")
	public String inserURLGet() {
		return "admin/insertURL";
	}

	@RequestMapping(value = "insertURL", method = RequestMethod.POST)
	public String inserURLPost(YoutubeVO vo) {
		service.insertURL(vo);
		return "redirect:main";
	}

}
