package com.javokhir.phase3.controller;

import com.javokhir.phase3.dto.CourseDto;
import com.javokhir.phase3.service.CourseService;
import lombok.AllArgsConstructor;
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
@RequestMapping(path = "/courses")
public class CourseController {

    private final CourseService service;

    @GetMapping
    public List<CourseDto> findAll() {
        return service.getCourses();
    }

    @GetMapping("/{id}")
    public CourseDto findById(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public CourseDto create(@RequestBody CourseDto course) {
        return service.create(course);
    }

    @PutMapping
    public CourseDto update(@RequestBody CourseDto course) {
        return service.update(course);
    }
}
