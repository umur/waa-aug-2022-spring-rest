package waa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import waa.dto.CourseDTO;
import waa.dto.StudentDTO;
import waa.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentControlller {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentDTO> findAllStudents(){
        return studentService.findAllStudents();
    }

    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO){
        return studentService.createStudent(studentDTO);
    }

    @DeleteMapping("{id}")
    public StudentDTO deleteStudent(@PathVariable int id) throws Exception {
        return studentService.removeStudentById(id);
    }

    @PutMapping
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO) throws Exception {
        return studentService.updateStudent(studentDTO);
    }

    @GetMapping("/{id}")
    public StudentDTO findStudentById(@PathVariable int id){
        return studentService.findStudentById(id);
    }

    @GetMapping("/major/{major}")
    public List<StudentDTO> getStudentsByMajor(@PathVariable String major){
        return studentService.findStudentByMajor(major);
    }

    @GetMapping("/courses/{id}")
    public List<CourseDTO> getCoursesByStudentId(@PathVariable int id){
        return studentService.findCoursesByStudentId(id);
    }
}
