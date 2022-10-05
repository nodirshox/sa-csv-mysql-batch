package com.sa.csv.batch.config;

import com.sa.csv.batch.entity.Student;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

import java.time.LocalDate;

public class StudentFieldSetMapper implements FieldSetMapper<Student> {
    @Override
    public Student mapFieldSet(FieldSet fieldSet) {
        Student student = new Student();
        student.setFirst(fieldSet.readString("first"));
        student.setLast(fieldSet.readString("last"));
        student.setGPA(fieldSet.readDouble("GPA"));
        student.setDOB(getDate(fieldSet.readInt("DOB")));
        return student;
    }
    private LocalDate getDate(int year) {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        return LocalDate.of(currentYear - year,1,1);
    }
}
