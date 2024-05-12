package org.example.project.service;


import org.example.project.dto.UserDto;
import org.example.project.model.User;

import java.util.List;

public interface UserService {
	
	User save (UserDto userDto);

	User findById(Long id);
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

}
