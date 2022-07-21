package miu.edu.lab2.services;

import miu.edu.lab2.dtos.CourseDto;

import java.util.List;

public interface CourseService {

    public List<CourseDto> getAll();
    public void save(CourseDto courseDto);

    public void delete(CourseDto courseDto);

}
