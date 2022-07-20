package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService=courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> findAll(){
        return (ResponseEntity<List<Course>>) ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable int id){
        Course course = courseService.findById(id);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable int id){
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Void> addOne(@RequestBody Course course){
        courseService.addCourse(course);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
