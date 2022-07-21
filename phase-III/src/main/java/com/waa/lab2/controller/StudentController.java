package com.waa.lab2.controller;

import com.waa.lab2.dto.StudentDTO;
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
    List<StudentDTO> findAll(){
        return studentService.findAll();
    }

    @PostMapping
    void save(@RequestBody StudentDTO studentDTO){
        studentService.save(studentDTO);
    }

    @PutMapping("/{id}")
    void update(@RequestBody StudentDTO studentDTO, @PathVariable Long id){
        studentService.update(studentDTO);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id){
        studentService.deleteById(id);
    }

    @GetMapping("/{id}")
    Optional<StudentDTO> findById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @GetMapping("/getByMajor")
    List<StudentDTO> getStudentsByMajor(@RequestParam String major){
        return studentService.getByMajor(major);
    }
}
