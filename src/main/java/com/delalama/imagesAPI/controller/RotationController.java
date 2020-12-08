package com.delalama.imagesAPI.controller;

import com.delalama.imagesAPI.service.RotationServiceImpl;
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
@RequestMapping(value = "rotation")
public class RotationController {
    RotationServiceImpl rotationService;

    @ResponseBody
    @GetMapping(value="rotate90" , produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(
            @RequestParam String id,
            @RequestParam String side) throws IOException {
        log.info("Image Controller : getImage");
        return new ResponseEntity<byte[]>(rotationService.rotate90(id, side), HttpStatus.OK);
    }

}
