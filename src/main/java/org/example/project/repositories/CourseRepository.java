package org.example.project.repositories;

import org.example.project.model.Course;
import org.example.project.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("select c from Course c where c.course_id like %?1%")
    List<Course> searchCourseById(String keyword);
    @Query("select c from Course c where c.name like %?1%")
    List<Course> searchCourseByName(String keyword);
    @Query("select c from Course c where c.department.id = ?1")
    List<Course> searchCourseByDept(Long keyword);

    @Query("select COUNT(*) from Course c")
    Integer numberOfCourses();
}
