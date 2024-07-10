package org.example.project.service;


import org.example.project.dto.UserDto;
import org.example.project.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
	
	User save (UserDto userDto);

	User findById(Long id);
	User findByUserName(String email);

	List<User> findAllByStudent();
	List<User> findAllByStudentInDept(Long id);
	Boolean update(User user);
	Boolean delete(Long id);
	List<User> searchStudentById(Long keyword);
	List<User> searchStudentByName(String keyword);
	Integer numberOfStudentsInDept(Long id);
	Integer numberOfStudentsInLecturer(Long id);
	List<User> findAllByLecturerInDept(Long id);
	List<User> searchStudentByIdAndDeptId(Long keyword, Long keyword1);
	List<User> findAllByLecturer();

	Page<User> getAllByStudentInDept(Long id, Integer pageNo);
	Page<User> getAllByLecturerInDept(Long id, Integer pageNo);

	List<User> getStudent(Long id, Long userId, String fullName);
	Page<User> getStudent(Long id, Long userId, String fullName, Integer pageNo);
	List<User> getLecturer(Long id, String fullName);
	Page<User> getLecturer(Long id, String fullName, Integer pageNo);
	Integer numberOfAllStudents();
	Integer numberOfAllLecturers();
}
