package io.github.allanadriano.imageliteapi.infra.repository;

import io.github.allanadriano.imageliteapi.Domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {

}
