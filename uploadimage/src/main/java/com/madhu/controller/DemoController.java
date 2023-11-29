package com.madhu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;

@RestController
public class DemoController {
	
	
	@Autowired
	private DemoServiceImpl demoService;

	
	@GetMapping("/hello")
	public String hello() {
		return "Hello ";
	}
	
	@PostMapping("/uploadImage")
	public ResponseEntity<Map> convertImageIntoUrl(@RequestParam("image") MultipartFile imageFile) {
		
		
		System.out.print("file name "+imageFile.getOriginalFilename());
		
		//return ResponseEntity.ok(demoService.upload(imageFile));
		
		return ResponseEntity.ok(null);
		
		
	}
}
