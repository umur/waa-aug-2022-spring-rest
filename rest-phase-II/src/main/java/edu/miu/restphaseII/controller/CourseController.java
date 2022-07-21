package edu.miu.restphaseII.controller;

import edu.miu.restphaseII.dto.CourseDto;
import edu.miu.restphaseII.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public void save(@RequestBody CourseDto courseDto) {
        courseService.save(courseDto);
    }

    @GetMapping
    public List<CourseDto> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getById(@PathVariable int id) {
        var course = courseService.getById(id);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int courseId, @RequestBody CourseDto courseDto) {
        courseDto.setId(courseId);
        courseService.update(courseDto);
    }
}
