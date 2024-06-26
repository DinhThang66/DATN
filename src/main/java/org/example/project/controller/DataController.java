package org.example.project.controller;

import lombok.extern.java.Log;
import org.example.project.model.User;
import org.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DataController {
    @Autowired
    private UserService userService;

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
}
