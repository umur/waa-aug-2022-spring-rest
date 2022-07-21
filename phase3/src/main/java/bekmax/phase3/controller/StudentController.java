package bekmax.phase3.controller;

import bekmax.phase3.dto.CourseDto;
import bekmax.phase3.dto.StudentDto;
import bekmax.phase3.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> fetchAll(@RequestParam(required = false) String major) {
        if (major != null && !major.isEmpty()) {
            return studentService.getByMajor(major);
        } else {
            return studentService.fetchAll();
        }
    }

    @GetMapping("/{id}/courses")
    public List<CourseDto> getCoursesByStudentId(@PathVariable long id) {
        return studentService.getCoursesByStudentId(id);
    }

    @PostMapping
    public StudentDto save(@RequestBody StudentDto sd) {
        return studentService.save(sd);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody StudentDto sd) {
        studentService.update(id, sd);
    }

}
