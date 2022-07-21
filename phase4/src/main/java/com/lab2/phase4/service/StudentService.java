package com.lab2.phase4.service;

import com.lab2.phase4.dto.CourseDto;
import com.lab2.phase4.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAll();

    void save(StudentDto student);

    boolean delete(int id);

    StudentDto findById(int id);

    void update(int id,StudentDto student);

    List<StudentDto> getStudentsByMajor(String major);

    List<CourseDto> getCoursesByStudentId(int studentId);
}
