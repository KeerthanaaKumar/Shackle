package com.example.attendancesystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FailingMarkDTO {
    private Long marksId;
    private String studentName;
    private String subjectName;
    private String examType;
    private Double score;
}