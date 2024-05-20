package org.example.project.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "user_id")
    private Long id;
    private String educationLevel;
    private String educationProgram;
    private String className;
    @OneToOne
    @JoinColumn(name = "user_id", unique = true, referencedColumnName = "id")
    private User user;
    @ManyToMany(mappedBy = "students")
    Set<CourseClass> courseClasses;


    public Student() {
        super();
    }
    public Student(Long id, String educationLevel, String educationProgram, String className, User user) {
        this.id = id;
        this.educationLevel = educationLevel;
        this.educationProgram = educationProgram;
        this.className = className;
        this.user = user;
    }

    public Set<CourseClass> getClasses() {
        return courseClasses;
    }

    public void setClasses(Set<CourseClass> courseClasses) {
        this.courseClasses = courseClasses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getEducationProgram() {
        return educationProgram;
    }

    public void setEducationProgram(String educationProgram) {
        this.educationProgram = educationProgram;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
