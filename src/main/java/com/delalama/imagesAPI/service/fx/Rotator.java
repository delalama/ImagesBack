package com.delalama.imagesAPI.service.fx;

import org.imgscalr.Scalr;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.delalama.imagesAPI.service.fx.ImageUtils.convertPreImageToBufferedImage;
import static com.delalama.imagesAPI.service.fx.ImageUtils.toByteArray;

@Component
public class Rotator {

    private Scalr scalr = new Scalr();

    public byte[] rotate90(byte[] preImage, String side) throws IOException {
        switch (side){
            case "LEFT": return rotateLeft(preImage);
            case "RIGHT": return rotateRight(preImage);
            default: return null;
        }
    }

    private byte[] rotateRight(byte[] preImage) throws IOException {

        BufferedImage img = convertPreImageToBufferedImage(preImage);

        BufferedImage processedImg = scalr.rotate(img, Scalr.Rotation.CW_90);

        return toByteArray(processedImg);
    }

    private byte[] rotateLeft(byte[] preImage) throws IOException {
        BufferedImage img = convertPreImageToBufferedImage(preImage);

        BufferedImage processedImg = scalr.rotate(img, Scalr.Rotation.CW_270);

        return toByteArray(processedImg);
    }

}
