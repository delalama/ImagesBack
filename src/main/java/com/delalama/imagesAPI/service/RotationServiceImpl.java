package com.delalama.imagesAPI.service;

import com.delalama.imagesAPI.model.Dto.ImageDto;
import com.delalama.imagesAPI.service.fx.ImageEffect;
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
    private ImageEffect imageEffect ;

    public byte[] rotate90(String id, String side) throws IOException {
        byte[] preImage = conversionService.convert(imageService.findById(id), ImageDto.class).getData();

        byte[] effectedData = imageEffect.rotate90(preImage, side);

        return effectedData;

    }
}
