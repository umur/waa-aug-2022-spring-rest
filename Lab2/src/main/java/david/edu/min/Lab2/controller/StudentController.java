package david.edu.min.Lab2.controller;

import david.edu.min.Lab2.entity.Course;
import david.edu.min.Lab2.entity.Student;
import david.edu.min.Lab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        ResponseEntity.status(HttpStatus.OK);
        return studentService.getAll();
    }


    @PostMapping
    public void save(@RequestBody Student entity) {
        ResponseEntity.status(HttpStatus.CREATED);
        studentService.save(entity);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Student entity) {
        ResponseEntity.status(HttpStatus.OK);
        studentService.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        ResponseEntity.status(HttpStatus.OK);
        studentService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        ResponseEntity.status(HttpStatus.OK);
        return studentService.getById(id);
    }

    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable int id) {
        ResponseEntity.status(HttpStatus.OK);
        return studentService.getCoursesByStudentId(id);
    }

    @GetMapping("/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    }

}
