package lab.waa.two.phase1.controller;

import lab.waa.two.phase1.entity.Course;
import lab.waa.two.phase1.entity.Student;
import lab.waa.two.phase1.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
  private final StudentService studentService;

  @GetMapping
  public ResponseEntity<List<Student>> getAll() {
    return ResponseEntity.ok(studentService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Student> getById(@PathVariable Long id) {
    return ResponseEntity.ok(studentService.getById(id));
  }

  @PostMapping
  public ResponseEntity<Void> save(@RequestBody Student Student) {
    studentService.save(Student);
    return new ResponseEntity<Void>(HttpStatus.CREATED);

  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Student Student) {
    studentService.update(id, Student);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    studentService.delete(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/student-by-major")
  public List<Student> getStudentByMajor(@RequestParam String major) {
    return studentService.getStudentsByMajor(major);
  }

  @GetMapping("/get-courses-by-student-id")
  public List<Course> getCoursesByStudentId(@RequestParam Long id) {
    return studentService.getCoursesByStudentId(id);
  }

}
