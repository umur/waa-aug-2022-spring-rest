package waa.phase1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.phase1.entity.Course;
import waa.phase1.service.CourseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping()
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @PostMapping()
    public void save(@RequestBody Course course) {
        courseService.save(course);
    }

    @DeleteMapping("/{id}")
    public void findById(@PathVariable int id) {
        courseService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Course course) {
        courseService.update(id, course);
    }
}