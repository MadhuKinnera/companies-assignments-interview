package com.madhu.service;

import org.springframework.web.multipart.MultipartFile;

import com.madhu.dto.DataType;

public interface BasicService {
	

	String encryptData(MultipartFile file ,String secretKey) throws Exception;
	
	String encryptText(String text,String secretKey) throws Exception;
	
	String decryptText(String text,DataType dataType,String secretKey) throws Exception;
	
	

}
