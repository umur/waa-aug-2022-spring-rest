package com.waa.lab2.service;

import com.waa.lab2.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAll();
    void save(Course course);
    void update(Course course);
    void deleteById(Long id);
    Optional<Course> findById(Long id);

    List<Course> getByStudentId(Long studentId);
}
