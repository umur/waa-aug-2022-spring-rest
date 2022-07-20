package phase1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import phase1.entity.Course;
import phase1.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @PostMapping
    public Course save(@RequestBody Course course) {
        return courseService.save(course);
    }

    @DeleteMapping("/{courseId}")
    public void delete(@PathVariable int courseId) {
        courseService.delete(courseId);
    }

    @PutMapping("/{courseId}")
    public void update(@PathVariable int courseId, @RequestBody Course course) {
        courseService.update(courseId, course);
    }
}
