package org.example.project.service.course;

import org.example.project.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAll();
    Boolean create(Course course);
    Course findById(Long id);
    Boolean update(Course course);
    Boolean delete(Long id);
    List<Course> searchCourseById(String keyword);
    List<Course> searchCourseByName(String keyword);
    List<Course> searchCourseByDept(Long keyword);
}
