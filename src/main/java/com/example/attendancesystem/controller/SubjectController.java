package com.example.attendancesystem.controller;

import com.example.attendancesystem.entity.Subject;
import com.example.attendancesystem.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectRepository.save(subject);
    }

    @GetMapping("/teacher/{teacherId}")
    public List<Subject> getSubjectsByTeacher(@PathVariable Long teacherId) {
        return subjectRepository.findByTeacherId(teacherId);
    }
}