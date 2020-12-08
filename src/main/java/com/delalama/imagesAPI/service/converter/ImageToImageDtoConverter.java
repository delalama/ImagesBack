package com.delalama.imagesAPI.service.converter;

import com.delalama.imagesAPI.model.Dto.ImageDto;
import com.delalama.imagesAPI.model.persistence.Image;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component
public class ImageToImageDtoConverter implements Converter<Image, ImageDto> {

    @Override
    public ImageDto convert(Image image){
        return new ModelMapper().map(image, ImageDto.class);
    }
}
