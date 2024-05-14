package org.example.project.service._class;

import org.example.project.model.Class;
import org.example.project.model.Student;
import org.example.project.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService{
    @Autowired
    private ClassRepository classRepository;
    @Override
    public List<Class> getAll() {
        return this.classRepository.findAll();
    }

    @Override
    public Boolean create(Class _class) {
        try{
            this.classRepository.save(_class);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Class findById(Long id) {
        return this.classRepository.findById(id).get();
    }

    @Override
    public Boolean delete(Long id) {
        try {
            this.classRepository.delete(findById(id));
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Student> getAllStudents() {
        return null;
    }
    public List<Student> getStudentsByClassId(Long ClassId) {
        Optional<Class> authorOptional = classRepository.findById(ClassId);
        if (authorOptional.isPresent()) {
            Class _class = authorOptional.get();
            return new ArrayList<>(_class.getStudents());
        } else {
            // Handle case when author with given id is not found
            return Collections.emptyList();
        }
    }
}
