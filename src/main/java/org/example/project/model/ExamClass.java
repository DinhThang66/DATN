package org.example.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "examClass")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private Integer examSession;

    @OneToOne
    @JoinColumn(name = "class_id")
    private CourseClass courseClass;

    public ExamClass(CourseClass courseClass) {
        this.courseClass = courseClass;
    }
}
