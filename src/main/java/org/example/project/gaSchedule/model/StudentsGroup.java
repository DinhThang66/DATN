package org.example.project.gaSchedule.model;

import java.util.ArrayList;
import java.util.List;

// Stores data about student group
public class StudentsGroup
{
	public StudentsGroup(int id, String name, int numberOfStudents)
    {
		Id = id;
		Name = name;
		NumberOfStudents = numberOfStudents;
		CourseClasses = new ArrayList<CourseClass>();
	}

	// Bind group to class
	public void addClass(CourseClass courseClass)
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
		StudentsGroup other = (StudentsGroup) obj;
		if (Id != other.Id)
			return false;
		return true;
	}

    public int Id;
	public String Name;

	public int NumberOfStudents;


	// Trả về tham chiếu đến danh sách các lớp mà nhóm tham dự
	public List<CourseClass> CourseClasses;

}
