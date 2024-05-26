package org.example.project.controller;


import jakarta.servlet.http.HttpSession;
import org.example.project.dto.UserDto;
import org.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	
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
		return "admin_pages/index";
	}



	@GetMapping("/profile")
	public String profile (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "admin_pages/profile";
	}
	@GetMapping("student-page")
	public String studentPage (Model model, Principal principal, HttpSession session) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());

		model.addAttribute("user", userDetails);

		session.setAttribute("user", userDetails);


		return "student_pages/index";
	}

	@GetMapping("lecturer-page")
	public String lecturerPage (Model model, Principal principal, HttpSession session) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());

		model.addAttribute("user", userDetails);

		session.setAttribute("user", userDetails);


		return "lecturer_pages/index";
	}



}
