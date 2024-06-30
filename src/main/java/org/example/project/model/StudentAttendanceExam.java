package org.example.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "studentAttendanceExam")
@Getter
@Setter
@NoArgsConstructor
public class StudentAttendanceExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ExamClass examClass;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private Boolean isAttended;

    public StudentAttendanceExam(Long id, ExamClass examClass, Student student, Boolean isAttended) {
        this.id = id;
        this.examClass = examClass;
        this.student = student;
        this.isAttended = isAttended;
    }
}
