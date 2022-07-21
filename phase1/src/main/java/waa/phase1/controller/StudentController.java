package waa.phase1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.phase1.entity.Course;
import waa.phase1.entity.Student;
import waa.phase1.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping()
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @PostMapping()
    public void save(@RequestBody Student dto) {
        studentService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void findById(@PathVariable int id) {
        studentService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Student dto) {
        studentService.update(id, dto);
    }

    @GetMapping("/{id}/courses")
    public List<Course> getStudentsByMajor(@PathVariable("id") int studentId) {
        return studentService.getCoursesByStudentId(studentId);
    }

    @GetMapping("/major/{major}")
    public List<Student> getStudentsByMajor(@PathVariable("major") String major) {
        return studentService.getStudentsByMajor(major);
    }
}
