package org.example.project.repositories;

import org.example.project.model.CourseClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<CourseClass, Long> {
}
