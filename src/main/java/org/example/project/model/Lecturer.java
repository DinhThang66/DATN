package org.example.project.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "lecturer")
public class Lecturer {
    @Id
    @Column(name = "user_id")
    private Long id;
    private String educationLevel;
    private String position;
    private Integer salary;
    @OneToOne
    @JoinColumn(name = "user_id", unique = true, referencedColumnName = "id")
    private User user;
    @OneToMany(mappedBy = "lecturer")
    private List<Class> classes;



    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public Lecturer() {
        super();
    }

    public Lecturer(Long id, String educationLevel, String position, Integer salary, User user) {
        this.id = id;
        this.educationLevel = educationLevel;
        this.position = position;
        this.salary = salary;
        this.user = user;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
