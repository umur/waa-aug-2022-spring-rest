package com.lab2.phase3.service.impl;

import com.lab2.phase3.dto.CourseDto;
import com.lab2.phase3.entity.Course;
import com.lab2.phase3.repository.CourseRepository;
import com.lab2.phase3.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CourseDto> findAll() {
        var data = courseRepository.findAll();
        var result = new ArrayList<CourseDto>();
        data.forEach(entity -> {
            var dto = modelMapper.map(entity, CourseDto.class);
            result.add(dto);
        });
        return result;
    }

    @Override
    public void save(CourseDto course) {
        courseRepository.save(modelMapper.map(course, Course.class));
    }

    @Override
    public boolean delete(int id) {
        return courseRepository.delete(id);
    }

    @Override
    public CourseDto findById(int id) {
        Course course = courseRepository.findById(id);
        return modelMapper.map(course, CourseDto.class);
    }

    @Override
    public void update(int id, CourseDto course) {
        courseRepository.update(id, modelMapper.map(course, Course.class));
    }
}
