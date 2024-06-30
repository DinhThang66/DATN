package org.example.project.service.studentAttendanceExam;

import org.example.project.model.StudentAttendance;
import org.example.project.model.StudentAttendanceExam;
import org.example.project.repositories.StudentAttendanceExamRepository;
import org.example.project.repositories.StudentAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAttendanceExamServiceImpl implements StudentAttendanceExamService {

    @Autowired
    private StudentAttendanceExamRepository studentAttendanceExamRepository;

    @Override
    public Boolean update(StudentAttendanceExam studentAttendanceExam) {
        try {
            this.studentAttendanceExamRepository.save(studentAttendanceExam);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<StudentAttendanceExam> getAll() {
        return this.studentAttendanceExamRepository.findAll();
    }

    @Override
    public List<StudentAttendanceExam> findAllByExamCLassId(Long ClassId) {
        return this.studentAttendanceExamRepository.findAllByExamCLassId(ClassId);
    }
}
