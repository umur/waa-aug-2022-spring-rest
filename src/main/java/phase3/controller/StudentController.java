package phase3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import phase3.dto.CourseDto;
import phase3.dto.StudentDto;
import phase3.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentDto> findStudents(@RequestParam(required = false) String major) {
        if (major != null && !major.isEmpty()) {
            return studentService.getByMajor(major);
        } else {
            return studentService.findAll();
        }
    }

    @GetMapping("/{studentId}/courses")
    public List<CourseDto> getCourses(@PathVariable int studentId) {
        return studentService.getCoursesByStudentId(studentId);
    }

    @PostMapping
    public StudentDto save(@RequestBody StudentDto studentDto) {
        return studentService.save(studentDto);
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable int studentId) {
        studentService.delete(studentId);
    }

    @PutMapping("/{studentId}")
    public void update(@PathVariable int studentId, @RequestBody StudentDto studentDto) {
        studentService.update(studentId, studentDto);
    }
}
