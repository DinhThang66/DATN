package org.example.project.controller;

import jakarta.servlet.http.HttpSession;
import org.example.project.model.User;
import org.example.project.service.UserService;
import org.example.project.service.dept.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class StudentController {
    @Autowired
    private UserService userService;
    @GetMapping("student_page/schedule")
    public String profile (Model model, Principal principal, HttpSession session) {
        UserDetails userDetails = (UserDetails) session.getAttribute("user");
        String email = userDetails.getUsername();
        User user = this.userService.findByUserName(email);

        model.addAttribute("list", user.getStudent().getClasses());

        return "student_pages/schedule";
    }
}
