package com.example.attendancesystem.repository;

import com.example.attendancesystem.entity.Student;
import com.example.attendancesystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByUserId(Long userId);
    List<Student> findByClassEntityId(Long classId);
}