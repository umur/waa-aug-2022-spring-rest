package com.example.lab2waa.phase1.Service;

import com.example.lab2waa.phase1.Model.Course;
import com.example.lab2waa.phase1.Repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;
    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
