package com.miu.demo.Service.Impl;

import com.miu.demo.Domain.Course;
import com.miu.demo.Repository.CourseRepo;
import com.miu.demo.Service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepository;

    public CourseServiceImpl(CourseRepo courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course save(Course course) {
        course = courseRepository.save(course);
        return course;
    }

    @Override
    public Course update(Course course, Long id) {
        course = courseRepository.update(course, id);
        return course;
    }

    @Override
    public void remove(Long id) {
        courseRepository.delete(id);
    }
}