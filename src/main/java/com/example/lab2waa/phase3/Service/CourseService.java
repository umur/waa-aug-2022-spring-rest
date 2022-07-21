package com.example.lab2waa.phase3.Service;


import com.example.lab2waa.phase3.Model.Course;
import com.example.lab2waa.phase3.dto.CourseDto;

import java.util.List;


public interface CourseService {
    List<CourseDto> findAll();
}
