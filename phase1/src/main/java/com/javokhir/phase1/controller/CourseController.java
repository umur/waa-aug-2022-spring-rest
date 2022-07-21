package com.javokhir.phase1.controller;

import com.javokhir.phase1.domain.Course;
import com.javokhir.phase1.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(path="/courses")
public class CourseController {

    private final CourseService service;

    @GetMapping
    public List<Course> findAll(){
        return service.getCourses();
    }

    @GetMapping("/{id}")
    public Course findById(@PathVariable("id")UUID id){
        return service.getById(id);
    }

    @PostMapping
    public Course create(@RequestBody Course course){
        return service.create(course);
    }

    @PutMapping
    public Course update(@RequestBody Course course){
        return service.update(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id){
        service.delete(id);
    }
}
