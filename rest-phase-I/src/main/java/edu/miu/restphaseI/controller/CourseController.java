package edu.miu.restphaseI.controller;

import edu.miu.restphaseI.entity.Course;
import edu.miu.restphaseI.service.CourseService;
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
    public void save(@RequestBody Course course) {
        courseService.save(course);
    }

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable int id) {
        var course = courseService.getById(id);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int courseId, @RequestBody Course course) {
        course.setId(courseId);
        courseService.update(course);
    }
}
