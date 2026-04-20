package io.github.allanadriano.imageliteapi.application.images;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
public class ImageDTO {
    private String url;
    private String name;
    private String extension;
    private Long size;
    private LocalDate uploadDate;
}
