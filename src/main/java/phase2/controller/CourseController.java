package phase2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import phase2.dto.CourseDto;
import phase2.entity.Course;
import phase2.service.CourseService;

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

    @DeleteMapping("/{courseId}")
    public void delete(@PathVariable int courseId) {
        courseService.delete(courseId);
    }

    @PutMapping("/{courseId}")
    public void update(@PathVariable int courseId, @RequestBody CourseDto courseDto) {
        courseService.update(courseId, courseDto);
    }
}
