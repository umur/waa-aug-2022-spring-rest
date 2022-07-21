package edu.miu.restphaseI.controller;

import edu.miu.restphaseI.entity.Course;
import edu.miu.restphaseI.entity.Student;
import edu.miu.restphaseI.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Student student) {
        studentService.save(student);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable int id) {
        var student = studentService.getById(id);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int studentId, @RequestBody Student student) {
        student.setId(studentId);
        studentService.update(student);
    }

    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }

    @GetMapping("/search")
    public List<Student> getStudentsByMajor(@RequestParam Map<String, String> params) {
        System.out.println(params);
        if(params.containsKey("major")) {
            return studentService.getStudentsByMajor(params.get("major"));
        }

        return null;
    }

}
