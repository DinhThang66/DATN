package org.example.project.controller;

import jakarta.servlet.http.HttpSession;
import org.example.project.model.User;
import org.example.project.service.UserService;
import org.example.project.service.dept.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class StudentController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsService userDetailsService;
    @GetMapping("student_page/schedule")
    public String profile (Model model, Principal principal, HttpSession session) {
        UserDetails userDetails = (UserDetails) session.getAttribute("user");
        String email = userDetails.getUsername();
        User user = this.userService.findByUserName(email);
        model.addAttribute("userParam", user);

        model.addAttribute("list", user.getStudent().getClasses());

        return "student_pages/schedule";
    }

    @GetMapping("student_page/profile")
    public String profile (Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        User user = this.userService.findByUserName(userDetails.getUsername());
        model.addAttribute("userParam", user);

        return "student_pages/profile";
    }
}
