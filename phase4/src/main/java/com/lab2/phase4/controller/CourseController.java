package com.lab2.phase4.controller;


import com.lab2.phase4.dto.CourseDto;
import com.lab2.phase4.service.CourseService;
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
    public List<CourseDto> findAll() {
        return courseService.findAll();
    }


    @PostMapping
    public ResponseEntity<String> save(@RequestBody CourseDto course) {
        courseService.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body("New course saved");
    }

    @GetMapping("/{id}")
    public CourseDto findById(@PathVariable int id) {
        return courseService.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody CourseDto course) {
        courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return courseService.delete(id);
    }
}