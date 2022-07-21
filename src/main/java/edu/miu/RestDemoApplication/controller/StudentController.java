package edu.miu.RestDemoApplication.controller;

import edu.miu.RestDemoApplication.dto.CourseDTO;
import edu.miu.RestDemoApplication.dto.StudentDTO;
import edu.miu.RestDemoApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentDTO> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public StudentDTO findByID(@PathVariable long id) {
        return studentService.findByID(id);
    }

    @PostMapping
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.addStudent(studentDTO);
    }

    @PutMapping
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.updateStudent(studentDTO);
    }

    @GetMapping("/{major}")
    public List<StudentDTO> getStudentsByMajor(@PathVariable String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDTO> getCoursesByStudentID(@PathVariable long id) {
        return studentService.getCoursesByStudentID(id);
    }

    @DeleteMapping("/{id}")
    public void removeStudentByID(@PathVariable long id) {
        studentService.removeStudentByID(id);
    }

}
