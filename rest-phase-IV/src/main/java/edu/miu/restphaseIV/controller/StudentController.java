package edu.miu.restphaseIV.controller;

import edu.miu.restphaseIV.dto.CourseDto;
import edu.miu.restphaseIV.dto.StudentDto;
import edu.miu.restphaseIV.service.StudentService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/students")
@CrossOrigin("*")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StudentDto> save(@RequestBody StudentDto studentDto) {
        var student = studentService.save(studentDto);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public List<StudentDto> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable int id) {
        var student = studentService.getById(id);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentDto> delete(@PathVariable int id) {
        return ResponseEntity.ok(studentService.delete(id));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int studentId, @RequestBody StudentDto studentDto) {
        studentDto.setId(studentId);
        studentService.update(studentDto);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }
    @PostMapping("/{id}/courses/{courseId}")
    public List<CourseDto> addCourseToStudent(@PathVariable("id") int id, @PathVariable("courseId") int courseId) {
        return studentService.addCourseToStudent(id, courseId);
    }
    @DeleteMapping("/{id}/courses/{courseId}")
    public List<CourseDto> deleteCourseFromStudent(@PathVariable("id") int id, @PathVariable("courseId") int courseId) {
        return studentService.deleteCourseFromStudent(id, courseId);
    }

    @GetMapping("/search")
    public List<StudentDto> getStudentsByMajor(@RequestParam Map<String, String> params) {
        if(params.containsKey("major")) {
            return studentService.getStudentsByMajor(params.get("major"));
        }

        return null;
    }
}
