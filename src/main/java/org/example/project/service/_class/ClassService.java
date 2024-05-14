package org.example.project.service._class;

import org.example.project.model.Class;
import org.example.project.model.Course;
import org.example.project.model.Student;


import java.util.List;

public interface ClassService {
    List<Class> getAll();
    Boolean create(Class _class);
    Class findById(Long id);
    Boolean delete(Long id);
    List<Student> getAllStudents();
    List<Student> getStudentsByClassId(Long ClassId);


}
