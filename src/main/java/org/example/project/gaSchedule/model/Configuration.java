package org.example.project.gaSchedule.model;

import org.example.project.service.course.CourseService;

import java.io.File;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import java.util.TreeMap;
class DatabaseUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/demo";
	private static final String USER = "root";
	private static final String PASSWORD = "thang2002";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}



// Đọc file cấu hình và lưu trữ các đối tượng được phân tích cú pháp
public class Configuration
{

	private Map<Integer, Professor> _professors;			// parsed professors
	private Map<Integer, StudentsGroup> _studentGroups;		// parsed student groups
	private Map<Integer, Course> _courses;					// parsed courses
	private Map<Integer, Room> _rooms;						// parsed rooms
	private List<CourseClass> _courseClasses;				// parsed classes

	// Cho biết cấu hình chưa được phân tích cú pháp
	private boolean _isEmpty;

	private static Random _random = new Random(System.currentTimeMillis());

	// Khởi tạo dữ liệu
	public Configuration()  {
		_isEmpty = true;
		_professors = new TreeMap<>();
		_studentGroups = new TreeMap<>();
		_courses = new TreeMap<>();
		_rooms = new TreeMap<>();
		_courseClasses = new ArrayList<>();
	}

	private Map<Integer, Professor> loadProfessors() throws SQLException{
		Map<Integer, Professor> professors = new TreeMap<>();
		/*
		professors.put(1, new Professor(1, "Victor"));
		professors.put(2, new Professor(2, "Red"));
		professors.put(3, new Professor(3, "Philip"));
		professors.put(4, new Professor(4, "Marry"));
		professors.put(5, new Professor(5, "Don"));
		professors.put(6, new Professor(6, "Mark"));
		professors.put(7, new Professor(7, "Peter"));
		professors.put(8, new Professor(8, "John"));
		professors.put(9, new Professor(9, "Ben"));
		professors.put(10, new Professor(10, "Mike"));
		professors.put(11, new Professor(11, "Steve"));
		professors.put(12, new Professor(12, "Ann"));
		professors.put(13, new Professor(13, "Alex"));


		 */
		String query = "SELECT id, fullname FROM users u where u.role = 'lecturer'";
		try (Connection conn = DatabaseUtil.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(query);
			 ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("fullname");
				professors.put(id, new Professor(id, name));
			}
		}


		return professors;
	}
	private Map<Integer, StudentsGroup> loadStudentsGroups() {
		Map<Integer, StudentsGroup> studentGroups = new TreeMap<>();
		studentGroups.put(1, new StudentsGroup(1, "1O1", 19));
		studentGroups.put(2, new StudentsGroup(2, "1O2", 19));
		studentGroups.put(3, new StudentsGroup(3, "1O3", 19));
		studentGroups.put(4, new StudentsGroup(4, "1S1", 19));

		return studentGroups;
	}

	private Map<Integer, Course> loadCourses() throws SQLException{
		Map<Integer, Course> courses = new TreeMap<>();
		/*
		courses.put(1, new Course(1, "Introduction to Programming"));
		courses.put(2, new Course(2, "Introduction to Computer Architecture"));
		courses.put(3, new Course(3, "Business Applications"));
		courses.put(4, new Course(4, "English"));
		courses.put(5, new Course(5, "Discrete Mathematic I"));
		courses.put(6, new Course(6, "Linear Algebra"));
		courses.put(7, new Course(7, "Introduction to Information Technology I"));
		courses.put(8, new Course(8, "System Administration and Maintenance I"));
		 */

		String query = "SELECT id, name, session_duration FROM course";

		try (Connection conn = DatabaseUtil.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(query);
			 ResultSet rs = stmt.executeQuery()) {

			int index = 1;
			while (rs.next()) {
				int id = rs.getInt("id");
				int session_duration = rs.getInt("session_duration");

				String name = rs.getString("name");
				courses.put(index++, new Course(id, name, session_duration));
			}
		}

		return courses;
	}

	private Map<Integer, Room> loadRooms() {
		Map<Integer, Room> rooms = new TreeMap<>();
		rooms.put(0, new Room("D5-101", false, 50));
		rooms.put(1, new Room("R6", true, 50));
		rooms.put(2, new Room("R7", true, 60));
		rooms.put(3, new Room("D5-102", true, 60));

		return rooms;
	}

	private List<CourseClass> loadCourseClasses() throws SQLException{
		List<CourseClass> courseClasses = new ArrayList<>();
		String query = "SELECT id, lecturer_id, course_id FROM class";
		try (Connection conn = DatabaseUtil.getConnection();
			 PreparedStatement stmt = conn.prepareStatement(query);
			 ResultSet rs = stmt.executeQuery()) {

			int index = 1;
			while (rs.next()) {
				long id = rs.getLong("id");

				long lecturer_id = rs.getLong("lecturer_id");
				long course_id = rs.getLong("course_id");
				List<StudentsGroup> groups = new ArrayList<>();
				groups.add(new StudentsGroup(index++, "", 19));
				courseClasses.add(new CourseClass((int) id,_professors.get((int) lecturer_id), _courses.get((int) course_id), false, _courses.get((int) course_id).Duration, groups.toArray(new StudentsGroup[0])));
			}
		}
		return courseClasses;
	}
	public void loadFromDatabase() throws SQLException{
		_professors.clear();
		_studentGroups.clear();
		_courses.clear();
		_rooms.clear();
		_courseClasses.clear();

		Room.restartIDs();
		CourseClass.restartIDs();

		_professors = loadProfessors();
		_studentGroups = loadStudentsGroups();
		_courses = loadCourses();
		_rooms = loadRooms();
		_courseClasses = loadCourseClasses();

		_isEmpty = false;
	}

	Professor getProfessorById(int id)		// Trả về ID giáo viên, nếu không có thì = null
	{
		if (!_professors.containsKey(id))
			return null;
		return _professors.get(id);
	}

	public int getNumberOfProfessors() { return _professors.size(); }	// Trả về số lượng giáo viên

	StudentsGroup getStudentsGroupById(Integer id)		// Trả về id của nhóm sinh viên
	{
		if (!_studentGroups.containsKey(id))
			return null;
		return _studentGroups.get(id);
	}

	public int getNumberOfStudentGroups() { return _studentGroups.size(); }	// Trả về số nhóm sinh viên

	Course getCourseById(int id)		// Trả về Id của khóa học
	{
		if (!_courses.containsKey(id))
			return null;
		return _courses.get(id);
	}
	public int getNumberOfCourses() { return _courses.size(); }

	public Room getRoomById(int id)		// Trả về Id của phòng
	{
		if (!_rooms.containsKey(id))
			return null;
		return _rooms.get(id);
	}

	public int getNumberOfRooms() { return _rooms.size(); }		// Số lượng phòng


	public List<CourseClass> getCourseClasses() { return _courseClasses; }	// Danh sách các lớp


	public int getNumberOfCourseClasses() { return _courseClasses.size(); }		// Số lớp

	public boolean isEmpty() { return _isEmpty; }		// Trả về True nếu cấu hình chưa được phân tích cú pháp

	public static int rand()
	{
		return _random.nextInt(32768);
	}

	public static double random()
	{
		return _random.nextDouble();
	}

	public static int rand(int size)
	{
		return _random.nextInt(size);
	}

	public static int rand(int min, int max)
	{
		return min + rand(max - min + 1);
	}

	public static double rand(double min, double max)
	{
		return min + _random.nextDouble() * (max - min);
	}

	public static void seed()
	{
		_random = new Random(System.currentTimeMillis());
	}
}