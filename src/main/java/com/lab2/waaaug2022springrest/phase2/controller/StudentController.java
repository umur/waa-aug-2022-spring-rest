package com.lab2.waaaug2022springrest.phase2.controller;

import com.lab2.waaaug2022springrest.phase2.entity.Course;
import com.lab2.waaaug2022springrest.phase2.entity.Student;
import com.lab2.waaaug2022springrest.phase2.service.StudentService;
import com.lab2.waaaug2022springrest.phase2.dto.StudentDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        return studentService.getStudentById(studentId);
    }

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/{studentId}")
    public Student updateStudentById(@PathVariable int studentId, @RequestBody StudentDto studentDto) {
        return studentService.updateStudent(studentId, studentDto);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/filter-by-major")
    public List<StudentDto> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{studentId}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable int studentId) {
        return studentService.getCoursesByStudentId(studentId);
    }
}
