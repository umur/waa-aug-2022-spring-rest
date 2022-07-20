package lab.waa.two.phase1.controller;

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
  public ResponseEntity<List<Course>> getAll() {
    return ResponseEntity.ok(courseService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Course> getById(@PathVariable Long id) {
    return ResponseEntity.ok(courseService.getById(id));
  }

  @PostMapping
  public ResponseEntity<Void> save(@RequestBody Course course) {
    courseService.save(course);
    return new ResponseEntity<Void>(HttpStatus.CREATED);

  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Course course) {
    courseService.update(id, course);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    courseService.delete(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}
