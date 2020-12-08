package com.delalama.imagesAPI.service;

import com.delalama.imagesAPI.service.fx.Resizer;
import com.delalama.imagesAPI.service.interf.ImageService;
import com.delalama.imagesAPI.service.interf.ResizeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.IOException;

@AllArgsConstructor
@Service
public class ResizeServiceImpl implements ResizeService {

    @Autowired
    ConversionService conversionService;

    @Autowired
    ImageService imageService;

    @Autowired
    Resizer resizer;

    public byte[] resize(String id, int width, int height) throws IOException {

        Dimension dimension = new Dimension(width, height);

        return resizer.resize(imageService.findById(id).getData(), dimension);
    }
}
