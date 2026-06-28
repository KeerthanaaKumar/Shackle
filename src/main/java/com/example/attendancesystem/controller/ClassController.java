package com.example.attendancesystem.controller;

import com.example.attendancesystem.entity.ClassEntity;
import com.example.attendancesystem.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassRepository classRepository;

    @PostMapping
    public ClassEntity createClass(@RequestBody ClassEntity classEntity) {
        return classRepository.save(classEntity);
    }

    @GetMapping
    public List<ClassEntity> getAllClasses() {
        return classRepository.findAll();
    }
}