package com.example.attendancesystem.repository;

import com.example.attendancesystem.entity.ClassEntity;
import com.example.attendancesystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {}

