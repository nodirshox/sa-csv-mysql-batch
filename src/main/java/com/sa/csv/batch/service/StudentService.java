package com.sa.csv.batch.service;

import com.sa.csv.batch.entity.Student;
import java.util.List;

public interface StudentService {
    void load();
    List<Student> getAll();
}
