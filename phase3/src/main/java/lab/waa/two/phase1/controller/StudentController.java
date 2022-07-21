package lab.waa.two.phase1.controller;

import lab.waa.two.phase1.dto.CourseDto;
import lab.waa.two.phase1.dto.StudentDto;
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
  public ResponseEntity<List<StudentDto>> getAll() {
    return ResponseEntity.ok(studentService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<StudentDto> getById(@PathVariable Long id) {
    return ResponseEntity.ok(studentService.getById(id));
  }

  @PostMapping
  public ResponseEntity<Void> save(@RequestBody StudentDto studentDto) {
    studentService.save(studentDto);
    return new ResponseEntity<Void>(HttpStatus.CREATED);

  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody StudentDto studentDto) {
    studentService.update(id, studentDto);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    studentService.delete(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/filter-by-major")
  public List<StudentDto> getStudentByMajor(@RequestParam String major) {
    return studentService.getStudentsByMajor(major);
  }

  @GetMapping("/{id}/courses")
  public List<CourseDto> getCoursesByStudentId(@PathVariable Long id) {
    return studentService.getCoursesByStudentId(id);
  }

}
