package org.example.project.service.studentAttendanceExam;

import org.example.project.model.StudentAttendance;
import org.example.project.model.StudentAttendanceExam;

import java.util.List;

public interface StudentAttendanceExamService {
    Boolean update(StudentAttendanceExam studentAttendanceExam);
    List<StudentAttendanceExam> getAll();
    List<StudentAttendanceExam> findAllByExamCLassId(Long ClassId);


}
