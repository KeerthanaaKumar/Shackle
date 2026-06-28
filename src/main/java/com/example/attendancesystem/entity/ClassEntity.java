package com.example.attendancesystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "classes")
@Data
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String section;

    @JsonIgnore
    @OneToMany(mappedBy = "classEntity")
    private List<Student> students;

    @JsonIgnore
    @OneToMany(mappedBy = "classEntity")
    private List<Subject> subjects;
}