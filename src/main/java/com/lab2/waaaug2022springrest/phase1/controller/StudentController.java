package com.lab2.waaaug2022springrest.phase1.controller;

import com.lab2.waaaug2022springrest.phase1.entity.Course;
import com.lab2.waaaug2022springrest.phase1.entity.Student;
import com.lab2.waaaug2022springrest.phase1.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody  Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        return studentService.getStudentById(studentId);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/{studentId}")
    public Student updateStudentById(@PathVariable int studentId, @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/filter-by-major")
    public List<Student> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{studentId}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable int studentId) {
        return studentService.getCoursesByStudentId(studentId);
    }
}
