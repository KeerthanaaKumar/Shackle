package com.example.attendancesystem.controller;

import com.example.attendancesystem.entity.Student;
import com.example.attendancesystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/class/{classId}")
    public List<Student> getStudentsByClass(@PathVariable Long classId) {
        return studentRepository.findByClassEntityId(classId);
    }

    @GetMapping("/me/{userId}")
    public Student getMyDetails(@PathVariable Long userId) {
        return studentRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}