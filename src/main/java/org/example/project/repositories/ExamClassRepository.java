package org.example.project.repositories;

import org.example.project.model.ExamClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamClassRepository  extends JpaRepository<ExamClass, Long> {
}
