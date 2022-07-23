package edu.miu.restphaseIII.service;

import edu.miu.restphaseIII.dto.CourseDto;

import java.util.List;

public interface CourseService {
    void save(CourseDto courseDto);
    void update(CourseDto courseDto);
    void delete(int id);
    CourseDto getById(int id);
    List<CourseDto> getAll();
}
