package org.example.project.model;

import java.util.List;

public class UploadRequest {

    private List<Float> descriptor;
    private Long userId;

    public UploadRequest(List<Float> descriptor, Long userId) {
        this.descriptor = descriptor;
        this.userId = userId;
    }

// Getters và Setters

    public List<Float> getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(List<Float> descriptor) {
        this.descriptor = descriptor;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
