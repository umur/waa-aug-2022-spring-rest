package miu.edu.lab2.server.controller;

import miu.edu.lab2.server.dto.StudentDTO;
import miu.edu.lab2.server.entity.Course;
import miu.edu.lab2.server.entity.Student;
import miu.edu.lab2.server.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/students")
public class StudentController {
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }
    @GetMapping
    public List<Student> fetchStudents(@RequestParam(name = "major", required = false) String major){
        if(!ObjectUtils.isEmpty(major)) {
            return service.getStudentsByMajor(major);
        }
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

    @PutMapping
    public Student updateStudent(@RequestBody StudentDTO studentDTO) throws Exception {
        return service.updateStudent(studentDTO);
    }

    @GetMapping("/{studentId}")
    public Student findStudentById(@PathVariable int studentId){
        return service.findStudentById(studentId);
    }

    @GetMapping("/{studentId}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable int studentId){
        return service.getCoursesByStudentId(studentId);
    }

}
