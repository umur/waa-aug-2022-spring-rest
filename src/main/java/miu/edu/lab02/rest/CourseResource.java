package miu.edu.lab02.rest;

import lombok.RequiredArgsConstructor;
import miu.edu.lab02.dto.CourseDTO;
import miu.edu.lab02.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/courses")
public class CourseResource {

    private final CourseService courseService;

    @GetMapping
    public List<CourseDTO> getCourses() {
        return courseService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO save(@RequestBody CourseDTO body) {
        return courseService.save(body);
    }

    @PutMapping("{id}")
    public CourseDTO update(@PathVariable Integer id, @RequestBody CourseDTO body) {
        return courseService.update(id, body);
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseDTO> getCourse(@PathVariable Integer id) {
        return courseService.findOne(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        courseService.delete(id);
    }
}
