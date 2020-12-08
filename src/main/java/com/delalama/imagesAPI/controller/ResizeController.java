package com.delalama.imagesAPI.controller;

import com.delalama.imagesAPI.service.ResizeServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping(value = "resize")
public class ResizeController {
    ResizeServiceImpl resizeService;

    @ResponseBody
    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(
            @RequestParam String id,
            @RequestParam int width,
            @RequestParam int height) throws IOException {
        log.info("Resize Controller : resize");
        return new ResponseEntity<byte[]>(resizeService.resize(id, width, height), HttpStatus.OK);
    }

}
