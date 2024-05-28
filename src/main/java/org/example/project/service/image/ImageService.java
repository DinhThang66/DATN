package org.example.project.service.image;

import org.example.project.model.Image;

import java.util.List;

public interface ImageService {
    List<Image> getAll();
    Boolean create(Image image);
    Image findById(Long id);

}
