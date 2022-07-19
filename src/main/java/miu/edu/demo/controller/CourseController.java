package miu.edu.demo.controller;

import miu.edu.demo.dto.CourseDTO;
import miu.edu.demo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public CourseDTO getById(@PathVariable int id) {
        return courseService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCourse(@RequestBody CourseDTO courseDTO) {
        courseService.save(courseDTO);
    }


}
