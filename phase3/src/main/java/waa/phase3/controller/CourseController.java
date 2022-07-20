package waa.phase3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.phase3.dto.CourseDto;
import waa.phase3.service.CourseService;

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
    public void deleteById(@PathVariable int id) {
        courseService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody CourseDto dto) {
        courseService.update(id, dto);
    }

    @GetMapping("/{id}")
    public CourseDto findById(@PathVariable int id) {
        return courseService.findById(id);
    }

}