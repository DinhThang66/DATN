package org.example.project.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.project.model.*;
import org.example.project.service.UserService;
import org.example.project.service.course.CourseService;
import org.example.project.service.dept.DeptService;
import org.example.project.service.lecturer.LecturerService;
import org.example.project.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    // Department ===========================

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept_management")
    public String dept_management(Model model, @Param("keyword") String keyword,
                                  @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
        Page<Department> list = this.deptService.getAll(pageNo);
        /*
          if (keyword != null){
            list = this.deptService.searchDept(keyword);
        }

         */

        model.addAttribute("list", list);

        Department department = new Department();   
        model.addAttribute("department", department);


        model.addAttribute("totalPage", list.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        return "admin_pages/manage/dept_management";
    }

    @PostMapping("/add_dept")
    public String save_dept(@ModelAttribute("department") Department department) {
        if (this.deptService.create(department)) {
            return "redirect:/dept_management";
        }
        return "admin_pages/manage/dept_management";
    }

    @GetMapping("/edit_dept_{id}")
    public String edit_dept(Model model, @PathVariable Long id) {
        Department department = this.deptService.findById(id);
        model.addAttribute("e_department", department);

        return "admin_pages/edit_manage/edit_dept";
    }

    @PostMapping("/edit_dept")
    public String update_dept(@ModelAttribute("department") Department department) {
        if (this.deptService.update(department)) {
            return "redirect:/dept_management";
        }
        return "admin_pages/manage/dept_management";
    }

    @GetMapping("/delete_dept_{id}")
    public String delete_dept(@PathVariable("id") Long id) {
        if (this.deptService.delete(id))
            return "redirect:/dept_management";
        return "redirect:/dept_management";
    }

    // Course ===========================
    @Autowired
    private CourseService courseService;

    @GetMapping("course_management")
    public String course_management (Model model,  @Param("keyword_id") String keyword_id ,@Param("keyword_name") String keyword_name,
                                     @Param("keyword_dept") Long keyword_dept) {
        List<Course> list = this.courseService.getAll();

        if (keyword_id != null){
            list = this.courseService.searchCourseById(keyword_id);
        }
        if (keyword_name != null){
            list = this.courseService.searchCourseByName(keyword_name);
        }
        model.addAttribute("list", list);
        if (keyword_dept != null && keyword_dept != 0){
            list = this.courseService.searchCourseByDept(keyword_dept);
        }
        model.addAttribute("list", list);

        List<Department> list1 = this.deptService.getAll();
        model.addAttribute("list1", list1);



        Course course = new Course();
        model.addAttribute("course", course);
        return "admin_pages/manage/course_management";
    }

    @PostMapping("/add_course")
    public String save_course(@ModelAttribute("course") Course course) {
        if (this.courseService.create(course)) {
            return "redirect:/course_management";
        }
        return "admin_pages/manage/course_management";
    }

    @GetMapping("/edit_course_{id}")
    public String edit_course(Model model, @PathVariable Long id) {
        Course course = this.courseService.findById(id);
        model.addAttribute("course", course);

        List<Department> list1 = this.deptService.getAll();
        model.addAttribute("list1", list1);

        return "admin_pages/edit_manage/edit_course";
    }

    @PostMapping("/edit_course")
    public String update_course( @ModelAttribute("course") Course course) {
        if (this.courseService.update(course)) {
            return "redirect:/course_management";
        }
        return "admin_pages/manage/course_management";
    }

    @GetMapping("/delete_course_{id}")
    public String delete_course(@PathVariable("id") Long id) {
        if (this.courseService.delete(id))
            return "redirect:/course_management";
        return "redirect:/course_management";
    }

    // Student ===========================

    @GetMapping("/student_management")
    public String student_management (Model model, Principal principal) {
        List<Department> list = this.deptService.getAll();
        List<Map.Entry<Department, Integer>> mergedList = new ArrayList<>();

        // Ghép thông tin từ list1 và số lượng bằng cách sử dụng Map.Entry
        for (Department department : list ) {
            int id = this.userService.numberOfStudentsInDept(department.getId());
            Map.Entry<Department, Integer> entry = new AbstractMap.SimpleEntry<>(department, id);
            mergedList.add(entry);
        }

        model.addAttribute("list",  mergedList);

        return "admin_pages/manage/student_management";
    }

    // List Student ===========================

    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/list_student_{id}")
    public String list_student (Model model, @PathVariable("id") Long id,
                                @Param("keyword_id") Long keyword_id,
                                @Param("keyword_name") String keyword_name ) {
        List<User> list = this.userService.findAllByStudentInDept(id);
        if (keyword_id != null){
            list = this.userService.searchStudentByIdAndDeptId(keyword_id, id);
        }
        //if (keyword_name != null){
        //    list = this.userService.searchStudentByName(keyword_name);
        //}
        model.addAttribute("list", list);

        User user = new User();
        model.addAttribute("user", user);

        Student student = new Student(user.getId(), null, null, null, null);
        model.addAttribute("student", student);

        List<Department> list1 = this.deptService.getAll();
        model.addAttribute("list1", list1);

        return "admin_pages/list_student";
    }

    @PostMapping("/add_student")
    public String save_student(@ModelAttribute("student") User user,
                               @Param("educationLevel") String educationLevel ,
                               @Param("educationProgram") String educationProgram,
                               @Param("className") String className,
                               HttpServletRequest request) {

        user.setRole("student");

        if (this.userService.update(user)) {
            Student student = new Student(user.getId(), educationLevel, educationProgram, className, null);
            String referer = request.getHeader("Referer");

            String email = convertToUsername(user.getFullname()) + "." + user.getId().toString() + "@gmail.com";
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode("2002"));


            if (this.studentService.update(student))
                if (referer != null) {
                    // Chuyển hướng đến URL trước đó
                    return "redirect:" + referer;
                }
        }
        return "admin_pages/list_student";
    }

    @GetMapping("/edit_student_{id}")
    public String edit_student(Model model, @PathVariable Long id) {
        User user = this.userService.findById(id);
        model.addAttribute("user", user);

        List<Department> list1 = this.deptService.getAll();
        model.addAttribute("list1", list1);

        return "admin_pages/edit_manage/edit_student";
    }

    @PostMapping("/edit_student")
    public String update_student(@ModelAttribute("user") User user, @Param("educationLevel") String educationLevel ,
                                 @Param("educationProgram") String educationProgram, @Param("className") String className) {

        Student student = new Student(user.getId(), educationLevel, educationProgram, className, null);
        if (this.userService.update(user)) {
            if (this.studentService.update(student))
                return "redirect:/list_student_" + user.getDepartment().getId();
        }
        return "admin_pages/list_student";
    }

    @GetMapping("/delete_student_{id}")
    public String delete_student(@PathVariable("id") Long id, HttpServletRequest request) {
        User user = this.userService.findById(id);
        String referer = request.getHeader("Referer");
        if (this.userService.delete(id))
            return "redirect:/list_student_" + user.getDepartment().getId();
        return "admin_pages/list_student";
    }

    // Lecturer ===========================
    @GetMapping("/lecturer_management")
    public String lecturer_management (Model model, Principal principal) {
        List<Department> list = this.deptService.getAll();
        List<Map.Entry<Department, Integer>> mergedList = new ArrayList<>();

        // Ghép thông tin từ list1 và số lượng bằng cách sử dụng Map.Entry
        for (Department department : list ) {
            int id = this.userService.numberOfStudentsInLecturer(department.getId());
            Map.Entry<Department, Integer> entry = new AbstractMap.SimpleEntry<>(department, id);
            mergedList.add(entry);
        }

        model.addAttribute("list",  mergedList);

        return "admin_pages/manage/lecturer_management";
    }

    // List Student ===========================

    @Autowired
    private LecturerService lecturerService;

    @GetMapping("/list_lecturer_{id}")
    public String list_lecturer (Model model, @PathVariable("id") Long id) {

        List<User> list = this.userService.findAllByLecturerInDept(id);
        model.addAttribute("list", list);

        User user = new User();
        model.addAttribute("user", user);

        Lecturer lecturer = new Lecturer();
        model.addAttribute("lecturer", lecturer);

        List<Department> list1 = this.deptService.getAll();
        model.addAttribute("list1", list1);

        return "admin_pages/list_lecturer";
    }

    @PostMapping("/add_lecturer")
    public String save_lecturer(@ModelAttribute("user") User user,
                                @Param("educationLevel") String educationLevel ,
                                @Param("position") String position,
                                @Param("salary") Integer salary,
                                HttpServletRequest request) {
        user.setRole("lecturer");

        if (this.userService.update(user)) {
            Lecturer lecturer = new Lecturer(user.getId(), educationLevel, position,salary, null);
            String referer = request.getHeader("Referer");

            String email = convertToUsername(user.getFullname()) + "." + user.getId().toString() + "@gmail.com";
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode("2002"));

            if (this.lecturerService.update(lecturer))
                if (referer != null) {
                    // Chuyển hướng đến URL trước đó
                    return "redirect:" + referer;
                }

        }
        return "admin_pages/list_student";
    }

    @GetMapping("/edit_lecturer_{id}")
    public String edit_lecturer(Model model, @PathVariable Long id) {
        User user = this.userService.findById(id);
        model.addAttribute("user", user);

        List<Department> list1 = this.deptService.getAll();
        model.addAttribute("list1", list1);

        return "admin_pages/edit_manage/edit_test";
    }

    @PostMapping("/edit_lecturer")
    public String update_lecturer(@ModelAttribute("user") User user,
                                  @Param("educationLevel") String educationLevel ,
                                  @Param("position") String position,
                                  @Param("salary") Integer salary) {

        Lecturer lecturer = new Lecturer(user.getId(), null, null , null, null);
        if (this.userService.update(user)) {
            if (this.lecturerService.update(lecturer))
                return "redirect:/list_lecturer_" + user.getDepartment().getId();
        }
        return "redirect:/dept_management";
    }

    @GetMapping("/delete_lecturer_{id}")
    public String delete_lecturer(@PathVariable("id") Long id, HttpServletRequest request) {
        User user = this.userService.findById(id);
        String referer = request.getHeader("Referer");
        if (this.userService.delete(id))
            return "redirect:/list_lecturer_" + user.getDepartment().getId();
        return "admin_pages/list_lecturer";
    }


    // Func ===========================
    public static String convertToUsername(String name) {
        String normalized = java.text.Normalizer.normalize(name, java.text.Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase();

        String[] words = normalized.split("\\s+");

        StringBuilder username = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1) {
                username.append(words[i]); // chỉ lấy phần cuối cùng
            }
        }
        return username.toString();
    }
}
