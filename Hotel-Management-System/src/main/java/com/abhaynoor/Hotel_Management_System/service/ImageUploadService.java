package com.abhaynoor.Hotel_Management_System.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {

	String uploadImage(MultipartFile image) throws IOException;
}
