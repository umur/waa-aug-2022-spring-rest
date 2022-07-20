package miu.edu.lab2.phase1.controller;

import miu.edu.lab2.phase1.entity.Course;
import miu.edu.lab2.phase1.entity.Student;
import miu.edu.lab2.phase1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
public class StudentController {
    private StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> findAllStudents() {
        return service.findAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public Student deleteStudent(@PathVariable int studentId) throws Exception {
        return service.deleteStudentById(studentId);
    }

    @PutMapping("/")
    public Student updateStudent(@RequestBody Student student) throws Exception {
        return service.updateStudent(student);
    }


    @GetMapping("/{studentId}")
    public Student findStudentById(@PathVariable int studentId){
        return service.findStudentById(studentId);
    }

    @GetMapping("/")
    public List<Student> getStudentsByMajor(@RequestParam String major){
        return service.getStudentsByMajor(major);
    }

    @GetMapping("/{studentId}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable int studentId){
        return service.getCoursesByStudentId(studentId);
    }

}
