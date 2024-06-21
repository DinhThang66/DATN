package org.example.project.controller;

import jakarta.servlet.http.HttpSession;
import org.example.project.model.Course;
import org.example.project.model.CourseClass;
import org.example.project.model.Student;
import org.example.project.model.User;
import org.example.project.service.UserService;
import org.example.project.service.courseClass.CourseClassService;
import org.example.project.service.dept.DeptService;
import org.example.project.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class StudentController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private ToggleStateController toggleStateController;
    @Autowired
    private CourseClassService courseClassService;
    @Autowired
    private StudentService studentService;

    @GetMapping("student_page/schedule")
    public String profile(Model model, Principal principal, HttpSession session) {
        UserDetails userDetails = (UserDetails) session.getAttribute("user");
        String email = userDetails.getUsername();
        User user = this.userService.findByUserName(email);
        model.addAttribute("userParam", user);

        model.addAttribute("list", user.getStudent().getClasses());
        model.addAttribute("Open_class_registration", this.toggleStateController.getState());


        return "student_pages/schedule";
    }

    @GetMapping("student_page/profile")
    public String profile(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        User user = this.userService.findByUserName(userDetails.getUsername());
        model.addAttribute("userParam", user);

        model.addAttribute("Open_class_registration", this.toggleStateController.getState());


        return "student_pages/profile";
    }

    @GetMapping("student_page/classRegistration")
    public String classRegistration(Model model, Principal principal, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        User user = this.userService.findByUserName(userDetails.getUsername());
        model.addAttribute("userParam", user);

        model.addAttribute("Open_class_registration", this.toggleStateController.getState());

        Page<CourseClass> list = this.courseClassService.getAll(pageNo);
        model.addAttribute("list", list);
        model.addAttribute("totalPage", list.getTotalPages());
        model.addAttribute("currentPage", pageNo);

        Set<CourseClass> courseClasses = user.getStudent().getClasses();
        model.addAttribute("courseClasses", courseClasses);


        return "student_pages/classRegistration";
    }

    @GetMapping("/api/students")
    public Set<CourseClass> get(Principal principal) {
        // Đây chỉ là ví dụ. Bạn nên lấy dữ liệu từ cơ sở dữ liệu.
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        User user = this.userService.findByUserName(userDetails.getUsername());

        return user.getStudent().getClasses();
    }

    @PostMapping("/student_page/api/addStudentToClass")
    public ResponseEntity<String> addStudentToClass(@RequestParam("classId") Long classId, @RequestParam("studentId") Long studentId) {
        CourseClass courseClass = this.courseClassService.findById(classId);
        User user = this.userService.findById(studentId);
        Set<CourseClass> classes = user.getStudent().getClasses();


        try {
            Iterator<CourseClass> iterator = classes.iterator();
            boolean removed = false;
            while (iterator.hasNext()) {
                CourseClass item = iterator.next();
                if (item.getId().equals(classId)) {
                    iterator.remove();
                    removed = true;
                    this.courseClassService.deleteStudentFromClass(classId, studentId);
                    break;
                }
            }
            if (!removed) {
                this.courseClassService.addStudentToClass(classId, studentId);
            }
            return ResponseEntity.ok("Student added to class successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding student to class");
        }
    }

    boolean Check(CourseClass courseClass, Student student) {
        Set<CourseClass> classes = student.getClasses();
        List<Integer> numbers1 = extractNumbers(courseClass.getSchedule());
        if (courseClass.getRoom()==null|| courseClass.getSchedule()==null)
            return false;
        for (CourseClass item : classes) {
            if (item.getRoom()==null|| item.getSchedule()==null)
                return false;
            if (!Objects.equals(item.getRoom(), courseClass.getRoom()))
                return false;
            List<Integer> numbers2 = extractNumbers(item.getSchedule());
            if (!Objects.equals(numbers1.get(0), numbers2.get(0)))
                return false;
            int duration = numbers1.get(1);
            int startingFromPeriod = numbers1.get(2);
            while (duration!=0){
                for (int i =numbers2.get(2);i<numbers2.get(1)+numbers2.get(2);i++){
                    if(i==startingFromPeriod)
                        return false;
                }
                startingFromPeriod++;
                duration--;
            }
        }
        return true;
    }
    List<Integer> extractNumbers(String input){
        List<Integer> numbers = new ArrayList<>();

        // Sử dụng regex để tìm tất cả các số nguyên trong chuỗi đầu vào
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            // Lấy chuỗi số tìm được từ matcher
            String numberStr = matcher.group();

            // Chuyển đổi chuỗi số thành số nguyên và thêm vào danh sách numbers
            int number = Integer.parseInt(numberStr);
            numbers.add(number);
        }

        return numbers;
    }
}
