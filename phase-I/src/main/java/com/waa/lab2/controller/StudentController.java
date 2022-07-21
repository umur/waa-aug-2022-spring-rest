package com.waa.lab2.controller;

import com.waa.lab2.entity.Student;
import com.waa.lab2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    List<Student> findAll(){
        return studentService.findAll();
    }

    @PostMapping
    void save(@RequestBody Student student){
        studentService.save(student);
    }

    @PutMapping("/{id}")
    void update(@RequestBody Student student, @PathVariable Long id){
        studentService.update(student);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id){
        studentService.deleteById(id);
    }

    @GetMapping("/{id}")
    Optional<Student> findById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @GetMapping("/getByMajor")
    List<Student> getStudentsByMajor(@RequestParam String major){
        return studentService.getByMajor(major);
    }
}
