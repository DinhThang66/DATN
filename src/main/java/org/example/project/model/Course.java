package org.example.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String course_id;
    private String name;
    private String sessionDuration;     //(Ca/kíp)
    private Integer numberOfCredit;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private List<Class> classes;

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public Course() {
        super();
    }

    public Course(Long id, String course_id, String name, String sessionDuration, Integer numberOfCredit, Department department) {
        this.id = id;
        this.course_id = course_id;
        this.name = name;
        this.sessionDuration = sessionDuration;
        this.numberOfCredit = numberOfCredit;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfCredit() {
        return numberOfCredit;
    }

    public void setNumberOfCredit(Integer numberOfCredit) {
        this.numberOfCredit = numberOfCredit;
    }

    public String getSessionDuration() {
        return sessionDuration;
    }

    public void setSessionDuration(String sessionDuration) {
        this.sessionDuration = sessionDuration;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
