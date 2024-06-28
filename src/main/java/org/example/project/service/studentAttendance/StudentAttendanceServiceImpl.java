package org.example.project.service.studentAttendance;

import org.example.project.model.StudentAttendance;
import org.example.project.repositories.StudentAttendanceRepository;
import org.example.project.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAttendanceServiceImpl implements StudentAttendanceService{

    @Autowired
    private StudentAttendanceRepository studentAttendanceRepository;
    @Override
    public Boolean update(StudentAttendance studentAttendance) {
        try {
            this.studentAttendanceRepository.save(studentAttendance);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public List<StudentAttendance> findAllByCLassId(Long ClassId) {
        return this.studentAttendanceRepository.findAllByCLassId(ClassId);
    }
}
