package controller;

import domain.Course;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public List<Student> findAllStudents(){
        return studentService.findAll();
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        studentService.create(student);
        return student;
    }
    @GetMapping("/search")
    public ResponseEntity<?> delete(@PathVariable int id){
        studentService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
    @GetMapping("{id}/course")
    public List<Course> getCourseByStudentId(@PathVariable int id){
        return studentService.findByCourses(id);
    }


}
