package org.example.project.service.courseClass;

import org.example.project.model.CourseClass;
import org.example.project.model.Student;
import org.example.project.model.User;
import org.example.project.repositories.CourseClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CourseClassServiceImpl implements CourseClassService {
    @Autowired
    private CourseClassRepository courseClassRepository;
    @Override
    public List<CourseClass> getAll() {
        return this.courseClassRepository.findAll();
    }

    @Override
    public Boolean create(CourseClass _Course_class) {
        try{
            this.courseClassRepository.save(_Course_class);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public CourseClass findById(Long id) {
        return this.courseClassRepository.findById(id).get();
    }

    @Override
    public Boolean delete(Long id) {
        try {
            this.courseClassRepository.delete(findById(id));
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
        Optional<CourseClass> authorOptional = courseClassRepository.findById(ClassId);
        if (authorOptional.isPresent()) {
            CourseClass _Course_class = authorOptional.get();
            return new ArrayList<>(_Course_class.getStudents());
        } else {
            // Handle case when author with given id is not found
            return Collections.emptyList();
        }
    }

    @Override
    public Page<CourseClass> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo - 1, 8);
        return this.courseClassRepository.findAll(pageable);
    }

    @Override
    public Integer numberOfClassesInDept(Long id) {
        return this.courseClassRepository.numberOfClassesInDept(id);
    }
}
