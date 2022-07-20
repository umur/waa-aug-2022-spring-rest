package cs545waa.lab2.controller;

import cs545waa.lab2.dto.CourseDto;
import cs545waa.lab2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseDto> findAll() {
        return courseService.findAll();
    }

    @PostMapping
    public CourseDto save(@RequestBody CourseDto courseDto) {
        return courseService.save(courseDto);
    }
}
