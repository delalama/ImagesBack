package com.delalama.imagesAPI.service;

import com.delalama.imagesAPI.model.Dto.ImageDto;

public interface ImageService {
    public abstract ImageDto findById(String id);

    String save(byte[] data);
}

