package com.delalama.imagesAPI.controller;

import com.delalama.imagesAPI.service.ImageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@CrossOrigin
@AllArgsConstructor
@Slf4j
@RequestMapping("image")
@RestController
public class ImageController {

    private final ImageService imageService;

    @ResponseBody
    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(
            @RequestParam String id){
        log.info("Image Controller : getImage");
        return new ResponseEntity<byte[]>(imageService.findById(id).getData(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> postImage(
            @RequestBody MultipartFile file) throws IOException {
        log.info("Image Controller : postImage");
        byte[] data = file.getBytes();
        return new ResponseEntity<>(imageService.save(data), HttpStatus.OK);
    }
}
