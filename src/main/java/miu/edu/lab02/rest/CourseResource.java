package miu.edu.lab02.rest;

import lombok.RequiredArgsConstructor;
import miu.edu.lab02.model.Course;
import miu.edu.lab02.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/courses")
public class CourseResource {

    private final CourseService courseService;

    @GetMapping
    public List<Course> getCourses() {
        return courseService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course save(@RequestBody Course body) {
        return courseService.save(body);
    }

    @PutMapping("{id}")
    public Course update(@PathVariable Integer id, @RequestBody Course body) {
        return courseService.update(id, body);
    }

    @GetMapping("{id}")
    public Course getCourse(@PathVariable Integer id) {
        return courseService.findOne(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        courseService.delete(id);
    }
}
