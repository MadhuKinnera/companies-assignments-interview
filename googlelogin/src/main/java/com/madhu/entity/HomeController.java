package com.madhu.entity;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/hello")
	public String hello() {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
	String res =	SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		System.out.println("username is "+username);
		System.out.println("principal is "+res);
		return "Hello";

	}

}
