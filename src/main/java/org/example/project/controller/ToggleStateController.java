package org.example.project.controller;

import org.example.project.service.toggleBtn.ToggleStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toggle")
public class ToggleStateController {
    @Autowired
    private ToggleStateService service;

    @GetMapping
    public boolean getState() {
        return service.getState();
    }

    @PostMapping("/save")
    public void saveState(@RequestBody boolean isToggled) {
        service.saveState(isToggled);
    }
}
