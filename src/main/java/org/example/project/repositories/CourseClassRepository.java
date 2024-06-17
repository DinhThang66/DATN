package org.example.project.repositories;

import org.example.project.model.CourseClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseClassRepository extends JpaRepository<CourseClass, Long> {
    @Query("select COUNT(*) from CourseClass c where c.course.department.id =  ?1")
    Integer numberOfClassesInDept(Long id);
}
