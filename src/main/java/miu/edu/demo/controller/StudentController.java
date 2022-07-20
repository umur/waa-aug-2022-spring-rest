package miu.edu.demo.controller;

import miu.edu.demo.dto.CourseDTO;
import miu.edu.demo.dto.StudentDTO;
import miu.edu.demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public StudentDTO getById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDTO> getStudentCourses(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addStudent(@RequestBody StudentDTO studentDTO) {
        studentService.addStudent(studentDTO);
    }

    @PatchMapping("/{studentId}/courses/{courseId}")
    public StudentDTO addCourseToStudent(@PathVariable int studentId, @PathVariable int courseId){
        return studentService.addCourseToStudent(studentId, courseId);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody StudentDTO studentDTO) {
        studentService.updateStudent(id, studentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }
}
