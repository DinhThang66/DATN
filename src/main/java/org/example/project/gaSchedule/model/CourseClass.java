package org.example.project.gaSchedule.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseClass implements Comparable<CourseClass>
{
    private static int _nextClassId = 0;
	public CourseClass(Professor professor, Course course, boolean requiresLab, int duration, StudentsGroup... groups)
    {
		Id = _nextClassId++;
		Professor = professor;
		Course = course;
		NumberOfSeats = 0;
		LabRequired = requiresLab;
		Duration = duration;
		Groups = new ArrayList<StudentsGroup>();

		// bind professor to class
		Professor.addCourseClass(this);

		// bind student groups to class
		for(StudentsGroup group : groups)
        {
			group.addClass(this);
			Groups.add(group);
			NumberOfSeats += group.NumberOfStudents;
		}
	}

	// Trả về TRUE nếu lớp khác có một hoặc các nhóm sinh viên chồng chéo.
	public boolean groupsOverlap(CourseClass c)
    {
		return !Collections.disjoint(Groups, c.Groups);
    }

	// Trả về TRUE nếu lớp khác có cùng giáo sư.
	public boolean professorOverlaps(CourseClass c) {
		return Professor.equals(c.Professor);
	}

    public int Id;
	public Professor Professor;
	public Course Course;
	public List<StudentsGroup> Groups;
	public int NumberOfSeats;		// số lượng chỗ ngồi yêu cầu
	public boolean LabRequired;		// Trả về TRUE nếu lớp yêu cầu có máy tính trong phòng.
	public int Duration;			// Trả về thời lượng của lớp tính bằng ca(kíp)


	// Khởi động lại việc gán ID
    public static void restartIDs() { _nextClassId = 0; }

	@Override
	public int compareTo(CourseClass that) {
		if(that == null)
			return -1;
	    return that.Id - Id;
	}
}

