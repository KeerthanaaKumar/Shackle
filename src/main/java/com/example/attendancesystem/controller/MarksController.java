package com.example.attendancesystem.controller;

import com.example.attendancesystem.dto.FailingMarkDTO;
import com.example.attendancesystem.entity.Marks;
import com.example.attendancesystem.repository.MarksRepository;
import com.example.attendancesystem.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarksController {

    @Autowired
    private MarksRepository marksRepository;

    @Autowired
    private MarksService marksService;

    @PostMapping
    public Marks addMarks(@RequestBody Marks marks) {
        return marksRepository.save(marks);
    }

    @GetMapping("/student/{studentId}")
    public List<Marks> getMarksForStudent(@PathVariable Long studentId) {
        return marksService.getMarksForStudent(studentId);
    }

    @GetMapping("/student/{studentId}/failing")
    public List<FailingMarkDTO> getFailingMarks(@PathVariable Long studentId) {
        return marksService.getFailingMarksForStudent(studentId);
    }
}