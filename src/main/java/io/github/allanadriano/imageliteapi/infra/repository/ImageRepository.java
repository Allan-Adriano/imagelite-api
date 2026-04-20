package io.github.allanadriano.imageliteapi.infra.repository;

import io.github.allanadriano.imageliteapi.Domain.entity.Image;
import io.github.allanadriano.imageliteapi.Domain.enums.ImageExtension;
import io.github.allanadriano.imageliteapi.infra.repository.specs.ImageSpecs;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import java.util.List;

import static io.github.allanadriano.imageliteapi.infra.repository.specs.ImageSpecs.*;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image> {

     default List<Image> findByExtensionAndNameOrTagsLike(ImageExtension extension, String query){
         Specification<Image> conjunction = (root, q, criteriaBuilder) -> criteriaBuilder.conjunction();
         Specification<Image> spec = Specification.where( conjunction );

         if (extension != null){
             spec = spec.and(ImageSpecs.extensionEqual(extension));;
         }

         if (StringUtils.hasText(query)){

             spec = spec.and(Specification.anyOf(nameLike(query), tagLiKE(query)));

         }

         return findAll(spec);

     }

}
