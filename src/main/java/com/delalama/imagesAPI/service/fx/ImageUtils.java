package com.delalama.imagesAPI.service.fx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageUtils {

    static byte[] toByteArray(BufferedImage processedImg) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(processedImg, "jpg", bos );
        return bos.toByteArray();
    }

    static BufferedImage convertPreImageToBufferedImage(byte[] preImage) {
        ByteArrayInputStream imgInputStream = new ByteArrayInputStream(preImage);

        try {
            return ImageIO.read(imgInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
