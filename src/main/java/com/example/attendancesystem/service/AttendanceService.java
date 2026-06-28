package com.example.attendancesystem.service;

import com.example.attendancesystem.entity.Attendance;
import com.example.attendancesystem.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public double calculateAttendancePercentage(Long studentId, Long subjectId) {
        List<Attendance> records = attendanceRepository.findByStudentIdAndSubjectId(studentId, subjectId);

        if (records.isEmpty()) {
            return 0.0;
        }

        long presentCount = records.stream()
                .filter(r -> r.getStatus() == Attendance.Status.PRESENT)
                .count();

        return (presentCount * 100.0) / records.size();
    }

    public boolean isBelowAttendanceThreshold(Long studentId, Long subjectId) {
        return calculateAttendancePercentage(studentId, subjectId) < 75.0;
    }
}