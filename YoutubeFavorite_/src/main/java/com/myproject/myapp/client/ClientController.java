package com.myproject.myapp.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.myapp.model.YoutubeVO;

@Controller
@RequestMapping("client")
public class ClientController {

	String thumbnail = "https://img.youtube.com/vi/n0CiUx3U2fw/maxresdefault.jpg";
	String title = "https://www.youtube.com/oembed?format=json&url=https://www.youtube.com/watch?v=_";

	@Autowired
	private ClientService service;

	@RequestMapping("list")
	public String list(Model model) {

		List<YoutubeVO> list = service.getList();
		model.addAttribute("list", list);
		return "client/list";
	}

	@RequestMapping("jostList")
	@ResponseBody
	public List<YoutubeVO> jsonList() {
		List<YoutubeVO> list = service.getList();
		return list;
	}

	@RequestMapping("detail")
	public String detail(YoutubeVO vo, Model model) {
		System.out.println("detail!!");
		System.out.println("vo.getY_url() : " + vo.getY_url());
		model.addAttribute("y_url", vo.getY_url());
		return "client/detail";
	}

	@RequestMapping("viewGallary")
	public String viewGallary() {
		return "client/viewGallary";
	}
}
