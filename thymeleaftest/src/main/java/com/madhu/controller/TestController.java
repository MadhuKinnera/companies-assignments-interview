package com.madhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	
	@GetMapping("/about")
	public String about() {

		System.out.println("inside about handler ");

		return "about";
	}

}
