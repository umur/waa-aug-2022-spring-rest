package com.javokhir.phase2.controller;

import com.javokhir.phase2.dto.CourseDto;
import com.javokhir.phase2.dto.StudentDto;
import com.javokhir.phase2.service.CourseService;
import com.javokhir.phase2.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/students")
public class StudentController {

    private final StudentService service;
    private final CourseService courseService;

    @GetMapping
    public List<StudentDto> findAll(){
        return service.getStudents();
    }

    @GetMapping("/{id}")
    public StudentDto findById(@PathVariable("id")UUID id){
        return service.getById(id);
    }

    @PostMapping
    public StudentDto create(@RequestBody StudentDto student){
        return service.create(student);
    }

    @PutMapping
    public StudentDto update(@RequestBody StudentDto student){
        return service.update(student);
    }

    @GetMapping("/find-by-major")
    public List<StudentDto> findByMajor(@RequestParam(value = "major") String major){
        return service.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDto> findStudentCourses(@PathVariable("id") UUID id){
        return courseService.getCoursesByStudentId(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id){
        service.delete(id);
    }
}
