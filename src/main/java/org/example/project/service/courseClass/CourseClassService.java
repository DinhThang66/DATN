package org.example.project.service.courseClass;

import org.example.project.model.CourseClass;
import org.example.project.model.Student;
import org.springframework.data.domain.Page;


import java.util.List;

public interface CourseClassService {
    List<CourseClass> getAll();
    Boolean create(CourseClass _Course_class);
    CourseClass findById(Long id);
    Boolean delete(Long id);
    List<Student> getAllStudents();
    List<Student> getStudentsByClassId(Long ClassId);
    Page<CourseClass> getAll(Integer pageNo);
    Integer numberOfClassesInDept(Long id);
    void deleteStudentFromClass(Long classId, Long studentId);
    void addStudentToClass(Long classId, Long studentId);

    List<CourseClass> searchClassByDept(Long keyword);
    Page<CourseClass> searchClassByDept(Long keyword, Integer pageNo);

    List<CourseClass> searchClassByDept(String keyword1, String keyword2);
    Page<CourseClass> searchClassByDept(String keyword1, String keyword2, Integer pageNo);


}
