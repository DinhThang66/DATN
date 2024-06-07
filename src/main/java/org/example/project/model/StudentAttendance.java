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


    private Long student_id;
    private String date;
    private Boolean isAttended;


    public StudentAttendance(Long id, Long student_id, String date, Boolean isAttended) {
        this.id = id;
        this.student_id = student_id;
        this.date = date;
        this.isAttended = isAttended;
    }

    public StudentAttendance() {

    }
}
