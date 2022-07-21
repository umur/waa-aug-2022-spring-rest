package edu.miu.restphaseIII.controller;

import edu.miu.restphaseIII.dto.CourseDto;
import edu.miu.restphaseIII.dto.StudentDto;
import edu.miu.restphaseIII.service.StudentService;
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
    public void save(@RequestBody StudentDto studentDto) {
        studentService.save(studentDto);
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
    public void delete(@PathVariable int id) {
        studentService.delete(id);
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

    @GetMapping("/search")
    public List<StudentDto> getStudentsByMajor(@RequestParam Map<String, String> params) {
        System.out.println(params);
        if(params.containsKey("major")) {
            return studentService.getStudentsByMajor(params.get("major"));
        }

        return null;
    }

}
