package com.sa.csv.batch.controller;

import com.sa.csv.batch.dto.ResponseDTO;
import com.sa.csv.batch.entity.Student;
import com.sa.csv.batch.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TriggerController {
    private final StudentService studentService;

    @GetMapping("/load-csv")
    public ResponseDTO triggerBatchProcess() {
        studentService.load();
        return new ResponseDTO("Success", true);
    }

    @GetMapping("/students")
    public List<Student> getAll() {
        return studentService.getAll();
    }
}
