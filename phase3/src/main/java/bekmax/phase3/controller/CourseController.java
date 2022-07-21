package bekmax.phase3.controller;

import bekmax.phase3.dto.CourseDto;
import bekmax.phase3.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
@CrossOrigin(origins = "*")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<CourseDto> fetchAll() {
        return courseService.fetchAll();
    }

    @PostMapping
    public CourseDto save(@RequestBody CourseDto cd) {
        return courseService.save(cd);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody CourseDto cd) {
        courseService.update(id, cd);
    }
}
