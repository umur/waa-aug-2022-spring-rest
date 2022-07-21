package bekmax.phase1.controller;

import bekmax.phase1.model.Course;
import bekmax.phase1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> fetchAll() {
        return courseService.fetchAll();
    }

    @PostMapping
    public Course save(@RequestBody Course course) {
        return courseService.save(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Course course) {
        courseService.update(id, course);
    }
}
