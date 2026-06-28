package com.example.attendancesystem.service;

import com.example.attendancesystem.dto.FailingMarkDTO;
import com.example.attendancesystem.entity.Marks;
import com.example.attendancesystem.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MarksService {

    @Autowired
    private MarksRepository marksRepository;

    public List<Marks> getMarksForStudent(Long studentId) {
        return marksRepository.findByStudentId(studentId);
    }

    public boolean isFailing(Marks mark) {
        return mark.getScore() < 40.0;
    }

    public List<FailingMarkDTO> getFailingMarksForStudent(Long studentId) {
        return getMarksForStudent(studentId).stream()
                .filter(this::isFailing)
                .map(mark -> new FailingMarkDTO(
                        mark.getId(),
                        mark.getStudent().getName(),
                        mark.getSubject().getName(),
                        mark.getExamType().name(),
                        mark.getScore()
                ))
                .toList();
    }
}