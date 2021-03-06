package com.delalama.imagesAPI.service;

import com.delalama.imagesAPI.service.fx.Rotator;
import com.delalama.imagesAPI.service.interf.ImageService;
import com.delalama.imagesAPI.service.interf.RotationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@AllArgsConstructor
@Service
public class RotationServiceImpl implements RotationService {

    @Autowired
    ConversionService conversionService;

    @Autowired
    ImageService imageService;

    @Autowired
    private Rotator imageEffect ;

    public byte[] rotate90(String id, String side) throws IOException {
        return imageEffect.rotate90(imageService.findById(id).getData(), side);
    }
}
