package com.sa.csv.batch.controller;

import com.sa.csv.batch.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TriggerController {
    private final StudentService studentService;

    @GetMapping("/csv")
    public String triggerBatchProcess() {
        studentService.save();
        return "Hello World";
    }
}
