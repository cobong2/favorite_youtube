package com.myproject.myapp.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.myapp.model.GallaryVO;
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
	public String insertURLGet() {
		return "admin/insertURL";
	}

	@RequestMapping(value = "insertURL", method = RequestMethod.POST)
	public String insertURLPost(YoutubeVO vo) {
		// TODO insert 수행
		System.out.println("url : " + vo.getY_url());
		System.out.println("title : " + vo.getY_title());
		service.insertURL(vo);
		return "redirect:/client/list";
	}

	@RequestMapping("insertGallary")
	public String insertGallaryGet() {
		return "admin/insertGallary";
	}

	@RequestMapping(value = "insertGallary", method = RequestMethod.POST)
	public String insertGallaryPost(GallaryVO vo) {
		System.out.println("title : " + vo.getG_title());
		System.out.println("img : " + vo.getImg());
		service.insertGallary(vo);
		return "redirect:/client/viewGallary";
	}
}
