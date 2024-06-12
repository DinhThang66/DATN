package org.example.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class DataController {
    @PostMapping("/saveLabeledImages")
    public String saveLabeledImages(@RequestBody String json) {
        // Xử lý dữ liệu JSON được gửi đến ở đây và lưu trữ nó
        // Trả về một thông báo xác nhận hoặc mã trạng thái HTTP tùy thuộc vào kết quả xử lý
        return "File JSON đã được lưu trữ thành công.";
    }
}
