package com.miu.lab.service.impl;

import com.miu.lab.dto.CourseDto;

import com.miu.lab.dto.StudentDto;
import com.miu.lab.entity.Course;
import com.miu.lab.entity.Student;
import com.miu.lab.repository.CourseRepo;
import com.miu.lab.service.ICourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService implements ICourseService {
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public List<CourseDto> findAll() {

        return courseRepo.findAll()
                .stream()
                .map(s -> mapper.map(s, CourseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(CourseDto courseDto) {
        courseRepo.save(mapper.map(courseDto, Course.class));
    }

    @Override
    public void delete(int courseId) {
        courseRepo.delete(mapper.map(courseId, Course.class));
    }

    @Override
    public CourseDto update(CourseDto courseDto) {
        return mapper.map(courseRepo.update(mapper.map(courseDto, Course.class)), CourseDto.class);
    }
}
