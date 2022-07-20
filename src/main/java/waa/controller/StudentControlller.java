package waa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import waa.domain.Course;
import waa.domain.Student;
import waa.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentControlller {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @DeleteMapping("{id}")
    public Student deleteStudent(@PathVariable int id) throws Exception {
        return studentService.removeStudentById(id);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) throws Exception {
        return studentService.updateStudent(student);
    }

    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable int id){
        return studentService.findStudentById(id);
    }

    @GetMapping("/major/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major){
        return studentService.findStudentByMajor(major);
    }

    @GetMapping("/courses/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable int id){
        return studentService.findCoursesByStudentId(id);
    }
}
