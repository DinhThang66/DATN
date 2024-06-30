package org.example.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "class")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;

    @ManyToOne
    @JoinColumn(name = "course_id"  )
    private Course course;

    @ManyToMany
    @JoinTable(
            name = "class_student",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    Set<Student> students;

    private String room;
    private String schedule;

    @OneToMany(mappedBy = "courseClass")
    private Set<StudentAttendance> attendances;

    @OneToOne(mappedBy = "courseClass", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ExamClass examClass;
}
