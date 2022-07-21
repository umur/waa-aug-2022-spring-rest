package waa.phase3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.phase3.dto.CourseDto;
import waa.phase3.dto.StudentDto;
import waa.phase3.service.StudentService;

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
    public void deleteById(@PathVariable int id) {
        studentService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody StudentDto dto) {
        studentService.update(id, dto);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDto> getStudentsByMajor(@PathVariable("id") int studentId) {
        return studentService.getCoursesByStudentId(studentId);
    }

    @GetMapping("/major/{major}")
    public List<StudentDto> getStudentsByMajor(@PathVariable("major") String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}")
    public StudentDto findById(@PathVariable("id") int id) {
        return studentService.findById(id);
    }
}
