package com.example.lab2waa.phase2.Service;

import com.example.lab2waa.phase2.Model.Course;
import com.example.lab2waa.phase2.Repository.CourseRepository;
import com.example.lab2waa.phase2.dto.CourseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    @Override
    public List<Course> findAll() {

        var courses = courseRepository.findAll();
        CourseDto dto = new CourseDto();
        var result = dto.toDto(courses);
        return courses;
    }
}
