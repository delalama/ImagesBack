package com.delalama.imagesAPI.service.interf;

import java.io.IOException;

public interface RotationService {
    byte[] rotate90(String id, String side) throws IOException;
}
