package com.sa.csv.batch.service.impl;

import com.sa.csv.batch.entity.Student;
import com.sa.csv.batch.repository.StudentRepository;
import com.sa.csv.batch.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public void save() {
        Student student = new Student();
        student.setFirst("John");
        student.setLast("Doe");
        student.setGPA(4.0);
        student.setDOB(LocalDateTime.now());
        studentRepository.save(student);
    }
}
