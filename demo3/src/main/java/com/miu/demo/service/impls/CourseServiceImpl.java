package com.miu.demo.service.impls;

import com.miu.demo.domain.Course;
import com.miu.demo.dto.CourseDto;
import com.miu.demo.dto.StudentDto;
import com.miu.demo.repo.CourseRepository;
import com.miu.demo.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;
    public CourseServiceImpl(CourseRepository courseRepository,ModelMapper modelMapper){
        this.courseRepository = courseRepository;
        this.modelMapper= modelMapper;
    }

    @Override
    public List<CourseDto> findAll() {
        var courses = courseRepository.findAll();
        var result= new ArrayList<CourseDto>();


        courses.forEach(course ->{
            var dto= modelMapper.map(course,CourseDto.class);

            result.add(dto);
        });
        return result;
    }

    @Override
    public CourseDto findById(Long id) {
        var course =  courseRepository.findById(id);

        var dto= modelMapper.map(course,CourseDto.class);
        return dto;

    }

    @Override
    public CourseDto save(CourseDto courseDto) {

        var course = courseRepository.save(new Course(courseRepository.getCounter(), courseDto.getName(),courseDto.getCode()));
        return new CourseDto(courseDto.getId(), courseDto.getCode(), course.getName());
    }

    @Override
    public CourseDto update(CourseDto courseDto, Long id) {
        var course = courseRepository.update(new Course(courseDto.getId(), courseDto.getName(),courseDto.getCode()),id);
        return new CourseDto(courseDto.getId(), courseDto.getCode(), course.getName());
    }

    @Override
    public void remove(Long id) {
        courseRepository.delete(id);
    }
}