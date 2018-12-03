package com.myproject.myapp.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.myapp.model.GallaryVO;
import com.myproject.myapp.model.YoutubeVO;

@Controller
@RequestMapping("client")
public class ClientController {

	String thumbnail = "https://img.youtube.com/vi/n0CiUx3U2fw/maxresdefault.jpg";
	String title = "https://www.youtube.com/oembed?format=json&url=https://www.youtube.com/watch?v=_";

	@Autowired
	private ClientService service;

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
	public String viewGallary(Model model) {
		List<GallaryVO> list = service.gallaryList();
		model.addAttribute("list", list);
		return "client/viewGallary";
	}

	@RequestMapping("gallaryDetail")
	public String gallaryDetail(@RequestParam(name = "g_no") int g_no, Model model) {
		GallaryVO result = service.gallaryDetail(g_no);
		model.addAttribute("result", result);
		return "client/gallaryDetail";
	}

	@RequestMapping("jsonYoutubeList")
	@ResponseBody
	public List<YoutubeVO> jsonYoutubeList() {
		List<YoutubeVO> list = service.getList();
		return list;
	}

	@RequestMapping("jsonGallaryList")
	@ResponseBody
	public List<GallaryVO> jsonGallaryList() {
		return service.gallaryList();
	}

	@RequestMapping("youtubeList")
	public String list(Model model) {
		List<YoutubeVO> list = service.getList();
		model.addAttribute("list", list);
		return "client/list";
	}
}
