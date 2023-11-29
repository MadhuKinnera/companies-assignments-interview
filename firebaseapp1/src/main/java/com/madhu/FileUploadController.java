package com.madhu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class FileUploadController {

	private String uploadDirectory; // Directory path to store files

	@Autowired
	private ResourceService resourceService;

	@PostMapping("/image")
	public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
		// Check if the file is empty

		if (file.isEmpty()) {
			return ResponseEntity.badRequest().body("Please upload an image file.");
		}

		uploadDirectory = resourceService.getResourcesPath();

		System.out.println(uploadDirectory);

		try {

			String filename = StringUtils.cleanPath(file.getOriginalFilename());

			File directory = new File(uploadDirectory);
			if (!directory.exists()) {
				directory.mkdirs();
			}

			Path filePath = Paths.get(uploadDirectory + File.separator + filename);
			
			System.out.println("the path is "+filePath.getFileName());
			file.transferTo(filePath.toFile());

			String fileName = filePath.getFileName().toString();
			
			System.out.println("the file name is "+fileName);

			return ResponseEntity.ok("Image uploaded successfully. File Name is : " + fileName);
		} catch (IOException e) {
			return ResponseEntity.status(500).body("Failed to upload image." + e.getMessage());
		}
	}

	@GetMapping("/image/{filename}")
	public ResponseEntity<byte[]> getImage(@PathVariable String filename) throws IOException {

		uploadDirectory = resourceService.getResourcesPath();

		String imagePath = uploadDirectory + File.separator + filename;
		FileSystemResource file = new FileSystemResource(imagePath);

		if (file.exists()) {
			byte[] imageData = file.getContentAsByteArray();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG); // Set the content type to image/jpeg

			return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	

	@GetMapping("/video/{filename}")
	public ResponseEntity<FileSystemResource> getVideo(@PathVariable String filename) throws IOException {

		uploadDirectory = resourceService.getResourcesPath();

		String videoPath = uploadDirectory + File.separator + filename;
		File videoFile = new File(videoPath);

		if (videoFile.exists()) {
			
			HttpHeaders headers = new HttpHeaders();
			 headers.setContentDispositionFormData("attachment", videoFile.getName());
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); // Set the content type to image/jpeg

			return new ResponseEntity<>(new FileSystemResource(videoFile), headers, HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
