package org.example.project.service.course;

import org.example.project.model.Course;
import org.example.project.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public Boolean create(Course course) {
        try{
            this.courseRepository.save(course);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Course findById(Long id) {
        return this.courseRepository.findById(id).get();
    }

    @Override
    public Boolean update(Course course) {
        try {
            this.courseRepository.save(course);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(Long id) {
        try {
            this.courseRepository.delete(findById(id));
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Course> searchCourseById(String keyword) {
        return this.courseRepository.searchCourseById(keyword);
    }

    @Override
    public List<Course> searchCourseByName(String keyword) {
        return this.courseRepository.searchCourseByName(keyword);
    }

    @Override
    public List<Course> searchCourseByDept(Long keyword) {
        return this.courseRepository.searchCourseByDept(keyword);
    }

}
