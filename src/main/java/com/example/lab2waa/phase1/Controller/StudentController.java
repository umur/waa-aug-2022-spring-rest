package com.example.lab2waa.phase1.Controller;

import com.example.lab2waa.phase1.Model.Course;
import com.example.lab2waa.phase1.Model.Student;
import com.example.lab2waa.phase1.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}/cources")
    public List<Course> getCoursesByStudentId(@PathVariable int id){
        return studentService.getCoursesByStudentId(id);
    }

    @GetMapping("/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    }

    @PutMapping("/")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @PostMapping("/")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void addStudent(@PathVariable int id){
         studentService.deleteStudent(id);
    }
}
