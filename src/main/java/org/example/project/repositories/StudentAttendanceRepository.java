package org.example.project.repositories;

import org.example.project.model.StudentAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentAttendanceRepository extends JpaRepository<StudentAttendance, Long> {
    @Query("SELECT s FROM StudentAttendance s WHERE s.courseClass.id = ?1")
    List<StudentAttendance> findAllByCLassId(Long ClassId);
}
