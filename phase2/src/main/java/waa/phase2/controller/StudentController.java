package waa.phase2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.phase2.dto.StudentDto;
import waa.phase2.entity.Course;
import waa.phase2.entity.Student;
import waa.phase2.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping()
    public List<StudentDto> findAll() {
        return studentService.findAll();
    }

    @PostMapping()
    public void save(@RequestBody StudentDto dto) {
        studentService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void findById(@PathVariable int id) {
        studentService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody StudentDto dto) {
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
