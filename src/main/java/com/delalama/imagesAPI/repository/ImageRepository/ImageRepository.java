package com.delalama.imagesAPI.repository.ImageRepository;

import com.delalama.imagesAPI.model.persistence.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ImageRepository extends MongoRepository<Image, String> {
//    public Optional<Image> findOneById(String id);
}
