package com.abhaynoor.Hotel_Management_System.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.abhaynoor.Hotel_Management_System.service.ImageUploadService;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {

	// Folder where images will be stored. Getting the value from application.properties
	@Value("${app.image.upload-dir}")
	private String uploadFolder;
	
	@Override
	public String uploadImage(MultipartFile image) throws IOException {
		
		// Check whether folder exists
		File checkUploadFolder = new File(uploadFolder);
		if(!checkUploadFolder.exists()) {
			checkUploadFolder.mkdirs();
		}
		// Get the original file name
		String fileName = image.getOriginalFilename();
		if(fileName==null||fileName.isEmpty()) {
			throw new IOException("File name does not exist");
		}
		// Define complete path for file
		String filePath = Paths.get(uploadFolder, fileName).toString();
		
		// Saving the file(image) to folder
		image.transferTo(new File(filePath));
		
		// Return the url to be saved in database
		return filePath;
	}

}
