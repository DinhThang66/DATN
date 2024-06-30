package org.example.project.service.examClass;

import org.example.project.model.ExamClass;

public interface ExamClassService {
    void update(ExamClass examClass);
    ExamClass findById(Long id);

}
