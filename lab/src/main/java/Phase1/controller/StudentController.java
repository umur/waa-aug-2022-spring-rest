package Phase1.controller;

import Phase1.domain.Course;
import Phase1.domain.Student;
import Phase1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public Student deleteStudent(@PathVariable int id) throws Exception {
        return studentService.removeStudentById(id);
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student) throws Exception {
        return studentService.updateStudent(student);
    }

    @GetMapping("/students/{id}")
    public Student findStudentById(@PathVariable int id){
        return studentService.findStudentById(id);
    }

    @GetMapping("/students/major/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/student/courses/{id}")
    public List<Course> getCoursesByStudentId(@PathVariable int id){
        return studentService.getCoursesByStudentId(id);
    }
}
