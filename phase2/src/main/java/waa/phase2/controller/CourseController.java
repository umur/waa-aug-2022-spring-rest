package waa.phase2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.phase2.dto.CourseDto;
import waa.phase2.service.CourseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping()
    public List<CourseDto> findAll() {
        return courseService.findAll();
    }

    @PostMapping()
    public void save(@RequestBody CourseDto dto) {
        courseService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void findById(@PathVariable int id) {
        courseService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody CourseDto dto) {
        courseService.update(id, dto);
    }
}