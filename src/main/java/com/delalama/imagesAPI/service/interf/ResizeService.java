package com.delalama.imagesAPI.service.interf;

import java.io.IOException;

public interface ResizeService {
    byte[] resize(String id, int width, int height) throws IOException;
}
