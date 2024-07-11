package org.example.project.repositories;

import jakarta.transaction.Transactional;
import org.example.project.model.Course;
import org.example.project.model.CourseClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseClassRepository extends JpaRepository<CourseClass, Long> {
    @Query("select COUNT(*) from CourseClass c where c.course.department.id =  ?1")
    Integer numberOfClassesInDept(Long id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM class_student WHERE class_id = :classId AND student_id = :studentId", nativeQuery = true)
    void deleteStudentFromClass(Long classId, Long studentId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO class_student (class_id, student_id) VALUES (:classId, :studentId)", nativeQuery = true)
    void addStudentToClass(Long classId, Long studentId);


    @Query("select c from CourseClass c where c.course.department.id = ?1")
    List<CourseClass> searchClassByDept(Long keyword);

    @Query("select c from CourseClass c where c.course.name like %?1% and c.lecturer.user.fullname like %?2%")
    List<CourseClass> searchClassByDept(String keyword1, String keyword2);
}
