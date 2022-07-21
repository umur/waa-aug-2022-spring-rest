package bekmax.phase2.controller;

import bekmax.phase2.dto.CourseDto;
import bekmax.phase2.service.CourseService;
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
    public List<CourseDto> fetchAll() {
        return courseService.fetchAll();
    }

    @PostMapping
    public CourseDto save(@RequestBody CourseDto courseDto) {
        return courseService.save(courseDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody CourseDto courseDto) {
        courseService.update(id, courseDto);
    }
}
