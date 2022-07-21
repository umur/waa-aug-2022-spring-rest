package com.example.lab2waa.phase3.Service;

import com.example.lab2waa.phase3.Model.Course;
import com.example.lab2waa.phase3.Model.Student;
import com.example.lab2waa.phase3.Repository.CourseRepository;
import com.example.lab2waa.phase3.dto.CourseDto;
import com.example.lab2waa.phase3.dto.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CourseDto> findAll() {

        var courses = courseRepository.findAll();
        var result =  new ArrayList<CourseDto>();
        for(Course course: courses){
            var courseDto =  toDto(course);
            result.add(courseDto);
        }
        return result;
    }


    //MAPPER method
    private CourseDto toDto(Course course){
        CourseDto courseDto = mapper.map(course, CourseDto.class);
        return courseDto;
    }
}
