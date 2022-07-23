package edu.miu.restphaseIV.controller;

import edu.miu.restphaseIV.dto.CourseDto;
import edu.miu.restphaseIV.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@CrossOrigin("*")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseDto> save(@RequestBody CourseDto courseDto) {
        CourseDto createdCourse = courseService.save(courseDto);
        var res = createdCourse != null ? ResponseEntity.ok(createdCourse) : new ResponseEntity(null, HttpStatus.NOT_IMPLEMENTED);
        return res;
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
    public ResponseEntity<CourseDto> delete(@PathVariable int id) {
        return ResponseEntity.ok(courseService.delete(id));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int courseId, @RequestBody CourseDto courseDto) {
        courseDto.setId(courseId);
        courseService.update(courseDto);
    }
}
