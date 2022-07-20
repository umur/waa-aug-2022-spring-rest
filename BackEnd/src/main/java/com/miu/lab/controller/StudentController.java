package com.miu.lab.controller;

import com.miu.lab.dto.CourseDto;
import com.miu.lab.dto.StudentDto;
import com.miu.lab.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(originPatterns = "*", maxAge = 3600)
@RestController
@RequestMapping("/Students")
public class StudentController {
    @Autowired
    IStudentService studentService;

    @GetMapping
    public List<StudentDto> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{studentId}")
    public StudentDto getById(@PathVariable int studentId) {
        return studentService.getById(studentId);
    }

    @PostMapping
    public void save(@RequestBody StudentDto student) {
        studentService.save(student);
    }

    @PutMapping
    public void update(@RequestBody StudentDto student) {
        studentService.update(student);
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable int studentId) {
        studentService.delete(studentId);
    }

    @GetMapping("/get-students-by-major/{major}")
    public StudentDto getStudentsByMajor(@RequestParam String major){
        return studentService.getStudentsByMajor(major);
    }


    @GetMapping("{studentId}/get-Courses-by-studentId/")
    public List<CourseDto> getCoursesByStudentId(@PathVariable int studentId){
        return studentService.getCoursesByStudentId(studentId);
    }



}
