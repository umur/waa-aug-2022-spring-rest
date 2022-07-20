package cs545waa.lab2.service.impl;

import cs545waa.lab2.dto.CourseDto;
import cs545waa.lab2.entity.Course;
import cs545waa.lab2.repository.CourseRepo;
import cs545waa.lab2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    public List<CourseDto> findAll() {
        var data = courseRepo.getCourses();
        List<CourseDto> result = new ArrayList<>();
        data.forEach(e -> {
            var dto = modelMapper.map(e, CourseDto.class);
            result.add(dto);
        });
        return result;
    }

    public CourseDto save(CourseDto c) {
        var newCourse = modelMapper.map(c, Course.class);
        var savedCourse = courseRepo.save(newCourse);
        return modelMapper.map(savedCourse, CourseDto.class);
    }
}
