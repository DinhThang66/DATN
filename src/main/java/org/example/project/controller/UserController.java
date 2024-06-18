package org.example.project.controller;


import jakarta.servlet.http.HttpSession;
import org.example.project.dto.UserDto;
import org.example.project.model.Department;
import org.example.project.model.User;
import org.example.project.service.UserService;
import org.example.project.service.course.CourseService;
import org.example.project.service.courseClass.CourseClassService;
import org.example.project.service.dept.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
	
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private CourseClassService courseClassService;
	
	
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "sign-up";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
		userService.save(userDto);
		model.addAttribute("message", "Registered Successfuly!");
		return "sign-up";
	}
	
	@GetMapping("/login")
	public String login() {
		return "sign-in";
	}

	@GetMapping("admin_page")
	public String adminPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		User user = this.userService.findByUserName(userDetails.getUsername());
		model.addAttribute("userParam", user);

		model.addAttribute("numberOfDepts", this.deptService.numberOfDepts());
		model.addAttribute("numberOfAllStudents", this.userService.numberOfAllStudents());
		model.addAttribute("numberOfAllLecturers", this.userService.numberOfAllLecturers());
		model.addAttribute("numberOfCourses", this.courseService.numberOfCourses());

		List<Department> list = this.deptService.getAll();
		List<Map.Entry<Department, Integer>> mergedList = new ArrayList<>();

		for (Department department : list) {
			int id = this.courseClassService.numberOfClassesInDept(department.getId());
			Map.Entry<Department, Integer> entry = new AbstractMap.SimpleEntry<>(department, id);
			mergedList.add(entry);
		}
		model.addAttribute("mergedList", mergedList);


		return "admin_pages/index";
	}



	@GetMapping("/profile")
	public String profile (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "admin_pages/profile";
	}
	@GetMapping("student_page")
	public String studentPage (Model model, Principal principal, HttpSession session) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		session.setAttribute("user", userDetails);


		return "student_pages/index";
	}

	@GetMapping("lecturer_page")
	public String lecturerPage (Model model, Principal principal, HttpSession session) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		session.setAttribute("user", userDetails);


		return "lecturer_pages/index";
	}



}
