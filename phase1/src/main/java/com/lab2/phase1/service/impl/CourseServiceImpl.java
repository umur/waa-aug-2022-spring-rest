package com.lab2.phase1.service.impl;

import com.lab2.phase1.entity.Course;
import com.lab2.phase1.repository.CourseRepository;
import com.lab2.phase1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public boolean delete(int id) {
        return courseRepository.delete(id);
    }

    @Override
    public Course findById(int id) {
        return courseRepository.findById(id);
    }

    @Override
    public void update(int id, Course course) {
        courseRepository.update(id, course);
    }
}
