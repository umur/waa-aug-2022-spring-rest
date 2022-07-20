package miu.edu.lab2.controller;

import miu.edu.lab2.dto.StudentDTO;
import miu.edu.lab2.entity.Course;
import miu.edu.lab2.entity.Student;
import miu.edu.lab2.service.StudentService;
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
    public Student createStudent(@RequestBody StudentDTO studentDTO) {
        return service.createStudent(studentDTO);
    }

    @DeleteMapping("/{studentId}")
    public Student deleteStudent(@PathVariable int studentId) throws Exception {
        return service.deleteStudentById(studentId);
    }

    @PutMapping("/")
    public Student updateStudent(@RequestBody StudentDTO studentDTO) throws Exception {
        return service.updateStudent(studentDTO);
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
