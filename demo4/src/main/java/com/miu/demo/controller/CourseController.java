package com.miu.demo.controller;


import com.miu.demo.domain.Course;
import com.miu.demo.dto.CourseDto;
import com.miu.demo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/courses")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourse(){
        var courses = courseService.findAll();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> findById(@PathVariable Long id){
        var course = courseService.findById(id);
        return ResponseEntity.ok(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> update(@RequestBody CourseDto courseDto, @PathVariable Long id){
        var updatedCourse = courseService.update(courseDto, id);
        return ResponseEntity.ok(updatedCourse);
    }

    @PostMapping
    public ResponseEntity<CourseDto> create(@RequestBody CourseDto courseDto){
        courseDto = courseService.save(courseDto);
        return ResponseEntity.ok(courseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        courseService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
