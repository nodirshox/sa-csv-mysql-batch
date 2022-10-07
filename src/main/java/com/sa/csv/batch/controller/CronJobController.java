package com.sa.csv.batch.controller;

import com.sa.csv.batch.model.Response;
import com.sa.csv.batch.entity.Student;
import com.sa.csv.batch.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/cron-job")
@RequiredArgsConstructor
public class CronJobController {
    private final StudentService studentService;

    @PostMapping("/start")
    public ResponseEntity<?> triggerBatchProcess() {
        studentService.load();
        var response = new Response("Job has been started", true);
        return ResponseEntity.accepted().body(response);
    }

    @GetMapping("/data")
    public ResponseEntity<?> getAll() {
        var response = new Response(studentService.getAll(), true);
        return ResponseEntity.ok().body(response);
    }
}
