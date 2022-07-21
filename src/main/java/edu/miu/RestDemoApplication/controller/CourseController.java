package edu.miu.RestDemoApplication.controller;

import edu.miu.RestDemoApplication.dto.CourseDTO;
import edu.miu.RestDemoApplication.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseDTO> findAll() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public CourseDTO findByID(@PathVariable long id) {
        return courseService.findByID(id);
    }

    @PostMapping
    public void addCourse(@RequestBody CourseDTO courseDTO) {
        courseService.addCourse(courseDTO);
    }
}
