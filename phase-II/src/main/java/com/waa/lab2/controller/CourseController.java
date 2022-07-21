package com.waa.lab2.controller;

import com.waa.lab2.dto.CourseDTO;
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
    List<CourseDTO> findAll(){
        return courseService.findAll();
    }

    @PostMapping
    void save(@RequestBody CourseDTO courseDTO){
        courseService.save(courseDTO);
    }

    @PutMapping("/{id}")
    void update(@RequestBody CourseDTO courseDTO, @PathVariable Long id){
        courseService.update(courseDTO);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id){
        courseService.deleteById(id);
    }

    @GetMapping("/{id}")
    Optional<CourseDTO> findById(@PathVariable Long id){
        return courseService.findById(id);
    }

    @GetMapping("/getByStudentId")
    List<CourseDTO> getCoursesByStudentId(@RequestParam Long studentId){
        return courseService.getByStudentId(studentId);
    }
}
