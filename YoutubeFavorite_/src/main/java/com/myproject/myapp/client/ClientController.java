package com.myproject.myapp.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("client")
public class ClientController {
	@RequestMapping("list")
	public String list() {
		return "client/list";
	}
}
