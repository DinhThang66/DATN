package org.example.project.model;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @Column(name = "user_id")
    private Long id;
    @Lob
    private Blob imageData;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, referencedColumnName = "id")
    private User user;

    public Image(Long id, Blob imageData, User user) {
        this.id = id;
        this.imageData = imageData;
        this.user = user;
    }
    public Image() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Blob getImageData() {
        return imageData;
    }

    public void setImageData(Blob imageData) {
        this.imageData = imageData;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
