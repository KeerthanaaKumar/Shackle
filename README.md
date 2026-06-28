# Student Attendance and Performance System

A full-stack Java backend for managing student attendance and academic performance,
with role-based access for teachers and students.

## Stack
Java, Spring Boot, Spring Data JPA, Spring Security, MySQL

## Features
- Role-based access: teachers can create/edit records, students have read-only access to their own data
- Automatic attendance percentage calculation with a 75% threshold flag
- Automatic failing-marks detection with a 40% threshold
- Password hashing via BCrypt
- DTOs used to prevent sensitive data exposure in API responses

## Setup
1. Create a MySQL database: `CREATE DATABASE attendance_system;`
2. Update `src/main/resources/application.properties` with your DB credentials
3. Run `AttendanceSystemApplication.java`
4. Test endpoints via Postman using HTTP Basic Auth