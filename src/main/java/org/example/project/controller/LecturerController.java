package org.example.project.controller;

import jakarta.servlet.http.HttpSession;
import org.example.project.model.CourseClass;
import org.example.project.model.Student;
import org.example.project.model.User;
import org.example.project.service.UserService;
import org.example.project.service.courseClass.CourseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

@Controller

public class LecturerController {

    @Autowired
    private UserService userService;
    @Autowired
    private CourseClassService courseClassService;
    @GetMapping("lecturer_page/schedule")
    public String profile (Model model, Principal principal, HttpSession session) {
        UserDetails userDetails = (UserDetails) session.getAttribute("user");
        String email = userDetails.getUsername();
        User user = this.userService.findByUserName(email);

        model.addAttribute("list", user.getLecturer().getClasses());


        return "lecturer_pages/schedule";
    }

    @GetMapping("lecturer_page/schedule/detailClass_{id}")
    public String detailClass (Model model, @PathVariable("id") Long id,
                               Principal principal, HttpSession session) {
        List<Student> list = this.courseClassService.getStudentsByClassId(id);
        model.addAttribute("list", list);

        CourseClass courseClass = this.courseClassService.findById(id);
        model.addAttribute("class", courseClass);
        return "lecturer_pages/detailClass";
    }
    @GetMapping("/")
    public String index(Model model) {
        String x = "dinh van thang";
        model.addAttribute("userName", x);
        model.addAttribute("userEmail", "markDavis@gmail.com");
        return "fragments/navbar";
    }


    @GetMapping("/admin_page/test")
    public String index1(Model model) {

        return "admin_pages/index1";
    }

    @GetMapping("/admin_page/had")
    public String index2(Model model) {

        return "admin_pages/test";
    }
}
