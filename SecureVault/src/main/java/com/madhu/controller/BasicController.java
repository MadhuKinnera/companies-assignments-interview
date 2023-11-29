package com.madhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.madhu.dto.DataType;
import com.madhu.service.BasicService;

@RestController
@RequestMapping("/secure")
public class BasicController {

	@Autowired
	private BasicService bService;

	
	@PostMapping("/encryptFile")
	ResponseEntity<String> encryptData(@RequestParam  MultipartFile file,@RequestParam(required = false) String secretKey) throws Exception {

		return ResponseEntity.ok(bService.encryptData(file, secretKey));

	}

	@PostMapping("/encryptText")
	ResponseEntity<String> encryptText(@RequestParam String text,@RequestParam(required = false) String secretKey) throws Exception {

		return ResponseEntity.ok(bService.encryptText(text, secretKey));
	}

	@PostMapping("/decryptText")
	ResponseEntity<String> decryptText(@RequestParam String text,@RequestParam DataType dataType,@RequestParam(required = false) String secretKey) throws Exception {
		return ResponseEntity.ok(bService.decryptText(text, dataType, secretKey));
	}

}
