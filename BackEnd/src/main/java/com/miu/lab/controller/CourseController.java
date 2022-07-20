package com.miu.lab.controller;

import com.miu.lab.dto.CourseDto;
import com.miu.lab.dto.StudentDto;
import com.miu.lab.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Courses")
public class CourseController {

    ICourseService courseService;
    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDto> findAll() {
        return courseService.findAll();
    }


    @PostMapping
    public void save(@RequestBody CourseDto course) {
        courseService.save(course);
    }

    @PutMapping
    public void update(@RequestBody CourseDto course) {
        courseService.update(course);
    }

    @DeleteMapping("/{courseId}")
    public void delete(@RequestParam int courseId) {
        courseService.delete(courseId);
    }

}
