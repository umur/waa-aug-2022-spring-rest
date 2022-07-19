package miu.edu.lab2.controllers;

import miu.edu.lab2.dtos.CourseDto;
import miu.edu.lab2.dtos.StudentDto;
import miu.edu.lab2.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentContrtoller {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentDto> getAllStudents(){
        return studentService.getAll();
    }

    @GetMapping("/byMajor")
    public List<StudentDto> getAllStudentsByMajor(@RequestParam String major){
        return studentService.getStudentByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDto> getAllCourseForStudent(@PathVariable String id){
        return studentService.getCoursesByStudentId(Integer.parseInt(id));
    }

    @PostMapping
    public ResponseEntity saveBook(@RequestBody StudentDto studentDto){
        studentService.save(studentDto);
        return new ResponseEntity("Student saved successfully", HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity deleteBook(@RequestBody StudentDto studentDto){
        studentService.delete(studentDto);
        return new ResponseEntity("Student deleted successfully", HttpStatus.OK);
    }
}
