package phase1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import phase1.entity.Course;
import phase1.entity.Student;
import phase1.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> findStudents(@RequestParam(required = false) String major) {
        if (major != null && !major.isEmpty()) {
            return studentService.getByMajor(major);
        } else {
            return studentService.findAll();
        }
    }

    @GetMapping("/{studentId}/courses")
    public List<Course> getCourses(@PathVariable int studentId) {
        return studentService.getCoursesByStudentId(studentId);
    }

    @PostMapping
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable int studentId) {
        studentService.delete(studentId);
    }

    @PutMapping("/{studentId}")
    public void update(@PathVariable int studentId, @RequestBody Student student) {
        studentService.update(studentId, student);
    }
}
