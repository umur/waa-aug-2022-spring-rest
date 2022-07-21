package edu.miu.restphaseI.service;

import edu.miu.restphaseI.entity.Course;

import java.util.List;

public interface CourseService {
    void save(Course course);
    void delete(int id);
    Course getById(int id);
    List<Course> getAll();
}
