package com.lab2.phase1.controller;


import com.lab2.phase1.entity.Course;
import com.lab2.phase1.entity.Student;
import com.lab2.phase1.service.CourseService;
import com.lab2.phase1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping()
    public List<Course> findAll() {
        return courseService.findAll();
    }


    @PostMapping
    public ResponseEntity<String> save(@RequestBody Course course) {
        courseService.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body("New course saved");
    }

    @GetMapping("/{id}")
    public Course findById(@PathVariable int id) {
        return courseService.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Course course) {
        courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return courseService.delete(id);
    }
}