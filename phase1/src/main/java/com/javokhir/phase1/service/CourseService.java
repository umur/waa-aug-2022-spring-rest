package com.javokhir.phase1.service;

import com.javokhir.phase1.domain.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface CourseService {

    List<Course> getCourses();

    Course getById(UUID id);

    Course create(Course course);

    Course update(Course course);

    void delete(UUID id);

    List<Course> getCoursesByStudentId(UUID id);
}
