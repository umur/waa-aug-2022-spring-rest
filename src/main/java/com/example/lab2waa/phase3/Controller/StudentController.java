package com.example.lab2waa.phase3.Controller;

import com.example.lab2waa.phase3.Model.Course;
import com.example.lab2waa.phase3.Model.Student;
import com.example.lab2waa.phase3.Service.StudentService;
import com.example.lab2waa.phase3.dto.StudentDto;
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
    public List<StudentDto> getStudentsByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    }

    @PutMapping("/")
    public Student updateStudent(@RequestBody StudentDto studentDto){
        return studentService.updateStudent(studentDto);
    }

    @PostMapping("/")
    public Student addStudent(@RequestBody StudentDto studentDto){
        return studentService.addStudent(studentDto);
    }

    @DeleteMapping("/{id}")
    public void addStudent(@PathVariable int id){
         studentService.deleteStudent(id);
    }
}
