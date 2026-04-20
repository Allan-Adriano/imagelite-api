package io.github.allanadriano.imageliteapi.Domain.service;

import io.github.allanadriano.imageliteapi.Domain.entity.Image;
import io.github.allanadriano.imageliteapi.Domain.enums.ImageExtension;

import java.util.List;
import java.util.Optional;

public interface ImageService {

    Image save(Image image);

    Optional<Image> getById(String id);

   List<Image> search(ImageExtension extension, String query);
}
