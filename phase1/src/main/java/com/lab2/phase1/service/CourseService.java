package com.lab2.phase1.service;

import com.lab2.phase1.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    void save(Course course);
    boolean delete(int id);
    Course findById(int id);
    void update(int id,Course course);

}
