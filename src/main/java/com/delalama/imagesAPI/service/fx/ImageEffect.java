package com.delalama.imagesAPI.service.fx;

import org.imgscalr.Scalr;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component
public class ImageEffect {
    public byte[] rotate90(byte[] preImage, String side) throws IOException {
        switch (side){
            case "LEFT": return rotateLeft(preImage);
            case "RIGHT": return rotateRight(preImage);
            default: return null;
        }
    }

    private byte[] rotateRight(byte[] preImage) throws IOException {

        return applyRightRotation(preImage);
    }



    private byte[] applyRightRotation(byte[] preImage) throws IOException {
        BufferedImage img = convertPreImageToBufferedImage(preImage);

        Scalr scalr = new Scalr();

        BufferedImage processedImg = scalr.rotate(img, Scalr.Rotation.CW_90);

        return toByteArray(processedImg);
    }

    private byte[] toByteArray(BufferedImage processedImg) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(processedImg, "jpg", bos );
        return bos.toByteArray();
    }

    private BufferedImage convertPreImageToBufferedImage(byte[] preImage) {
        ByteArrayInputStream imgInputStream = new ByteArrayInputStream(preImage);

        try {
            return ImageIO.read(imgInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private byte[] rotateLeft(byte[] preImage) {
        return null;
    }
}
