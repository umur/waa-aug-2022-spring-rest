package com.lab2.phase2.service.impl;

import com.lab2.phase2.dto.CourseDto;
import com.lab2.phase2.entity.Course;
import com.lab2.phase2.repository.CourseRepository;
import com.lab2.phase2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public List<CourseDto> findAll() {
        var data = courseRepository.findAll();
        var result = new ArrayList<CourseDto>();
        data.forEach(entity -> {
            var dto = new CourseDto(entity.getId(), entity.getCode(), entity.getName());
            result.add(dto);
        });
        return result;
    }

    @Override
    public void save(CourseDto course) {
        courseRepository.save(course.toEntity());
    }

    @Override
    public boolean delete(int id) {
        return courseRepository.delete(id);
    }

    @Override
    public CourseDto findById(int id) {
        Course course = courseRepository.findById(id);
        return new CourseDto(course.getId(), course.getCode(), course.getName());
    }

    @Override
    public void update(int id, CourseDto course) {
        courseRepository.update(id, course.toEntity());
    }
}
