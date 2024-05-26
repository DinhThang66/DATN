package org.example.project.gaSchedule.model;

// Lưu trữ dữ liệu khóa học
public class Course
{
    // Initializes course
    public Course(int id, String name, int duration)
    {
        this.Id = id;
        this.Name = name;
        this.Duration = duration;
    }

    public int Id;
    public String Name;
    public int Duration;			// Trả về thời lượng của lớp tính bằng ca(kíp)

}
