package org.example.project.repositories;

import org.example.project.model.StudentAttendance;
import org.example.project.model.StudentAttendanceExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentAttendanceExamRepository extends JpaRepository<StudentAttendanceExam, Long> {
    @Query("SELECT s FROM StudentAttendanceExam s WHERE s.examClass.id = ?1")
    List<StudentAttendanceExam> findAllByExamCLassId(Long ClassId);
}
