package com.miu.demo.controller;


import com.miu.demo.dto.CourseDto;
import com.miu.demo.dto.StudentDto;
import com.miu.demo.dto.StudentV2Dto;
import com.miu.demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> findAll(){
        var students = studentService.findAll();
        return ResponseEntity.ok().body(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> findById(@PathVariable Long id){
        var student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> update(@RequestBody StudentDto student, @PathVariable Long id){
        var updateStudent = studentService.update(student, id);
        return ResponseEntity.ok(updateStudent);
    }

    @PostMapping
    public ResponseEntity<StudentDto> create(@RequestBody StudentDto student){
        student = studentService.save(student);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        studentService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/{id}/courses")
    public ResponseEntity<List<CourseDto>> findStudentCourse(@PathVariable Long id){
        var courses = studentService.getCoursesByStudentId(id);
        return ResponseEntity.ok().body(courses);
    }

    // "/search?major=compro or ?search=compro"

    @GetMapping(value = "/search")
    public ResponseEntity<List<StudentV2Dto>> findStudentByMajor(@RequestParam String major){
        var students = studentService.getStudentsByMajor(major);
        return ResponseEntity.ok().body(students);
    }

}
