package com.madhu.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

@Component
public class CommonUtils {
	
	@Autowired
	private Cloudinary cloudinary;

	private  final String ALGORITHM = "AES";

	private   final String defaultKey = "1234567812345678";

	public  String encrypt(String plainText, String key) throws Exception {

		if (key == null)
			key = defaultKey;

		Cipher cipher = Cipher.getInstance(ALGORITHM);

		SecretKey secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);

		cipher.init(Cipher.ENCRYPT_MODE, secretKey);

		byte[] encryptedText = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
		return Base64.getEncoder().encodeToString(encryptedText);
	}

	public  String decrypt(String encryptedText,String key) throws Exception {

		if (key == null)
			key = defaultKey;
		
		encryptedText = encryptedText.trim();
		
		encryptedText = encryptedText.replace(' ', '+');
		
		System.out.println(encryptedText+" and size is "+encryptedText.length());
		
		
		Cipher cipher = Cipher.getInstance(ALGORITHM);

		SecretKey secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);

		byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText.getBytes());

		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

		return new String(decryptedBytes, StandardCharsets.UTF_8);

	}
	
	@SuppressWarnings("rawtypes")
	public  String convertImageToUrl(MultipartFile file) throws IOException {
		Map data = this.cloudinary.uploader().upload(file.getBytes(), Map.of());

		return data.get("secure_url").toString();
	}


}
