package com.delalama.imagesAPI.model.persistence;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Image {

    @Id
    @Indexed(unique = true)
    private String id;
    private byte[] data;

    public Image(byte[] data) {
        this.data = data;
    }
}
