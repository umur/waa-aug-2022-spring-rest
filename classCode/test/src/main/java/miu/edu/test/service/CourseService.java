package miu.edu.test.service;

import miu.edu.test.dto.CourseDto;
import miu.edu.test.dto.StudentCreateDto;
import miu.edu.test.dto.StudentDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> getAll();
    CourseDto getById(int id);
    CourseDto create(CourseDto course);

    CourseDto delete(int id);

    CourseDto update(int id, CourseDto course);
}
