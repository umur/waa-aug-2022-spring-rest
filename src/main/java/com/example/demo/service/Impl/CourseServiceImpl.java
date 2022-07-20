package com.example.demo.service.Impl;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepo;
import com.example.demo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    @Override
    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public Course findById(int id) {
        return courseRepo.getById(id);
    }

    @Override
    public void deleteCourse(int id) {
        courseRepo.deleteCourse(id);
    }

    @Override
    public void addCourse(Course course) {
        courseRepo.save(course);
    }
}
