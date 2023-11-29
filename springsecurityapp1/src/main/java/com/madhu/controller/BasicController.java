package com.madhu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

	@GetMapping("/private/hello")
	public String privateMethod() {
		return "This is Private Method Hello";
	}

	@GetMapping("/public/hello")
	public String publicMethod() {
		return "This is Public Method Hello";
	}

}
