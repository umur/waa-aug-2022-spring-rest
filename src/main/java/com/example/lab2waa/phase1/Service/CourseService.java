package com.example.lab2waa.phase1.Service;


import com.example.lab2waa.phase1.Model.Course;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService {
    List<Course> findAll();
}
