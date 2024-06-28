package org.example.project.service.studentAttendance;

import org.example.project.model.Student;
import org.example.project.model.StudentAttendance;

import java.util.List;

public interface StudentAttendanceService {
    Boolean update(StudentAttendance studentAttendance);
    List<StudentAttendance> findAllByCLassId(Long ClassId);


}
