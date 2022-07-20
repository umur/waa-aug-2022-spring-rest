package com.example.demo.service;

import com.example.demo.entity.Course;

import java.util.List;

public interface CourseService {
    public List<Course> findAll();
    public Course findById(int id);
    public void deleteCourse(int id);
    public void addCourse(Course course);
}
