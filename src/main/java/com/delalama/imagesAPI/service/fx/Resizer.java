package com.delalama.imagesAPI.service.fx;

import org.imgscalr.Scalr;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.delalama.imagesAPI.service.fx.ImageUtils.convertPreImageToBufferedImage;
import static com.delalama.imagesAPI.service.fx.ImageUtils.toByteArray;

@Component
public class Resizer {

    private Scalr scalr = new Scalr();

    public byte[] resize(byte[] preImage, Dimension dimension) throws IOException {
        BufferedImage img = convertPreImageToBufferedImage(preImage);

        BufferedImage processedImg = scalr.resize(img, dimension.width, dimension.height);

        return toByteArray(processedImg);
    }


}
