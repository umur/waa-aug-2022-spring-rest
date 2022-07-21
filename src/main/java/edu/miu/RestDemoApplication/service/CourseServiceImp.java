package edu.miu.RestDemoApplication.service;

import edu.miu.RestDemoApplication.dto.CourseDTO;
import edu.miu.RestDemoApplication.entity.Course;
import edu.miu.RestDemoApplication.repository.CourseRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImp implements CourseService {

    @Autowired
    private final CourseRepo courseRepo;
    @Autowired
    private final ModelMapper modelMapper;


    @Override
    public List<CourseDTO> findAll() {
        var courses = courseRepo.findAll();
        var result = new ArrayList<CourseDTO>();
        courses.forEach(course -> {
            var dto = modelMapper.map(course, CourseDTO.class);
            result.add(dto);
        });
        return result;
    }

    @Override
    public CourseDTO findByID(long id) {
        var course = courseRepo.findByID(id);
        return modelMapper.map(course, CourseDTO.class);
    }

    @Override
    public void addCourse(CourseDTO courseDTO) {
        var course = modelMapper.map(courseDTO, Course.class);
        courseRepo.addCourse(course);
    }
}
