package com.madhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.madhu.dto.DataType;
import com.madhu.utils.CommonUtils;

@Service
public class BasicServiceImpl implements BasicService {

	@Autowired
	private CommonUtils utils;

	@Override
	public String encryptData(MultipartFile file, String secretKey) throws Exception {

		String fileUrl = utils.convertImageToUrl(file);

		return utils.encrypt(fileUrl, secretKey);

	}

	@Override
	public String encryptText(String text, String secretKey) throws Exception {

		String encryptedText = utils.encrypt(text, secretKey);

		return encryptedText;
	}

	@Override
	public String decryptText(String text, DataType dataType, String secretKey) throws Exception {
		
		String plainText = utils.decrypt(text, secretKey);
		
		return plainText;
	}

}
