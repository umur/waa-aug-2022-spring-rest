package david.edu.min.Lab2.controller;

import david.edu.min.Lab2.entity.Course;
import david.edu.min.Lab2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<Course> getAll() {
        ResponseEntity.status(HttpStatus.OK);
        return courseService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Course entity) {
        ResponseEntity.status(HttpStatus.CREATED);
        courseService.save(entity);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Course entity) {
        ResponseEntity.status(HttpStatus.OK);
        courseService.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        ResponseEntity.status(HttpStatus.OK);
        courseService.deleteById(id);
    }

    @GetMapping("/{id}")
    public void getById(@PathVariable int id) {
        ResponseEntity.status(HttpStatus.OK);
        courseService.getById(id);
    }
}
