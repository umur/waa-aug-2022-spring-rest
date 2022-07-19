package miu.edu.demo.service.impl;

import miu.edu.demo.dto.CourseDTO;
import miu.edu.demo.entity.Course;
import miu.edu.demo.repository.CourseRepo;
import miu.edu.demo.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    public CourseServiceImpl(CourseRepo courseRepo, ModelMapper modelMapper) {
        this.courseRepo = courseRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepo.findAll()
                .stream()
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO findById(int courseId) {
        return courseRepo.findById(courseId)
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .orElseThrow(() -> new NoSuchElementException("No such course with id: " + courseId));
    }

    @Override
    public void save(CourseDTO courseDTO) {
        courseRepo.save(modelMapper.map(courseDTO, Course.class));
    }
}
