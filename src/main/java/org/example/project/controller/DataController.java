package org.example.project.controller;

import lombok.extern.java.Log;
import org.example.project.model.*;
import org.example.project.service.UserService;
import org.example.project.service.courseClass.CourseClassService;
import org.example.project.service.image.ImageService;
import org.example.project.service.student.StudentService;
import org.example.project.service.studentAttendance.StudentAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@RestController
public class DataController {
    @Autowired
    private UserService userService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private CourseClassService courseClassService;
    @Autowired
    private StudentAttendanceService studentAttendanceService;

    @PostMapping("/saveLabeledImages")
    public String saveLabeledImages(@RequestBody String json) {
        // Xử lý dữ liệu JSON được gửi đến ở đây và lưu trữ nó
        // Trả về một thông báo xác nhận hoặc mã trạng thái HTTP tùy thuộc vào kết quả xử lý
        return "File JSON đã được lưu trữ thành công.";
    }

    @PostMapping("/getUserInfo")
    public Map<String, String> getUserInfo(@RequestBody Map<String, String> payload) {
        String userId = payload.get("userId");
        User user = this.userService.findById(Long.parseLong(userId));

        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("ID", user.getId().toString());
        userInfo.put("name", user.getFullname());
        userInfo.put("email", user.getEmail());

        return userInfo;
    }

    @PostMapping("/getDescriptor")
    public List<Map<String, Object>> getDescriptor() {
        List<Image> list = this.imageService.getAll();
        List<Map<String, Object>> descriptors = new ArrayList<>();


        for (Image image : list) {
            Map<String, Object> descriptor = new HashMap<>();
            Long label = image.getId();
            List<Float> description = image.getDescription();

            descriptor.put("userId", label);
            descriptor.put("descriptor", description);

            if (!description.isEmpty())
                descriptors.add(descriptor);
        }


        return descriptors;
    }

    @PostMapping("/submit_attendance")
    public ResponseEntity<String> submit_attendance(@RequestBody Map<String, Object> request) {
        Long classId = Long.valueOf(request.get("classId").toString());
        CourseClass courseClass = this.courseClassService.findById(classId);
        Set<StudentAttendance> studentAttendances = courseClass.getAttendances();
        // Lấy danh sách attendance từ request
        List<Map<String, Object>> attendanceList = (List<Map<String, Object>>) request.get("attendance");
        String date = (String) request.get("date");
        System.out.println("Descriptor: " + date);

        for (Map<String, Object> attendance : attendanceList) {
            Long studentId = Long.valueOf(attendance.get("id").toString());
            Student student = this.userService.findById(studentId).getStudent();
            Boolean attended = (Boolean) attendance.get("attended");

            StudentAttendance studentAttendance = new StudentAttendance(null, courseClass,student,attended,date);
            if (this.studentAttendanceService.update(studentAttendance)){}

        }

        return ResponseEntity.ok("Attendance submitted successfully!");
    }
}
