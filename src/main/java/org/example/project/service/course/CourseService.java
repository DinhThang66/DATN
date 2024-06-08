package org.example.project.service.course;

import org.example.project.model.Course;
import org.example.project.model.Department;
import org.springframework.data.domain.Page;

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
    Page<Course> getAll(Integer pageNo);
    Page<Course> searchDept(Long keywordDeptId, String  keywordId, String keywordName, Integer pageNo);
}
