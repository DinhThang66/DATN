package org.example.project.service._class;

import org.example.project.model.CourseClass;
import org.example.project.model.Student;


import java.util.List;

public interface ClassService {
    List<CourseClass> getAll();
    Boolean create(CourseClass _Course_class);
    CourseClass findById(Long id);
    Boolean delete(Long id);
    List<Student> getAllStudents();
    List<Student> getStudentsByClassId(Long ClassId);


}
