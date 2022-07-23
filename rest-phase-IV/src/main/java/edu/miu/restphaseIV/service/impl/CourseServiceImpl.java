package edu.miu.restphaseIV.service.impl;

import edu.miu.restphaseIV.dto.CourseDto;
import edu.miu.restphaseIV.dto.StudentDto;
import edu.miu.restphaseIV.entity.Course;
import edu.miu.restphaseIV.entity.Student;
import edu.miu.restphaseIV.repository.CourseRepo;
import edu.miu.restphaseIV.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    @Override
    public CourseDto save(CourseDto courseDto) {
        Course createdCourse = courseRepo.save(modelMapper.map(courseDto, Course.class));
        return createdCourse != null ? modelMapper.map(createdCourse, CourseDto.class) : null;
    }

    @Override
    public void update(CourseDto courseDto) {
        courseRepo.update(modelMapper.map(courseDto, Course.class));
    }

    @Override
    public CourseDto delete(int id) {
        Course deletedCourse = courseRepo.delete(id);
        return (deletedCourse != null) ? modelMapper.map(deletedCourse, CourseDto.class) : null;
    }

    @Override
    public CourseDto getById(int id) {
        var course = courseRepo.getById(id);
        return (course != null) ? modelMapper.map(course, CourseDto.class) : null;
    }

    @Override
    public List<CourseDto> getAll() {
        var courses = courseRepo.getAll();
        return courses.stream().map(c -> modelMapper.map(c, CourseDto.class)).collect(Collectors.toList());
    }
}
