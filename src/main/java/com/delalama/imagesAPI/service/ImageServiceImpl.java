package com.delalama.imagesAPI.service;

import com.delalama.imagesAPI.model.Dto.ImageDto;
import com.delalama.imagesAPI.model.persistence.Image;
import com.delalama.imagesAPI.repository.ImageRepository.ImageRepository;
import com.delalama.imagesAPI.service.interf.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ConversionService conversionService;

    @Autowired
    ImageRepository imageRepository;

    public ImageServiceImpl(){
    }

    @Override
    public ImageDto findById(String id) {
        return conversionService.convert(imageRepository.findById(id).orElseThrow(), ImageDto.class);
    }

    @Override
    public String save(byte[] data) {
        // TODO format exceptions....size...etc
        Image image = new Image(data);
        String id = imageRepository.save(image).getId();
        return id;
    }
}
