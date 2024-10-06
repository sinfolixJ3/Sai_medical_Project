package com.sinfolix.Sai_Samarth.service.Impl;

import com.sinfolix.Sai_Samarth.entities.ImageFile;
import com.sinfolix.Sai_Samarth.repositories.ImageFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl {

    @Autowired
    private ImageFileRepository imageFileRepository;

    // Save the uploaded image as binary data in the DB
    public ImageFile saveImage(MultipartFile file) throws IOException {
        ImageFile imageFile = new ImageFile();
        imageFile.setFileName(file.getOriginalFilename());
        imageFile.setFileType(file.getContentType());
        imageFile.setData(file.getBytes());  // Convert image to byte array

        return imageFileRepository.save(imageFile);
    }

    // Get image metadata and binary data from the DB by ID
    public ImageFile getImageById(Long id) {
        return imageFileRepository.findById(id).orElse(null);
    }
}
