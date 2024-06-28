package org.example.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "studentAttendance")
@Getter
@Setter
@NoArgsConstructor
public class StudentAttendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private CourseClass courseClass;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private Boolean isAttended;

    private String date;

    public StudentAttendance(Long id, CourseClass courseClass, Student student, Boolean isAttended, String date) {
        this.id = id;
        this.courseClass = courseClass;
        this.student = student;
        this.isAttended = isAttended;
        this.date = date;
    }
}
