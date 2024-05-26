package org.example.project.service.courseClass;

import org.example.project.model.CourseClass;
import org.example.project.model.Student;


import java.util.List;

public interface CourseClassService {
    List<CourseClass> getAll();
    Boolean create(CourseClass _Course_class);
    CourseClass findById(Long id);
    Boolean delete(Long id);
    List<Student> getAllStudents();
    List<Student> getStudentsByClassId(Long ClassId);


}
