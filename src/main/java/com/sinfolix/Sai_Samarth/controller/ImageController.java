package com.sinfolix.Sai_Samarth.controller;

import com.sinfolix.Sai_Samarth.entities.ImageFile;
import com.sinfolix.Sai_Samarth.service.Impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageServiceImpl imageService;

    // Endpoint to upload an image
    @PostMapping("/upload")
    public ResponseEntity<ImageFile> uploadImage(@RequestParam("image") MultipartFile file) {
        try {
            ImageFile savedImage = imageService.saveImage(file);
            return new ResponseEntity<>(savedImage, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint to retrieve an image by ID
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        ImageFile imageFile = imageService.getImageById(id);
        if (imageFile != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(org.springframework.http.MediaType.valueOf(imageFile.getFileType()));
            return new ResponseEntity<>(imageFile.getData(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}