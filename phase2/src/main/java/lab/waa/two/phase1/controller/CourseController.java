package lab.waa.two.phase1.controller;

import lab.waa.two.phase1.dto.CourseDto;
import lab.waa.two.phase1.entity.Course;
import lab.waa.two.phase1.entity.Student;
import lab.waa.two.phase1.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {
  private final CourseService courseService;

  @GetMapping
  public ResponseEntity<List<CourseDto>> getAll() {
    return ResponseEntity.ok(courseService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CourseDto> getById(@PathVariable Long id) {
    return ResponseEntity.ok(courseService.getById(id));
  }

  @PostMapping
  public ResponseEntity<Void> save(@RequestBody CourseDto courseDto) {
    courseService.save(courseDto);
    return new ResponseEntity<Void>(HttpStatus.CREATED);

  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody CourseDto courseDto) {
    courseService.update(id, courseDto);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    courseService.delete(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}
