package com.madhu.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

@Service
public class DemoServiceImpl  {
	
	
	@Autowired
	private Cloudinary cloudinary;
	
	
	public Map upload(MultipartFile file) {	
		
		try {
		Map data =	this.cloudinary.uploader().upload(file.getBytes(), Map.of());
		
		System.out.println("data is "+data);
		
		System.out.println("url is "+data.get("secure_url"));
		
		return data;
		} catch (IOException e) {
			System.out.println("Image Upload Failed ");
			return null;
		}
		
		
	}
	

}
