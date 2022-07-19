package com.waa.lab2.controller;

import com.waa.lab2.entity.Course;
import com.waa.lab2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    List<Course> findAll(){
        return courseService.findAll();
    }

    @PostMapping
    void save(@RequestBody Course course){
        courseService.save(course);
    }

    @PutMapping("/{id}")
    void update(@RequestBody Course course, @PathVariable Long id){
        courseService.update(course);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id){
        courseService.deleteById(id);
    }

    @GetMapping("/{id}")
    Optional<Course> findById(@PathVariable Long id){
        return courseService.findById(id);
    }
}
