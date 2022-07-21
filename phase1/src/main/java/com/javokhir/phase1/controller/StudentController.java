package com.javokhir.phase1.controller;

import com.javokhir.phase1.domain.Course;
import com.javokhir.phase1.domain.Student;
import com.javokhir.phase1.service.CourseService;
import com.javokhir.phase1.service.StudentService;
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
    public List<Student> findAll(){
        return service.getStudents();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id")UUID id){
        return service.getById(id);
    }

    @PostMapping
    public Student create(@RequestBody Student student){
        return service.create(student);
    }

    @PutMapping
    public Student update(@RequestBody Student student){
        return service.update(student);
    }

    @GetMapping("/find-by-major")
    public List<Student> findByMajor(@RequestParam(value = "major") String major){
        return service.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<Course> findStudentCourses(@PathVariable("id") UUID id){
        return courseService.getCoursesByStudentId(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id){
        service.delete(id);
    }
}
