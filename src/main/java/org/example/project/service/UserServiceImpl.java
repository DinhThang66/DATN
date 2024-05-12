package org.example.project.service;


import org.example.project.dto.UserDto;
import org.example.project.model.User;
import org.example.project.repositories.StudentRepository;
import org.example.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public User save(UserDto userDto) {
		User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()) , userDto.getRole(), userDto.getFullname());
		return userRepository.save(user);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> findAllByStudent() {
		return userRepository.findAllByStudent();
	}

	@Override
	public List<User> findAllByStudentInDept(Long id) {
		return this.userRepository.findAllByStudentInDept(id);
	}

	@Override
	public Boolean update(User user) {
		try {
			this.userRepository.save(user);
			return true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean delete(Long id) {
		try {
			this.userRepository.delete(findById(id));
			return true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<User> searchStudentById(Long keyword) {
		return this.userRepository.searchStudentById(keyword);
	}

	@Override
	public List<User> searchStudentByName(String keyword) {
		return this.userRepository.searchStudentByName(keyword);
	}

	@Override
	public Integer numberOfStudentsInDept(Long id) {
		return this.userRepository.numberOfStudentsInDept(id);
	}

	@Override
	public Integer numberOfStudentsInLecturer(Long id) {
		return this.userRepository.numberOfStudentsInLecturer(id);
	}

	@Override
	public List<User> findAllByLecturerInDept(Long id) {
		return this.userRepository.findAllByLecturerInDept(id);
	}

	@Override
	public List<User> searchStudentByIdAndDeptId(Long keyword, Long keyword1) {
		return this.userRepository.searchStudentByIdAndDeptId(keyword, keyword1);
	}

}
