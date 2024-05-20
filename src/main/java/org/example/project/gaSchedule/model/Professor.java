package org.example.project.gaSchedule.model;

import java.util.ArrayList;
import java.util.List;

// Stores data about professor
public class Professor
{
    // Initializes professor data
    public Professor(int id, String name)  {
        Id = id;
        Name = name;
        CourseClasses = new ArrayList<CourseClass>();
    }

    // Bind professor to course
    public void addCourseClass(CourseClass courseClass)
    {
        CourseClasses.add(courseClass);
    }    

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (Id != other.Id)
			return false;
		return true;
	}

    public int Id;
    public String Name;


	// Trả về tham chiếu đến danh sách các lớp mà giáo viên dạy
    public List<CourseClass> CourseClasses;

}
