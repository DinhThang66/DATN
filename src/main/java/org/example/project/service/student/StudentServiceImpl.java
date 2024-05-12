package org.example.project.service.student;

import org.example.project.model.Student;
import org.example.project.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{


    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Boolean update(Student student) {
        try {
            this.studentRepository.save(student);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
