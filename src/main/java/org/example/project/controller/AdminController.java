package org.example.project.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.project.gaSchedule.HtmlOutput;
import org.example.project.gaSchedule.algorithm.Cso;
import org.example.project.gaSchedule.model.Configuration;
import org.example.project.gaSchedule.model.Reservation;
import org.example.project.gaSchedule.model.Room;
import org.example.project.gaSchedule.model.Schedule;
import org.example.project.model.*;
import org.example.project.model.CourseClass;
import org.example.project.model.Image;
import org.example.project.service.UserService;
import org.example.project.service.courseClass.CourseClassService;
import org.example.project.service.course.CourseService;
import org.example.project.service.dept.DeptService;
import org.example.project.service.image.ImageService;
import org.example.project.service.lecturer.LecturerService;
import org.example.project.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.*;
import java.security.Principal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

@Controller
public class AdminController {

    // Department ===========================

    @Autowired
    private DeptService deptService;


    @GetMapping("admin_page/dept_management")
    public String dept_management(Model model, @Param("keyword") String keyword,
                                  @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
        Page<Department> list = this.deptService.getAll(pageNo);

        if (keyword != null) {
            list = this.deptService.searchDept(keyword, pageNo);
            model.addAttribute("keyword", keyword);
        }


        model.addAttribute("list", list);

        Department department = new Department();
        model.addAttribute("department", department);


        model.addAttribute("totalPage", list.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        return "admin_pages/manage/dept_management";
    }

    @PostMapping("/add_dept")
    public String save_dept(@ModelAttribute("department") Department department, HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        if (this.deptService.create(department)) {
            return "redirect:" + referer;
        }
        return "admin_pages/manage/dept_management";
    }

    @GetMapping("admin_page/dept_management/edit_dept={id}")
    public String edit_dept(Model model, @PathVariable Long id, HttpServletRequest request) {
        Department department = this.deptService.findById(id);
        model.addAttribute("e_department", department);

        // Lưu URL của trang trước đó vào session
        String referer = request.getHeader("Referer");
        request.getSession().setAttribute("previousPage_dept", referer);

        return "admin_pages/edit_manage/edit_dept";
    }

    @PostMapping("/edit_dept")
    public String update_dept(@ModelAttribute("department") Department department, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String previousPage = (String) session.getAttribute("previousPage_dept");

        if (this.deptService.update(department)) {
            //session.removeAttribute("previousPage");
            return "redirect:" + (previousPage != null ? previousPage : "/dept_management");
            //return "redirect:/dept_management";
        }
        return "admin_pages/manage/dept_management";
    }

    @GetMapping("/delete_dept_{id}")
    public String delete_dept(@PathVariable("id") Long id, HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        if (this.deptService.delete(id)) {
            return "redirect:" + referer;
        }
        return "redirect:" + referer;
    }

    // Course ===========================
    @Autowired
    private CourseService courseService;

    @GetMapping("admin_page/course_management")
    public String course_management(Model model, @Param("keyword_id") String keyword_id, @Param("keyword_name") String keyword_name,
                                    @Param("keyword_dept") Long keyword_dept,
                                    @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
        Page<Course> list = this.courseService.getAll(pageNo);


        if (keyword_name != null) {
            list = this.courseService.searchDept(keyword_dept, keyword_id, keyword_name, pageNo);
            model.addAttribute("keyword_name", keyword_name);
        }


        model.addAttribute("list", list);
        model.addAttribute("totalPage", list.getTotalPages());
        model.addAttribute("currentPage", pageNo);

        List<Department> list1 = this.deptService.getAll();
        model.addAttribute("list1", list1);


        Course course = new Course();
        model.addAttribute("course", course);
        return "admin_pages/manage/course_management";
    }

    @PostMapping("/add_course")
    public String save_course(@ModelAttribute("course") Course course, HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        if (this.courseService.create(course)) {
            return "redirect:" + referer;
        }
        return "admin_pages/manage/course_management";
    }

    @GetMapping("admin_page/course_management/edit_courseId={id}")
    public String edit_course(Model model, @PathVariable Long id, HttpServletRequest request) {
        Course course = this.courseService.findById(id);
        model.addAttribute("course", course);

        List<Department> list1 = this.deptService.getAll();
        model.addAttribute("list1", list1);

        // Lưu URL của trang trước đó vào session
        String referer = request.getHeader("Referer");
        request.getSession().setAttribute("previousPage_course", referer);

        return "admin_pages/edit_manage/edit_course";
    }

    @PostMapping("/edit_course")
    public String update_course(@ModelAttribute("course") Course course, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String previousPage = (String) session.getAttribute("previousPage_course");
        if (this.courseService.update(course)) {
            return "redirect:" + (previousPage != null ? previousPage : "/course_management");
        }
        return "admin_pages/manage/course_management";
    }

    @GetMapping("/delete_course_{id}")
    public String delete_course(@PathVariable("id") Long id, HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        if (this.courseService.delete(id))
            return "redirect:" + referer;
        return "redirect:/course_management";
    }

    // Student ===========================

    @GetMapping("admin_page/student_management")
    public String student_management(Model model, Principal principal) {
        List<Department> list = this.deptService.getAll();
        List<Map.Entry<Department, Integer>> mergedList = new ArrayList<>();

        // Ghép thông tin từ list1 và số lượng bằng cách sử dụng Map.Entry
        for (Department department : list) {
            int id = this.userService.numberOfStudentsInDept(department.getId());
            Map.Entry<Department, Integer> entry = new AbstractMap.SimpleEntry<>(department, id);
            mergedList.add(entry);
        }

        model.addAttribute("list", mergedList);

        return "admin_pages/manage/student_management";
    }

    // List Student ===========================

    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ImageService imageService;

    @GetMapping("/admin_page/student_management/list_student_{id}")
    public String list_student(Model model, @PathVariable("id") Long id,
                               @Param("keyword_id") Long keyword_id,
                               @Param("keyword_name") String keyword_name,
                               @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
        Page<User> list = this.userService.getAllByStudentInDept(id, pageNo);


        if (keyword_id != null || (keyword_name != null && keyword_name.isEmpty())) {
            list = this.userService.getStudent(id, keyword_id, keyword_name, pageNo);
        }


        model.addAttribute("list", list);
        model.addAttribute("totalPage", list.getTotalPages());
        model.addAttribute("currentPage", pageNo);

        User user = new User();
        model.addAttribute("user", user);

        Student student = new Student(user.getId(), null, null, null, null);
        model.addAttribute("student", student);

        List<Department> list1 = this.deptService.getAll();
        model.addAttribute("list1", list1);

        Department department = this.deptService.findById(id);
        model.addAttribute("nameDept", department.getName());

        return "admin_pages/list_student";
    }


    @PostMapping("/add_student")
    public String save_student(@ModelAttribute("student") User user,
                               @Param("educationLevel") String educationLevel,
                               @Param("educationProgram") String educationProgram,
                               @Param("className") String className,
                               @RequestParam("image_path") MultipartFile file,
                               HttpServletRequest request) throws IOException, SQLException {

        user.setRole("student");

        if (this.userService.update(user)) {
            Student student = new Student(user.getId(), educationLevel, educationProgram, className, null);
            String referer = request.getHeader("Referer");

            String email = convertToUsername(user.getFullname()) + "." + user.getId().toString() + "@gmail.com";
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode("2002"));

            if (file != null) {
                byte[] bytes = file.getBytes();
                Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
                Image image = new Image(user.getId(), blob, null);
                if (this.imageService.create(image)) {

                }
            }


            if (this.studentService.update(student))
                if (referer != null) {
                    // Chuyển hướng đến URL trước đó
                    return "redirect:" + referer;
                }
        }
        return "admin_pages/list_student";
    }

    @GetMapping("admin_page/student_management/edit_studentId={id}")
    public String edit_student(Model model, @PathVariable Long id, HttpServletRequest request) throws SQLException {
        User user = this.userService.findById(id);
        model.addAttribute("user", user);

        List<Department> list1 = this.deptService.getAll();
        model.addAttribute("list1", list1);

        // Lưu URL của trang trước đó vào session
        String referer = request.getHeader("Referer");
        request.getSession().setAttribute("previousPage_student", referer);


        return "admin_pages/edit_manage/edit_student";
    }

    // display image
    @GetMapping("/display")
    public ResponseEntity<byte[]> displayImage(@RequestParam("id") long id) throws IOException, SQLException {
        User user = this.userService.findById(id);
        byte[] imageBytes = null;
        Blob image = user.getImage().getImageData();
        imageBytes = image.getBytes(1, (int) image.length());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }

    @PostMapping("/edit_student")
    public String update_student(@ModelAttribute("user") User user, @Param("educationLevel") String educationLevel,
                                 @Param("educationProgram") String educationProgram, @Param("className") String className,
                                 @RequestParam("imagePath") MultipartFile file, HttpServletRequest request) throws IOException, SQLException {
        HttpSession session = request.getSession();
        String previousPage = (String) session.getAttribute("previousPage_student");
        Student student = new Student(user.getId(), educationLevel, educationProgram, className, null);

        if (file != null) {
            byte[] bytes = file.getBytes();
            Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
            Image image = new Image(user.getId(), blob, null);
            if (this.imageService.create(image)) {

            }
        }

        if (this.userService.update(user)) {
            if (this.studentService.update(student))
                return "redirect:" + (previousPage != null ? previousPage : "/list_student_" + user.getDepartment().getId());
        }
        return "admin_pages/list_student";
    }

    @GetMapping("/delete_student_{id}")
    public String delete_student(@PathVariable("id") Long id, HttpServletRequest request) {
        User user = this.userService.findById(id);
        String referer = request.getHeader("Referer");
        if (this.userService.delete(id))
            return "redirect:" + (referer != null ? referer : "/list_student_" + user.getDepartment().getId());
        return "admin_pages/list_student";
    }


    // Lecturer ===========================
    @GetMapping("admin_page/lecturer_management")
    public String lecturer_management(Model model, Principal principal) {
        List<Department> list = this.deptService.getAll();
        List<Map.Entry<Department, Integer>> mergedList = new ArrayList<>();

        // Ghép thông tin từ list1 và số lượng bằng cách sử dụng Map.Entry
        for (Department department : list) {
            int id = this.userService.numberOfStudentsInLecturer(department.getId());
            Map.Entry<Department, Integer> entry = new AbstractMap.SimpleEntry<>(department, id);
            mergedList.add(entry);
        }

        model.addAttribute("list", mergedList);

        return "admin_pages/manage/lecturer_management";
    }

    // List Student ===========================

    @Autowired
    private LecturerService lecturerService;

    @GetMapping("admin_page/lecturer_management/list_lecturer_{id}")
    public String list_lecturer(Model model, @PathVariable("id") Long id,
                                @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {

        //List<User> list = this.userService.findAllByLecturerInDept(id);
        Page<User> list = this.userService.getAllByLecturerInDept(id, pageNo);
        model.addAttribute("list", list);
        model.addAttribute("totalPage", list.getTotalPages());
        model.addAttribute("currentPage", pageNo);

        User user = new User();
        model.addAttribute("user", user);

        Lecturer lecturer = new Lecturer();
        model.addAttribute("lecturer", lecturer);

        List<Department> list1 = this.deptService.getAll();
        model.addAttribute("list1", list1);

        Department department = this.deptService.findById(id);
        model.addAttribute("nameDept", department.getName());

        return "admin_pages/list_lecturer";
    }

    @PostMapping("/add_lecturer")
    public String save_lecturer(@ModelAttribute("user") User user,
                                @Param("educationLevel") String educationLevel,
                                @Param("position") String position,
                                @Param("salary") Integer salary,
                                @RequestParam("image_path") MultipartFile file,
                                HttpServletRequest request) throws SQLException, IOException {
        user.setRole("lecturer");
        String referer = request.getHeader("Referer");

        if (this.userService.update(user)) {
            Lecturer lecturer = new Lecturer(user.getId(), educationLevel, position, salary, null);
            String email = convertToUsername(user.getFullname()) + "." + user.getId().toString() + "@gmail.com";
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode("2002"));

            if (file != null) {
                byte[] bytes = file.getBytes();
                Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
                Image image = new Image(user.getId(), blob, null);
                if (this.imageService.create(image)) {

                }
            }

            if (this.lecturerService.update(lecturer))
                if (referer != null) {
                    // Chuyển hướng đến URL trước đó
                    return "redirect:" + referer;
                }

        }
        return "admin_pages/list_student";
    }

    @GetMapping("admin_page/lecturer_management/edit_lecturerId={id}")
    public String edit_lecturer(Model model, @PathVariable Long id, HttpServletRequest request) {
        User user = this.userService.findById(id);
        model.addAttribute("user", user);

        List<Department> list1 = this.deptService.getAll();
        model.addAttribute("list1", list1);


        // Lưu URL của trang trước đó vào session
        String referer = request.getHeader("Referer");
        request.getSession().setAttribute("previousPage_lecturer", referer);

        return "admin_pages/edit_manage/edit_lecturer";
    }

    @PostMapping("/edit_lecturer")
    public String update_lecturer(@ModelAttribute("user") User user,
                                  @Param("educationLevel") String educationLevel,
                                  @Param("position") String position,
                                  @Param("salary") Integer salary,
                                  @RequestParam("imagePath") MultipartFile file, HttpServletRequest request) throws IOException, SQLException {

        HttpSession session = request.getSession();
        String previousPage = (String) session.getAttribute("previousPage_lecturer");
        Lecturer lecturer = new Lecturer(user.getId(), educationLevel, position, salary, null);

        if (file != null) {
            byte[] bytes = file.getBytes();
            Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
            Image image = new Image(user.getId(), blob, null);
            if (this.imageService.create(image)) {

            }
        }

        if (this.userService.update(user)) {
            if (this.lecturerService.update(lecturer))
                return "redirect:" + (previousPage != null ? previousPage : "/list_lecturer_" + user.getDepartment().getId());
        }
        return "admin_pages/list_lecturer";
    }

    @GetMapping("/delete_lecturer_{id}")
    public String delete_lecturer(@PathVariable("id") Long id, HttpServletRequest request) {
        User user = this.userService.findById(id);
        String referer = request.getHeader("Referer");
        if (this.userService.delete(id))
            return "redirect:" + referer;
        return "admin_pages/list_lecturer";
    }


    // Class ===========================

    @Autowired
    private CourseClassService courseClassService;

    @GetMapping("admin_page/class_management")
    public String class_management(Model model, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
        //List<CourseClass> list = this.courseClassService.getAll();
        Page<CourseClass> list = this.courseClassService.getAll(pageNo);
        model.addAttribute("list", list);
        model.addAttribute("totalPage", list.getTotalPages());
        model.addAttribute("currentPage", pageNo);

        List<Department> list1 = this.deptService.getAll();
        model.addAttribute("list1", list1);

        List<User> list2 = this.userService.findAllByLecturer();
        model.addAttribute("list2", list2);

        List<Course> list3 = this.courseService.getAll();
        model.addAttribute("list3", list3);

        CourseClass _Course_class = new CourseClass();
        model.addAttribute("class", _Course_class);


        return "admin_pages/manage/class_management";
    }

    @PostMapping("/add_class")
    public String save_class(@ModelAttribute("class") CourseClass _Course_class, HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        if (this.courseClassService.create(_Course_class)) {
            return "redirect:" + referer;

        }
        return "redirect:/class_management";
    }

    @GetMapping("admin_page/class_management/edit_classId={id}")
    public String edit_class(Model model, @PathVariable Long id, HttpServletRequest request) {
        CourseClass _Course_class = this.courseClassService.findById(id);
        model.addAttribute("class", _Course_class);

        List<User> list2 = this.userService.findAllByLecturer();
        model.addAttribute("list2", list2);

        List<Course> list3 = this.courseService.getAll();
        model.addAttribute("list3", list3);

        Set<Student> students = _Course_class.getStudents();
        model.addAttribute("list4", students);

        int index = 0;
        for (Student student : _Course_class.getStudents()) {
            index++;
        }
        model.addAttribute("numberOfStudents", index);

        // Lưu URL của trang trước đó vào session
        String referer = request.getHeader("Referer");
        request.getSession().setAttribute("previousPage_class", referer);


        return "admin_pages/edit_manage/edit_class";
    }

    @PostMapping("/edit_class")
    public String update_class(@ModelAttribute("class") CourseClass _Course_class, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String previousPage = (String) session.getAttribute("previousPage_class");
        if (this.courseClassService.create(_Course_class)) {
            return "redirect:" + (previousPage != null ? previousPage : "admin_pages/manage/class_management");

        }
        return "admin_pages/manage/class_management";
    }

    @GetMapping("/delete_class_{id}")
    public String delete_class(@PathVariable("id") Long id, HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        CourseClass _Course_class = this.courseClassService.findById(id);
        if (this.courseClassService.delete(id))
            return "redirect:" + referer;
        return "admin_pages/manage/class_management";
    }

    String[] WEEK_DAYS = {"Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6"};

    @GetMapping("/scheduled")
    public String scheduled( HttpServletRequest request) throws SQLException {
        final long startTime = System.currentTimeMillis();
        Configuration configuration = new Configuration();

        configuration.loadFromDatabase();
        Cso<Schedule> alg = new Cso<>(new Schedule(configuration), 2,
                2, 80, 3);

        alg.run(9999, 0.999);

        String htmlResult = HtmlOutput.getResult(alg.getResult());


        Map<org.example.project.gaSchedule.model.CourseClass, Integer> classes = alg.getResult().getClasses();

        for (org.example.project.gaSchedule.model.CourseClass cc : classes.keySet()) {
            // coordinate of time-space slot
            Reservation reservation = Reservation.getReservation(classes.get(cc));
            int dayId = reservation.getDay() + 1;
            int periodId = reservation.getTime() + 1;
            int roomId = reservation.getRoom();

            CourseClass courseClass = this.courseClassService.findById((long) cc.Id);

            Room room = alg.getResult().getConfiguration().getRoomById(roomId);
            courseClass.setRoom(room.Name);
            courseClass.setSchedule(WEEK_DAYS[dayId - 1] + " , " + String.valueOf(courseClass.getCourse().getSessionDuration())
                    + " tiết, bắt đầu từ kíp " + String.valueOf(periodId));

            if (this.courseClassService.create(courseClass)) {

            }


        }


        String tempFilePath = System.getProperty("java.io.tmpdir") + "GaSchedule.htm";
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFilePath)))) {
            writer.write(htmlResult);
            writer.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        double seconds = (System.currentTimeMillis() - startTime) / 1000.0;
        System.out.println(String.format("\nCompleted in %f secs.", seconds));
        try {
            Desktop.getDesktop().open(new File(tempFilePath));
        } catch (Exception ex) {
            // no application registered for html
        }

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
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
