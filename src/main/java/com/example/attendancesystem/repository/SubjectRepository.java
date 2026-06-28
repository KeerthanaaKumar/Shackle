package com.example.attendancesystem.repository;

import com.example.attendancesystem.entity.Subject;
import com.example.attendancesystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findByTeacherId(Long teacherId);
}
