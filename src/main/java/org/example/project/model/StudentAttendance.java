package org.example.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "studentAttendance")
@Getter
@Setter
public class StudentAttendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToMany
    @JoinTable(
            name = "student_attendance_students",
            joinColumns = @JoinColumn(name = "attendance_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;
    private String date;
    private Boolean isAttended;


    @ManyToOne
    @JoinColumn(name = "course_class_id")
    private CourseClass courseClass;

    public StudentAttendance(Long id, List<Student> students, String date, Boolean isAttended, CourseClass courseClass) {
        this.id = id;
        this.students = students;
        this.date = date;
        this.isAttended = isAttended;
        this.courseClass = courseClass;
    }

    public StudentAttendance() {}

}
