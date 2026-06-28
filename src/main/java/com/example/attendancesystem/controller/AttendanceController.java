package com.example.attendancesystem.controller;

import com.example.attendancesystem.entity.Attendance;
import com.example.attendancesystem.repository.AttendanceRepository;
import com.example.attendancesystem.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    public Attendance markAttendance(@RequestBody Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @GetMapping("/{studentId}/{subjectId}/percentage")
    public double getPercentage(@PathVariable Long studentId, @PathVariable Long subjectId) {
        return attendanceService.calculateAttendancePercentage(studentId, subjectId);
    }

    @GetMapping("/{studentId}/{subjectId}/flag")
    public boolean isFlagged(@PathVariable Long studentId, @PathVariable Long subjectId) {
        return attendanceService.isBelowAttendanceThreshold(studentId, subjectId);
    }
}