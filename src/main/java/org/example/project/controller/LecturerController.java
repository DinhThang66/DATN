package org.example.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import org.example.project.model.*;
import org.example.project.service.UserService;
import org.example.project.service.courseClass.CourseClassService;
import org.example.project.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.*;

@Controller
public class LecturerController {

    @Autowired
    private UserService userService;
    @Autowired
    private CourseClassService courseClassService;
    @Autowired
    private UserDetailsService userDetailsService;
    @GetMapping("lecturer_page/schedule")
    public String profile (Model model, Principal principal, HttpSession session) {
        UserDetails userDetails = (UserDetails) session.getAttribute("user");
        String email = userDetails.getUsername();
        User user = this.userService.findByUserName(email);
        model.addAttribute("userParam", user);

        model.addAttribute("list", user.getLecturer().getClasses());


        return "lecturer_pages/schedule";
    }

    @GetMapping("lecturer_page/schedule/detailClass_{id}")
    public String detailClass (Model model, @PathVariable("id") Long id,
                               Principal principal, HttpSession session) {

        List<Student> list = this.courseClassService.getStudentsByClassId(id);
        //model.addAttribute("list", list);

        CourseClass courseClass = this.courseClassService.findById(id);
        model.addAttribute("class", courseClass);

        Set<StudentAttendance> studentAttendances = courseClass.getAttendances();
        Set<String> dateSet = new HashSet<>(); // Sử dụng Set để lưu trữ các date duy nhất
        for (StudentAttendance studentAttendance : studentAttendances){
            String date = studentAttendance.getDate();
            dateSet.add(date); // Thêm date vào Set
        }
        System.out.println(dateSet);


        List<Map<String, Object>> studentInfoList = new ArrayList<>();
        for (Student student : list) {
            Map<String, Object> studentInfo = new HashMap<>();

            studentInfo.put("studentName", student.getUser().getFullname());
            studentInfo.put("studentId", student.getId());


            List<Map<String, Object>> dateInfoList = new ArrayList<>();
            int counter = 0;
            for (String item:dateSet){
                Map<String, Object> dateInfo = new HashMap<>();
                for (StudentAttendance studentAttendance:studentAttendances){
                    if (Objects.equals(item, studentAttendance.getDate())
                            &&(Objects.equals(student.getId(), studentAttendance.getStudent().getId()))){
                        dateInfo.put(item, studentAttendance.getIsAttended());
                        if (!studentAttendance.getIsAttended()){
                            counter++;
                        }
                    }
                }
                dateInfoList.add(dateInfo);
            }
            studentInfo.put("date", dateInfoList);
            studentInfo.put("absent", counter);

            studentInfoList.add(studentInfo);
        }
        System.out.println(studentInfoList);
        model.addAttribute("list", studentInfoList);


        //++++
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        User user = this.userService.findByUserName(userDetails.getUsername());
        model.addAttribute("userParam", user);



        return "lecturer_pages/detailClass";
    }

    @GetMapping("lecturer_page/profile")
    public String profile (Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        User user = this.userService.findByUserName(userDetails.getUsername());
        model.addAttribute("userParam", user);

        return "lecturer_pages/profile";
    }





    @GetMapping("/")
    public String index(Model model) {
        String x = "dinh van thang";
        model.addAttribute("userName", x);
        model.addAttribute("userEmail", "markDavis@gmail.com");
        return "fragments/navbar";
    }

    @Autowired
    private ImageService imageService;
    @GetMapping("/admin_page/test")
    public String index1(Model model) {



        return "admin_pages/index1";
    }
}
