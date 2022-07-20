package cs545waa.lab2.service;

import cs545waa.lab2.dto.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> findAll();
    CourseDto save(CourseDto c);

}
