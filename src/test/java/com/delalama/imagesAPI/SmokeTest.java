package com.delalama.imagesAPI;

import com.delalama.imagesAPI.controller.ImageController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private ImageController imageController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(imageController).isNotNull();
    }
}
