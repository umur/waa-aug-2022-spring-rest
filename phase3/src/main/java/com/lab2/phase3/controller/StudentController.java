package com.lab2.phase3.controller;

import com.lab2.phase3.dto.CourseDto;
import com.lab2.phase3.dto.StudentDto;
import com.lab2.phase3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping()
    public List<StudentDto> findAll(@RequestParam(required = false) String major) {
        if (major != null) {
            return studentService.getStudentsByMajor(major);
        }
        return studentService.findAll();
    }


    @PostMapping
    public ResponseEntity<String> save(@RequestBody StudentDto student) {
        studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body("New student saved");
    }

    @GetMapping("/{id}")
    public StudentDto findById(@PathVariable int id) {
        return studentService.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody StudentDto student) {
        studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {
        return studentService.delete(id);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }
}
