package miu.edu.lab2.services.impl;

import miu.edu.lab2.dtos.CourseDto;
import miu.edu.lab2.dtos.StudentDto;
import miu.edu.lab2.models.Course;
import miu.edu.lab2.repositories.CourseRepo;
import miu.edu.lab2.services.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CourseDto> getAll() {
        var courseList = courseRepo.getAll();
        return  courseList.stream().map(course -> modelMapper.map(course, CourseDto.class)).collect(Collectors.toList());
    }

    @Override
    public void save(CourseDto courseDto) {
        var course = modelMapper.map(courseDto, Course.class);
        courseRepo.save(course);
    }

    @Override
    public void delete(CourseDto courseDto) {
        var course = modelMapper.map(courseDto, Course.class);
        courseRepo.delete(course);
    }

}
