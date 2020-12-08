package com.delalama.imagesAPI.service.converter;

import com.delalama.imagesAPI.model.Dto.ImageDto;
import com.delalama.imagesAPI.model.persistence.Image;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ImageDtoToImageConverter implements Converter<ImageDto, Image> {
    @Override
    public Image convert(ImageDto imageDto) {
        return new ModelMapper().map(imageDto, Image.class);
    }
}
