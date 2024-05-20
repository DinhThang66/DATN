package org.example.project.service._class;

import org.example.project.model.CourseClass;
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
    public List<CourseClass> getAll() {
        return this.classRepository.findAll();
    }

    @Override
    public Boolean create(CourseClass _Course_class) {
        try{
            this.classRepository.save(_Course_class);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public CourseClass findById(Long id) {
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
        Optional<CourseClass> authorOptional = classRepository.findById(ClassId);
        if (authorOptional.isPresent()) {
            CourseClass _Course_class = authorOptional.get();
            return new ArrayList<>(_Course_class.getStudents());
        } else {
            // Handle case when author with given id is not found
            return Collections.emptyList();
        }
    }
}
