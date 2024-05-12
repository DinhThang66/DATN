package org.example.project.service.lecturer;

import org.example.project.model.Lecturer;
import org.example.project.repositories.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LecturerServiceImp implements LecturerService{

    @Autowired
    private LecturerRepository lecturerRepository;

    @Override
    public Boolean update(Lecturer lecturer) {
        try {
            this.lecturerRepository.save(lecturer);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
