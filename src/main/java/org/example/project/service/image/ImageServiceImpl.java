package org.example.project.service.image;

import org.example.project.model.Image;
import org.example.project.repositories.DeptRepository;
import org.example.project.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    private ImageRepository imageRepository;
    @Override
    public List<Image> getAll() {
        return this.imageRepository.findAll();
    }

    @Override
    public Boolean create(Image image) {
        try {
            this.imageRepository.save(image);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Image findById(Long id) {
        return this.imageRepository.findById(id).get();
    }
}
