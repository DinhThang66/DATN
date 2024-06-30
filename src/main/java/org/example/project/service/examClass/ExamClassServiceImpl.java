package org.example.project.service.examClass;

import org.example.project.model.ExamClass;
import org.example.project.repositories.ExamClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamClassServiceImpl implements ExamClassService {
    @Autowired
    private ExamClassRepository examClassRepository;
    @Override
    public void update(ExamClass examClass) {
        try{
            this.examClassRepository.save(examClass);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public ExamClass findById(Long id) {
        return this.examClassRepository.findById(id).get();
    }
}
